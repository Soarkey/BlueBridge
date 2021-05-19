package jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class RefTest {
    public static void main(String[] args) throws InterruptedException {
        // testReference();
        // testWeakReference();
        // testReferenceQueue();

        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, referenceQueue);

        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        obj = null;
        System.gc();
        Thread.sleep(500);

        System.out.println("=======================");
        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

    }

    private static void testReferenceQueue() throws InterruptedException {
        /**
         * 引用队列
         */
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(obj, referenceQueue);

        System.out.println(obj);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=====================");
        obj = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(obj);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        // 结果
        // java.lang.Object@14ae5a5
        // java.lang.Object@14ae5a5
        // null
        // =====================
        // null
        // null
        // java.lang.ref.WeakReference@7f31245a
    }

    private static void testWeakReference() {
        /**
         * 弱引用
         */
        Map<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        // 若直接定义 Integer key = 2; 则无法回收
        String value = "WeakHashMap";
        weakHashMap.put(key, value);
        System.out.println(weakHashMap);

        key = null;
        System.out.println(weakHashMap);

        System.gc();
        System.out.println(weakHashMap);
    }

    private static void testReference() {
        /**
         * 强引用
         */
        Object obj1 = new Object();
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        // java.lang.Object@14ae5a5
        System.out.println(obj2);
    }
}
