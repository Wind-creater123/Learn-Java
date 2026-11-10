package Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        byte[] bytes ="哈哈啊哈哈".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),8080);
        socket.send(packet);
        socket.close();

    }
}
