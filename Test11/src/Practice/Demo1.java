package Practice;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Demo1 {
    public static void main(String[] args) {
        Set<Integer> red =new TreeSet<>();
        while(red.size()<6){
            int num=(int)(Math.random()*35+1);
            red.add(num);
        }
        System.out.println(red);
        int blue=(int)(Math.random()*15+1);
        System.out.println(blue);

        Set<Integer> luckyRed =new TreeSet<>();
        Collections.addAll(luckyRed,10,12,30,16,7,17);
        int luckyBlue= 12;

        int redCount =0;
        for(Integer num:luckyRed){
            if(luckyRed.contains(num)){
                redCount++;
            }
        }
        System.out.println("redCount:"+redCount);
        System.out.println("blueCount:"+(luckyBlue==blue));
    }
}
