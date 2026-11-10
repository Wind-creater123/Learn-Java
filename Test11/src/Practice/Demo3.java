package Practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo3 {
    public static void main(String[] args) {
        Liquid water = new Liquid("water",4,24);
        Liquid milk=new Liquid("milk",8,160);
        Liquid wine=new Liquid("wine",2,4000);
        Liquid cola=new Liquid("cola",6,108);
        Liquid maotai=new Liquid("maotai",1,4000);

        List<Liquid> liquids=new ArrayList<>();
        Collections.addAll(liquids,water,milk,wine,cola,maotai);

        liquids=liquids.stream()
                .sorted((o1,o2)-> Double.compare(o2.getPrice(),o1.getPrice()))
                .collect(Collectors.toList());

        double total = 0;
        int all=10;
        for (int i = 0; i < liquids.size(); i++) {
            Liquid liquid = liquids.get(i);
            int weight = liquid.getWeight();
            if(weight>=all){
                total+=liquid.getPrice()*all;
                break;
            } else {
                total+=liquid.getPrice()*weight;
                all-=weight;
            }
        }
        System.out.println(total);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Liquid {
    private String name;
    private int weight;
    private int price;

    public double getPerPrice() {
        BigDecimal price = BigDecimal.valueOf(this.price);
        BigDecimal weight = BigDecimal.valueOf(this.weight);
        return price.divide(weight,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
