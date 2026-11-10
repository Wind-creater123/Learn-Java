package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();

        names.add("A");
        names.add("B");
        names.add("C");
        System.out.println(names);
        //添加
        names.add(2,"D");
        System.out.println(names);
        //删除
        names.remove(1);
        //修改
        names.set(3,"E");
        //获取
        System.out.println(names.get(2));

        //0,有索引
        for(int i=0;i<names.size();i++){
            System.out.println(names.get(i));
        }

        //1
        Iterator<String>  iterator=names.iterator();
        while(iterator.hasNext()){
            String name=iterator.next();
            System.out.println(name);
        }
        //2
        for(String name:names){
            System.out.println(name);
        }
        //3
        names.forEach(System.out::println);
    }
}
