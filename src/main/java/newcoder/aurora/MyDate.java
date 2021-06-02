package newcoder.aurora;

import java.util.ArrayList;

/**
 * MyDate class
 * 给定year,month,dayOfWeek三个数，输出整个月的日历表，
 * 这里注意没有日期的地方需要填空字符串
 *
 * @author Soarkey
 * @date 2021/3/24
 */
public class MyDate {
    public static void main(String[] args) {
        int year = 2020;
        int month = 2;
        int dayOfWeek = 6;

        // -------------------- begin -------------------- //
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int daysOfMonth;
        switch (month) {
            case 2:
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    daysOfMonth = 29;
                } else {
                    daysOfMonth = 28;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysOfMonth = 31;
                break;
            default:
                daysOfMonth = 30;
        }

        int k = 1;
        ArrayList<String> firstWeek = new ArrayList<>(7);
        for (int j = 1; j <= 7; ++j) {
            if (j < dayOfWeek) {
                firstWeek.add("");
            } else {
                firstWeek.add(k++ + "");
            }
        }
        ans.add(firstWeek);
        while (k <= daysOfMonth) {
            ArrayList<String> week = new ArrayList<>(7);
            for (int j = 1; j <= 7; ++j) {
                if (k <= daysOfMonth) {
                    week.add(k++ + "");
                } else {
                    week.add("");
                }
            }
            ans.add(week);
        }

        System.out.println(ans);
        // -------------------- end -------------------- //
    }
}
