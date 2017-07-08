package MainGUI.Classes;

import java.sql.Date;

/**
 *
 * @author Fan Hu
 */
public class Therapy {

    private String TherapyDescription, Outcome, CertificationType, Duration, O2FlowRate;
    private Date StartDate, EndDate, OrderDate;
    private int TherapyID, PatientID, EncounterID;
    private Byte deleted;

    public String getTherapyDescription() {
        return TherapyDescription;
    }

    public void setTherapyDescription(String TherapyDescription) {
        this.TherapyDescription = TherapyDescription;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getOutcome() {
        return Outcome;
    }

    public void setOutcome(String Outcome) {
        this.Outcome = Outcome;
    }

    public String getCertificationType() {
        return CertificationType;
    }

    public void setCertificationType(String CertificationType) {
        this.CertificationType = CertificationType;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getO2FlowRate() {
        return O2FlowRate;
    }

    public void setO2FlowRate(String O2FlowRate) {
        this.O2FlowRate = O2FlowRate;
    }

    public int getTherapyID() {
        return TherapyID;
    }

    public void setTherapyID(int TherapyID) {
        this.TherapyID = TherapyID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getEncounterID() {
        return EncounterID;
    }

    public void setEncounterID(int EncounterID) {
        this.EncounterID = EncounterID;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

}
