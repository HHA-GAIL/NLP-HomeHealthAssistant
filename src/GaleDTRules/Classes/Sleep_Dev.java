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
public class Sleep_Dev {
    private Integer SleepID;
    private Integer PatientID_FK;
    private Integer DevID_FK;
    private Double SleepMeasurement;
    private String SleepResults;
    private Date DateTime;

    /**
     * @return the SleepID
     */
    public Integer getSleepID() {
        return SleepID;
    }

    /**
     * @param SleepID the SleepID to set
     */
    public void setSleepID(Object SleepID) {
        this.SleepID = (Integer)SleepID;
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
    
        /**
     * @return the SleepMeasurement
     */
    public Double getSleepMeasurement() {
        return SleepMeasurement;
    }

    /**
     * @param SleepMeasurement the SleepMeasurement to set
     */
    public void setSleepMeasurement(Object SleepMeasurement) {
        this.SleepMeasurement = (Integer)SleepMeasurement + 0.0;
    }

    /**
     * @return the SleepResults
     */
    public String getSleepResults() {
        return SleepResults;
    }

    /**
     * @param SleepResults the SleepResults to set
     */
    public void setSleepResults(Object SleepResults) {
        this.SleepResults = (String)SleepResults;
    }
    
}
