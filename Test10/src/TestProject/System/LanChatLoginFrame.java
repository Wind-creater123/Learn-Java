package TestProject.System;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 局域网聊天登录界面。
 */
public class LanChatLoginFrame extends JFrame{
    // 用于输入用户昵称的文本框。
    private final JTextField nicknameField;
    // 登录成功后保存的客户端Socket。
    private Socket socket;

    public LanChatLoginFrame() {
        // 设置登录窗口的基本属性。
        setTitle("局域网聊天");
        setSize(360, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 使用网格包布局组织登录界面。
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        // 设置组件在网格中的间距和填充方式。
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 创建昵称提示标签。
        JLabel nicknameLabel = new JLabel("昵称：");

        // 创建昵称输入框。
        nicknameField = new JTextField(18);

        // 创建进入聊天按钮。
        JButton enterButton = new JButton("进入");

        // 创建取消按钮。
        JButton cancelButton = new JButton("取消");

        // 第一行放置昵称标签和输入框。
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        mainPanel.add(nicknameLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        mainPanel.add(nicknameField, gbc);

        // 第二行放置进入和取消按钮。
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        // 点击进入按钮时执行登录流程。
        enterButton.addActionListener(e -> enterChat());

        // 点击取消按钮时关闭登录窗口。
        cancelButton.addActionListener(e -> dispose());

        // 在输入框中按回车与点击进入按钮效果相同。
        nicknameField.addActionListener(e -> enterChat());
    }

    /**
     * 校验昵称并进入聊天窗口。
     */
    private void enterChat() {
        // 去除昵称首尾空格，避免使用空白昵称登录。
        String nickname = nicknameField.getText().trim();

        if (nickname.isEmpty()) {
            // 昵称为空时提示用户并保持在登录界面。
            JOptionPane.showMessageDialog(
                    this,
                    "请输入昵称！",
                    "提示",
                    JOptionPane.WARNING_MESSAGE
            );
            nicknameField.requestFocus();
            return;
        }

        // 登录成功前给用户显示欢迎提示。
        JOptionPane.showMessageDialog(
                this,
                "欢迎你，" + nickname + "！",
                "进入聊天",
                JOptionPane.INFORMATION_MESSAGE
        );

        try {
            // 连接服务器并发送登录信息。
            login(nickname);
            // 创建聊天窗口，并关闭登录窗口。
            new ChatFrame(nickname,socket).setVisible(true);
            dispose();
        } catch (Exception e) {
            // 登录或创建聊天窗口失败时抛出异常。
            throw new RuntimeException(e);
        }
    }

    /**
     * 连接服务器，并按照通信协议发送登录请求。
     *
     * 消息类型1表示登录，后面跟随用户昵称。
     */
    private void login(String nickname) throws Exception{
        // 根据客户端配置连接服务器。
        socket =new Socket(Constant.SERVER_IP,Constant.SERVER_PORT);
        // 获取向服务器发送数据的输出流。
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
        // 写入登录消息类型和昵称。
        dos.writeInt(1);
        dos.writeUTF(nickname);
        // 立即将数据发送到服务器。
        dos.flush();
    }

    /**
     * 程序入口，在Swing事件调度线程中创建登录窗口。
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 创建并显示客户端登录界面。
            LanChatLoginFrame frame = new LanChatLoginFrame();
            frame.setVisible(true);
        });
    }
}
