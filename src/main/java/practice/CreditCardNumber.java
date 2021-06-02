package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * CreditCardNumber class
 * <p>
 * 输入信用卡号码
 * 当你输入信用卡号码的时候，有没有担心输错了而造成损失呢？其实可以不必这么担心，
 * 因为并不是一个随便的信用卡号码都是合法的，它必须通过Luhn 算法来验证通过。
 * 该校验的过程：
 * 1、从卡号最后一位数字开始，逆向将奇数位(1、3、5 等等)相加。
 * 2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去9），再求和。
 * 3、将奇数位总和加上偶数位总和，结果应该可以被10 整除。
 * 例如，卡号是：5432123456788881
 * 则奇数、偶数位（用红色标出）分布：5432123456788881
 * 奇数位和=35
 * 偶数位乘以2（有些要减去9）的结果：1 6 2 6 1 5 7 7，求和=35。
 * 最后35+35=70 可以被10 整除，认定校验通过。
 * 请编写一个程序，从键盘输入卡号，然后判断是否校验通过。通过显示：“成功”，否则显示“失败”。
 * 比如，用户输入：356827027232780
 * 程序输出：成功
 *
 * @author Soarkey
 * @date 2018/2/25
 */
public class CreditCardNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        String cardNumber = in.nextLine();
        out.println(judge(cardNumber));
        in.close();
        out.close();
    }

    public static int[] evenAns = new int[10];

    static {
        int t;
        for (int i = 0; i < 10; i++) {
            t = i * 2;
            if (t / 10 > 0) {
                t -= 9;
            }
            evenAns[i] = t;
        }
    }

    public static String judge(String s) {
        char[] c = s.toCharArray();
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                //偶数
                evenSum += evenAns[c[i] - '0'];
            } else {
                //奇数
                oddSum += c[i] - '0';
            }
        }
        if ((evenSum + oddSum) % 10 == 0) {
            return "成功";
        }
        return "失败";
    }
}
