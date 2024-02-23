package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton backButton, add;
    Department() {
        setBounds(400, 190, 610, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("DEPARTMENT DETAILS");
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);  // Add a scroll pane
        scrollPane.setBounds(20, 20, 555, 370);
        add(scrollPane);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Add");
        add.setBounds(50, 400, 200, 40);
        add.setBackground(Color.BLACK); 
        add.setForeground(Color.WHITE); 
        add.addActionListener(this);
        add(add);
        
        backButton = new JButton("Back");
        backButton.setBounds(300, 400, 200, 40);
        backButton.setBackground(Color.BLACK); 
        backButton.setForeground(Color.WHITE); 
        backButton.addActionListener(this);
        add(backButton);

//        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == backButton){
            setVisible(false);
            new Reception();
        }else if(ae.getSource() == add){
            setVisible(false);
            new NewDepartment();
        }
    }
    public static void main(String[] args) {
        Department d = new Department();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
