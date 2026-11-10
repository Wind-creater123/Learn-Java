package different_class.interface_class;

public class ClassDataInterImpl1 implements  ClassDataInter {
    private Student[] students;
    public  ClassDataInterImpl1(Student[] students){
        this.students=students;
    }

    @Override
    public void printAllStudentInfos(){
        System.out.println("All students informations are:");
        for(int i=0;i<students.length;i++){
            Student s=students[i];
            System.out.println(s.toString());
        }
    }

    @Override
    public void printAverageScore(){
        double sum=0;
        for(int i=0;i<students.length;i++){
            sum+=students[i].getScore();
        }
        System.out.println("Average score: "+sum/students.length);
    }
}
