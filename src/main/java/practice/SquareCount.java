package practice;

/**
 * SquareCount class
 *
 * @author Soarkey
 * @date 2018/11/21
 */
public class SquareCount {

    public static void main(String[] args) {
        int R = 1000;
        int a = 1000, b = 0, tb = 0, count = 0;
        for (; a >= 0; a--) {
            while (a * a + b * b <= R * R) b++;
            b--;
            count += a * (b - tb);
            tb = b;
        }
        System.out.println(count * 4);
        //答案 3137548
    }
}
