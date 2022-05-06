package ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalTime;

public class RateLimit {

    public static void main(String[] args) {
        testAcquire();
    }

    public static void testAcquire() {
        RateLimiter rateLimiter = RateLimiter.create(5);

        double count = 0;
        for (int i = 0; i < 100; i++) {
            double sleep = rateLimiter.acquire();
            count += sleep;
            System.out.println("i: " + i + " now: " + LocalTime.now() + "  sleep: " + sleep);
        }

        System.out.println(count);
    }
}
