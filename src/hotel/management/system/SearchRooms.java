package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class SearchRooms extends JFrame implements ActionListener {
    JTable table;
    JButton backButton, search;
    JComboBox bedType;
    JCheckBox avlb;
    ResultSet rs;
    SearchRooms() {
        setBounds(400, 190, 610, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("SEARCH ROOMS ");
        
        bedType = new JComboBox(new String[]{"All","Single Bed","Double Bed"});
        bedType.setBounds(20, 30, 100, 40);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        search = new JButton("SEARCH");
        search.setBounds(210, 30, 150, 40);
        search.setFont(new Font("Roboto", Font.BOLD, 20));
        search.setBackground(Color.BLACK); 
        search.setForeground(Color.WHITE); 
        search.addActionListener(this);
        add(search);
        
        avlb = new JCheckBox("only available");
        avlb.setBounds(460, 20, 200, 40);
        avlb.setBackground(Color.WHITE);
        add(avlb);
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table); 
        scrollPane.setBounds(20, 80, 555, 320);
        add(scrollPane);
        
        try{
            Conn c = new Conn();
            rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        backButton = new JButton("Back");
        backButton.setBounds(210, 410, 150, 30);
        backButton.setBackground(Color.BLACK); 
        backButton.setForeground(Color.WHITE); 
        backButton.addActionListener(this);
        add(backButton);

//        setUndecorated(true);
        setVisible(true);
    }
    @Override
public void actionPerformed(ActionEvent ae) {
    String bed_type = "";
    if(bedType.getSelectedItem() == "Single Bed"){
        bed_type = "single";
    }
    else if(bedType.getSelectedItem() == "Double Bed"){
        bed_type = "double";
    }
    boolean onlyAvailable = avlb.isSelected(); 

    if (ae.getSource() == backButton) {
        setVisible(false);
        new Reception();
    } else if (ae.getSource() == search) {
        try {
            Conn c = new Conn();
            String query1 = "SELECT * FROM room WHERE bed_type = '" + bed_type + "'";
            String query2 = "SELECT * FROM room WHERE bed_type = '" + bed_type + "' AND status = 'unoccupied' ";
            String query3 = "SELECT * FROM room";
            if (onlyAvailable && !bed_type.isEmpty()) {
                rs = c.s.executeQuery(query2);
            }else if(!bed_type.isEmpty()){
                rs = c.s.executeQuery(query1);
            }else{
                rs = c.s.executeQuery(query3);
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    public static void main(String[] args) {
        SearchRooms sr = new SearchRooms();
        sr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
