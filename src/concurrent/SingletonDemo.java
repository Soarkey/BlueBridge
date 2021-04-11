package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Singleton class
 *
 * @author Soarkey
 * @date 2021/4/11
 */
class Singleton {
    private Singleton() {
    }

    // 懒汉式
    // 单重判断（不推荐）
    // private static Singleton instance;
    //
    // public static Singleton getInstance() {
    //     if (instance == null) {
    //         instance = new Singleton();
    //     }
    //     return instance;
    // }

    // 双重判断（不推荐）
    // private volatile static Singleton instance; // volatile: 可见性，禁止指令重排序优化
    //
    // public static Singleton getInstance() {
    //     if (instance == null) {
    //         synchronized (Singleton.class) {
    //             if (instance == null) {
    //                 instance = new Singleton();
    //             }
    //         }
    //     }
    //     return instance;
    // }

    // 静态内部类（推荐）
    public static final Singleton getInstance() {
        return Nested.INSTANCE;
    }

    private static class Nested {
        private static final Singleton INSTANCE = new Singleton();
    }
}

// 枚举实现单例
enum EasySingleton {
    INSTANCE;
    // private int k = 0;
    // EasySingleton(){
    //     System.out.println("初始化");
    //     ++k;
    //     System.out.println(k);
    // }
}


public class SingletonDemo {
    static final AtomicInteger times = new AtomicInteger(0);

    static class MyTask implements Runnable {
        @Override
        public void run() {
            int t = SingletonDemo.times.getAndIncrement();
            // Singleton instance = Singleton.getInstance();
            // System.out.println(Thread.currentThread().getName() + " : " + instance + ", t=" + t);

            // 枚举实现单例
            EasySingleton instance = EasySingleton.INSTANCE;
            System.out.println(Thread.currentThread().getName() + " : " + System.identityHashCode(instance) + ", t=" + t);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 200, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 2000; ++i) {
            Runnable task = new MyTask();
            pool.execute(task);
        }

        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        System.out.println(times);
    }
}
