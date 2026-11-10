package uesful_api;

import java.util.Scanner;

public class String_api {
    public static void main(String[] args) {
        String crtLoginName="admin";
        System.out.println("输入:");
        Scanner sc=new Scanner(System.in);
        String loginName=sc.nextLine();
        if(crtLoginName.equals(loginName)){
            System.out.println("correct");
        }else{
            System.out.println("wrong");
        }

        String phoneNumber=sc.nextLine();
        String newPhoneNumber=phoneNumber.substring(0,3)+"****"+phoneNumber.substring(7);
        System.out.println("newPhoneNumber:"+newPhoneNumber);
    }

}
