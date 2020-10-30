package design;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: AbstractFactoryPattern
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/19 17:00
 * @Author: zhouguanbao@sensetime.com
 * @Description: 抽象工厂
 **/
public class AbstractFactoryPattern {
    interface Color {
        String getColor();
    }

    static class Red implements Color {

        @Override
        public String getColor() {
            return "red";
        }
    }

    static class Yellow implements Color {

        @Override
        public String getColor() {
            return "yellow";
        }
    }

    public static abstract class AbstractFactory {
        public abstract Color getColor(String color);
        public abstract FactoryPattern.Fruit getFruit(String name) ;
    }

    public static class FruitFactory extends AbstractFactory {

        @Override
        public Color getColor(String color) {
            return null;
        }

        @Override
        public FactoryPattern.Fruit getFruit(String name) {
            return FactoryPattern.getFruit(name);
        }
    }

    public static Color getColor(String name){

        switch (name){
            case "red":
                return new Red();
            case "yellow":
                return new Yellow();
            default:
                return null;
        }
    }

    public static class ColorFactory extends AbstractFactory {

        @Override
        public Color getColor(String color) {
            return AbstractFactoryPattern.getColor(color);
        }

        @Override
        public FactoryPattern.Fruit getFruit(String name) {
            return null;
        }
    }

    public static AbstractFactory getFactory(String choice){
        if("FRUIT".equalsIgnoreCase(choice)){
            return new FruitFactory();
        } else if("COLOR".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        return null;
    }

    public static void main(String[] args) {
        AbstractFactory fruitFactory = getFactory("FRUIT");
        FactoryPattern.Fruit fruit = fruitFactory.getFruit("apple");

        System.out.println(fruit.getName());

        AbstractFactory colorFactory = getFactory("COLOR");
        Color color = colorFactory.getColor("yellow");

        System.out.println(color.getColor());
    }

}
