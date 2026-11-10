package Thread;

public class ThreadDemo4 {
    public static void main(String[] args) {

        Thread thread1=new ThreadDemo();
        thread1.start();
        System.out.println(thread1.getName());

        Thread thread2=new ThreadDemo();
        thread2.start();
        System.out.println(thread2.getName());

        //哪个线程调用，拿到哪个线程(main)
        Thread now=Thread.currentThread();
        System.out.println(now.getName());

        Thread thread3=new ThreadDemo();
        thread3.setName("3号线程");
        thread3.start();
        System.out.println(thread3.getName());

        for(int i=0;i<5;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
                if (i==1){
                    thread1.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ThreadDemo extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(i);
            System.out.println(Thread.currentThread().getName());
        }
    }
}