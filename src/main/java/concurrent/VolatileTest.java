package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * VolatileTest class
 *
 * @author Soarkey
 * @date 2021/5/8
 */

class Data {
    // int number = 0;
    volatile int number = 0;

    public void change() {
        this.number = 60;
    }

    public void incr() {
        ++number;
    }
}

public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
        testAtomic();
    }

    /**
     * 可见性
     */
    public static void testVisable() {
        Data data = new Data();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 进入");
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.change();
            System.out.println(Thread.currentThread().getName() + " 退出 number=" + data.number);
        }, "a").start();


        while (data.number == 0) {
        }

        System.out.println(Thread.currentThread().getName() + " 完成");
    }

    /**
     * 不保证原子性
     *
     * @throws InterruptedException
     */
    public static void testAtomic() throws InterruptedException {
        Data data = new Data();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.incr();
                }
            }, String.valueOf(i));

            thread.start();
            // thread.join();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ": " + data.number);
    }
}
