/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp.HistoryMeta;

import Database.*;
import java.sql.*;

/**
 *
 * @author Brian
 */
public abstract class General implements History {

    //internal Variables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[51];
    private final String[] columnStrings = new String[51];
    private final String tableName = "generalmedicalhistorytable";
    //definition variables

    private int generalmedicalhistoryid;
    private int patientid;
    private String maritalstatus;
    private String education;
    private String growthanddevelopment;
    private String pregnancies;
    private String behavioralhistory;
    private String tobacco;
    private byte tobaccohrf;
    private String tobaccoquantity;
    private String tobaccoduraton;
    private String alcohol;
    private byte alcoholhrf;
    private String alcoholquantity;
    private String alcoholduration;
    private String drug;
    private byte drughrf;
    private String drugtype;
    private String drugduration;
    private String dietary;
    private byte diethrf;
    private String travel;
    private byte travelhrf;
    private String bloodtype;
    private String rh;
    private String medicalhistorynotes;
    private String hxobtainedby;
    private byte hxconfirmedbyhcp;
    private String unabletoobtainhxreason;
    private byte deleted;
    private java.sql.Date lmpdate;
    private String lmpstatus;
    private byte lmp;
    private byte pregnant;
    private java.sql.Date pregnancyduedate;
    private java.sql.Date edc;
    private int numberofchildren;
    private int numberofpregnancies;
    private String lmpestmethod;
    private byte lmpdateapprox;
    private byte menstrualamtnormalyes;
    private byte menstrualamtnormalno;
    private byte mensesmonthlyyes;
    private byte mensesmonthlyno;
    private java.sql.Date mensespriordate;
    private int mensesfreq;
    private int menarcheageofonset;
    private byte onbcpatconceptionyes;
    private byte onbcpatconceptionno;
    private String hospitalofdelivery;
    private double ega;

