package array;

public class static_array {
    public static void main(String[] args) {
        randomCall();
    }

    private static void randomCall() {
        String[] names={"1","2"};

        int index=(int)(Math.random()*names.length);

        String name=names[index];
        System.out.println(name);
    }
}
