/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display.PatientMeta;

import java.sql.Date;

/**
 *
 * @author Brian
 */
public abstract class Instruction extends Temp.PatientMeta.Instruction{

    /**
     *
     * @param deleted
     * @throws Exception
     */
    @Override
    public void setDeleted(byte deleted) throws Exception {
        super.setDeleted(deleted);
    }

    /**
     *
     * @param frequencyID
     * @throws Exception
     */
    @Override
    public void setFrequencyID(int frequencyID) throws Exception {
        super.setFrequencyID(frequencyID);
    }

    /**
     *
     * @param completionDate
     * @throws Exception
     */
    @Override
    public void setCompletionDate(Date completionDate) throws Exception {
        super.setCompletionDate(completionDate);
    }

    /**
     *
     * @param dateGiven
     * @throws Exception
     */
    @Override
    public void setDateGiven(Date dateGiven) throws Exception {
        super.setDateGiven(dateGiven);
    }

    /**
     *
     * @param instruction
     * @throws Exception
     */
    @Override
    public void setInstruction(String instruction) throws Exception {
        super.setInstruction(instruction);
    }

    /**
     *
     * @param encounterID
     * @throws Exception
     */
    @Override
    public void setEncounterID(int encounterID) throws Exception {
        super.setEncounterID(encounterID);
    }

    /**
     *
     * @param patientID
     * @throws Exception
     */
    @Override
    public void setPatientID(int patientID) throws Exception {
        super.setPatientID(patientID);
    }

    /**
     *
     * @param instructionsID
     * @throws Exception
     */
    @Override
    public void setInstructionsID(int instructionsID) throws Exception{
        super.setInstructionsID(instructionsID);
    }

   
    
    
}
