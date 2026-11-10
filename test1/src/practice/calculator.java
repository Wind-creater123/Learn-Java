package practice;

import java.util.Scanner;

public class calculator {
    public static void  main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入两个整数");
        System.out.println("请输入第一个数据");
        double num1=sc.nextDouble();

        System.out.println("请输入第二个数据");
        double num2=sc.nextDouble();

        System.out.println("请输入运算符（+，-，*，/）：");
        String operator=sc.next();

        double result=calc(num1,num2,operator);
        System.out.println("结果为："+result);
    }

    private static double calc(double num1, double num2, String operator) {
        double result=0;
        switch (operator){
            case "+":
                result=num1+num2;
                break;
            case  "-":
                result=num1-num2;
                break;
            case "*":
                result=num1*num2;
                break;
            case "/":
                result=num1/num2;
                break;
            default:
                System.out.println("有误");
        }
        return result;
    }
}
