package MainGUI.Classes;

import java.sql.Date;

public class Person {

    private String OldID, PersonFirstName, PersonLastName, PersonMiddleName, PersonInitials, Title, Address1, Address2, GroupName, City, StateProvinceRegion, ZipCode, Country,
            Citizenship, SpecialtyDescription, OtherSpecialty, OfficePhone, OfficeFAX, HomePhone, CarPhone, FaxNumber, Pager, EmailAddress, InternetPassword, Type, Position,
            SocialSecurity, StateLicenseNumber, Medicaid, MedicareUPIN, MedicarePIN, HospitalPIN, DEARegNumber, MalpracticePol, SignatureImage, Username, NameSuffix,
            CreditCardIDInfo, RelationshipToPatient, NationalProviderID, EmployerIDNumber, Gender, StateControlledSubstanceNumber, Comments, Suffix;
    private int PersonId, ProviderOrganizationID, SpecialtyID, StaffID, PrimaryEmployerID, SecondaryEmployerID, OrganizationID;
    private byte Active, deleted, HospiceEmployee, ClaimSignatureAuth;

    /**
     * change the datatype of these properties from Timestamp to Date
     *
     * @author Fan Hu
     */
    private Date LicenseExpiration, DEAExpiration, ControlledSubstanceExpiration, DOB;

    public String getOldID() {
        return OldID;
    }

    public void setOldID(String OldID) {
        this.OldID = OldID;
    }

    public String getPersonFirstName() {
        return PersonFirstName;
    }

    public void setPersonFirstName(String PersonFirstName) {
        this.PersonFirstName = PersonFirstName;
    }

    public String getPersonLastName() {
        return PersonLastName;
    }

    public void setPersonLastName(String PersonLastName) {
        this.PersonLastName = PersonLastName;
    }

    public String getPersonMiddleName() {
        return PersonMiddleName;
    }

    public void setPersonMiddleName(String PersonMiddleName) {
        this.PersonMiddleName = PersonMiddleName;
    }

    public String getPersonInitials() {
        return PersonInitials;
    }

