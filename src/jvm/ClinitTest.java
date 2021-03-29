package jvm;

/**
 * ClinitTest class
 *
 * @author Soarkey
 * @date 2021/3/28
 */
public class ClinitTest {
    static class Father {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        // 先加载Father，后加载Son
        System.out.println(Son.B); // B = 2
    }
}
