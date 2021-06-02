package newcoder.tencent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * SplitArray class
 *
 * @author Soarkey
 * @date 2021/4/4
 */
public class SplitArray {
    private static int ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            ans = 0;
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            dfs(arr, 0, n - 1);
            ans -= Arrays.stream(arr).sum();
            out.println(ans);
        }

        in.close();
        out.close();
    }

    public static void dfs(int[] arr, int left, int right) {
        if (left == right) {
            ans += arr[left];
            return;
        }
        int mid = Arrays.binarySearch(arr, (arr[left] + arr[right]) >>> 1);
        for (int i = left; i <= right; ++i) {
            ans += arr[i];
        }
        dfs(arr, left, mid);
        dfs(arr, mid + 1, right);
    }
}
