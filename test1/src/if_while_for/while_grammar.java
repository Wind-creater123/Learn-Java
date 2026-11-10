package if_while_for;

public class while_grammar {
    public static void main(String[] args) {
        int count=test1();
        test2();
        print99();
    }

    private static void test2() {
        int i=1;
        do{
            System.out.println("hello");
            i++;
        }while(i<3);
    }

    private static int test1() {
        int count=0;
        double height=8848860;
        double thickness=0.1;

        while(thickness<height){
            count++;
            thickness=thickness*2;
        }

        return count;
    }

    private  static void loop() {
//        for(;;){
//            System.out.println("hello");
//        }

        //死循环--->服务器会用
        while(true){
            System.out.println("hello");
        }

//        do{
//            System.out.println("hello");
//        }while (true);
    }

    private static void print99(){
        for(int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j+"x"+i+"="+(j*i)+"\t");
            }
            System.out.println();
        }
    }
}
