package different_class.interface_class;

public class Test {
    public static void main(String[] args) {
        Student[] allstudents=new Student[6];
        allstudents[0]=new Student("1",'m',100);
        allstudents[1]=new Student("2",'f',200);
        allstudents[2]=new Student("3",'m',300);
        allstudents[3]=new Student("4",'f',400);
        allstudents[4]=new Student("5",'m',500);
        allstudents[5]=new Student("6",'f',600);


        ClassDataInter cdi=new ClassDataInterImpl1(allstudents);
        System.out.println("方案1: ");
        cdi.printAllStudentInfos();
        cdi.printAverageScore();
        System.out.println("方案2：");
        cdi=new ClassDataInterImpl2(allstudents);
        cdi.printAllStudentInfos();
        cdi.printAverageScore();

    }
}
