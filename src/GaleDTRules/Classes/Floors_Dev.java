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
public class Floors_Dev {
    private Integer FloorsID;
    private Integer PatientID_FK;
    private Integer DevID_FK;
    private Integer Floors;
    private Date DateTime;

    /**
     * @return the FloorsID
     */
    public Integer getFloorsID() {
        return FloorsID;
    }

    /**
     * @param FloorsID the FloorsID to set
     */
    public void setFloorsID(Object FloorsID) {
        this.FloorsID = (Integer)FloorsID;
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
     * @return the Floors
     */
    public Integer getFloors() {
        return Floors;
    }

    /**
     * @param Floors the Floors to set
     */
    public void setFloors(Object Floors) {
        this.Floors = (Integer)Floors;
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
