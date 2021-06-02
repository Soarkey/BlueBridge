package newcoder.meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第9场)
 * 回转寿司
 * see https://blog.csdn.net/zhaoxiaoba/article/details/114048602
 * 可能的组合是：前缀和-前缀和最小值(0或者负数); 前缀和+以最后一个数字结尾的最大和子数组
 *
 * @author Soarkey
 * @date 2021/2/28
 */
public class CircleSushi {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();
        int[] sushi = new int[100002];
        int[] pre = new int[100002];
        int[] suf = new int[100002];
        int[] preMin = new int[100002];
        int[] sufMax = new int[100002];

        while (t-- != 0) {
            int n = in.nextInt();

            Arrays.fill(pre, 0);
            Arrays.fill(suf, 0);
            Arrays.fill(preMin, 0);
            Arrays.fill(sufMax, 0);

            int mins = 0, maxs = 0;
            for (int i = 0; i < n; ++i) {
                sushi[i] = in.nextInt();
                pre[i + 1] += pre[i] + sushi[i];
                mins = Math.min(mins, pre[i + 1]);
                preMin[i + 1] = mins;
            }

            for (int i = n - 1; i >= 0; --i) {
                suf[i] = suf[i + 1] + sushi[i];
                maxs = Math.max(maxs, suf[i]);
                sufMax[i] = maxs;
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, Math.max(pre[i + 1] - preMin[i + 1], pre[i + 1] + sufMax[i + 1]));
            }

            out.println(ans);
        }

        in.close();
        out.close();
    }
}
