package concurrency;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright (C), 2019, piccasi@163.com
 *
 * @Name: ScheduleExcutor
 * @Since: 4.0
 * @Version: v1.0
 * @Date: 2020/9/23 10:18
 * @Author: piccasi@163.com
 * @Description: TODO
 **/
public class ScheduleExecutor {

    private static final AtomicInteger poolNum = new AtomicInteger(1);

    private final static AtomicInteger threadNum = new AtomicInteger(1);

    //private final ThreadGroup group;
    private final static String namePre = "ScheduleExecutor-";
    private final static boolean isDaemon = true;

    public static void main(String[] args) {

        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(5
                , (Runnable r) -> {

            Thread t = new Thread(Thread.currentThread().getThreadGroup(), r, namePre + threadNum.getAndIncrement(), 0);
            t.setContextClassLoader(ScheduleExecutor.class.getClassLoader());
            t.setPriority(Thread.NORM_PRIORITY);
            t.setDaemon(isDaemon);
            return t;

        }, (r, e) -> r.run() // run caller thread

        );

        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getId() + ", " + new Date());
            //Date d = new Date();
            //System.out.println(d);
        };

        Runnable r2 = () -> {
            System.out.println("-----------r2 is running--------------------");
            System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getId() + ", " + new Date());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----------r2 is complete--------------------");
            System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getId() + ", " + new Date());
        };

        System.out.println("start: " + new Date());

        Future f = executor.schedule(r1, 1000, TimeUnit.MILLISECONDS);

        System.out.println("-------------" + f.isDone());

        executor.schedule(r1, 1000, TimeUnit.MILLISECONDS);

        executor.schedule(r1, 1000, TimeUnit.MILLISECONDS);

        Future f2 = executor.schedule(r2, 0, TimeUnit.MILLISECONDS);


        try {
            Thread.sleep(2000);
            System.out.println("-------------" + f.isDone());

            while (!f2.isDone()){
                System.out.println("------r2-------" + f2.isDone());

                Thread.sleep(1000);
            }

            System.out.println("------r2-------" + f2.isDone());
            System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getId() + ", " + new Date());

            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
