package oop_super;

import java.util.Arrays;

public class code_zone {
    public static String schoolName;
    public static String[] cards=new  String[5];

    static {
        System.out.println("+++++");
        cards[0]="1";
        cards[1]="2";
        cards[2]="3";
    }

    private String name;
    private String[] direction=new String[5];

    {
        System.out.println("+-+-+");
        name="123";
        direction[0]="1";
        direction[1]="2";
        direction[2]="3";
    }

    public static void main(String[] args) {
        System.out.println("-----");
        System.out.println(schoolName);
        System.out.println(Arrays.toString(cards));

        new code_zone();
        new code_zone();
        new code_zone();
    }
}
