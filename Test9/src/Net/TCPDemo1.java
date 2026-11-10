package Net;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPDemo1 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",9999);
        OutputStream os = socket.getOutputStream();

        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(1);
        dos.writeUTF("hello");

    }
}
