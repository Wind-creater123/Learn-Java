package Practice;

import java.util.Scanner;

public class Test {
    public  static void main(String[] args) {
        JD[] jds = new JD[4];
        jds[0] = new TV("MiTv",true);
        jds[1] = new WashMachine("MDWm",false);
        jds[2] =new Lamp("ODLp",true);
        jds[3] =new AirCondition("MDAc",false);

        SmartHomeControl smartHomeControl=SmartHomeControl.getInstance();

        while(true) {
            smartHomeControl.printAllStatus(jds);
            System.out.println("the machine you choose:");
            Scanner sc=new Scanner(System.in);
            String command=sc.next();
            switch (command) {
                case "1":
                    smartHomeControl.control(jds[0]);
                    break;
                case "2":
                    smartHomeControl.control(jds[1]);
                    break;
                case "3":
                    smartHomeControl.control(jds[2]);
                    break;
                case "4":
                    smartHomeControl.control(jds[3]);
                    break;
                case "exit":
                    System.out.println("exit");
                    return;
                default:
                    System.out.println("invalid command");
                    break;
            }
        }

    }
}
