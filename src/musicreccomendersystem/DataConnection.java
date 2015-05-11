/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev
 */

public class DataConnection {
    Statement s;
   
    public DataConnection()
    {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/btp_main","root","");
            s = c.createStatement();
        }       
        catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
