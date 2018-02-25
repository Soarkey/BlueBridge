package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateCalculate class
 * <p>
 * 输入日期
 * 从键盘输入一个日期，格式为yyyy-M-d
 * 要求计算该日期与1949 年10 月1 日距离多少天
 * 例如：
 * 用户输入了：1949-10-2
 * 程序输出：1
 * 用户输入了：1949-11-1
 * 程序输出：31
 *
 * @author Soarkey
 * @date 2018/2/25
 */
public class DateCalculate {
    public static void main(String[] args) {
        String a = "1949-10-1";
        String b = "1949-11-1";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date preDate;
        Date nowDate;
        long days = 0;
        try {
            preDate = simpleDateFormat.parse(a);
            nowDate = simpleDateFormat.parse(b);
            days = Math.abs(nowDate.getTime() - preDate.getTime()) / (1000 * 3600 * 24);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(days);
    }
}
