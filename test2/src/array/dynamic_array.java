package array;

import java.util.Scanner;

public class dynamic_array {
    public static void main(String[] args) {
        inputScore();
    }

    private static void inputScore() {
        double[] scores=new double[8];

        Scanner sc=new Scanner(System.in);
        for(int i=0;i<scores.length;i++){
            System.out.println("请输入第"+(i+1)+"个学生成绩");
            scores[i]=sc.nextDouble();
        }

        double allScore=0.0;
        double maxScore=0.0;
        double minScore=0.0;
        for(int i=0;i<scores.length;i++){
            double score=scores[i];
            allScore+=score;
            //allScore+=scores[i];

            if(score>maxScore){
                maxScore=score;
            }
            if(score<minScore){
                minScore=score;
            }
        }
        System.out.println("平均分"+allScore/scores.length);
        System.out.println("max:"+maxScore);
        System.out.println("min:"+minScore);
    }

    private static int getMax(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            //找数组浪费性能
            int data=arr[i];
            if(data>max){
                max=data;
            }
        }
        return max;
    }
}
