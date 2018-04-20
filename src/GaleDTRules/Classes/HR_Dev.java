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
public class HR_Dev {
    private Integer HRID;
    private Integer PatientID_FK;
    private Integer DevID_FK;
    private Integer HR;
    private Date DateTime;

    /**
     * @return the HRID
     */
    public Integer getHRID() {
        return HRID;
    }

    /**
     * @param HRID the HRID to set
     */
    public void setHRID(Object HRID) {
        this.HRID = (Integer)HRID;
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
     * @return the HR
     */
    public Integer getHR() {
        return HR;
    }

    /**
     * @param HR the HR to set
     */
    public void setHR(Object HR) {
        this.HR = (Integer)HR;
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
    public void setDateTime(Date DateTime) {
        this.DateTime = DateTime;
    }
}
