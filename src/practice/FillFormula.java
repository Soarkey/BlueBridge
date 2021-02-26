package practice;

import java.util.HashMap;

/**
 * FillFormula class
 * <p>
 * 填算式
 * 看这个算式：
 * ☆☆☆ + ☆☆☆ = ☆☆☆
 * 如果每个五角星代表 1 ~ 9 的不同的数字。
 * 这个算式有多少种可能的正确填写方法？
 * 173 + 286 = 459
 * 295 + 173 = 468
 * 173 + 295 = 468
 * 183 + 492 = 675
 * 以上都是正确的填写法！
 * 注意：
 * 111 + 222 = 333 是错误的填写法！
 * 因为每个数字必须是不同的！
 * 也就是说：1~9 中的所有数字，每个必须出现且仅出现一次！
 * <p>
 * 注意：
 * 不包括数字“0”！
 * 注意：
 * 满足加法交换率的式子算两种不同的答案。
 * 所以答案肯定是个偶数！
 * 注意：
 * 只要求计算不同的填法的数目
 * 不要求列出所有填写法
 * 更不要求填写源代码！
 *
 * @author Soarkey
 * @date 2018/2/21
 */
public class FillFormula {

    public static int[] num = new int[9];
    public static int[] used = new int[10];
    public static int count = 0;

    public static void main(String[] args) {
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int depth) {
        if (depth == 9) {
            int a = num[0] * 100 + num[1] * 10 + num[2];
            int b = num[3] * 100 + num[4] * 10 + num[5];
            int c = num[6] * 100 + num[7] * 10 + num[8];
            if (a + b == c) {
                count++;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (used[i] != 1) {
                used[i] = 1;
                num[depth] = i;
                dfs(depth + 1);
                used[i] = 0;
            }
        }
    }
}
