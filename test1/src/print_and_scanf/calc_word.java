package print_and_scanf;

public class calc_word {
    public static void main(String[] args) {
        int a = 10;
        a++;
        System.out.println(a);
        ++a;
        System.out.println(a);
        ;
        a--;
        System.out.println(a);
        --a;
        System.out.println(a);

        int b = a++;
        System.out.println(b);
        a--;
        b = ++a;
        System.out.println(b);
        --a;

        int c = 0;
        c += 1;
        System.out.println(c);
        c -= 1;
        System.out.println(c);
        c *= 2;
        System.out.println(c);
        c /= 2;
        System.out.println(c);

    }
}
