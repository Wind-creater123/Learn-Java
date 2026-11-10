package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
    public static void main(String[] args) {
        //无序，不重复，无索引
        Set<String> set=new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");

        //有序
        Set<String> set1=new LinkedHashSet<String>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        //排序
        Set<String> set2=new TreeSet<String>();
        set2.add("a");
        set2.add("b");
        set2.add("c");
    }
}
