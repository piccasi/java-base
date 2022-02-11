package collection;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: Interface1
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/5/9 15:10
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public interface Interface1 {

    default int size(){
        return 1;
    }

    boolean isEmpty();
}
