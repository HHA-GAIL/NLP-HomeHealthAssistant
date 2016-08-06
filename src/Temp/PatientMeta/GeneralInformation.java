/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp.PatientMeta;

import java.sql.*;
import Database.*;
import Temp.Temp;

/**
 * This is the temp class for GeneralInformation. It will hold the declaration methods and
 * the methods for reading and writing to the database.
 *
 * Edit Date: 05/22/2016 Brian Miller
 *
 * @author Brian
 */
public abstract class GeneralInformation implements Temp {
    //Variable declaration

    //Internal variables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[52];
    private final String[] columnStrings = new String[52];
    final String tableName = "patienttable";

    //Patient variables
    private int patientID;
    private String oldID;
    private String ptLastName;
    private String ptPreviousLastName;
    private String ptFirstName;
    private String homeAddress1;
    private String homeAddress2;
    private String homeCity;
    private String homeState;
    private String homeZip;
    private String country;
    private String citizenship;
    private String ptHomePhoneNumber;
    private String ptEmergencyPhoneNumber;
    private String ptHomeFax;
    private String pager;
    private String emailAddress;
    private String ptSS;
    private String DOB;
    private String gender;
    private String ethnicAssociation;
    private String religion;
    private String maritalStatus;
    private String employmentStatus;
    private String hospitalMR;
    private String dateOfExpire;
    private int referral;
    private int currentPrimaryHCPId;
    private int specialist1;
    private int specialist2;
    private int specialist3;
    private int specialist4;
    private int originalStaffHCP;
    private int currentStaffHCP;
    private int active;
    private String comments;
    private String dateEntered;
    private String businessPhone;
    private String businessFax;
    private int billingAccountInfo;
    private int deleted;
    private String updates;
    private String groupName;
    private String subscriberRelationship;
    private int employerID;
    private int nextOfKinID;
    private String UPID;
    private String ptMiddleInitial;
    private String nextOfKinRelationshipToPatient;
    private String noticeOfPracticePrivacy;
    private String nPPDate;
    private String suffix;

    //Constructors
    /**
     * Default constructor that will initialize column strings
     *
     * Edit Date: 05/22/2016 Brian Miller
     */
    public GeneralInformation() {
        fillColumnStrings();
        readData = new Read(tableName);
    }

