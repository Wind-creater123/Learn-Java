package polymorphsm;

public class Tortoise extends Animal{
    @Override
    public void run(){
        System.out.println("Tortoise.run()");
    }

    public void eatGrass(){
        System.out.println("Tortoise.eatGrass()");
    }
}
