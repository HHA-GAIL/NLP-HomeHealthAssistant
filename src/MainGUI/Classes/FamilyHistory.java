package MainGUI.Classes;

public class FamilyHistory {

    private String Name, Relation, MajorDisorder, SpecificTypeDisorder;
    private int FamilyID, PatientID;
    private byte Alive, LivesWithPatient, DisorderHRF, deleted;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String Relation) {
        this.Relation = Relation;
    }

    public String getMajorDisorder() {
        return MajorDisorder;
    }

    public void setMajorDisorder(String MajorDisorder) {
        this.MajorDisorder = MajorDisorder;
    }

    public String getSpecificTypeDisorder() {
        return SpecificTypeDisorder;
    }

    public void setSpecificTypeDisorder(String SpecificTypeDisorder) {
        this.SpecificTypeDisorder = SpecificTypeDisorder;
    }

    public int getFamilyID() {
        return FamilyID;
    }

    public void setFamilyID(int FamilyID) {
        this.FamilyID = FamilyID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public byte getAlive() {
        return Alive;
    }

    public void setAlive(byte Alive) {
        this.Alive = Alive;
    }

    public byte getLivesWithPatient() {
        return LivesWithPatient;
    }

    public void setLivesWithPatient(byte LivesWithPatient) {
        this.LivesWithPatient = LivesWithPatient;
    }

    public byte getDisorderHRF() {
        return DisorderHRF;
    }

    public void setDisorderHRF(byte DisorderHRF) {
        this.DisorderHRF = DisorderHRF;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

}
