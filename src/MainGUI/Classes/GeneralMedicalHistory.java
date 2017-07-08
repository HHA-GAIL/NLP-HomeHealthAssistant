package MainGUI.Classes;

import java.sql.Date;

public class GeneralMedicalHistory {

    private String MaritalStatus, Education, GrowthAndDevelopment, Pregnancies, BehavioralHistory, Tobacco, TobaccoQuantity, Tobaccoduraton, Alcohol, AlcoholQuantity,
            Alcoholduration, Drug, DrugType, Drugduration, Dietary, Travel, BloodType, Rh, MedicalHistoryNotes, HxObtainedBy, UnableToObtainHxReason, LMPStatus,
            LMPEstMethod, MensesFreq, HospitalOfDelivery, EGA;
    private int GeneralMedicalHistoryID, PatientID, NumberOfChildren, NumberOfPregnancies, MenarcheAgeOfOnset;
    private byte TobaccoHRF, AlcoholHRF, DrugHRF, DietHRF, TravelHRF, HxConfirmedByHCP, deleted, LMP, Pregnant, LMPDateApprox, MenstrualAmtNormalYes, MenstrualAmtNormalNo,
            MensesMonthlyYes, MensesMonthlyNo, OnBCPAtConceptionYes, OnBCPAtConceptionNo;
    /**
     * change the datatype of these properties from Timestamp to Date
     * 
     * @author Fan Hu
     */
    private Date LMPDate, EDC, PregnancyDueDate, MensesPriorDate;

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }

    public String getGrowthAndDevelopment() {
        return GrowthAndDevelopment;
    }

    public void setGrowthAndDevelopment(String GrowthAndDevelopment) {
        this.GrowthAndDevelopment = GrowthAndDevelopment;
    }

    public String getPregnancies() {
        return Pregnancies;
    }

    public void setPregnancies(String Pregnancies) {
        this.Pregnancies = Pregnancies;
    }

    public String getBehavioralHistory() {
        return BehavioralHistory;
    }

    public void setBehavioralHistory(String BehavioralHistory) {
        this.BehavioralHistory = BehavioralHistory;
    }

    public String getTobacco() {
        return Tobacco;
    }

    public void setTobacco(String Tobacco) {
        this.Tobacco = Tobacco;
    }

    public String getTobaccoQuantity() {
        return TobaccoQuantity;
    }

    public void setTobaccoQuantity(String TobaccoQuantity) {
        this.TobaccoQuantity = TobaccoQuantity;
    }

    public String getTobaccoduraton() {
        return Tobaccoduraton;
    }

    public void setTobaccoduraton(String Tobaccoduraton) {
        this.Tobaccoduraton = Tobaccoduraton;
    }

    public String getAlcohol() {
        return Alcohol;
    }

    public void setAlcohol(String Alcohol) {
        this.Alcohol = Alcohol;
    }

    public String getAlcoholQuantity() {
        return AlcoholQuantity;
    }

    public void setAlcoholQuantity(String AlcoholQuantity) {
        this.AlcoholQuantity = AlcoholQuantity;
    }

    public String getAlcoholduration() {
        return Alcoholduration;
    }

    public void setAlcoholduration(String Alcoholduration) {
        this.Alcoholduration = Alcoholduration;
    }

    public String getDrug() {
        return Drug;
    }

    public void setDrug(String Drug) {
        this.Drug = Drug;
    }

    public String getDrugType() {
        return DrugType;
    }

    public void setDrugType(String DrugType) {
        this.DrugType = DrugType;
    }

    public String getDrugduration() {
        return Drugduration;
    }

    public void setDrugduration(String Drugduration) {
        this.Drugduration = Drugduration;
    }

    public String getDietary() {
        return Dietary;
    }

    public void setDietary(String Dietary) {
        this.Dietary = Dietary;
    }

    public String getTravel() {
        return Travel;
    }

    public void setTravel(String Travel) {
        this.Travel = Travel;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String BloodType) {
        this.BloodType = BloodType;
    }

    public String getRh() {
        return Rh;
    }

    public void setRh(String Rh) {
        this.Rh = Rh;
    }

    public String getMedicalHistoryNotes() {
        return MedicalHistoryNotes;
    }

    public void setMedicalHistoryNotes(String MedicalHistoryNotes) {
        this.MedicalHistoryNotes = MedicalHistoryNotes;
    }

    public String getHxObtainedBy() {
        return HxObtainedBy;
    }

    public void setHxObtainedBy(String HxObtainedBy) {
        this.HxObtainedBy = HxObtainedBy;
    }

    public String getUnableToObtainHxReason() {
        return UnableToObtainHxReason;
    }

    public void setUnableToObtainHxReason(String UnableToObtainHxReason) {
        this.UnableToObtainHxReason = UnableToObtainHxReason;
    }

    public String getLMPStatus() {
        return LMPStatus;
    }

    public void setLMPStatus(String LMPStatus) {
        this.LMPStatus = LMPStatus;
    }

    public Date getEDC() {
        return EDC;
    }

    public void setEDC(Date EDC) {
        this.EDC = EDC;
    }

    public String getLMPEstMethod() {
        return LMPEstMethod;
    }

    public void setLMPEstMethod(String LMPEstMethod) {
        this.LMPEstMethod = LMPEstMethod;
    }

    public String getMensesFreq() {
        return MensesFreq;
    }

    public void setMensesFreq(String MensesFreq) {
        this.MensesFreq = MensesFreq;
    }

    public String getHospitalOfDelivery() {
        return HospitalOfDelivery;
    }

    public void setHospitalOfDelivery(String HospitalOfDelivery) {
        this.HospitalOfDelivery = HospitalOfDelivery;
    }

    public String getEGA() {
        return EGA;
    }

    public void setEGA(String EGA) {
        this.EGA = EGA;
    }

    public int getGeneralMedicalHistoryID() {
        return GeneralMedicalHistoryID;
    }

    public void setGeneralMedicalHistoryID(int GeneralMedicalHistoryID) {
        this.GeneralMedicalHistoryID = GeneralMedicalHistoryID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getNumberOfChildren() {
        return NumberOfChildren;
    }

    public void setNumberOfChildren(int NumberOfChildren) {
        this.NumberOfChildren = NumberOfChildren;
    }

    public int getNumberOfPregnancies() {
        return NumberOfPregnancies;
    }

    public void setNumberOfPregnancies(int NumberOfPregnancies) {
        this.NumberOfPregnancies = NumberOfPregnancies;
    }

    public int getMenarcheAgeOfOnset() {
        return MenarcheAgeOfOnset;
    }

    public void setMenarcheAgeOfOnset(int MenarcheAgeOfOnset) {
        this.MenarcheAgeOfOnset = MenarcheAgeOfOnset;
    }

    public byte getTobaccoHRF() {
        return TobaccoHRF;
    }

    public void setTobaccoHRF(byte TobaccoHRF) {
        this.TobaccoHRF = TobaccoHRF;
    }

    public byte getAlcoholHRF() {
        return AlcoholHRF;
    }

    public void setAlcoholHRF(byte AlcoholHRF) {
        this.AlcoholHRF = AlcoholHRF;
    }

    public byte getDrugHRF() {
        return DrugHRF;
    }

    public void setDrugHRF(byte DrugHRF) {
        this.DrugHRF = DrugHRF;
    }

    public byte getDietHRF() {
        return DietHRF;
    }

    public void setDietHRF(byte DietHRF) {
        this.DietHRF = DietHRF;
    }

    public byte getTravelHRF() {
        return TravelHRF;
    }

    public void setTravelHRF(byte TravelHRF) {
        this.TravelHRF = TravelHRF;
    }

    public byte getHxConfirmedByHCP() {
        return HxConfirmedByHCP;
    }

    public void setHxConfirmedByHCP(byte HxConfirmedByHCP) {
        this.HxConfirmedByHCP = HxConfirmedByHCP;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public byte getLMP() {
        return LMP;
    }

    public void setLMP(byte LMP) {
        this.LMP = LMP;
    }

    public byte getPregnant() {
        return Pregnant;
    }

    public void setPregnant(byte Pregnant) {
        this.Pregnant = Pregnant;
    }

    public byte getLMPDateApprox() {
        return LMPDateApprox;
    }

    public void setLMPDateApprox(byte LMPDateApprox) {
        this.LMPDateApprox = LMPDateApprox;
    }

    public byte getMenstrualAmtNormalYes() {
        return MenstrualAmtNormalYes;
    }

    public void setMenstrualAmtNormalYes(byte MenstrualAmtNormalYes) {
        this.MenstrualAmtNormalYes = MenstrualAmtNormalYes;
    }

    public byte getMenstrualAmtNormalNo() {
        return MenstrualAmtNormalNo;
    }

    public void setMenstrualAmtNormalNo(byte MenstrualAmtNormalNo) {
        this.MenstrualAmtNormalNo = MenstrualAmtNormalNo;
    }

    public byte getMensesMonthlyYes() {
        return MensesMonthlyYes;
    }

    public void setMensesMonthlyYes(byte MensesMonthlyYes) {
        this.MensesMonthlyYes = MensesMonthlyYes;
    }

    public byte getMensesMonthlyNo() {
        return MensesMonthlyNo;
    }

    public void setMensesMonthlyNo(byte MensesMonthlyNo) {
        this.MensesMonthlyNo = MensesMonthlyNo;
    }

    public byte getOnBCPAtConceptionYes() {
        return OnBCPAtConceptionYes;
    }

    public void setOnBCPAtConceptionYes(byte OnBCPAtConceptionYes) {
        this.OnBCPAtConceptionYes = OnBCPAtConceptionYes;
    }

    public byte getOnBCPAtConceptionNo() {
        return OnBCPAtConceptionNo;
    }

    public void setOnBCPAtConceptionNo(byte OnBCPAtConceptionNo) {
        this.OnBCPAtConceptionNo = OnBCPAtConceptionNo;
    }

    public Date getLMPDate() {
        return LMPDate;
    }

    public void setLMPDate(Date LMPDate) {
        this.LMPDate = LMPDate;
    }

    public Date getPregnancyDueDate() {
        return PregnancyDueDate;
    }

    public void setPregnancyDueDate(Date PregnancyDueDate) {
        this.PregnancyDueDate = PregnancyDueDate;
    }

    public Date getMensesPriorDate() {
        return MensesPriorDate;
    }

    public void setMensesPriorDate(Date MensesPriorDate) {
        this.MensesPriorDate = MensesPriorDate;
    }

}
