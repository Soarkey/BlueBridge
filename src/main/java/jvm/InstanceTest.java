package jvm;

/**
 * InstanceTest
 *
 * @author Soarkey
 * @date 2021/5/31
 */
public class InstanceTest {
    static class Customer {
        int id = 1001;
        String name;
        static String staicName;
        Account account;

        {
            name = "匿名客户";
            staicName = "xxx";
        }

        static {
            staicName = "yyy";
        }

        public Customer() {
            account = new Account();
        }
    }

    static class Account {

    }

    public static void main(String[] args) {
        Customer customer = new Customer();
    }
}
