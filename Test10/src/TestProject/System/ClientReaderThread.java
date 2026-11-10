package TestProject.System;

import java.io.DataInputStream;
import java.net.Socket;

/**
 * 客户端消息读取线程。
 *
 * 负责持续读取服务器发送的在线用户列表和群聊消息，
 * 避免网络读取操作阻塞Swing界面线程。
 */
public class ClientReaderThread extends Thread {
    // 与服务器建立的客户端连接。
    private final Socket socket;
    // 用于更新聊天界面的窗口对象。
    private final ChatFrame chatFrame;

    public ClientReaderThread(Socket socket,ChatFrame chatFrame) {
        // 保存连接和界面引用，供读取线程使用。
        this.socket = socket;
        this.chatFrame = chatFrame;
    }

    @Override
    public void run() {
        try {
            // 获取服务器输入流，读取服务器推送的数据。
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while(true){
                // 每条服务器消息的开头都是消息类型。
                int type=dis.readInt();
                switch(type){
                    case 1:
                        // 消息类型1表示服务器推送在线用户列表。
                        updateClientOnlineUserList(dis);
                        break;
                    case 2:
                        // 消息类型2表示服务器推送群聊消息。
                        chatFrame.appendMessage(dis.readUTF());
                        break;
                    default:
                        // 收到未知类型时停止读取，避免错误解析后续数据。
                        throw new IllegalStateException("未知消息类型：" + type);
                }
            }
        } catch (Exception e) {
            // 读取失败通常表示服务器或网络连接已经断开。
            chatFrame.showConnectionClosed();
        }
    }

    /**
     * 读取服务器发送的在线用户列表。
     */
    private void updateClientOnlineUserList(DataInputStream dis) throws Exception {
        // 先读取在线用户数量。
        int count=dis.readInt();

        // 按数量读取每个用户的昵称。
        String[] onlineNames=new String[count];
        for(int i=0;i<count;i++){
            onlineNames[i] = dis.readUTF();
        }
        chatFrame.updateOnlineUsers(onlineNames);
    }
}
