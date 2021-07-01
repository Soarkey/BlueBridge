package data_structure;

/**
 * ArrayQueue
 *
 * @author Soarkey
 * @date 2021/7/1
 */
public class ArrayQueue {
    public static void main(String[] args) {
        final int N = 5;
        int[] queue = new int[N];
        int head = 0, tail = 0;

        int k = 1;

        // 判满 (head + 1 + N) % N == tail
        // 不满一直入队
        while ((tail + 1 + N) % N != head) {
            // 入队
            queue[tail] = k++;
            tail = (tail + 1 + N) % N;
        }

        System.out.println("head:" + head + ",tail=" + tail);

        // 判空 head != tail
        // 不空一直出队
        while (head != tail) {
            System.out.print(queue[head] + ", ");
            head = (head + 1 + N) % N;
        }
        System.out.println();
        // 1, 2, 3, 4,

        // 入队4出队3入队2
        head = tail = 0;
        k = 1;
        for (int i = 0; i < 4; i++) {
            queue[tail] = k++;
            tail = (tail + 1 + N) % N;
        }
        for (int i = 0; i < 3; i++) {
            head = (head + 1 + N) % N;
        }
        for (int i = 0; i < 2; i++) {
            queue[tail] = k++;
            tail = (tail + 1 + N) % N;
        }

        // 求队列长度
        System.out.println("队列长度:" + (tail - head + N) % N);

        while (head != tail) {
            System.out.print(queue[head] + ", ");
            head = (head + 1 + N) % N;
        }
        System.out.println();
        // 4, 5, 6,
    }
}
