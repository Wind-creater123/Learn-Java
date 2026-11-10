package practice;

public class ver_code {
    public static void main(String[] args) {
        String code=verCode(6);
        System.out.println(code);
    }

    //生成验证码
    private static String verCode(int n) {
        String code="";
        for (int i=0;i<=n;i++){
            int type=(int)(Math.random()*3);
            switch (type){
                case 0:
                    int num=(int)(Math.random()*10);
                    code+=num;
                    break;
                case 1:
                    int num1=(int)(Math.random()*26);//0~25
                    char ch1=(char)('A'+num1);//65~90
                    code+=ch1;
                    break;
                case 2:
                    int num2=(int)(Math.random()*26);//0~25
                    char ch2=(char)('a'+num2);//97~122
                    code+=ch2;
                    break;
            }
        }

        return code;
    }
}
