package Thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable runnable=new MyRunnable2();
        Thread thread=new Thread(runnable);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
