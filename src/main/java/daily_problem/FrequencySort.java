package daily_problem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * FrequencySort
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 *
 * @author Soarkey
 * @date 2021/7/3
 */
public class FrequencySort {
    public static void main(String[] args) {
        FrequencySort f = new FrequencySort();
        String[] data = {"tree", "cccaaa", "Aabb"};
        for (String i : data) {
            System.out.println(f.frequencySort(i));
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(a -> -a.freq));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            priorityQueue.offer(node);
        }
        StringBuilder builder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            while (node.freq-- > 0) {
                builder.append(node.c);
            }
        }
        return builder.toString();
    }

    class Node {
        char c;
        int freq;

        Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
