package practice;

import java.util.Stack;

/**
 * Bracket class
 *
 * @author Soarkey
 * @date 2018/2/18
 */
public class Bracket {
    public static void main(String[] args) {
        System.out.println(isGoodBracket("...(..[.)..].{.(..).}..."));
        System.out.println(isGoodBracket("...(..[...].(.).).{.(..).}..."));
        System.out.println(isGoodBracket(".....[...].(.).){.(..).}..."));
        System.out.println(isGoodBracket("...(..[...].(.).){.(..)...."));
    }

    public static boolean isGoodBracket(String s) {
        Stack<Character> a = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') a.push(')');
            if (c == '[') a.push(']');
            if (c == '{') a.push('}');
            if (c == ')' || c == ']' || c == '}') {
                if (a.size() == 0)
                    return false; // 填空
                if (a.pop() != c)
                    return false;
            }
        }
        if (a.size() != 0)
            return false;
        // 填空
        return true;
    }
}
