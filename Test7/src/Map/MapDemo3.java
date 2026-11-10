package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo3 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("a",0);
        map.put("b",1);
        map.put("c",2);

        //key->value
        Set<String> keys=map.keySet();
        for(String key:keys){
            Integer value=map.get(key);
            System.out.println("key:"+key+",value:"+value);
        }

        //键值对遍历
        Set<Map.Entry<String,Integer>> entries=map.entrySet();
        for(Map.Entry<String,Integer> entry:entries){
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }

        //lambda
//        map.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String key, Integer value) {
//                System.out.println("key:"+key+",value:"+value);
//            }
//        });
        map.forEach((key,value)-> System.out.println("key:"+key+",value:"+value));
    }
}
