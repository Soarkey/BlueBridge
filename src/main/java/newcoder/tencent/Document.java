package newcoder.tencent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Document class
 *
 * @author Soarkey
 * @date 2021/4/4
 */
public class Document {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNext()) {
            int n = in.nextInt();
            Map<String, Integer> total = new HashMap<>();
            Map<String, Integer> map = new HashMap<>();
            while (n-- != 0) {
                int k = in.nextInt();

                while (k-- != 0) {
                    // 统计词频
                    String word = in.nextLine();
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    // total.put(word, total.getOrDefault(word, 0) + 1);
                }
                // 最高词频单词
                String maxFreq;
                int t = Integer.MIN_VALUE;
                for(Map.Entry<String, Integer> entry : map.entrySet()){
                    String key = entry.getKey();
                    total.put(key, total.getOrDefault(key, 0) + 1);
                    int value = entry.getValue();
                    if(value > t){

                    }

                }
            }

        }

        in.close();
        out.close();
    }

    static class Node {
        String word;
        int freq;
    }
}
