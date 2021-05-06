package jvm;

/**
 * SyncClearTest class
 *
 * @author Soarkey
 * @date 2021/5/6
 */
public class SyncClearTest {
    public void func() {
        Object obj = new Object();
        synchronized (obj) {
            System.out.println(obj);
        }
    }
}
