package concurrent;

/**
 * ThreadLocalTest
 *
 * @author Soarkey
 * @date 2021/5/23
 */
public class ThreadLocalTest {

    static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    static class Task implements Runnable {

        @Override
        public void run() {
            Long result = threadLocal.get();
            if (result == null) {
                threadLocal.set(System.currentTimeMillis());
            }
            System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        new Thread(task, "A").start();
        Thread.sleep(5);
        new Thread(task, "B").start();
        Thread.sleep(1);
        new Thread(task, "C").start();

        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());
    }
}
