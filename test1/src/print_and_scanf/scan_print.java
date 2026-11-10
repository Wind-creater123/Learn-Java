package print_and_scanf;
//导包
import java.util.Scanner;

public class scan_print {
    public static void main() {
        //new对象
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        //输入，输出
        int a = sc.nextInt();
        int b = sc.nextInt();

        String c = sc1.nextLine();
        String d = sc1.nextLine();

        System.out.println(a+b);
        System.out.println(c);
        System.out.println("hhh"+d+c);
    }

    public static void calc(int a,int b){
        //加 减 乘 除 取余（模）
        int c=a+b;
        int c2=a/b;
        int c3=a*b;
        int c4=a%b;
        int c5=a-b;
        System.out.println(c);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
    }

}
