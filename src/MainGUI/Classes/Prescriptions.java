package MainGUI.Classes;

import java.sql.Date;

public class Prescriptions {

    private String Medication, PrescriptionQuantity, PrescriptionQuantityUnits, RefillPeriod, Instructions, PrescriptionMedsAmt, PrescriptionMedsUnit;
    private int PrescriptionID, CurrentMedicationID, PatientID, Refills, PrescriptionHCP, PharmacyID;
    private byte Generic, deleted;
    private Date PrescriptionDate;

    public String getMedication() {
        return Medication;
    }

    public void setMedication(String Medication) {
        this.Medication = Medication;
    }

    public String getPrescriptionQuantity() {
        return PrescriptionQuantity;
    }

    public void setPrescriptionQuantity(String PrescriptionQuantity) {
        this.PrescriptionQuantity = PrescriptionQuantity;
    }

    public String getPrescriptionQuantityUnits() {
        return PrescriptionQuantityUnits;
    }

    public void setPrescriptionQuantityUnits(String PrescriptionQuantityUnits) {
        this.PrescriptionQuantityUnits = PrescriptionQuantityUnits;
    }

    public String getRefillPeriod() {
        return RefillPeriod;
    }

    public void setRefillPeriod(String RefillPeriod) {
        this.RefillPeriod = RefillPeriod;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String Instructions) {
        this.Instructions = Instructions;
    }

    public String getPrescriptionMedsAmt() {
        return PrescriptionMedsAmt;
    }

    public void setPrescriptionMedsAmt(String PrescriptionMedsAmt) {
        this.PrescriptionMedsAmt = PrescriptionMedsAmt;
    }

    public String getPrescriptionMedsUnit() {
        return PrescriptionMedsUnit;
    }

    public void setPrescriptionMedsUnit(String PrescriptionMedsUnit) {
        this.PrescriptionMedsUnit = PrescriptionMedsUnit;
    }

    public int getPrescriptionID() {
        return PrescriptionID;
    }

    public void setPrescriptionID(int PrescriptionID) {
        this.PrescriptionID = PrescriptionID;
    }

    public int getCurrentMedicationID() {
        return CurrentMedicationID;
    }

    public void setCurrentMedicationID(int CurrentMedicationID) {
        this.CurrentMedicationID = CurrentMedicationID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getRefills() {
        return Refills;
    }

    public void setRefills(int Refills) {
        this.Refills = Refills;
    }

    public int getPrescriptionHCP() {
        return PrescriptionHCP;
    }

    public void setPrescriptionHCP(int PrescriptionHCP) {
        this.PrescriptionHCP = PrescriptionHCP;
    }

    public int getPharmacyID() {
        return PharmacyID;
    }

    public void setPharmacyID(int PharmacyID) {
        this.PharmacyID = PharmacyID;
    }

    public byte getGeneric() {
        return Generic;
    }

    public void setGeneric(byte Generic) {
        this.Generic = Generic;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public Date getPrescriptionDate() {
        return PrescriptionDate;
    }

    public void setPrescriptionDate(Date PrescriptionDate) {
        this.PrescriptionDate = PrescriptionDate;
    }

}
