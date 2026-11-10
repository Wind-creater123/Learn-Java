package Practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public  static void main(String[] args) {
        List<Prisoner> prisoners = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int code = (int)(Math.random() * 100);
            if(isRepeat(prisoners,code)){
                i--;
                continue;
            }
            Prisoner prisoner = new Prisoner(code, i);
            prisoners.add(prisoner);
        }
        System.out.println(prisoners);

        while(true){
            List<Prisoner> lastPrisoners = new ArrayList<>();
            for (int i = 1; i < prisoners.size(); i+=2) {
                lastPrisoners.add(prisoners.get(i));
            }
            if(lastPrisoners.size() ==1){
                Prisoner prisoner =lastPrisoners.get(0);
                System.out.println(prisoner.getId()+" "+prisoner.getFirstLocation());
                break;
            }
            prisoners = lastPrisoners;
        }
    }

    public static boolean isRepeat(List<Prisoner> prisoners,int code) {
        for(Prisoner prisoner : prisoners) {
            if(prisoner.getId() == code) {
                return true;
            }
        }
        return false;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Prisoner {
    private int id;
    private int firstLocation;
}
