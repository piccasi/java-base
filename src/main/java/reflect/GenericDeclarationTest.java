package reflect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.TypeVariable;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: GenericDeclarationTest
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/16 14:14
 * @Author: zhouguanbao@sensetime.com
 * @Description: TODO
 **/
public class GenericDeclarationTest{

    public GenericDeclarationTest(String[] args){

    }

    public GenericDeclarationTest(){

    }

    static class Person<T>  implements Serializable, Cloneable {
        @Deprecated
        private String name;
        private String id;
        private Date birthDay;

        private int getAge(){
            Date now = new Date();
            Calendar calendar = Calendar.getInstance();
            long diff = birthDay.getTime() - now.getTime();
            return 3;
        }
    }

    static class Police<T> extends Person<T> {

    }

    public static void main(String[] args) {
        TypeVariable[] typeVariables = Person.class.getTypeParameters();

        //泛型参数
        for (TypeVariable typeVariable : typeVariables){
            System.out.println(typeVariable);
        }

        Person<String> hah = new Person<>();

        //类继承的接口
        AnnotatedType[] annotatedTypes = Person.class.getAnnotatedInterfaces();
        for (AnnotatedType annotatedType : annotatedTypes){
            System.out.println("AnnotatedInterface: " + annotatedType.getType().getTypeName());
        }

        AnnotatedType annotatedType = Police.class.getAnnotatedSuperclass();
        System.out.println(annotatedType.getType());

        Annotation[] annotations = Person.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
    }
}
