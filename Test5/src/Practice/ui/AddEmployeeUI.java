package Practice.ui;

import Practice.bean.Employee;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class AddEmployeeUI extends JFrame {
    private JTextField txtId,txtName,txtSex,txtAge,txtPhone,txtPosition,txtSalary,txtDepartment;
    private JFormattedTextField txtHireDate;
    private JButton btnSave,btnCancel;
    private EmployeeManangeUI employeeManangeUI;

    public AddEmployeeUI(EmployeeManangeUI employeeManangeUI) {
        super("Add Employee");
        this.employeeManangeUI = employeeManangeUI;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets=new Insets(5,5,5,5);

        //设置字体
        Font labelFont = new Font("Arial",Font.PLAIN,14);

        //标签和文本框
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.EAST;
        JLabel jLabel=new JLabel("ID:");
        jLabel.setFont(labelFont);
        add(jLabel,gbc);

        gbc.gridx=1;
        gbc.anchor=GridBagConstraints.WEST;
        txtId=new JTextField(10);
        add(txtId,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        jLabel=new JLabel("Name:");
        add(jLabel,gbc);

        gbc.gridx=1;
        txtName=new JTextField(10);
        add(txtName,gbc);

        //...

        gbc.gridx=0;
        gbc.gridy=7;
        jLabel=new JLabel("txtHireDate:");
        add(jLabel,gbc);

        gbc.gridx=1;
        txtHireDate=new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        add(txtHireDate,gbc);

        gbc.gridx=0;
        gbc.gridy=8;
        jLabel=new JLabel("Salary:");
        add(jLabel,gbc);

        gbc.gridx=1;
        txtSalary=new JTextField(10);
        add(txtSalary,gbc);

        gbc.gridx=0;
        gbc.gridy=9;
        jLabel=new JLabel("Department:");
        add(jLabel,gbc);

        gbc.gridx=1;
        txtDepartment=new JTextField(10);
        add(txtDepartment,gbc);

        //添加，取消
        gbc.gridx=0;
        gbc.gridy=10;
        gbc.gridwidth=2;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.NONE;
        btnSave=new JButton("Save");
        btnCancel=new JButton("Cancel");
        btnSave.setPreferredSize(new Dimension(100,30));
        btnCancel.setPreferredSize(new Dimension(100,30));
        JPanel buttonPanel=new JPanel();
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        add(buttonPanel,gbc);

        //添加员工信息点击事件
        btnSave.addActionListener(e -> {
            Employee  employee=new Employee();
            employee.setId(Integer.parseInt(txtId.getText()));
            employee.setName(txtName.getText());
            employee.setSex(txtSex.getText());
            employee.setAge(Integer.parseInt(txtAge.getText()));
            employee.setPhone(txtPhone.getText());
            employee.setPosition(txtPosition.getText());
            employee.setSalary(Double.parseDouble(txtSalary.getText()));
            employee.setDepartment(txtDepartment.getText());
            employee.setEntryDate(txtHireDate.getText());

            employeeManangeUI.addEmployee(employee);

            JOptionPane.showMessageDialog(this,"Employee Added Successfully");

            this.dispose();
        });

        //设置窗口属性
        pack();
        setSize(300,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
