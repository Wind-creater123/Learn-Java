package ProxyDemo;

public class ProxyDemo1 {
    public static void main(String[] args) {
        Star star=new Star("123");
        StarService proxy = ProxyUtil.createProxy(star);
        proxy.sing("");
        proxy.dance();

    }
}
