/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dhu.lib;

import edu.dhu.DTRules.DAOs.HRDevDAO;
import edu.dhu.DTRules.entities.HR_Dev;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HASEE
 */
public class HRDevUtils {
    
    public static Boolean AskForExercise(){
        Boolean result = false;
        int n=JOptionPane.showConfirmDialog(null, "Have you just do some physical exercise?"
            ,"Question",JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.OK_OPTION){
            result = true;
        }
        return result;
    }

    static Double CalculateHRAverage(int patientID) throws SQLException {
        HRDevDAO hrddao = new HRDevDAO();
        List<HR_Dev> hrs = hrddao.getListByPatientID(patientID);
        if(hrs == null)
            return 0d;
        double sum = 0;
        for(HR_Dev tmp : hrs){
            sum += tmp.getHR();
        }
        return (sum / hrs.size());
    }
    
    static Double CalculateHRAverage7(int patientID) throws SQLException {
        HRDevDAO hrddao = new HRDevDAO();
        List<HR_Dev> hrs = hrddao.getListByPatientID(patientID);
        if(hrs == null)
            return 0d;
        double sum = 0;
        if(hrs.size() <= 7){
            for(HR_Dev tmp : hrs){
                sum += tmp.getHR();
            }
            sum /= hrs.size();
        }
        else
        {
            for(int i = 0; i < 7; i++){
                sum += hrs.get(i).getHR();
            }
            sum /= 7;
        }
        return sum;
    }
    
}
