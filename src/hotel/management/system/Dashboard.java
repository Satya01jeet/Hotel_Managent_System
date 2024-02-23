package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    JMenuItem addEmployee, addRoom, addDriver, reception, houseKeeping, security, food;
    Dashboard(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
//        setBounds(0,0,screenSize.width,screenSize.height);
        setLayout(null);
        setTitle("DASHBOARD");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Hotel.png"));
        Image img = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(0, 0, screenSize.width, screenSize.height);
        add(image);
        
        JLabel text = new JLabel("ℝ𝕀𝕐𝔸𝕊𝕊𝔸𝕋 ℍ𝕆𝕊ℙ𝕆𝕋𝔸𝕃𝕀𝕋𝕐 𝔾ℝ𝕆𝕌ℙ");
        text.setBounds(250, 100, 1200, 50);
        text.setFont(new Font("Raleway", Font.BOLD, 60));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,screenSize.width,30);
        mb.setBackground(Color.WHITE);
        image.add(mb);
        
        JMenu hotel = new JMenu("Management");
        hotel.setFont(new Font("Roboto", Font.PLAIN, 16));
        hotel.setForeground(Color.black);
        hotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mb.add(hotel);
        
        reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        houseKeeping = new JMenuItem("House Keeping");
        houseKeeping.addActionListener(this);
        hotel.add(houseKeeping);
        
        security = new JMenuItem("Security");
        security.addActionListener(this);
        hotel.add(security);
        
        food = new JMenuItem("Food");
        food.addActionListener(this);
        hotel.add(food);
        
        
        
        JMenu admin = new JMenu("Admin");
        admin.setFont(new Font("Roboto", Font.PLAIN, 16));
        admin.setForeground(Color.black);
        admin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mb.add(admin);
        
        addEmployee = new JMenuItem("Add Employee");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);
        
        addRoom = new JMenuItem("Add Room");
        addRoom.addActionListener(this);
        admin.add(addRoom);
        
        addDriver = new JMenuItem("Add Driver");
        addDriver.addActionListener(this);
        admin.add(addDriver);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addEmployee){
            new AddEmployee();
        }
        else if(ae.getSource() == addRoom){
            new AddRooms();
        }
        else if(ae.getSource() == addDriver){
            new AddDriver();
        }
        else if(ae.getSource() == reception){
            new Reception();
        }
    }
    public static void main(String[] args){
        Dashboard dashboard = new Dashboard();
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
