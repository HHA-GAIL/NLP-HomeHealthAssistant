/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dhu.lib;

import com.dtrules.infrastructure.RulesException;
import com.dtrules.interpreter.IRObject;
import edu.dhu.DTRules.entities.Patient;
import javax.swing.JOptionPane;

/**
 *
 * @author HASEE
 */
public class Utils {
    
    public Double Pow(IRObject x, IRObject y) throws RulesException{
        return java.lang.Math.pow(2, 6);
    }
    
    public Double Pow(IRObject x) throws RulesException{
        Patient patient = IRObjConverter.ConvertIRObjToPatient(x);
        int n=JOptionPane.showConfirmDialog(null, "test"
            ,"ATTENTION!",JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.OK_OPTION){
            
        }
        return java.lang.Math.pow(2, 2);
    }
    
    public Double Pow() throws RulesException{
        return java.lang.Math.pow(2, 10);
    }
    
}
