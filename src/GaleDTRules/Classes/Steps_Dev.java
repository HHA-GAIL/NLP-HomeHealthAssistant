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
public class Steps_Dev {
    private Integer StepsID;
    private Integer PatientID_FK;
    private Integer DevID_FK;
    private Double Steps;
    private Date DateTime;

    /**
     * @return the StepsID
     */
    public Integer getStepsID() {
        return StepsID;
    }

    /**
     * @param StepsID the StepsID to set
     */
    public void setStepsID(Object StepsID) {
        this.StepsID = (Integer)StepsID;
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
        this.DevID_FK =(Integer) DevID_FK;
    }

    /**
     * @return the Steps
     */
    public Double getSteps() {
        return Steps;
    }

    /**
     * @param Steps the Steps to set
     */
    public void setSteps(Object Steps) {
        this.Steps =0.0 + (Integer)Steps;
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
