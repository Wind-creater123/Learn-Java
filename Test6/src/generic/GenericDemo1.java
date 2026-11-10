package generic;

import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");

        for(int i=0;i<list.size();i++){
            String str=list.get(i);
            System.out.println(str);
        }
    }
}
