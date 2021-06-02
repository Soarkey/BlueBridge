package newcoder.aurora;

/**
 * NotInSeq class
 * 数组中所有的数范围都属于0-n,找出0-n中第一个未出现的数
 *
 * @author Soarkey
 * @date 2021/3/24
 */
public class NotInSeq {
    public static void main(String[] args) {
        int[] input = {0, 1, 2, 4, 5, 6, 7};

        // -------------------- begin -------------------- //
        int n = input.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            hash[input[i]] = 1;
        }

        for (int i = 0; i <= n; ++i) {
            if (hash[i] == 0) {
                System.out.println(i);
                return;
            }
        }
        // -------------------- end -------------------- //
    }
}
