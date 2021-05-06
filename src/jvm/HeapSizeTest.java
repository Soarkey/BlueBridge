package jvm;

/**
 * HeapSizeTest class
 *
 * @author Soarkey
 * @date 2021/4/27
 */
public class HeapSizeTest {
    public static void main(String[] args) {
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("-Xms:" + initialMemory + "M");
        System.out.println("-Xmx:" + maxMemory + "M");
        System.out.println("system memory size: " + initialMemory * 64 / 1024 + "G");
        System.out.println("system memory size: " + maxMemory * 4 / 1024 + "G");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
