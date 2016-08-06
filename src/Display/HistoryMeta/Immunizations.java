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
public abstract class Immunizations extends Temp.HistoryMeta.Imunization{

    /**
     *
     * @param immunizationsID
     */
    @Override
    public void setImmunizationsID(int immunizationsID) {
        super.setImmunizationsID(immunizationsID);
        
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
     * @param vaccine
     */
    @Override
    public void setVaccine(String vaccine) {
        super.setVaccine(vaccine);
    }

    /**
     *
     * @param immunizationDate
     */
    @Override
    public void setImmunizationDate(Date immunizationDate) {
        super.setImmunizationDate(immunizationDate);
    }

    /**
     *
     * @param experationDate
     */
    @Override
    public void setExperationDate(Date experationDate) {
        super.setExperationDate(experationDate);
    }

    /**
     *
     * @param delivery
     */
    @Override
    public void setDelivery(String delivery) {
        super.setDelivery(delivery);
    }

    /**
     *
     * @param comments
     */
    @Override
    public void setComments(String comments) {
        super.setComments(comments);
    }

    /**
     *
     * @param HCPId
     */
    @Override
    public void setHCPId(int HCPId) {
        super.setHCPId(HCPId);
    }

    /**
     *
     * @param deleted
     */
    @Override
    public void setDeleted(byte deleted) {
        super.setDeleted(deleted);
    }
}
