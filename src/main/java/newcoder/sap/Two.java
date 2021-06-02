package newcoder.sap;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Two class
 *
 * @author Soarkey
 * @date 2021/4/22
 */
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int d = in.nextInt();
            in.nextLine();
            char[][] map = new char[n][m];
            for (int i = 0; i < n; ++i) {
                char[] line = in.nextLine().toCharArray();
                map[i] = line;
            }

            dfs(map, 0, 0);
        }

        in.close();
        out.close();
    }

    public static void dfs(char[][] map, int x, int y){
        if(map[x][y] == '*'){
            return;
        }


    }
}
