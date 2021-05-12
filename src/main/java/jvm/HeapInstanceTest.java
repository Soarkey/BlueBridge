package jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * HeapInstanceTest class
 * -Xms600m -Xmx600m
 *
 * @author Soarkey
 * @date 2021/5/5
 */
public class HeapInstanceTest {
    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        List<HeapInstanceTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
