package data_structure;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * RBTreeTest class
 *
 * @author Soarkey
 * @date 2021/3/5
 */
public class RBTreeTest {
    public static void main(String[] args) {
        RBTree<String, Object> rbt = new RBTree();
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        // 测试输入：ijkgefhdabc
        System.out.print("input key:");
        while (true) {
            String key = in.next();
            if("-1".equals(key)){
                break;
            }
            rbt.insert(key, null);
            TreeOperation.show(rbt.getRoot());
            System.out.print("input key:");
        }
    }
}
