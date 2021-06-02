package newcoder.envision;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * NearestK class
 *
 * @author Soarkey
 * @date 2021/3/7
 */
public class NearestK {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            String line = in.nextLine();
            int repeat = 0;
            while ("".equals(line)) {
                ++repeat;
                line = in.nextLine();
            }
            //使用正则表达式将字符串分割 “\\s+”表示多个空格
            String a[] = line.split(",");
            int[] arr = str2int(a);
            int k = in.nextInt();
            int x = in.nextInt();

            int left = 0, right = arr.length - k;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (x - arr[mid] > arr[mid + k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            for (int i = left; i < k - 1; ++i) {
                out.print(arr[i] + ",");
            }
            out.println(arr[k - 1]);
        }

        in.close();
        out.close();
    }

    public static int[] str2int(String[] arr) {
        int[] ans = new int[arr.length];
        int i = 0;
        for (String s : arr) {
            ans[i++] = Integer.parseInt(s);
        }
        return ans;
    }
}
