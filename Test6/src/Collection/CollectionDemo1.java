package Collection;

import java.util.*;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
        String rs=list.get(0);
        System.out.println(rs);

        //
        Set<String> set=new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println(set);

        //
        Collection<String> collection=new ArrayList<>();
        //add
        collection.add("a");
        collection.add("b");
        collection.add("c");
        System.out.println(collection);//
        //size()
        System.out.println(collection.size());
        //remove();
        collection.remove("a");
        System.out.println(collection);
        //judge isEmpty
        System.out.println(collection.isEmpty());//false
        //clear
        collection.clear();
        System.out.println(collection.isEmpty());//true
        //judge contains
        System.out.println(collection.contains("a"));
        //toArray转数组
        Object[] array=collection.toArray();
        System.out.println(Arrays.toString(array));

    }
}
