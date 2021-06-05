package jvm;

/**
 * StringTest
 *
 * @author Soarkey
 * @date 2021/6/4
 */
public class StringTest {
    public static void main(String[] args) {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = s1 + s2;
        String s4 = "ab";
        // true
        System.out.println(s3 == s4);
        System.out.println("----------------");
        // test();
        testIntern();
        // testNewString();
    }

    public static void test() {
        // 83045
        // -------------------
        // 8
        // -------------------
        // 13
        final int N = 20_0000;
        long start = System.currentTimeMillis();
        String s1 = "";
        for (int i = 0; i < N; i++) {
            s1 = s1 + "a";
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("-------------------");

        start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("-------------------");

        start = System.currentTimeMillis();
        builder = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            builder.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void testIntern() {
        String s = new String("1");
        // 在调用此方法之前，字符串常量池中就已经存在了"1"
        s.intern();
        String s2 = "1";
        // jdk6: false jdk7/8: false
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        // jdk6: false jdk7/8: true
        System.out.println(s3 == s4);

        String s5 = new String("2") + new String("2");
        String s6 = "22";
        String s7 = s5.intern();
        // false
        System.out.println(s5 == s6);
        // true
        System.out.println(s7 == s6);
    }

    public static void testNewString() {
        String s1 = new String("ab");
        String s2 = new String("a") + new String("b");
    }
}
