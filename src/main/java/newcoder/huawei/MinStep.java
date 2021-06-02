package newcoder.huawei;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * MinStep class
 * 超时 70%
 *
 * @author Soarkey
 * @date 2021/3/31
 */
public class MinStep {
    static int ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            String s = in.nextLine();
            String pattern = in.nextLine();
            // 转成字符数组能加快取第i位的速度，以空间换时间
            char[] sc = s.toCharArray();
            char[] pc = pattern.toCharArray();
            int start = in.nextInt();

            ans = Integer.MAX_VALUE;
            dfs(sc, pc, start, 0, 0);

            out.println(ans);
        }

        in.close();
        out.close();
    }

    /**
     * 匹配到第 k 位
     */
    public static void dfs(char[] sc, char[] pc, int start, int k, int step) {
        if (k == pc.length) {
            ans = Math.min(ans, step);
            return;
        }
        if (step >= ans) {
            return;
        }

        for (int j = 0; j < sc.length; j++) {
            if (pc[k] == sc[j]) {
                int t = Math.abs(j - start);
                dfs(sc, pc, j, k + 1,
                        step + Math.min(t, Math.abs(sc.length - t))
                );
            }
        }
    }
}
