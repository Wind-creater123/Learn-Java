package ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool= Executors.newFixedThreadPool(3);

        Future<String> f1= pool.submit(new MyCallable(100));
        Future<String> f2= pool.submit(new MyCallable(100));
        Future<String> f3= pool.submit(new MyCallable(100));
        Future<String> f4= pool.submit(new MyCallable(100));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
