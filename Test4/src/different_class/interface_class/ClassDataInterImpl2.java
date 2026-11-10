package different_class.interface_class;

public class ClassDataInterImpl2 implements ClassDataInter {
    private Student[] students;
    public  ClassDataInterImpl2(Student[] students){
        this.students=students;
    }
    @Override
    public void printAllStudentInfos() {
        int male=0;
        int female=0;
        for(int i=0;i<students.length;i++){
            Student s=students[i];
            System.out.println(s.toString());
            if(s.getSex()=='m'){
                male++;
            }
            else {
                female++;
            }
        }
        System.out.println("Male: "+male+"\n"
                +"Female: "+female);
    }

    @Override
    public void printAverageScore() {
        double sum=0;
        double max=students[0].getScore();
        double min=students[0].getScore();
        for(int i=0;i<students.length;i++){
            Student s=students[i];
            sum+=s.getScore();

            if(s.getScore()>max){
                max=s.getScore();
            }
            if(s.getScore()<min){
                min=s.getScore();
            }
        }
        System.out.println("max: "+max);
        System.out.println("min: "+min);
        System.out.println("Average score: "+(sum-min-max)/(students.length-2));
    }
}
