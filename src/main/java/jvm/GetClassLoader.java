package jvm;

/**
 * GetClassLoader class
 *
 * @author Soarkey
 * @date 2021/4/3
 */
public class GetClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取classloader的四种方式
        // 1
        ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader);
        // 2
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1);
        // 3
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(classLoader2);
    }
}
