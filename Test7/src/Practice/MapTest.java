package Practice;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        calc();

    }

    private static void calc() {
        List<String> locations=new ArrayList<>();
        String[] names={"a","b","c","d","e","f","g"};
        Random r=new Random();
        for(int i=1;i<=3;i++){
            int index=r.nextInt(names.length);
            locations.add(names[index]);
        }
        System.out.println(locations);

        Map<String,Integer> map=new HashMap<>();

        for(String location:locations){
//            if(map.containsKey(location)){
//                map.put(location,map.get(location)+1);
//            }else{
//                map.put(location,1);
//            }
            map.put(location, map.containsKey(location) ? map.get(location) + 1 : 1);

        }
        System.out.println(map);
    }
}
