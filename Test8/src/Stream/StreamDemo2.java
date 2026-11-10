package Stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //1.Collection
        Collection<String> list=new ArrayList<>();
        Stream<String> stream=list.stream();

        Map<String,Integer> map=new HashMap<>();
        Stream<String> stream1=map.keySet().stream();
        Stream<Integer> stream2=map.values().stream();
        Stream<Map.Entry<String, Integer>> stream3=map.entrySet().stream();

        //2.array
        String[] names={"a","b","c"};
        Stream<String> stream4= Arrays.stream(names);

        //3.stream
        Stream<String> stream5= Stream.of(names);
        Stream<String> stream6= Stream.of("a","b","c");
    }
}
