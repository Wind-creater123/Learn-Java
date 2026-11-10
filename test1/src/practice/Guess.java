package practice;

import java.util.Random;
import java.util.Scanner;

public class Guess {
    public  static void main(String[] args){
        Random r=new Random();
        int rn=r.nextInt(100)+1;

        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.print("输入猜测的数字：");
            int guess=sc.nextInt();
            if(guess==rn){
                System.out.println("猜对了");
                break;
            }
            else if (guess>rn) {
                System.out.println("猜大了");
            }
            else{
                System.out.println("猜小了");
            }
        }
    }
}
