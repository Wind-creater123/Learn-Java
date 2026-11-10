package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    public static void main(String[] args) throws  Exception {
        //
        Class c1 = Student.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        Constructor[] constructors = c1.getConstructors();
        Constructor[] constructors1 = c1.getDeclaredConstructors();
        Constructor constructor=c1.getConstructor();
        Constructor constructor1=c1.getDeclaredConstructor();

        Constructor constructor2=c1.getDeclaredConstructor(String.class);
        System.out.println(constructor2.getName()+" : "+constructor2.getParameterCount());

        //
        Class c2 = Student.class;

        Field[] fields = c2.getDeclaredFields();
        Field field1=c2.getDeclaredField("name");
        System.out.println(field1.getName()+" : "+field1.getType().getName());

        //
        Class c3 = Student.class;
        Method[] methods = c3.getDeclaredMethods();
        Method method=c3.getDeclaredMethod("getName");
        System.out.println(method.getName()+" : "+method.getParameterCount());



    }
}
