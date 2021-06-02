package practice;

import java.util.HashMap;

/**
 * GuessNum class
 * dfs “注意方案去重！！！”
 * <p>
 * 猜算式：
 * 看下面的算式：
 * □□ x □□ = □□ x □□□
 * 它表示：两个两位数相乘等于一个两位数乘以一个三位数。
 * 如果没有限定条件，这样的例子很多。
 * 但目前的限定是：这9个方块，表示1~9的9个数字，不包含0。
 * 该算式中1至9的每个数字出现且只出现一次！
 * 比如：
 * 46 x 79 = 23 x 158
 * 54 x 69 = 27 x 138
 * 54 x 93 = 27 x 186
 * .....
 * 请编程，输出所有可能的情况！
 * 注意：
 * 左边的两个乘数交换算同一方案，不要重复输出！
 * 不同方案的输出顺序不重要
 *
 * @author Soarkey
 * @date 2018/2/17
 */
public class GuessFormula {

    static int[] num = new int[10];
    static int[] used = new int[10];
    static HashMap<String, Integer> result = new HashMap<>();

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == 9) {
            int n1 = num[0] * 10 + num[1];
            int n2 = num[2] * 10 + num[3];
            int left = n1 * n2;
            int right = (num[4] * 10 + num[5]) * (num[6] * 100 + num[7] * 10 + num[8]);
            if (left == right
                    && !result.containsKey(n1 + "" + n2)
                    && !result.containsKey(n2 + "" + n1)) {
                display();
                result.put(n1 + "" + n2, 1);
            }
            return;
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

    public static void display() {
        System.out.printf("%d%d * %d%d = %d%d * %d%d%d\n",
                num[0], num[1], num[2], num[3], num[4], num[5], num[6], num[7], num[8]);
    }
}
