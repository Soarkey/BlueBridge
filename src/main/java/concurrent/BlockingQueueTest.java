package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueueTest class
 *
 * @author Soarkey
 * @date 2021/5/10
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // Exception in thread "main" java.lang.IllegalStateException: Queue full
        // System.out.println(blockingQueue.add("d"));

        System.out.println("------------------------");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // Exception in thread "main" java.util.NoSuchElementException
        // System.out.println(blockingQueue.remove());

        System.out.println("------------------------");
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 返回 false
        // System.out.println(blockingQueue.offer("x"));

        System.out.println("------------------------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 返回 null
        // System.out.println(blockingQueue.poll());

        System.out.println("------------------------");
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

        System.out.println("------------------------");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        // 阻塞
        // blockingQueue.take();

        System.out.println("------------------------");
        // 超时
        System.out.println(blockingQueue.offer("x", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("x", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("x", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("x", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("x", 2L, TimeUnit.SECONDS));
    }
}
