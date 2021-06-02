package newcoder.bilibili;

/**
 * Point24
 *
 * @author Soarkey
 * @date 2021/6/1
 */
public class Point24 {
    public static void main(String[] args) {
        int[][] arrs = {
                {7, 2, 1, 10},
                {8, 2, 4, 5}
        };
        for (int[] arr : arrs) {
            System.out.println(Game24Points(arr));
        }
    }

    /**
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public static boolean Game24Points(int[] arr) {
        // write code here
        int n = arr.length;
        float[] stack = new float[n];
        int top = -1;
        for (int k : arr) {
            stack[++top] = k;
        }
        return dfs(stack, top);
    }

    public static boolean dfs(float[] nums, int top) {
        int n = nums.length;
        if (top == -1) {
            return false;
        }
        if (top == 0) {
            return Math.abs(nums[top] - 24) < 1e-7;
        }

        boolean flag = false;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                float n1 = nums[i], n2 = nums[j];
                for (int k = 0; k < n; ++k) {
                    if (k != i && k != j) {

                    }
                }
            }
        }

        return false;
    }

}
