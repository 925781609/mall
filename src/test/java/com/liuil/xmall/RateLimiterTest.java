package com.liuil.xmall;

import com.google.common.util.concurrent.RateLimiter;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class RateLimiterTest {

  private static int timeout = 1000;
  private ExecutorService threadPool = new ThreadPoolExecutor(
      20, 300, 1, TimeUnit.SECONDS,
      new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.CallerRunsPolicy());


  @Test
  public void testRateLimiter() {
    // 每秒只发2个令牌
    RateLimiter rateLimiter = RateLimiter.create(1);
    AtomicInteger count = new AtomicInteger(0);

    for (int i = 0; i < 20; i++) {
      System.out.println(i + "开始尝试获得令牌" + LocalDateTime.now());
      //判断能否在给定时间内得到令牌，如果不能则立即返回false，不会阻塞程序
      //否则会阻塞尝试获得令牌
      if (!rateLimiter.tryAcquire(timeout, TimeUnit.MILLISECONDS)) {
        System.out.println(i + "短期无法获取令牌");
        continue;
      }
      System.out.println(i + "结束尝试获得令牌" + LocalDateTime.now());
      threadPool.execute(() -> {
        System.out
            .println("Thread-" + count.getAndIncrement() + "开始运行");

      });
    }

    try {
      TimeUnit.SECONDS.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
