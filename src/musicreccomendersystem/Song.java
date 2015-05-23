/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dev
 */
public class Song {
    
    ResultSet rs;
    int userId;
    public Song(int userId)
    {
        this.userId=userId;
    }
    ArrayList<Integer> songId = new ArrayList<Integer>();
    
    public  ArrayList<Integer> get( DataConnection dataCon)
    {
        try {
           
            rs= dataCon.s.executeQuery("SELECT rating FROM `user_song_train_small_ratings` where id = '"+userId+"'");
            while(rs.next())
                {
                    
                    songId.add(rs.getInt(1));

                }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return songId;      
}
}
