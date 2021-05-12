package concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueueTest class
 *
 * @author Soarkey
 * @date 2021/5/10
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put a");
                blockingQueue.put("a");

                System.out.println(Thread.currentThread().getName() + " put b");
                blockingQueue.put("b");

                System.out.println(Thread.currentThread().getName() + " put c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());

                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());

                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
