/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.History;

import java.sql.Date;


/**
 *
 * @author Brian
 */
public class Immunizations extends Display.HistoryMeta.Immunizations{

    @Override
    public byte getDeleted() {
        return super.getDeleted(); 
    }

    @Override
    public int getHCPId() {
        return super.getHCPId(); 
    }

    @Override
    public String getComments() {
        return super.getComments(); 
    }

    @Override
    public String getDelivery() {
        return super.getDelivery(); 
    }

    @Override
    public Date getExperationDate() {
        return super.getExperationDate(); 
    }

    @Override
    public Date getImmunizationDate() {
        return super.getImmunizationDate(); }

    @Override
    public String getVaccine() {
        return super.getVaccine(); 
    }

    @Override
    public int getPatientID() {
        return super.getPatientID(); 
    }

    @Override
    public int getImmunizationsID() {
        return super.getImmunizationsID(); 
    }

    @Override
    public int getNextID() throws Exception {
        return super.getNextID(); 
    }
    
    
    
}
