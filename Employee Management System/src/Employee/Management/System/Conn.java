package Employee.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection connection;
    Statement statement;

    public Conn() {

        try{
            String URL = "jdbc:mysql://localhost:3306/EmployeeMangement" ;
            String username = "root" ;
            String password = "Dragon7@1" ;
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            connection = DriverManager.getConnection(URL , username , password ) ;
            statement = connection.createStatement() ;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
