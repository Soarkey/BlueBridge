package jvm;

/**
 * OperandStackTest class
 *
 * @author Soarkey
 * @date 2021/4/20
 */
public class OperandStackTest {
    public static void main(String[] args) {
        new OperandStackTest().test();
    }

    public void testAddOperation() {
        byte i = 15;
        int j = 8;
        int k = i + j;
        char c = 'b';
        int m = 800;
    }

    public int getSum() {
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    public void testGetSum() {
        int i = getSum();
        int j = 10;
    }

    public void test() {
        // 第一类问题
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;
        // 第二类问题
        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;
        // 第三类问题
        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;
        // 第四类问题
        int i9 = 10;
        int i10 = i9++ + ++i9;
        System.out.println(i7 + "," + i8 + "," + i10);
    }
}
