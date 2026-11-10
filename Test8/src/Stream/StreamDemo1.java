package Stream;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo1 {
    public  static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");

        //
        List<String> newList = new ArrayList<>();
        for (String name : names) {
            if(name.startsWith("a")&&name.length()==1){
                newList.add(name);
            }
        }
        System.out.println(newList);

        //stream
        List<String> newList2 = names.stream().filter(name -> name.startsWith("a")).filter(name -> name.length()==1).toList();
        System.out.println(newList2);
    }
}
