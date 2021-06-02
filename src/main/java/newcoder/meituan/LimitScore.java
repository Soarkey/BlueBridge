package newcoder.meituan;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第10场)
 * 淘汰分数
 *
 * @author Soarkey
 * @date 2021/2/27
 */
public class LimitScore {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n, x, y;
        while (in.hasNextInt()) {
            n = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; ++i) {
                score[i] = in.nextInt();
            }

            // 先排序
            Arrays.sort(score);
            int ans = -1;
            for (int i = 0; i < n; ++i) {
                if (n - 1 - i >= x && n - 1 - i <= y && i + 1 >= x && i + 1 <= y) {
                    ans = score[i];
                    break;
                }
            }
            out.println(ans);
        }

        in.close();
        out.close();
    }
}
