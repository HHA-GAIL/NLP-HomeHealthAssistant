/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display.HistoryMeta;

import java.sql.Date;

/**
 *
 * @author Brian
 */
public abstract class Occupation extends Temp.HistoryMeta.Occupation implements History{

    /**
     *
     * @param deleted
     */
    @Override
    public void setDeleted(byte deleted) {
        super.setDeleted(deleted); 
    }

    /**
     *
     * @param lastWorkDate
     */
    @Override
    public void setLastWorkDate(Date lastWorkDate) {
        super.setLastWorkDate(lastWorkDate); 
    }

    /**
     *
     * @param occupationalHRF
     */
    @Override
    public void setOccupationalHRF(byte occupationalHRF) {
        super.setOccupationalHRF(occupationalHRF); 
    }

    /**
     *
     * @param causeOfDisability
     */
    @Override
    public void setCauseOfDisability(String causeOfDisability) {
        super.setCauseOfDisability(causeOfDisability); 
    }

    /**
     *
     * @param disability
     */
    @Override
    public void setDisability(byte disability) {
        super.setDisability(disability); 
    }

    /**
     *
     * @param current
     */
    @Override
    public void setCurrent(byte current) {
        super.setCurrent(current); 
    }

    /**
     *
     * @param description
     */
    @Override
    public void setDescription(String description) {
        super.setDescription(description); 
    }

    /**
     *
     * @param endDate
     */
    @Override
    public void setEndDate(Date endDate) {
        super.setEndDate(endDate); 
    }

    /**
     *
     * @param startDate
     */
    @Override
    public void setStartDate(Date startDate) {
        super.setStartDate(startDate); 
    }

    /**
     *
     * @param patientID
     */
    @Override
    public void setPatientID(int patientID) {
        super.setPatientID(patientID); 
    }

    /**
     *
     * @param occupationalID
     */
    @Override
    public void setOccupationalID(int occupationalID) {
        super.setOccupationalID(occupationalID); 
    }
        
}
