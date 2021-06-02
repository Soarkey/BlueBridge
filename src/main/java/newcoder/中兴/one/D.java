package newcoder.中兴.one;

import org.w3c.dom.Node;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * D class
 *
 * @author Soarkey
 * @date 2021/4/24
 */
public class D {

    static class Node {
        Node pre;
        int value;
        int num; // 所属队伍数字
        Node next;

        Node() {
        }

        Node(int value) {
            this.value = value;
        }

        Node(int value, int num) {
            this.value = value;
            this.num = num;
        }
    }

    static class DequqList {
        Node head;
        Node tail;
        int len;

        DequqList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void addNode(Node node) {
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
            ++len;
        }

        void deleteNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            --len;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            int q = in.nextInt();

            int[] nums = new int[q];
            for(int i=0; i<q; ++i){
                nums[i] = in.nextInt();
            }
            DequqList q1 = new DequqList();
            DequqList q2 = new DequqList();
            Map<Integer, Node> indexMap = new HashMap<>();
            for (int i = 1; i <= n1; ++i) {
                Node node = new Node(i, 0);
                indexMap.put(i, node);
                q1.addNode(node);
            }
            for (int j = n1 + 1; j <= n1 + n2; ++j) {
                Node node = new Node(j, 1);
                indexMap.put(j, node);
                q2.addNode(node);
            }

            // 换队伍
            for (int i = 0; i < q; ++i) {
                Node node = indexMap.get(nums[i]);
                int k = node.num;
                if(k == 0){
                    node.num = 1;
                    q1.deleteNode(node);
                    q2.addNode(node);
                } else {
                    node.num = 0;
                    q2.deleteNode(node);
                    q1.addNode(node);
                }
            }

            // 输出队伍编号
            StringBuilder builder = new StringBuilder();
            Node t = q1.head.next;
            while(t != q1.tail){
                builder.append(t.value + " ");
                t = t.next;
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append('\n');
            t = q2.head.next;
            while(t != q2.tail){
                builder.append(t.value + " ");
                t = t.next;
            }
            builder.deleteCharAt(builder.length() - 1);
            out.println(builder);
        }

        in.close();
        out.close();
    }
}
