package newcoder.shopee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ChangeNameStyle class
 *
 * @author Soarkey
 * @date 2021/3/26
 */
public class ChangeNameStyle {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            String s = in.nextLine();
            out.println(caseTransform(s));
            ;
        }

        in.close();
        out.close();
    }

    public static String caseTransform(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        StringBuilder[] builders = new StringBuilder[4];
        for (int i = 0; i < 4; ++i) {
            builders[i] = new StringBuilder(n + 1);
        }
        // style 1 PascalCaseTest
        boolean isNewPattern = true;
        boolean isFirst = true;
        for (int i = 0; i < n; ++i) {
            if (Character.isUpperCase(sc[i]) || isNewPattern) {
                if (!isFirst) {
                    builders[2].append("_");
                    builders[3].append("-");
                }
                char upper = Character.toUpperCase(sc[i]), lower = Character.toLowerCase(sc[i]);
                builders[0].append(upper);
                if (isFirst) {
                    builders[1].append(lower);
                } else {
                    builders[1].append(upper);
                }

                builders[2].append(lower);
                builders[3].append(lower);
                isNewPattern = false;
                isFirst = false;
            } else if (sc[i] == '-' || sc[i] == '_') {
                isNewPattern = true;
            } else {
                builders[0].append(sc[i]);
                builders[1].append(sc[i]);
                builders[2].append(sc[i]);
                builders[3].append(sc[i]);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 3; ++i) {
            ans.append(builders[i] + " ");
        }
        ans.append(builders[3]);
        return ans.toString();
    }
}
