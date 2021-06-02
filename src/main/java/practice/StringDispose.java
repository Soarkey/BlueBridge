package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * StringDispose class
 * <p>
 * 串的处理
 * 在实际的开发工作中，对字符串的处理是最常见的编程任务。
 * 本题目即是要求程序对用户输入的串进行处理。具体规则如下：
 * 1. 把每个单词的首字母变为大写。
 * 2. 把数字与字母之间用下划线字符（_）分开，使得更清晰
 * 3. 把单词中间有多个空格的调整为1个空格。
 * 例如：
 * 用户输入：
 * you and me what cpp2005program
 * 2
 * 则程序输出：
 * You And Me What Cpp_2005_program
 * 用户输入：
 * this is a 99cat
 * 则程序输出：
 * This Is A 99_cat
 * 我们假设：用户输入的串中只有小写字母，空格和数字，不含其它的字母或符号。
 * 每个单词间由1个或多个空格分隔。
 * 假设用户输入的串长度不超过200个字符。
 *
 * @author Soarkey
 * @date 2018/2/17
 */
public class StringDispose {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringBuilder s = new StringBuilder(in.nextLine());
        in.close();
        dispose(s);
        out.println(s.toString());
        out.close();
    }

    public static void dispose(StringBuilder s) {
        int len = s.length();
        // 调整句首字母大写
        char head = s.charAt(0);
        if ('a' <= head && head <= 'z') {
            s.deleteCharAt(0);
            s.insert(0, (char) (head - 32));
        }
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char temp = s.charAt(i);
            // 调整空格
            if (pre == ' ' && temp == ' ') {
                s.deleteCharAt(i);
            }
            // 首字母大写
            if ('a' <= temp && temp <= 'z' && pre == ' ') {
                // 置换大写
                s.deleteCharAt(i);
                s.insert(i, (char) (temp - 32));
            }
            // 下划线分割
            if (('0' <= pre && pre <= '9' && 'A' <= temp && temp <= 'z')
                    || ('0' <= temp && temp <= '9' && 'A' <= pre && pre <= 'z')) {
                s.insert(i, '_');
                i++;
            }
            pre = s.charAt(i);
        }
    }
}
