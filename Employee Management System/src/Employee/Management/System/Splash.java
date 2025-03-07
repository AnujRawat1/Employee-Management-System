package Employee.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        //  Adding Front Page Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,1170,650);
        add(image);


        setSize(1170,650);
        setLocation(200,100);  // To Open the Window at Centre
        setLayout(null);
        setTitle("Employee Management System");
        setVisible(true);

        try {
          Thread.sleep(5000);
          setVisible(false);
          new Login() ;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
