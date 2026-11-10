package oop_super;

public class test {
    public static void main(String[] args) {
        Animal animal=new Animal() {
            @Override
            public void cry() {
                System.out.println("cry");
            }
        };
        animal.cry();
    }
}
