/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleDTRules.Classes;

import java.util.Date;


/**
 *
 * @author NazonaX
 */
public class BMI_Dev {
    
    private Integer BMIID;
    private Integer PatientID_FK;
    private Integer DevID_FK;
    private Double BMI; 
    private Date DateTime;

    /**
     * @return the BMIID
     */
    public Integer getBMIID() {
        return BMIID;
    }

    /**
     * @param BMIID the BMIID to set
     */
    public void setBMIID(Object BMIID) {
        this.BMIID = (Integer)BMIID;
    }

    /**
     * @return the PatientID_FK
     */
    public Integer getPatientID_FK() {
        return PatientID_FK;
    }

    /**
     * @param PatientID_FK the PatientID_FK to set
     */
    public void setPatientID_FK(Object PatientID_FK) {
        this.PatientID_FK = (Integer)PatientID_FK;
    }

    /**
     * @return the DevID_FK
     */
    public Integer getDevID_FK() {
        return DevID_FK;
    }

    /**
     * @param DevID_FK the DevID_FK to set
     */
    public void setDevID_FK(Object DevID_FK) {
        this.DevID_FK = (Integer)DevID_FK;
    }

    /**
     * @return the BMI
     */
    public Double getBMI() {
        return BMI;
    }

    /**
     * @param BMI the BMI to set
     */
    public void setBMI(Object BMI) {
        this.BMI = (Double)BMI;
    }

    /**
     * @return the DateTime
     */
    public Date getDateTime() {
        return DateTime;
    }

    /**
     * @param DateTime the DateTime to set
     */
    public void setDateTime(Object DateTime) {
        this.DateTime = (Date)DateTime;
    }
        
        
    
}
