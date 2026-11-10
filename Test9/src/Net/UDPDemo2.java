package Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPDemo2 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8080);
        byte[] bytes = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(bytes, 1024*64);

        socket.receive(packet);

        int len = packet.getLength();

        String data=new String(bytes,0,len);
        System.out.println(data);

        String ip=packet.getAddress().getHostAddress();
        int port = packet.getPort();
        socket.close();
    }
}
