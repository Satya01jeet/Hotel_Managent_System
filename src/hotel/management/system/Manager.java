package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class Manager extends JFrame implements ActionListener {
    JTable table;
    JButton backButton;
    Manager() {
        setBounds(400, 190, 610, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("CUSTOMER DETAILS");
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);  //
        scrollPane.setBounds(20, 20, 555, 370);
        add(scrollPane);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee WHERE job = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        backButton = new JButton("Back");
        backButton.setBounds(220, 410, 150, 30);
        backButton.setBackground(Color.BLACK); 
        backButton.setForeground(Color.WHITE); 
        backButton.addActionListener(this);
        add(backButton);

//        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
