package newcoder.bytedance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * 字节跳动2018校招后端方向（第二批）
 * 手串
 *
 * 滑动窗口
 *
 * @author Soarkey
 * @date 2021/3/6
 */
public class Bracelets {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int c = in.nextInt();

            int[] color = new int[c + 1];
            List<List<Integer>> bracelets = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                int x = in.nextInt();
                List<Integer> item = new ArrayList<>(x);
                while (x-- != 0) {
                    item.add(in.nextInt());
                }
                bracelets.add(item);
            }

            // System.out.println(bracelets);

            // 滑动窗口
            int left = 0, right = 0;
            Map<Integer, Integer> map = new HashMap<>(c);
            while (left < n) {
                while ((right - left + n) % n < m) {
                    List<Integer> item = bracelets.get(right);
                    for (Integer i : item) {
                        ++color[i];
                        if (color[i] >= 2) {
                            map.put(i, 1);
                        }
                    }
                    right = (right + 1) % n;
                }

                // = m
                for (Integer i : bracelets.get(left)) {
                    --color[i];
                }
                ++left;
            }
            out.println(map.keySet().size());
        }

        in.close();
        out.close();
    }
}
