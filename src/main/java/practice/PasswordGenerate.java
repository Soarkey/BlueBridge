package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * PasswordGenerate class
 * <p>
 * 密码发生器
 * 在对银行账户等重要权限设置密码的时候，我们常常遇到这样的烦恼：如果为了好记用生日吧，
 * 容易被破解，不安全；如果设置不好记的密码，又担心自己也会忘记；如果写在纸上，担心纸张被别人发现或弄丢
 * 了...
 * 这个程序的任务就是把一串拼音字母转换为6 位数字（密码）。
 * 我们可以使用任何好记的拼音串(比如名字，王喜明，就写：wangximing)作为输入，程序输出6 位数字。
 * 变换的过程如下：
 * 第一步. 把字符串6 个一组折叠起来，比如wangximing 则变为：
 * wangxi
 * ming
 * 第二步. 把所有垂直在同一个位置的字符的ascii 码值相加，得出6 个数字，如上面的例子，则得出：
 * 228 202 220 206 120 105
 * 第三步. 再把每个数字“缩位”处理：就是把每个位的数字相加，得出的数字如果不是一位数字，
 * 就再缩位，直到变成一位数字为止。例如: 228 => 2+2+8=12 => 1+2=3
 * 上面的数字缩位后变为：344836, 这就是程序最终的输出结果！
 * 要求程序从标准输入接收数据，在标准输出上输出结果。
 * 输入格式为：第一行是一个整数n（<100），表示下边有多少输入行，接下来是n 行字符串，就是等待变换的字符串。
 * 输出格式为：n 行变换后的6 位密码。
 * 例如，输入：
 * 5
 * zhangfeng
 * wangximing
 * jiujingfazi
 * woaibeijingtiananmen
 * haohaoxuexi
 * 则输出：
 * 772243
 * 344836
 * 297332
 * 716652
 * 875843
 *
 * @author Soarkey
 * @date 2018/2/24
 */
public class PasswordGenerate {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = in.nextInt();
        in.nextLine();
        while (n-- != 0) {
            String s = in.nextLine();
            System.out.println(generate(s));
        }
        in.close();
        out.close();
    }

    // 答案 放在main里

    public static void answer() {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = in.nextInt();
        in.nextLine();
        String s;
        while (n-- != 0) {
            int array[] = new int[6];
            s = in.nextLine();
            for (int i = 0; i < s.length(); i++) {
                array[i % 6] += (int) (s.charAt(i));
            }
            for (int i = 0; i < 6; i++) {
                System.out.println(simplify(array[i]));
            }
        }
        in.close();
        out.close();
    }

    public static int simplify(int n) {
        String s;
        while (n >= 10) {
            s = n + "";
            n = 0;
            for (int i = 0; i < s.length(); i++) {
                n += s.charAt(i) - '0';
            }
        }
        return n;
    }

    // 自己

    public static ArrayList<String> strs = new ArrayList<>();

    public static String generate(String s) {
        strs.clear();
        String password = "";
        int len = s.length();
        int i = 0;
        // 分组
        while (i < len) {
            String sub;
            if (i + 6 < len) {
                sub = s.substring(i, i + 6);
                i += 6;
            } else {
                sub = s.substring(i);
                i = len;
            }
            strs.add(sub);
        }
        // ASCII码相加并缩位
        int[] ascii = new int[6];
        for (i = 0; i < 6; i++) {
            ascii[i] = reduceDigit(addAscii(i));
            password += ascii[i];
        }
        return password;
    }

    public static int addAscii(int i) {
        Iterator<String> iterator = strs.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.length() > i) {
                sum += s.charAt(i);
            }
        }
        return sum;
    }

    public static int reduceDigit(int n) {
        int len = (int) (Math.log10(n) + 1);
        int ans = n;
        if (len == 3) {
            ans = n / 100 + n / 10 % 10 + n % 10;
            ans = reduceDigit(ans);
        } else if (len == 2) {
            ans = n / 10 + n % 10;
            ans = reduceDigit(ans);
        }
        return ans;
    }
}
