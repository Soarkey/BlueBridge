package practice;

import java.math.BigInteger;

/**
 * Wheat class
 * <p>
 * 放麦子
 * 你一定听说过这个故事。国王对发明国际象棋的大臣很佩服，
 * 问他要什么报酬，大臣说：请在第1 个棋盘格放1 粒麦子，
 * 在第2 个棋盘格放2 粒麦子，在第3 个棋盘格放4 粒麦子，
 * 在第4 个棋盘格放8 粒麦子，......后一格的数字是前一格的两倍，
 * 直到放完所有棋盘格（国际象棋共有64 格）。
 * 国王以为他只是想要一袋麦子而已，哈哈大笑。
 * 当时的条件下无法准确计算，但估算结果令人吃惊：即使全世界都铺满麦子也不够用！
 * 11
 * 请你借助计算机准确地计算，到底需要多少粒麦子。
 *
 * @author Soarkey
 * @date 2018/2/18
 */
public class Wheat {
    public static void main(String[] args) {
        System.out.println(calc());
        System.out.println(calc2());
    }

    /**
     * 方法1，低效，直接模拟加和
     *
     * @return
     */
    public static BigInteger calc() {
        BigInteger ans = BigInteger.ZERO;
        BigInteger two = new BigInteger("2");
        for (int i = 0; i < 64; i++) {
            ans = ans.add(two.pow(i));
        }
        return ans;
    }

    /**
     * 方法2，高效，利用等比数列求和公式
     *      a1 (1- q^n)
     * S = -------------
     *         1 - q
     */
    public static BigInteger calc2() {
        BigInteger ans = BigInteger.ZERO;
        BigInteger two = new BigInteger("2");
        return two.pow(64).add(new BigInteger("-1"));
    }
}
