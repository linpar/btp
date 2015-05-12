/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev
 */
public class User {
    DataConnection dataCon;
    ResultSet rs1;
    ResultSet rs2;
    ArrayList<Integer> userId = new ArrayList<Integer>();
    int i;
    public  ArrayList<Integer> getUser(int user)
    {
        try {
            dataCon = new DataConnection();
            rs1= dataCon.s.executeQuery("SELECT distinct(id) FROM `user_song_train_small_ratings` where id <> '" + user + "'");
            while(rs1.next())
                {
                    
                    userId.add(rs1.getInt(1));

                }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userId;                                                           
    }
    
    
    public void similarity(int user,int songId, ArrayList<Integer> userId)
    {
        
        ArrayList<Integer> rating1= new  ArrayList<Integer>();
        ArrayList<Integer> rating2= new  ArrayList<Integer>();
        float factorValue,predict=0;
        
         dataCon = new DataConnection();
         DataConnection dataCon1 = new DataConnection();
        for(i=0;i<userId.size();i++)
        {
            try {
               
                rs1= dataCon.s.executeQuery("SELECT rating FROM `user_song_train_small_ratings` where id = '" + userId.get(i) + "' and song_id in(select song_id from`user_song_train_small_ratings` where id = '" + user + "')");
                rs2= dataCon1.s.executeQuery("SELECT rating FROM `user_song_train_small_ratings` where id = '" + user + "' and song_id in(select song_id from`user_song_train_small_ratings` where id = '" + userId.get(i) + "')");
            while(rs1.next() && rs2.next())
            {
                rating1.add(rs1.getInt(1));
                rating2.add(rs2.getInt(1));
               
            }
            if(rating1.size()!=0 && rating2.size()!=0)
            {
                PearsonFactor factor =new PearsonFactor();
                
             
             factorValue=factor.process(rating1,rating2);
             predict+=predictRating(songId,userId.get(i),factorValue);
   //             System.out.println(factorValue);
            }
            
             rating1.clear();
             rating2.clear();
             
             
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        predict=predict/userId.size();
        System.out.println("rating for songId"+songId+"is"+predict);
        
    }
    
    public float predictRating(int songId,int user,float factorValue)
    {
        float rating=0;
        ResultSet rs3;
        try {
            
            DataConnection dataCon3 = new DataConnection();
     
            rs3=dataCon3.s.executeQuery("SELECT rating FROM `user_song_train_small_ratings` where song_id = '" + songId + "' and id='"+ user+"'");
             if(rs3.next())
                {
                    rating=(float)rs3.getInt(1) * factorValue;
                    

                }
             else
             {
                 Song songlist= new Song(user);
                 AvgUser temp = new AvgUser();
                  ArrayList<Integer> rating3=songlist.get();
                 rating = temp.mean(rating3)*factorValue;
                 
             }
             
           } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        return rating;
    }
    
    
}
