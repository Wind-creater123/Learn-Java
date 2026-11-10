package if_while_for;

public class if_grammar {
    public static void main(String[] args) {
        ififif();
    }

    public static void ififif(){
        //1.获取信息改变red，yellow，green
        boolean red=false;
        boolean yellow=false;
        boolean green=true;

        if(red){
            System.out.println("停");
        }
        else if(yellow){
            System.out.println("准备");
        }
        else if(green){
            System.out.println("行");
        }
        else{
            System.out.println("故障");
        }
    }


}
