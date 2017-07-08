package MainGUI.Classes;

/**
 *
 * @author Fan Hu
 */
public class VitalSign {

    private int EncounterID,PatientID,HR,RR,BPSYS1,
            BPDIAS1,BPSYS2,BPDIAS2,BPSYS3,BPDIAS3;
    
    private String PETime,Ht_Unit_of_Measurement,Wt_Unit_of_Measurement,
            Head_Unit_of_Measurement,BP1Position,BP1Location,BP2Position,
            BP2Location,BP3Position,BP3Location,Temperature_unit;
    
    private double Ht,Wt,HeadCircumference,BodyMassIndex,Temperature;
    
    private Byte deleted;

    public int getEncounterID() {
        return EncounterID;
    }

    public void setEncounterID(int EncounterID) {
        this.EncounterID = EncounterID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getHR() {
        return HR;
    }

    public void setHR(int HR) {
        this.HR = HR;
    }

    public int getRR() {
        return RR;
    }

    public void setRR(int RR) {
        this.RR = RR;
    }

    public int getBPSYS1() {
        return BPSYS1;
    }

    public void setBPSYS1(int BPSYS1) {
        this.BPSYS1 = BPSYS1;
    }

    public int getBPDIAS1() {
        return BPDIAS1;
    }

    public void setBPDIAS1(int BPDIAS1) {
        this.BPDIAS1 = BPDIAS1;
    }

    public int getBPSYS2() {
        return BPSYS2;
    }

    public void setBPSYS2(int BPSYS2) {
        this.BPSYS2 = BPSYS2;
    }

    public int getBPDIAS2() {
        return BPDIAS2;
    }

    public void setBPDIAS2(int BPDIAS2) {
        this.BPDIAS2 = BPDIAS2;
    }

    public int getBPSYS3() {
        return BPSYS3;
    }

    public void setBPSYS3(int BPSYS3) {
        this.BPSYS3 = BPSYS3;
    }

    public int getBPDIAS3() {
        return BPDIAS3;
    }

    public void setBPDIAS3(int BPDIAS3) {
        this.BPDIAS3 = BPDIAS3;
    }

    public String getPETime() {
        return PETime;
    }

    public void setPETime(String PETime) {
        this.PETime = PETime;
    }

    public String getHt_Unit_of_Measurement() {
        return Ht_Unit_of_Measurement;
    }

    public void setHt_Unit_of_Measurement(String Ht_Unit_of_Measurement) {
        this.Ht_Unit_of_Measurement = Ht_Unit_of_Measurement;
    }

    public String getWt_Unit_of_Measurement() {
        return Wt_Unit_of_Measurement;
    }

    public void setWt_Unit_of_Measurement(String Wt_Unit_of_Measurement) {
        this.Wt_Unit_of_Measurement = Wt_Unit_of_Measurement;
    }

    public String getHead_Unit_of_Measurement() {
        return Head_Unit_of_Measurement;
    }

    public void setHead_Unit_of_Measurement(String Head_Unit_of_Measurement) {
        this.Head_Unit_of_Measurement = Head_Unit_of_Measurement;
    }

    public String getBP1Position() {
        return BP1Position;
    }

    public void setBP1Position(String BP1Position) {
        this.BP1Position = BP1Position;
    }

    public String getBP1Location() {
        return BP1Location;
    }

    public void setBP1Location(String BP1Location) {
        this.BP1Location = BP1Location;
    }

    public String getBP2Position() {
        return BP2Position;
    }

    public void setBP2Position(String BP2Position) {
        this.BP2Position = BP2Position;
    }

    public String getBP2Location() {
        return BP2Location;
    }

    public void setBP2Location(String BP2Location) {
        this.BP2Location = BP2Location;
    }

    public String getBP3Position() {
        return BP3Position;
    }

    public void setBP3Position(String BP3Position) {
        this.BP3Position = BP3Position;
    }

    public String getBP3Location() {
        return BP3Location;
    }

    public void setBP3Location(String BP3Location) {
        this.BP3Location = BP3Location;
    }

    public String getTemperature_unit() {
        return Temperature_unit;
    }

    public void setTemperature_unit(String Temperature_unit) {
        this.Temperature_unit = Temperature_unit;
    }

    public double getHt() {
        return Ht;
    }

    public void setHt(double Ht) {
        this.Ht = Ht;
    }

    public double getWt() {
        return Wt;
    }

    public void setWt(double Wt) {
        this.Wt = Wt;
    }

    public double getHeadCircumference() {
        return HeadCircumference;
    }

    public void setHeadCircumference(double HeadCircumference) {
        this.HeadCircumference = HeadCircumference;
    }

    public double getBodyMassIndex() {
        return BodyMassIndex;
    }

    public void setBodyMassIndex(double BodyMassIndex) {
        this.BodyMassIndex = BodyMassIndex;
    }

    public double getTemperature() {
        return Temperature;
    }

    public void setTemperature(double Temperature) {
        this.Temperature = Temperature;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
    
}
