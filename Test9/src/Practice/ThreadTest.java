package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {
    public static void main(String[] args) {
        List<Integer> redPacket = getRedPacket();

        for(int i=1;i<=100;i++){
            new PeopleGetRedPacket(redPacket,"人");
        }
    }

    public static List<Integer> getRedPacket() {
        Random random = new Random();
        List<Integer> redPacket = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            redPacket.add(random.nextInt(30)+1);
        }
        for (int i = 0; i < 50; i++) {
            redPacket.add(random.nextInt(70)+1);
        }
        return redPacket;
    }
}
