package Exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        try {
            show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("start");
        while(true){
            try {
                double price =price();
                System.out.println(price);
                break;
            }catch (Exception e){
                System.out.println("price is wrong");
            }
        }
        System.out.println("end");
    }

    public static void show()throws Exception{
        String string="2025-07-09 11:12:13";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=sdf.parse(string);

        System.out.println(date);

    }

    public static double price(){
        Scanner sc=new Scanner(System.in);
        System.out.println("price:");
        double price=sc.nextDouble();
        return price;
    }
}
