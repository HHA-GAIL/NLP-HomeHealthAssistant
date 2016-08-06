/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display.HistoryMeta;

import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Brian
 */
public abstract class Genetic extends Temp.HistoryMeta.Genetic implements History {

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
     * @param comments
     */
    @Override
    public void setComments(String comments) {
        super.setComments(comments);
    }

    /**
     *
     * @param anyother
     */
    @Override
    public void setAnyother(byte anyother) {
        super.setAnyother(anyother);
    }

    /**
     *
     * @param medicationlistsincelastlmp
     */
    @Override
    public void setMedicationlistsincelastlmp(String medicationlistsincelastlmp) {
        super.setMedicationlistsincelastlmp(medicationlistsincelastlmp);
    }

    /**
     *
     * @param medicationssincelmp
     */
    @Override
    public void setMedicationssincelmp(byte medicationssincelmp) {
        super.setMedicationssincelmp(medicationssincelmp);
    }

    /**
     *
     * @param recurrentpregnancyloss
     */
    @Override
    public void setRecurrentpregnancyloss(byte recurrentpregnancyloss) {
        super.setRecurrentpregnancyloss(recurrentpregnancyloss);
    }

    /**
     *
     * @param motherorfatherhadchildwithbirthdefect
     */
    @Override
    public void setMotherorfatherhadchildwithbirthdefect(byte motherorfatherhadchildwithbirthdefect) {
        super.setMotherorfatherhadchildwithbirthdefect(motherorfatherhadchildwithbirthdefect);
    }

    /**
     *
     * @param maternalmetabolicdisorder
     */
    @Override
    public void setMaternalmetabolicdisorder(byte maternalmetabolicdisorder) {
        super.setMaternalmetabolicdisorder(maternalmetabolicdisorder);
    }

    /**
     *
     * @param otherchromosomaldisorder
     */
    @Override
    public void setOtherchromosomaldisorder(byte otherchromosomaldisorder) {
        super.setOtherchromosomaldisorder(otherchromosomaldisorder);
    }

    /**
     *
     * @param testedforfragilex
     */
    @Override
    public void setTestedforfragilex(byte testedforfragilex) {
        super.setTestedforfragilex(testedforfragilex);
    }

    /**
     *
     * @param mentalretardation
     */
    @Override
    public void setMentalretardation(byte mentalretardation) {
        super.setMentalretardation(mentalretardation);
    }

    /**
     *
     * @param huntingtonschorea
     */
    @Override
    public void setHuntingtonschorea(byte huntingtonschorea) {
        super.setHuntingtonschorea(huntingtonschorea);
    }

    /**
     *
     * @param cysticfibrosis
     */
    @Override
    public void setCysticfibrosis(byte cysticfibrosis) {
        super.setCysticfibrosis(cysticfibrosis);
    }

    /**
     *
     * @param musculardystrophy
     */
    @Override
    public void setMusculardystrophy(byte musculardystrophy) {
        super.setMusculardystrophy(musculardystrophy);
    }

    /**
     *
     * @param hemophilia
     */
    @Override
    public void setHemophilia(byte hemophilia) {
        super.setHemophilia(hemophilia);
    }

    /**
     *
     * @param sicklecelldisease
     */
    @Override
    public void setSicklecelldisease(byte sicklecelldisease) {
        super.setSicklecelldisease(sicklecelldisease);
    }

    /**
     *
     * @param canavandisease
     */
    @Override
    public void setCanavandisease(byte canavandisease) {
        super.setCanavandisease(canavandisease);
    }

    /**
     *
     * @param taysachs
     */
    @Override
    public void setTaysachs(byte taysachs) {
        super.setTaysachs(taysachs);
    }

    /**
     *
     * @param downsyndrome
     */
    @Override
    public void setDownsyndrome(byte downsyndrome) {
        super.setDownsyndrome(downsyndrome);
    }

    /**
     *
     * @param congenitalheartdefect
     */
    @Override
    public void setCongenitalheartdefect(byte congenitalheartdefect) {
        super.setCongenitalheartdefect(congenitalheartdefect);
    }

    /**
     *
     * @param neuraltubedefect
     */
    @Override
    public void setNeuraltubedefect(byte neuraltubedefect) {
        super.setNeuraltubedefect(neuraltubedefect);
    }

    /**
     *
     * @param thalassemia
     */
    @Override
    public void setThalassemia(byte thalassemia) {
        super.setThalassemia(thalassemia);
    }

    /**
     *
     * @param patientagegreaterthan35
     */
    @Override
    public void setPatientagegreaterthan35(byte patientagegreaterthan35) {
        super.setPatientagegreaterthan35(patientagegreaterthan35);
    }

    /**
     *
     * @param recordcreatedate
     */
    @Override
    public void setRecordcreatedate(Date recordcreatedate) {
        super.setRecordcreatedate(recordcreatedate);
    }

    /**
     *
     * @param hcpid
     */
    @Override
    public void setHcpid(int hcpid) {
        super.setHcpid(hcpid);
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
     * @param geneticscreeningid
     */
    @Override
    public void setGeneticscreeningid(int geneticscreeningid) {
        super.setGeneticscreeningid(geneticscreeningid);
    }

}
