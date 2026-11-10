package oop;

public class Student_test {
    public static void main(String[] args) {
        Student s1=new Student();
//        s1.name="S1";
//        s1.age=10;
//        s1.height=20;
//        s1.weight=20;
//        s1.gender="Male";
        s1.setName("s1");
        s1.setAge(10);
        s1.setGender("M");
        s1.setHeight(20);
        s1.setWeight(20);

        StudentOperator studentOperator=new StudentOperator(s1);

        studentOperator.print();
    }
}
