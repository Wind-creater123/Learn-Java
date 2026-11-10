package Practice.ui;

import Practice.bean.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EmployeeManangeUI extends JFrame{
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField textField;
    private static ArrayList<Employee> employees=new ArrayList<>();

    public EmployeeManangeUI(){

    }

    public EmployeeManangeUI(String userName){
        super(userName+"login Employee Manange");
        frame=this;
        initialize();
        this.setVisible(true);
    }

    private void initialize() {
        this.setBounds(100,100,800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        //输入框
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        textField=new JTextField(20);
        JButton btnSearch=new JButton("Search");
        JButton btnAdd=new JButton("Add");
        topPanel.add(textField);
        topPanel.add(btnSearch);
        topPanel.add(btnAdd);

        //创建表格
        model=new DefaultTableModel(new Object[][]{},
                new String[]{"id", "name", "sex",
                             "age","phone","position",
                             "entryDate","salary", "department"}
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table=new JTable(model);
        JScrollPane scrollPane=new JScrollPane(table);
        table.setRowHeight(30);

        //测试数据
        for(int i=0;i<3;i++){
            model.addRow(new Object[]{i+1,i+1,i+1,i+1,i+1,i+1,i+1,i+1,i+1});
        }

        JPopupMenu jPopupMenu=new JPopupMenu();
        JMenuItem editItem=new JMenuItem("Edit");
        JMenuItem deleteItem=new JMenuItem("Delete");
        jPopupMenu.add(editItem);
        jPopupMenu.add(deleteItem);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if(e.getButton()==MouseEvent.BUTTON3){
                    int row=table.rowAtPoint(e.getPoint());
                    if(row>=0){
                        table.setRowSelectionInterval(row,row);
                        jPopupMenu.show(table,e.getX(),e.getY());
                    }
                }
            }
        });

        //绑定事件到菜单
        editItem.addActionListener(e -> {
            int selectedRow=table.getSelectedRow();
            if(selectedRow>=0){
                int id=(Integer)model.getValueAt(selectedRow,0);
                JOptionPane.showMessageDialog(frame,"Delete Id:"+id);
            }
        });

        //删除
        deleteItem.addActionListener(e -> {
            int selectedRow=table.getSelectedRow();
            if(selectedRow>=0){
                int id=(Integer)model.getValueAt(selectedRow,0);
                //JOptionPane.showMessageDialog(frame,"Delete Id:"+id);
                deleteEmployee(id);
                model.removeRow(selectedRow);
            }
        });

        //搜索按钮事件
        btnSearch.addActionListener(e -> {
            String search=textField.getText();
        });

        //添加
        btnAdd.addActionListener(e -> {
            new AddEmployeeUI(this);
        });

        frame.getContentPane().add(topPanel,BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
    }

    private void deleteEmployee(int id) {
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).getId()==id){
                employees.remove(i);
                break;
            }
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        model.addRow(new Object[]{employee.getId(),employee.getName(),employee.getSex(),employee.getAge(),employee.getPhone(),employee.getPosition(),employee.getEntryDate(),employee.getSalary(),employee.getDepartment()});
    }
}
