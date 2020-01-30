package BL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class UTIL {
    private String BD_DRIVER = "org.h2.Driver";
    private String BD_URL = "jdbc:h2:~/trans";
    private String BD_Name = "root";
    private  String BD_Password = "root";

    public Connection getConnection(){

        Connection connection = null;

        try {
            Class.forName(BD_DRIVER);
            connection = DriverManager.getConnection(BD_URL, BD_Name, BD_Password);
            //System.out.println("connection ok");
            //connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("connection error");
        }
        return connection;
    }

}
