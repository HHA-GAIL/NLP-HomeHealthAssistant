/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.History;

import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Brian
 */
public abstract class Genetic extends Display.HistoryMeta.Genetic implements History{

    @Override
    public byte getDeleted() {
        return super.getDeleted();
    }

    @Override
    public String getComments() {
        return super.getComments();
    }

    @Override
    public byte getAnyother() {
        return super.getAnyother();
    }

    @Override
    public String getMedicationlistsincelastlmp() {
        return super.getMedicationlistsincelastlmp();
    }

    @Override
    public byte getMedicationssincelmp() {
        return super.getMedicationssincelmp();
    }

    @Override
    public byte getRecurrentpregnancyloss() {
        return super.getRecurrentpregnancyloss();
    }

    @Override
    public byte getMotherorfatherhadchildwithbirthdefect() {
        return super.getMotherorfatherhadchildwithbirthdefect();
    }

    @Override
    public byte getMaternalmetabolicdisorder() {
        return super.getMaternalmetabolicdisorder();
    }

    @Override
    public byte getOtherchromosomaldisorder() {
        return super.getOtherchromosomaldisorder();
    }

    @Override
    public byte getTestedforfragilex() {
        return super.getTestedforfragilex();
    }

    @Override
    public byte getMentalretardation() {
        return super.getMentalretardation();
    }

    @Override
    public byte getHuntingtonschorea() {
        return super.getHuntingtonschorea();
    }

    @Override
    public byte getCysticfibrosis() {
        return super.getCysticfibrosis();
    }

    @Override
    public byte getMusculardystrophy() {
        return super.getMusculardystrophy();
    }

    @Override
    public byte getHemophilia() {
        return super.getHemophilia();
    }

    @Override
    public byte getSicklecelldisease() {
        return super.getSicklecelldisease();
    }

    @Override
    public byte getCanavandisease() {
        return super.getCanavandisease();
    }

    @Override
    public byte getTaysachs() {
        return super.getTaysachs();
    }

    @Override
    public byte getDownsyndrome() {
        return super.getDownsyndrome();
    }

    @Override
    public byte getCongenitalheartdefect() {
        return super.getCongenitalheartdefect();
    }

    @Override
    public byte getNeuraltubedefect() {
        return super.getNeuraltubedefect();
    }

    @Override
    public byte getThalassemia() {
        return super.getThalassemia();
    }

    @Override
    public byte getPatientagegreaterthan35() {
        return super.getPatientagegreaterthan35();
    }

    @Override
    public Date getRecordcreatedate() {
        return super.getRecordcreatedate();
    }

    @Override
    public int getHcpid() {
        return super.getHcpid();
    }

    @Override
    public int getPatientid() {
        return super.getPatientid();
    }

    @Override
    public int getGeneticscreeningid() {
        return super.getGeneticscreeningid();
    }
}
