package newcoder.shopee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * FindLeafNode class
 *
 * @author Soarkey
 * @date 2021/3/26
 */
public class FindLeafNode {
    private static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            String s = in.nextLine();
            findLeafNode(s);
            int n = queue.size();
            for (int i = 0; i < n - 1; ++i) {
                out.print(queue.poll() + " ");
            }
            out.println(queue.poll());
        }

        in.close();
        out.close();
    }

    public static void findLeafNode(String s) {
        String[] sp = s.split(" ");
        int n = sp.length;
        int[] preOrder = new int[n];
        for (int i = 0; i < n; ++i) {
            preOrder[i] = Integer.parseInt(sp[i]);
        }

        int[] inOrder = new int[n];
        System.arraycopy(preOrder, 0, inOrder, 0, n);
        Arrays.sort(inOrder);

        queue = new ArrayDeque<>(n - 1);
        buildBinarySearchTree(preOrder, 0, n - 1, inOrder, 0, n - 1);
    }

    public static void buildBinarySearchTree(int[] preOrder, int l1, int r1, int[] inOrder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return;
        }

        int root = preOrder[l1];
        int k = l2;
        for (int i = l2; i <= r2; ++i) {
            if (inOrder[i] == root) {
                k = i;
                break;
            }
        }

        boolean isLeafNode = true;
        if (k > l2) {
            // left child
            isLeafNode = false;
            buildBinarySearchTree(preOrder, l1 + 1, l1 + k - l2, inOrder, l2, k - 1);
        }
        if (k < r2) {
            // right child
            isLeafNode = false;
            buildBinarySearchTree(preOrder, l1 + k - l2 + 1, r1, inOrder, k + 1, r2);
        }
        if (isLeafNode) {
            queue.add(root);
        }
    }
}
