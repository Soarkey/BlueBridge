package data_structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMapLRUCache
 *
 * @author Soarkey
 * @date 2021/5/22
 */
public class LinkedHashMapLRUCache extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LinkedHashMapLRUCache(int capacity) {
        super(capacity, 1.0f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > capacity;
    }

    @Override
    public Integer get(Object key) {
        if (super.containsKey(key)) {
            return super.get(key);
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedHashMapLRUCache cache = new LinkedHashMapLRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        // 1
        // -1
        // -1
        // 3
        // 4
    }
}
