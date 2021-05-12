package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class MyThread implements Runnable {
    private Object data;

    public MyThread(Object data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start, data: " + data);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * ThreadPoolExecutorDemo class
 *
 * @author Soarkey
 * @date 2021/3/15
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i <= 100; ++i) {
            try {
                String task = "task@" + i;
                System.out.println("put " + task);
                threadPool.execute(new MyThread(task));

                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        threadPool.shutdown();
    }
}
