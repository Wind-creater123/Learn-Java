package Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("a1");
        arrayList.add("a2");
        arrayList.add("a3");
        arrayList.add("b1");
        arrayList.add("b2");
        arrayList.add("b3");

        //并发修改异常
        for(int i=0;i<arrayList.size();i++){
            String name=arrayList.get(i);
            if(name.contains("a")){
                arrayList.remove(i);
                i--;
            }
        }

        //倒着遍历(支持索引)
        for(int i=arrayList.size()-1;i>=0;i--){
            String name=arrayList.get(i);
            if(name.contains("a")){
                arrayList.remove(i);
            }
        }

        //迭代器
        Iterator<String> it=arrayList.iterator();
        while(it.hasNext()){
            String name=it.next();
            if(name.contains("a")){
                //迭代器方法删除，避免修改异常
                it.remove();
            }
        }
    }
}
