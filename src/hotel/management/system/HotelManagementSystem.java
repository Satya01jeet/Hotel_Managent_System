package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    JButton next;
    HotelManagementSystem(){
        setBounds(350,0,815,800);
        setLayout(null);
        setTitle("WELCOME");
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/Hotel2.jpg"));
        Image image = icon1.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(0, 0, 800, 800);
        add(imgLabel);
        
//        The following code was croping the image
//        ImageIcon hotel = new ImageIcon(ClassLoader.getSystemResource("icons/Hotel2.jpg"));
//        JLabel image = new JLabel(hotel);
//        image.setBounds(0,0,800,800);
//        add(image);
        
        JLabel hms = new JLabel("HOTEL MANAGEMENT SYSTEM");
        hms.setBounds(85, 350, 800, 40);
        hms.setFont(new Font("Serif",Font.BOLD, 40));
        hms.setForeground(Color.WHITE);
        imgLabel.add(hms);
        
        next = new JButton("NEXT");
        next.setBounds(680,710,100,40);
        next.setFont(new Font("Raleway",Font.BOLD, 24));
        next.setForeground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        imgLabel.add(next);
        
        setVisible(true);
        
        while(true){
            hms.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }
            hms.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
   
    @Override
    public void actionPerformed(ActionEvent ae){
        Login login = new Login();
    }
    public static void main(String[] args) {
        HotelManagementSystem hms = new HotelManagementSystem();
        hms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}
