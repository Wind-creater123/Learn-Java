package practice;

import java.util.Scanner;

public class HuaRongDao {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        start(n);
    }

    private static void start(int n) {
        int[][] arr=new int[n][n];

        int count =1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=count++;
            }
        }

        printArray(arr);

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                int m=(int)(Math.random()*arr.length);
                int p=(int)(Math.random()*arr.length);

                int tmp=arr[m][p];
                arr[m][p]=arr[i][j];
                arr[i][j]=tmp;
            }
        }

        printArray(arr);
    }

    private static void printArray(int[][] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
