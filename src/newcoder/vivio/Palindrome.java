package newcoder.vivio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Palindrome class
 *
 * @author Soarkey
 * @date 2021/3/25
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            String s = in.nextLine();
            char[] sc = s.toCharArray();
            int n = sc.length;

            int left = 0, right = n - 1, k = 0, index = -1;
            boolean isFound = true;
            while (k <= 1 && left <= right) {
                if (sc[left] == sc[right]) {
                    ++left;
                    --right;
                } else {
                    if (left + 1 <= right && sc[left + 1] == sc[right]) {
                        index = left;
                        left += 2;
                        --right;
                        ++k;
                    } else if (left <= right - 1 && sc[right - 1] == sc[left]) {
                        index = right;
                        ++left;
                        right -= 2;
                        ++k;
                    } else {
                        isFound = false;
                        break;
                    }
                }
            }
            if (isFound && k <= 1) {
                if(index == -1){
                    index = n - 1;
                }
                for (int i = 0; i < n; ++i) {
                    if(i != index){
                        out.print(sc[i]);
                    }
                }
                out.println();
            } else {
                out.println("false");
            }
        }

        in.close();
        out.close();
    }
}
