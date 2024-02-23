package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Reception extends JFrame implements ActionListener {
    JButton forms, rooms, dptmt, allemp, cusinfo, mnginfo, checkout, updsts, sts, pickup, srchroom, logout;
    Reception(){
        setBounds(350,190,740,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("RECEPTION");       
//        setUndecorated(true);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.png"));
        Image img = i1.getImage().getScaledInstance(415, 415, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(290, 20, 415, 415);
        add(image);
        
        forms = new JButton("New Customer Form");
        forms.setBackground(Color.BLACK);
        forms.setForeground(Color.WHITE);
        forms.setFont(new Font("Roboto", Font.BOLD, 18));
        forms.setBounds(20, 20, 250, 30);
        forms.addActionListener(this);
        add(forms);
        
        rooms = new JButton("Rooms");
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setFont(new Font("Roboto", Font.BOLD, 18));
        rooms.setBounds(20, 55, 250, 30);
        rooms.addActionListener(this);
        add(rooms);
        
        dptmt = new JButton("Department");
        dptmt.setBackground(Color.BLACK);
        dptmt.setForeground(Color.WHITE);
        dptmt.setFont(new Font("Roboto", Font.BOLD, 18));
        dptmt.setBounds(20, 90, 250, 30);
        dptmt.addActionListener(this);
        add(dptmt);
        
        allemp = new JButton("All Employees");
        allemp.setBackground(Color.BLACK);
        allemp.setForeground(Color.WHITE);
        allemp.setFont(new Font("Roboto", Font.BOLD, 18));
        allemp.setBounds(20, 125, 250, 30);
        allemp.addActionListener(this);
        add(allemp);
        
        cusinfo = new JButton("Customer Info");
        cusinfo.setBackground(Color.BLACK);
        cusinfo.setForeground(Color.WHITE);
        cusinfo.setFont(new Font("Roboto", Font.BOLD, 18));
        cusinfo.setBounds(20, 160, 250, 30);
        cusinfo.addActionListener(this);
        add(cusinfo);
        
        mnginfo = new JButton("Manager Info");
        mnginfo.setBackground(Color.BLACK);
        mnginfo.setForeground(Color.WHITE);
        mnginfo.setFont(new Font("Roboto", Font.BOLD, 18));
        mnginfo.setBounds(20, 195, 250, 30);
        mnginfo.addActionListener(this);
        add(mnginfo);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Roboto", Font.BOLD, 18));
        checkout.setBounds(20, 230, 250, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        updsts = new JButton("Update Status");
        updsts.setBackground(Color.BLACK);
        updsts.setForeground(Color.WHITE);
        updsts.setFont(new Font("Roboto", Font.BOLD, 18));
        updsts.setBounds(20, 265, 250, 30);
        updsts.addActionListener(this);
        add(updsts);
        
        sts = new JButton("Status");
        sts.setBackground(Color.BLACK);
        sts.setForeground(Color.WHITE);
        sts.setFont(new Font("Roboto", Font.BOLD, 18));
        sts.setBounds(20, 300, 250, 30);
        sts.addActionListener(this);
        add(sts);
        
        pickup = new JButton("Pickup");
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.setFont(new Font("Roboto", Font.BOLD, 18));
        pickup.setBounds(20, 335, 250, 30);
        pickup.addActionListener(this);
        add(pickup);
        
        srchroom = new JButton("Search Rooms");
        srchroom.setBackground(Color.BLACK);
        srchroom.setForeground(Color.WHITE);
        srchroom.setFont(new Font("Roboto", Font.BOLD, 18));
        srchroom.setBounds(20, 370, 250, 30);
        srchroom.addActionListener(this);
        add(srchroom);
        
        logout = new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Roboto", Font.BOLD, 18));
        logout.setBounds(20, 405, 250, 30);
        logout.addActionListener(this);
        add(logout);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == forms){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource() == dptmt){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allemp){
            setVisible(false);
            new AllEmp();
        }
        else if(ae.getSource() == cusinfo){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == mnginfo){
            setVisible(false);
            new Manager();
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == updsts){
            setVisible(false);
            new UpdateStatus();
        }
        else if(ae.getSource() == sts){
            setVisible(false);
            new SearchRooms();
        }
        else if(ae.getSource() == pickup){
            setVisible(false);
            new SearchRooms();
        }
        else if(ae.getSource() == srchroom){
            setVisible(false);
            new SearchRooms();
        }
    }
    public static void main(String[] args){
        Reception rep = new Reception();
        rep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
