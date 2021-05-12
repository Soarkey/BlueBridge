package jvm;

/**
 * ClassInitTest class
 *
 * @author Soarkey
 * @date 2021/3/28
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println("(1)." + num);
        // System.out.println(number); // Illegal forward reference
    }

    private static int number = 10; // linking prepare: number=0 -> initial: 20 --> 10

    public static void main(String[] args) {
        System.out.println("(2)." + ClassInitTest.num);
        System.out.println("(3)." + ClassInitTest.number); // 10
    }
}
