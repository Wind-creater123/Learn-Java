package Reflect;

public class ReflectDemo1 {
    public static void main(String[] args) throws  Exception {
        //
        Class c1=Student.class;
        System.out.println(c1);

        //
        Class c2 =Class.forName("Reflect.Student");
        System.out.println(c2);

        //
        Student s=new Student();
        Class c3=s.getClass();
        System.out.println(c3);

        System.out.println(c1==c3);//true
        System.out.println(c2==c3);//true
    }
}
