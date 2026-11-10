package polymorphsm;

public class Test {
    public static void main(String[] args) {
        Animal a1=new Animal();
        a1.run();
        Animal a2=new Wolf();
        a2.run();
        go(a2);
        Animal a3=new Tortoise();
        a3.run();
        go(a3);

        System.out.println("-----------------");

        Wolf w=new Wolf();
        w.run();
        go(w);
        Tortoise t=new Tortoise();
        t.run();
        go(t);

        System.out.println("-----------------");

        go(a2);
        go(a3);
    }

    public static void go(Animal a){
        System.out.println("go()");
        a.run();
        if(a instanceof Tortoise){
            Tortoise t=(Tortoise)a;
            t.eatGrass();
        }
        else if(a instanceof Wolf){
            Wolf w=(Wolf)a;
            w.eatSheep();
        }
    }
}
