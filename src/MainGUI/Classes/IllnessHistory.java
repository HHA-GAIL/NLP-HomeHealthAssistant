package MainGUI.Classes;

import java.sql.Date;

public class IllnessHistory {

    private String Illness, Resolution;
    private int IllnessID, PatientID;
    private Byte deleted, IllnessHRF;
    private Date IllnessDate;

    public String getIllness() {
        return Illness;
    }

    public void setIllness(String Illness) {
        this.Illness = Illness;
    }

    public String getResolution() {
        return Resolution;
    }

    public void setResolution(String Resolution) {
        this.Resolution = Resolution;
    }

    public Date getIllnessDate() {
        return IllnessDate;
    }

    public void setIllnessDate(Date IllnessDate) {
        this.IllnessDate = IllnessDate;
    }

    public int getIllnessID() {
        return IllnessID;
    }

    public void setIllnessID(int IllnessID) {
        this.IllnessID = IllnessID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Byte getIllnessHRF() {
        return IllnessHRF;
    }

    public void setIllnessHRF(Byte IllnessHRF) {
        this.IllnessHRF = IllnessHRF;
    }

}
