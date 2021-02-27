package newcoder.meituan;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第10场)
 * 公司食堂
 *
 * @author Soarkey
 * @date 2021/2/27
 */
public class CompanyCanteen {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T, N, M;
        T =  in.nextInt();
        in.nextLine();
        while (T-- != 0) {
            N = in.nextInt();
            in.nextLine();
            String already = in.nextLine();
            M = in.nextInt();
            in.nextLine();
            String queue = in.nextLine();

            // 构建优先队列
            PriorityQueue<Integer> one = new PriorityQueue<>(N);
            PriorityQueue<Integer> zero = new PriorityQueue<>(N);

            for (int i = 0; i < N; ++i) {
                if (already.charAt(i) == '1') {
                    one.offer(i);
                } else if (already.charAt(i) == '0') {
                    zero.offer(i);
                }
            }

            char[] qc = queue.toCharArray();
            for (int i = 0; i < qc.length; ++i) {
                char c = qc[i];
                if (c == 'M') {
                    // Male, 优先选1
                    if(!one.isEmpty()){
                        out.println(one.poll() + 1);
                    } else {
                        int index = zero.peek();
                        out.println(zero.poll() + 1);
                        one.offer(index);
                    }
                } else {
                    // Female, 优先选0
                    if(!zero.isEmpty()){
                        int index = zero.peek();
                        out.println(zero.poll() + 1);
                        one.offer(index);
                    } else {
                        out.println(one.poll() + 1);
                    }
                }
            }

            out.flush();
        }

        in.close();
        out.close();
    }
}
