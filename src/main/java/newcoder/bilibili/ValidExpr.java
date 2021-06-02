package newcoder.bilibili;

/**
 * ValidExpr
 *
 * @author Soarkey
 * @date 2021/6/1
 */
public class ValidExpr {
    public static void main(String[] args) {
        String[] strings = {"{[]}", "([)]", "([]", "", "((((", "{}", "[]", "()", ")", "]]]"};
        for (String s : strings) {
            System.out.println(IsValidExp(s));
        }
    }

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean IsValidExp(String s) {
        // write code here
        char[] sc = s.toCharArray();
        int n = sc.length;

        char[] stack = new char[n];
        int top = -1;

        for (char c : sc) {
            if (c == ' ') {
                continue;
            }
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else {
                if (top == -1 || (c - stack[top] != 1 && c - stack[top] != 2)) {
                    return false;
                }
                --top;
            }
        }

        return top == -1;
    }
}
