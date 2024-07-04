package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEmpId ;
    JButton delete , back ;

    RemoveEmployee() {

        //  To Get Employee Id  To Remove
        JLabel label = new JLabel("Employee Id ");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma", Font.BOLD,15));
        add(label);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(200,50,150,30);
        add(choiceEmpId);

        try{
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM employee");
            while( resultSet.next() ) {
                choiceEmpId.add(resultSet.getString("Employee_Id"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


        // Get Name of the Employee
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelName);

        JLabel txtName = new JLabel();
        txtName.setBounds(200,100,100,30);
        add(txtName);


        // Get Phone No.  of the Employee
        JLabel labelPhone = new JLabel("Phone No.");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelPhone);

        JLabel txtPhone = new JLabel();
        txtPhone.setBounds(200,150,100,30);
        add(txtPhone);


        // Get E-mail  of the Employee
        JLabel labelEmail = new JLabel("E-Mail");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD,15));
        add(labelEmail);

        JLabel txtEmail = new JLabel();
        txtEmail.setBounds(200,200,100,30);
        add(txtEmail);

        try{
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM employee WHERE Employee_Id = '"+choiceEmpId.getSelectedItem()+"'" );

            while( resultSet.next() ) {
                txtName.setText(resultSet.getString("Name"));
                txtPhone.setText(resultSet.getString("Phone_No"));
                txtEmail.setText(resultSet.getString("E_Mail"));
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
        choiceEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM employee WHERE Employee_Id = '"+choiceEmpId.getSelectedItem()+"'" );

                    while( resultSet.next() ) {
                        txtName.setText(resultSet.getString("Name"));
                        txtPhone.setText(resultSet.getString("Phone_No"));
                        txtEmail.setText(resultSet.getString("E_Mail"));
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });


        // Button to Delete Employee
        delete = new JButton("Delete Employee");
        delete.setBounds(80,300,200,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        // Button to go Back
        back = new JButton("Back");
        back.setBounds(320,300,200,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        // Adding Background to the Window
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(700,80,200,200);
        add(image);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22) ;
        JLabel image1 = new JLabel(i33) ;
        image1.setBounds(0,0,1120,630);
        add(image1);


        // Window
        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setTitle("Remove Employee");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == delete ) {
            try{
                Conn conn = new Conn();
                String query = "DELETE FROM employee WHERE Employee_Id = '"+choiceEmpId.getSelectedItem()+"'";
                conn.statement.executeUpdate(query) ;
                JOptionPane.showMessageDialog(null,"Employee Deleted Succesfully");
                setVisible(false);
                new Main_class();
            }catch (Exception e2 ){
                e2.printStackTrace();
            }
        }
        else if( e.getSource() == back ) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