    public void setPersonInitials(String PersonInitials) {
        this.PersonInitials = PersonInitials;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String Address1) {
        this.Address1 = Address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStateProvinceRegion() {
        return StateProvinceRegion;
    }

    public void setStateProvinceRegion(String StateProvinceRegion) {
        this.StateProvinceRegion = StateProvinceRegion;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
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

    public String getSpecialtyDescription() {
        return SpecialtyDescription;
    }

    public void setSpecialtyDescription(String SpecialtyDescription) {
        this.SpecialtyDescription = SpecialtyDescription;
    }

    public String getOtherSpecialty() {
        return OtherSpecialty;
    }

    public void setOtherSpecialty(String OtherSpecialty) {
        this.OtherSpecialty = OtherSpecialty;
    }

    public String getOfficePhone() {
        return OfficePhone;
    }

    public void setOfficePhone(String OfficePhone) {
        this.OfficePhone = OfficePhone;
    }

    public String getOfficeFAX() {
        return OfficeFAX;
    }

    public void setOfficeFAX(String OfficeFAX) {
        this.OfficeFAX = OfficeFAX;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

    public String getCarPhone() {
        return CarPhone;
    }

    public void setCarPhone(String CarPhone) {
        this.CarPhone = CarPhone;
    }

    public String getFaxNumber() {
        return FaxNumber;
    }

    public void setFaxNumber(String FaxNumber) {
        this.FaxNumber = FaxNumber;
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

    public String getInternetPassword() {
        return InternetPassword;
    }

    public void setInternetPassword(String InternetPassword) {
        this.InternetPassword = InternetPassword;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getSocialSecurity() {
        return SocialSecurity;
    }

    public void setSocialSecurity(String SocialSecurity) {
        this.SocialSecurity = SocialSecurity;
    }

    public String getStateLicenseNumber() {
        return StateLicenseNumber;
    }

    public void setStateLicenseNumber(String StateLicenseNumber) {
        this.StateLicenseNumber = StateLicenseNumber;
    }

    public String getMedicaid() {
        return Medicaid;
    }

    public void setMedicaid(String Medicaid) {
        this.Medicaid = Medicaid;
    }

    public String getMedicareUPIN() {
        return MedicareUPIN;
    }

    public void setMedicareUPIN(String MedicareUPIN) {
        this.MedicareUPIN = MedicareUPIN;
    }

    public String getMedicarePIN() {
        return MedicarePIN;
    }

    public void setMedicarePIN(String MedicarePIN) {
        this.MedicarePIN = MedicarePIN;
    }

    public String getHospitalPIN() {
        return HospitalPIN;
    }

    public void setHospitalPIN(String HospitalPIN) {
        this.HospitalPIN = HospitalPIN;
    }

    public String getDEARegNumber() {
        return DEARegNumber;
    }

    public void setDEARegNumber(String DEARegNumber) {
        this.DEARegNumber = DEARegNumber;
    }

    public String getMalpracticePol() {
        return MalpracticePol;
    }

    public void setMalpracticePol(String MalpracticePol) {
        this.MalpracticePol = MalpracticePol;
    }

    public String getSignatureImage() {
        return SignatureImage;
    }

    public void setSignatureImage(String SignatureImage) {
        this.SignatureImage = SignatureImage;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getNameSuffix() {
        return NameSuffix;
    }

    public void setNameSuffix(String NameSuffix) {
        this.NameSuffix = NameSuffix;
    }

    public String getCreditCardIDInfo() {
        return CreditCardIDInfo;
    }

    public void setCreditCardIDInfo(String CreditCardIDInfo) {
        this.CreditCardIDInfo = CreditCardIDInfo;
    }

    public String getRelationshipToPatient() {
        return RelationshipToPatient;
    }

    public void setRelationshipToPatient(String RelationshipToPatient) {
        this.RelationshipToPatient = RelationshipToPatient;
    }

    public String getNationalProviderID() {
        return NationalProviderID;
    }

    public void setNationalProviderID(String NationalProviderID) {
        this.NationalProviderID = NationalProviderID;
    }

    public String getEmployerIDNumber() {
        return EmployerIDNumber;
    }

    public void setEmployerIDNumber(String EmployerIDNumber) {
        this.EmployerIDNumber = EmployerIDNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getStateControlledSubstanceNumber() {
        return StateControlledSubstanceNumber;
    }

    public void setStateControlledSubstanceNumber(String StateControlledSubstanceNumber) {
        this.StateControlledSubstanceNumber = StateControlledSubstanceNumber;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public String getSuffix() {
        return Suffix;
    }

    public void setSuffix(String Suffix) {
        this.Suffix = Suffix;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int PersonId) {
        this.PersonId = PersonId;
    }

    public int getProviderOrganizationID() {
        return ProviderOrganizationID;
    }

    public void setProviderOrganizationID(int ProviderOrganizationID) {
        this.ProviderOrganizationID = ProviderOrganizationID;
    }

    public int getSpecialtyID() {
        return SpecialtyID;
    }

    public void setSpecialtyID(int SpecialtyID) {
        this.SpecialtyID = SpecialtyID;
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    public int getPrimaryEmployerID() {
        return PrimaryEmployerID;
    }

    public void setPrimaryEmployerID(int PrimaryEmployerID) {
        this.PrimaryEmployerID = PrimaryEmployerID;
    }

    public int getSecondaryEmployerID() {
        return SecondaryEmployerID;
    }

    public void setSecondaryEmployerID(int SecondaryEmployerID) {
        this.SecondaryEmployerID = SecondaryEmployerID;
    }

    public int getOrganizationID() {
        return OrganizationID;
    }

    public void setOrganizationID(int OrganizationID) {
        this.OrganizationID = OrganizationID;
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

    public byte getHospiceEmployee() {
        return HospiceEmployee;
    }

    public void setHospiceEmployee(byte HospiceEmployee) {
        this.HospiceEmployee = HospiceEmployee;
    }

    public byte getClaimSignatureAuth() {
        return ClaimSignatureAuth;
    }

    public void setClaimSignatureAuth(byte ClaimSignatureAuth) {
        this.ClaimSignatureAuth = ClaimSignatureAuth;
    }

    public Date getLicenseExpiration() {
        return LicenseExpiration;
    }

    public void setLicenseExpiration(Date LicenseExpiration) {
        this.LicenseExpiration = LicenseExpiration;
    }

    public Date getDEAExpiration() {
        return DEAExpiration;
    }

    public void setDEAExpiration(Date DEAExpiration) {
        this.DEAExpiration = DEAExpiration;
    }

    public Date getControlledSubstanceExpiration() {
        return ControlledSubstanceExpiration;
    }

    public void setControlledSubstanceExpiration(Date ControlledSubstanceExpiration) {
        this.ControlledSubstanceExpiration = ControlledSubstanceExpiration;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

}
