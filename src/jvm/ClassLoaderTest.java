package jvm;

import java.util.List;

/**
 * ClassLoaderTest class
 *
 * @author Soarkey
 * @date 2021/3/29
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        // 获取系统类加载器 systemClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // oracle jdk8
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // openjdk11
        // jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83

        // 获取上层 扩展类加载器 extClassLoader
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        // sun.misc.Launcher$ExtClassLoader@1540e19d
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@1d251891

        // 尝试获取上层 bootstrapClassLoader
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
        // null

        // 对用户自定义类来说，默认使用系统类加载器加载
        ClassLoader classLoader = ClassInitTest.class.getClassLoader();
        System.out.println(classLoader);
        // sun.misc.Launcher$AppClassLoader@18b4aac2

        // String类使用引导类加载器进行加载, -> java核心类库都是使用引导类加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
        // null

        ClassLoader classLoader2 = List.class.getClassLoader();
        System.out.println(classLoader2);
        // null

        // 核心类有哪些? 待补充
    }
}
