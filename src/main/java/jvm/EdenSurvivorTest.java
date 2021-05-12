package jvm;


/**
 * EdenSurvivorTest class
 * -Xms600m -Xmx600m
 * 默认Eden:S1:S2=6:1:1，并不是8:1:1
 *
 * -XX:SurvivorRatio=8显示设置可以调整为8:1:1
 *
 * @author Soarkey
 * @date 2021/4/28
 */
public class EdenSurvivorTest {

    public static void main(String[] args) {
        System.out.println("....");
        try {
            Thread.sleep(100_0000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
