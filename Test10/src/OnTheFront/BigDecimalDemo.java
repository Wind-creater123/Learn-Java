package OnTheFront;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
         double a=0.1;
         double b=0.2;
         System.out.println(a+b);

         //
        BigDecimal b1=new BigDecimal(a);
        BigDecimal b2=new BigDecimal(b);
        System.out.println(b1.add(b2).doubleValue());

        BigDecimal i=BigDecimal.valueOf(0.1);
        BigDecimal j=BigDecimal.valueOf(0.2);
        BigDecimal k=i.divide(j,2, RoundingMode.HALF_UP);
        System.out.println(k);

    }
}
