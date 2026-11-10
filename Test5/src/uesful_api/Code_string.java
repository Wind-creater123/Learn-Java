package uesful_api;

public class Code_string {
    public static void main(String[] args) {
        String code=getCode(4);
        System.out.println(code);

        System.out.println(getCode(6));
    }

    public static String getCode(int n){
        String str="qwertyuiopasdfghjklzxcvbnm";

        String code="";

        for(int i=0;i<n;i++){
            int index=(int)(Math.random()*str.length());//[0,26)
            code+=str.charAt(index);
        }

        return code;
    }
}
