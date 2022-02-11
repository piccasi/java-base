package innerclass;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: InnerClass
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/5/9 17:31
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public class InnerClass {
    private int size;

    public int getSize(){
        return new Itr().index;
    }

    private class Itr {
        int index = InnerClass.this.size;

    }
}
