package data_structure;

import java.util.PriorityQueue;

/**
 * PirorityQueueDemo class
 * 优先级队列
 * @author Soarkey
 * @date 2018/2/17
 */
public class PirorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(23);
        pq.add(2443);
        pq.add(235);
        pq.add(2323322);
        pq.add(2);
        // Error
        // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        //pq.add("hello");
        //pq.add("a");

        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}
