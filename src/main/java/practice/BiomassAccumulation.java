package practice;

/**
 * BiomassAccumulation class
 * <p>
 * 微生物增殖
 * 假设有两种微生物 X 和 Y
 * X 出生后每隔3 分钟分裂一次（数目加倍），Y 出生后每隔2 分钟分裂一次（数目加倍）。
 * 一个新出生的X，半分钟之后吃掉1 个Y，并且，从此开始，每隔1 分钟吃1 个Y。
 * 现在已知有新出生的 X=10, Y=89，求60 分钟后Y 的数目。
 * 如果X=10，Y=90 呢？
 *
 * 本题的要求就是写出这两种初始条件下，60 分钟后Y 的数目。
 * 题目的结果令你震惊吗？这不是简单的数字游戏！真实的生物圈有着同样脆弱的性质！也许因为你消灭的那只 Y 就
 * 是最终导致 Y 种群灭绝的最后一根稻草！
 *
 * @author Soarkey
 * @date 2018/2/24
 */
public class BiomassAccumulation {
    public static void main(String[] args) {
        calc(0, 90, 60);
        calc(10, 0, 60);
        calc(10, 89, 60);
        calc(10, 90, 60);
    }

    public static void calc(int px, int py, int minute) {
        int numX = px, numY = py;
        System.out.println("1:" + numX + "," + numY);
        for (int i = 2; i <= minute * 2; i++) {
            if (numY <= 0) {
                numY = 0;
                break;
            }
            if (px != 0) {
                if (i % 2 == 0) {
                    // 当为整数分钟时,最初数目的生物X将进食同等数目的生物Y
                    numY -= px;
                } else if (i % 2 == 1) {
                    //当为半数分钟的奇数倍时,由最初的生物X增值产生的生物X将进食同等数目的生物Y
                    numY -= (numX - px);
                }
            }
            if (i % 6 == 0) {
                //三分钟的整数倍,生物X增值一倍
                numX *= 2;
            }
            if (i % 4 == 0) {
                //两分钟的整数倍,生物Y增值一倍
                numY *= 2;
            }
        }
        System.out.println("2:" + numX + "," + numY);
    }

}
