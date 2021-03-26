package newcoder.vivio;

import java.util.*;

/**
 * CompileDependency class
 *
 * @author Soarkey
 * @date 2021/3/25
 */
public class CompileDependency {
    public static void main(String[] args) {
        String input = "8,2,7,4,6,-1,5,5,6";
        // String input = "-1,-1";
        // String input = "1,2,-1,1";

        String[] items = input.split(",");
        int n = items.length;
        int[] pre = new int[n];

        PriorityQueue<Integer> queue = new PriorityQueue<>(n);

        boolean[] vis = new boolean[n];
        for (int i = n - 1; i >= 0; --i) {
            pre[i] = Integer.parseInt(items[i]);
            if (pre[i] == -1) {
                queue.offer(i);
            }
        }

        StringBuilder builder = new StringBuilder(2 * n);

        while (!queue.isEmpty()) {
            Integer e = queue.poll();
            vis[e] = true;
            builder.append(e + ",");

            for (int i = n - 1; i >= 0; --i) {
                if (!vis[i] && pre[i] == e) {
                    pre[i] = -1;
                    queue.offer(i);
                }
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }
}
