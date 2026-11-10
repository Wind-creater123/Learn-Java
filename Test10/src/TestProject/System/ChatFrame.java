package TestProject.System;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 局域网聊天主窗口。
 */
class ChatFrame extends JFrame {
    // 当前登录用户的昵称
    private final String nickname;
    // 聊天消息显示区域和消息输入框
    private final JTextArea messageArea;
    private final JTextField messageField;
    // 与服务器建立的连接，以及用于发送消息的数据输出流
    private final Socket socket;
    private final DataOutputStream dos;
    // 在线用户列表的数据模型和显示组件
    private final DefaultListModel<String> onlineModel = new DefaultListModel<>();
    private final JList<String> onlineUsers = new JList<>(onlineModel);
    // 在线用户列表所在的滚动面板，用于显示在线人数标题
    private final JScrollPane onlineScrollPane;

    ChatFrame(String nickname, Socket socket) throws Exception {
        this.nickname = nickname;
        this.socket = socket;
        this.dos = new DataOutputStream(socket.getOutputStream());

        // 初始化聊天窗口的基本属性
        setTitle("局域网聊天 - " + nickname);
        setSize(760, 520);
        setMinimumSize(new Dimension(620, 420));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建消息显示区域，该区域只允许查看消息，不能直接编辑
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        messageArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        messageArea.append("系统：欢迎加入局域网聊天室，" + nickname + "！\n");

        // 将消息区域放入带滚动条的面板中
        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        messageScrollPane.setBorder(BorderFactory.createTitledBorder("消息"));

        // 初始化在线用户列表，真实用户数据由服务器登录后推送
        onlineUsers.setModel(onlineModel);
        onlineUsers.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        onlineUsers.setFixedCellHeight(30);

        // 将在线用户列表放入右侧面板
        onlineScrollPane = new JScrollPane(onlineUsers);
        onlineScrollPane.setPreferredSize(new Dimension(180, 0));
        onlineScrollPane.setBorder(BorderFactory.createTitledBorder("在线人数（加载中）"));

        // 中央区域：左侧显示消息，右侧显示在线用户
        JPanel contentPanel = new JPanel(new BorderLayout(10, 0));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        contentPanel.add(messageScrollPane, BorderLayout.CENTER);
        contentPanel.add(onlineScrollPane, BorderLayout.EAST);

        // 创建消息输入框和发送按钮
        messageField = new JTextField();
        messageField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        JButton sendButton = new JButton("发送");
        sendButton.setPreferredSize(new Dimension(85, 32));
        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());

        // 底部区域：输入框在中间，发送按钮在右侧
        JPanel inputPanel = new JPanel(new BorderLayout(8, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // 将主要内容区域和输入区域加入窗口
        add(contentPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // 启动线程，持续接收服务器转发的消息和在线用户列表
        new ClientReaderThread(socket, this).start();
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (message.isEmpty()) {
            // 不发送空消息
            messageField.requestFocusInWindow();
            return;
        }

        try {
            // 消息类型为2，后面写入具体的群聊内容
            dos.writeInt(2);
            dos.writeUTF(message);
            dos.flush();
            messageField.setText("");
            messageField.requestFocusInWindow();
        } catch (Exception e) {
            // 发送失败通常表示服务器连接已经断开
            showConnectionClosed();
        }
    }

    public void updateOnlineUsers(String[] onlineNames) {
        // 网络线程不能直接更新Swing组件，交给界面线程处理
        SwingUtilities.invokeLater(() -> {
            onlineModel.clear();
            for (String onlineName : onlineNames) {
                onlineModel.addElement(onlineName.equals(nickname) ? onlineName + "（我）" : onlineName);
            }
            // 标题只设置在滚动面板上，避免JList和JScrollPane同时显示两个标题
            onlineScrollPane.setBorder(
                    BorderFactory.createTitledBorder("在线人数（" + onlineNames.length + "）")
            );
        });
    }

    public void appendMessage(String message) {
        // 在聊天区域追加服务器转发的群聊消息
        SwingUtilities.invokeLater(() -> {
            messageArea.append(message + "\n");
            messageArea.setCaretPosition(messageArea.getDocument().getLength());
        });
    }

    public void showConnectionClosed() {
        // 连接断开后禁止继续输入，并提示用户
        SwingUtilities.invokeLater(() -> {
            messageField.setEnabled(false);
            messageArea.append("系统：与服务器的连接已断开。\n");
            messageArea.setCaretPosition(messageArea.getDocument().getLength());
        });
    }
}
