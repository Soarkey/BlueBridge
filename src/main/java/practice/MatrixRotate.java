package practice;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * MatrixRotate class
 *
 * @author Soarkey
 * @date 2018/2/24
 */
public class MatrixRotate {
    public static void main(String[] args) {
        // 原矩阵 m
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        display(m);
        System.out.println("=================");
        // 顺时针旋转之后的矩阵 n
        int[][] n = rotation(m);
        display(n);
    }

    public static int[][] rotation(int[][] m) {
        // i行j列
        int i = m.length;
        int j = m[0].length;
        int[][] n = new int[i][j];
        for (int r = 0; r < i; r++) {
            for (int c = 0; c < j; c++) {
                n[c][j - r - 1] = m[r][c];
            }
        }
        return n;
    }

    public static void display(int[][] arr) {
        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + "\t");
            }
            System.out.println();
        }

//        int x = arr.length;
//        int y = arr[0].length;
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                System.out.printf("%3d", arr[i][j]);
//            }
//            System.out.println();
//        }
    }
}
