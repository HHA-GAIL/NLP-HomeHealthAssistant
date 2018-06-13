/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dhu.lib;

import com.dtrules.infrastructure.RulesException;
import com.dtrules.interpreter.IRObject;
import edu.dhu.DTRules.entities.Sleep_Dev;
import edu.dhu.DTRules.entities.Steps_Dev;
import edu.dhu.DTRules.entities.Weight_Dev;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HASEE
 */
public class DevUtils {
    
    /**
     * to test the sleep_devs
     * @param obj
     * @return string result
     */
    public String TestSleep(IRObject obj) throws RulesException{
        StringBuilder sb = new StringBuilder();
        List<Sleep_Dev> list = IRObjConverter.ConvertIRObjToPatient(obj).getSleep_Devs();
        if(list.size() == 0)
            return sb.append("No Sleep Data...").toString();
        int nearest = 0;Date date = list.get(0).getDateTime();
        for(int i = 1; i < list.size(); i++){
            if(date.before(list.get(i).getDateTime())){
                nearest = i;
                date = list.get(i).getDateTime();
            }
        }
        Date now = new Date();
        sb.append("The nearest date is ").append((now.getTime() - date.getTime())/1000/24/60/60).append(" days from now...");
        return sb.toString();
    }
    
    /**
     * to test the steps_devs
     * @param obj
     * @return string result
     */
    public String TestSteps(IRObject obj) throws RulesException{
        StringBuilder sb = new StringBuilder();
        List<Steps_Dev> list = IRObjConverter.ConvertIRObjToPatient(obj).getSteps_Devs();
        if(list.size() == 0)
            return sb.append("No Steps Data").toString();
        sb.append("Your nearest steps are: ").append(list.get(0).getSteps()).append("...");
        Date now = new Date();
        sb.append("The nearest date from now is ").append((now.getTime() - list.get(0).getDateTime().getTime())/1000/24/60/60).append(" days ago...");
        return sb.toString();
    }
    
    /**
     * to test the weight_devs
     * @param obj
     * @return string result
     */
    public String TestWeight(IRObject obj) throws RulesException{
        StringBuilder sb = new StringBuilder();
        List<Weight_Dev> list = IRObjConverter.ConvertIRObjToPatient(obj).getWeight_Devs();
        if(list.size() <= 3){
            JOptionPane.showConfirmDialog(null, "We need more data of Weight to analysize..."
                ,"System",JOptionPane.OK_OPTION);
            return sb.append("We need more data of Weight to analysize...").toString();
        }
        double all = 0;
        double recent3 = (list.get(0).Weight+list.get(1).getWeight()+list.get(2).getWeight())/3;
        for (Weight_Dev weight_Dev : list) {
            all += weight_Dev.getWeight();
        }
        all/=list.size();
        sb.append("your recent 3 days' average weight is: ").append(recent3).append("...");
        if(all < recent3){
            int n=JOptionPane.showConfirmDialog(null, "Did you eat something unnormal recently, like a lot of fried chicken or coca?"
                ,"Question",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.OK_OPTION){
                sb.append("SUGGESTION: you need to watch out of what you eat.");
            }
            else{
                sb.append("SUGGESTION: you need to do more excise to low down the rate of heart attack.");
            }
        }
        else{
            int n=JOptionPane.showConfirmDialog(null, "Did you do some excise recently?"
                ,"Question",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.OK_OPTION){
                sb.append("GOOD!");
            }
            else{
                sb.append("SUGGESTION: you need to take care of what you ear.");
            }
        }
        Date now = new Date();
        sb.append("\nThe nearest data from now is ").append((now.getTime() - list.get(0).getDateTime().getTime())/1000/24/60/60).append(" days ago...");
        return sb.toString();
    }
    
}
