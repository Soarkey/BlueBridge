package data_structure;

import java.util.Hashtable;

/**
 * HashTableDemo class
 *
 * @author Soarkey
 * @date 2018/2/17
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("a","aaaaa");
        hashtable.put("b","bbbb");
        hashtable.put("c","ccc");
        System.out.println(hashtable.get("a"));
    }
}