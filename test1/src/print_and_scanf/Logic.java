package print_and_scanf;

public class Logic {
    public static void main(String[] args) {
        System.out.println(isMatch(180,70,"女"));
        System.out.println(isMatch2(180,70,320000));
        System.out.println(!isMatch2(180,70,320000));
    }

    public static boolean isMatch(int height,int weight,String sex){
        boolean result=height>170 && weight>=60 && sex=="女";
        return result;
    }

    public static boolean isMatch2(int height,int weight,int wage){
        boolean result=(height>170 && weight>=60)||wage>=30000;
        return result;
    }


}
