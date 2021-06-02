package newcoder.envision;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * WindMachine class
 *
 * @author Soarkey
 * @date 2021/3/7
 */
public class WindMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            String line = in.nextLine();
            while ("".equals(line)) {
                line = in.nextLine();
            }
            //使用正则表达式将字符串分割 “\\s+”表示多个空格
            String a[] = line.split("\\s+");
            int[] cost = str2int(a);

            int n = cost.length;
            int[] value = new int[n];
            for (int i = 0; i < n; ++i) {
                value[i] = in.nextInt();
            }

            int limit = in.nextInt();
            // 0-1背包问题, i是第i件物品，j是背包剩余容量
            int[][] dp = new int[n][limit + 1];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < limit + 1; ++j) {
                    if (i == 0) {
                        if (j - cost[i] >= 0) {
                            dp[i][j] = value[i];
                        }
                        continue;
                    }
                    if (j - cost[i] >= 0) {
                        // 拿
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + value[i]);
                    } else {
                        // 不拿
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }

            out.println(dp[n - 1][limit]);
        }

        in.close();
        out.close();
    }

    public static int[] str2int(String[] arr) {
        int[] ans = new int[arr.length];
        int i = 0;
        for (String s : arr) {
            ans[i++] = Integer.parseInt(s);
        }
        return ans;
    }
}
