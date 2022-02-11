package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: CyclicBarrierTest
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/6/11 12:30
 * @Author: piccasi@163.com
 * @Description: TODO
 **/

public class CyclicBarrierTest {

    public static class MyThread extends Thread {
        private CyclicBarrier cyclicBarrier;
        private String name;

        public MyThread(CyclicBarrier cyclicBarrier, String name) {
            super();
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "开始准备");
            try {
                Thread.sleep(5000);
                System.out.println(name + "准备完毕！等待发令枪");
                try {
                    cyclicBarrier.await();
                    System.out.println(name + "跑起来了");
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

            @Override
            public void run() {
                System.out.println("发令枪响了，跑！");

            }
        });

        for (int i = 0; i < 5; i++) {
            new MyThread(barrier, "运动员" + i + "号").start();

        }

        System.out.println("_________________________________");

        for (int i = 10; i < 15; i++) {
            new MyThread(barrier, "运动员" + i + "号").start();

        }

    }

}
