package if_while_for;

import java.util.Scanner;

public class switch_grammar {
    public static void main(String[] args) {
        sex();
    }

    public static void sex(){
        Scanner sc = new Scanner(System.in);
        String sex=sc.nextLine();
        switch (sex){
            case "男":
                System.out.println("bro");
                break;
            case "女":
                System.out.println("girl");
                break;
            default:
                System.out.println("someone");
        }
    }
}
