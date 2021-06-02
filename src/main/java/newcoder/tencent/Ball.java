package newcoder.tencent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Ball class
 *
 * @author Soarkey
 * @date 2021/4/4
 */
public class Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            int T = in.nextInt();
            while (T-- != 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                out.println(C(n - k + 1, k));
            }
        }

        in.close();
        out.close();
    }

    private static int C(int n, int k) {
        int a = 1, b = 1;
        if (k > n / 2) {
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }
}
