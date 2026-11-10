package lambda_function;

public class lambda {
    public  static void main(String[] args) {
        Swim s=new Swim() {
            @Override
            public void swim() {
                System.out.println("swim");
            }
        };

        Swim s1 = () -> {
            System.out.println("swim lambda");
        };

        Swim s2 = () -> System.out.println("swim lambda2");


    }
}
