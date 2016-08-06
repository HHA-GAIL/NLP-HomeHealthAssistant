/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display.HistoryMeta;

/**
 *
 * @author Brian
 */
public abstract class Family extends Temp.HistoryMeta.Family implements History{
    
    /**
     *
     * @param familyID
     */
    @Override
    public void setFamilyID(int familyID) {
        super.setFamilyID(familyID);
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
     * @param relative
     */
    @Override
    public void setRelative(String relative) {
        super.setRelative(relative);
    }

    /**
     *
     * @param alive
     */
    @Override
    public void setAlive(byte alive) {
        super.setAlive(alive);
    }

    /**
     *
     * @param livesWithPatient
     */
    @Override
    public void setLivesWithPatient(byte livesWithPatient) {
        super.setLivesWithPatient(livesWithPatient);
    }

    /**
     *
     * @param majorDisorder
     */
    @Override
    public void setMajorDisorder(String majorDisorder) {
        super.setMajorDisorder(majorDisorder);
    }

    /**
     *
     * @param specificTypeDisorder
     */
    @Override
    public void setSpecificTypeDisorder(String specificTypeDisorder) {
        super.setSpecificTypeDisorder(specificTypeDisorder);
    }

    /**
     *
     * @param disorderHRF
     */
    @Override
    public void setDisorderHRF(byte disorderHRF) {
        super.setDisorderHRF(disorderHRF);
    }

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
     * @param name
     */
    @Override
    public void setName(String name){
        super.setName(name);
    }
    
}
