/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dhu.lib;

import com.dtrules.infrastructure.RulesException;
import com.dtrules.interpreter.IRObject;
import edu.dhu.DTRules.entities.Patient;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HASEE
 */
public class Utils {
    
// Test codes
//    public Double Pow(IRObject x, IRObject y) throws RulesException{
//        return java.lang.Math.pow(2, 6);
//    }
//    
//    public Double Pow(IRObject x) throws RulesException{
//        Patient patient = IRObjConverter.ConvertIRObjToPatient(x);
//        int n=JOptionPane.showConfirmDialog(null, "test"
//            ,"ATTENTION!",JOptionPane.YES_NO_OPTION);
//        if(n == JOptionPane.OK_OPTION){
//            
//        }
//        return java.lang.Math.pow(2, 2);
//    }
//    
//    public Double Pow() throws RulesException{
//        return java.lang.Math.pow(2, 10);
//    }
    public Boolean ShowBooleanQuestionDialog(IRObject message){
        Boolean result = false;
        String messString = message.stringValue();
        int n=JOptionPane.showConfirmDialog(null, messString
            ,"Question",JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.OK_OPTION){
            result = true;
        }
        return result;
    }
    
    public Boolean HRAskForExercise(){
        return HRDevUtils.AskForExercise();
    }
    
    public Double CalculateHRAverage(IRObject patientID) throws RulesException, SQLException{
        return HRDevUtils.CalculateHRAverage(patientID.intValue());
    }
    
    public Double CalculateHRAverage7(int patientID) throws RulesException, SQLException{
        return HRDevUtils.CalculateHRAverage7(patientID);
    }
    
}
