package jvm;

import java.nio.ByteBuffer;

/**
 * DirectBufferOOMTest
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * @author Soarkey
 * @date 2021/5/18
 */
public class DirectBufferOOMTest {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory大小 = " + sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024 + "MB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 6MB
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
        // Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    }
}
