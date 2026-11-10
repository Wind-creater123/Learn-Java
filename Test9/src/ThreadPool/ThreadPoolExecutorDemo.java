package ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3,5,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //Runnable任务
        Runnable runnable = new MyRuannable();
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);

        //executorService.shutdown();
        //executorService.shutdownNow();

        Future<String> f1= executorService.submit(new MyCallable(100));
        Future<String> f2= executorService.submit(new MyCallable(200));
        Future<String> f3= executorService.submit(new MyCallable(150));
        Future<String> f4= executorService.submit(new MyCallable(50));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
