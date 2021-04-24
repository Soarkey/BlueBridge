package jvm;

/**
 * InvokeTypeTest class
 *
 * @author Soarkey
 * @date 2021/4/23
 */

class Father {
    public Father() {
        System.out.println("father 构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

class Son extends Father {
    public Son() {
        super(); // invokespecial
    }

    public Son(int age) {
        this(); // invokespecial
    }

    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    public void show() {
        // 非虚方法
        showStatic("xxx"); // invokestatic
        super.showStatic("yyy"); // invokestatic
        showPrivate("hello");  // invokespecial
        super.showCommon(); // invokespecial

        showFinal(); // invokevirtual
        super.showFinal(); // invokespecial, 因为此方法声明有final，子类不能重写，因此也认为是非虚方法

        // 虚方法
        showCommon(); // invokevirtual
        info(); // invokevirtual

        MethodInterface in = null;
        in.methodA(); // invokeinterface
    }

    public void info() {
    }
}

interface MethodInterface {
    void methodA();
}

public class InvokeTypeTest {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}