    //methods
    /**
     * Populate Data method that will select all records from the patient table
     *
     * Edit Date: 05/22/2016 Brian Miller
     *
     * @throws Exception on database Errors
     */
    @Override
    public void populateData() throws Exception {
        try {
            readData.createConnection();
            currentResultSet = readData.selectAll();
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Adds the created patient to the database
     * @return the result of the add operation, true or false
     * @throws Exception
     */
    @Override
    public boolean addData() throws Exception {
        try {
            fillvalueStrings();
            addData = new Add(valueStrings, columnStrings);
            return addData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
  
    }

    /**
     * updates the current patient record in the database.
     * @return the result of the update operation true or false.
     * @throws Exception
     */
    @Override
    public boolean updateData() throws Exception{
        try {
            fillvalueStrings();
            updateData = new Update(valueStrings, columnStrings);
            return updateData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * deletes the current patient data from the database.
     * @return the result the of the delete operation, true or false.
     * @throws Exception
     */
    @Override
    public boolean deleteData() throws Exception{
        return true;
    }

    @Override
    public void populateFromResultSet() throws Exception {
        try {
            currentResultSet.moveToCurrentRow();
            patientID = currentResultSet.getInt("patientID");
            oldID = currentResultSet.getString("OldID");
            ptLastName = currentResultSet.getString("PtLastName");
            ptPreviousLastName = currentResultSet.getString("PtPreviousLastName");
            ptFirstName = currentResultSet.getString("ptFirstName");
            homeAddress1 = currentResultSet.getString("homeAddress1");
            homeAddress2 = currentResultSet.getString("homeAddress2");
            homeCity = currentResultSet.getString("homeCity");
            homeState = currentResultSet.getString("HomeState/Province/Region");
            homeZip = currentResultSet.getString("homeZip");
            country = currentResultSet.getString("country");
            citizenship = currentResultSet.getString("citizenship");
            ptHomePhoneNumber = currentResultSet.getString("PtHomePhone");
            ptEmergencyPhoneNumber = currentResultSet.getString("EmergencyPhoneNumber");
            ptHomeFax = currentResultSet.getString("PtHomeFax");
            pager = currentResultSet.getString("Pager");
            emailAddress = currentResultSet.getString("EmailAddress");
            ptSS = currentResultSet.getString("PtSS#");
            DOB = currentResultSet.getString("DOB");
            gender = currentResultSet.getString("Gender");
            ethnicAssociation = currentResultSet.getString("EthnicAssociation");
            religion = currentResultSet.getString("Religion");
            maritalStatus = currentResultSet.getString("MaritalStatus");
            employmentStatus = currentResultSet.getString("EmploymentStatus");
            hospitalMR = currentResultSet.getString("HospitalMR#");
            dateOfExpire = currentResultSet.getString("DateofExpire");
            referral = currentResultSet.getInt("Referral");
            currentPrimaryHCPId = currentResultSet.getInt("CurrentPrimaryHCPId");
            specialist1 = currentResultSet.getInt("Specialist1");
            specialist2 = currentResultSet.getInt("Specialist2");
            specialist3 = currentResultSet.getInt("specialist3");
            specialist4 = currentResultSet.getInt("specialist4");
            originalStaffHCP = currentResultSet.getInt("originalStaffHCP");
            currentStaffHCP = currentResultSet.getInt("currentStaffHCP");
            active = currentResultSet.getInt("active");
            comments = currentResultSet.getString("comments");
            dateEntered = currentResultSet.getString("dateEntered");
            businessPhone = currentResultSet.getString("businessPhone");
            businessFax = currentResultSet.getString("businessFax");
            billingAccountInfo = currentResultSet.getInt("BillingAcctNumber");
            deleted = currentResultSet.getInt("deleted");
            updates = currentResultSet.getString("updates");
            groupName = currentResultSet.getString("groupName");
            subscriberRelationship = currentResultSet.getString("subscriberRelationship");
            employerID = currentResultSet.getInt("employerID");
            nextOfKinID = currentResultSet.getInt("nextOfKinID");
            UPID = currentResultSet.getString("UPID");
            ptMiddleInitial = currentResultSet.getString("ptMiddleInitial");
            nextOfKinRelationshipToPatient = currentResultSet.getString("nextOfKinRelationshipToPatient");
            noticeOfPracticePrivacy = currentResultSet.getString("noticeOfPracticePrivacy");
            nPPDate = currentResultSet.getString("nPPDate");
            suffix = currentResultSet.getString("suffix");
        } catch (Exception e) {
            throw e;
        }
    }
    public void determinePatientFromID() throws Exception{
        populateFromResultSet(this.patientID);
    }
    public Interface.PatientMeta.GeneralInformation populateFromResultSet(int position) throws Exception {
        try {
            Interface.PatientMeta.GeneralInformation newGeneralInformation = new Interface.PatientMeta.GeneralInformation();
            currentResultSet.absolute(position);
            newGeneralInformation.setPatientID(currentResultSet.getInt("patientID"));
            newGeneralInformation.setOldID(currentResultSet.getString("OldID"));
            newGeneralInformation.setPtLastName(currentResultSet.getString("PtLastName"));
            newGeneralInformation.setPtPreviousLastName(currentResultSet.getString("PtPreviousLastName"));
            newGeneralInformation.setPtFirstName(currentResultSet.getString("ptFirstName"));
            newGeneralInformation.setHomeAddress1(currentResultSet.getString("homeAddress1"));
            newGeneralInformation.setHomeAddress2(currentResultSet.getString("homeAddress2"));
           newGeneralInformation.setHomeCity(currentResultSet.getString("homeCity"));
            newGeneralInformation.setHomeState(currentResultSet.getString("HomeState/Province/Region"));
            newGeneralInformation.setHomeZip(currentResultSet.getString("homeZip"));
            newGeneralInformation.setCountry(currentResultSet.getString("country"));
            newGeneralInformation.setCitizenship(currentResultSet.getString("citizenship"));
            newGeneralInformation.setPtHomePhoneNumber(currentResultSet.getString("PtHomePhone"));
            newGeneralInformation.setPtEmergencyPhoneNumber(currentResultSet.getString("EmergencyPhoneNumber"));
            newGeneralInformation.setPtHomeFax(currentResultSet.getString("PtHomeFax"));
            newGeneralInformation.setPager(currentResultSet.getString("Pager"));
            newGeneralInformation.setEmailAddress(currentResultSet.getString("EmailAddress"));
            newGeneralInformation.setPtSS(currentResultSet.getString("PtSS#"));
            newGeneralInformation.setDOB(currentResultSet.getString("DOB"));
            newGeneralInformation.setGender(currentResultSet.getString("Gender"));
            newGeneralInformation.setEthnicAssociation(currentResultSet.getString("EthnicAssociation"));
            newGeneralInformation.setReligion(currentResultSet.getString("Religion"));
            newGeneralInformation.setMaritalStatus(currentResultSet.getString("MaritalStatus"));
            newGeneralInformation.setEmploymentStatus(currentResultSet.getString("EmploymentStatus"));
            newGeneralInformation.setHospitalMR(currentResultSet.getString("HospitalMR#"));
            newGeneralInformation.setDateOfExpire(currentResultSet.getString("DateofExpire"));
            newGeneralInformation.setReferral(currentResultSet.getInt("Referral"));
            newGeneralInformation.setCurrentPrimaryHCPId(currentResultSet.getInt("CurrentPrimaryHCPId"));
            newGeneralInformation.setSpecialist1(currentResultSet.getInt("Specialist1"));
            newGeneralInformation.setSpecialist2(currentResultSet.getInt("Specialist2"));
            newGeneralInformation.setSpecialist3(currentResultSet.getInt("specialist3"));
            newGeneralInformation.setSpecialist4(currentResultSet.getInt("specialist4"));
            newGeneralInformation.setOriginalStaffHCP(currentResultSet.getInt("originalStaffHCP"));
            newGeneralInformation.setCurrentStaffHCP(currentResultSet.getInt("currentStaffHCP"));
            newGeneralInformation.setActive(currentResultSet.getInt("active"));
            newGeneralInformation.setComments(currentResultSet.getString("comments"));
            newGeneralInformation.setDateEntered(currentResultSet.getString("dateEntered"));
            newGeneralInformation.setBusinessPhone(currentResultSet.getString("businessPhone"));
            newGeneralInformation.setBusinessFax(currentResultSet.getString("businessFax"));
            newGeneralInformation.setBillingAccountInfo(currentResultSet.getInt("BillingAcctNumber"));
            newGeneralInformation.setDeleted(currentResultSet.getInt("deleted"));
            newGeneralInformation.setUpdates(currentResultSet.getString("updates"));
            newGeneralInformation.setGroupName(currentResultSet.getString("groupName"));
            newGeneralInformation.setSubscriberRelationship(currentResultSet.getString("subscriberRelationship"));
            newGeneralInformation.setEmployerID(currentResultSet.getInt("employerID"));
            newGeneralInformation.setNextOfKinID(currentResultSet.getInt("nextOfKinID"));
            newGeneralInformation.setUPID(currentResultSet.getString("UPID"));
            newGeneralInformation.setPtMiddleInitial(currentResultSet.getString("ptMiddleInitial"));
            newGeneralInformation.setNextOfKinRelationshipToPatient(currentResultSet.getString("nextOfKinRelationshipToPatient"));
            newGeneralInformation.setNoticeOfPracticePrivacy(currentResultSet.getString("noticeOfPracticePrivacy"));
            newGeneralInformation.setnPPDate(currentResultSet.getString("nPPDate"));
            newGeneralInformation.setSuffix(currentResultSet.getString("suffix"));
            return newGeneralInformation;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void fillColumnStrings() {
        columnStrings[0] = "PatientID";
        columnStrings[1] = "OldID";
        columnStrings[2] = "PtLastName";
        columnStrings[3] = "PtPreviousLastName";
        columnStrings[4] = "PtFirstName";
        columnStrings[5] = "HomeAddress1";
        columnStrings[6] = "HomeAddress2";
        columnStrings[7] = "HomeCity";
        columnStrings[8] = "HomeState/Province/Region";
        columnStrings[9] = "HomeZip";
        columnStrings[10] = "Country";
        columnStrings[11] = "Citizenship";
        columnStrings[12] = "PtHomePhone";
        columnStrings[13] = "EmergencyPhoneNumber";
        columnStrings[14] = "PtHomeFax";
        columnStrings[15] = "Pager";
        columnStrings[16] = "EmailAddress";
        columnStrings[17] = "PtSS#";
        columnStrings[18] = "DOB";
        columnStrings[19] = "Gender";
        columnStrings[20] = "EthnicAssociation";
        columnStrings[21] = "Religion";
        columnStrings[22] = "MaritalStatus";
        columnStrings[23] = "EmploymentStatus";
        columnStrings[24] = "HospitalMR#";
        columnStrings[25] = "DateofExpire";
        columnStrings[26] = "Referral";
        columnStrings[27] = "CurrentPrimaryHCPId";
        columnStrings[28] = "Specialist1";
        columnStrings[29] = "Specialist2";
        columnStrings[30] = "Specialist3";
        columnStrings[31] = "Specialist4";
        columnStrings[32] = "OriginalStaffHCP";
        columnStrings[33] = "CurrentStaffHCP";
        columnStrings[34] = "Active";
        columnStrings[35] = "Comments";
        columnStrings[36] = "DateEntered";
        columnStrings[37] = "BusinessPhone";
        columnStrings[38] = "BusinessFax";
        columnStrings[39] = "BillingAcctNumber";
        columnStrings[40] = "deleted";
        columnStrings[41] = "updates";
        columnStrings[42] = "GroupName";
        columnStrings[43] = "SubscriberRelationship";
        columnStrings[44] = "EmployerID";
        columnStrings[45] = "NextOfKinID";
        columnStrings[46] = "UPID";
        columnStrings[47] = "PtMiddleInitial";
        columnStrings[48] = "NextOfKinRelationshipToPatient";
        columnStrings[49] = "NoticeOfPracticePrivacy";
        columnStrings[50] = "NPPDate";
        columnStrings[51] = "Suffix";
    }

    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(patientID);
        valueStrings[1] = oldID;
        valueStrings[2] = ptLastName;
        valueStrings[3] = ptPreviousLastName;
        valueStrings[4] = ptFirstName;
        valueStrings[5] = homeAddress1;
        valueStrings[6] = homeAddress2;
        valueStrings[7] = homeCity;
        valueStrings[8] = homeState;
        valueStrings[9] = homeZip;
        valueStrings[10] = country;
        valueStrings[11] = citizenship;
        valueStrings[12] = ptHomePhoneNumber;
        valueStrings[13] = ptEmergencyPhoneNumber;
        valueStrings[14] = ptHomeFax;
        valueStrings[15] = pager;
        valueStrings[16] = emailAddress;
        valueStrings[17] = ptSS;
        valueStrings[18] = DOB;
        valueStrings[19] = gender;
        valueStrings[20] = ethnicAssociation;
        valueStrings[21] = religion;
        valueStrings[22] = maritalStatus;
        valueStrings[23] = employmentStatus;
        valueStrings[24] = hospitalMR;
        valueStrings[25] = dateOfExpire;
        valueStrings[26] = String.valueOf(referral);
        valueStrings[27] = String.valueOf(currentPrimaryHCPId);
        valueStrings[28] = String.valueOf(specialist1);
        valueStrings[29] = String.valueOf(specialist2);
        valueStrings[30] = String.valueOf(specialist3);
        valueStrings[31] = String.valueOf(specialist4);
        valueStrings[32] = String.valueOf(originalStaffHCP);
        valueStrings[33] = String.valueOf(currentStaffHCP);
        valueStrings[34] = String.valueOf(active);
        valueStrings[35] = comments;
        valueStrings[36] = dateEntered;
        valueStrings[37] = businessPhone;
        valueStrings[38] = businessFax;
        valueStrings[39] = String.valueOf(billingAccountInfo);
        valueStrings[40] = String.valueOf(deleted);
        valueStrings[41] = updates;
        valueStrings[42] = groupName;
        valueStrings[43] = subscriberRelationship;
        valueStrings[44] = String.valueOf(employerID);
        valueStrings[45] = String.valueOf(nextOfKinID);
        valueStrings[46] = UPID;
        valueStrings[47] = ptMiddleInitial;
        valueStrings[48] = nextOfKinRelationshipToPatient;
        valueStrings[49] = noticeOfPracticePrivacy;
        valueStrings[50] = nPPDate;
        valueStrings[51] = suffix;

    }
    public boolean fristUse() throws Exception{
        int counter = 0;
        currentResultSet.beforeFirst();
        while (currentResultSet.next()) {            
            counter++;
        }
        currentResultSet.beforeFirst();
        return (counter == 0);
    }

    //Set Methods
    public void setPatientID(int patientID) throws Exception {
        this.patientID = patientID;
    }

    public void setOldID(String oldID) throws Exception {
        this.oldID = oldID;
    }

    public void setPtLastName(String ptLastName) throws Exception {
        this.ptLastName = ptLastName;
    }

    public void setPtPreviousLastName(String ptPreviousLastName) throws Exception {
        this.ptPreviousLastName = ptPreviousLastName;
    }

    public void setPtFirstName(String ptFirstName) throws Exception {
        this.ptFirstName = ptFirstName;
    }

    public void setHomeAddress1(String homeAddress1) throws Exception {
        this.homeAddress1 = homeAddress1;
    }

    public void setHomeAddress2(String homeAddress2) throws Exception {
        this.homeAddress2 = homeAddress2;
    }

    public void setHomeCity(String homeCity) throws Exception {
        this.homeCity = homeCity;
    }

    public void setHomeState(String homeState) throws Exception {
        this.homeState = homeState;
    }

    public void setHomeZip(String homeZip) throws Exception {
        this.homeZip = homeZip;
    }

    public void setCountry(String country) throws Exception {
        this.country = country;
    }

    public void setCitizenship(String citizenship) throws Exception {
        this.citizenship = citizenship;
    }

    public void setPtHomePhoneNumber(String ptHomePhoneNumber) throws Exception {
        this.ptHomePhoneNumber = ptHomePhoneNumber;
    }

    public void setPtEmergencyPhoneNumber(String ptEmergencyPhoneNumber) throws Exception {
        this.ptEmergencyPhoneNumber = ptEmergencyPhoneNumber;
    }

    public void setPtHomeFax(String ptHomeFax) throws Exception {
        this.ptHomeFax = ptHomeFax;
    }

    public void setPager(String pager) throws Exception {
        this.pager = pager;
    }

    public void setEmailAddress(String emailAddress) throws Exception {
        this.emailAddress = emailAddress;
    }

    public void setPtSS(String ptSS) throws Exception {
        this.ptSS = ptSS;
    }

    public void setDOB(String DOB) throws Exception {
        this.DOB = DOB;
    }

    public void setGender(String gender) throws Exception {
        this.gender = gender;
    }

    public void setEthnicAssociation(String ethnicAssociation) throws Exception {
        this.ethnicAssociation = ethnicAssociation;
    }

    public void setReligion(String religion) throws Exception {
        this.religion = religion;
    }

    public void setMaritalStatus(String maritalStatus) throws Exception {
        this.maritalStatus = maritalStatus;
    }

    public void setEmploymentStatus(String employmentStatus) throws Exception {
        this.employmentStatus = employmentStatus;
    }

    public void setHospitalMR(String hospitalMR) throws Exception {
        this.hospitalMR = hospitalMR;
    }

    public void setDateOfExpire(String dateOfExpire) throws Exception {
        this.dateOfExpire = dateOfExpire;
    }

    public void setReferral(int referral) throws Exception {
        this.referral = referral;
    }

    public void setCurrentPrimaryHCPId(int currentPrimaryHCPId) throws Exception {
        this.currentPrimaryHCPId = currentPrimaryHCPId;
    }

    public void setSpecialist1(int specialist1) throws Exception {
        this.specialist1 = specialist1;
    }

    public void setSpecialist2(int specialist2) throws Exception {
        this.specialist2 = specialist2;
    }

    public void setSpecialist3(int specialist3) throws Exception {
        this.specialist3 = specialist3;
    }

    public void setSpecialist4(int specialist4) throws Exception {
        this.specialist4 = specialist4;
    }

    public void setOriginalStaffHCP(int originalStaffHCP) throws Exception {
        this.originalStaffHCP = originalStaffHCP;
    }

    public void setCurrentStaffHCP(int currentStaffHCP) throws Exception {
        this.currentStaffHCP = currentStaffHCP;
    }

    public void setActive(int active) throws Exception {
        this.active = active;
    }

    public void setComments(String comments) throws Exception {
        this.comments = comments;
    }

    public void setDateEntered(String dateEntered) throws Exception {
        this.dateEntered = dateEntered;
    }

    public void setBusinessPhone(String businessPhone) throws Exception {
        this.businessPhone = businessPhone;
    }

    public void setBusinessFax(String businessFax) throws Exception {
        this.businessFax = businessFax;
    }

    public void setBillingAccountInfo(int billingAccountInfo) throws Exception {
        this.billingAccountInfo = billingAccountInfo;
    }

    public void setDeleted(int deleted) throws Exception {
        this.deleted = deleted;
    }

    public void setUpdates(String updates) throws Exception {
        this.updates = updates;
    }

    public void setGroupName(String groupName) throws Exception {
        this.groupName = groupName;
    }

    public void setSubscriberRelationship(String subscriberRelationship) throws Exception {
        this.subscriberRelationship = subscriberRelationship;
    }

    public void setEmployerID(int employerID) throws Exception {
        this.employerID = employerID;
    }

    public void setNextOfKinID(int nextOfKinID) throws Exception {
        this.nextOfKinID = nextOfKinID;
    }

    public void setUPID(String UPID) throws Exception {
        this.UPID = UPID;
    }

    public void setPtMiddleInitial(String ptMiddleInitial) throws Exception {
        this.ptMiddleInitial = ptMiddleInitial;
    }

    public void setNextOfKinRelationshipToPatient(String nextOfKinRelationshipToPatient) throws Exception {
        this.nextOfKinRelationshipToPatient = nextOfKinRelationshipToPatient;
    }

    public void setNoticeOfPracticePrivacy(String noticeOfPracticePrivacy) throws Exception {
        this.noticeOfPracticePrivacy = noticeOfPracticePrivacy;
    }

    public void setnPPDate(String nPPDate) throws Exception {
        this.nPPDate = nPPDate;
    }

    public void setSuffix(String suffix) throws Exception {
        this.suffix = suffix;
    }

    //Getters
    public int getPatientID() {
        return patientID;
    }

    public String getOldID() {
        return oldID;
    }

    public String getPtLastName() {
        return ptLastName;
    }

    public String getPtPreviousLastName() {
        return ptPreviousLastName;
    }

    public String getPtFirstName() {
        return ptFirstName;
    }

    public String getHomeAddress1() {
        return homeAddress1;
    }

    public String getHomeAddress2() {
        return homeAddress2;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public String getCountry() {
        return country;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getPtHomePhoneNumber() {
        return ptHomePhoneNumber;
    }

    public String getPtEmergencyPhoneNumber() {
        return ptEmergencyPhoneNumber;
    }

    public String getPtHomeFax() {
        return ptHomeFax;
    }

    public String getPager() {
        return pager;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPtSS() {
        return ptSS;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public String getEthnicAssociation() {
        return ethnicAssociation;
    }

    public String getReligion() {
        return religion;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public String getHospitalMR() {
        return hospitalMR;
    }

    public String getDateOfExpire() {
        return dateOfExpire;
    }

    public int getReferral() {
        return referral;
    }

    public int getCurrentPrimaryHCPId() {
        return currentPrimaryHCPId;
    }

    public int getSpecialist1() {
        return specialist1;
    }

    public int getSpecialist2() {
        return specialist2;
    }

    public int getSpecialist3() {
        return specialist3;
    }

    public int getSpecialist4() {
        return specialist4;
    }

    public int getOriginalStaffHCP() {
        return originalStaffHCP;
    }

    public int getCurrentStaffHCP() {
        return currentStaffHCP;
    }

    public int isActive() {
        return active;
    }

    public String getComments() {
        return comments;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public String getBusinessFax() {
        return businessFax;
    }

    public int getBillingAccountInfo() {
        return billingAccountInfo;
    }

    public int isDeleted() {
        return deleted;
    }

    public String getUpdates() {
        return updates;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getSubscriberRelationship() {
        return subscriberRelationship;
    }

    public int getEmployerID() {
        return employerID;
    }

    public int getNextOfKinID() {
        return nextOfKinID;
    }

    public String getUPID() {
        return UPID;
    }

    public String getPtMiddleInitial() {
        return ptMiddleInitial;
    }

    public String getNextOfKinRelationshipToPatient() {
        return nextOfKinRelationshipToPatient;
    }

    public String getNoticeOfPracticePrivacy() {
        return noticeOfPracticePrivacy;
    }

    public String getnPPDate() {
        return nPPDate;
    }

    public String getSuffix() {
        return suffix;
    }

}
