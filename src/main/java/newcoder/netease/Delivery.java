package newcoder.netease;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Delivery class
 *
 * @author Soarkey
 * @date 2021/3/29
 */
public class Delivery {
    private static int time;
    private static int ans;


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        while (in.hasNext()) {
            int N = in.nextInt();
            int K = in.nextInt();
            int M = in.nextInt();

            int[][] graph = new int[N][N];
            for (int i = 0; i < M; i++) {
                graph[in.nextInt() - 1][in.nextInt() - 1] = in.nextInt();
            }

            boolean[] vis = new boolean[N];
            time = 0;
            ans = -1;
            dfs(graph, vis, N, K - 1, 0);
            boolean isAllVis = true;
            for (int i = 0; i < N; i++) {
                if (!vis[i]) {
                    isAllVis = false;
                    break;
                }
            }
            if(isAllVis) {
                out.println(ans);
            } else {
                out.println(-1);
            }
        }

        in.close();
        out.close();
    }

    public static void dfs(int[][] graph, boolean[] vis, int N, int x, int times) {
        int k = 0;
        for (int j = 0; j < N; ++j) {
            if (!vis[j] && graph[x][j] > 0) {
                vis[j] = true;
                dfs(graph, vis, N, j, times + graph[x][j]);
                vis[j] = false;
            } else {
                ++k;
            }
        }

        if (k == N) {
            ans = Math.max(ans, times);
        }
    }
}
