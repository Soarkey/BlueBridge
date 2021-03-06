package newcoder.bytedance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * 字节跳动2018校招后端方向（第二批）
 * 用户喜好
 *
 * @author Soarkey
 * @date 2021/3/6
 */
public class UserPreference {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));


        while (in.hasNextInt()) {
            int n = in.nextInt();
            Map<Integer, TreeSet<Integer>> map = new HashMap<>(n);

            for (int i = 1; i <= n; ++i) {
                int like = in.nextInt();
                TreeSet<Integer> treeSet = map.getOrDefault(like, new TreeSet<>());
                treeSet.add(i);
                map.put(like, treeSet);
            }

            // query
            int q = in.nextInt();
            for (int i = 0; i < q; ++i) {
                int l = in.nextInt();
                int r = in.nextInt();
                int k = in.nextInt();

                int ans = 0;
                if (map.containsKey(k)) {
                    ans = map.get(k).subSet(l, r + 1).size();
                }
                out.println(ans);
            }
        }

        in.close();
        out.close();
    }
}
