/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.PatientMeta;

import java.sql.Date;

/**
 *
 * @author Brian
 */
public class Instruction extends Display.PatientMeta.Instruction{
     @Override
    public byte getDeleted() {
        return super.getDeleted();
    }

    @Override
    public int getFrequencyID() {
        return super.getFrequencyID();
    }

    @Override
    public Date getCompletionDate() {
        return super.getCompletionDate();
    }

    @Override
    public Date getDateGiven() {
        return super.getDateGiven();
    }

    @Override
    public String getInstruction() {
        return super.getInstruction();
    }

    @Override
    public int getEncounterID() {
        return super.getEncounterID();
    }

    @Override
    public int getPatientID() {
        return super.getPatientID();
    }

    @Override
    public int getInstructionsID() {
        return super.getInstructionsID();
    }
}
