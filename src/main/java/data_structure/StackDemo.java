package data_structure;

import java.util.Iterator;
import java.util.Stack;

/**
 * Stack class
 * Stack-method:
 * boolean empty()  测试堆栈是否为空。
 * E peek()        查看堆栈顶部的对象，但不从堆栈中移除它。
 * E pop()         移除堆栈顶部的对象，并作为此函数的值返回该对象。
 * E push(E item)  把项压入堆栈顶部。
 * int search(Object o)  返回对象在堆栈中的位置，以 1 为基数。
 *
 * @author Soarkey
 * @date 2018/2/14
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("push:XXX");
        stack.push("XXX");
        System.out.println("peek:" + stack.peek());
        System.out.println("isEmpty:" + stack.empty());
        System.out.println("size:" + stack.size());
        System.out.println("pop:" + stack.pop());
        System.out.println("isEmpty:" + stack.empty());
        System.out.println("size:" + stack.size());
        stack.push("YYY");
        stack.push("XXX");
        System.out.println("search XXX:" + stack.search("YYY"));
        System.out.println("size:" + stack.size());
        stack.clear();
        System.out.println("isEmpty:" + stack.empty());
        stack.push("ZZZ");
        stack.push("YYY");
        stack.push("XXX");
        // fori
        System.out.println("fori:");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
            stack.set(i, "X" + i);
        }
        //iterator
        System.out.println("iterator:");
        Iterator i = stack.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
