package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection<String> names=new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        //迭代器
        Iterator<String> iterator=names.iterator();
        while(iterator.hasNext()){
            String name=iterator.next();
            System.out.println(name);
        }

        //增强for
        for(String s:names){
            System.out.println(s);
        }

        //Lambda表达式
        names.forEach(System.out::println);
//      names.forEach(new Consumer<String>() {
//          @Override
//          public void accept(String s) {
//              System.out.println(s);
//          }
//      });
    }
}
