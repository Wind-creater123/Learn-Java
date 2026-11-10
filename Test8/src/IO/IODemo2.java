package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IODemo2 {
    static void main(String[] args) throws IOException {
        OutputStream os=new FileOutputStream("Test8\\src\\IO\\isfile");
        OutputStream os2=new FileOutputStream("Test8\\src\\IO\\isfile",true);

        os.write(97);
        os.write('a');
        os.write("\r\n".getBytes());

        byte[] b="13456789".getBytes();
        os.write(b);
        os.write("\r\n".getBytes());

        os.write(b,0,3);
        os.write("\r\n".getBytes());

        os2.write(b,3,3);

        //
        os.close();
    }
}
