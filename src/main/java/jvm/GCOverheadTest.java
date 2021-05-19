package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class GCOverheadTest {
    public static void main(String[] args) {
        // Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("***************   i=" + i + "   ***************");
            e.printStackTrace();
            throw e;
        }
    }
}
