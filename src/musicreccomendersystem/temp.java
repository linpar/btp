/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

/**
 *
 * @author Dev
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class temp {
     
            ArrayList <Integer> user1= new ArrayList<Integer>();
            ArrayList <Integer> user2= new ArrayList<Integer>();
           
            int rating;
          
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/song","root","");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select song,rating from details where user =101 order by 'song' ASC");
            while(rs.next())
   
            {
        try {
            rating=rs.getInt(2);
            user1.add(rating);
        } catch (SQLException ex) {
            Logger.getLogger(temp.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            
            rs = st.executeQuery("select song,rating from details where user =102 order by 'song' ASC");
            while(rs.next())
            {
                rating=rs.getInt(2);
                user2.add(rating);
            }
            
            PearsonFactor factor =new PearsonFactor();
            float factorValue=factor.process(user1,user2);
            
            System.out.println(factorValue);
            EuclideanDist dist =new EuclideanDist();
            
            float normDis=dist.method(user1,user2);
            normDis=1/(1+normDis);
            System.out.println(normDis);
            
            Song songList = new Song(3);
            System.out.println(songList.get());
        } 
