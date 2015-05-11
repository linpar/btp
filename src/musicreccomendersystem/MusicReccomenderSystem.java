/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev
 */
public class MusicReccomenderSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
       
       Scanner scan = new Scanner(System.in);
       int userId,songId;
       ArrayList<Integer> userlist;
       userId=scan.nextInt();
        songId=scan.nextInt();
        User user1= new User();
        userlist=user1.getUser(userId);
        user1.similarity(userId, userlist);
        
        
        
    }
}
