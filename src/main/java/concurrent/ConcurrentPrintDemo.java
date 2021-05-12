package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConcurrentPrintDemo class
 *
 * @author Soarkey
 * @date 2021/5/10
 */

class MyResource {
    Lock lock = new ReentrantLock();
    int number = 1; // 1：A, 2: B, 3:C
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void print1() {
        lock.lock();
        try {
            while (number != 1) {
                conditionA.await();
            }
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number = 2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print2() {
        lock.lock();
        try {
            while (number != 2) {
                conditionB.await();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number = 3;
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print3() {
        lock.lock();
        try {
            while (number != 3) {
                conditionC.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number = 1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ConcurrentPrintDemo {
    public static void main(String[] args) {
        MyResource resource = new MyResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print3();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print2();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print1();
            }
        }, "A").start();
    }
}
