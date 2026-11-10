package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class IODemo4 {
    public static void main(String[] args){
        try (
                Reader fr=new FileReader("Test8\\src\\IO\\isfile");
        ){
            char[] chars=new char[1024];
            int len;
            while((len=fr.read(chars))!=-1){
                String str=new String(chars,0,len);
                System.out.println(str);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (Writer fw=new FileWriter("Test8\\src\\IO\\isfile")){
            fw.write('c');
            fw.write(98);
            fw.write("abc");

            fw.flush();

            fw.write("java");
            char[]  chars="java".toCharArray();
            fw.write(chars);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
