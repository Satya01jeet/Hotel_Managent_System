package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login_button, cancel_button;
    JTextField username_textfield;
    JPasswordField password_field;
    Login(){
        setBounds(450,420,600,300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("LOGIN");
        
        JLabel title = new JLabel("LOGIN DETAILS");
        title.setBounds(80, 20, 300, 30);
        title.setFont(new Font("Raleway",Font.BOLD, 30));
        add(title);
        
        JLabel username_field = new JLabel("User Name");
        username_field.setBounds(20, 80, 100, 24);
        username_field.setFont(new Font("Raleway",Font.BOLD, 18));
        add(username_field);
        
        username_textfield = new JTextField();
        username_textfield.setBounds(150, 80, 200, 24);
        add(username_textfield);
        
        JLabel password = new JLabel("Password");
        password.setBounds(20, 120, 100, 24);
        password.setFont(new Font("Raleway",Font.BOLD, 18));
        add(password);
        
        password_field = new JPasswordField();
        password_field.setBounds(150, 120, 200, 24);
        add(password_field);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        Image image = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(380, 40, 180, 180);
        add(imgLabel);
        
        login_button = new JButton("Login");
        login_button.setBounds(30, 180, 150, 40);
        login_button.setFont(new Font("Raleway", Font.BOLD, 20));
        login_button.setBackground(Color.BLACK);
        login_button.setForeground(Color.WHITE);
        login_button.addActionListener(this);
        add(login_button);
        
        cancel_button = new JButton("Cancel");
        cancel_button.setBounds(200, 180, 150, 40);
        cancel_button.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        cancel_button.addActionListener(this);
        add(cancel_button);
        
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel_button){
            System.exit(0);
        }
        else if(ae.getSource() == login_button){
            String user = username_textfield.getText();
            String pass = new String(password_field.getPassword());
            try{
                Conn c = new Conn();
                String query = "select * from login where user_name = '"+user+"' and password = '"+pass+"'";
                
                // whwn the table is just read and not updated,
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    Dashboard dashboard = new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    System.exit(0);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    public static void main(String[] args){
        Login login = new Login();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
