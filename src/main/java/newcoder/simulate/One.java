package newcoder.simulate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * One class
 *
 * @author Soarkey
 * @date 2021/3/18
 */
public abstract class One {
    public static native int meo();
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        // int t = in.nextInt();
        int a = 5, b = 5;

        in.close();
        out.close();
    }

}
