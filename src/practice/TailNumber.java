package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * TailNumber class
 * <p>
 * 手机尾号
 * 30 年的改革开放，给中国带来了翻天覆地的变化。2011 全年中国手机产量约为11.72 亿部。手机已经成为百姓的
 * 基本日用品！ 给手机选个好听又好记的号码可能是许多人的心愿。
 * 但号源有限，只能辅以有偿选号的方法了。
 * 这个程序的目的就是：根据给定的手机尾号（4 位），按照一定的规则来打分。其规则如下：
 * 1. 如果出现连号，不管升序还是降序，都加5分。例如：5678,4321 都满足加分标准。
 * 2. 前三个数字相同，或后三个数字相同，都加3 分。例如：4888,6665,7777 都满足加分的标准。
 * 注意：7777 因为满足这条标准两次，所以这条规则给它加了6 分。
 * 3. 符合AABB 或者ABAB 模式的加1 分。例如：2255,3939,7777 都符合这个模式，所以都被加分。
 * 注意：7777 因为满足这条标准两次，所以这条标准给它加了2 分。
 * 4. 含有：6，8，9 中任何一个数字，每出现一次加1 分。例如4326,6875,9918 都符合加分标准。其中，6875 被加
 * 2 分；9918 被加3 分。
 * 尾号最终得分就是每条标准的加分总和！
 * 要求程序从标准输入接收数据，在标准输出上输出结果。
 * 输入格式为：第一行是一个整数n（<100），表示下边有多少输入行，接下来是n 行4 位一组的数据，就是等待计算
 * 加分的手机尾号。
 * 例如，输入：
 * 14
 * 3045
 * ….
 * …..
 * 6789
 * 8866
 * 则输出：
 * 0
 * 0
 * ….
 * …
 * 8
 * 5
 *
 * @author Soarkey
 * @date 2018/2/18
 */
public class TailNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = in.nextInt();
        in.nextLine();
        while (n-- != 0) {
            String num = in.nextLine();
            out.println(judge(num));
            out.flush();
        }
        in.close();
        out.close();
    }

    /**
     * 判分
     * 转为字符数组来处理
     * @return
     */
    public static int judge(String num) {
        char[] arr = num.toCharArray();
        int score = 0;
        // 连号
        if (((arr[3] - arr[2]) == (arr[2] - arr[1]))
                && ((arr[2] - arr[1]) == (arr[1] - arr[0]))) {
            score += 5;
        }
        //前三个数字
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            score += 3;
        }
        //后三个数字
        if (arr[3] == arr[1] && arr[1] == arr[2]) {
            score += 3;
        }
        // AABB
        if (arr[0] == arr[1] && arr[2] == arr[3]) {
            score += 1;
        }
        // ABAB
        if (arr[0] == arr[2] && arr[1] == arr[3]) {
            score += 1;
        }
        // 含6,8,9
        char t;
        for (int i = 0; i < 4; i++) {
            t = arr[i];
            if (t == '6' || t == '8' || t == '9') {
                score += 1;
            }

        }
        return score;
    }
}
