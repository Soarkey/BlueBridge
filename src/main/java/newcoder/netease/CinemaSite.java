package newcoder.netease;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * CinemaSite class
 *
 * @author Soarkey
 * @date 2021/3/29
 */
public class CinemaSite {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            String[] line = in.nextLine().split(" ");

            int n = line.length;
            int[] site = new int[n + 2];
            site[0] = site[n + 1] = -1;
            for (int i = 1; i <= n; i++) {
                site[i] = Integer.parseInt(line[i - 1]);
            }
            // System.out.println(Arrays.toString(site));

            int[] dist = new int[n];
            int left = 1, right = n, ans = Integer.MIN_VALUE;
            // -->
            for (int i = 1; i <= n; i++) {
                if (site[i] == 1) {
                    left = i;
                } else {
                    dist[i] = i - left;
                }
            }

            // <--
            for (int i = n; i >= 1; i--) {
                if (site[i] == 1) {
                    right = i;
                } else {
                    dist[i] = Math.max(dist[i], right - i);
                    ans = Math.max(dist[i], ans);
                }
            }

            // System.out.println(Arrays.toString(dist));
            out.println(ans);
        }

        in.close();
        out.close();
    }
}
