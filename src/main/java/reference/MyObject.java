package reference;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: MyObject
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/10 17:48
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public class MyObject {
    private int[] ints = new int[1000];
    private final String name;

    public MyObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("%s is finalizing.%n", name);
    }
}
