package OnTheFront;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeDemo {
    public static void main(String[] args) {
        Date d=new Date();
        System.out.println(d);

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(d));

        //
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonth());

        LocalDateTime now=ldt.plusSeconds(60);
        System.out.println(now);
        System.out.println(ldt);

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dtf.format(now));
    }
}
