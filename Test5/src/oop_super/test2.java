package oop_super;

public class test2 {
    public static void main(String[] args) {
        Swim s1=new Swim() {
            @Override
            public void swim() {
                System.out.println("s1");
            }
        };
        start(s1);

        start(new Swim() {
            @Override
            public void swim() {
                System.out.println("s2");
            }
        });
    }

    public static void start(Swim swim) {
        System.out.println("start");
        swim.swim();
        System.out.println("end");
    }
}

interface Swim{
    void swim();
}