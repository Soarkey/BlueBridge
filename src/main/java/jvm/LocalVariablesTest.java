package jvm;

import java.util.Date;

/**
 * LocalVariablesTest class
 *
 * @author Soarkey
 * @date 2021/4/20
 */
public class LocalVariablesTest {
    int count;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    public LocalVariablesTest() {
        this.count = 1;
    }

    public void test1() {
        Date date = new Date();
        String name = "abcdefg";
        test2(date, name);
        System.out.println(date + name);
        this.count++;
    }

    // 练习
    public static void testStatic() {
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
    }

    public String test2(Date date, String name) {
        date = null;
        name = "abc";
        double weight = 130.5; // 占据两个slot
        char sex = '男';
        return name;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        // 变量c使用之前已经销毁的变量b占据的slot位置
        int c = a + 1;
    }

    public void test5(){
        int num;
        // System.out.println(num); // Variable 'num' might not have been initialized
    }
}