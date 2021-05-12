package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MyBlockingQueueTest class
 *
 * @author Soarkey
 * @date 2021/5/10
 */

class CakeResource {
    volatile boolean flag = true;
    BlockingQueue<String> blockingQueue;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public CakeResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void put() throws InterruptedException {
        String data = null;
        boolean ret;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            ret = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (ret) {
                System.out.println(Thread.currentThread().getName() + " 生产 " + data);
            } else {
                System.out.println(Thread.currentThread().getName() + " 生产 " + data + " 失败!");
            }
            Thread.sleep(10);
        }
        System.out.println(Thread.currentThread().getName() + " flag 为false，停止生产");
    }

    public void take() throws InterruptedException {
        String result = null;
        while (flag) {
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (result == null || "".equalsIgnoreCase(result)) {
                System.out.println("消费者超过2s未取到，停止消费");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " 消费 " + result + "成功");
        }
        System.out.println(Thread.currentThread().getName() + " flag 为false，停止消费");
    }

    public void stop() {
        flag = false;
    }
}

public class MyBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        CakeResource cakeResource = new CakeResource(new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    cakeResource.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Producer-" + i).start();
        }

        new Thread(() -> {
            try {
                cakeResource.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer-0").start();

        Thread.sleep(3000);
        System.out.println("关闭生产");
        cakeResource.stop();
    }
}
