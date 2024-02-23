package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener{
    JTextField nametf,agetf,salarytf,phonetf,emailtf,aadhartf;
    JRadioButton male,female;
    JComboBox jobbox;
    JButton next;
    AddEmployee(){
        setBounds(400,190,670,400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/employees.png"));
        Image img = i1.getImage().getScaledInstance(350, 360, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(img));
        image.setBounds(300, 20, 350, 360);
        add(image);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(30, 20, 100, 24);
        name.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(name);
        
        nametf = new JTextField();
        nametf.setBounds(130, 20, 150, 24);
        nametf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(nametf);
        
        JLabel age = new JLabel("Age:");
        age.setBounds(30, 60, 100, 24);
        age.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(age);
        
        agetf = new JTextField();
        agetf.setBounds(130, 60, 150, 24);
        agetf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(agetf);
        
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(30, 100, 100, 24);
        gender.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(130, 100, 70, 24);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(205, 100, 70, 24);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderbox = new ButtonGroup();
        genderbox.add(male);
        genderbox.add(female);
        
        JLabel job = new JLabel("Job:");
        job.setBounds(30, 140, 100, 24);
        job.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(job);
        
        String[] values = {"-SELECT-","Receptionist","Housekeeper","Room Attendant","Laundry Staff","Waitstaff","Bartender",
            "Chef","Manager","Technician","Security Guard","IT Staff","Driver"};
        jobbox = new JComboBox(values);
        jobbox.setBounds(130, 140, 150, 24);
        jobbox.setBackground(Color.WHITE);
        add(jobbox);
        
        JLabel salary = new JLabel("Salary:");
        salary.setBounds(30, 180, 100, 24);
        salary.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(salary);
        
        salarytf = new JTextField();
        salarytf.setBounds(130, 180, 150, 24);
        salarytf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(salarytf);
        
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(30, 220, 100, 24);
        phone.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(phone);
        
        phonetf = new JTextField();
        phonetf.setBounds(130, 220, 150, 24);
        phonetf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(phonetf);
        
        JLabel email = new JLabel("Email:");
        email.setBounds(30, 260, 100, 24);
        email.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(email);
        
        emailtf = new JTextField();
        emailtf.setBounds(130, 260, 150, 24);
        emailtf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(emailtf);
        
        JLabel aadhar = new JLabel("Aadhar:");
        aadhar.setBounds(30, 300, 100, 24);
        aadhar.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(aadhar);
        
        aadhartf = new JTextField();
        aadhartf.setBounds(130, 300, 150, 24);
        aadhartf.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(aadhartf);
        
        next = new JButton("Next");
        next.setBounds(30, 340, 250, 40);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setUndecorated(true);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String _name = nametf.getText();
        String _age = agetf.getText();
        String _salary = salarytf.getText();
        String _phone = phonetf.getText();
        String _email = emailtf.getText();
        String _aadhar = aadhartf.getText();
        String _job = (String) jobbox.getSelectedItem();
        String _gender = "";
        if(male.isSelected()) _gender = "male";
        else if(female.isSelected()) _gender = "female";
        
        try{
            if(_name.equals("") || _age.equals("") || _salary.equals("") || _phone.equals("")
                     || _email.equals("") || _aadhar.equals("") || _job.equals("") || _gender.equals("")){
                JOptionPane.showMessageDialog(null, "All the feilds are required!!!");
            }else{
                Conn c = new Conn();
                String query = "insert into employee values('"+_name+"', '"+_age+"', '"+_gender+"', '"+_job+"', '"+
                        _salary+"', '"+_phone+"', '"+_email+"', '"+_aadhar+"')";

                // When the table is to be updated.
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee added successfully");
                setVisible(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){
        AddEmployee ad = new AddEmployee();
        ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
