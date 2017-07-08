package MainGUI.Classes;
import java.sql.Date;

public class OccupationalHistory 
{
    private String Description, Causeofdisability;
    private int OccupationalID, PatientID;
    private byte Current, Disability, OccupationalHRF, deleted;
    private Date StartDate, EndDate, LastWorkDate;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCauseofdisability() {
        return Causeofdisability;
    }

    public void setCauseofdisability(String Causeofdisability) {
        this.Causeofdisability = Causeofdisability;
    }

    public int getOccupationalID() {
        return OccupationalID;
    }

    public void setOccupationalID(int OccupationalID) {
        this.OccupationalID = OccupationalID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public byte getCurrent() {
        return Current;
    }

    public void setCurrent(byte Current) {
        this.Current = Current;
    }

    public byte getDisability() {
        return Disability;
    }

    public void setDisability(byte Disability) {
        this.Disability = Disability;
    }

    public byte getOccupationalHRF() {
        return OccupationalHRF;
    }

    public void setOccupationalHRF(byte OccupationalHRF) {
        this.OccupationalHRF = OccupationalHRF;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
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

    public Date getLastWorkDate() {
        return LastWorkDate;
    }

    public void setLastWorkDate(Date LastWorkDate) {
        this.LastWorkDate = LastWorkDate;
    }

    
}
