package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteTest class
 *
 * @author Soarkey
 * @date 2021/5/9
 */
class Cache {
    volatile Map<Integer, Object> map = new HashMap<>();
    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(Integer key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写入 " + key);
            // 模拟操作和网络延时
            Thread.sleep(3);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(Integer key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在读取 " + key);
            // 模拟操作和网络延时
            Thread.sleep(3);
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完成 " + key + ":" + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

public class ReadWriteTest {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(() -> cache.put(finalI, finalI), "write-thread-" + i).start();
        }

        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(() -> cache.get(finalI), "read-thread-" + i).start();
        }
    }
}
