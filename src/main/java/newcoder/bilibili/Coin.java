package newcoder.bilibili;

/**
 * Coin
 *
 * @author Soarkey
 * @date 2021/6/1
 */
public class Coin {
    public static void main(String[] args) {
        int[] N = {200, 1, 1024, 656};
        for (int n : N) {
            System.out.println(GetCoinCount(n));
        }
    }

    /**
     * @param N int整型
     * @return int整型
     */
    public static int GetCoinCount(int N) {
        // write code here
        N = 1024 - N;
        int ans = 0;
        int[] coins = {64, 16, 4, 1};
        for (int i = 0; i < coins.length; ++i) {
            ans += N / coins[i];
            N %= coins[i];
        }
        return ans;
    }
}
