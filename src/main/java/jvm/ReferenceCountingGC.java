package jvm;

/**
 * ReferenceCountingGC class
 *
 * @author Soarkey
 * @date 2021/3/28
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        testGC();
    }

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        // 循环引用
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();

        System.out.println("---------------------------");
    }
}
