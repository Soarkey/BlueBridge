package newcoder.alibaba;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Two
 * 蜡烛
 *
 * @author Soarkey
 * @date 2021/3/15
 */
public class Two {
    private static float ans = 0.0f;
    private static int k = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n = in.nextInt();
            ans = 0.0f;
            k = 0;
            dfs(n, 0);
            out.format("%.4f\n", ans / k);
        }
        in.close();
        out.close();
    }

    public static void dfs(int len, int cur) {
        if (len == 1 || len == 2) {
            ++k;
            ans += (cur + 1);
            return;
        }

        for(int i=1; i<len; ++i){
            int a = Math.max(i, len - i);
            int b = Math.min(i, len - i);
            int nextLen = a - b;
            dfs(nextLen, cur + b);
        }
    }
}
