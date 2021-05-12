package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockTest class
 *
 * @author Soarkey
 * @date 2021/5/9
 */
class Phone {
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + " sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + " sendEmail()");
    }

    private final Lock lock = new ReentrantLock();

    public void openPhone() {
        lock.lock();
        try {
            System.out.println("-------------------");
            Thread.sleep(3);
            System.out.println(Thread.currentThread().getName() + " openPhone()");
            showTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void showTime() {
        lock.lock();
        System.out.println(lock);
        lock.lock();
        System.out.println(lock);
        try {
            System.out.println(Thread.currentThread().getName() + " showTime()");
            System.out.println("-------------------");
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }
}


public class ReentrantLockTest {

    public static void main(String[] args) {
        Phone phone = new Phone();

        // 1. synchronized 是可重入锁
        // new Thread(() -> phone.sendSMS(), "t1").start();
        // phone.sendSMS();

        // 2. ReentrantLock 是可重入锁
        for (int i = 0; i < 50; i++) {
            new Thread(() -> phone.openPhone(), String.valueOf(i)).start();
        }
    }
}
