package concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ListNoSafeTest class
 *
 * @author Soarkey
 * @date 2021/5/8
 */
public class ListNoSafeTest {
    /**
     * 1. ArrayList多线程修改会报 java.util.ConcurrentModificationException 异常
     */
    public static void testArrayList() {
        List<String> list = new ArrayList<>();
        // list.forEach(System.out::println);

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add("6");
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        // java.util.ConcurrentModificationException

        // Exception in thread "22" Exception in thread "25" java.util.ConcurrentModificationException
        // at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
        // at java.util.ArrayList$Itr.next(ArrayList.java:851)
        // at java.util.AbstractCollection.toString(AbstractCollection.java:461)
        // at java.lang.String.valueOf(String.java:2994)
        // at java.io.PrintStream.println(PrintStream.java:821)
        // at concurrent.ListNoSafeTest.lambda$main$0(ListNoSafeTest.java:22)
        // at java.lang.Thread.run(Thread.java:745)
        // java.util.ConcurrentModificationException
        // at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
        // at java.util.ArrayList$Itr.next(ArrayList.java:851)
        // at java.util.AbstractCollection.toString(AbstractCollection.java:461)
        // at java.lang.String.valueOf(String.java:2994)
        // at java.io.PrintStream.println(PrintStream.java:821)
        // at concurrent.ListNoSafeTest.lambda$main$0(ListNoSafeTest.java:22)
        // at java.lang.Thread.run(Thread.java:745)
    }

    /**
     * 2. 使用vector
     */
    public static void testVector() {
        List<String> list = new Vector<>();

        try {
            for (int i = 0; i < 30; i++) {
                Thread thread = new Thread(() -> {
                    list.add("6");
                }, String.valueOf(i));
                thread.start();
                thread.join();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size() + ":" + list);
    }

    /**
     * 3. 使用 Collections.synchronizedList 包装 ArrayList
     */
    public static void testCollections() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add("6");
                System.out.println(list.size() + ":" + list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 4. 使用 写时复制列表 CopyOnWriteArrayList
     */
    public static void testCopyOnWriteArrayList() {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add("6");
                System.out.println(list.size() + ":" + list);
            }, String.valueOf(i)).start();
        }
    }

    public static void main(String[] args) {
        testCopyOnWriteArrayList();
    }
}
