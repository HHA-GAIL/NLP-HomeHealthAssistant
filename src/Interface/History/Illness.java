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
public class Illness extends Display.HistoryMeta.Illness implements History{

    @Override
    public byte getDeleted() {
        return super.getDeleted();
    }

    @Override
    public byte getIllnesshrf() {
        return super.getIllnesshrf();
    }

    @Override
    public String getResolution() {
        return super.getResolution();
    }

    @Override
    public String getIllness() {
        return super.getIllness();
    }

    @Override
    public String getIllnessdate() {
        return super.getIllnessdate();
    }

    @Override
    public int getPatientid() {
        return super.getPatientid();
    }

    @Override
    public int getIllnessid() {
        return super.getIllnessid();
    }
    
}
