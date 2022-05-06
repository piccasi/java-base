package declarative;

import declarative.beans.LogCollect;
import declarative.beans.OpenApiScheme;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class DeclarativeApi {

    private Map<String, OpenApiScheme> apiRoute = null;

    //private static Yaml yaml = new Yaml();

    public static void main(String[] args) {
        //Yaml yaml = new Yaml();
        Yaml yaml = new Yaml(new Constructor(OpenApiScheme.class));
        InputStream inputStream = DeclarativeApi.class
                .getClassLoader()
                .getResourceAsStream("OpenApi.yaml");
        //Map<String, Object> obj = yaml.load(inputStream);
        //System.out.println(obj);

        OpenApiScheme openApiScheme = yaml.load(inputStream);
        System.out.println(openApiScheme);

        String request = openApiScheme.getRequest();
        System.out.println(request);

        Class clazz1 = null;
        Object o = null;
        Method[] methods = null;
        try {
            clazz1 = Class.forName(request);
            o = clazz1.newInstance();
            methods = clazz1.getDeclaredMethods();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println("object: " + o);

        for(Method m : methods){
            System.out.println("method: " + m);
            if(m.getName().equals("setName")) {
                try {
                    m.invoke(o, "patternzhou");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("after set object: " + o);


        ServiceLoader<OpenApi> serviceLoader = ServiceLoader.load(OpenApi.class);

        Iterator<OpenApi> iterator = serviceLoader.iterator();

        OpenApi openApi = null;


        Map<String, OpenApi> apiMap = new HashMap<>();

        while(iterator.hasNext()) {

            //加载并初始化实现类

            openApi = iterator.next();

            apiMap.put(openApi.toString(), openApi);

        }

        for (Map.Entry<String, OpenApi> item : apiMap.entrySet()) {
            String response = item.getValue().call(request);

            System.out.println(response);
        }


        //LogCollect logCollect = yaml.loadAs(inputStream, LogCollect.class);
        //LogCollect logCollect = yaml.load(inputStream);
        //System.out.println(logCollect);
    }

}
