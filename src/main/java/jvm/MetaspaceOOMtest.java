package jvm;


import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * MetaspaceOOMtest class
 *
 * JDK8+
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 *
 * 8531
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 * at java.lang.ClassLoader.defineClass1(Native Method)
 * at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
 * at java.lang.ClassLoader.defineClass(ClassLoader.java:642)
 * at jvm.MetaspaceOOMtest.main(MetaspaceOOMtest.java:27)
 *
 * @author Soarkey
 * @date 2021/5/6
 */
public class MetaspaceOOMtest extends ClassLoader {
    public static void main(String[] args) {
        // 动态创建非常多的类，使metaspace溢出
        int j = 0;
        try {
            MetaspaceOOMtest test = new MetaspaceOOMtest();
            for (int i = 0; i < 1_0000; i++) {
                ClassWriter classWriter = new ClassWriter(0);
                // 指明 版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                // 生成二进制字节码
                byte[] code = classWriter.toByteArray();
                // 类加载
                test.defineClass("Class" + i, code, 0, code.length);
                ++j;
            }
        } finally {
            System.out.println(j);
        }

    }
}
