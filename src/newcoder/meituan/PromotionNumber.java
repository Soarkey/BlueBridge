package newcoder.meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第9场)
 * 晋级人数
 *
 * @author Soarkey
 * @date 2021/2/28
 */
public class PromotionNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n, x;
        while (in.hasNextInt()) {
            n = in.nextInt();
            x = in.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; ++i) {
                score[i] = in.nextInt();
            }

            Arrays.sort(score);
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                if (score[i] >= score[n - 1 - x] && score[i] != 0) {
                    ++ans;
                }
            }
            out.println(ans);
        }

        in.close();
        out.close();
    }
}
