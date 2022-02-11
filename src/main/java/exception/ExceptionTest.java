package exception;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: ExceptionTest
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/11 10:53
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public class ExceptionTest {

    protected int tryAcquireShared(int arg) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();

        System.out.println("interrupted: " + Thread.interrupted());

        if(exceptionTest.tryAcquireShared(1) < 0){
            System.out.println("sdfsadfs");
        }
    }
}
