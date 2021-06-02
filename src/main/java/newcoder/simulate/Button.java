package newcoder.simulate;

/**
 * Button class
 *
 * @author Soarkey
 * @date 2021/3/18
 */
public class Button {
    private static int ans = 0;

    public static void main(String[] args) {
        // int[] a = new int[]{1, 1, 4, 5, 1, 4};
        int[] buttons = new int[]{2, 2, 2};
        int n = buttons.length;
        int[] k = new int[n];
        int ans = 0;
        for(int i=0; i<n; ++i){
            k[i] = i;
            if(buttons[i] > 1){
                ans += buttons[i] - 1;

            }
        }
        System.out.println(ans);
    }

    public static void dfs(int[] arr, int depth) {
        System.out.println("dfs " + depth + ",");
        int n = arr.length;
        if (depth == n - 1) {
            return;
        }

        for (int i = 0; i < arr[i]; ++i) {
            if (i == arr[i] - 1) {
                ++ans;
                dfs(arr, depth + 1);
            } else {
                ++ans;
            }
        }
    }
}
