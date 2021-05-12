package jvm;

/**
 * DeadThreadTest class
 *
 * @author Soarkey
 * @date 2021/3/28
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " 开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + " 结束");
        };

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");

        t1.start();
        t2.start();
        // 线程1 开始
        // 线程1 初始化当前类
        // 线程2 开始
        // ...
    }
}


class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + " 初始化当前类");
            while (true) {

            }
        }
    }
}