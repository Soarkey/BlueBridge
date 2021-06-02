package newcoder.improbable;

/**
 * RemoveCardsInCircle class
 *
 * @author Soarkey
 * @date 2021/4/10
 */
public class RemoveCardsInCircle {
    public static void main(String[] args) {
        System.out.println(solution(10, 3));
    }

    public static int solution(int N, int K) {
        // write code here
        int t = 0;
        for (int i = 2; i <= N; ++i) {
            t = (t + K) % i;
        }
        return t + 1;
    }
}
