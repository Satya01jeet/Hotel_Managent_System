package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton backButton;
    Room() {
        setBounds(400, 190, 610, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ROOM DETAILS");
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);  // Add a scroll pane
        scrollPane.setBounds(20, 20, 555, 370);
        add(scrollPane);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        backButton = new JButton("Back");
        backButton.setBounds(200, 410, 150, 30);
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
        Room r = new Room();
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
