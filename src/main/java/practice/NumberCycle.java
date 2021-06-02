package practice;

import java.util.Random;

/**
 * NumberCycle class
 * 数量周期
 * <p>
 * 复杂现象背后的推动力，可能是极其简单的原理。科学的目标之一就是发现纷
 * 繁复杂的自然现象背后的简单法则。爱因斯坦的相对论是这方面的典范例证。
 * 很早的时候，生物学家观察某区域某种昆虫的数量（称为虫口数）之逐年变化规律，
 * 就十分迷惑：有的时候是逐渐增多达到一个平衡值。有的时候在两个数字间周期跳动。
 * 有的时候则进入一片混乱，类似随机数字一样变化（称为混沌现象）。
 * 慢慢地，人们从数学中更清晰地观察到了这一现象，并因此开创了：符号动力学、非线性动力学等研究领域。
 * 一个著名的虫口数目简化模型如下：
 * x' = x * (1 - x) * r
 * 这里，x x' r 都是浮点数。
 * 其中，x 表示当年的虫口数，x' 表示下一年的虫口数。
 * 它们的取值范围在 0 与 1 之间，实际上表示的是：虫口的总数占环境所能支持的最大数量的比率。
 * r 是常数（环境参数），r 的取值范围在 [0,4]。
 * 令人惊讶的是：这个简单的迭代公式有着不同寻常的神秘性质！
 * 一般来说，多次迭代后，虫口数的稳定模式与x 的初始值无关，而与 r 有关！
 * 例如：无论x 初始值是多少，当 r = 2.5 的时候，x 多次迭代后会趋向于 0.6。
 * 而当 r = 3.2 的时候，x 的值会趋向于在 0.799 与 0.513 之间周期性摆动。
 * 那么，r = 3.62 的时候，你观察到有什么周期现象发生吗？
 * 不需要提交源代码，只要写出你的结论即可！
 * <p>
 * <p>
 * 结论：
 * 虫口数目函数呈锯齿状变化，虫口数目不存在连续两年增加和连续两年减少的情况。
 *
 * @author Soarkey
 * @date 2018/2/22
 */
public class NumberCycle {

    public static void main(String[] args) {
        r = 3.62f;
        Random random = new Random();
        float x = random.nextFloat();
        int n = 1000;
        nextYear(x, n);
    }

    public static float r;

    public static void nextYear(float x, int n) {
        if (n == 0) {
            return;
        }
        float nextX = x * (1 - x) * r;
        System.out.println((1000 - n) + ":" + nextX);
        nextYear(nextX, --n);
    }
}
