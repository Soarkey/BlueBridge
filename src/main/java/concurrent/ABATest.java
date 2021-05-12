package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABATest class
 * 解决ABA问题
 *
 * @author Soarkey
 * @date 2021/5/8
 */
public class ABATest {
    // static AtomicInteger atomicInteger = new AtomicInteger(100);
    static AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) throws InterruptedException {
        // 会出现ABA问题
        // new Thread(() -> {
        //     atomicInteger.compareAndSet(100, 2021);
        //     atomicInteger.compareAndSet(2021, 100);
        // }, "a").start();
        //
        // Thread.sleep(3);
        // boolean flag = atomicInteger.compareAndSet(100, 2000);
        // System.out.println(flag + ":" + atomicInteger.get());

        // 通过版本号解决ABA问题
        new Thread(() -> {
            int stamp = atomicReference.getStamp();
            atomicReference.compareAndSet(100, 2021, stamp, stamp + 1);
            stamp = atomicReference.getStamp();
            atomicReference.compareAndSet(2021, 100, stamp, stamp + 1);
        }, "a").start();

        int expectVal = atomicReference.getReference(); // 100
        int stamp = atomicReference.getStamp(); // 1
        Thread.sleep(3);
        boolean flag = atomicReference.compareAndSet(expectVal, 2000, stamp, stamp + 1);
        System.out.println(atomicReference.getReference() + ":" + atomicReference.getStamp());
        System.out.println(flag + "," + expectVal + ":" + stamp);
    }
}
