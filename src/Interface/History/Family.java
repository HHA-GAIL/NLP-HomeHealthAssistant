/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.History;

/**
 *
 * @author Brian
 */
public class Family extends Display.HistoryMeta.Family implements History{
    @Override
    public String[] getValueStrings() {
        return super.getValueStrings();
    }

    @Override
    public String[] getColumnStrings() {
        return super.getColumnStrings();
    }

    @Override
    public int getFamilyID() {
        return super.getFamilyID();
    }

    @Override
    public int getPatientID() {
        return super.getPatientID();
    }

    @Override
    public String getRelative() {
        return super.getRelative();
    }

    @Override
    public byte getAlive() {
        return super.getAlive();
    }

    @Override
    public byte getLivesWithPatient() {
        return super.getLivesWithPatient();
    }

    @Override
    public String getMajorDisorder() {
        return super.getMajorDisorder();
    }

    @Override
    public String getSpecificTypeDisorder() {
        return super.getSpecificTypeDisorder();
    }

    @Override
    public byte getDisorderHRF() {
        return super.getDisorderHRF();
    }

    @Override
    public byte getDeleted() {
        return super.getDeleted();
    }
    
    @Override
    public String getName(){
        return super.getName();
    }
}
