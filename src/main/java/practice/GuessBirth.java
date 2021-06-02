package practice;

/**
 * GuessBirth class
 * <p>
 * 今年的植树节（2012 年3 月12 日），小明和他的叔叔还有小伙伴们一起去植树。
 * 休息的时候，小明的同学问他叔叔多大年纪，他叔叔说：“我说个题目，看你们谁先猜出来！”
 * “把我出生的年月日连起来拼成一个8 位数（月、日不足两位前补0）正好可以被今天的年、月、日整除！”
 * 他想了想，又补充到：“再给个提示，我是6 月出生的。”
 * 根据这些信息，请你帮小明算一下，他叔叔的出生年月日。
 * 答案写在“解答.txt”中，不要写在这里！
 * 格式是年月日连成的8 位数。
 * 例如，如果是1948 年6 月12 日，就写：19480612
 *
 * @author Soarkey
 * @date 2018/2/21
 */
public class GuessBirth {
    public static void main(String[] args) {
        guess();
    }

    public static void guess() {
        int birth;
        for (int i = 1950; i < 2000; i++) {
            for (int j = 1; j <= 30; j++) {
                if (j < 10) {
                    birth = Integer.valueOf(i + "060" + j);
                } else {
                    birth = Integer.valueOf(i + "06" + j);
                }
                if (birth % 2012 == 0 && birth % 3 == 0 && birth % 12 == 0) {
                    System.out.println(birth);
                }
            }
        }
    }
}
