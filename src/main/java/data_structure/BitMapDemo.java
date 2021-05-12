package data_structure;

import java.util.BitSet;

/**
 * BitMapDemo class
 *
 * @author Soarkey
 * @date 2021/3/31
 */
public class BitMapDemo {
    public static void main(String[] args) {
        BitSet bitmap = new BitSet();
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            bitmap.set(i);
        }
        System.out.println(bitmap.get(7));
        System.out.println(bitmap.length());
    }
}
