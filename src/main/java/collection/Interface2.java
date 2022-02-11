package collection;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: Interface2
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/5/9 15:11
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public interface Interface2<T> extends Interface1 {
    @Override
    default int size() {
        return 2;
    }
}
