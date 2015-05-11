/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;

import java.util.ArrayList;
import java.math.*;

/**
 *
 * @author Dev
 */
public class PearsonFactor {
    float x,y,factorValue=0,diff1,diff2,var1=0,var2=0,prd=0;
    AvgUser userMean =new AvgUser();
    float process(ArrayList<Integer> user1,ArrayList<Integer> user2)
    {
        x=userMean.mean(user1);
        y=userMean.mean(user2);
        int i;
        for(i=0;i<user1.size();i++)
        {
            diff1=(float)(user1.get(i));
            diff2=(float)(user2.get(i));
            prd+=diff1*diff2;
            
            var1=var1+diff1*diff1;
            var2=var2+diff2*diff2;
             
        }
        double d=var1*var2;
        factorValue=(float) (prd/Math.sqrt(d));
        return factorValue;
        
    }
}
