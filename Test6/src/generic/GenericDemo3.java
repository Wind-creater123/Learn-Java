package generic;

import different_class.abstract_class.Student;

public class GenericDemo3 {
    public  static void main(String[] args) {
        String[] names = new String[10];
        printArray(names);

        Student[] students = new Student[3];
        printArray(students);

        Student max=getMax(students);
        String max2=getMax(names);
    }

    private static <T> void printArray(T[] names) {

    }

    public static <T> T getMax(T[] array) {
        return null;
    }
}
