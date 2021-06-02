package practice;

import java.util.Random;

/**
 * AncientGamble class
 *
 * @author Soarkey
 * @date 2018/2/21
 */
public class AncientGamble {
    public static Random random = new Random();

    public static void main(String[] args) {
        int money = 0;
        for (int i = 0; i < 500000; i++) {
            money += gamble();
        }
        System.out.printf("%.3f\n", money / 500000f);
    }

    /**
     * 模拟每一次的游戏
     *
     * @return 庄主盈利金额
     */
    public static int gamble() {
        int money = 0;
        // 玩家押注匣子 1-6
        int player = randomNumber();
        // 投掷骰子
        int a = randomNumber();
        int b = randomNumber();
        int c = randomNumber();
        // 三个骰子相同
        if (a == b && b == c && c == player) {
            money = -6;
        } else if ((a == b && b == player)
                || (b == c && c == player)
                || (a == c && c == player)) {
            // 两个骰子相同
            money = -2;
        } else if (player == a || player == b || player == c) {
            // 一个骰子相同
            money = -1;
        } else if ((a * b == c * player)
                || (a * c == b * player)
                || (b * c == a * player)) {
            // 流局
            money = 0;
        } else {
            money = 1;
        }
        return money;
    }

    /**
     * 生成1-6的随机数
     *
     * @return
     */
    public static int randomNumber() {
        return random.nextInt(6) + 1;
    }
}
