package practice;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

/**
 * Test class
 *
 * @author Soarkey
 * @date 2018/2/18
 */
public class Test {

    static HashMap<Character, BigInteger> powValue = new HashMap<>();
    static int size = 21;
    static HashMap<Character, BigInteger> count = new HashMap<>();

    public static void main(String[] args) {
        Random random = new Random();
//        for (int i = 0; i < 50; i++) {
//            int a = (int) (Math.random() * 6) + 1;
//            System.out.println(a);
//        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int t;
        for (int i = 0; i < 40000; i++) {
            t = random.nextInt();
            System.out.println(t);
            if (t < min) {
                min = t;
            }
            if (t > max) {
                max = t;
            }
        }
        System.out.println("[" + min + "," + max + "]");

//        // init
//        for (int i = 0; i <= 9; i++) {
//            powValue.put((char) (i + '0'), new BigInteger("" + i).pow(size));
//        }
//
//        System.out.println();
//        long beginTime = System.currentTimeMillis();
//        daff();
//        long endTime = System.currentTimeMillis();
//        System.out.println("time: " + (endTime - beginTime) / 1000f + "s");
    }

    public static void daff() {
        BigInteger ans = BigInteger.ZERO;
        BigInteger begin = new BigInteger("100000000000000000000");
        BigInteger end = new BigInteger("999999999999999999999");
        for (BigInteger i = begin; i.compareTo(end) < 0; i = i.add(BigInteger.ONE)) {
            if (calc(i).compareTo(i) == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * 计算水仙花的每位幂加和
     *
     * @return
     */
    public static BigInteger calc(BigInteger num) {
        String s = num.toString();
        s.replace("0", "");
        BigInteger ans = BigInteger.ZERO;
        int len = s.length();
        // 统计每个数字的出现次数
        count.clear();
        char t;
        for (int i = 0; i < len; i++) {
            t = s.charAt(i);
            if (!count.containsKey(t)) {
                count.put(t, BigInteger.ONE);
            } else {
                count.put(t, count.get(t).add(BigInteger.ONE));
            }
        }
        for (Character key : count.keySet()) {
            ans = ans.add(count.get(key).multiply(powValue.get(key)));
        }
        return ans;
    }


}
