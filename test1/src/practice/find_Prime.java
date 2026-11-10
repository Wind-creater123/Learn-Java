package practice;

public class find_Prime {
    public static void main(String[] args) {
        int count=0;
        for(int i=101;i<=200;i++) {
            if (isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("素数个数："+count);
    }

    private static boolean isPrime(int n) {
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
