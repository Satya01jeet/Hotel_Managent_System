package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NewDepartment extends JFrame implements ActionListener{
    JButton add, back;
    JTextField name, bud;
    NewDepartment(){
        setBounds(450, 210, 500, 220);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD NEW DEPARTMENT");
        
        JLabel departName = new JLabel("Name:");
        departName.setBounds(20, 20, 100, 30);
        departName.setFont(new Font("Roboto", Font.PLAIN, 20));
        add(departName);
        
        name = new JTextField();
        name.setBounds(120, 20, 350, 30);
        name.setFont(new Font("Roboto", Font.PLAIN, 20));
        add(name);
        
        JLabel budget = new JLabel("Budget:");
        budget.setBounds(20, 70, 100, 30);
        budget.setFont(new Font("Roboto", Font.PLAIN, 20));
        add(budget);
        
        bud = new JTextField();
        bud.setBounds(120, 70, 350, 30);
        bud.setFont(new Font("Roboto", Font.PLAIN, 20));
        add(bud);
        
        add = new JButton("Add");
        add.setBounds(30, 130, 200, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Roboto", Font.PLAIN, 20));
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(250, 130, 200, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Roboto", Font.PLAIN, 20));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String department_name = name.getText();
            String department_budget = bud.getText();
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into department values('"+department_name+"', '"+department_budget+"')");
                JOptionPane.showMessageDialog(null, "Department added successfullly!!!");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Department();
        }
    }
    public static void main(String[] args){
        NewDepartment nd = new NewDepartment();
        nd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
