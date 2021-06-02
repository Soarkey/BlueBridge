package newcoder.shopee;

/**
 * ValidString class
 *
 * @author Soarkey
 * @date 2021/3/26
 */
public class ValidString {
    public static void main(String[] args) {
        String[] s = {"()", "(*)", "(*))"};
        for (String i : s) {
            System.out.println(checkValidString(i));
        }
    }

    public static boolean checkValidString(String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] sc = s.toCharArray();
        int n = sc.length;
        int left = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            //从左向右
            left += sc[i] == ')' ? -1 : 1;
            //从右向左
            right += sc[n - 1 - i] == '(' ? -1 : 1;
            if (left < 0 || right < 0)
                return false;
        }
        System.out.println(left + "," + right);
        return true;
    }
}
