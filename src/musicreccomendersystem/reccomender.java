/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev
 */
public class reccomender {
   DataConnection dataCon;
    public void predictSystem(ArrayList <Integer> songlist,int userId )
    {
        try {
             ArrayList<Integer> userlist;
             ArrayList<Float> ratinglist=new ArrayList<Float>();
             int i;
             dataCon = new DataConnection();
             User user1= new User();
             userlist=user1.getUser(userId,dataCon);
             for(i=0;i<songlist.size();i++)
             {
                 ratinglist.add(user1.similarity(userId,songlist.get(i),userlist,dataCon)) ;
                
             }
             Collections.sort(userlist,Collections.reverseOrder());
             for(float rating:ratinglist)
             {
                 System.out.println(rating);
             }
        } catch (Exception ex) {
            Logger.getLogger(reccomender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
