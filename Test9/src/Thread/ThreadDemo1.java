package Thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread thread=new MyThread1();
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

//方案1(继承Thread类)
class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
