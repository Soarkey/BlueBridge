package newcoder.中兴.one;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * C class
 *
 * @author Soarkey
 * @date 2021/4/24
 */
public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n = in.nextInt();
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; ++i) { // i 代表序号
                int t = in.nextInt(); // 任务难度
                if (!map.containsKey(t)) {
                    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
                    queue.offer(i);
                    map.put(t, queue);
                } else {
                    // 存在，进入map
                    map.get(t).offer(i);
                }

                if (map.size() == 5) {
                    int[] nums = new int[5];
                    int k = 0;

                    for (int m = 1; m <= 5; ++m) {
                        nums[k++] = map.get(m).poll();
                    }

                    StringBuilder builder = new StringBuilder();
                    for (int num : nums) {
                        builder.append(num + " ");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    out.println(builder);

                    Iterator<Integer> iter = map.keySet().iterator();
                    while (iter.hasNext()) {
                        Integer key = iter.next();
                        if (map.get(key).isEmpty()) {
                            iter.remove();
                        }
                    }
                } else {
                    out.println(-1);
                }
            }
        }

        in.close();
        out.close();
    }
}
