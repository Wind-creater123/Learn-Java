package generic;

import java.util.ArrayList;

public class GenericDemo4 {
    public static void main(String[] args) {
        ArrayList<XiaoMi> xiaoMis = new ArrayList<XiaoMi>();
        xiaoMis.add(new XiaoMi());
        xiaoMis.add(new XiaoMi());
        xiaoMis.add(new XiaoMi());
        go(xiaoMis);

        ArrayList<BYD> byds=new ArrayList<>();
        byds.add(new BYD());
        byds.add(new BYD());
        byds.add(new BYD());
        go(byds);
    }

    private static void go(ArrayList<?extends Car> cars) {

    }
}
