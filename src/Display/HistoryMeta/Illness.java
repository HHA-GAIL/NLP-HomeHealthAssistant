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
public abstract class Illness extends Temp.HistoryMeta.Illness implements History{

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
     * @param illnesshrf
     */
    @Override
    public void setIllnesshrf(byte illnesshrf) {
        super.setIllnesshrf(illnesshrf);
    }

    /**
     *
     * @param resolution
     */
    @Override
    public void setResolution(String resolution) {
        super.setResolution(resolution);
    }

    /**
     *
     * @param illness
     */
    @Override
    public void setIllness(String illness) {
        super.setIllness(illness);
    }

    /**
     *
     * @param illnessdate
     */
    @Override
    public void setIllnessdate(String illnessdate) {
        super.setIllnessdate(illnessdate);
    }

    /**
     *
     * @param patientid
     */
    @Override
    public void setPatientid(int patientid) {
        super.setPatientid(patientid);
    }

    /**
     *
     * @param illnessid
     */
    @Override
    public void setIllnessid(int illnessid) {
        super.setIllnessid(illnessid);
    }
    
}
