package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: ToiletSemaphore
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/11 11:29
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public class ToiletSemaphore {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Employee(String.valueOf(i), s));
        }

        threadPool.shutdown();
    }
}
