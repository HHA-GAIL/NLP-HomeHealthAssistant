package MainGUI.Classes;

import java.sql.Date;

public class ImmunizationsHistory {

    private String Vaccine, Delivery, Comments;
    private int ImmunizationsID, PatientID, HCPId;
    private byte deleted;
    private Date ImmunizationDate, ExperationDate;

    public String getVaccine() {
        return Vaccine;
    }

    public void setVaccine(String Vaccine) {
        this.Vaccine = Vaccine;
    }

    public String getDelivery() {
        return Delivery;
    }

    public void setDelivery(String Delivery) {
        this.Delivery = Delivery;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public int getImmunizationsID() {
        return ImmunizationsID;
    }

    public void setImmunizationsID(int ImmunizationsID) {
        this.ImmunizationsID = ImmunizationsID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getHCPId() {
        return HCPId;
    }

    public void setHCPId(int HCPId) {
        this.HCPId = HCPId;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public Date getImmunizationDate() {
        return ImmunizationDate;
    }

    public void setImmunizationDate(Date ImmunizationDate) {
        this.ImmunizationDate = ImmunizationDate;
    }

    public Date getExperationDate() {
        return ExperationDate;
    }

    public void setExperationDate(Date ExperationDate) {
        this.ExperationDate = ExperationDate;
    }

}
