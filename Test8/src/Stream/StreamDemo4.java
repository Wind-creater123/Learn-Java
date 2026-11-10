package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo4 {
    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();

        teachers.add(new Teacher("a",1,1));
        teachers.add(new Teacher("b",2,2));
        teachers.add(new Teacher("c",3,3));

        //forEach
        teachers.stream().filter(t->t.getSalary()>2).forEach(System.out::println);

        //count
        long count = teachers.stream().filter(t->t.getSalary()>2).count();
        System.out.println(count);

        //max\min
        Optional<Teacher> max = teachers.stream().max(Comparator.comparingDouble(Teacher::getSalary));
        Teacher teacherMax = max.get();
        Optional<Teacher> min = teachers.stream().min((t1, t2)->Double.compare(t1.getSalary(),t2.getSalary()));
        Teacher teacherMin = min.get();
        System.out.println(teacherMin.getSalary());
        System.out.println(teacherMax.getSalary());

        //
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        //collect
        List<String> list2=list.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());
        System.out.println(list2);

        //set
        Set<String> set2=list.stream().filter(s->s.startsWith("a")).collect(Collectors.toSet());
        System.out.println(set2);

        //map
        Map<String,Double> map=teachers.stream().sorted().collect(Collectors.toMap(Teacher::getName,Teacher::getSalary));
        System.out.println(map);

        //array
        Object[] array=list.stream().filter(s->s.startsWith("a")).toArray();
        System.out.println(Arrays.toString(array));

    }
}