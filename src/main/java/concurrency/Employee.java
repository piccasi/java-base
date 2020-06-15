package concurrency;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2019, Sensetime Tech. Co., Ltd.
 *
 * @Name: Employ
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/11 11:27
 * @Author: zhouguanbao@sensetime.com
 * @Description: TODO
 **/



class Employee implements Runnable {
    private String id;
    private Semaphore semaphore;
    private static Random rand= new Random(47);

    public Employee(String id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(this.id + "is using the toilet");
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            semaphore.release();
            System.out.println(this.id + "is leaving");
        } catch (InterruptedException e) {
        }
    }
}
