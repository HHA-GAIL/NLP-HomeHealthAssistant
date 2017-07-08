package MainGUI.Classes;

public class AllergyHistory {

    private String Allergen, AllergyStartDate, AllergyEndDate, AllergyDescription;
    private int AllergyID, PatientID;
    private byte AllergyHRF, deleted;

    public String getAllergen() {
        return Allergen;
    }

    public void setAllergen(String Allergen) {
        this.Allergen = Allergen;
    }

    public String getAllergyStartDate() {
        return AllergyStartDate;
    }

    public void setAllergyStartDate(String AllergyStartDate) {
        this.AllergyStartDate = AllergyStartDate;
    }

    public String getAllergyEndDate() {
        return AllergyEndDate;
    }

    public void setAllergyEndDate(String AllergyEndDate) {
        this.AllergyEndDate = AllergyEndDate;
    }

    public String getAllergyDescription() {
        return AllergyDescription;
    }

    public void setAllergyDescription(String AllergyDescription) {
        this.AllergyDescription = AllergyDescription;
    }

    public int getAllergyID() {
        return AllergyID;
    }

    public void setAllergyID(int AllergyID) {
        this.AllergyID = AllergyID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public byte getAllergyHRF() {
        return AllergyHRF;
    }

    public void setAllergyHRF(byte AllergyHRF) {
        this.AllergyHRF = AllergyHRF;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

}
