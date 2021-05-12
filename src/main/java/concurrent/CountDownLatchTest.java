package concurrent;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchTest class
 *
 * @author Soarkey
 * @date 2021/5/10
 */
enum City {
    BEGIN(0, "起点"),
    SHANG_HAI(1, "上海"),
    BEI_JING(2, "北京"),
    GUANG_ZHOU(3, "广州"),
    SHEN_ZHEN(4, "深圳"),
    HANG_ZHOU(5, "杭州"),
    WU_HAN(6, "武汉"),
    END(7, "终点");

    @Getter
    private Integer code;
    @Getter
    private String cityName;

    City(int code, String cityName) {
        this.code = code;
        this.cityName = cityName;
    }

    public static City selectCityByCode(int id) {
        for (City city : City.values()) {
            if (id == city.code) {
                return city;
            }
        }
        return null;
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // close();
        trave();
    }

    public static void trave() throws InterruptedException {
        System.out.println(City.BEGIN + " 出发");
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 游览完成");
                countDownLatch.countDown();
            }, i + ":" +City.selectCityByCode(i).getCityName()).start();
        }

        countDownLatch.await();
        System.out.println(City.END + " 结束");
    }

    private static void close() throws InterruptedException {
        int n = 10;
        CountDownLatch countDownLatch = new CountDownLatch(n);

        for (int i = 0; i < n; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 离开");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 离开");
    }
}
