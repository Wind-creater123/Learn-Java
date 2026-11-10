package print_and_scanf;

public class relation {
    public static void main(String[] args) {
        print(10,2);
        print2(10,10);
        print3(10,20,30);
    }

    public static void print(int a,int b) {
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a!=b);
    }

    public static void print2(int a,int b){
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        System.out.println(a==b);
        System.out.println(a!=b);
    }

    public static  void print3(int a,int b,int c){
        int d=a>b?a:b;
        System.out.println(d);
        //嵌套
        int e=a>b?a>c?a:c:b>c?b:c;
        System.out.println(e);
        //int f=a>b?(a>c?a:c):(b>c?b:c);
    }
}
