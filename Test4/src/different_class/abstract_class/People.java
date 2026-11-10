package different_class.abstract_class;

public abstract class People {
    public void write(){
        System.out.println("write");
        WriteBy();
        System.out.println("write3");
    }

    public abstract void WriteBy();
}
