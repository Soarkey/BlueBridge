package jvm;

/**
 * 解释模式/编译模式/混合模式的时间比较
 *
 * -Xint  : 8614
 * -Xcomp : 1407
 * -Xmixed: 1401
 *
 * @author Soarkey
 * @date 2021/6/1
 */
public class IntCompTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        testPrimeNumber(100_0000);
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    public static void testPrimeNumber(int count) {
        for (int i = 0; i < count; ++i) {
            // 计算100以内的质数
            label:
            for (int j = 2; j <= 100; ++j) {
                for (int k = 2; k <= Math.sqrt(j); ++k) {
                    if (j % k == 0) {
                        continue label;
                    }
                }
            }
        }
    }
}
