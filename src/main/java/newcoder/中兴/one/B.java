package newcoder.中兴.one;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * B class
 *
 * @author Soarkey
 * @date 2021/4/24
 */
public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int T = in.nextInt();
            while (T-- != 0) {
                long n = in.nextLong();
                out.println(1 + (int) Math.ceil(Math.log(n) / Math.log(2)));
            }
        }

        in.close();
        out.close();
    }
}
