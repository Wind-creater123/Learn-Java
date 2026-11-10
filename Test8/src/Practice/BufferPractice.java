package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BufferPractice {
    public static void main(String[] args) {
        try (
                BufferedReader br=new BufferedReader(new FileReader("Test8\\src\\Practice\\Buffered.txt"));
                BufferedWriter bw=new BufferedWriter(new FileWriter("Test8\\src\\Practice\\Buffered_out.txt"))
                ){
            List<String> list=new ArrayList<>();
            String line;
            while ((line=br.readLine())!=null){
                list.add(line);
            }
            Collections.sort(list);
            System.out.println(list);
            for(String s:list){
                bw.write(s);
                bw.newLine();
            }
        } catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
