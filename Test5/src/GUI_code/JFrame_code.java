package GUI_code;

import javax.swing.*;

public class JFrame_code {
    public static void main(String[] args) {
        JFrame jf=new JFrame("login");

        JPanel jp=new JPanel();
        jf.add(jp);

        jf.setSize(400,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jb=new JButton("login");
        jp.add(jb);

        jf.setVisible(true);
    }
}
