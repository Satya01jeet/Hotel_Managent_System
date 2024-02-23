package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Date;
import java.sql.*;
public class AddCustomer extends JFrame implements ActionListener {
    JLabel lblcheckintime;
    JTextField nametf,agetf,countrytf,idNumtf,depositf;
    JRadioButton male,female;
    JComboBox idbox,roomBox;
    JButton add,back;
    AddCustomer(){
        setBounds(400,190,670,400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD CUSTOMER");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image img = i1.getImage().getScaledInstance(350, 360, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(300, 20, 350, 360);
        add(image);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(30, 20, 100, 24);
        name.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(name);
        
        nametf = new JTextField("");
        nametf.setBounds(130, 20, 150, 24);
        nametf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(nametf);
        
        JLabel age = new JLabel("Age:");
        age.setBounds(30, 55, 100, 24);
        age.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(age);
        
        agetf = new JTextField();
        agetf.setBounds(130, 55, 150, 24);
        agetf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(agetf);
        
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(30, 90, 100, 24);
        gender.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(130, 90, 70, 24);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(205, 90, 70, 24);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderbox = new ButtonGroup();
        genderbox.add(male);
        genderbox.add(female);
        
        JLabel id = new JLabel("ID:");
        id.setBounds(30, 125, 100, 24);
        id.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(id);
        
        String[] idval = {"-SELECT-","Passport","Drivers Licence", "Aadhar card","Voter ID"};
        idbox = new JComboBox(idval);
        idbox.setBounds(130, 125, 150, 24);
        idbox.setBackground(Color.WHITE);
        add(idbox);
        
        JLabel country = new JLabel("Id Number:");
        country.setBounds(30, 160, 100, 24);
        country.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(country);
        
        idNumtf = new JTextField();
        idNumtf.setBounds(130, 160, 150, 24);
        idNumtf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(idNumtf);
        
        JLabel phone = new JLabel("Country:");
        phone.setBounds(30, 195, 100, 24);
        phone.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(phone);
        
        countrytf = new JTextField();
        countrytf.setBounds(130, 195, 150, 24);
        countrytf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(countrytf);
        
        JLabel roomno = new JLabel("Room No:");
        roomno.setBounds(30, 230, 100, 24);
        roomno.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(roomno);
        
        String[] room = getAvailableRooms();
        roomBox = new JComboBox(room);
        roomBox.setBounds(130, 230, 150, 24);
        roomBox.setBackground(Color.WHITE);
        roomBox.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(roomBox);
        
        JLabel deposit = new JLabel("Deposit:");
        deposit.setBounds(30, 265, 100, 24);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(deposit);
        
        depositf = new JTextField();
        depositf.setBounds(130, 265, 150, 24);
        depositf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(depositf);
        
        JLabel checkintime = new JLabel("Checkin time:");
        checkintime.setBounds(30, 300, 150, 24);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(checkintime);
        
        Date date = new Date();
        
        lblcheckintime = new JLabel(""+date);
        lblcheckintime.setBounds(130, 300, 150, 24);
        lblcheckintime.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(lblcheckintime);
        
        add = new JButton("Add");
        add.setBounds(30, 340, 120, 40);
        add.setFont(new Font("Raleway", Font.BOLD, 20));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(160, 340, 120, 40);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String _name = nametf.getText();
            String _age = agetf.getText();
            String _country = countrytf.getText();
            String _idnum = idNumtf.getText();
            String _room = (String) roomBox.getSelectedItem();
            String _deposit = depositf.getText();
            String _id = (String) idbox.getSelectedItem();
            String _gender = "";
            String checkin_time = lblcheckintime.getText();
            if(male.isSelected()) _gender = "male";
            else if(female.isSelected()) _gender = "female";

            try{
                if(_name.equals("") || _age.equals("") || _country.equals("") || _idnum.equals("")
                         || _room.equals("") || _deposit.equals("") || _id.equals("") || _gender.equals("")){
                    JOptionPane.showMessageDialog(null, "All the feilds are required!!!");
                }else{
                    Conn c = new Conn();
                    String query1 = "insert into customer values('"+_name+"', '"+_age+"', '"+_gender+"', '"+_id+"', '"+
                            _idnum+"', '"+_country+"', '"+_room+"', '"+_deposit+"','"+checkin_time+"')";
                    String query2 = "UPDATE room SET status='occupied', clean='not clean' WHERE room_num='" + _room + "'";
                    System.out.println(query2);
                    // When the table is to be updated.
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Customer added successfully");
                    setVisible(false);
                    new Reception();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    private static String[] getAvailableRooms(){
        ArrayList<String> availableRoomsList = new ArrayList<>();
        try {
            Conn c = new Conn();
            String query = "SELECT room_num FROM room WHERE status='unoccupied' AND clean='clean'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                availableRoomsList.add(rs.getString("room_num"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return availableRoomsList.toArray(new String[0]);
    }
    public static void main(String[] args){
        AddCustomer cus = new AddCustomer();
    }
}
