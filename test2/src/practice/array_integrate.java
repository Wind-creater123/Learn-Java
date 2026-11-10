package practice;

public class array_integrate {
    public static void main(String[] args) {
        start();

    }

    //新牌
    private static void start() {
        //数组存牌
        String[] poker=new String[54];
        //点数
        String[] numbers={"3","4","5","6","7","8","9"};
        //花色
        String[] colors={"1","2","3","4"};

        int index=0;
        for(int i=0;i<numbers.length;i++){
            for (int j=0;j<colors.length;j++){
                poker[index++]=numbers[i]+colors[j];
            }
        }
        //大小王
        poker[index++]="大王";
        poker[index]="小王";

        //印牌
        System.out.println("新牌：");
        for (int i = 0; i < poker.length; i++) {
            System.out.print(poker[i]+"\t");
        }
        System.out.println();
        //洗牌
        for(int i=0;i<poker.length;i++){
            int index1=(int)(Math.random()*poker.length);
            int index2=(int)(Math.random()*poker.length);
            String tmp=poker[index1];
            poker[index1]=poker[index2];
            poker[index2]=tmp;
        }

        System.out.println("洗牌后：");
        for (int i = 0; i < poker.length; i++) {
            System.out.println(poker[i]+"\t");
        }
    }
}
