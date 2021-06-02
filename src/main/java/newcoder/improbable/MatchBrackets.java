package newcoder.improbable;

import java.util.HashMap;
import java.util.Map;

/**
 * MatchBrackets class
 *
 * @author Soarkey
 * @date 2021/4/10
 */
public class MatchBrackets {
    public static void main(String[] args) {
        String[] strs = {"({[]}()", "([})", "([])}", "()", "())", "({})", "([)]", "", "{()}([])", "{[()]{",
        "(cx){{cx}c}as", "{", "dsf"};
        for(String s : strs){
            System.out.println(s + ", " + validString(s));
        }
    }

    public static boolean validString(String s) {
        // write code here
        char[] sc = s.toCharArray();
        int n = sc.length;
        char[] stack = new char[n];
        int top = -1;

        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < n; ++i) {
            if(map.containsKey(sc[i])){
                if(top == -1 || stack[top] != map.get(sc[i])){
                    return false;
                }
                top--;
            } else if(sc[i] == '(' || sc[i] == '[' || sc[i] == '{') {
                stack[++top] = sc[i];
            }
        }
        return top == -1;
    }
}
