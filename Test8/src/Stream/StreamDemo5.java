package Stream;

import java.util.*;

public class StreamDemo5 {
    public static void main(String[] args) {
        sum();//
        sum(1);//
        sum(1,2,3,4,5);//
        sum(new int[]{1,2,3,4,5});//

        //
        List<String> list=new ArrayList<>();
        //addAll
        Collections.addAll(list,"a","b","c","d","e");
        System.out.println(list);

        //shuffle
        Collections.shuffle(list);
        System.out.println(list);

        //sort
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
    }

    //可变参数只能有1个，且必须放在形参列表最后
    public static void sum(int...nums){
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));

    }
}
