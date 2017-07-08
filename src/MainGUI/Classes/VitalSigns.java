package MainGUI.Classes;


public class VitalSigns 
{
    private String Presentation, PretermLaborSigns, Comments;
    private int VitalSignID, PatientID, CompleteGeneralSpecialistClinicID, FetalMovement;
    private double WeeksGestation, FundalHeight, FHR, CervixDilationLength;
    private byte deleted;

    public String getPresentation() {
        return Presentation;
    }

    public void setPresentation(String Presentation) {
        this.Presentation = Presentation;
    }

    public String getPretermLaborSigns() {
        return PretermLaborSigns;
    }

    public void setPretermLaborSigns(String PretermLaborSigns) {
        this.PretermLaborSigns = PretermLaborSigns;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public int getVitalSignID() {
        return VitalSignID;
    }

    public void setVitalSignID(int VitalSignID) {
        this.VitalSignID = VitalSignID;
    }

    public int getCompleteGeneralSpecialistClinicID() {
        return CompleteGeneralSpecialistClinicID;
    }

    public void setCompleteGeneralSpecialistClinicID(int CompleteGeneralSpecialistClinicID) {
        this.CompleteGeneralSpecialistClinicID = CompleteGeneralSpecialistClinicID;
    }

    public int getFetalMovement() {
        return FetalMovement;
    }

    public void setFetalMovement(int FetalMovement) {
        this.FetalMovement = FetalMovement;
    }

    public double getWeeksGestation() {
        return WeeksGestation;
    }

    public void setWeeksGestation(double WeeksGestation) {
        this.WeeksGestation = WeeksGestation;
    }

    public double getFundalHeight() {
        return FundalHeight;
    }

    public void setFundalHeight(double FundalHeight) {
        this.FundalHeight = FundalHeight;
    }

    public double getFHR() {
        return FHR;
    }

    public void setFHR(double FHR) {
        this.FHR = FHR;
    }

    public double getCervixDilationLength() {
        return CervixDilationLength;
    }

    public void setCervixDilationLength(double CervixDilationLength) {
        this.CervixDilationLength = CervixDilationLength;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }
    
}
