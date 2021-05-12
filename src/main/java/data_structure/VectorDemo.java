package data_structure;

import java.util.Vector;

/**
 * VectorDemo class
 *
 * @author Soarkey
 * @date 2018/2/18
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("ss");
        vector.add(0,"44");
        System.out.println(vector.contains("ss"));
        System.out.println(vector.get(0));
        System.out.println(vector.get(1));
        System.out.println(vector.size());
    }
}
