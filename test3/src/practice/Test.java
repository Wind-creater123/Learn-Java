package practice;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        GoldCard gc = new GoldCard("1","1","1",1000);
        pay(gc);
        gc.setMoney(1000);
        pay(gc);

        SilverCard sc=new SilverCard("2","2","2",2000);
        pay(sc);
        sc.setMoney(2000);
        pay(sc);
    }

    public static void pay(Card c){
        System.out.println("请刷卡，输入消费金额：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextInt();
        c.consume(money);
    }
}
