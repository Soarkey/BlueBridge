package jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * NewObjectTest class
 *
 * @author Soarkey
 * @date 2021/5/12
 */
public class NewObjectTest {
    static class Demo implements Cloneable {
        int i;

        public Demo() {
        }

        public Demo(int i) {
            this.i = i;
        }

        @Override
        protected Demo clone() throws CloneNotSupportedException {
            return new Demo(this.i);
        }

        @Override
        public String toString() {
            return "Demo{" +
                    "i=" + i +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 1. new
        Demo demo1 = new Demo();
        // 2. class.newInstance
        try {
            Demo demo2 = Demo.class.newInstance();
            Demo demo2_1 = (Demo) Class.forName("jvm.NewObjectTest$Demo").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 3. Constructor
        try {
            Constructor<Demo> constructor1 = Demo.class.getConstructor();
            Demo demo3 = constructor1.newInstance();
            Constructor<Demo> constructor2 = Demo.class.getConstructor(int.class);
            Demo demo4 = constructor2.newInstance(10);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // 4. clone
        try {
            Demo demo5 = demo1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 5. 反序列化
        // 6. 第三方库Objenesis
    }
}
