package concurrent;

/**
 * DeadLockTest class
 *
 * @author Soarkey
 * @date 2021/5/11
 */
public class DeadLockTest {
    static class HoldLockThread implements Runnable {
        final String objA;
        final String objB;

        public HoldLockThread(String objA, String objB) {
            this.objA = objA;
            this.objB = objB;
        }

        @Override
        public void run() {
            synchronized (objA) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 已经持有 " + objA + ", 尝试获取 " + objB);
                synchronized (objB) {
                    System.out.println(Thread.currentThread().getName() + " 获取 " + objB + " 成功");
                }
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA, lockB), "Thread-1").start();
        new Thread(new HoldLockThread(lockB, lockA), "Thread-2").start();

//         Found one Java-level deadlock:
// =============================
//         "Thread-2":
//         waiting to lock monitor 0x000000000369e918 (object 0x00000000d5fa4060, a java.lang.String),
//         which is held by "Thread-1"
//         "Thread-1":
//         waiting to lock monitor 0x000000000369d478 (object 0x00000000d5fa4098, a java.lang.String),
//         which is held by "Thread-2"
//
//         Java stack information for the threads listed above:
// ===================================================
//         "Thread-2":
//         at concurrent.DeadLockTest$HoldLockThread.run(DeadLockTest.java:32)
//         - waiting to lock <0x00000000d5fa4060> (a java.lang.String)
//         - locked <0x00000000d5fa4098> (a java.lang.String)
//         at java.lang.Thread.run(Thread.java:745)
//         "Thread-1":
//         at concurrent.DeadLockTest$HoldLockThread.run(DeadLockTest.java:32)
//         - waiting to lock <0x00000000d5fa4098> (a java.lang.String)
//         - locked <0x00000000d5fa4060> (a java.lang.String)
//         at java.lang.Thread.run(Thread.java:745)
//
//         Found 1 deadlock.

    }
}
