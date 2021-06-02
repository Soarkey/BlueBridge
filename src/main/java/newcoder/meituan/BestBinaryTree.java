package newcoder.meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第10场)
 * 最优二叉树II
 * [未完成]
 * <p>
 * 测试用例对应输出应该为
 * 45
 * 9572681
 *
 * @author Soarkey
 * @date 2021/2/27
 */
public class BestBinaryTree {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n;
        int[] weights = new int[300];
        while (in.hasNextInt()) {
            n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                weights[i] = in.nextInt();
            }

            if (n <= 1) {
                out.println(0);
            } else {
                out.println(minWeights(weights, 0, n - 1, -1));
            }
        }

        in.close();
        out.close();
    }


    public static int minWeights(int[] weights, int left, int right, int cur) {
        // 无节点
        if (right - left + 1 == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = left; i <= right; ++i) {
            int root = 0;
            if (cur >= 0) {
                root = weights[cur] * weights[i];
            }

            String leftKey = left + "" + (i - 1) + "" + i;
            int leftValue;

            if (map.containsKey(leftKey)) {
                leftValue = map.get(leftKey);
            } else {
                leftValue = minWeights(weights, left, i - 1, i);
                map.put(leftKey, leftValue);
            }

            String rightKey = (i + 1) + "" + right + "" + i;
            int rightValue;

            if (map.containsKey(rightKey)) {
                rightValue = map.get(rightKey);
            } else {
                rightValue = minWeights(weights, i + 1, right, i);
                map.put(rightKey, rightValue);
            }

            ans = Math.min(ans, root + leftValue + rightValue);
        }

        return ans;
    }
}
