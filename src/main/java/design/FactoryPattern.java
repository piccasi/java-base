package design;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: FactoryPattern
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/19 16:48
 * @Author: zhouguanbao@sensetime.com
 * @Description: 工厂模式
 **/
public class FactoryPattern {
    interface Fruit {
        String getName();
    }

    static class Apple implements Fruit {

        @Override
        public String getName() {
            return "apple";
        }
    }

    static class Banana implements Fruit {

        @Override
        public String getName() {
            return "banana";
        }
    }

    public static Fruit getFruit(String name){

        switch (name){
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getFruit("apple").getName());
    }
}
