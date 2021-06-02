package newcoder.tencent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * MathCalc class
 *
 * @author Soarkey
 * @date 2021/4/4
 */
public class MathCalc {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            int T = in.nextInt();
            while (T-- != 0) {
                int l = in.nextInt();
                int r = in.nextInt();
                int k = in.nextInt();
                out.println(new DecimalFormat("0.00000E000")
                        .format(f(l, r, k)));
            }
        }

        in.close();
        out.close();
    }

    public static double f(int l, int r, int k) {
        double ans = 0;
        for (int i = l; i <= r; ++i) {
            ans += Math.pow((double) i + Math.pow(10, -k), (double) 1 / 3) - Math.pow(i, (double) 1 / 3);
        }
        return ans;
    }
}
