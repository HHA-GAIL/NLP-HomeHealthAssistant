package MainGUI.Classes;

import java.sql.Date;

public class Patient {

    private String OldID, PtLastName, PtPreviousLastName, PtFirstName, HomeAddress1, HomeAddress2, HomeCity, HomeStateProvinceRegion, HomeZip, Country, Citizenship,
            PtHomePhone, EmergencyPhoneNumber, PtHomeFax, Pager, EmailAddress, PtSS, Gender, EthnicAssociation, Religion, MaritalStatus, EmploymentStatus, HospitalMR,
            Comments, BusinessPhone, BusinessFax, updates, GroupName, SubscriberRelationship, UPID, PtMiddleInitial, NextOfKinRelationshipToPatient, Suffix;
    private int PatientID, Referral, CurrentPrimaryHCPId, Specialist1, Specialist2, Specialist3, Specialist4, OriginalStaffHCP, CurrentStaffHCP, BillingAcctNumber, EmployerID, NextOfKinID;
    private byte Active, deleted, NoticeOfPracticePrivacy;

    /**
     * change the datatype of these properties from Timestamp to Date
     *
     * @author Zhiwei Chu
     */
    private Date DOB, DateofExpire, DateEntered, NPPDate;

    public String getOldID() {
        return OldID;
    }

    public void setOldID(String OldID) {
        this.OldID = OldID;
    }

    public String getPtLastName() {
        return PtLastName;
    }

    public void setPtLastName(String PtLastName) {
        this.PtLastName = PtLastName;
    }

    public String getPtPreviousLastName() {
        return PtPreviousLastName;
    }

    public void setPtPreviousLastName(String PtPreviousLastName) {
        this.PtPreviousLastName = PtPreviousLastName;
    }

    public String getPtFirstName() {
        return PtFirstName;
    }

    public void setPtFirstName(String PtFirstName) {
        this.PtFirstName = PtFirstName;
    }

    public String getHomeAddress1() {
        return HomeAddress1;
    }

    public void setHomeAddress1(String HomeAddress1) {
        this.HomeAddress1 = HomeAddress1;
    }

    public String getHomeAddress2() {
        return HomeAddress2;
    }

    public void setHomeAddress2(String HomeAddress2) {
        this.HomeAddress2 = HomeAddress2;
    }

    public String getHomeCity() {
        return HomeCity;
    }

    public void setHomeCity(String HomeCity) {
        this.HomeCity = HomeCity;
    }

    public String getHomeStateProvinceRegion() {
        return HomeStateProvinceRegion;
    }

    public void setHomeStateProvinceRegion(String HomeStateProvinceRegion) {
        this.HomeStateProvinceRegion = HomeStateProvinceRegion;
    }

    public String getHomeZip() {
        return HomeZip;
    }

