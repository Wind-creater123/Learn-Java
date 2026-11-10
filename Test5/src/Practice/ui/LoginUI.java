package Practice.ui;

import Practice.bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginUI extends JFrame implements ActionListener {
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JButton registerButton;

    private  static ArrayList<User> allUsers=new ArrayList<>();

    //静态代码块
    static{
        allUsers.add(new User("1","1","1"));
        allUsers.add(new User("2","2","2"));
        allUsers.add(new User("3","3","3"));
    }

    public LoginUI() {
        super("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);

        loginShow();
    }

    private void loginShow() {
        //创建主面板
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 240, 240));

        //字体颜色
        Font customFont=new Font("Arial",Font.BOLD,20);
        Color primaryColor=new Color(66,135,245);
        Color secondaryColor=new Color(205,205,205);

        //标题
        JLabel title=new JLabel("Login");
        title.setBounds(50,30,300,30);
        title.setFont(new Font("Arial",Font.BOLD,24));
        panel.add(title);

        //用户名标签
        JLabel usernameLable=new JLabel("Username");
        usernameLable.setBounds(50,100,150,30);
        usernameLable.setFont(customFont);
        panel.add(usernameLable);

        //用户名输入框
        username=new JTextField();
        username.setBounds(160,100,190,30);
        username.setFont(customFont);
        panel.add(username);

        //密码标签
        JLabel passwordLable=new JLabel("Password");
        passwordLable.setBounds(50,150,150,30);
        passwordLable.setFont(customFont);
        panel.add(passwordLable);

        //密码输入框
        password=new JPasswordField();
        password.setBounds(160,150,190,30);
        password.setFont(customFont);
        password.setEchoChar('*');
        panel.add(password);

        //登录按钮
        loginButton=new JButton("Login");
        loginButton.setBounds(200,200,150,30);
        loginButton.setFont(customFont);
        loginButton.setBackground(secondaryColor);
        loginButton.setForeground(Color.white);
        panel.add(loginButton);
        loginButton.addActionListener(this);

        //注册按钮
        registerButton=new JButton("Register");
        registerButton.setBounds(200,200,150,30);
        registerButton.setFont(customFont);
        registerButton.setBackground(secondaryColor);
        registerButton.setForeground(Color.black);
        panel.add(registerButton);
        registerButton.addActionListener(this);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn==loginButton){
            //System.out.println("login button pressed");
            login();
        }
        else if(btn==registerButton){
            //System.out.println("register button pressed");
        }
    }

    private void login() {
        String loginUsername = username.getText();
        String loginPassword = new String(password.getPassword());

        User user=getUserByLoginUsername(loginUsername);
        if(user!=null){
            if(user.getPassword().equals(loginPassword)){
                System.out.println("Login successful");
                new EmployeeManangeUI(loginUsername);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Incorrect password");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Incorrect username or password");
        }
    }
    private User getUserByLoginUsername(String loginUsername) {
        for(int i=0;i<allUsers.size();i++){
            User user=allUsers.get(i);
            if(user.getUsername().equals(loginUsername)){
                return user;
            }
        }
        return null;
    }
}
