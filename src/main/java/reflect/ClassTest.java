package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: ClassTest
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/8/6 14:29
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public class ClassTest {

    public static void main(String[] args) {
        try {
            Class<?> clazz =  Class.forName("reflect.GenericDeclarationTest");
            Constructor<?> constructor =  clazz.getDeclaredConstructor();
            GenericDeclarationTest genericDeclarationTest = (GenericDeclarationTest) constructor.newInstance(null);
            genericDeclarationTest.main(args);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
