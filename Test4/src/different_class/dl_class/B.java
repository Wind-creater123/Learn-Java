package different_class.dl_class;

public class B {
    private static  B b;

    private  B() {
    }

    public static  B getInstance() {
        if(b==null){
            b=new B();
        }
        return b;
    }
}
