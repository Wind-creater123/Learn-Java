package if_while_for;

import java.util.Scanner;

public class for_grammar {
    public static void main(String[] args) {
        int sum=sum();
        int sum2=sum2();
    }

    private static int sum2() {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        for(int i=1;i<=n;i+=2){
            sum+=i;
        }
        return sum;
    }

    private static int sum() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum+=i;
        }
        return sum;
    }
}
