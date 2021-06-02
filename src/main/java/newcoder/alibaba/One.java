package newcoder.alibaba;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * One class
 *
 * @author Soarkey
 * @date 2021/3/15
 */
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = in.nextInt();
        while (t-- != 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            int ans = 0;
            // 获取二进制位
            while (a != 0 || b != 0 || c != 0) {
                int i = a & 1;
                int j = b & 1;
                int k = c & 1;
                if ((i | j) != k) {
                    if (k == 1) {
                        ++ans;
                    } else { // k == 0
                        if ((i & j) == 1) {
                            ans += 2;
                        } else {
                            ++ans;
                        }
                    }
                }

                a >>= 1;
                b >>= 1;
                c >>= 1;
            }
            out.println(ans);
        }

        in.close();
        out.close();
    }
}
