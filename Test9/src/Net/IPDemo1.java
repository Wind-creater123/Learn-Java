package Net;

import java.net.InetAddress;

public class IPDemo1 {
    public static void main(String[] args) {
        try {
            InetAddress ip1=InetAddress.getLocalHost();
            System.out.println(ip1.getHostAddress());
            System.out.println(ip1.getHostName());

            InetAddress ip2=InetAddress.getByName("www.baidu.com");
            System.out.println(ip2.getHostAddress());
            System.out.println(ip2.getHostName());

            System.out.println(ip2.isReachable(5000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
