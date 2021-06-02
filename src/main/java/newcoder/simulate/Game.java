package newcoder.simulate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Game class
 *
 * @author Soarkey
 * @date 2021/3/18
 */
public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();

            String[] str = new String[3];
            char[][] sc = new char[3][];
            Map<Character, Integer>[] map = new Map[3];
            for (int i = 0; i < 3; ++i) {
                str[i] = in.nextLine();
                sc[i] = str[i].toCharArray();
                map[i] = new HashMap<>(52);
            }

            int[] maxChar = new int[3];
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < sc[i].length; ++j) {
                    int times = map[i].getOrDefault(sc[i][j], 0) + 1;
                    maxChar[i] = Math.max(maxChar[i], times);
                    map[i].put(sc[i][j], times);
                }
            }

            // 0
            if(maxChar[0] > maxChar[1] && maxChar[0] > maxChar[2]){
                out.println("xiaoming");
                continue;
            }
            // 1
            if(maxChar[1] > maxChar[0] && maxChar[1] > maxChar[2]){
                out.println("xiaowang");
                continue;
            }
            // 2
            if(maxChar[2] > maxChar[0] && maxChar[2] > maxChar[1]){
                out.println("xiaoli");
                continue;
            }

            System.out.println(Arrays.toString(maxChar));

            if(maxChar[0] > maxChar[1]){
                if(maxChar[0] > maxChar[2]){
                    out.println("xiaoming");
                }else if(maxChar[0] == maxChar[2]) {
                    out.println("draw");
                } else {
                    // maxChar[2] > maxChar[0] > maxChar[1]
                    out.println("xiaoli");
                }
            } else if(maxChar[0] == maxChar[1]) {
                System.out.println("draw");
            } else {
                // maxChar[0] < maxChar[1]
                if(maxChar[0] > maxChar[2]){
                    // maxChar[2] < maxChar[0] < maxChar[1]
                    out.println("xiaowang");
                }else if(maxChar[0] == maxChar[2]) {
                    out.println("draw");
                } else {
                    // maxChar[2] > maxChar[0] < maxChar[1]
                    if(maxChar[1] > maxChar[2]){
                        out.println("xiaowang");
                    } else if(maxChar[1] == maxChar[2]){
                        out.println("draw");
                    } else {
                        out.println("xiaoli");
                    }
                }

            }
        }

        in.close();
        out.close();
    }
}
