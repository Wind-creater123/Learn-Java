package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //put
        map.put("a",0);
        map.put("b",1);
        map.put("c",2);
        System.out.println(map);

        //getByKey
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        //
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsKey("b"));
        //
        System.out.println(map.containsValue(0));
        System.out.println(map.containsValue(1));

        //removeByKey
        map.remove("a");
        System.out.println(map);

        System.out.println(map.size());
        //map.clear();
        System.out.println(map);
        map.isEmpty();

        //key不重复,无序
        Set<String> keys=map.keySet();
        for(String key:keys){
            System.out.println(key);
        }
        //value可重复
        Collection<Integer> values=map.values();
        for(Integer value:values){
            System.out.println(value);
        }

    }
}
