package jvm;

/**
 * YoungOldAreaTest class
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * Eden S1 S2 | Old
 * 16m  2m 2m | 40m
 *
 * @author Soarkey
 * @date 2021/5/5
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20]; // 20m  20480K
        // 结果
        // Heap
        //  PSYoungGen      total 18432K, used 2973K [0x00000000fec00000, 0x0000000100000000, 0x0000000100000000)
        //   eden space 16384K, 18% used [0x00000000fec00000,0x00000000feee7770,0x00000000ffc00000)
        //   from space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
        //   to   space 2048K, 0% used [0x00000000ffc00000,0x00000000ffc00000,0x00000000ffe00000)
        //  ParOldGen       total 40960K, used 20480K [0x00000000fc400000, 0x00000000fec00000, 0x00000000fec00000)
        //   object space 40960K, 50% used [0x00000000fc400000,0x00000000fd800010,0x00000000fec00000)
        //  Metaspace       used 3496K, capacity 4498K, committed 4864K, reserved 1056768K
        //   class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
    }
}
