package collection;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: Interface2
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/5/9 15:11
 * @Author: zhouguanbao@sensetime.com
 * @Description: TODO
 **/
public interface Interface2<T> extends Interface1 {
    @Override
    default int size() {
        return 2;
    }
}
