package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Callable<String> callable=new MyCallable3(100);

        FutureTask<String> futureTask=new FutureTask<>(callable);
        Thread thread=new Thread(futureTask);
        thread.start();

        try{
            System.out.println(futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class MyCallable3 implements Callable<String> {
    private int n;
    public MyCallable3(int n){
        this.n=n;
    }
    @Override
    public String call() throws Exception {
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=i;
        }
        return String.valueOf(sum);
    }
}