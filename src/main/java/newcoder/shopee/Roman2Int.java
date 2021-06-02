package newcoder.shopee;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman2Int class
 *
 * @author Soarkey
 * @date 2021/3/26
 */
public class Roman2Int {
    public static void main(String[] args) {
        // String s = "III";
        String s = "IX";
        // String s = "LVIII";

        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] sc = s.toCharArray();
        int n = sc.length;
        int ans = 0, cur, next;
        for (int i = 0; i < n; ) {
            cur = map.get(sc[i]);
            next = i + 1 < n ? map.get(sc[i + 1]) : 0;

            if (cur < next) {
                ans += next - cur;
                i += 2;
            } else {
                ans += cur;
                ++i;
            }
        }

        System.out.println(ans);
    }
}
