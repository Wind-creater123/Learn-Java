package TestProject.Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * 聊天服务器启动类。
 */
public class Server {
    // 保存在线客户端的Socket和对应昵称。
    // ConcurrentHashMap支持多个客户端线程同时访问。
    public static final Map<Socket,String> onLineSockets = new ConcurrentHashMap<>();

    /**
     * 启动服务器并持续接收客户端连接。
     */
    public static void main(String[] args) {
        System.out.println("Server Started");
        try {
            // 创建服务器Socket并监听固定端口。
            ServerSocket serverSocket = new ServerSocket(Constant.PORT);
            while (true) {
                System.out.println("Waiting for connection...");
                // 等待客户端连接。accept会阻塞直到有新客户端接入。
                Socket socket = serverSocket.accept();
                // 每个客户端使用一个独立线程处理。
                new ServerThread(socket).start();
                System.out.println("Connection Accepted");
            }
        }catch (Exception e){
            // 服务器启动或运行失败时抛出异常。
            throw  new RuntimeException(e);
        }
    }
}
