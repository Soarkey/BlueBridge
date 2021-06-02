package newcoder.netease;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * MosCode class
 *
 * @author Soarkey
 * @date 2021/3/29
 */
public class MosCode {
    private static int ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            String s = in.nextLine();
            char[] sc = s.toCharArray();
            ans = 0;
            dfs(sc, 0);
            out.println(ans);
        }

        in.close();
        out.close();
    }

    public static void dfs(char[] sc, int depth) {
        int n = sc.length;
        if (depth == n) {
            ++ans;
            return;
        }

        // 替换1位
        dfs(sc, depth + 1);
        // 替换2位
        if (depth + 1 < n) {
            if (sc[depth] == '1') {
                dfs(sc, depth + 2);
            }
        }
        // 替换3位
        if(depth + 2 < n) {
            if(sc[depth] == '1' && sc[depth + 1] == '0'){
                dfs(sc, depth + 3);
            }
            if(sc[depth] == '1' && sc[depth + 1] == '1'){
                dfs(sc, depth + 3);
            }
        }
    }
}
