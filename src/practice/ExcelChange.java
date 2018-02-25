package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ExcelChange class
 *
 * @author Soarkey
 * @date 2018/2/17
 */
public class ExcelChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = in.nextInt();
        in.nextLine();
        while (n-- != 0) {
            String cell = in.nextLine();
            String[] result = cell.split("[RC]");
            int row = Integer.valueOf(result[1]);
            int column = Integer.valueOf(result[2]);
            out.println(change(column) + row);
        }

        in.close();
        out.close();
    }

    /**
     * 10进制 -> 26进制
     *
     * @return
     */
    public static String change(int num) {
        String str = " ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        int scale = 26;
        StringBuilder s = new StringBuilder();
        if (num == 0) {
            return "";
        }
        while (num > 0) {
            if (num < scale) {
                s.insert(0, str.charAt(num));
                num = 0;
            } else {
                int r = num % scale;
                s.insert(0, str.charAt(r));
                num = (num - r) / scale;
            }
        }
        return s.toString();
    }
}
