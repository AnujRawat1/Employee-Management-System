package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img) ;

        JLabel heading = new JLabel("Employee Mangement System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,28));
        img.add(heading);

        // Add Button
        JButton add = new JButton("Add Employee") ;
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        // View Button
        JButton view = new JButton("View Employee") ;
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);


        // Remove Button
        JButton remove = new JButton("Remove Employee") ;
        remove.setBounds(335,370,150,40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.black);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(remove);

        // Exit Button
        JButton exit = new JButton("Exit") ;
        exit.setBounds(565,370,150,40);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.black);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(99);
            }
        });
        img.add(exit);


        // Window
        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setTitle("Employee Management System");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
