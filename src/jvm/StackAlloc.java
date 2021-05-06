package jvm;

/**
 * StackAlloc class
 * -Xmx1G -Xmx1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * [GC (Allocation Failure) [PSYoungGen: 33280K->776K(38400K)] 33280K->784K(125952K), 0.0085879 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * [GC (Allocation Failure) [PSYoungGen: 34056K->760K(71680K)] 34064K->768K(159232K), 0.0019677 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 67320K->728K(71680K)] 67328K->736K(159232K), 0.0017047 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 67288K->744K(138240K)] 67296K->752K(225792K), 0.0023249 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 花费的时间：92ms
 *
 *
 * -Xmx1G -Xmx1G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * 花费的时间：7ms
 *
 * -Xmx256M -Xmx256M -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * [GC (Allocation Failure) [PSYoungGen: 33280K->744K(38400K)] 33280K->752K(125952K), 0.0013380 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 34024K->760K(38400K)] 34032K->768K(125952K), 0.0010536 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 34040K->712K(38400K)] 34048K->720K(125952K), 0.0029866 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 33992K->696K(71680K)] 34000K->704K(159232K), 0.0012098 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) [PSYoungGen: 67256K->712K(71680K)] 67264K->720K(159232K), 0.0009710 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 花费的时间：103ms
 *
 * -Xmx256M -Xmx256M -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * 花费的时间：5ms
 *
 * @author Soarkey
 * @date 2021/5/6
 */
public class StackAlloc {

    static class User {
        String username;
        String password;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间：" + (end - start) + "ms");
        // 睡眠程序，方便查看堆内存对象个数
        try {
            Thread.sleep(100_0000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void alloc() {
        User user = new User();
    }
}
