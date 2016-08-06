/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp.HistoryMeta;

import Database.*;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Brian
 */
public abstract class Genetic implements History {

    //Internal Variables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[27];
    private final String[] columnStrings = new String[27];
    private final String tableName = "geneticscreening";

    //definition variables
    private int geneticscreeningid;
    private int patientid;
    private int hcpid;
    private java.sql.Date recordcreatedate;
    private byte patientagegreaterthan35;
    private byte thalassemia;
    private byte neuraltubedefect;
    private byte congenitalheartdefect;
    private byte downsyndrome;
    private byte taysachs;
    private byte canavandisease;
    private byte sicklecelldisease;
    private byte hemophilia;
    private byte musculardystrophy;
    private byte cysticfibrosis;
    private byte huntingtonschorea;
    private byte mentalretardation;
    private byte testedforfragilex;
    private byte otherchromosomaldisorder;
    private byte maternalmetabolicdisorder;
    private byte motherorfatherhadchildwithbirthdefect;
    private byte recurrentpregnancyloss;
    private byte medicationssincelmp;
    private String medicationlistsincelastlmp;
    private byte anyother;
    private String comments;
    private byte deleted;

    public Genetic() {
        this.readData = new Read();
        fillColumnStrings();
    }

    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(this.geneticscreeningid);
        valueStrings[1] = String.valueOf(this.patientid);
        valueStrings[2] = String.valueOf(this.hcpid);
        valueStrings[3] = String.valueOf(this.recordcreatedate);
        valueStrings[4] = String.valueOf(this.patientagegreaterthan35);
        valueStrings[5] = String.valueOf(this.thalassemia);
        valueStrings[6] = String.valueOf(this.neuraltubedefect);
        valueStrings[7] = String.valueOf(this.congenitalheartdefect);
        valueStrings[8] = String.valueOf(this.downsyndrome);
        valueStrings[9] = String.valueOf(this.taysachs);
        valueStrings[10] = String.valueOf(this.canavandisease);
        valueStrings[11] = String.valueOf(this.sicklecelldisease);
        valueStrings[12] = String.valueOf(this.hemophilia);
        valueStrings[13] = String.valueOf(this.musculardystrophy);
        valueStrings[14] = String.valueOf(this.cysticfibrosis);
        valueStrings[15] = String.valueOf(this.huntingtonschorea);
        valueStrings[16] = String.valueOf(this.mentalretardation);
        valueStrings[17] = String.valueOf(this.testedforfragilex);
        valueStrings[18] = String.valueOf(this.otherchromosomaldisorder);
        valueStrings[19] = String.valueOf(this.maternalmetabolicdisorder);
        valueStrings[20] = String.valueOf(this.motherorfatherhadchildwithbirthdefect);
        valueStrings[21] = String.valueOf(this.recurrentpregnancyloss);
        valueStrings[22] = String.valueOf(this.medicationssincelmp);
        valueStrings[23] = String.valueOf(this.medicationlistsincelastlmp);
        valueStrings[24] = String.valueOf(this.anyother);
        valueStrings[25] = String.valueOf(this.comments);
        valueStrings[26] = String.valueOf(this.deleted);
    }

    @Override
    public final void fillColumnStrings() {
        columnStrings[0] = "GeneticScreeningID";
        columnStrings[1] = "PatientID";
        columnStrings[2] = "HCPID";
        columnStrings[3] = "RecordCreateDate";
        columnStrings[4] = "PatientAgeGreaterThan35";
        columnStrings[5] = "Thalassemia";
        columnStrings[6] = "NeuralTubeDefect";
        columnStrings[7] = "CongenitalHeartDefect";
        columnStrings[8] = "DownSyndrome";
        columnStrings[9] = "TaySachs";
        columnStrings[10] = "CanavanDisease";
        columnStrings[11] = "SickleCellDisease";
        columnStrings[12] = "Hemophilia";
        columnStrings[13] = "MuscularDystrophy";
        columnStrings[14] = "CysticFibrosis";
        columnStrings[15] = "HuntingtonsChorea";
        columnStrings[16] = "MentalRetardation";
        columnStrings[17] = "TestedForFragileX";
        columnStrings[18] = "OtherChromosomalDisorder";
        columnStrings[19] = "MaternalMetabolicDisorder";
        columnStrings[20] = "MotherOrFatherHadChildWithBirthDefect";
        columnStrings[21] = "RecurrentPregnancyLoss";
        columnStrings[22] = "MedicationsSinceLMP";
        columnStrings[23] = "MedicationListSinceLastLMP";
        columnStrings[24] = "AnyOther";
        columnStrings[25] = "Comments";
        columnStrings[26] = "deleted";
    }

    @Override
    public void populateData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void populateFromResultSet() throws Exception {
        currentResultSet.moveToCurrentRow();
        this.geneticscreeningid = currentResultSet.getInt("GeneticScreeningID");
        this.patientid = currentResultSet.getInt("PatientID");
        this.hcpid = currentResultSet.getInt("HCPID");
        this.recordcreatedate = currentResultSet.getDate("RecordCreateDate");
        this.patientagegreaterthan35 = currentResultSet.getByte("PatientAgeGreaterThan35");
        this.thalassemia = currentResultSet.getByte("Thalassemia");
        this.neuraltubedefect = currentResultSet.getByte("NeuralTubeDefect");
        this.congenitalheartdefect = currentResultSet.getByte("CongenitalHeartDefect");
        this.downsyndrome = currentResultSet.getByte("DownSyndrome");
        this.taysachs = currentResultSet.getByte("TaySachs");
        this.canavandisease = currentResultSet.getByte("CanavanDisease");
        this.sicklecelldisease = currentResultSet.getByte("SickleCellDisease");
        this.hemophilia = currentResultSet.getByte("Hemophilia");
        this.musculardystrophy = currentResultSet.getByte("MuscularDystrophy");
        this.cysticfibrosis = currentResultSet.getByte("CysticFibrosis");
        this.huntingtonschorea = currentResultSet.getByte("HuntingtonsChorea");
        this.mentalretardation = currentResultSet.getByte("MentalRetardation");
        this.testedforfragilex = currentResultSet.getByte("TestedForFragileX");
        this.otherchromosomaldisorder = currentResultSet.getByte("OtherChromosomalDisorder");
        this.maternalmetabolicdisorder = currentResultSet.getByte("MaternalMetabolicDisorder");
        this.motherorfatherhadchildwithbirthdefect = currentResultSet.getByte("MotherOrFatherHadChildWithBirthDefect");
        this.recurrentpregnancyloss = currentResultSet.getByte("RecurrentPregnancyLoss");
        this.medicationssincelmp = currentResultSet.getByte("MedicationsSinceLMP");
        this.medicationlistsincelastlmp = currentResultSet.getString("MedicationListSinceLastLMP");
        this.anyother = currentResultSet.getByte("AnyOther");
        this.comments = currentResultSet.getString("Comments");
        this.deleted = currentResultSet.getByte("deleted");
    }

    @Override
    public void populateFromResultSet(int position) throws Exception {
        currentResultSet.absolute(1);
        this.geneticscreeningid = currentResultSet.getInt("GeneticScreeningID");
        this.patientid = currentResultSet.getInt("PatientID");
        this.hcpid = currentResultSet.getInt("HCPID");
        this.recordcreatedate = currentResultSet.getDate("RecordCreateDate");
        this.patientagegreaterthan35 = currentResultSet.getByte("PatientAgeGreaterThan35");
        this.thalassemia = currentResultSet.getByte("Thalassemia");
        this.neuraltubedefect = currentResultSet.getByte("NeuralTubeDefect");
        this.congenitalheartdefect = currentResultSet.getByte("CongenitalHeartDefect");
        this.downsyndrome = currentResultSet.getByte("DownSyndrome");
        this.taysachs = currentResultSet.getByte("TaySachs");
        this.canavandisease = currentResultSet.getByte("CanavanDisease");
        this.sicklecelldisease = currentResultSet.getByte("SickleCellDisease");
        this.hemophilia = currentResultSet.getByte("Hemophilia");
        this.musculardystrophy = currentResultSet.getByte("MuscularDystrophy");
        this.cysticfibrosis = currentResultSet.getByte("CysticFibrosis");
        this.huntingtonschorea = currentResultSet.getByte("HuntingtonsChorea");
        this.mentalretardation = currentResultSet.getByte("MentalRetardation");
        this.testedforfragilex = currentResultSet.getByte("TestedForFragileX");
        this.otherchromosomaldisorder = currentResultSet.getByte("OtherChromosomalDisorder");
        this.maternalmetabolicdisorder = currentResultSet.getByte("MaternalMetabolicDisorder");
        this.motherorfatherhadchildwithbirthdefect = currentResultSet.getByte("MotherOrFatherHadChildWithBirthDefect");
        this.recurrentpregnancyloss = currentResultSet.getByte("RecurrentPregnancyLoss");
        this.medicationssincelmp = currentResultSet.getByte("MedicationsSinceLMP");
        this.medicationlistsincelastlmp = currentResultSet.getString("MedicationListSinceLastLMP");
        this.anyother = currentResultSet.getByte("AnyOther");
        this.comments = currentResultSet.getString("Comments");
        this.deleted = currentResultSet.getByte("deleted");
    }

    @Override
    public void populateFromResultSet(ResultSet resultSet) throws Exception {
        resultSet.absolute(1);
        this.geneticscreeningid = resultSet.getInt("GeneticScreeningID");
        this.patientid = resultSet.getInt("PatientID");
        this.hcpid = resultSet.getInt("HCPID");
        this.recordcreatedate = resultSet.getDate("RecordCreateDate");
        this.patientagegreaterthan35 = resultSet.getByte("PatientAgeGreaterThan35");
        this.thalassemia = resultSet.getByte("Thalassemia");
        this.neuraltubedefect = resultSet.getByte("NeuralTubeDefect");
        this.congenitalheartdefect = resultSet.getByte("CongenitalHeartDefect");
        this.downsyndrome = resultSet.getByte("DownSyndrome");
        this.taysachs = resultSet.getByte("TaySachs");
        this.canavandisease = resultSet.getByte("CanavanDisease");
        this.sicklecelldisease = resultSet.getByte("SickleCellDisease");
        this.hemophilia = resultSet.getByte("Hemophilia");
        this.musculardystrophy = resultSet.getByte("MuscularDystrophy");
        this.cysticfibrosis = resultSet.getByte("CysticFibrosis");
        this.huntingtonschorea = resultSet.getByte("HuntingtonsChorea");
        this.mentalretardation = resultSet.getByte("MentalRetardation");
        this.testedforfragilex = resultSet.getByte("TestedForFragileX");
        this.otherchromosomaldisorder = resultSet.getByte("OtherChromosomalDisorder");
        this.maternalmetabolicdisorder = resultSet.getByte("MaternalMetabolicDisorder");
        this.motherorfatherhadchildwithbirthdefect = resultSet.getByte("MotherOrFatherHadChildWithBirthDefect");
        this.recurrentpregnancyloss = resultSet.getByte("RecurrentPregnancyLoss");
        this.medicationssincelmp = resultSet.getByte("MedicationsSinceLMP");
        this.medicationlistsincelastlmp = resultSet.getString("MedicationListSinceLastLMP");
        this.anyother = resultSet.getByte("AnyOther");
        this.comments = resultSet.getString("Comments");
        this.deleted = resultSet.getByte("deleted");
    }

    private void changeGeneticScreening(Genetic newGenetic) {
        this.geneticscreeningid = newGenetic.getGeneticscreeningid();
        this.patientid = newGenetic.getPatientid();
        this.hcpid = newGenetic.getHcpid();
        this.recordcreatedate = newGenetic.getRecordcreatedate();
        this.patientagegreaterthan35 = newGenetic.getPatientagegreaterthan35();
        this.thalassemia = newGenetic.getThalassemia();
        this.neuraltubedefect = newGenetic.getNeuraltubedefect();
        this.congenitalheartdefect = newGenetic.getCongenitalheartdefect();
        this.downsyndrome = newGenetic.getDownsyndrome();
        this.taysachs = newGenetic.getTaysachs();
        this.canavandisease = newGenetic.getCanavandisease();
        this.sicklecelldisease = newGenetic.getSicklecelldisease();
        this.hemophilia = newGenetic.getHemophilia();
        this.musculardystrophy = newGenetic.getMusculardystrophy();
        this.cysticfibrosis = newGenetic.getCysticfibrosis();
        this.huntingtonschorea = newGenetic.getHuntingtonschorea();
        this.mentalretardation = newGenetic.getMentalretardation();
        this.testedforfragilex = newGenetic.getTestedforfragilex();
        this.otherchromosomaldisorder = newGenetic.getOtherchromosomaldisorder();
        this.maternalmetabolicdisorder = newGenetic.getMaternalmetabolicdisorder();
        this.motherorfatherhadchildwithbirthdefect = newGenetic.getMotherorfatherhadchildwithbirthdefect();
        this.recurrentpregnancyloss = newGenetic.getRecurrentpregnancyloss();
        this.medicationssincelmp = newGenetic.getMedicationssincelmp();
        this.medicationlistsincelastlmp = newGenetic.getMedicationlistsincelastlmp();
        this.anyother = newGenetic.getAnyother();
        this.comments = newGenetic.getComments();
        this.deleted = newGenetic.getDeleted();
    }

    //Getters
    public int getGeneticscreeningid() {
        return geneticscreeningid;
    }

    public int getPatientid() {
        return patientid;
    }

    public int getHcpid() {
        return hcpid;
    }

    public Date getRecordcreatedate() {
        return recordcreatedate;
    }

    public byte getPatientagegreaterthan35() {
        return patientagegreaterthan35;
    }

    public byte getThalassemia() {
        return thalassemia;
    }

    public byte getNeuraltubedefect() {
        return neuraltubedefect;
    }

    public byte getCongenitalheartdefect() {
        return congenitalheartdefect;
    }

    public byte getDownsyndrome() {
        return downsyndrome;
    }

    public byte getTaysachs() {
        return taysachs;
    }

    public byte getCanavandisease() {
        return canavandisease;
    }

    public byte getSicklecelldisease() {
        return sicklecelldisease;
    }

    public byte getHemophilia() {
        return hemophilia;
    }

    public byte getMusculardystrophy() {
        return musculardystrophy;
    }

    public byte getCysticfibrosis() {
        return cysticfibrosis;
    }

    public byte getHuntingtonschorea() {
        return huntingtonschorea;
    }

    public byte getMentalretardation() {
        return mentalretardation;
    }

    public byte getTestedforfragilex() {
        return testedforfragilex;
    }

    public byte getOtherchromosomaldisorder() {
        return otherchromosomaldisorder;
    }

    public byte getMaternalmetabolicdisorder() {
        return maternalmetabolicdisorder;
    }

    public byte getMotherorfatherhadchildwithbirthdefect() {
        return motherorfatherhadchildwithbirthdefect;
    }

    public byte getRecurrentpregnancyloss() {
        return recurrentpregnancyloss;
    }

    public byte getMedicationssincelmp() {
        return medicationssincelmp;
    }

    public String getMedicationlistsincelastlmp() {
        return medicationlistsincelastlmp;
    }

    public byte getAnyother() {
        return anyother;
    }

    public String getComments() {
        return comments;
    }

    public byte getDeleted() {
        return deleted;
    }
    //setters

    public void setGeneticscreeningid(int geneticscreeningid) {
        this.geneticscreeningid = geneticscreeningid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public void setHcpid(int hcpid) {
        this.hcpid = hcpid;
    }

    public void setRecordcreatedate(Date recordcreatedate) {
        this.recordcreatedate = recordcreatedate;
    }

    public void setPatientagegreaterthan35(byte patientagegreaterthan35) {
        this.patientagegreaterthan35 = patientagegreaterthan35;
    }

    public void setThalassemia(byte thalassemia) {
        this.thalassemia = thalassemia;
    }

    public void setNeuraltubedefect(byte neuraltubedefect) {
        this.neuraltubedefect = neuraltubedefect;
    }

    public void setCongenitalheartdefect(byte congenitalheartdefect) {
        this.congenitalheartdefect = congenitalheartdefect;
    }

    public void setDownsyndrome(byte downsyndrome) {
        this.downsyndrome = downsyndrome;
    }

    public void setTaysachs(byte taysachs) {
        this.taysachs = taysachs;
    }

    public void setCanavandisease(byte canavandisease) {
        this.canavandisease = canavandisease;
    }

    public void setSicklecelldisease(byte sicklecelldisease) {
        this.sicklecelldisease = sicklecelldisease;
    }

    public void setHemophilia(byte hemophilia) {
        this.hemophilia = hemophilia;
    }

    public void setMusculardystrophy(byte musculardystrophy) {
        this.musculardystrophy = musculardystrophy;
    }

    public void setCysticfibrosis(byte cysticfibrosis) {
        this.cysticfibrosis = cysticfibrosis;
    }

    public void setHuntingtonschorea(byte huntingtonschorea) {
        this.huntingtonschorea = huntingtonschorea;
    }

    public void setMentalretardation(byte mentalretardation) {
        this.mentalretardation = mentalretardation;
    }

    public void setTestedforfragilex(byte testedforfragilex) {
        this.testedforfragilex = testedforfragilex;
    }

    public void setOtherchromosomaldisorder(byte otherchromosomaldisorder) {
        this.otherchromosomaldisorder = otherchromosomaldisorder;
    }

    public void setMaternalmetabolicdisorder(byte maternalmetabolicdisorder) {
        this.maternalmetabolicdisorder = maternalmetabolicdisorder;
    }

    public void setMotherorfatherhadchildwithbirthdefect(byte motherorfatherhadchildwithbirthdefect) {
        this.motherorfatherhadchildwithbirthdefect = motherorfatherhadchildwithbirthdefect;
    }

    public void setRecurrentpregnancyloss(byte recurrentpregnancyloss) {
        this.recurrentpregnancyloss = recurrentpregnancyloss;
    }

    public void setMedicationssincelmp(byte medicationssincelmp) {
        this.medicationssincelmp = medicationssincelmp;
    }

    public void setMedicationlistsincelastlmp(String medicationlistsincelastlmp) {
        this.medicationlistsincelastlmp = medicationlistsincelastlmp;
    }

    public void setAnyother(byte anyother) {
        this.anyother = anyother;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

}
