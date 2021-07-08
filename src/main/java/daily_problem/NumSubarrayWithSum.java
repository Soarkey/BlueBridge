package daily_problem;

/**
 * NumSubarrayWithSum
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 *
 * @author Soarkey
 * @date 2021/7/8
 */
public class NumSubarrayWithSum {
    public static void main(String[] args) {
        NumSubarrayWithSum n = new NumSubarrayWithSum();
        int[][] nums = {{1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}};
        int[] goals = {2, 0};
        for (int i = 0; i < goals.length; ++i) {
            System.out.println(n.numSubarraysWithSum(nums[i], goals[i]));
        }

    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // 滑动窗口
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0, ans = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ans += left2 - left1;
            right++;
        }
        return ans;
    }
}
