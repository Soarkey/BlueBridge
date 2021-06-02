package newcoder.vivio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * GameMapBestPath class
 *
 * @author Soarkey
 * @date 2021/3/25
 */
public class GameMapBestPath {
    private static int minPath;
    private static int[][] data;
    private static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));


        while (in.hasNextInt()) {
            int n = in.nextInt();
            int startX = in.nextInt();
            int startY = in.nextInt();
            int endX = in.nextInt();
            int endY = in.nextInt();

            in.nextLine();
            data = new int[n][n];
            for (int i = 0; i < n; ++i) {
                String line = in.nextLine();
                char[] lc = line.toCharArray();
                for (int j = 0; j < lc.length; ++j) {
                    if (lc[j] == '#' || lc[j] == '@') {
                        data[i][j] = 1;
                    }
                }
            }

            Queue<Integer> queue = new ArrayDeque<>(n * n);
            queue.add(startX);
            queue.add(startY);


        }

        in.close();
        out.close();
    }

    public static void dfs(int x, int y, int endX, int endY, int depth) {
        if (x == endX && y == endY) {
            minPath = Math.min(minPath, depth);
            return;
        }

        // 剪枝
        if (depth >= minPath) {
            return;
        }

        // 向四个方向移动
        // ↑
        if (x - 1 >= 0 && data[x - 1][y] == 0) {
            dfs(x - 1, y, endX, endY, depth + 1);
        }
        // ↓
        if (x + 1 < N && data[x + 1][y] == 0) {
            dfs(x + 1, y, endX, endY, depth + 1);
        }
        // ←
        if (y - 1 >= 0 && data[x][y - 1] == 0) {
            dfs(x, y - 1, endX, endY, depth + 1);
        }
        // →
        if (y + 1 < N && data[x][y + 1] == 0) {
            dfs(x, y + 1, endX, endY, depth + 1);
        }
    }

}
