package newcoder.bytedance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 字节跳动2018校招后端方向（第二批）
 * 字母交换
 *
 * 区间动态规划
 *
 * @author Soarkey
 * @date 2021/3/6
 */
public class ChangeCharactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            String s = in.next();
            char[] sc = s.toCharArray();
            int m = in.nextInt(), n = sc.length;
            int ans = 1;

            for (char c = 'a'; c <= 'z'; ++c) {
                int[] pos = new int[n];
                int top = -1;
                for (int i = 0; i < n; ++i) {
                    if (c == sc[i]) {
                        pos[++top] = i;
                    }
                }

                if (top + 1 < 2) {
                    // 栈元素少于2个, 不予考虑
                    continue;
                }

                int ret = 1;
                int[][] dp = new int[top + 1][top + 1];
                for (int len = 2; len <= top + 1; ++len) {
                    for (int i = 0; i + len - 1 < top + 1; ++i) {
                        dp[i][i + len - 1] = dp[i + 1][i + len - 2] + pos[i + len - 1] - pos[i] - len + 1;
                        if (dp[i][i + len - 1] <= m) {
                            ret = len;
                        }
                    }
                }
                ans = Math.max(ans, ret);
            }

            out.println(ans);
        }

        in.close();
        out.close();
    }
}
