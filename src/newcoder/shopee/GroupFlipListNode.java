package newcoder.shopee;

import java.util.List;

/**
 * GroupFlipListNode class
 *
 * @author Soarkey
 * @date 2021/3/26
 */
public class GroupFlipListNode {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }
    }

    public static void main(String[] args) {
        // create
        ListNode head = new ListNode(-1, null), p = head;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < arr.length; ++i) {
            ListNode q = new ListNode(arr[i], null);
            p.next = q;
            p = p.next;
        }
        ListNode ans = reverseLinkedList(head.next, 2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }

    public static ListNode reverseLinkedList(ListNode head, int n) {
        // write code here
        if (n <= 1) {
            return head;
        }

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode p = newHead, q, post, rear;

        while (p.next != null) {
            q = p.next;
            rear = p.next;
            p.next = null;

            int k = 0;
            while (q != null && k < n) {
                post = q.next;
                q.next = p.next;
                p.next = q;
                q = post;
                ++k;
            }
            rear.next = q;
            p = rear;
        }

        return newHead.next;
    }
}
