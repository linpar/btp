/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicreccomendersystem;
import java.util.ArrayList;
/**
 *
 * @author Dev
 */
public class EuclideanDist {
    float method(ArrayList<Integer> song1,ArrayList<Integer> song2)
    {
        int i;
        float diff,dist=0;
        for(i=0;i<song1.size();i++)
        {
            diff=(float)(song1.get(i))-(float)(song2.get(i));
            dist+=diff*diff;
        }
        return dist;
    }
}
