package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddRooms extends JFrame implements ActionListener {
    JTextField pricetf,roomtf;
    JComboBox bedBox, statusBox,cleanBox,roomBox;
    JButton add, back;
    AddRooms(){
        setBounds(400,190,670,400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD ROOM");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rooms2.png"));
        Image img = i1.getImage().getScaledInstance(350, 360, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(300, 20, 350, 360);
        add(image);
        
        JLabel roomNo = new JLabel("Room No:");
        roomNo.setBounds(30, 20, 100, 24);
        roomNo.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(roomNo);
        
        roomtf = new JTextField();
        roomtf.setBounds(130, 20, 150, 24);
        roomtf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(roomtf);
        
        JLabel status = new JLabel("Status:");
        status.setBounds(30, 60, 100, 24);
        status.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(status);
        
        String[] roomStatus = {"-SELECT-","occupied", "unoccupied"};
        statusBox = new JComboBox(roomStatus);
        statusBox.setBounds(130, 60, 150, 24);
        statusBox.setBackground(Color.WHITE);
        add(statusBox);
        
        JLabel clean = new JLabel("Clean sts:");
        clean.setBounds(30, 100, 100, 24);
        clean.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(clean);
        
        String[] cleanStatus = {"-SELECT-","clean", "not clean"};
        cleanBox = new JComboBox(cleanStatus);
        cleanBox.setBounds(130, 100, 150, 24);
        cleanBox.setBackground(Color.WHITE);
        add(cleanBox);
        
        JLabel price = new JLabel("Price:");
        price.setBounds(30, 140, 100, 24);
        price.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(price);
        
        pricetf = new JTextField();
        pricetf.setBounds(130, 140, 150, 24);
        pricetf.setBackground(Color.WHITE);
        add(pricetf);
        
        JLabel bedType = new JLabel("Bed Type:");
        bedType.setBounds(30, 180, 100, 24);
        bedType.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(bedType);
        
        String[] bed = {"-SELECT-","single", "double"};
        bedBox = new JComboBox(bed);
        bedBox.setBounds(130, 180, 150, 24);
        bedBox.setBackground(Color.WHITE);
        add(bedBox);
        
        add = new JButton("Add");
        add.setBounds(30, 335, 120, 40);
        add.setFont(new Font("Raleway", Font.BOLD, 20));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(160, 335, 120, 40);
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
            String room_num = roomtf.getText();
            String status = (String) statusBox.getSelectedItem();
            String clean = (String) cleanBox.getSelectedItem();
            String price = pricetf.getText();
            String bed_type = (String) bedBox.getSelectedItem();

            try{
                if(room_num.equals("") || status.equals("") || clean.equals("") || price.equals("")
                         || bed_type.equals("")){
                    JOptionPane.showMessageDialog(null, "All the feilds are required!!!");
                }else{
                    Conn c = new Conn();
                    String query = "insert into room values('"+room_num+"', '"+status+"', '"+clean+"', '"+price+"', '"+
                            bed_type+"')";

                    // When the table is to be updated.
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Room added successfully");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        AddRooms ar = new AddRooms();
        ar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