    public General() {
        this.readData = new Read(tableName);
        fillColumnStrings();
    }

    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(this.generalmedicalhistoryid);
        valueStrings[1] = String.valueOf(this.patientid);
        valueStrings[2] = String.valueOf(this.maritalstatus);
        valueStrings[3] = String.valueOf(this.education);
        valueStrings[4] = String.valueOf(this.growthanddevelopment);
        valueStrings[5] = String.valueOf(this.pregnancies);
        valueStrings[6] = String.valueOf(this.behavioralhistory);
        valueStrings[7] = String.valueOf(this.tobacco);
        valueStrings[8] = String.valueOf(this.tobaccohrf);
        valueStrings[9] = String.valueOf(this.tobaccoquantity);
        valueStrings[10] = String.valueOf(this.tobaccoduraton);
        valueStrings[11] = String.valueOf(this.alcohol);
        valueStrings[12] = String.valueOf(this.alcoholhrf);
        valueStrings[13] = String.valueOf(this.alcoholquantity);
        valueStrings[14] = String.valueOf(this.alcoholduration);
        valueStrings[15] = String.valueOf(this.drug);
        valueStrings[16] = String.valueOf(this.drughrf);
        valueStrings[17] = String.valueOf(this.drugtype);
        valueStrings[18] = String.valueOf(this.drugduration);
        valueStrings[19] = String.valueOf(this.dietary);
        valueStrings[20] = String.valueOf(this.diethrf);
        valueStrings[21] = String.valueOf(this.travel);
        valueStrings[22] = String.valueOf(this.travelhrf);
        valueStrings[23] = String.valueOf(this.bloodtype);
        valueStrings[24] = String.valueOf(this.rh);
        valueStrings[25] = String.valueOf(this.medicalhistorynotes);
        valueStrings[26] = String.valueOf(this.hxobtainedby);
        valueStrings[27] = String.valueOf(this.hxconfirmedbyhcp);
        valueStrings[28] = String.valueOf(this.unabletoobtainhxreason);
        valueStrings[29] = String.valueOf(this.deleted);
        valueStrings[30] = String.valueOf(this.lmpdate);
        valueStrings[31] = String.valueOf(this.lmpstatus);
        valueStrings[32] = String.valueOf(this.lmp);
        valueStrings[33] = String.valueOf(this.pregnant);
        valueStrings[34] = String.valueOf(this.pregnancyduedate);
        valueStrings[35] = String.valueOf(this.edc);
        valueStrings[36] = String.valueOf(this.numberofchildren);
        valueStrings[37] = String.valueOf(this.numberofpregnancies);
        valueStrings[38] = String.valueOf(this.lmpestmethod);
        valueStrings[39] = String.valueOf(this.lmpdateapprox);
        valueStrings[40] = String.valueOf(this.menstrualamtnormalyes);
        valueStrings[41] = String.valueOf(this.menstrualamtnormalno);
        valueStrings[42] = String.valueOf(this.mensesmonthlyyes);
        valueStrings[43] = String.valueOf(this.mensesmonthlyno);
        valueStrings[44] = String.valueOf(this.mensespriordate);
        valueStrings[45] = String.valueOf(this.mensesfreq);
        valueStrings[46] = String.valueOf(this.menarcheageofonset);
        valueStrings[47] = String.valueOf(this.onbcpatconceptionyes);
        valueStrings[48] = String.valueOf(this.onbcpatconceptionno);
        valueStrings[49] = String.valueOf(this.hospitalofdelivery);
        valueStrings[50] = String.valueOf(this.ega);
    }

    @Override
    public void fillColumnStrings() {
        columnStrings[0] = "GeneralMedicalHistoryID";
        columnStrings[1] = "PatientID";
        columnStrings[2] = "MaritalStatus";
        columnStrings[3] = "Education";
        columnStrings[4] = "GrowthAndDevelopment";
        columnStrings[5] = "Pregnancies";
        columnStrings[6] = "BehavioralHistory";
        columnStrings[7] = "Tobacco";
        columnStrings[8] = "TobaccoHRF";
        columnStrings[9] = "TobaccoQuantity";
        columnStrings[10] = "Tobaccoduraton";
        columnStrings[11] = "Alcohol";
        columnStrings[12] = "AlcoholHRF";
        columnStrings[13] = "AlcoholQuantity";
        columnStrings[14] = "Alcoholduration";
        columnStrings[15] = "Drug";
        columnStrings[16] = "DrugHRF";
        columnStrings[17] = "DrugType";
        columnStrings[18] = "Drugduration";
        columnStrings[19] = "Dietary";
        columnStrings[20] = "DietHRF";
        columnStrings[21] = "Travel";
        columnStrings[22] = "TravelHRF";
        columnStrings[23] = "BloodType";
        columnStrings[24] = "Rh";
        columnStrings[25] = "MedicalHistoryNotes";
        columnStrings[26] = "HxObtainedBy";
        columnStrings[27] = "HxConfirmedByHCP";
        columnStrings[28] = "UnableToObtainHxReason";
        columnStrings[29] = "deleted";
        columnStrings[30] = "LMPDate";
        columnStrings[31] = "LMPStatus";
        columnStrings[32] = "LMP";
        columnStrings[33] = "Pregnant";
        columnStrings[34] = "PregnancyDueDate";
        columnStrings[35] = "EDC";
        columnStrings[36] = "NumberOfChildren";
        columnStrings[37] = "NumberOfPregnancies";
        columnStrings[38] = "LMPEstMethod";
        columnStrings[39] = "LMPDateApprox";
        columnStrings[40] = "MenstrualAmtNormalYes";
        columnStrings[41] = "MenstrualAmtNormalNo";
        columnStrings[42] = "MensesMonthlyYes";
        columnStrings[43] = "MensesMonthlyNo";
        columnStrings[44] = "MensesPriorDate";
        columnStrings[45] = "MensesFreq";
        columnStrings[46] = "MenarcheAgeOfOnset";
        columnStrings[47] = "OnBCPAtConceptionYes";
        columnStrings[48] = "OnBCPAtConceptionNo";
        columnStrings[49] = "HospitalOfDelivery";
        columnStrings[50] = "EGA";
    }

    @Override
    public void populateData() throws Exception {
        readData.createConnection();
        currentResultSet = readData.selectAll();
    }
    public void populateData(Interface.PatientMeta.GeneralInformation patientInfo) throws Exception {
        readData.createConnection();
        currentResultSet = readData.selectWhere(columnStrings[1], Integer.toString(patientInfo.getPatientID()));
    }

    @Override
    public boolean addData() throws Exception {
        try {
            fillvalueStrings();
            addData = new Add(valueStrings, columnStrings);
            return addData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean addData(General general) throws Exception {
        try {
            changeGeneral(general);
            return addData();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean updateData() throws Exception {
        try {
            fillvalueStrings();
            updateData = new Update(valueStrings, columnStrings);
            return updateData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean updateData(General general) throws Exception {
        try {
            changeGeneral(general);
            return updateData();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void populateFromResultSet() throws Exception {
        currentResultSet.moveToCurrentRow();
        this.generalmedicalhistoryid = currentResultSet.getInt("GeneralMedicalHistoryID");
        this.patientid = currentResultSet.getInt("PatientID");
        this.maritalstatus = currentResultSet.getString("MaritalStatus");
        this.education = currentResultSet.getString("Education");
        this.growthanddevelopment = currentResultSet.getString("GrowthAndDevelopment");
        this.pregnancies = currentResultSet.getString("Pregnancies");
        this.behavioralhistory = currentResultSet.getString("BehavioralHistory");
        this.tobacco = currentResultSet.getString("Tobacco");
        this.tobaccohrf = currentResultSet.getByte("TobaccoHRF");
        this.tobaccoquantity = currentResultSet.getString("TobaccoQuantity");
        this.tobaccoduraton = currentResultSet.getString("Tobaccoduraton");
        this.alcohol = currentResultSet.getString("Alcohol");
        this.alcoholhrf = currentResultSet.getByte("AlcoholHRF");
        this.alcoholquantity = currentResultSet.getString("AlcoholQuantity");
        this.alcoholduration = currentResultSet.getString("Alcoholduration");
        this.drug = currentResultSet.getString("Drug");
        this.drughrf = currentResultSet.getByte("DrugHRF");
        this.drugtype = currentResultSet.getString("DrugType");
        this.drugduration = currentResultSet.getString("Drugduration");
        this.dietary = currentResultSet.getString("Dietary");
        this.diethrf = currentResultSet.getByte("DietHRF");
        this.travel = currentResultSet.getString("Travel");
        this.travelhrf = currentResultSet.getByte("TravelHRF");
        this.bloodtype = currentResultSet.getString("BloodType");
        this.rh = currentResultSet.getString("Rh");
        this.medicalhistorynotes = currentResultSet.getString("MedicalHistoryNotes");
        this.hxobtainedby = currentResultSet.getString("HxObtainedBy");
        this.hxconfirmedbyhcp = currentResultSet.getByte("HxConfirmedByHCP");
        this.unabletoobtainhxreason = currentResultSet.getString("UnableToObtainHxReason");
        this.deleted = currentResultSet.getByte("deleted");
        this.lmpdate = currentResultSet.getDate("LMPDate");
        this.lmpstatus = currentResultSet.getString("LMPStatus");
        this.lmp = currentResultSet.getByte("LMP");
        this.pregnant = currentResultSet.getByte("Pregnant");
        this.pregnancyduedate = currentResultSet.getDate("PregnancyDueDate");
        this.edc = currentResultSet.getDate("EDC");
        this.numberofchildren = currentResultSet.getInt("NumberOfChildren");
        this.numberofpregnancies = currentResultSet.getInt("NumberOfPregnancies");
        this.lmpestmethod = currentResultSet.getString("LMPEstMethod");
        this.lmpdateapprox = currentResultSet.getByte("LMPDateApprox");
        this.menstrualamtnormalyes = currentResultSet.getByte("MenstrualAmtNormalYes");
        this.menstrualamtnormalno = currentResultSet.getByte("MenstrualAmtNormalNo");
        this.mensesmonthlyyes = currentResultSet.getByte("MensesMonthlyYes");
        this.mensesmonthlyno = currentResultSet.getByte("MensesMonthlyNo");
        this.mensespriordate = currentResultSet.getDate("MensesPriorDate");
        this.mensesfreq = currentResultSet.getInt("MensesFreq");
        this.menarcheageofonset = currentResultSet.getInt("MenarcheAgeOfOnset");
        this.onbcpatconceptionyes = currentResultSet.getByte("OnBCPAtConceptionYes");
        this.onbcpatconceptionno = currentResultSet.getByte("OnBCPAtConceptionNo");
        this.hospitalofdelivery = currentResultSet.getString("HospitalOfDelivery");
        this.ega = currentResultSet.getDouble("EGA");
    }

    @Override
    public void populateFromResultSet(int position) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void populateFromResultSet(ResultSet resultSet) throws Exception {
        resultSet.moveToCurrentRow();
        this.generalmedicalhistoryid = resultSet.getInt("GeneralMedicalHistoryID");
        this.patientid = resultSet.getInt("PatientID");
        this.maritalstatus = resultSet.getString("MaritalStatus");
        this.education = resultSet.getString("Education");
        this.growthanddevelopment = resultSet.getString("GrowthAndDevelopment");
        this.pregnancies = resultSet.getString("Pregnancies");
        this.behavioralhistory = resultSet.getString("BehavioralHistory");
        this.tobacco = resultSet.getString("Tobacco");
        this.tobaccohrf = resultSet.getByte("TobaccoHRF");
        this.tobaccoquantity = resultSet.getString("TobaccoQuantity");
        this.tobaccoduraton = resultSet.getString("Tobaccoduraton");
        this.alcohol = resultSet.getString("Alcohol");
        this.alcoholhrf = resultSet.getByte("AlcoholHRF");
        this.alcoholquantity = resultSet.getString("AlcoholQuantity");
        this.alcoholduration = resultSet.getString("Alcoholduration");
        this.drug = resultSet.getString("Drug");
        this.drughrf = resultSet.getByte("DrugHRF");
        this.drugtype = resultSet.getString("DrugType");
        this.drugduration = resultSet.getString("Drugduration");
        this.dietary = resultSet.getString("Dietary");
        this.diethrf = resultSet.getByte("DietHRF");
        this.travel = resultSet.getString("Travel");
        this.travelhrf = resultSet.getByte("TravelHRF");
        this.bloodtype = resultSet.getString("BloodType");
        this.rh = resultSet.getString("Rh");
        this.medicalhistorynotes = resultSet.getString("MedicalHistoryNotes");
        this.hxobtainedby = resultSet.getString("HxObtainedBy");
        this.hxconfirmedbyhcp = resultSet.getByte("HxConfirmedByHCP");
        this.unabletoobtainhxreason = resultSet.getString("UnableToObtainHxReason");
        this.deleted = resultSet.getByte("deleted");
        this.lmpdate = resultSet.getDate("LMPDate");
        this.lmpstatus = resultSet.getString("LMPStatus");
        this.lmp = resultSet.getByte("LMP");
        this.pregnant = resultSet.getByte("Pregnant");
        this.pregnancyduedate = resultSet.getDate("PregnancyDueDate");
        this.edc = resultSet.getDate("EDC");
        this.numberofchildren = resultSet.getInt("NumberOfChildren");
        this.numberofpregnancies = resultSet.getInt("NumberOfPregnancies");
        this.lmpestmethod = resultSet.getString("LMPEstMethod");
        this.lmpdateapprox = resultSet.getByte("LMPDateApprox");
        this.menstrualamtnormalyes = resultSet.getByte("MenstrualAmtNormalYes");
        this.menstrualamtnormalno = resultSet.getByte("MenstrualAmtNormalNo");
        this.mensesmonthlyyes = resultSet.getByte("MensesMonthlyYes");
        this.mensesmonthlyno = resultSet.getByte("MensesMonthlyNo");
        this.mensespriordate = resultSet.getDate("MensesPriorDate");
        this.mensesfreq = resultSet.getInt("MensesFreq");
        this.menarcheageofonset = resultSet.getInt("MenarcheAgeOfOnset");
        this.onbcpatconceptionyes = resultSet.getByte("OnBCPAtConceptionYes");
        this.onbcpatconceptionno = resultSet.getByte("OnBCPAtConceptionNo");
        this.hospitalofdelivery = resultSet.getString("HospitalOfDelivery");
        this.ega = resultSet.getDouble("EGA");
    }
    
    public Interface.History.General createGeneralHistory() throws Exception{
        try {
            currentResultSet.absolute(1);
            Interface.History.General newGeneral = new Interface.History.General();
            newGeneral.populateFromResultSet(currentResultSet);
            return newGeneral;
        } catch (Exception e) {
            throw e;
        }
    }
    public int getNextID() throws Exception{
        try {
            return readData.getNextID(columnStrings[0]);
        } catch (Exception e) {
            throw e;
        }
    }

    public void changeGeneral(General newGeneral) {
        this.generalmedicalhistoryid = newGeneral.getGeneralmedicalhistoryid();
        this.patientid = newGeneral.getPatientid();
        this.maritalstatus = newGeneral.getMaritalstatus();
        this.education = newGeneral.getEducation();
        this.growthanddevelopment = newGeneral.getGrowthanddevelopment();
        this.pregnancies = newGeneral.getPregnancies();
        this.behavioralhistory = newGeneral.getBehavioralhistory();
        this.tobacco = newGeneral.getTobacco();
        this.tobaccohrf = newGeneral.getTobaccohrf();
        this.tobaccoquantity = newGeneral.getTobaccoquantity();
        this.tobaccoduraton = newGeneral.getTobaccoduraton();
        this.alcohol = newGeneral.getAlcohol();
        this.alcoholhrf = newGeneral.getAlcoholhrf();
        this.alcoholquantity = newGeneral.getAlcoholquantity();
        this.alcoholduration = newGeneral.getAlcoholduration();
        this.drug = newGeneral.getDrug();
        this.drughrf = newGeneral.getDrughrf();
        this.drugtype = newGeneral.getDrugtype();
        this.drugduration = newGeneral.getDrugduration();
        this.dietary = newGeneral.getDietary();
        this.diethrf = newGeneral.getDiethrf();
        this.travel = newGeneral.getTravel();
        this.travelhrf = newGeneral.getTravelhrf();
        this.bloodtype = newGeneral.getBloodtype();
        this.rh = newGeneral.getRh();
        this.medicalhistorynotes = newGeneral.getMedicalhistorynotes();
        this.hxobtainedby = newGeneral.getHxobtainedby();
        this.hxconfirmedbyhcp = newGeneral.getHxconfirmedbyhcp();
        this.unabletoobtainhxreason = newGeneral.getUnabletoobtainhxreason();
        this.deleted = newGeneral.getDeleted();
        this.lmpdate = newGeneral.getLmpdate();
        this.lmpstatus = newGeneral.getLmpstatus();
        this.lmp = newGeneral.getLmp();
        this.pregnant = newGeneral.getPregnant();
        this.pregnancyduedate = newGeneral.getPregnancyduedate();
        this.edc = newGeneral.getEdc();
        this.numberofchildren = newGeneral.getNumberofchildren();
        this.numberofpregnancies = newGeneral.getNumberofpregnancies();
        this.lmpestmethod = newGeneral.getLmpestmethod();
        this.lmpdateapprox = newGeneral.getLmpdateapprox();
        this.menstrualamtnormalyes = newGeneral.getMenstrualamtnormalyes();
        this.menstrualamtnormalno = newGeneral.getMenstrualamtnormalno();
        this.mensesmonthlyyes = newGeneral.getMensesmonthlyyes();
        this.mensesmonthlyno = newGeneral.getMensesmonthlyno();
        this.mensespriordate = newGeneral.getMensespriordate();
        this.mensesfreq = newGeneral.getMensesfreq();
        this.menarcheageofonset = newGeneral.getMenarcheageofonset();
        this.onbcpatconceptionyes = newGeneral.getOnbcpatconceptionyes();
        this.onbcpatconceptionno = newGeneral.getOnbcpatconceptionno();
        this.hospitalofdelivery = newGeneral.getHospitalofdelivery();
        this.ega = newGeneral.getEga();
    }

    //getters
    public int getGeneralmedicalhistoryid() {
        return generalmedicalhistoryid;
    }

    public int getPatientid() {
        return patientid;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public String getEducation() {
        return education;
    }

    public String getGrowthanddevelopment() {
        return growthanddevelopment;
    }

    public String getPregnancies() {
        return pregnancies;
    }

    public String getBehavioralhistory() {
        return behavioralhistory;
    }

    public String getTobacco() {
        return tobacco;
    }

    public byte getTobaccohrf() {
        return tobaccohrf;
    }

    public String getTobaccoquantity() {
        return tobaccoquantity;
    }

    public String getTobaccoduraton() {
        return tobaccoduraton;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public byte getAlcoholhrf() {
        return alcoholhrf;
    }

    public String getAlcoholquantity() {
        return alcoholquantity;
    }

    public String getAlcoholduration() {
        return alcoholduration;
    }

    public String getDrug() {
        return drug;
    }

    public byte getDrughrf() {
        return drughrf;
    }

    public String getDrugtype() {
        return drugtype;
    }

    public String getDrugduration() {
        return drugduration;
    }

    public String getDietary() {
        return dietary;
    }

    public byte getDiethrf() {
        return diethrf;
    }

    public String getTravel() {
        return travel;
    }

    public byte getTravelhrf() {
        return travelhrf;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public String getRh() {
        return rh;
    }

    public String getMedicalhistorynotes() {
        return medicalhistorynotes;
    }

    public String getHxobtainedby() {
        return hxobtainedby;
    }

    public byte getHxconfirmedbyhcp() {
        return hxconfirmedbyhcp;
    }

    public String getUnabletoobtainhxreason() {
        return unabletoobtainhxreason;
    }

    public byte getDeleted() {
        return deleted;
    }

    public Date getLmpdate() {
        return lmpdate;
    }

    public String getLmpstatus() {
        return lmpstatus;
    }

    public byte getLmp() {
        return lmp;
    }

    public byte getPregnant() {
        return pregnant;
    }

    public Date getPregnancyduedate() {
        return pregnancyduedate;
    }

    public Date getEdc() {
        return edc;
    }

    public int getNumberofchildren() {
        return numberofchildren;
    }

    public int getNumberofpregnancies() {
        return numberofpregnancies;
    }

    public String getLmpestmethod() {
        return lmpestmethod;
    }

    public byte getLmpdateapprox() {
        return lmpdateapprox;
    }

    public byte getMenstrualamtnormalyes() {
        return menstrualamtnormalyes;
    }

    public byte getMenstrualamtnormalno() {
        return menstrualamtnormalno;
    }

    public byte getMensesmonthlyyes() {
        return mensesmonthlyyes;
    }

    public byte getMensesmonthlyno() {
        return mensesmonthlyno;
    }

    public Date getMensespriordate() {
        return mensespriordate;
    }

    public int getMensesfreq() {
        return mensesfreq;
    }

    public int getMenarcheageofonset() {
        return menarcheageofonset;
    }

    public byte getOnbcpatconceptionyes() {
        return onbcpatconceptionyes;
    }

    public byte getOnbcpatconceptionno() {
        return onbcpatconceptionno;
    }

    public String getHospitalofdelivery() {
        return hospitalofdelivery;
    }

    public double getEga() {
        return ega;
    }
    
    //Setters

    public void setGeneralmedicalhistoryid(int generalmedicalhistoryid) {
        this.generalmedicalhistoryid = generalmedicalhistoryid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setGrowthanddevelopment(String growthanddevelopment) {
        this.growthanddevelopment = growthanddevelopment;
    }

    public void setPregnancies(String pregnancies) {
        this.pregnancies = pregnancies;
    }

    public void setBehavioralhistory(String behavioralhistory) {
        this.behavioralhistory = behavioralhistory;
    }

    public void setTobacco(String tobacco) {
        this.tobacco = tobacco;
    }

    public void setTobaccohrf(byte tobaccohrf) {
        this.tobaccohrf = tobaccohrf;
    }

    public void setTobaccoquantity(String tobaccoquantity) {
        this.tobaccoquantity = tobaccoquantity;
    }

    public void setTobaccoduraton(String tobaccoduraton) {
        this.tobaccoduraton = tobaccoduraton;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public void setAlcoholhrf(byte alcoholhrf) {
        this.alcoholhrf = alcoholhrf;
    }

    public void setAlcoholquantity(String alcoholquantity) {
        this.alcoholquantity = alcoholquantity;
    }

    public void setAlcoholduration(String alcoholduration) {
        this.alcoholduration = alcoholduration;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public void setDrughrf(byte drughrf) {
        this.drughrf = drughrf;
    }

    public void setDrugtype(String drugtype) {
        this.drugtype = drugtype;
    }

    public void setDrugduration(String drugduration) {
        this.drugduration = drugduration;
    }

    public void setDietary(String dietary) {
        this.dietary = dietary;
    }

    public void setDiethrf(byte diethrf) {
        this.diethrf = diethrf;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public void setTravelhrf(byte travelhrf) {
        this.travelhrf = travelhrf;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public void setMedicalhistorynotes(String medicalhistorynotes) {
        this.medicalhistorynotes = medicalhistorynotes;
    }

    public void setHxobtainedby(String hxobtainedby) {
        this.hxobtainedby = hxobtainedby;
    }

    public void setHxconfirmedbyhcp(byte hxconfirmedbyhcp) {
        this.hxconfirmedbyhcp = hxconfirmedbyhcp;
    }

    public void setUnabletoobtainhxreason(String unabletoobtainhxreason) {
        this.unabletoobtainhxreason = unabletoobtainhxreason;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public void setLmpdate(Date lmpdate) {
        this.lmpdate = lmpdate;
    }

    public void setLmpstatus(String lmpstatus) {
        this.lmpstatus = lmpstatus;
    }

    public void setLmp(byte lmp) {
        this.lmp = lmp;
    }

    public void setPregnant(byte pregnant) {
        this.pregnant = pregnant;
    }

    public void setPregnancyduedate(Date pregnancyduedate) {
        this.pregnancyduedate = pregnancyduedate;
    }

    public void setEdc(Date edc) {
        this.edc = edc;
    }

    public void setNumberofchildren(int numberofchildren) {
        this.numberofchildren = numberofchildren;
    }

    public void setNumberofpregnancies(int numberofpregnancies) {
        this.numberofpregnancies = numberofpregnancies;
    }

    public void setLmpestmethod(String lmpestmethod) {
        this.lmpestmethod = lmpestmethod;
    }

    public void setLmpdateapprox(byte lmpdateapprox) {
        this.lmpdateapprox = lmpdateapprox;
    }

    public void setMenstrualamtnormalyes(byte menstrualamtnormalyes) {
        this.menstrualamtnormalyes = menstrualamtnormalyes;
    }

    public void setMenstrualamtnormalno(byte menstrualamtnormalno) {
        this.menstrualamtnormalno = menstrualamtnormalno;
    }

    public void setMensesmonthlyyes(byte mensesmonthlyyes) {
        this.mensesmonthlyyes = mensesmonthlyyes;
    }

    public void setMensesmonthlyno(byte mensesmonthlyno) {
        this.mensesmonthlyno = mensesmonthlyno;
    }

    public void setMensespriordate(Date mensespriordate) {
        this.mensespriordate = mensespriordate;
    }

    public void setMensesfreq(int mensesfreq) {
        this.mensesfreq = mensesfreq;
    }

    public void setMenarcheageofonset(int menarcheageofonset) {
        this.menarcheageofonset = menarcheageofonset;
    }

    public void setOnbcpatconceptionyes(byte onbcpatconceptionyes) {
        this.onbcpatconceptionyes = onbcpatconceptionyes;
    }

    public void setOnbcpatconceptionno(byte onbcpatconceptionno) {
        this.onbcpatconceptionno = onbcpatconceptionno;
    }

    public void setHospitalofdelivery(String hospitalofdelivery) {
        this.hospitalofdelivery = hospitalofdelivery;
    }

    public void setEga(double ega) {
        this.ega = ega;
    }
    
    

}
