package IO;

import java.io.*;

public class IODemo3 {
    public static void main(String[] args) {

    }

    //资源释放(1)
    public static void copyFile(String src,String dst){
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dst);
            byte[] b = new byte[1024];
            int len;
            while((len=fis.read(b))!=-1){
                fos.write(b,0,len);
            }
        } catch (Exception e) {
            throw  new RuntimeException(e);
        } finally {
          try {
              if (fis != null) {
                  fis.close();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
          try {
              if (fos != null) {
                  fos.close();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
        }
    }

    //*资源释放(2)
    public static void copyFile2(String src,String dst) {
        try (
                InputStream fis = new FileInputStream(src);
                OutputStream fos = new FileOutputStream(dst);
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
