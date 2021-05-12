package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProductConsumerTest class
 *
 * @author Soarkey
 * @date 2021/5/10
 */
class Resource {
    private int n = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void put() {
        lock.lock();
        try {
            while (n != 0) {
                condition.await();
            }
            ++n;
            System.out.println(Thread.currentThread().getName() + " put " + n);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        lock.lock();
        try {
            while (n == 0) {
                condition.await();
            }
            --n;
            System.out.println(Thread.currentThread().getName() + " take " + n);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return n;
    }
}

public class ProductConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        new Object().wait();
        Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.put();
            }
        }, "producer1").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.take();
            }
        }, "consumer1").start();
    }
}