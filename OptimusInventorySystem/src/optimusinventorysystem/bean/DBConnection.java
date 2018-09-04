/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rajesh
 */
public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try
         {
             Class.forName("com.mysql.jdbc.Driver");
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:mysql:///optimusdb","root","root");
           // con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
         }
         catch(Exception e)
         {
             System.out.println("Connection not established...!"+e);
         }
         return con;
    }
}
