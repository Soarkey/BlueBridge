package jvm;

/**
 * SoltReuse
 * -XX:+PrintGCDetails
 *
 * @author Soarkey
 * @date 2021/6/6
 */
public class SoltReuse {
    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        test4();
    }

    public static void test1() {
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
        // [GC (System.gc()) [PSYoungGen: 3328K->792K(38400K)] 68864K->66336K(125952K), 0.0024421 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        // [Full GC (System.gc()) [PSYoungGen: 792K->0K(38400K)] [ParOldGen: 65544K->66226K(87552K)] 66336K->66226K(125952K), [Metaspace: 3491K->3491K(1056768K)], 0.0064571 secs] [Times: user=0.03 sys=0.02, real=0.02 secs]
        // Heap
        //  PSYoungGen      total 38400K, used 333K [0x00000000d5e00000, 0x00000000d8880000, 0x0000000100000000)
        //   eden space 33280K, 1% used [0x00000000d5e00000,0x00000000d5e534a8,0x00000000d7e80000)
        //   from space 5120K, 0% used [0x00000000d7e80000,0x00000000d7e80000,0x00000000d8380000)
        //   to   space 5120K, 0% used [0x00000000d8380000,0x00000000d8380000,0x00000000d8880000)
        //  ParOldGen       total 87552K, used 66226K [0x0000000081a00000, 0x0000000086f80000, 0x00000000d5e00000)
        //   object space 87552K, 75% used [0x0000000081a00000,0x0000000085aacb18,0x0000000086f80000)
        //  Metaspace       used 3498K, capacity 4498K, committed 4864K, reserved 1056768K
        //   class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
    }

    public static void test2() {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
        // [GC (System.gc()) [PSYoungGen: 3328K->808K(38400K)] 68864K->66352K(125952K), 0.0013907 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        // [Full GC (System.gc()) [PSYoungGen: 808K->0K(38400K)] [ParOldGen: 65544K->66226K(87552K)] 66352K->66226K(125952K), [Metaspace: 3491K->3491K(1056768K)], 0.0060570 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        // Heap
        //  PSYoungGen      total 38400K, used 333K [0x00000000d5e00000, 0x00000000d8880000, 0x0000000100000000)
        //   eden space 33280K, 1% used [0x00000000d5e00000,0x00000000d5e534a8,0x00000000d7e80000)
        //   from space 5120K, 0% used [0x00000000d7e80000,0x00000000d7e80000,0x00000000d8380000)
        //   to   space 5120K, 0% used [0x00000000d8380000,0x00000000d8380000,0x00000000d8880000)
        //  ParOldGen       total 87552K, used 66226K [0x0000000081a00000, 0x0000000086f80000, 0x00000000d5e00000)
        //   object space 87552K, 75% used [0x0000000081a00000,0x0000000085aacb18,0x0000000086f80000)
        //  Metaspace       used 3498K, capacity 4498K, committed 4864K, reserved 1056768K
        //   class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
    }

    public static void test3() {
        // 加入a实现变量槽solt复用
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
        // [GC (System.gc()) [PSYoungGen: 3328K->760K(38400K)] 68864K->66304K(125952K), 0.0020062 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        // [Full GC (System.gc()) [PSYoungGen: 760K->0K(38400K)] [ParOldGen: 65544K->690K(87552K)] 66304K->690K(125952K), [Metaspace: 3491K->3491K(1056768K)], 0.0059541 secs] [Times: user=0.05 sys=0.00, real=0.02 secs]
        // Heap
        //  PSYoungGen      total 38400K, used 333K [0x00000000d5e00000, 0x00000000d8880000, 0x0000000100000000)
        //   eden space 33280K, 1% used [0x00000000d5e00000,0x00000000d5e534a8,0x00000000d7e80000)
        //   from space 5120K, 0% used [0x00000000d7e80000,0x00000000d7e80000,0x00000000d8380000)
        //   to   space 5120K, 0% used [0x00000000d8380000,0x00000000d8380000,0x00000000d8880000)
        //  ParOldGen       total 87552K, used 690K [0x0000000081a00000, 0x0000000086f80000, 0x00000000d5e00000)
        //   object space 87552K, 0% used [0x0000000081a00000,0x0000000081aacb08,0x0000000086f80000)
        //  Metaspace       used 3498K, capacity 4498K, committed 4864K, reserved 1056768K
        //   class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
    }

    public static void test4() {
        // 置null可以达成和变量槽solt复用一样的效果
        byte[] placeholder = new byte[64 * 1024 * 1024];
        placeholder = null;
        System.gc();
        // [GC (System.gc()) [PSYoungGen: 3328K->824K(38400K)] 68864K->66368K(125952K), 0.0014639 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        // [Full GC (System.gc()) [PSYoungGen: 824K->0K(38400K)] [ParOldGen: 65544K->690K(87552K)] 66368K->690K(125952K), [Metaspace: 3491K->3491K(1056768K)], 0.0055363 secs] [Times: user=0.00 sys=0.01, real=0.02 secs]
        // Heap
        //  PSYoungGen      total 38400K, used 333K [0x00000000d5e00000, 0x00000000d8880000, 0x0000000100000000)
        //   eden space 33280K, 1% used [0x00000000d5e00000,0x00000000d5e534a8,0x00000000d7e80000)
        //   from space 5120K, 0% used [0x00000000d7e80000,0x00000000d7e80000,0x00000000d8380000)
        //   to   space 5120K, 0% used [0x00000000d8380000,0x00000000d8380000,0x00000000d8880000)
        //  ParOldGen       total 87552K, used 690K [0x0000000081a00000, 0x0000000086f80000, 0x00000000d5e00000)
        //   object space 87552K, 0% used [0x0000000081a00000,0x0000000081aacb08,0x0000000086f80000)
        //  Metaspace       used 3498K, capacity 4498K, committed 4864K, reserved 1056768K
        //   class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
        //
        // Process finished with exit code 0
    }
}
