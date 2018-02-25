package practice;

/**
 * ExtractSubString class
 * <p>
 * 提取子串
 * 串“abcba”以字母“c”为中心左右对称；串“abba” 是另一种模式的左右对称。
 * 这两种情况我们都称这个串是镜像串。特别地，只含有1 个字母的串，可以看成是第一种模式的镜像串。
 * 一个串可以含有许多镜像子串。我们的目标是求一个串的最大镜像子串（最长的镜像子串），
 * 如果有多个最大镜像子串，对称中心靠左的优先选中。例如：“abcdeefghhgfeiieje444k444lmn”的最大镜像子串
 * 是：“efghhgfe”
 * 下面的静态方法实现了该功能，请仔细阅读并分析代码，填写空白处的代码，使得程序的逻辑合理，结果正确。
 *
 * @author Soarkey
 * @date 2018/2/22
 */
public class ExtractSubString {
    public static void main(String[] args) {
        String s = "abcdeefghhgfeiieje444k444lmn";
        System.out.println("method 1: " + maxS(s));
        System.out.println("===================");
        System.out.println("method 2: " + getMaxMirrorString(s));
    }

    /**
     * 方法一
     *
     * @param s
     * @return
     */
    public static String maxS(String s) {
        String maxS = "";
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            // 下标标记
            int mark = 0;
            // 记录一个镜像串
            String temp = "";
            if (c[i] == c[i + 1]) {
                for (; ; ) { // abba模式
                    if ((i - mark < 0) || c[i - mark] != c[i + mark + 1]) {
                        break;
                    }
                    mark++;
                }
                temp = s.substring(i - mark + 1, i + mark + 1);
            } else if ((i + 2) < c.length && c[i] == c[i + 2]) {
                for (; ; ) { // abcba模式
                    if ((i - mark < 0) || c[i - mark] != c[i + mark + 2]) {
                        break;
                    }
                    mark++;
                }
                temp = s.substring(i - mark + 1, i + mark + 2);
            }
            if (temp.length() > maxS.length()) {
                maxS = temp;
            }
        }
        return maxS;
    }

    /**
     * 方法二
     *
     * @param s
     * @return
     */
    public static String getMaxMirrorString(String s) {
        // 所求的最大对称子串
        String max_s = "";
        for (int i = 0; i < s.length(); i++) {
            // 第一种对称模式
            int step = 1;
            try {
                for (; ; ) {
                    if (s.charAt(i - step) != s.charAt(i + step)) {
                        break;
                    }
                    step++;
                }
            } catch (Exception e) {
            }
            String s1 = s.substring(i - step + 1, i + step); // 填空1
            // 第二种对称模式
            step = 0;
            try {
                for (; ; ) {
                    if (s.charAt(i - step) != s.charAt(i + step + 1)) {
                        break; // 填空2
                    }
                    step++;
                }
            } catch (Exception e) {
            }
            String s2 = s.substring(i - step + 1, i + step + 1);
            if (s1.length() > max_s.length()) {
                max_s = s1;
            }
            if (s2.length() > max_s.length()) {
                max_s = s2;
            }
        }
        return max_s;
    }
}
