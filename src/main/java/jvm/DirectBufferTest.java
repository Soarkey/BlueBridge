package jvm;

import java.io.BufferedInputStream;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class DirectBufferTest {
    private static final int BUFFER = 1024 * 1024 * 1024; // 1GB

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("分配直接内存");

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        in.next();

        byteBuffer = null;
        System.out.println("释放直接内存");
        System.gc();
        in.next();



    }
}
