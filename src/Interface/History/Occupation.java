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
public class Occupation extends Display.HistoryMeta.Occupation implements History{

    @Override
    public byte getDeleted() {
        return super.getDeleted();
    }

    @Override
    public Date getLastWorkDate() {
        return super.getLastWorkDate();
    }

    @Override
    public byte getOccupationalHRF() {
        return super.getOccupationalHRF();
    }

    @Override
    public String getCauseOfDisability() {
        return super.getCauseOfDisability();
    }

    @Override
    public byte getDisability() {
        return super.getDisability();
    }

    @Override
    public byte getCurrent() {
        return super.getCurrent();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public Date getEndDate() {
        return super.getEndDate();
    }

    @Override
    public Date getStartDate() {
        return super.getStartDate();
    }

    @Override
    public int getPatientID() {
        return super.getPatientID();
    }

    @Override
    public int getOccupationalID() {
        return super.getOccupationalID();
    }

    @Override
    public int getNextID() throws Exception {
        return super.getNextID();
    }
    
}
