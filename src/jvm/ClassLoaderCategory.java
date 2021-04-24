package jvm;

import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.Provider;

/**
 * ClassLoaderCategory class
 *
 * @author Soarkey
 * @date 2021/3/29
 */
public class ClassLoaderCategory {
    public static void main(String[] args) {
        System.out.println("############## 启动类加载器 ##############");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toString());
        }
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/resources.jar
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/rt.jar
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/sunrsasign.jar
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/jsse.jar
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/jce.jar
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/charsets.jar
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/lib/jfr.jar
        // file:/C:/Program%20Files/Java/jdk1.8.0_121/jre/classes

        // Provider属于上面的路径
        System.out.println(Provider.class.getClassLoader());
        // null

        System.out.println("############## 扩展类加载器 ##############");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        // C:\Program Files\Java\jdk1.8.0_121\jre\lib\ext
        // C:\WINDOWS\Sun\Java\lib\ext
    }
}
