package newcoder.中兴.one;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * A class
 *
 * @author Soarkey
 * @date 2021/4/24
 */
public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int h = in.nextInt(); // 本身
            int u = in.nextInt(); // target
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < n; ++i) {
                queue.offer(in.nextInt());
            }

            if(h >= u){
                out.println(0);
                continue;
            }

            int k = 0;
            while (!queue.isEmpty()){
                h += queue.poll();
                ++k;
                if(h >= u){
                    break;
                }
            }

            out.println(k);
        }

        in.close();
        out.close();
    }
}
