package oop;

public class StudentOperator {
    Student student;

    public StudentOperator(Student student){
        this.student=student;
    }

    public void print(){
        System.out.println("Name:"+student.getName());
        System.out.println("Age:"+student.getAge());
        System.out.println("Gender:"+student.getGender());
        System.out.println("Weight:"+student.getWeight());
        System.out.println("Height:"+student.getHeight());
    }
}
