package newcoder.meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第10场)
 * 正则序列
 *
 * @author Soarkey
 * @date 2021/2/27
 */
public class RegularSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n;
        int[] seq = new int[20000];
        while (in.hasNextInt()) {
            n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                seq[i] = in.nextInt();
            }

            Arrays.sort(seq, 0, n);
            int ans = 0;

            for (int i = 0; i < n; ++i) {
                ans += Math.abs(i + 1 - seq[i]);
            }
            out.println(ans);
        }

        in.close();
        out.close();
    }
}
