package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateStatus extends JFrame implements ActionListener {
    Choice name,num;
    JTextField tfroom, tfadvance, tfcheckin;
    JButton search, update, back;
    UpdateStatus(){
        setLayout(null);
        setBounds(400, 190, 450, 330);
        setTitle("Update Checkout Status");

        JLabel cusName = new JLabel("Customer Name:");
        cusName.setBounds(20, 20, 200, 30);
        cusName.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(cusName);

        name = new Choice();
        name.setBounds(220, 20, 200, 30);
        name.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(name);

        try {
            Conn c = new Conn();
            String query = "SELECT * from customer";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                name.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel cusId = new JLabel("Customer ID Number:");
        cusId.setBounds(20, 60, 200, 30);
        cusId.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(cusId);

        num = new Choice();
        num.setBounds(220, 60, 200, 30);
        num.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(num);

        JLabel cusRoom = new JLabel("Room number:");
        cusRoom.setBounds(20, 100, 200, 30);
        cusRoom.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(cusRoom);

        tfroom = new JTextField();
        tfroom.setBounds(220, 100, 200, 30);
        tfroom.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(tfroom);

        JLabel adv = new JLabel("Advance Paid:");
        adv.setBounds(20, 140, 200, 30);
        adv.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(adv);

        tfadvance = new JTextField();
        tfadvance.setBounds(220, 140, 200, 30);
        tfadvance.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(tfadvance);

        JLabel checkin = new JLabel("Checkin Time:");
        checkin.setBounds(20, 180, 200, 30);
        checkin.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(checkin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(220, 180, 200, 30);
        tfcheckin.setFont(new Font("Roboto", Font.PLAIN, 16));
        add(tfcheckin);

        search = new JButton("Search");
        search.setBounds(20, 230, 120, 40);
        search.setFont(new Font("Roboto", Font.PLAIN, 16));
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(160, 230, 120, 40);
        update.setFont(new Font("Roboto", Font.PLAIN, 16));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(300, 230, 120, 40);
        back.setFont(new Font("Roboto", Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            num.removeAll();
            try{
                String nameOf = (String) name.getSelectedItem();
                Conn c = new Conn();
                String query = "SELECT * from customer WHERE name = '"+nameOf+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    num.add(rs.getString("id_num"));
                }
                
                String id_num = (String) num.getSelectedItem();
                String query2 = "SELECT * from customer WHERE id_num = '"+id_num+"'";
                ResultSet rs2 = c.s.executeQuery(query);
                while(rs2.next()){
                    tfroom.setText(rs2.getString("room"));
                    tfadvance.setText(rs2.getString("deposit"));
                    tfcheckin.setText(rs2.getString("checkin_time"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            String id_num = (String) num.getSelectedItem();
            String room = tfroom.getText();
            String dep = tfadvance.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("UPDATE customer SET room = '"+room+"', deposit = '"+dep+"' WHERE id_num = '"+id_num+"'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Details Updated Successfully");
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        UpdateStatus us = new UpdateStatus();
        us.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
