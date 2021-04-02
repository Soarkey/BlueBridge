package newcoder.huawei;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HatNumber class
 * 50%
 * @author Soarkey
 * @date 2021/3/31
 */
public class HatNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            String line = in.nextLine();
            line = line.substring(1, line.length() - 1).replace(" ", "");
            if (line.length() == 0) {
                out.println("0");
                continue;
            }

            String[] hatsStr = line.split(",");
            int[] hats = new int[hatsStr.length];
            for (int i = 0; i < hatsStr.length; ++i) {
                hats[i] = Integer.parseInt(hatsStr[i]);
            }
            Arrays.sort(hats);
            Map<Integer, Integer> map = new HashMap<>();

            int totalHat = 0;
            for (int hat : hats) {
                int t = hat + 1;
                if (map.containsKey(t)) {
                    if (map.get(t) - 1 == 0) {
                        map.remove(t);
                        totalHat += t;
                    } else {
                        map.put(t, map.get(t) - 1);
                    }
                } else {
                    if(t == 1){
                        // cover有人报的帽子数量为0的情况
                        totalHat += 1;
                    } else {
                        map.put(t, t - 1);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                totalHat += entry.getKey();
            }
            out.println(totalHat);
        }

        in.close();
        out.close();
    }
}
