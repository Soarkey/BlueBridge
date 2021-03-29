package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CallableDemo class
 *
 * @author Soarkey
 * @date 2021/3/25
 */
public class CallableDemo {
    static class MyCallable implements Callable<String> {
        private String name;

        public MyCallable(String name) {
            this.name = "thread " + name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(5);
            return "[" + name + " finished !]";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 最好手动创建线程池
        // ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 20,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardOldestPolicy());

        int n = 30;
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            MyCallable callable = new MyCallable(i + "");
            Future future = pool.submit(callable);
            System.out.println("SUBMIT: " + callable.getName());
            list.add(future);
        }

        int finished = 0;
        for (Future future : list) {
            try {
                System.out.println("RESPONSE: " + future.get(100, TimeUnit.MILLISECONDS));
                ++finished;
            } catch (TimeoutException e) {
                future.cancel(true);
            }
        }

        System.out.println("FINISHED: " + finished + "/" + n);
        pool.shutdown();
    }
}
