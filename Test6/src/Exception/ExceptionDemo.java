package Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo{
        //RuntimeException
        public static void show(){
            int[] arr={1,2,3};
            System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
            //System.out.println("over");

            System.out.println(10/0);//ArithmeticException

            String str=null;
            System.out.println(str);
            System.out.println(str.length());//NullPointerException

            System.out.println("over");
        }

        //方法1，抛出异常
        public static void show2() throws ParseException {
            String str="2024-07-09 11:12:13";
            //抛出编译异常提醒，代码容易出错
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date= null;//编译时异常ParseException
            //方法2，自己处理异常
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                //e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println(date);
        }
}
