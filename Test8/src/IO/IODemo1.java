package IO;

import java.io.FileInputStream;
import java.io.InputStream;

public class IODemo1{
    public static void main(String[] args) throws Exception {
        InputStream is=new FileInputStream("Test8\\src\\IO\\isfile");

        //读字节
        int a=0;
        while((a=is.read())!=-1){
            System.out.print((char)a);
        }

        //读字节数组
        byte[] buffer=new byte[8];
        int len;
        while((len=is.read(buffer))!=-1){
            String str=new String(buffer,0,len);
            System.out.println(str);
        }

        //读取all为字节数组
        byte[] bytes =is.readAllBytes();
        String str=new String(bytes,0,bytes.length);
        System.out.println(str);
    }
}
