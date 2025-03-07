package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField txt_username ;
    JPasswordField txt_password ;
    JButton login , back ;
    Login(){

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        txt_username = new JTextField();
        txt_username.setBounds(150,20,150,30);
        add(txt_username);


        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        txt_password = new JPasswordField();
        txt_password.setBounds(150,70,150,30);
        add(txt_password);


        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login) ;

        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back) ;

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22) ;
        JLabel img = new JLabel(i33) ;
        img.setBounds(350,10,600,400);
        add(img) ;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel img1 = new JLabel(i3) ;
        img1.setBounds(0,0,600,300);
        add(img1) ;


        // Window
        setSize(600,300);
        setLocation(450,200);  // To Open the Window at Centre
        setLayout(null);
        setTitle("Login-Page");
        setVisible(true);
    }


    public static void main(String[] args) {
        new Login() ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == login ) {
            try{
                String username = txt_username.getText() ;
                String password = txt_password.getText() ;

                Conn conn = new Conn() ;
                String query = "SELECT * FROM login WHERE username = '"+username+"' and password = '"+password+"'";
                ResultSet resultset = conn.statement.executeQuery(query);

                if( resultset.next() ) {
                    setVisible(false);
                    new Main_class();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Unvalid Usename or Password ");
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        else if( e.getSource() == back ) {
            System.exit(111);
        }
    }
}
