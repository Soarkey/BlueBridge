package practice;

/**
 * HolmesFormula class
 *
 * @author Soarkey
 * @date 2018/2/24
 */
public class HolmesFormula {
    public static int[] n = new int[6];
    public static boolean[] used = new boolean[10];

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == 6) {
            int a = n[0] * 10000 + n[1] * 1000 + n[2] * 100 + n[3] * 10 + n[4];
            int left = a * n[5];
            int right = n[4] * 10000 + n[3] * 1000 + n[2] * 100 + n[1] * 10 + n[0];
            if (left == right) {
                System.out.printf("%d%d%d%d%d*%d=%d%d%d%d%d", n[0], n[1], n[2], n[3], n[4], n[5], n[4], n[3], n[2], n[1], n[0]);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if ((depth == 0 || depth == 5) && i == 0) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                n[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }
}
