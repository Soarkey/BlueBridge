package practice;

import java.math.BigInteger;

/**
 * DaffodilNumber class
 * 求21 位数的水仙花数
 * <p>
 * 水仙花数： 水仙花数是指一个 n 位数（n≥3 ），它的每个位上的数字的 n 次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
 *
 * @author Soarkey
 * @date 2018/2/18
 */
public class DaffodilNumber {

    public static int size;
    public static int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    // 记录0~9的size次方
    public static BigInteger powArray[] = new BigInteger[10];
    // 记录0~9的使用次数
    public static int usedTimes[] = new int[10];
    //记录0到9中任意数字i的N次方乘以i出现的次数j的结果（i^N*j）
    public static BigInteger iPowSizeMultiplyj[][];
    // size位的数字能表示的最大值
    public static BigInteger MAX;
    // size位的数字能表示的最小值
    public static BigInteger MIN;

    public static void init() {
        // 用于初始化powArray[],MAX,MIN
        for (int i = 0; i < 10; i++) {
            // 初始化powArray[]
            powArray[i] = (new BigInteger("" + i)).pow(size);
        }
        // 初始化最小值
        MIN = (new BigInteger("10")).pow(size - 1);
        // 初始化最大值
        MAX = (new BigInteger("10").pow(size).add(new BigInteger("-1")));
        //初始化iPowSizeMultiplyj[][]
        iPowSizeMultiplyj = new BigInteger[10][size + 1];
        for (int i = 0; i < 10; i++) {
            iPowSizeMultiplyj[i][0] = BigInteger.valueOf(0);
            for (int j = 1; j < size + 1; j++) {
                iPowSizeMultiplyj[i][j] = iPowSizeMultiplyj[i][j - 1].add(powArray[i]);
            }
        }
    }

    public static void exhaustion(int arrayIndex, int used, BigInteger current) {
        if (current.compareTo(MAX) > 1) {
            //超过最大值,递归结束
            return;
        }
        if (used == size) {
            //size位全部分配完毕
            if (current.compareTo(MIN) < 0) {
                //已获得的值小于最小值
                return;
            } else {
                String s = current + "";
                int avaliableValueUsed[] = new int[10];
                for (int i = 0; i < s.length(); i++) {
                    avaliableValueUsed[s.charAt(i) - '0']++;
                }
                for (int i = 0; i < 10; i++) {
                    if (usedTimes[i] != avaliableValueUsed[i]) {
                        return;
                    }
                }
                System.out.println(current);
                return;
            }
        }
        if (arrayIndex == 0) {
            usedTimes[0] = size - used;
            exhaustion(-1, size, current);
            usedTimes[0] = 0;
            return;
        }
        if (current.add(iPowSizeMultiplyj[arrayIndex][size - used]).compareTo(MIN) < 0) {
            return;
        }
        if (arrayIndex >= 0) {
            for (int i = 0; i <= size - used; i++) {
                if (current.add(iPowSizeMultiplyj[arrayIndex][i]).compareTo(MAX) > 0) {
                    return;
                }
                usedTimes[arrayIndex] = i;
                exhaustion(arrayIndex - 1, used + i, current.add(iPowSizeMultiplyj[arrayIndex][i]));
                usedTimes[arrayIndex] = 0;
            }
        } else {
            //1到9已分配完毕,不可再延伸了
            return;
        }
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        size = 21;
        init();
        exhaustion(9, 0, BigInteger.valueOf(0));
        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - beginTime) / 1000f + "s");
    }
}