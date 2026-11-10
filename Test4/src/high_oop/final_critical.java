package high_oop;

public class final_critical {
    public static final String schoolName="666";

    //无意义
    private final String name="999";

    public static void main(String[] args) {
        final double rate=3.14;

        double z=0.9;
        buy(z);
    }

    public static void buy(final double money) {
        //money=0.1;
        System.out.println("money");
    }
}

final class A{}
//class B extends A{}

class C{
    public final void show(){
        System.out.println("C");
        return;
    }
}
//class D extends C{
//        @Override
//        public void show(){
//            System.out.println("D");
//        }
//
//}