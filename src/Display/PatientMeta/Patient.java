/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display.PatientMeta;

import Display.Display;

/**
 *
 * @author Brian
 */
public abstract class Patient extends Temp.PatientMeta.GeneralInformation implements Display {

    //Set methods for GeneralInformation

    /**
     *
     * @param patientID
     * @throws Exception
     */
    @Override
    public void setPatientID(int patientID) throws Exception {
        try {
            Display.validate(patientIDValidationString(), String.valueOf(patientID), "That is not a valid Patient ID");
            super.setPatientID(patientID);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param oldID
     * @throws Exception
     */
    @Override
    public void setOldID(String oldID) throws Exception {
        super.setOldID(oldID);
    }

    /**
     *
     * @param ptLastName
     * @throws Exception
     */
    @Override
    public void setPtLastName(String ptLastName) throws Exception {
        super.setPtLastName(ptLastName);
    }

    /**
     *
     * @param ptPreviousLastName
     * @throws Exception
     */
    @Override
    public void setPtPreviousLastName(String ptPreviousLastName) throws Exception {
        super.setPtPreviousLastName(ptPreviousLastName);
    }

    /**
     *
     * @param ptFirstName
     * @throws Exception
     */
    @Override
    public void setPtFirstName(String ptFirstName) throws Exception {
        super.setPtFirstName(ptFirstName);
    }
    
    /**
     *
     * @param homeAddress1
     * @throws Exception
     */
    @Override
    public void setHomeAddress1(String homeAddress1) throws Exception {
        super.setHomeAddress1(homeAddress1);
    }
    
    /**
     *
     * @param homeAddress2
     * @throws Exception
     */
    @Override
    public void setHomeAddress2(String homeAddress2) throws Exception {
        super.setHomeAddress2(homeAddress2);
    }
    
    /**
     *
     * @param homeCity
     * @throws Exception
     */
    @Override
    public void setHomeCity(String homeCity) throws Exception {
        super.setHomeCity(homeCity);    }
    
    /**
     *
     * @param homeState
     * @throws Exception
     */
    @Override
    public void setHomeState(String homeState) throws Exception {
        super.setHomeState(homeState);    }
    
    /**
     *
     * @param homeZip
     * @throws Exception
     */
    @Override
    public void setHomeZip(String homeZip) throws Exception {
        super.setHomeZip(homeZip);    }
    
    /**
     *
     * @param country
     * @throws Exception
     */
    @Override
    public void setCountry(String country) throws Exception {
        super.setCountry(country);    }
    
    /**
     *
     * @param citizenship
     * @throws Exception
     */
    @Override
    public void setCitizenship(String citizenship) throws Exception {
        super.setCitizenship(citizenship);    }
    
    /**
     *
     * @param ptHomePhoneNumber
     * @throws Exception
     */
    @Override
    public void setPtHomePhoneNumber(String ptHomePhoneNumber) throws Exception {
        super.setPtHomePhoneNumber(ptHomePhoneNumber);    }
    
    /**
     *
     * @param ptEmergencyPhoneNumber
     * @throws Exception
     */
    @Override
    public void setPtEmergencyPhoneNumber(String ptEmergencyPhoneNumber) throws Exception {
        super.setPtEmergencyPhoneNumber(ptEmergencyPhoneNumber);    }
    
    /**
     *
     * @param ptHomeFax
     * @throws Exception
     */
    @Override
    public void setPtHomeFax(String ptHomeFax) throws Exception {
        super.setPtHomeFax(ptHomeFax);    }
    
    /**
     *
     * @param pager
     * @throws Exception
     */
    @Override
    public void setPager(String pager) throws Exception {
        super.setPager(pager);    }
    
    /**
     *
     * @param emailAddress
     * @throws Exception
     */
    @Override
    public void setEmailAddress(String emailAddress) throws Exception {
        super.setEmailAddress(emailAddress);    }
    
    /**
     *
     * @param ptSS
     * @throws Exception
     */
    @Override
    public void setPtSS(String ptSS) throws Exception {
        super.setPtSS(ptSS);    }
    
    /**
     *
     * @param DOB
     * @throws Exception
     */
    @Override
    public void setDOB(String DOB) throws Exception {
        super.setDOB(DOB);    }
    
    /**
     *
     * @param gender
     * @throws Exception
     */
    @Override
    public void setGender(String gender) throws Exception {
        super.setGender(gender);    }
    
    /**
     *
     * @param ethnicAssociation
     * @throws Exception
     */
    @Override
    public void setEthnicAssociation(String ethnicAssociation) throws Exception {
        super.setEthnicAssociation(ethnicAssociation);    }
    
    /**
     *
     * @param religion
     * @throws Exception
     */
    @Override
    public void setReligion(String religion) throws Exception {
        super.setReligion(religion);    }
    
    /**
     *
     * @param maritalStatus
     * @throws Exception
     */
    @Override
    public void setMaritalStatus(String maritalStatus) throws Exception {
        super.setMaritalStatus(maritalStatus);    }
    
    /**
     *
     * @param employmentStatus
     * @throws Exception
     */
    @Override
    public void setEmploymentStatus(String employmentStatus) throws Exception {
        super.setEmploymentStatus(employmentStatus);    }
    
    /**
     *
     * @param hospitalMR
     * @throws Exception
     */
    @Override
    public void setHospitalMR(String hospitalMR) throws Exception {
        super.setHospitalMR(hospitalMR);    }
    
    /**
     *
     * @param dateOfExpire
     * @throws Exception
     */
    @Override
    public void setDateOfExpire(String dateOfExpire) throws Exception {
        super.setDateOfExpire(dateOfExpire);    }
    
    /**
     *
     * @param referral
     * @throws Exception
     */
    @Override
    public void setReferral(int referral) throws Exception {
        super.setReferral(referral);    }
    
    /**
     *
     * @param currentPrimaryHCPId
     * @throws Exception
     */
    @Override
    public void setCurrentPrimaryHCPId(int currentPrimaryHCPId) throws Exception {
        super.setCurrentPrimaryHCPId(currentPrimaryHCPId);    }
    
    /**
     *
     * @param specialist1
     * @throws Exception
     */
    @Override
    public void setSpecialist1(int specialist1) throws Exception {
        super.setSpecialist1(specialist1);    }
    
    /**
     *
     * @param specialist2
     * @throws Exception
     */
    @Override
    public void setSpecialist2(int specialist2) throws Exception {
        super.setSpecialist2(specialist2);    }
    
    /**
     *
     * @param specialist3
     * @throws Exception
     */
    @Override
    public void setSpecialist3(int specialist3) throws Exception {
        super.setSpecialist3(specialist3);    }
    
    /**
     *
     * @param specialist4
     * @throws Exception
     */
    @Override
    public void setSpecialist4(int specialist4) throws Exception {
        super.setSpecialist4(specialist4);    }
    
    /**
     *
     * @param originalStaffHCP
     * @throws Exception
     */
    @Override
    public void setOriginalStaffHCP(int originalStaffHCP) throws Exception {
        super.setOriginalStaffHCP(originalStaffHCP);    }
    
    /**
     *
     * @param currentStaffHCP
     * @throws Exception
     */
    @Override
    public void setCurrentStaffHCP(int currentStaffHCP) throws Exception {
        super.setCurrentStaffHCP(currentStaffHCP);    }
    
    /**
     *
     * @param active
     * @throws Exception
     */
    @Override
    public void setActive(int active) throws Exception {
        super.setActive(active);    }
    
    /**
     *
     * @param comments
     * @throws Exception
     */
    @Override
    public void setComments(String comments) throws Exception {
        super.setComments(comments);    }
    
    /**
     *
     * @param dateEntered
     * @throws Exception
     */
    @Override
    public void setDateEntered(String dateEntered) throws Exception {
        super.setDateEntered(dateEntered);    }
    
    /**
     *
     * @param businessPhone
     * @throws Exception
     */
    @Override
    public void setBusinessPhone(String businessPhone) throws Exception {
        super.setBusinessPhone(businessPhone);    }
    
    /**
     *
     * @param businessFax
     * @throws Exception
     */
    @Override
    public void setBusinessFax(String businessFax) throws Exception {
        super.setBusinessFax(businessFax);    }
    
    /**
     *
     * @param billingAccountInfo
     * @throws Exception
     */
    @Override
    public void setBillingAccountInfo(int billingAccountInfo) throws Exception {
        super.setBillingAccountInfo(billingAccountInfo);    }
    
    /**
     *
     * @param deleted
     * @throws Exception
     */
    @Override
    public void setDeleted(int deleted) throws Exception {
        super.setDeleted(deleted);    }
    
    /**
     *
     * @param updates
     * @throws Exception
     */
    @Override
    public void setUpdates(String updates) throws Exception {
        super.setUpdates(updates);    }
    
    /**
     *
     * @param groupName
     * @throws Exception
     */
    @Override
    public void setGroupName(String groupName) throws Exception {
        super.setGroupName(groupName);    }

    /**
     *
     * @param subscriberRelationship
     * @throws Exception
     */
    @Override
    public void setSubscriberRelationship(String subscriberRelationship) throws Exception {
        super.setSubscriberRelationship(subscriberRelationship);    }

    /**
     *
     * @param employerID
     * @throws Exception
     */
    @Override
    public void setEmployerID(int employerID) throws Exception {
        super.setEmployerID(employerID);    }

    /**
     *
     * @param nextOfKinID
     * @throws Exception
     */
    @Override
    public void setNextOfKinID(int nextOfKinID) throws Exception {
        super.setNextOfKinID(nextOfKinID);    }

    /**
     *
     * @param UPID
     * @throws Exception
     */
    @Override
    public void setUPID(String UPID) throws Exception {
        super.setUPID(UPID);    }

    /**
     *
     * @param ptMiddleInitial
     * @throws Exception
     */
    @Override
    public void setPtMiddleInitial(String ptMiddleInitial) throws Exception {
        super.setPtMiddleInitial(ptMiddleInitial);    }

    /**
     *
     * @param nextOfKinRelationshipToPatient
     * @throws Exception
     */
    @Override
    public void setNextOfKinRelationshipToPatient(String nextOfKinRelationshipToPatient) throws Exception {
        super.setNextOfKinRelationshipToPatient(nextOfKinRelationshipToPatient);    }

    /**
     *
     * @param noticeOfPracticePrivacy
     * @throws Exception
     */
    @Override
    public void setNoticeOfPracticePrivacy(String noticeOfPracticePrivacy) throws Exception {
        super.setNoticeOfPracticePrivacy(noticeOfPracticePrivacy);    }

    /**
     *
     * @param nPPDate
     * @throws Exception
     */
    @Override
    public void setnPPDate(String nPPDate) throws Exception {
        super.setnPPDate(nPPDate);    }

    /**
     *
     * @param suffix
     * @throws Exception
     */
    @Override
    public void setSuffix(String suffix) throws Exception {
        super.setSuffix(suffix);    }
    
    /**
     * 
     * @return 
     */
    //validation String Creation Methods
    public String patientIDValidationString() {
        return "[0-9]{0,11}";
    }
    
}
