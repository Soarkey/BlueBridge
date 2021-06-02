package practice;

import java.util.Scanner;

/**
 * BallGame class
 * <p>
 * 取球游戏
 * 今盒子里有n 个小球，A、B 两人轮流从盒中取球，每个人都可以看到另一个人取了多少个，
 * 也可以看到盒中还剩下多少个，并且两人都很聪明，不会做出错误的判断。
 * 我们约定：
 * 每个人从盒子中取出的球的数目必须是：1，3，7 或者8 个。
 * 轮到某一方取球时不能弃权！
 * A 先取球，然后双方交替取球，直到取完。
 * 被迫拿到最后一个球的一方为负方（输方）
 * 请编程确定出在双方都不判断失误的情况下，对于特定的初始球数，A 是否能赢？
 * 程序运行时，从标准输入获得数据，其格式如下：
 * 先是一个整数n(n<100)，表示接下来有n 个整数。然后是n 个整数，每个占一行（整数<10000），表示初始球数。
 * 程序则输出n 行，表示A 的输赢情况（输为0，赢为1）。
 * 例如，用户输入：
 * 4
 * 1
 * 2
 * 10
 * 18
 * 则程序应该输出：
 * 0
 * 1
 * 1
 * 0
 *
 * @author Soarkey
 * @date 2018/2/24
 */
public class BallGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- != 0) {
            int num = in.nextInt();
            System.out.println(game(num));
        }
    }

    public static boolean array[] = new boolean[10020];

    static {
        array[0] = true;
        for (int i = 1; i < array.length; i++) {
            // 自己拿取1,3,7,8之后对手不会胜利 即为 先手胜利
            array[i] = (i >= 8 && !array[i - 8])
                    || (i >= 7 && !array[i - 7])
                    || (i >= 3 && !array[i - 3])
                    || (i >= 1 && !array[i - 1]);
        }
    }

    public static int game(int num) {
        return array[num] ? 1 : 0;
    }
}
