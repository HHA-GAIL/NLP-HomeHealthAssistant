package MainGUI.Classes;

import java.sql.Date;

public class PastPregnancies {

    private String LengthOfLabor, Sex, TypeOfDelivery, PlaceOfDelivery, Comments, Corionicity, EGAEstMethod;
    private int PastPregnanciesID, PatientID, NumberOfFetuses;
    private double EGA, BirthWeightLbs, BirthWeightOunces;
    private byte PreTermLabor, deleted, Choncordant, TwinToTwinTransSyndrome, OnBCPAtConceptionYes, OnBCPAtConceptionNo, Current;

    /**
     * change the datatype of these properties from Timestamp to Date
     *
     * @author Fan Hu
     */
    private Date LMP, EDD, DateStamp, EGACalculationDate, PregnancyDate;

    public Date getPregnancyDate() {
        return PregnancyDate;
    }

    public void setPregnancyDate(Date PregnancyDate) {
        this.PregnancyDate = PregnancyDate;
    }

    public String getLengthOfLabor() {
        return LengthOfLabor;
    }

    public void setLengthOfLabor(String LengthOfLabor) {
        this.LengthOfLabor = LengthOfLabor;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getTypeOfDelivery() {
        return TypeOfDelivery;
    }

    public void setTypeOfDelivery(String TypeOfDelivery) {
        this.TypeOfDelivery = TypeOfDelivery;
    }

    public String getPlaceOfDelivery() {
        return PlaceOfDelivery;
    }

    public void setPlaceOfDelivery(String PlaceOfDelivery) {
        this.PlaceOfDelivery = PlaceOfDelivery;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public String getCorionicity() {
        return Corionicity;
    }

    public void setCorionicity(String Corionicity) {
        this.Corionicity = Corionicity;
    }

    public String getEGAEstMethod() {
        return EGAEstMethod;
    }

    public void setEGAEstMethod(String EGAEstMethod) {
        this.EGAEstMethod = EGAEstMethod;
    }

    public int getPastPregnanciesID() {
        return PastPregnanciesID;
    }

    public void setPastPregnanciesID(int PastPregnanciesID) {
        this.PastPregnanciesID = PastPregnanciesID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getNumberOfFetuses() {
        return NumberOfFetuses;
    }

    public void setNumberOfFetuses(int NumberOfFetuses) {
        this.NumberOfFetuses = NumberOfFetuses;
    }

    public double getEGA() {
        return EGA;
    }

    public void setEGA(double EGA) {
        this.EGA = EGA;
    }

    public double getBirthWeightLbs() {
        return BirthWeightLbs;
    }

    public void setBirthWeightLbs(double BirthWeightLbs) {
        this.BirthWeightLbs = BirthWeightLbs;
    }

    public double getBirthWeightOunces() {
        return BirthWeightOunces;
    }

    public void setBirthWeightOunces(double BirthWeightOunces) {
        this.BirthWeightOunces = BirthWeightOunces;
    }

    public byte getPreTermLabor() {
        return PreTermLabor;
    }

    public void setPreTermLabor(byte PreTermLabor) {
        this.PreTermLabor = PreTermLabor;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public byte getChoncordant() {
        return Choncordant;
    }

    public void setChoncordant(byte Choncordant) {
        this.Choncordant = Choncordant;
    }

    public byte getTwinToTwinTransSyndrome() {
        return TwinToTwinTransSyndrome;
    }

    public void setTwinToTwinTransSyndrome(byte TwinToTwinTransSyndrome) {
        this.TwinToTwinTransSyndrome = TwinToTwinTransSyndrome;
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

    public byte getCurrent() {
        return Current;
    }

    public void setCurrent(byte Current) {
        this.Current = Current;
    }

    public Date getLMP() {
        return LMP;
    }

    public void setLMP(Date LMP) {
        this.LMP = LMP;
    }

    public Date getEDD() {
        return EDD;
    }

    public void setEDD(Date EDD) {
        this.EDD = EDD;
    }

    public Date getDateStamp() {
        return DateStamp;
    }

    public void setDateStamp(Date DateStamp) {
        this.DateStamp = DateStamp;
    }

    public Date getEGACalculationDate() {
        return EGACalculationDate;
    }

    public void setEGACalculationDate(Date EGACalculationDate) {
        this.EGACalculationDate = EGACalculationDate;
    }

}
