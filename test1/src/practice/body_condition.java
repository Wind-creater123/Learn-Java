package practice;

import java.util.Scanner;

public class body_condition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入你的身高：");
        double height=sc.nextDouble();
        System.out.println("请输入你的体重：");
        double weight=sc.nextDouble();
        System.out.println("请输入你的性别：");
        String sex=sc.next();
        System.out.println("请输入你的年龄：");
        int age=sc.nextInt();

        double bmi=BMI(height,weight);
        System.out.println("您的BMI为:"+bmi);

        double bmr=BMR(height,weight,sex,age);
        System.out.println("您的BMR为："+bmr);

    }

    public static double BMI(double height,double weight) {
        double bmi=weight/(height*height);
        return bmi;
    }

    public static double BMR(double height,double weight,String sex,int age) {
        double bmr=0;

        if (sex.equals("男")) {
            bmr=88.362+(13.397*weight)+(4.799*height)-(5.677*age);
            return bmr;
        }
        else if (sex.equals("女")) {
            bmr=447.593+(9.247*weight)+(3.098*height)-(4.330*age);
            return bmr;
        }
        else {
            return 0;
        }
    }
}
