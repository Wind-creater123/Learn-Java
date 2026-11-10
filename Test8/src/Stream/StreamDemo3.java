package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        //filter
        list.stream().filter(s->s.length()==3).forEach(System.out::println);

        List<Double> scores=new ArrayList<>();
        scores.add(1.0);
        scores.add(2.0);
        scores.add(3.0);

        //sorted
        scores.stream().sorted().forEach(System.out::println);
        //降序
        scores.stream().sorted((s1,s2)-> Double.compare(s2,s1)).forEach(System.out::println);

        //limit
        scores.stream().sorted((s1,s2)-> Double.compare(s2,s1)).limit(2).forEach(System.out::println);

        //skip
        scores.stream().sorted().skip(2).forEach(System.out::println);

        //distinct
        scores.stream().sorted().distinct().forEach(System.out::println);

        //map
        scores.stream().map(s->s+10).forEach(System.out::println);

        //concat
        Stream<String> s1=Stream.of("a","b","c");
        Stream<Integer> s2=Stream.of(1,2,3);
        Stream<Object> s3=Stream.concat(s1,s2);
    }
}
