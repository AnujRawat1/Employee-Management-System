package Employee.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField   tFName , tAddress , tPhone , tEducation , tEmail , tSalary , tDesignation ;
    String id ;
    JLabel lEmpId ;
    JButton update , back ;

    UpdateEmployee(String id){

        this.id = id ;
        getContentPane().setBackground(new Color(115,185,255));

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,28));
        add(heading);


        // For Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tName = new JLabel();
        tName.setBounds(200,150,150,30);
        tName.setBackground(new Color(215,215,255));
        add(tName);


        // For Father's Name
        JLabel fName = new JLabel("Father's Name");
        fName.setBounds(400,150,150,30);
        fName.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fName);

        tFName = new JTextField();
        tFName.setBounds(600,150,150,30);
        tFName.setBackground(new Color(150,200,255));
        add(tFName);


        // For Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tDob = new JLabel();
        tDob.setBounds(200,200,150,30);
        tDob.setFont(new Font("Tahoma",Font.BOLD,17));
        add(tDob);


        // For Salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tSalary = new JTextField();
        tSalary.setBounds(600,200,150,30);
        tSalary.setBackground(new Color(150,200,255));
        add(tSalary);

        // For Address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        tAddress = new JTextField();
        tAddress.setBounds(200,250,150,30);
        tAddress.setBackground(new Color(150,200,255));
        add(tAddress);

        // For Phone Number
        JLabel phoneNumber = new JLabel("Phone No.");
        phoneNumber.setBounds(400,250,150,30);
        phoneNumber.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phoneNumber);

        tPhone = new JTextField();
        tPhone.setBounds(600,250,150,30);
        tPhone.setBackground(new Color(150,200,255));
        add(tPhone);


        // For E-Mail
        JLabel email = new JLabel("E-Mail");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        tEmail = new JTextField();
        tEmail.setBounds(200,300,150,30);
        tEmail.setBackground(new Color(150,200,255));
        add(tEmail);


        // For Highest Education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        tEducation = new JTextField();
        tEducation.setBounds(600,300,150,30);
        tEducation.setBackground(new Color(150,200,255));
        add(tEducation);

        // For Adhaar Number
        JLabel adhaar = new JLabel("Adhaar No.");
        adhaar.setBounds(400,350,150,30);
        adhaar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(adhaar);

        JLabel tAdhaar = new JLabel();
        tAdhaar.setBounds(600,350,150,30);
        tAdhaar.setBackground(new Color(215,215,255));
        add(tAdhaar);

        // For Employee Id
        JLabel empId = new JLabel("Employee Id.");
        empId.setBounds(50,400,150,30);
        empId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empId);

        lEmpId = new JLabel();
        lEmpId.setBounds(200,400,150,30);
        lEmpId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        lEmpId.setForeground(Color.RED);
        add(lEmpId);

        // For Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tDesignation = new JTextField();
        tDesignation.setBounds(200,350,150,30);
        tDesignation.setBackground(new Color(150,200,255));
        add(tDesignation);


        try{
            Conn conn = new Conn();
            String query = "SELECT * FROM employee WHERE Employee_Id = '"+id+"'";
            ResultSet resultSet = conn.statement.executeQuery(query);
            while( resultSet.next() ) {
                tName.setText(resultSet.getString("Name"));
                tFName.setText(resultSet.getString("Fathers_Name"));
                tDob.setText(resultSet.getString("DOB"));
                tSalary.setText(resultSet.getString("Salary"));
                tAddress.setText(resultSet.getString("Address"));
                tAdhaar.setText(resultSet.getString("Adhaar_No"));
                tPhone.setText(resultSet.getString("Phone_No"));
                tEmail.setText(resultSet.getString("E_Mail"));
                tEducation.setText(resultSet.getString("Education"));
                tDesignation.setText(resultSet.getString("Designation"));
                lEmpId.setText(resultSet.getString("Employee_Id"));


            }
        }catch (Exception E) {
            E.printStackTrace();
        }



        // Button For Adding Employee
        update = new JButton("Update Employee");
        update.setBounds(250,550,150,40);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);


        // Button For Back
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Window
        setSize(900,700);
        setLocation(300,50);
        setLayout(null);
        setTitle("Update Employee");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == update ) {
            String fatherName = tFName.getText();
            String salary = tSalary.getText();
            String address = tAddress.getText();
            String phoneNo = tPhone.getText();
            String email = tEmail.getText();
            String education = tEducation.getText();
            String designation = tDesignation.getText();

            try{
                Conn conn = new Conn();
                String query = "UPDATE employee SET Fathers_Name = '" + fatherName + "', Salary = " + salary + ", Address = '" + address + "', Phone_No = '" + phoneNo + "', E_Mail = '" + email + "', Education = '" + education + "', Designation = '" + designation + "' WHERE Employee_Id = " + id;
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Succesfully");
                setVisible(false);
                new Main_class();

            }catch (Exception e1 ) {
                e1.printStackTrace();
            }
        }
        else if( e.getSource() == back ) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
