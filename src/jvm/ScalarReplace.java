package jvm;

/**
 * ScalarReplace class
 *
 * -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * [GC (Allocation Failure)  25600K->784K(98304K), 0.0019691 secs]
 * [GC (Allocation Failure)  26384K->784K(98304K), 0.0009744 secs]
 * [GC (Allocation Failure)  26384K->760K(98304K), 0.0008821 secs]
 * [GC (Allocation Failure)  26360K->776K(98304K), 0.0020401 secs]
 * [GC (Allocation Failure)  26376K->760K(98304K), 0.0012633 secs]
 * [GC (Allocation Failure)  26360K->776K(101376K), 0.0018172 secs]
 * [GC (Allocation Failure)  32520K->725K(101376K), 0.0017218 secs]
 * [GC (Allocation Failure)  32469K->725K(100352K), 0.0007754 secs]
 * 花费的时间：82ms
 *
 * -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * 花费的时间：5ms
 *
 * @author Soarkey
 * @date 2021/5/6
 */
public class ScalarReplace {
    static class User {
        int id;
        String name;
    }

    public static void alloc() {
        User user = new User();
        user.id = 5;
        user.name = "hello";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间：" + (end - start) + "ms");
    }
}
