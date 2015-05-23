/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Dev
 */
public class AvgUser {
    int rating;
    
    float mean(ArrayList<Integer> userRating)
    {
        int sum=0;
        float avg=0;
        Iterator i=userRating.iterator();
        while(i.hasNext())
        {
            rating=(int)i.next();
            sum+=rating;
        }
        if(userRating.size()!=0)
        avg=sum/userRating.size();
      
        return avg;
    }
}
