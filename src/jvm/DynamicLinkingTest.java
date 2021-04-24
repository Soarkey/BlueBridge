package jvm;

/**
 * DynamicLinkingTest class
 *
 * @author Soarkey
 * @date 2021/4/23
 */
public class DynamicLinkingTest {
    int num = 10;

    public void methodA() {
        System.out.println("method A");
    }

    public void methodB() {
        System.out.println("method B");
        methodA();
        num++;
    }
}
