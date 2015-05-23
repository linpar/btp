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
       ArrayList<Integer> songlist=new ArrayList<Integer>();
       userId=scan.nextInt();
        songlist.add(166);
        songlist.add(2245);
        songlist.add(3647);
        reccomender prediction = new reccomender();
        prediction.predictSystem(songlist, userId);
        
        
    }
}
