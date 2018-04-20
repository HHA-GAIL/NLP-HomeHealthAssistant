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
public class Weight_Dev {
    private Integer WeightID;
    private Integer PatientID_FK;
    private Integer DevID_FK;
    private Double Weight;
    private Date DateTime;

    /**
     * @return the WeightID
     */
    public Integer getWeightID() {
        return WeightID;
    }

    /**
     * @param WeightID the WeightID to set
     */
    public void setWeightID(Object WeightID) {
        this.WeightID =(Integer) WeightID;
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
        this.PatientID_FK =(Integer) PatientID_FK;
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
        this.DevID_FK =(Integer) DevID_FK;
    }

    /**
     * @return the Weight
     */
    public Double getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(Object Weight) {
        this.Weight =(Double) Weight;
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
        this.DateTime =(Date) DateTime;
    }
}
