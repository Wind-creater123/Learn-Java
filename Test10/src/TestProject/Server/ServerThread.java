package TestProject.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * 服务端客户端连接处理线程。
 *
 * 每个客户端连接对应一个ServerThread，负责读取客户端请求，
 * 处理登录和群聊消息，并向其他客户端转发数据。
 */
public class ServerThread  extends  Thread {
    // 当前线程负责处理的客户端连接。
    private Socket socket;

    public ServerThread(Socket socket) {
        // 保存客户端Socket，后续通过它读取和发送数据。
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 获取客户端发送数据的输入流。
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            while (true) {
                // 每条客户端请求的开头都是请求类型。
                int type =dis.readInt();
                switch (type){
                    case 1:
                        // 类型1表示客户端登录，读取昵称并加入在线列表。
                        String nickname=dis.readUTF();
                        Server.onLineSockets.put(socket,nickname);
                        // 登录用户增加后，将最新在线列表通知所有客户端。
                        updateClientOnlineList();
                        break;
                    case 2:
                        // 类型2表示群聊消息，将消息转发给所有在线客户端。
                        String msg=dis.readUTF();
                        sendMsgToAll(msg);
                        break;
                    case 3:
                        // 类型3预留给其他功能，目前不执行具体操作。
                        break;
                    default:
                        // 收到未知请求类型时停止处理当前连接。
                        throw new IllegalStateException("未知消息类型：" + type);
                }
            }
        }catch(Exception e){
            // 客户端断开或通信异常时，从在线列表中移除客户端。
            if (Server.onLineSockets.remove(socket) != null) {
                System.out.println("Server offline:"+socket.getInetAddress().getHostName());
                // 用户下线后通知其余客户端更新在线列表。
                updateClientOnlineList();
            }
        }
    }

    /**
     * 给所有在线客户端发送群聊消息。
     */
    private void sendMsgToAll(String msg) {
        // 获取发送者昵称。未登录客户端不能发送群聊消息。
        StringBuilder sb=new StringBuilder();
        String name =Server.onLineSockets.get(socket);
        if (name == null) {
            return;
        }
        // 生成消息发送时间。
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE a");
        String now=dtf.format(ldt);
        // 拼接发送者、时间和消息内容，形成客户端显示的文本。
        String msgResult = sb.append(name).append(" ").append(now).append("\r\n").append(msg).append("\r\n").toString();
        for(Socket socket: Server.onLineSockets.keySet()){
            try {
                // 向每个在线客户端发送群聊消息类型和消息内容。
                DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
                dos.writeInt(2);
                dos.writeUTF(msgResult);
                dos.flush();
            }catch (Exception e){
                // 某个客户端发送失败时，移除并关闭失效连接。
                if (Server.onLineSockets.remove(socket) != null) {
                    try {
                        socket.close();
                    } catch (Exception ignored) {
                        // 已经断开的连接无需再次处理。
                    }
                }
            }
        }

    }

    /**
     * 将当前在线用户列表发送给所有在线客户端。
     */
    private void updateClientOnlineList() {
        // 获取全部在线用户昵称。
        Collection<String> onlineUsers = Server.onLineSockets.values();
        for(Socket socket:Server.onLineSockets.keySet()){
            try {
                // 发送在线列表消息类型和在线人数。
                DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
                dos.writeInt(1);
                dos.writeInt(onlineUsers.size());
                // 依次发送每个在线用户的昵称。
                for(String nickname:onlineUsers){
                    dos.writeUTF(nickname);
                }
                dos.flush();
            } catch (Exception e){
                // 更新列表失败时移除对应的失效连接。
                Server.onLineSockets.remove(socket);
            }
        }
    }
}
