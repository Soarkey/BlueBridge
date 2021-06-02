package newcoder.sap;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * One class
 *
 * @author Soarkey
 * @date 2021/4/22
 */
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int x = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            char[] sc = s.toCharArray();
            boolean ans = false;
            for (int i = 0; i <= n - x; ++i) {
                if (judge(sc, i, i + x - 1)) {
                    ans = true;
                    break;
                }
            }
            if (ans) {
                out.println("1");
            } else {
                out.println("0");
            }
        }

        in.close();
        out.close();
    }

    public static boolean judge(char[] sc, int start, int end) {
        // System.out.println("[" + start + "," + end + "]");
        int mid = (start + end) >>> 1;
        for (int i = start; i < mid; ++i) {
            // System.out.println("i:" + sc[i] + "," + sc[end - i]);
            if (sc[i] != sc[end - i]) {
                return false;
            }
        }
        return true;
    }
}
