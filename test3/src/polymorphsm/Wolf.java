package polymorphsm;

public class Wolf extends Animal{
    @Override
    public void run(){
        System.out.println("Wolf.run()");
    }

    public void eatSheep(){
        System.out.println("Wolf.eatSheep()");
    }
}
