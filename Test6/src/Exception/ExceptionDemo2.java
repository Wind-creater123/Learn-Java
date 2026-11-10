package Exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println("begin");
        System.out.println(div(10,0));
        System.out.println("end");
    }

    private static int div(int a, int b) {
        if(b==0) {
            System.out.println("cannot divide by zero");
            throw new RuntimeException("cannot divide by zero");
        }
        int result = a / b;
        return result;
    }
}
