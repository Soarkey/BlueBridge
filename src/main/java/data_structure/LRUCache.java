package data_structure;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache
 *
 * @author Soarkey
 * @date 2021/5/22
 */
public class LRUCache {
    static class Node {
        Node pre;
        Node next;
        int key;
        int value;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = next = null;
        }
    }

    static class MyLinkedList {
        Node head;
        Node tail;
        int len;

        MyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            len = 0;
        }

        void addToHead(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        Node removeTail() {
            Node node = tail.pre;
            removeNode(node);
            return node;
        }
    }

    private MyLinkedList myLinkedList;
    private Map<Integer, Node> map;
    private final int capacity;

    public LRUCache(int capacity) {
        myLinkedList = new MyLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 命中
            Node node = map.get(key);
            myLinkedList.moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 已有，更新value
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            myLinkedList.moveToHead(node);
            return;
        }
        // 新增
        Node node = new Node(key, value);
        myLinkedList.addToHead(node);
        map.put(key, node);
        // 淘汰
        if (map.size() > capacity) {
            Node tailNode = myLinkedList.removeTail();
            map.remove(tailNode.key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        // 结果
        // 1
        // -1
        // -1
        // 3
        // 4
    }
}