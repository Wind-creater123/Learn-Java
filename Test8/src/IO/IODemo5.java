package IO;

import java.io.*;

public class IODemo5 {
    public static void main(String[] args) {
        try (
                Reader fr=new FileReader("Test8\\src\\IO\\isfile");
                BufferedReader br=new BufferedReader(fr);
        ){
            char[] chars=new char[1024];
            int len;
            while((len=br.read(chars))!=-1){
                String str=new String(chars,0,len);
                System.out.println(str);
            }

            String line;
            while ((line=br.readLine())!=null) {
                System.out.println(br.readLine());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //
        try (
                Writer fw=new FileWriter("Test8\\src\\IO\\isfile");
                BufferedWriter bw=new BufferedWriter(fw);

            ){
            bw.write('c');
            bw.write(98);
            bw.write("abc");
            bw.newLine();//

            bw.flush();

            bw.write("java");
            char[]  chars="java".toCharArray();
            bw.write(chars);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  static void copyFile(String src,String dest){
        try (
                InputStream in = new FileInputStream(src);
                InputStream bis=new BufferedInputStream(in);
                OutputStream out=new FileOutputStream(dest);
                OutputStream bos=new BufferedOutputStream(out);
                ){

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
