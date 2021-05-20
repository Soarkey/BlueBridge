package concurrent;

import lombok.Getter;

import java.util.concurrent.*;

/**
 * ThreadPoolTest class
 *
 * @author Soarkey
 * @date 2021/5/10
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // testExecutors();
        testMyThreadPool();
    }

    public static void testMyThreadPool() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void testExecutors() {
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 办理业务");
                });
                Thread.sleep(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void testFutureTask() throws InterruptedException, ExecutionException {
        // fork-join 或 map-reduce 的思想
        int count = 10;
        int result = 0;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        FutureTask<Integer>[] futureTasks = new FutureTask[count];
        for (int i = 0; i < count; i++) {
            futureTasks[i] = new FutureTask<>(new MyThread(countDownLatch));
            new Thread(futureTasks[i], String.valueOf(i)).start();
        }
        countDownLatch.await();
        for (int i = 0; i < count; i++) {
            result += futureTasks[i].get(); // 会阻塞
        }
        System.out.println("返回值：" + result);
    }

    static class MyThread implements Callable<Integer> {
        @Getter
        private final CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " 线程处理数据");
            Thread.sleep(3000);
            this.countDownLatch.countDown();
            return 100;
        }
    }
}
