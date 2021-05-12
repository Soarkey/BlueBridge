package concurrent;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreTest class
 *
 * @author Soarkey
 * @date 2021/5/10
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 模拟抢车位, 3个车位
        Semaphore semaphore = new Semaphore(3);
        System.out.println("开始车位 " + semaphore.availablePermits());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() +
                            " 抢到车位, 剩余车位 " + semaphore.availablePermits() +
                            ", 等待队列长度 " + semaphore.getQueueLength());
                    Thread.sleep(3);
                    System.out.println(Thread.currentThread().getName() +
                            " 离开车位, 剩余车位 " + semaphore.availablePermits() +
                            ", 等待队列长度 " + semaphore.getQueueLength());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
