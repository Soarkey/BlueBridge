package newcoder.meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第9场)
 * 糕点
 *
 * @author Soarkey
 * @date 2021/2/28
 */
public class Cake {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n, m, a, b;
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();
            int[] w = new int[m];
            for (int i = 0; i < m; ++i) {
                w[i] = in.nextInt();
            }

            // 已经满足条件的蛋糕数
            int isa = 0, isb = 0;
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < m; ++i) {
                if (w[i] == a) {
                    isa = 1;
                } else if (w[i] == b) {
                    isb = 1;
                }
                max = Math.max(max, w[i]);
                min = Math.min(min, w[i]);
            }
            if(min >= Math.min(a, b) && max <= Math.max(a, b) && n - m >= 2 - isa - isb){
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

        in.close();
        out.close();
    }
}
