package practice;

import java.util.Arrays;

/**
 * FillNumberByCircle class
 *
 * @author Soarkey
 * @date 2018/2/25
 */
public class FillNumberByCircle {
    public static void main(String[] args) {
        int n = 5;
        int[][] array = new int[n][n];
        int count = 1;
        int startIndex = 0, endIndex = n - 1;
        int e = 0;
        while (count <= n * n) {
            // 左 -> 右
            for (int i = startIndex; i <= endIndex; i++) {
                array[e][i] = count++;
            }
            // 上 -> 下
            for (int i = startIndex + 1; i <= endIndex; i++) {
                array[i][n - 1 - e] = count++;
            }
            // 右 -> 左
            for (int i = endIndex - 1; i >= startIndex; i--) {
                array[n - 1 - e][i] = count++;
            }
            // 下 -> 上
            for (int i = endIndex - 1; i > startIndex; i--) {
                array[i][e] = count++;
            }
            startIndex++;
            endIndex--;
            e++;
        }
        display(array);
    }

    public static void display(int[][] array) {
        System.out.println("====================");
        for (int[] x : array) {
            for (int y : x) {
                System.out.print(y + "\t");
            }
            System.out.println();
        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Arrays.toString(array[i]));
//        }
        System.out.println("----------------------");
    }
}