    public void setHomeZip(String HomeZip) {
        this.HomeZip = HomeZip;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCitizenship() {
        return Citizenship;
    }

    public void setCitizenship(String Citizenship) {
        this.Citizenship = Citizenship;
    }

    public String getPtHomePhone() {
        return PtHomePhone;
    }

    public void setPtHomePhone(String PtHomePhone) {
        this.PtHomePhone = PtHomePhone;
    }

    public String getEmergencyPhoneNumber() {
        return EmergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String EmergencyPhoneNumber) {
        this.EmergencyPhoneNumber = EmergencyPhoneNumber;
    }

    public String getPtHomeFax() {
        return PtHomeFax;
    }

    public void setPtHomeFax(String PtHomeFax) {
        this.PtHomeFax = PtHomeFax;
    }

    public String getPager() {
        return Pager;
    }

    public void setPager(String Pager) {
        this.Pager = Pager;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getPtSS() {
        return PtSS;
    }

    public void setPtSS(String PtSS) {
        this.PtSS = PtSS;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEthnicAssociation() {
        return EthnicAssociation;
    }

    public void setEthnicAssociation(String EthnicAssociation) {
        this.EthnicAssociation = EthnicAssociation;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String Religion) {
        this.Religion = Religion;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public String getEmploymentStatus() {
        return EmploymentStatus;
    }

    public void setEmploymentStatus(String EmploymentStatus) {
        this.EmploymentStatus = EmploymentStatus;
    }

    public String getHospitalMR() {
        return HospitalMR;
    }

    public void setHospitalMR(String HospitalMR) {
        this.HospitalMR = HospitalMR;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public String getBusinessPhone() {
        return BusinessPhone;
    }

    public void setBusinessPhone(String BusinessPhone) {
        this.BusinessPhone = BusinessPhone;
    }

    public String getBusinessFax() {
        return BusinessFax;
    }

    public void setBusinessFax(String BusinessFax) {
        this.BusinessFax = BusinessFax;
    }

    public String getUpdates() {
        return updates;
    }

    public void setUpdates(String updates) {
        this.updates = updates;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public String getSubscriberRelationship() {
        return SubscriberRelationship;
    }

    public void setSubscriberRelationship(String SubscriberRelationship) {
        this.SubscriberRelationship = SubscriberRelationship;
    }

    public String getUPID() {
        return UPID;
    }

    public void setUPID(String UPID) {
        this.UPID = UPID;
    }

    public String getPtMiddleInitial() {
        return PtMiddleInitial;
    }

    public void setPtMiddleInitial(String PtMiddleInitial) {
        this.PtMiddleInitial = PtMiddleInitial;
    }

    public String getNextOfKinRelationshipToPatient() {
        return NextOfKinRelationshipToPatient;
    }

    public void setNextOfKinRelationshipToPatient(String NextOfKinRelationshipToPatient) {
        this.NextOfKinRelationshipToPatient = NextOfKinRelationshipToPatient;
    }

    public String getSuffix() {
        return Suffix;
    }

    public void setSuffix(String Suffix) {
        this.Suffix = Suffix;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getReferral() {
        return Referral;
    }

    public void setReferral(int Referral) {
        this.Referral = Referral;
    }

    public int getCurrentPrimaryHCPId() {
        return CurrentPrimaryHCPId;
    }

    public void setCurrentPrimaryHCPId(int CurrentPrimaryHCPId) {
        this.CurrentPrimaryHCPId = CurrentPrimaryHCPId;
    }

    public int getSpecialist1() {
        return Specialist1;
    }

    public void setSpecialist1(int Specialist1) {
        this.Specialist1 = Specialist1;
    }

    public int getSpecialist2() {
        return Specialist2;
    }

    public void setSpecialist2(int Specialist2) {
        this.Specialist2 = Specialist2;
    }

    public int getSpecialist3() {
        return Specialist3;
    }

    public void setSpecialist3(int Specialist3) {
        this.Specialist3 = Specialist3;
    }

    public int getSpecialist4() {
        return Specialist4;
    }

    public void setSpecialist4(int Specialist4) {
        this.Specialist4 = Specialist4;
    }

    public int getOriginalStaffHCP() {
        return OriginalStaffHCP;
    }

    public void setOriginalStaffHCP(int OriginalStaffHCP) {
        this.OriginalStaffHCP = OriginalStaffHCP;
    }

    public int getCurrentStaffHCP() {
        return CurrentStaffHCP;
    }

    public void setCurrentStaffHCP(int CurrentStaffHCP) {
        this.CurrentStaffHCP = CurrentStaffHCP;
    }

    public int getBillingAcctNumber() {
        return BillingAcctNumber;
    }

    public void setBillingAcctNumber(int BillingAcctNumber) {
        this.BillingAcctNumber = BillingAcctNumber;
    }

    public int getEmployerID() {
        return EmployerID;
    }

    public void setEmployerID(int EmployerID) {
        this.EmployerID = EmployerID;
    }

    public int getNextOfKinID() {
        return NextOfKinID;
    }

    public void setNextOfKinID(int NextOfKinID) {
        this.NextOfKinID = NextOfKinID;
    }

    public byte getActive() {
        return Active;
    }

    public void setActive(byte Active) {
        this.Active = Active;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public byte getNoticeOfPracticePrivacy() {
        return NoticeOfPracticePrivacy;
    }

    public void setNoticeOfPracticePrivacy(byte NoticeOfPracticePrivacy) {
        this.NoticeOfPracticePrivacy = NoticeOfPracticePrivacy;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getDateofExpire() {
        return DateofExpire;
    }

    public void setDateofExpire(Date DateofExpire) {
        this.DateofExpire = DateofExpire;
    }

    public Date getDateEntered() {
        return DateEntered;
    }

    public void setDateEntered(Date DateEntered) {
        this.DateEntered = DateEntered;
    }

    public Date getNPPDate() {
        return NPPDate;
    }

    public void setNPPDate(Date NPPDate) {
        this.NPPDate = NPPDate;
    }

}
