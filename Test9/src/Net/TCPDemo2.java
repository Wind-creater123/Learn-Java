package Net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = ss.accept();
        InputStream is=socket.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        int id =dis.readInt();
        String msg=dis.readUTF();
        System.out.println(id+":"+msg);
        System.out.println("ip:"+socket.getInetAddress().getHostAddress());
        System.out.println("port:"+socket.getPort());
    }
}
