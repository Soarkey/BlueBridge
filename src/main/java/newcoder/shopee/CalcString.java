package newcoder.shopee;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * CalcString class
 *
 * @author Soarkey
 * @date 2021/3/26
 */
public class CalcString {
    public static void main(String[] args) {
        String str = "3*[a2*[c]]";
        // String str = "10*[a]";
        // String str = "3*[42*[2]]";

        char[] sc = str.toCharArray();
        int n = sc.length;
        char[] ch = new char[1_0000_0000];
        int topChar = -1;
        int[] num = new int[n];
        int topNum = -1;

        Deque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if(Character.isDigit(sc[i])){
                int t = sc[i] - '0';
                while (Character.isDigit(sc[++i])){
                    t = t * 10 + sc[i] - '0';
                }
                num[++topNum] = t;
            } else if (sc[i] == ']') {
                // repeat num[topNum] times
                while (ch[topChar] != '[') {
                    queue.push(ch[topChar--]);
                }
                // pop [
                topChar--;
                // repeat
                int k = num[topNum--];
                for (int j = 0; j < k; ++j) {
                    for (Character c : queue) {
                        ch[++topChar] = c;
                    }
                }
                queue.clear();
            } else {
                ch[++topChar] = sc[i];
            }
        }

        System.out.println(new String(ch, 0, topChar + 1));
    }
}
