package jvm;

/**
 * 对象复活
 *
 * @author Soarkey
 * @date 2021/6/5
 */
public class ReliveObject {
    public static ReliveObject obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类重写的finalize方法");
        obj = this;
    }

    public static void main(String[] args) {
        try {
            obj = new ReliveObject();
            obj = null;
            System.out.println("第一次gc");
            System.gc();
            // 因为Finalizer线程优先级很低，暂停2秒等待执行完成
            Thread.sleep(2000);
            if(obj == null) {
                System.out.println("对象已死亡");
            } else {
                System.out.println("对象仍然存活");
            }
            System.out.println("-------------------------------");
            obj = null;
            System.out.println("第二次gc");
            System.gc();
            if(obj == null) {
                System.out.println("对象已死亡");
            } else {
                System.out.println("对象仍然存活");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
