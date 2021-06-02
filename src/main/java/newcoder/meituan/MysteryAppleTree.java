package newcoder.meituan;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * 美团2021校招笔试-编程题(通用编程试题,第9场)
 * 神秘的苹果树
 * [未完成]
 *
 * @author Soarkey
 * @date 2021/2/28
 */
public class MysteryAppleTree {
    static class Node {
        public Map<Integer, Integer> mapColor = new HashMap<>();
        public Map<Integer, Integer> mapIndex = new HashMap<>();
        public int maxColor = -1;
        public int minIndex = -1;
        public int color = -1;
        public List<Node> childs = new LinkedList<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));


        int n, x, y;
        Node[] nodes = new Node[5050];
        while (in.hasNextInt()) {
            n = in.nextInt();
            // 初始化结点
            for (int i = 1; i <= n; ++i) {
                nodes[i] = new Node();
            }
            // 构建树的关系
            for (int i = 1; i <= n; ++i) {
                x = in.nextInt();
                y = in.nextInt();
                nodes[Math.min(x, y)].childs.add(nodes[Math.max(x, y)]);
            }
            // 标记颜色
            for (int i = 1; i <= n; ++i) {
                nodes[i].color = in.nextInt();
                nodes[i].mapColor.put(nodes[i].color, 1);
                nodes[i].mapIndex.put(nodes[i].color, i);
            }
            // query
            int q = in.nextInt();
            while (q-- != 0) {
                int k = in.nextInt();
                // search color
                if (nodes[k].minIndex == -1) {
                    dfs(nodes, n, nodes[k]);
                }
                out.println(nodes[k].minIndex);
            }
        }

        in.close();
        out.close();
    }

    public static void dfs(Node[] nodes, int n, Node root) {
        // 叶子结点
        if (root.childs.size() == 0) {
            return;
        }
        // 统计子树颜色
        for (Node t : root.childs) {
//            root.mapColor.putAll(dfs(nodes, n, t));
        }
        // 找出最大的进行记录

    }
}
