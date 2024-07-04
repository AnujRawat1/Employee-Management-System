package Employee.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    Choice choiceEmp ;
    JTable table ;
    JButton search , print , update , back ;

    ViewEmployee(){

        // Set background
        getContentPane().setBackground(new Color(0,180,180));

        // For Searching Employee
        JLabel searchLabel = new JLabel("Search By Employee Id ");
        searchLabel.setBounds(20,20,150,20);
        add(searchLabel);

        choiceEmp = new Choice();
        choiceEmp.setBounds(180,20,150,20);
        add(choiceEmp);

        try{
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM employee");
            while( resultSet.next() ){
                choiceEmp.add(resultSet.getString("Employee_Id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        //  Creating Table to Display Employee's
        table = new JTable();
        try{
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            while( resultSet.next() ){

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // Adding Scroll Functionality To the table
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);


        // Button to Search Employee
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        // Button to Print Employee Table
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        // Button to Update Employee
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        // Button to go Back
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(907,650);
        setLayout(null);
        setLocation(300,100);
        setTitle("View Employee");
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == search ) {
            String query = "SELECT * FROM employee WHERE Employee_Id = '"+choiceEmp.getSelectedItem()+"'" ;
            try{
                Conn conn = new Conn();
                ResultSet resultSet = conn.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E) {
                E.printStackTrace();
            }
        }
        else if( e.getSource() == print ) {
            try {
                table.print() ;
            }catch (Exception E) {
                E.printStackTrace();
            }
        }
        else if ( e.getSource() == update ) {
            setVisible(false) ;
            new UpdateEmployee(choiceEmp.getSelectedItem());
        }
        else if ( e.getSource() == back ) {
            setVisible(false);
            new Main_class() ;
        }
    }


    public static void main(String[] args) {
        new ViewEmployee();
    }


}
