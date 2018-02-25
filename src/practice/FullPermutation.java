package practice;

/**
 * FullPermutation class
 * dfs 全排列 针对N个不同的字符
 * 如果给定N 个不同字符，将这N 个字符全排列，最终的结果将会是N!种。如：给定 A、B、C 三个不同的字符，
 * 则结果为：ABC、ACB、BAC、BCA、CAB、CBA 一共3!=3*2=6 种情况。
 *
 * @author Soarkey
 * @date 2018/2/17
 */
public class FullPermutation {

    static int n;
    static char[] cs;

    public static void main(String[] args) {
        n = 3;
        cs = new char[n];
        for (int i = 0; i < n; i++) {
            cs[i] = (char) ('A' + i);
        }
        fullPermutation(0);
    }

    public static void fullPermutation(int depth) {
        if (depth == n) {
            display();
            return;
        }
        for (int i = depth; i < n; i++) {
            // exchange
            char temp = cs[depth];
            cs[depth] = cs[i];
            cs[i] = temp;
            fullPermutation(depth + 1);
            // exchange
            temp = cs[depth];
            cs[depth] = cs[i];
            cs[i] = temp;
        }
    }

    public static void display() {
        for (int i = 0; i < cs.length; i++) {
            System.out.print(cs[i]);
        }
        System.out.println();
    }

}