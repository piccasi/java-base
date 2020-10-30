package design;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: 枚举单例
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/19 15:18
 * @Author: zhouguanbao@sensetime.com
 * @Description: 枚举类型是线程安全的，并且只会装载一次
 **/
public class Singleton {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private Singleton(String name){
        this.name = name;
    }

    private enum SingletonInstance {
        INSTANCE;

        private final Singleton instance;

        SingletonInstance(){
            instance = new Singleton("singleton");
        }

        private Singleton getInstance(){
            return instance;
        }

    }

    public static Singleton getInstance(){

        return SingletonInstance.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().getName());
    }
}
