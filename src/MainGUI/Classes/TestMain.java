package MainGUI.Classes;

import MainGUI.DAO.JDBCMySQLConnection;
import java.sql.*;

public class TestMain {

    /*public static void main(String[] args) 
    {
        AllergyHistory ah = getAllergyHistory(1);
        System.out.println(ah.getAllergyID() + ah.getAllergen());
        updateRecord(getAllergyHistory(1));
    }*/
// <editor-fold defaultstate="collapsed" desc="Methods for database to object transfer">
    public static AllergyHistory getAllergyHistory(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        AllergyHistory allergyHist = null;
        String query = "SELECT * FROM allergyhistorytable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                allergyHist = new AllergyHistory();
                allergyHist.setAllergen(rs.getString("Allergen"));
                allergyHist.setAllergyDescription(rs.getString("AllergyDescription"));
                allergyHist.setAllergyEndDate(rs.getString("AllergyEndDate"));
                allergyHist.setAllergyHRF(rs.getByte("AllergyHRF"));
                allergyHist.setAllergyID(rs.getInt("AllergyID"));
                allergyHist.setAllergyStartDate(rs.getString("AllergyStartDate"));
                allergyHist.setDeleted(rs.getByte("deleted"));
                allergyHist.setPatientID(rs.getInt("PatientID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return allergyHist;
    }

    public static FamilyHistory getFamilyHistory(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        FamilyHistory familyHist = null;
        String query = "SELECT * FROM familyhistorytable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                familyHist = new FamilyHistory();
                familyHist.setFamilyID(rs.getInt("FamilyID"));
                familyHist.setPatientID(rs.getInt("PatientID"));
                familyHist.setName(rs.getString("Name"));
                familyHist.setRelation(rs.getString("Relation"));
                familyHist.setAlive(rs.getByte("Alive"));
                familyHist.setLivesWithPatient(rs.getByte("Lives with patient"));
                familyHist.setMajorDisorder(rs.getString("MajorDisorder"));
                familyHist.setSpecificTypeDisorder(rs.getString("SpecificTypeDisorder"));
                familyHist.setDisorderHRF(rs.getByte("DisorderHRF"));
                familyHist.setDeleted(rs.getByte("deleted"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return familyHist;
    }

    public static GeneralMedicalHistory getGeneralMedicalHistory(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        GeneralMedicalHistory generalMedicalHist = null;
        String query = "SELECT * FROM generalmedicalhistorytable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                generalMedicalHist = new GeneralMedicalHistory();
                generalMedicalHist.setMaritalStatus(rs.getString("MaritalStatus"));
                generalMedicalHist.setEducation(rs.getString("Education"));
                generalMedicalHist.setGrowthAndDevelopment(rs.getString("GrowthAndDevelopment"));
                generalMedicalHist.setPregnancies(rs.getString("Pregnancies"));
                generalMedicalHist.setBehavioralHistory(rs.getString("BehavioralHistory"));
                generalMedicalHist.setTobacco(rs.getString("Tobacco"));
                generalMedicalHist.setTobaccoQuantity(rs.getString("TobaccoQuantity"));
                generalMedicalHist.setTobaccoduraton(rs.getString("Tobaccoduraton"));
                generalMedicalHist.setAlcohol(rs.getString("Alcohol"));
                generalMedicalHist.setAlcoholQuantity(rs.getString("AlcoholQuantity"));
                generalMedicalHist.setAlcoholduration(rs.getString("Alcoholduration"));
                generalMedicalHist.setDrug(rs.getString("Drug"));
                generalMedicalHist.setDrugType(rs.getString("DrugType"));
                generalMedicalHist.setDrugduration(rs.getString("Drugduration"));
                generalMedicalHist.setDietary(rs.getString("Dietary"));
                generalMedicalHist.setTravel(rs.getString("Travel"));
                generalMedicalHist.setBloodType(rs.getString("BloodType"));
                generalMedicalHist.setRh(rs.getString("Rh"));
                generalMedicalHist.setMedicalHistoryNotes(rs.getString("MedicalHistoryNotes"));
                generalMedicalHist.setHxObtainedBy(rs.getString("HxObtainedBy"));
                generalMedicalHist.setUnableToObtainHxReason(rs.getString("UnableToObtainHxReason"));
                generalMedicalHist.setLMPStatus(rs.getString("LMPStatus"));
                generalMedicalHist.setEDC(rs.getDate("EDC"));
                generalMedicalHist.setLMPEstMethod(rs.getString("LMPEstMethod"));
                generalMedicalHist.setMensesFreq(rs.getString("MensesFreq"));
                generalMedicalHist.setHospitalOfDelivery(rs.getString("HospitalOfDelivery"));
                generalMedicalHist.setEGA(rs.getString("EGA"));
                generalMedicalHist.setGeneralMedicalHistoryID(rs.getInt("GeneralMedicalHistoryID"));
                generalMedicalHist.setPatientID(rs.getInt("PatientID"));
                generalMedicalHist.setNumberOfChildren(rs.getInt("NumberOfChildren"));
                generalMedicalHist.setNumberOfPregnancies(rs.getInt("NumberOfPregnancies"));
                generalMedicalHist.setMenarcheAgeOfOnset(rs.getInt("MenarcheAgeOfOnset"));
                generalMedicalHist.setTobaccoHRF(rs.getByte("TobaccoHRF"));
                generalMedicalHist.setAlcoholHRF(rs.getByte("AlcoholHRF"));
                generalMedicalHist.setDrugHRF(rs.getByte("DrugHRF"));
                generalMedicalHist.setDietHRF(rs.getByte("DietHRF"));
                generalMedicalHist.setTravelHRF(rs.getByte("TravelHRF"));
                generalMedicalHist.setHxConfirmedByHCP(rs.getByte("HxConfirmedByHCP"));
                generalMedicalHist.setDeleted(rs.getByte("deleted"));
                generalMedicalHist.setLMP(rs.getByte("LMP"));
                generalMedicalHist.setPregnant(rs.getByte("Pregnant"));
                generalMedicalHist.setLMPDateApprox(rs.getByte("LMPDateApprox"));
                generalMedicalHist.setMenstrualAmtNormalYes(rs.getByte("MenstrualAmtNormalYes"));
                generalMedicalHist.setMenstrualAmtNormalNo(rs.getByte("MenstrualAmtNormalNo"));
                generalMedicalHist.setMensesMonthlyYes(rs.getByte("MensesMonthlyYes"));
                generalMedicalHist.setMensesMonthlyNo(rs.getByte("MensesMonthlyNo"));
                generalMedicalHist.setOnBCPAtConceptionYes(rs.getByte("OnBCPAtConceptionYes"));
                generalMedicalHist.setOnBCPAtConceptionNo(rs.getByte("OnBCPAtConceptionNo"));
                generalMedicalHist.setLMPDate(rs.getDate("LMPDate"));
                generalMedicalHist.setPregnancyDueDate(rs.getDate("PregnancyDueDate"));
                generalMedicalHist.setMensesPriorDate(rs.getDate("MensesPriorDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return generalMedicalHist;
    }

    public static IllnessHistory getIllnessHistory(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        IllnessHistory illnessHist = null;
        String query = "SELECT * FROM illnesshistorytable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                illnessHist = new IllnessHistory();
                illnessHist.setIllnessDate(rs.getDate("IllnessDate"));
                illnessHist.setIllness(rs.getString("Illness"));
                illnessHist.setResolution(rs.getString("Resolution"));
                illnessHist.setIllnessID(rs.getInt("IllnessID"));
                illnessHist.setPatientID(rs.getInt("PatientID"));
                illnessHist.setIllnessHRF(rs.getByte("IllnessHRF"));
                illnessHist.setDeleted(rs.getByte("deleted"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return illnessHist;
    }

    public static ImmunizationsHistory getImmunizationsHistory(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        ImmunizationsHistory immuneHist = null;
        String query = "SELECT * FROM immunizationshistorytable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                immuneHist = new ImmunizationsHistory();
                immuneHist.setVaccine(rs.getString("Vaccine"));
                immuneHist.setDelivery(rs.getString("Delivery"));
                immuneHist.setComments(rs.getString("Comments"));
                immuneHist.setImmunizationsID(rs.getInt("ImmunizationsID"));
                immuneHist.setPatientID(rs.getInt("PatientID"));
                immuneHist.setHCPId(rs.getInt("HCPId"));
                immuneHist.setDeleted(rs.getByte("deleted"));
                immuneHist.setImmunizationDate(rs.getDate("ImmunizationDate"));
                immuneHist.setExperationDate(rs.getDate("ExperationDate"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return immuneHist;
    }

    public static OccupationalHistory getOccupationalHistory(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        OccupationalHistory occupationalHist = null;
        String query = "SELECT * FROM occupationalhistorytable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                occupationalHist = new OccupationalHistory();
                occupationalHist.setDescription(rs.getString("Description"));
                occupationalHist.setCauseofdisability(rs.getString("Causeofdisability"));
                occupationalHist.setOccupationalID(rs.getInt("OccupationalID"));
                occupationalHist.setPatientID(rs.getInt("PatientID"));
                occupationalHist.setCurrent(rs.getByte("Current"));
                occupationalHist.setDisability(rs.getByte("Disability"));
                occupationalHist.setOccupationalHRF(rs.getByte("OccupationalHRF"));
                occupationalHist.setDeleted(rs.getByte("deleted"));
                occupationalHist.setStartDate(rs.getDate("StartDate"));
                occupationalHist.setEndDate(rs.getDate("EndDate"));
                occupationalHist.setLastWorkDate(rs.getDate("LastWorkDate"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return occupationalHist;
    }

    public static PastPregnancies getPastPregnancies(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        PastPregnancies pastPreg = null;
        String query = "SELECT * FROM pastpregnanciestable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                pastPreg = new PastPregnancies();
                pastPreg.setPregnancyDate(rs.getDate("PregnancyDate"));
                pastPreg.setLengthOfLabor(rs.getString("LengthOfLabor"));
                pastPreg.setSex(rs.getString("Sex"));
                pastPreg.setTypeOfDelivery(rs.getString("TypeOfDelivery"));
                pastPreg.setPlaceOfDelivery(rs.getString("PlaceOfDelivery"));
                pastPreg.setComments(rs.getString("Comments"));
                pastPreg.setCorionicity(rs.getString("Corionicity"));
                pastPreg.setEGAEstMethod(rs.getString("EGAEstMethod"));
                pastPreg.setPastPregnanciesID(rs.getInt("PastPregnanciesID"));
                pastPreg.setPatientID(rs.getInt("PatientID"));
                pastPreg.setNumberOfFetuses(rs.getInt("NumberOfFetuses"));
                pastPreg.setEGA(rs.getDouble("EGA"));
                pastPreg.setBirthWeightLbs(rs.getDouble("BirthWeightLbs"));
                pastPreg.setBirthWeightOunces(rs.getDouble("BirthWeightOunces"));
                pastPreg.setPreTermLabor(rs.getByte("PreTermLabor"));
                pastPreg.setDeleted(rs.getByte("deleted"));
                pastPreg.setChoncordant(rs.getByte("Choncordant"));
                pastPreg.setTwinToTwinTransSyndrome(rs.getByte("TwinToTwinTransSyndrome"));
                pastPreg.setOnBCPAtConceptionYes(rs.getByte("OnBCPAtConceptionYes"));
                pastPreg.setOnBCPAtConceptionNo(rs.getByte("OnBCPAtConceptionNo"));
                pastPreg.setCurrent(rs.getByte("Current"));
                pastPreg.setLMP(rs.getDate("LMP"));
                pastPreg.setEDD(rs.getDate("EDD"));
                pastPreg.setDateStamp(rs.getDate("DateStamp"));
                pastPreg.setEGACalculationDate(rs.getDate("EGACalculationDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return pastPreg;
    }

    public static Patient getPatient(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        Patient patient = null;
        String query = "SELECT * FROM patienttable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                patient = new Patient();
                patient.setOldID(rs.getString("OldID"));
                patient.setPtLastName(rs.getString("PtLastName"));
                patient.setPtPreviousLastName(rs.getString("PtPreviousLastName"));
                patient.setPtFirstName(rs.getString("PtFirstName"));
                patient.setHomeAddress1(rs.getString("HomeAddress1"));
                patient.setHomeAddress2(rs.getString("HomeAddress2"));
                patient.setHomeCity(rs.getString("HomeCity"));
                patient.setHomeStateProvinceRegion(rs.getString("HomeState/Province/Region"));
                patient.setHomeZip(rs.getString("HomeZip"));
                patient.setCountry(rs.getString("Country"));
                patient.setCitizenship(rs.getString("Citizenship"));
                patient.setPtHomePhone(rs.getString("PtHomePhone"));
                patient.setEmergencyPhoneNumber(rs.getString("EmergencyPhoneNumber"));
                patient.setPtHomeFax(rs.getString("PtHomeFax"));
                patient.setPager(rs.getString("Pager"));
                patient.setEmailAddress(rs.getString("EmailAddress"));
                patient.setPtSS(rs.getString("PtSS#"));
                patient.setGender(rs.getString("Gender"));
                patient.setEthnicAssociation(rs.getString("EthnicAssociation"));
                patient.setReligion(rs.getString("Religion"));
                patient.setMaritalStatus(rs.getString("MaritalStatus"));
                patient.setEmploymentStatus(rs.getString("EmploymentStatus"));
                patient.setHospitalMR(rs.getString("HospitalMR#"));
                patient.setComments(rs.getString("Comments"));
                patient.setBusinessPhone(rs.getString("BusinessPhone"));
                patient.setBusinessFax(rs.getString("BusinessFax"));
                patient.setUpdates(rs.getString("Updates"));
                patient.setGroupName(rs.getString("GroupName"));
                patient.setSubscriberRelationship(rs.getString("SubscriberRelationship"));
                patient.setUPID(rs.getString("UPID"));
                patient.setPtMiddleInitial(rs.getString("PtMiddleInitial"));
                patient.setNextOfKinRelationshipToPatient(rs.getString("NextOfKinRelationshipToPatient"));
                patient.setSuffix(rs.getString("Suffix"));
                patient.setPatientID(rs.getInt("PatientID"));
                patient.setReferral(rs.getInt("Referral"));
                patient.setCurrentPrimaryHCPId(rs.getInt("CurrentPrimaryHCPId"));
                patient.setSpecialist1(rs.getInt("Specialist1"));
                patient.setSpecialist2(rs.getInt("Specialist2"));
                patient.setSpecialist3(rs.getInt("Specialist3"));
                patient.setSpecialist4(rs.getInt("Specialist4"));
                patient.setOriginalStaffHCP(rs.getInt("OriginalStaffHCP"));
                patient.setCurrentStaffHCP(rs.getInt("CurrentStaffHCP"));
                patient.setBillingAcctNumber(rs.getInt("BillingAcctNumber"));
                patient.setEmployerID(rs.getInt("EmployerID"));
                patient.setNextOfKinID(rs.getInt("NextOfKinID"));
                patient.setActive(rs.getByte("Active"));
                patient.setDeleted(rs.getByte("deleted"));
                patient.setNoticeOfPracticePrivacy(rs.getByte("NoticeOfPracticePrivacy"));
                patient.setDOB(rs.getDate("DOB"));
                patient.setDateofExpire(rs.getDate("DateofExpire"));
                patient.setDateEntered(rs.getDate("DateEntered"));
                patient.setNPPDate(rs.getDate("NPPDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return patient;
    }

    public static Person getPerson(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        Person person = null;
        String query = "SELECT * FROM persontable WHERE PersonId=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                person = new Person();
                person.setOldID(rs.getString("OldID"));
                person.setPersonFirstName(rs.getString("PersonFirstName"));
                person.setPersonLastName(rs.getString("PersonLastName"));
                person.setPersonMiddleName(rs.getString("PersonMiddleName"));
                person.setPersonInitials(rs.getString("PersonInitials"));
                person.setTitle(rs.getString("Title"));
                person.setAddress1(rs.getString("Address1"));
                person.setAddress2(rs.getString("Address2"));
                person.setGroupName(rs.getString("GroupName"));
                person.setCity(rs.getString("City"));
                person.setStateProvinceRegion(rs.getString("State/Province/Region"));
                person.setZipCode(rs.getString("ZipCode"));
                person.setCountry(rs.getString("Country"));
                person.setCitizenship(rs.getString("Citizenship"));
                person.setSpecialtyDescription(rs.getString("SpecialtyDescription"));
                person.setOtherSpecialty(rs.getString("OtherSpecialty"));
                person.setOfficePhone(rs.getString("OfficePhone"));
                person.setOfficeFAX(rs.getString("OfficeFAX"));
                person.setHomePhone(rs.getString("HomePhone"));
                person.setCarPhone(rs.getString("CarPhone"));
                person.setFaxNumber(rs.getString("FaxNumber"));
                person.setPager(rs.getString("Pager"));
                person.setEmailAddress(rs.getString("EmailAddress"));
                person.setInternetPassword(rs.getString("InternetPassword"));
                person.setType(rs.getString("Type"));
                person.setPosition(rs.getString("Position"));
                person.setSocialSecurity(rs.getString("SocialSecurity"));
                person.setStateLicenseNumber(rs.getString("StateLicenseNumber"));
                person.setMedicaid(rs.getString("Medicaid"));
                person.setMedicareUPIN(rs.getString("MedicareUPIN"));
                person.setMedicarePIN(rs.getString("MedicarePIN"));
                person.setHospitalPIN(rs.getString("HospitalPIN"));
                person.setDEARegNumber(rs.getString("DEARegNumber"));
                person.setMalpracticePol(rs.getString("MalpracticePol#"));
                person.setSignatureImage(rs.getString("SignatureImage"));
                person.setUsername(rs.getString("Username"));
                person.setNameSuffix(rs.getString("NameSuffix"));
                person.setCreditCardIDInfo(rs.getString("CreditCardIDInfo"));
                person.setRelationshipToPatient(rs.getString("RelationshipToPatient"));
                person.setNationalProviderID(rs.getString("NationalProviderID"));
                person.setEmployerIDNumber(rs.getString("EmployerIDNumber"));
                person.setGender(rs.getString("Gender"));
                person.setStateControlledSubstanceNumber(rs.getString("StateControlledSubstanceNumber"));
                person.setComments(rs.getString("Comments"));
                person.setSuffix(rs.getString("Suffix"));
                person.setPersonId(rs.getInt("PersonId"));
                person.setProviderOrganizationID(rs.getInt("ProviderOrganizationID"));
                person.setSpecialtyID(rs.getInt("SpecialtyID"));
                person.setStaffID(rs.getInt("StaffID"));
                person.setPrimaryEmployerID(rs.getInt("PrimaryEmployerID"));
                person.setSecondaryEmployerID(rs.getInt("SecondaryEmployerID"));
                person.setOrganizationID(rs.getInt("OrganizationID"));
                person.setActive(rs.getByte("Active"));
                person.setDeleted(rs.getByte("deleted"));
                person.setHospiceEmployee(rs.getByte("HospiceEmployee"));
                person.setClaimSignatureAuth(rs.getByte("ClaimSignatureAuth"));
                person.setLicenseExpiration(rs.getDate("LicenseExpiration"));
                person.setDEAExpiration(rs.getDate("DEAExpiration"));
                person.setControlledSubstanceExpiration(rs.getDate("ControlledSubstanceExpiration"));
                person.setDOB(rs.getDate("DOB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return person;
    }

    public static Prescriptions getPrescriptions(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        Prescriptions prescrip = null;
        String query = "SELECT * FROM patientprescriptiontable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                prescrip = new Prescriptions();
                prescrip.setMedication(rs.getString("Medication"));
                prescrip.setPrescriptionQuantity(rs.getString("PrescriptionQuantity"));
                prescrip.setPrescriptionQuantityUnits(rs.getString("PrescriptionQuantityUnits"));
                prescrip.setRefillPeriod(rs.getString("RefillPeriod"));
                prescrip.setInstructions(rs.getString("Instructions"));
                prescrip.setPrescriptionMedsAmt(rs.getString("PrescriptionMedsAmt"));
                prescrip.setPrescriptionMedsUnit(rs.getString("PrescriptionMedsUnit"));
                prescrip.setPrescriptionID(rs.getInt("PrescriptionID"));
                prescrip.setCurrentMedicationID(rs.getInt("CurrentMedicationID"));
                prescrip.setPatientID(rs.getInt("PatientID"));
                prescrip.setRefills(rs.getInt("Refills"));
                prescrip.setPrescriptionHCP(rs.getInt("PrescriptionHCP"));
                prescrip.setPharmacyID(rs.getInt("PharmacyID"));
                prescrip.setGeneric(rs.getByte("Generic"));
                prescrip.setDeleted(rs.getByte("deleted"));
                prescrip.setPrescriptionDate(rs.getDate("PrescriptionDate"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return prescrip;
    }

    public static Therapy getTherapy(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        Therapy therapies = null;
        String query = "SELECT * FROM patienttherapiestable WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                therapies = new Therapy();
                therapies.setTherapyDescription(rs.getString("TherapyDescription"));
                therapies.setStartDate(rs.getDate("StartDate"));
                therapies.setEndDate(rs.getDate("EndDate"));
                therapies.setOutcome(rs.getString("Outcome"));
                therapies.setCertificationType(rs.getString("CertificationType"));
                therapies.setDuration(rs.getString("Duration"));
                therapies.setOrderDate(rs.getDate("OrderDate"));
                therapies.setO2FlowRate(rs.getString("O2FlowRate"));
                therapies.setTherapyID(rs.getInt("TherapyID"));
                therapies.setPatientID(rs.getInt("PatientID"));
                therapies.setEncounterID(rs.getInt("EncounterID"));
                therapies.setDeleted(rs.getByte("deleted"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return therapies;
    }

    public static VitalSigns getVitalSigns(int ID) {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null;

        VitalSigns vitals = null;
        String query = "SELECT * FROM vitalsigns WHERE PatientID=" + ID;
        try {
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            if (rs.next()) {
                vitals = new VitalSigns();
                vitals.setPresentation(rs.getString("Presentation"));
                vitals.setPretermLaborSigns(rs.getString("PretermLaborSigns"));
                vitals.setComments(rs.getString("Comments"));
                vitals.setVitalSignID(rs.getInt("VitalSignID"));
                vitals.setPatientID(rs.getInt("PatientID"));
                vitals.setCompleteGeneralSpecialistClinicID(rs.getInt("CompleteGeneralSpecialistClinicID"));
                vitals.setFetalMovement(rs.getInt("FetalMovement"));
                vitals.setWeeksGestation(rs.getDouble("WeeksGestation"));
                vitals.setFundalHeight(rs.getDouble("FundalHeight"));
                vitals.setFHR(rs.getDouble("FHR"));
                vitals.setCervixDilationLength(rs.getDouble("CervixDilationLength"));
                vitals.setDeleted(rs.getByte("deleted"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return vitals;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Methods to Update the database">
    public static void updateRecord(AllergyHistory allergyHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE allergyhistorytable SET "
                + " Allergen = ?, "
                + " AllergyDescription = ?, "
                + " AllergyEndDate = ?, "
                + " AllergyHRF = ?, "
                + " PatientID = ?, "
                + " AllergyStartDate = ?, "
                + " deleted = ? "
                + "WHERE AllergyID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, allergyHist.getAllergen());
            ps.setString(2, allergyHist.getAllergyDescription());
            ps.setString(3, allergyHist.getAllergyEndDate());
            ps.setByte(4, allergyHist.getAllergyHRF());
            ps.setInt(5, allergyHist.getPatientID());
            ps.setString(6, allergyHist.getAllergyStartDate());
            ps.setByte(7, allergyHist.getDeleted());
            ps.setInt(8, allergyHist.getAllergyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(FamilyHistory familyHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE familyhistorytable SET "
                + " PatientID = ?, "
                + " Name = ?, "
                + " Relation = ?, "
                + " Alive = ?, "
                + " `Lives with patient` = ?, "
                + " MajorDisorder = ?, "
                + " SpecificTypeDisorder = ?, "
                + " DisorderHRF = ?, "
                + " deleted = ? "
                + "WHERE FamilyID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, familyHist.getPatientID());
            ps.setString(2, familyHist.getName());
            ps.setString(3, familyHist.getRelation());
            ps.setByte(4, familyHist.getAlive());
            ps.setByte(5, familyHist.getLivesWithPatient());
            ps.setString(6, familyHist.getMajorDisorder());
            ps.setString(7, familyHist.getSpecificTypeDisorder());
            ps.setByte(8, familyHist.getDisorderHRF());
            ps.setByte(9, familyHist.getDeleted());
            ps.setInt(10, familyHist.getFamilyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(GeneralMedicalHistory generalMedicalHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE generalmedicalhistorytable SET "
                + " MaritalStatus = ?, "
                + " Education = ?, "
                + " GrowthAndDevelopment = ?, "
                + " Pregnancies = ?, "
                + " BehavioralHistory = ?, "
                + " Tobacco = ?, "
                + " TobaccoQuantity = ?, "
                + " Tobaccoduraton = ?, "
                + " Alcohol = ?, "
                + " AlcoholQuantity = ?, "
                + " Alcoholduration = ?, "
                + " Drug = ?, "
                + " DrugType = ?, "
                + " Drugduration = ?, "
                + " Dietary = ?, "
                + " Travel = ?, "
                + " BloodType = ?, "
                + " Rh = ?, "
                + " MedicalHistoryNotes = ?, "
                + " HxObtainedBy = ?, "
                + " UnableToObtainHxReason = ?, "
                + " LMPStatus = ?, "
                + " EDC = ?, "
                + " LMPEstMethod = ?, "
                + " MensesFreq = ?, "
                + " HospitalOfDelivery = ?, "
                + " EGA = ?, "
                + " PatientID = ?, "
                + " NumberOfChildren = ?, "
                + " NumberOfPregnancies = ?, "
                + " MenarcheAgeOfOnset = ?, "
                + " TobaccoHRF = ?, "
                + " AlcoholHRF = ?, "
                + " DrugHRF = ?, "
                + " DietHRF = ?, "
                + " TravelHRF = ?, "
                + " HxConfirmedByHCP = ?, "
                + " deleted = ?, "
                + " LMP = ?, "
                + " Pregnant = ?, "
                + " LMPDateApprox = ?, "
                + " MenstrualAmtNormalYes = ?, "
                + " MenstrualAmtNormalNo = ?, "
                + " MensesMonthlyYes = ?, "
                + " MensesMonthlyNo = ?, "
                + " OnBCPAtConceptionYes = ?, "
                + " OnBCPAtConceptionNo = ?, "
                + " LMPDate = ?, "
                + " PregnancyDueDate = ?, "
                + " MensesPriorDate = ? "
                + "WHERE GeneralMedicalHistoryID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, generalMedicalHist.getMaritalStatus());
            ps.setString(2, generalMedicalHist.getEducation());
            ps.setString(3, generalMedicalHist.getGrowthAndDevelopment());
            ps.setString(4, generalMedicalHist.getPregnancies());
            ps.setString(5, generalMedicalHist.getBehavioralHistory());
            ps.setString(6, generalMedicalHist.getTobacco());
            ps.setString(7, generalMedicalHist.getTobaccoQuantity());
            ps.setString(8, generalMedicalHist.getTobaccoduraton());
            ps.setString(9, generalMedicalHist.getAlcohol());
            ps.setString(10, generalMedicalHist.getAlcoholQuantity());
            ps.setString(11, generalMedicalHist.getAlcoholduration());
            ps.setString(12, generalMedicalHist.getDrug());
            ps.setString(13, generalMedicalHist.getDrugType());
            ps.setString(14, generalMedicalHist.getDrugduration());
            ps.setString(15, generalMedicalHist.getDietary());
            ps.setString(16, generalMedicalHist.getTravel());
            ps.setString(17, generalMedicalHist.getBloodType());
            ps.setString(18, generalMedicalHist.getRh());
            ps.setString(19, generalMedicalHist.getMedicalHistoryNotes());
            ps.setString(20, generalMedicalHist.getHxObtainedBy());
            ps.setString(21, generalMedicalHist.getUnableToObtainHxReason());
            ps.setString(22, generalMedicalHist.getLMPStatus());
            ps.setDate(23, generalMedicalHist.getEDC());
            ps.setString(24, generalMedicalHist.getLMPEstMethod());
            ps.setString(25, generalMedicalHist.getMensesFreq());
            ps.setString(26, generalMedicalHist.getHospitalOfDelivery());
            ps.setString(27, generalMedicalHist.getEGA());
            ps.setInt(28, generalMedicalHist.getPatientID());
            ps.setInt(29, generalMedicalHist.getNumberOfChildren());
            ps.setInt(30, generalMedicalHist.getNumberOfPregnancies());
            ps.setInt(31, generalMedicalHist.getMenarcheAgeOfOnset());
            ps.setByte(32, generalMedicalHist.getTobaccoHRF());
            ps.setByte(33, generalMedicalHist.getAlcoholHRF());
            ps.setByte(34, generalMedicalHist.getDrugHRF());
            ps.setByte(35, generalMedicalHist.getDietHRF());
            ps.setByte(36, generalMedicalHist.getTravelHRF());
            ps.setByte(37, generalMedicalHist.getHxConfirmedByHCP());
            ps.setByte(38, generalMedicalHist.getDeleted());
            ps.setByte(39, generalMedicalHist.getLMP());
            ps.setByte(40, generalMedicalHist.getPregnant());
            ps.setByte(41, generalMedicalHist.getLMPDateApprox());
            ps.setByte(42, generalMedicalHist.getMenstrualAmtNormalYes());
            ps.setByte(43, generalMedicalHist.getMenstrualAmtNormalNo());
            ps.setByte(44, generalMedicalHist.getMensesMonthlyYes());
            ps.setByte(45, generalMedicalHist.getMensesMonthlyNo());
            ps.setByte(46, generalMedicalHist.getOnBCPAtConceptionYes());
            ps.setByte(47, generalMedicalHist.getOnBCPAtConceptionNo());
            ps.setDate(48, generalMedicalHist.getLMPDate());
            ps.setDate(49, generalMedicalHist.getPregnancyDueDate());
            ps.setDate(50, generalMedicalHist.getMensesPriorDate());
            ps.setInt(51, generalMedicalHist.getGeneralMedicalHistoryID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(OccupationalHistory occupationalHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE occupationalhistorytable SET "
                + " Description = ?, "
                + " Causeofdisability = ?, "
                + " PatientID = ?, "
                + " Current = ?, "
                + " Disability = ?, "
                + " OccupationalHRF = ?, "
                + " deleted = ?, "
                + " StartDate = ?, "
                + " EndDate = ?, "
                + " LastWorkDate = ? "
                + "WHERE OccupationalID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, occupationalHist.getDescription());
            ps.setString(2, occupationalHist.getCauseofdisability());
            ps.setInt(3, occupationalHist.getPatientID());
            ps.setByte(4, occupationalHist.getCurrent());
            ps.setByte(5, occupationalHist.getDisability());
            ps.setByte(6, occupationalHist.getOccupationalHRF());
            ps.setByte(7, occupationalHist.getDeleted());
            ps.setDate(8, occupationalHist.getStartDate());
            ps.setDate(9, occupationalHist.getEndDate());
            ps.setDate(10, occupationalHist.getLastWorkDate());
            ps.setInt(11, occupationalHist.getOccupationalID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(IllnessHistory illnessHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE illnesshistorytable SET "
                + " IllnessDate = ?, "
                + " Illness = ?, "
                + " Resolution = ?, "
                + " IllnessID = ?, "
                + " PatientID = ?, "
                + " IllnessHRF = ?, "
                + " deleted = ? "
                + "WHERE IllnessID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setDate(1, illnessHist.getIllnessDate());
            ps.setString(2, illnessHist.getIllness());
            ps.setString(3, illnessHist.getResolution());
            ps.setInt(4, illnessHist.getIllnessID());
            ps.setInt(5, illnessHist.getPatientID());
            ps.setByte(6, illnessHist.getIllnessHRF());
            ps.setByte(7, illnessHist.getDeleted());
            ps.setInt(8, illnessHist.getIllnessID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(ImmunizationsHistory immuneHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE immunizationshistorytable SET "
                + " Vaccine = ?, "
                + " Delivery = ?, "
                + " Comments = ?, "
                + " PatientID = ?, "
                + " HCPId = ?, "
                + " deleted = ?, "
                + " ImmunizationDate = ?, "
                + " ExperationDate = ? "
                + "WHERE ImmunizationsID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, immuneHist.getVaccine());
            ps.setString(2, immuneHist.getDelivery());
            ps.setString(3, immuneHist.getComments());
            ps.setInt(4, immuneHist.getPatientID());
            ps.setInt(5, immuneHist.getHCPId());
            ps.setByte(6, immuneHist.getDeleted());
            ps.setDate(7, immuneHist.getImmunizationDate());
            ps.setDate(8, immuneHist.getExperationDate());
            ps.setInt(9, immuneHist.getImmunizationsID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(PastPregnancies pastPreg) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE pastpregnanciestable SET "
                + " PregnancyDate = ?, "
                + " LengthOfLabor = ?, "
                + " Sex = ?, "
                + " TypeOfDelivery = ?, "
                + " PlaceOfDelivery = ?, "
                + " Comments = ?, "
                + " Corionicity = ?, "
                + " EGAEstMethod = ?, "
                + " PatientID = ?, "
                + " NumberOfFetuses = ?, "
                + " EGA = ?, "
                + " BirthWeightLbs = ?, "
                + " BirthWeightOunces = ?, "
                + " PreTermLabor = ?, "
                + " deleted = ?, "
                + " Choncordant = ?, "
                + " TwinToTwinTransSyndrome = ?, "
                + " OnBCPAtConceptionYes = ?, "
                + " OnBCPAtConceptionNo = ?, "
                + " Current = ?, "
                + " LMP = ?, "
                + " EDD = ?, "
                + " DateStamp = ?, "
                + " EGACalculationDate = ? "
                + "WHERE PastPregnanciesID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setDate(1, pastPreg.getPregnancyDate());
            ps.setString(2, pastPreg.getLengthOfLabor());
            ps.setString(3, pastPreg.getSex());
            ps.setString(4, pastPreg.getTypeOfDelivery());
            ps.setString(5, pastPreg.getPlaceOfDelivery());
            ps.setString(6, pastPreg.getComments());
            ps.setString(7, pastPreg.getCorionicity());
            ps.setString(8, pastPreg.getEGAEstMethod());
            ps.setInt(9, pastPreg.getPatientID());
            ps.setInt(10, pastPreg.getNumberOfFetuses());
            ps.setDouble(11, pastPreg.getEGA());
            ps.setDouble(12, pastPreg.getBirthWeightLbs());
            ps.setDouble(13, pastPreg.getBirthWeightOunces());
            ps.setByte(14, pastPreg.getPreTermLabor());
            ps.setByte(15, pastPreg.getDeleted());
            ps.setByte(16, pastPreg.getChoncordant());
            ps.setByte(17, pastPreg.getTwinToTwinTransSyndrome());
            ps.setByte(18, pastPreg.getOnBCPAtConceptionYes());
            ps.setByte(19, pastPreg.getOnBCPAtConceptionNo());
            ps.setByte(20, pastPreg.getCurrent());
            ps.setDate(21, pastPreg.getLMP());
            ps.setDate(22, pastPreg.getEDD());
            ps.setDate(23, pastPreg.getDateStamp());
            ps.setDate(24, pastPreg.getEGACalculationDate());
            ps.setInt(25, pastPreg.getPastPregnanciesID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(Patient patient) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE patienttable SET "
                + " OldID = ?, "
                + " PtLastName = ?, "
                + " PtPreviousLastName = ?, "
                + " PtFirstName = ?, "
                + " HomeAddress1 = ?, "
                + " HomeAddress2 = ?, "
                + " HomeCity = ?, "
                + " `HomeState/Province/Region` = ?, "
                + " HomeZip = ?, "
                + " Country = ?, "
                + " Citizenship = ?, "
                + " PtHomePhone = ?, "
                + " EmergencyPhoneNumber = ?, "
                + " PtHomeFax = ?, "
                + " Pager = ?, "
                + " EmailAddress = ?, "
                + " `PtSS#` = ?, "
                + " Gender = ?, "
                + " EthnicAssociation = ?, "
                + " Religion = ?, "
                + " MaritalStatus = ?, "
                + " EmploymentStatus = ?, "
                + " `HospitalMR#` = ?, "
                + " Comments = ?, "
                + " BusinessPhone = ?, "
                + " BusinessFax = ?, "
                + " Updates = ?, "
                + " GroupName = ?, "
                + " SubscriberRelationship = ?, "
                + " UPID = ?, "
                + " PtMiddleInitial = ?, "
                + " NextOfKinRelationshipToPatient = ?, "
                + " Suffix = ?, "
                + " Referral = ?, "
                + " CurrentPrimaryHCPId = ?, "
                + " Specialist1 = ?, "
                + " Specialist2 = ?, "
                + " Specialist3 = ?, "
                + " Specialist4 = ?, "
                + " OriginalStaffHCP = ?, "
                + " CurrentStaffHCP = ?, "
                + " BillingAcctNumber = ?, "
                + " EmployerID = ?, "
                + " NextOfKinID = ?, "
                + " Active = ?, "
                + " deleted = ?, "
                + " NoticeOfPracticePrivacy = ?, "
                + " DOB = ?, "
                + " DateofExpire = ?, "
                + " DateEntered = ?, "
                + " NPPDate = ? "
                + "WHERE PatientID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, patient.getOldID());
            ps.setString(2, patient.getPtLastName());
            ps.setString(3, patient.getPtPreviousLastName());
            ps.setString(4, patient.getPtFirstName());
            ps.setString(5, patient.getHomeAddress1());
            ps.setString(6, patient.getHomeAddress2());
            ps.setString(7, patient.getHomeCity());
            ps.setString(8, patient.getHomeStateProvinceRegion());
            ps.setString(9, patient.getHomeZip());
            ps.setString(10, patient.getCountry());
            ps.setString(11, patient.getCitizenship());
            ps.setString(12, patient.getPtHomePhone());
            ps.setString(13, patient.getEmergencyPhoneNumber());
            ps.setString(14, patient.getPtHomeFax());
            ps.setString(15, patient.getPager());
            ps.setString(16, patient.getEmailAddress());
            ps.setString(17, patient.getPtSS());
            ps.setString(18, patient.getGender());
            ps.setString(19, patient.getEthnicAssociation());
            ps.setString(20, patient.getReligion());
            ps.setString(21, patient.getMaritalStatus());
            ps.setString(22, patient.getEmploymentStatus());
            ps.setString(23, patient.getHospitalMR());
            ps.setString(24, patient.getComments());
            ps.setString(25, patient.getBusinessPhone());
            ps.setString(26, patient.getBusinessFax());
            ps.setString(27, patient.getUpdates());
            ps.setString(28, patient.getGroupName());
            ps.setString(29, patient.getSubscriberRelationship());
            ps.setString(30, patient.getUPID());
            ps.setString(31, patient.getPtMiddleInitial());
            ps.setString(32, patient.getNextOfKinRelationshipToPatient());
            ps.setString(33, patient.getSuffix());
            ps.setInt(34, patient.getReferral());
            ps.setInt(35, patient.getCurrentPrimaryHCPId());
            ps.setInt(36, patient.getSpecialist1());
            ps.setInt(37, patient.getSpecialist2());
            ps.setInt(38, patient.getSpecialist3());
            ps.setInt(39, patient.getSpecialist4());
            ps.setInt(40, patient.getOriginalStaffHCP());
            ps.setInt(41, patient.getCurrentStaffHCP());
            ps.setInt(42, patient.getBillingAcctNumber());
            ps.setInt(43, patient.getEmployerID());
            ps.setInt(44, patient.getNextOfKinID());
            ps.setByte(45, patient.getActive());
            ps.setByte(46, patient.getDeleted());
            ps.setByte(47, patient.getNoticeOfPracticePrivacy());
            ps.setDate(48, patient.getDOB());
            ps.setDate(49, patient.getDateofExpire());
            ps.setDate(50, patient.getDateEntered());
            ps.setDate(51, patient.getNPPDate());
            ps.setInt(52, patient.getPatientID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean updateRecord(Person person) {
        boolean success = false;
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE persontable SET "
                + " OldID = ?, "
                + " PersonFirstName = ?, "
                + " PersonLastName = ?, "
                + " PersonMiddleName = ?, "
                + " PersonInitials = ?, "
                + " Title = ?, "
                + " Address1 = ?, "
                + " Address2 = ?, "
                + " GroupName = ?, "
                + " City = ?, "
                + " `State/Province/Region` = ?, "
                + " ZipCode = ?, "
                + " Country = ?, "
                + " Citizenship = ?, "
                + " SpecialtyDescription = ?, "
                + " OtherSpecialty = ?, "
                + " OfficePhone = ?, "
                + " OfficeFAX = ?, "
                + " HomePhone = ?, "
                + " CarPhone = ?, "
                + " FaxNumber = ?, "
                + " Pager = ?, "
                + " EmailAddress = ?, "
                + " InternetPassword = ?, "
                + " Type = ?, "
                + " Position = ?, "
                + " SocialSecurity = ?, "
                + " StateLicenseNumber = ?, "
                + " Medicaid = ?, "
                + " MedicareUPIN = ?, "
                + " MedicarePIN = ?, "
                + " HospitalPIN = ?, "
                + " DEARegNumber = ?, "
                + " `MalpracticePol#` = ?, "
                + " SignatureImage = ?, "
                + " Username = ?, "
                + " NameSuffix = ?, "
                + " CreditCardIDInfo = ?, "
                + " RelationshipToPatient = ?, "
                + " NationalProviderID = ?, "
                + " EmployerIDNumber = ?, "
                + " Gender = ?, "
                + " StateControlledSubstanceNumber = ?, "
                + " Comments = ?, "
                + " Suffix = ?, "
                + " ProviderOrganizationID = ?, "
                + " SpecialtyID = ?, "
                + " StaffID = ?, "
                + " PrimaryEmployerID = ?, "
                + " SecondaryEmployerID = ?, "
                + " OrganizationID = ?, "
                + " Active = ?, "
                + " deleted = ?, "
                + " HospiceEmployee = ?, "
                + " ClaimSignatureAuth = ?, "
                + " LicenseExpiration = ?, "
                + " DEAExpiration = ?, "
                + " ControlledSubstanceExpiration = ?, "
                + " DOB = ? "
                + "WHERE PersonId = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, person.getOldID());
            ps.setString(2, person.getPersonFirstName());
            ps.setString(3, person.getPersonLastName());
            ps.setString(4, person.getPersonMiddleName());
            ps.setString(5, person.getPersonInitials());
            ps.setString(6, person.getTitle());
            ps.setString(7, person.getAddress1());
            ps.setString(8, person.getAddress2());
            ps.setString(9, person.getGroupName());
            ps.setString(10, person.getCity());
            ps.setString(11, person.getStateProvinceRegion());
            ps.setString(12, person.getZipCode());
            ps.setString(13, person.getCountry());
            ps.setString(14, person.getCitizenship());
            ps.setString(15, person.getSpecialtyDescription());
            ps.setString(16, person.getOtherSpecialty());
            ps.setString(17, person.getOfficePhone());
            ps.setString(18, person.getOfficeFAX());
            ps.setString(19, person.getHomePhone());
            ps.setString(20, person.getCarPhone());
            ps.setString(21, person.getFaxNumber());
            ps.setString(22, person.getPager());
            ps.setString(23, person.getEmailAddress());
            ps.setString(24, person.getInternetPassword());
            ps.setString(25, person.getType());
            ps.setString(26, person.getPosition());
            ps.setString(27, person.getSocialSecurity());
            ps.setString(28, person.getStateLicenseNumber());
            ps.setString(29, person.getMedicaid());
            ps.setString(30, person.getMedicareUPIN());
            ps.setString(31, person.getMedicarePIN());
            ps.setString(32, person.getHospitalPIN());
            ps.setString(33, person.getDEARegNumber());
            ps.setString(34, person.getMalpracticePol());
            ps.setString(35, person.getSignatureImage());
            ps.setString(36, person.getUsername());
            ps.setString(37, person.getNameSuffix());
            ps.setString(38, person.getCreditCardIDInfo());
            ps.setString(39, person.getRelationshipToPatient());
            ps.setString(40, person.getNationalProviderID());
            ps.setString(41, person.getEmployerIDNumber());
            ps.setString(42, person.getGender());
            ps.setString(43, person.getStateControlledSubstanceNumber());
            ps.setString(44, person.getComments());
            ps.setString(45, person.getSuffix());
            ps.setInt(46, person.getProviderOrganizationID());
            ps.setInt(47, person.getSpecialtyID());
            ps.setInt(48, person.getStaffID());
            ps.setInt(49, person.getPrimaryEmployerID());
            ps.setInt(50, person.getSecondaryEmployerID());
            ps.setInt(51, person.getOrganizationID());
            ps.setByte(52, person.getActive());
            ps.setByte(53, person.getDeleted());
            ps.setByte(54, person.getHospiceEmployee());
            ps.setByte(55, person.getClaimSignatureAuth());
            ps.setDate(56, person.getLicenseExpiration());
            ps.setDate(57, person.getDEAExpiration());
            ps.setDate(58, person.getControlledSubstanceExpiration());
            ps.setDate(59, person.getDOB());
            ps.setInt(60, person.getPersonId());
            ps.executeUpdate();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public static void updateRecord(Prescriptions prescrip) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE patientprescriptiontable SET "
                + " Medication = ?, "
                + " PrescriptionQuantity = ?, "
                + " PrescriptionQuantityUnits = ?, "
                + " RefillPeriod = ?, "
                + " Instructions = ?, "
                + " PrescriptionMedsAmt = ?, "
                + " PrescriptionMedsUnit = ?, "
                + " CurrentMedicationID = ?, "
                + " PatientID = ?, "
                + " Refills = ?, "
                + " PrescriptionHCP = ?, "
                + " PharmacyID = ?, "
                + " Generic = ?, "
                + " deleted = ?, "
                + " PrescriptionDate = ? "
                + "WHERE PrescriptionID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, prescrip.getMedication());
            ps.setString(2, prescrip.getPrescriptionQuantity());
            ps.setString(3, prescrip.getPrescriptionQuantityUnits());
            ps.setString(4, prescrip.getRefillPeriod());
            ps.setString(5, prescrip.getInstructions());
            ps.setString(6, prescrip.getPrescriptionMedsAmt());
            ps.setString(7, prescrip.getPrescriptionMedsUnit());
            ps.setInt(8, prescrip.getCurrentMedicationID());
            ps.setInt(9, prescrip.getPatientID());
            ps.setInt(10, prescrip.getRefills());
            ps.setInt(11, prescrip.getPrescriptionHCP());
            ps.setInt(12, prescrip.getPharmacyID());
            ps.setByte(13, prescrip.getGeneric());
            ps.setByte(14, prescrip.getDeleted());
            ps.setDate(15, prescrip.getPrescriptionDate());
            ps.setInt(16, prescrip.getPrescriptionID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(Therapy therapies) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE patienttherapiestable SET "
                + " TherapyDescription = ?, "
                + " StartDate = ?, "
                + " EndDate = ?, "
                + " Outcome = ?, "
                + " CertificationType = ?, "
                + " Duration = ?, "
                + " OrderDate = ?, "
                + " O2FlowRate = ?, "
                + " PatientID = ?, "
                + " EncounterID = ?, "
                + " deleted = ? "
                + "WHERE TherapyID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, therapies.getTherapyDescription());
            ps.setDate(2, therapies.getStartDate());
            ps.setDate(3, therapies.getEndDate());
            ps.setString(4, therapies.getOutcome());
            ps.setString(5, therapies.getCertificationType());
            ps.setString(6, therapies.getDuration());
            ps.setDate(7, therapies.getOrderDate());
            ps.setString(8, therapies.getO2FlowRate());
            ps.setInt(9, therapies.getPatientID());
            ps.setInt(10, therapies.getEncounterID());
            ps.setByte(11, therapies.getDeleted());
            ps.setInt(12, therapies.getTherapyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateRecord(VitalSigns vitals) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE vitalsigns SET "
                + " Presentation = ?, "
                + " PretermLaborSigns = ?, "
                + " Comments = ?, "
                + " CompleteGeneralSpecialistClinicID = ?, "
                + " FetalMovement = ?, "
                + " WeeksGestation = ?, "
                + " FundalHeight = ?, "
                + " FHR = ?, "
                + " CervixDilationLength = ?, "
                + " deleted = ?, "
                + " PatientID = ? "
                + "WHERE VitalSignID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, vitals.getPresentation());
            ps.setString(2, vitals.getPretermLaborSigns());
            ps.setString(3, vitals.getComments());
            ps.setInt(4, vitals.getCompleteGeneralSpecialistClinicID());
            ps.setInt(5, vitals.getFetalMovement());
            ps.setDouble(6, vitals.getWeeksGestation());
            ps.setDouble(7, vitals.getFundalHeight());
            ps.setDouble(8, vitals.getFHR());
            ps.setDouble(9, vitals.getCervixDilationLength());
            ps.setByte(10, vitals.getDeleted());
            ps.setInt(11, vitals.getPatientID());
            ps.setInt(12, vitals.getVitalSignID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Methods for inserting into database">
    public static void insertRecord(AllergyHistory allergyHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO allergyhistorytable (Allergen, AllergyDescription, AllergyEndDate, AllergyHRF, PatientID, AllergyStartDate, deleted, AllergyID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, allergyHist.getAllergen());
            ps.setString(2, allergyHist.getAllergyDescription());
            ps.setString(3, allergyHist.getAllergyEndDate());
            ps.setByte(4, allergyHist.getAllergyHRF());
            ps.setInt(5, allergyHist.getPatientID());
            ps.setString(6, allergyHist.getAllergyStartDate());
            ps.setByte(7, allergyHist.getDeleted());
            ps.setInt(8, allergyHist.getAllergyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(FamilyHistory familyHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO familyhistorytable (PatientID, Name, Relation, Alive, `Lives with patient`, MajorDisorder, SpecificTypeDisorder, DisorderHRF, deleted, FamilyID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, familyHist.getPatientID());
            ps.setString(2, familyHist.getName());
            ps.setString(3, familyHist.getRelation());
            ps.setByte(4, familyHist.getAlive());
            ps.setByte(5, familyHist.getLivesWithPatient());
            ps.setString(6, familyHist.getMajorDisorder());
            ps.setString(7, familyHist.getSpecificTypeDisorder());
            ps.setByte(8, familyHist.getDisorderHRF());
            ps.setByte(9, familyHist.getDeleted());
            ps.setInt(10, familyHist.getFamilyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(GeneralMedicalHistory generalMedicalHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO generalmedicalhistorytable (MaritalStatus, Education, GrowthAndDevelopment, Pregnancies, BehavioralHistory, Tobacco, TobaccoQuantity, Tobaccoduraton, Alcohol, AlcoholQuantity, Alcoholduration, Drug, DrugType, Drugduration, Dietary, Travel, BloodType, Rh, MedicalHistoryNotes, HxObtainedBy, UnableToObtainHxReason, LMPStatus, EDC, LMPEstMethod, MensesFreq, HospitalOfDelivery, EGA, PatientID, NumberOfChildren, NumberOfPregnancies, MenarcheAgeOfOnset, TobaccoHRF, AlcoholHRF, DrugHRF, DietHRF, TravelHRF, HxConfirmedByHCP, deleted, LMP, Pregnant, LMPDateApprox, MenstrualAmtNormalYes, MenstrualAmtNormalNo, MensesMonthlyYes, MensesMonthlyNo, OnBCPAtConceptionYes, OnBCPAtConceptionNo, LMPDate, PregnancyDueDate, MensesPriorDate, GeneralMedicalHistoryID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, generalMedicalHist.getMaritalStatus());
            ps.setString(2, generalMedicalHist.getEducation());
            ps.setString(3, generalMedicalHist.getGrowthAndDevelopment());
            ps.setString(4, generalMedicalHist.getPregnancies());
            ps.setString(5, generalMedicalHist.getBehavioralHistory());
            ps.setString(6, generalMedicalHist.getTobacco());
            ps.setString(7, generalMedicalHist.getTobaccoQuantity());
            ps.setString(8, generalMedicalHist.getTobaccoduraton());
            ps.setString(9, generalMedicalHist.getAlcohol());
            ps.setString(10, generalMedicalHist.getAlcoholQuantity());
            ps.setString(11, generalMedicalHist.getAlcoholduration());
            ps.setString(12, generalMedicalHist.getDrug());
            ps.setString(13, generalMedicalHist.getDrugType());
            ps.setString(14, generalMedicalHist.getDrugduration());
            ps.setString(15, generalMedicalHist.getDietary());
            ps.setString(16, generalMedicalHist.getTravel());
            ps.setString(17, generalMedicalHist.getBloodType());
            ps.setString(18, generalMedicalHist.getRh());
            ps.setString(19, generalMedicalHist.getMedicalHistoryNotes());
            ps.setString(20, generalMedicalHist.getHxObtainedBy());
            ps.setString(21, generalMedicalHist.getUnableToObtainHxReason());
            ps.setString(22, generalMedicalHist.getLMPStatus());
            ps.setDate(23, generalMedicalHist.getEDC());
            ps.setString(24, generalMedicalHist.getLMPEstMethod());
            ps.setString(25, generalMedicalHist.getMensesFreq());
            ps.setString(26, generalMedicalHist.getHospitalOfDelivery());
            ps.setString(27, generalMedicalHist.getEGA());
            ps.setInt(28, generalMedicalHist.getPatientID());
            ps.setInt(29, generalMedicalHist.getNumberOfChildren());
            ps.setInt(30, generalMedicalHist.getNumberOfPregnancies());
            ps.setInt(31, generalMedicalHist.getMenarcheAgeOfOnset());
            ps.setByte(32, generalMedicalHist.getTobaccoHRF());
            ps.setByte(33, generalMedicalHist.getAlcoholHRF());
            ps.setByte(34, generalMedicalHist.getDrugHRF());
            ps.setByte(35, generalMedicalHist.getDietHRF());
            ps.setByte(36, generalMedicalHist.getTravelHRF());
            ps.setByte(37, generalMedicalHist.getHxConfirmedByHCP());
            ps.setByte(38, generalMedicalHist.getDeleted());
            ps.setByte(39, generalMedicalHist.getLMP());
            ps.setByte(40, generalMedicalHist.getPregnant());
            ps.setByte(41, generalMedicalHist.getLMPDateApprox());
            ps.setByte(42, generalMedicalHist.getMenstrualAmtNormalYes());
            ps.setByte(43, generalMedicalHist.getMenstrualAmtNormalNo());
            ps.setByte(44, generalMedicalHist.getMensesMonthlyYes());
            ps.setByte(45, generalMedicalHist.getMensesMonthlyNo());
            ps.setByte(46, generalMedicalHist.getOnBCPAtConceptionYes());
            ps.setByte(47, generalMedicalHist.getOnBCPAtConceptionNo());
            ps.setDate(48, generalMedicalHist.getLMPDate());
            ps.setDate(49, generalMedicalHist.getPregnancyDueDate());
            ps.setDate(50, generalMedicalHist.getMensesPriorDate());
            ps.setInt(51, generalMedicalHist.getGeneralMedicalHistoryID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(IllnessHistory illnessHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO illnesshistorytable (IllnessDate, Illness, Resolution, IllnessID, PatientID, IllnessHRF, deleted) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setDate(1, illnessHist.getIllnessDate());
            ps.setString(2, illnessHist.getIllness());
            ps.setString(3, illnessHist.getResolution());
            ps.setInt(4, illnessHist.getIllnessID());
            ps.setInt(5, illnessHist.getPatientID());
            ps.setByte(6, illnessHist.getIllnessHRF());
            ps.setByte(7, illnessHist.getDeleted());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(ImmunizationsHistory immuneHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO immunizationshistorytable (Vaccine, Delivery, Comments, PatientID, HCPId, deleted, ImmunizationDate, ExperationDate, ImmunizationsID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, immuneHist.getVaccine());
            ps.setString(2, immuneHist.getDelivery());
            ps.setString(3, immuneHist.getComments());
            ps.setInt(4, immuneHist.getPatientID());
            ps.setInt(5, immuneHist.getHCPId());
            ps.setByte(6, immuneHist.getDeleted());
            ps.setDate(7, immuneHist.getImmunizationDate());
            ps.setDate(8, immuneHist.getExperationDate());
            ps.setInt(9, immuneHist.getImmunizationsID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(OccupationalHistory occupationalHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO occupationalhistorytable (Description, Causeofdisability, PatientID, Current, Disability, OccupationalHRF, deleted, StartDate, EndDate, LastWorkDate, OccupationalID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, occupationalHist.getDescription());
            ps.setString(2, occupationalHist.getCauseofdisability());
            ps.setInt(3, occupationalHist.getPatientID());
            ps.setByte(4, occupationalHist.getCurrent());
            ps.setByte(5, occupationalHist.getDisability());
            ps.setByte(6, occupationalHist.getOccupationalHRF());
            ps.setByte(7, occupationalHist.getDeleted());
            ps.setDate(8, occupationalHist.getStartDate());
            ps.setDate(9, occupationalHist.getEndDate());
            ps.setDate(10, occupationalHist.getLastWorkDate());
            ps.setInt(11, occupationalHist.getOccupationalID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(PastPregnancies pastPreg) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO pastpregnanciestable (PregnancyDate, LengthOfLabor, Sex, TypeOfDelivery, PlaceOfDelivery, Comments, Corionicity, EGAEstMethod, PatientID, NumberOfFetuses, EGA, BirthWeightLbs, BirthWeightOunces, PreTermLabor, deleted, Choncordant, TwinToTwinTransSyndrome, OnBCPAtConceptionYes, OnBCPAtConceptionNo, Current, LMP, EDD, DateStamp, EGACalculationDate, PastPregnanciesID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setDate(1, pastPreg.getPregnancyDate());
            ps.setString(2, pastPreg.getLengthOfLabor());
            ps.setString(3, pastPreg.getSex());
            ps.setString(4, pastPreg.getTypeOfDelivery());
            ps.setString(5, pastPreg.getPlaceOfDelivery());
            ps.setString(6, pastPreg.getComments());
            ps.setString(7, pastPreg.getCorionicity());
            ps.setString(8, pastPreg.getEGAEstMethod());
            ps.setInt(9, pastPreg.getPatientID());
            ps.setInt(10, pastPreg.getNumberOfFetuses());
            ps.setDouble(11, pastPreg.getEGA());
            ps.setDouble(12, pastPreg.getBirthWeightLbs());
            ps.setDouble(13, pastPreg.getBirthWeightOunces());
            ps.setByte(14, pastPreg.getPreTermLabor());
            ps.setByte(15, pastPreg.getDeleted());
            ps.setByte(16, pastPreg.getChoncordant());
            ps.setByte(17, pastPreg.getTwinToTwinTransSyndrome());
            ps.setByte(18, pastPreg.getOnBCPAtConceptionYes());
            ps.setByte(19, pastPreg.getOnBCPAtConceptionNo());
            ps.setByte(20, pastPreg.getCurrent());
            ps.setDate(21, pastPreg.getLMP());
            ps.setDate(22, pastPreg.getEDD());
            ps.setDate(23, pastPreg.getDateStamp());
            ps.setDate(24, pastPreg.getEGACalculationDate());
            ps.setInt(25, pastPreg.getPastPregnanciesID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(Patient patient) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO patienttable (OldID, PtLastName, PtPreviousLastName, PtFirstName, HomeAddress1, HomeAddress2, HomeCity, `HomeState/Province/Region`, HomeZip, Country, Citizenship, PtHomePhone, EmergencyPhoneNumber, PtHomeFax, Pager, EmailAddress, `PtSS#`, Gender, EthnicAssociation, Religion, MaritalStatus, EmploymentStatus, `HospitalMR#`, Comments, BusinessPhone, BusinessFax, Updates, GroupName, SubscriberRelationship, UPID, PtMiddleInitial, NextOfKinRelationshipToPatient, Suffix, Referral, CurrentPrimaryHCPId, Specialist1, Specialist2, Specialist3, Specialist4, OriginalStaffHCP, CurrentStaffHCP, BillingAcctNumber, EmployerID, NextOfKinID, Active, deleted, NoticeOfPracticePrivacy, DOB, DateofExpire, DateEntered, NPPDate, PatientID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, patient.getOldID());
            ps.setString(2, patient.getPtLastName());
            ps.setString(3, patient.getPtPreviousLastName());
            ps.setString(4, patient.getPtFirstName());
            ps.setString(5, patient.getHomeAddress1());
            ps.setString(6, patient.getHomeAddress2());
            ps.setString(7, patient.getHomeCity());
            ps.setString(8, patient.getHomeStateProvinceRegion());
            ps.setString(9, patient.getHomeZip());
            ps.setString(10, patient.getCountry());
            ps.setString(11, patient.getCitizenship());
            ps.setString(12, patient.getPtHomePhone());
            ps.setString(13, patient.getEmergencyPhoneNumber());
            ps.setString(14, patient.getPtHomeFax());
            ps.setString(15, patient.getPager());
            ps.setString(16, patient.getEmailAddress());
            ps.setString(17, patient.getPtSS());
            ps.setString(18, patient.getGender());
            ps.setString(19, patient.getEthnicAssociation());
            ps.setString(20, patient.getReligion());
            ps.setString(21, patient.getMaritalStatus());
            ps.setString(22, patient.getEmploymentStatus());
            ps.setString(23, patient.getHospitalMR());
            ps.setString(24, patient.getComments());
            ps.setString(25, patient.getBusinessPhone());
            ps.setString(26, patient.getBusinessFax());
            ps.setString(27, patient.getUpdates());
            ps.setString(28, patient.getGroupName());
            ps.setString(29, patient.getSubscriberRelationship());
            ps.setString(30, patient.getUPID());
            ps.setString(31, patient.getPtMiddleInitial());
            ps.setString(32, patient.getNextOfKinRelationshipToPatient());
            ps.setString(33, patient.getSuffix());
            ps.setInt(34, patient.getReferral());
            ps.setInt(35, patient.getCurrentPrimaryHCPId());
            ps.setInt(36, patient.getSpecialist1());
            ps.setInt(37, patient.getSpecialist2());
            ps.setInt(38, patient.getSpecialist3());
            ps.setInt(39, patient.getSpecialist4());
            ps.setInt(40, patient.getOriginalStaffHCP());
            ps.setInt(41, patient.getCurrentStaffHCP());
            ps.setInt(42, patient.getBillingAcctNumber());
            ps.setInt(43, patient.getEmployerID());
            ps.setInt(44, patient.getNextOfKinID());
            ps.setByte(45, patient.getActive());
            ps.setByte(46, patient.getDeleted());
            ps.setByte(47, patient.getNoticeOfPracticePrivacy());
            ps.setDate(48, patient.getDOB());
            ps.setDate(49, patient.getDateofExpire());
            ps.setDate(50, patient.getDateEntered());
            ps.setDate(51, patient.getNPPDate());
            ps.setInt(52, patient.getPatientID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean insertRecord(Person person) {
        boolean success = false;
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO persontable (OldID, PersonFirstName, PersonLastName, PersonMiddleName, PersonInitials, Title, Address1, Address2, GroupName, City, `State/Province/Region`, ZipCode, Country, Citizenship, SpecialtyDescription, OtherSpecialty, OfficePhone, OfficeFAX, HomePhone, CarPhone, FaxNumber, Pager, EmailAddress, InternetPassword, Type, Position, SocialSecurity, StateLicenseNumber, Medicaid, MedicareUPIN, MedicarePIN, HospitalPIN, DEARegNumber, `MalpracticePol#`, SignatureImage, Username, NameSuffix, CreditCardIDInfo, RelationshipToPatient, NationalProviderID, EmployerIDNumber, Gender, StateControlledSubstanceNumber, Comments, Suffix, ProviderOrganizationID, SpecialtyID, StaffID, PrimaryEmployerID, SecondaryEmployerID, OrganizationID, Active, deleted, HospiceEmployee, ClaimSignatureAuth, LicenseExpiration, DEAExpiration, ControlledSubstanceExpiration, DOB, PersonId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, person.getOldID());
            ps.setString(2, person.getPersonFirstName());
            ps.setString(3, person.getPersonLastName());
            ps.setString(4, person.getPersonMiddleName());
            ps.setString(5, person.getPersonInitials());
            ps.setString(6, person.getTitle());
            ps.setString(7, person.getAddress1());
            ps.setString(8, person.getAddress2());
            ps.setString(9, person.getGroupName());
            ps.setString(10, person.getCity());
            ps.setString(11, person.getStateProvinceRegion());
            ps.setString(12, person.getZipCode());
            ps.setString(13, person.getCountry());
            ps.setString(14, person.getCitizenship());
            ps.setString(15, person.getSpecialtyDescription());
            ps.setString(16, person.getOtherSpecialty());
            ps.setString(17, person.getOfficePhone());
            ps.setString(18, person.getOfficeFAX());
            ps.setString(19, person.getHomePhone());
            ps.setString(20, person.getCarPhone());
            ps.setString(21, person.getFaxNumber());
            ps.setString(22, person.getPager());
            ps.setString(23, person.getEmailAddress());
            ps.setString(24, person.getInternetPassword());
            ps.setString(25, person.getType());
            ps.setString(26, person.getPosition());
            ps.setString(27, person.getSocialSecurity());
            ps.setString(28, person.getStateLicenseNumber());
            ps.setString(29, person.getMedicaid());
            ps.setString(30, person.getMedicareUPIN());
            ps.setString(31, person.getMedicarePIN());
            ps.setString(32, person.getHospitalPIN());
            ps.setString(33, person.getDEARegNumber());
            ps.setString(34, person.getMalpracticePol());
            ps.setString(35, person.getSignatureImage());
            ps.setString(36, person.getUsername());
            ps.setString(37, person.getNameSuffix());
            ps.setString(38, person.getCreditCardIDInfo());
            ps.setString(39, person.getRelationshipToPatient());
            ps.setString(40, person.getNationalProviderID());
            ps.setString(41, person.getEmployerIDNumber());
            ps.setString(42, person.getGender());
            ps.setString(43, person.getStateControlledSubstanceNumber());
            ps.setString(44, person.getComments());
            ps.setString(45, person.getSuffix());
            ps.setInt(46, person.getProviderOrganizationID());
            ps.setInt(47, person.getSpecialtyID());
            ps.setInt(48, person.getStaffID());
            ps.setInt(49, person.getPrimaryEmployerID());
            ps.setInt(50, person.getSecondaryEmployerID());
            ps.setInt(51, person.getOrganizationID());
            ps.setByte(52, person.getActive());
            ps.setByte(53, person.getDeleted());
            ps.setByte(54, person.getHospiceEmployee());
            ps.setByte(55, person.getClaimSignatureAuth());
            ps.setDate(56, person.getLicenseExpiration());
            ps.setDate(57, person.getDEAExpiration());
            ps.setDate(58, person.getControlledSubstanceExpiration());
            ps.setDate(59, person.getDOB());
            ps.setInt(60, person.getPersonId());
            ps.executeUpdate();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public static void insertRecord(Prescriptions prescrip) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO patientprescriptiontable (Medication, PrescriptionQuantity, PrescriptionQuantityUnits, RefillPeriod, Instructions, PrescriptionMedsAmt, PrescriptionMedsUnit, CurrentMedicationID, PatientID, Refills, PrescriptionHCP, PharmacyID, Generic, deleted, PrescriptionDate, PrescriptionID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, prescrip.getMedication());
            ps.setString(2, prescrip.getPrescriptionQuantity());
            ps.setString(3, prescrip.getPrescriptionQuantityUnits());
            ps.setString(4, prescrip.getRefillPeriod());
            ps.setString(5, prescrip.getInstructions());
            ps.setString(6, prescrip.getPrescriptionMedsAmt());
            ps.setString(7, prescrip.getPrescriptionMedsUnit());
            ps.setInt(8, prescrip.getCurrentMedicationID());
            ps.setInt(9, prescrip.getPatientID());
            ps.setInt(10, prescrip.getRefills());
            ps.setInt(11, prescrip.getPrescriptionHCP());
            ps.setInt(12, prescrip.getPharmacyID());
            ps.setByte(13, prescrip.getGeneric());
            ps.setByte(14, prescrip.getDeleted());
            ps.setDate(15, prescrip.getPrescriptionDate());
            ps.setInt(16, prescrip.getPrescriptionID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(Therapy therapies) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO patienttherapiestable (TherapyDescription, StartDate, EndDate, Outcome, CertificationType, Duration, OrderDate, O2FlowRate, PatientID, EncounterID, deleted, TherapyID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, therapies.getTherapyDescription());
            ps.setDate(2, therapies.getStartDate());
            ps.setDate(3, therapies.getEndDate());
            ps.setString(4, therapies.getOutcome());
            ps.setString(5, therapies.getCertificationType());
            ps.setString(6, therapies.getDuration());
            ps.setDate(7, therapies.getOrderDate());
            ps.setString(8, therapies.getO2FlowRate());
            ps.setInt(9, therapies.getPatientID());
            ps.setInt(10, therapies.getEncounterID());
            ps.setByte(11, therapies.getDeleted());
            ps.setInt(12, therapies.getTherapyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertRecord(VitalSigns vitals) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO vitalsigns (Presentation, PretermLaborSigns, Comments, CompleteGeneralSpecialistClinicID, FetalMovement, WeeksGestation, FundalHeight, FHR, CervixDilationLength, deleted, PatientID, VitalSignID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, vitals.getPresentation());
            ps.setString(2, vitals.getPretermLaborSigns());
            ps.setString(3, vitals.getComments());
            ps.setInt(4, vitals.getCompleteGeneralSpecialistClinicID());
            ps.setInt(5, vitals.getFetalMovement());
            ps.setDouble(6, vitals.getWeeksGestation());
            ps.setDouble(7, vitals.getFundalHeight());
            ps.setDouble(8, vitals.getFHR());
            ps.setDouble(9, vitals.getCervixDilationLength());
            ps.setByte(10, vitals.getDeleted());
            ps.setInt(11, vitals.getPatientID());
            ps.setInt(12, vitals.getVitalSignID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Methods for deleting records by changing the `deleted` field to true">
    public static void deleteRecord(AllergyHistory allergyHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE allergyhistorytable SET "
                + " Allergen = ?, "
                + " AllergyDescription = ?, "
                + " AllergyEndDate = ?, "
                + " AllergyHRF = ?, "
                + " PatientID = ?, "
                + " AllergyStartDate = ?, "
                + " deleted = ? "
                + "WHERE AllergyID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, allergyHist.getAllergen());
            ps.setString(2, allergyHist.getAllergyDescription());
            ps.setString(3, allergyHist.getAllergyEndDate());
            ps.setByte(4, allergyHist.getAllergyHRF());
            ps.setInt(5, allergyHist.getPatientID());
            ps.setString(6, allergyHist.getAllergyStartDate());
            ps.setByte(7, (byte) 1);
            ps.setInt(8, allergyHist.getAllergyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(FamilyHistory familyHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE familyhistorytable SET "
                + " PatientID = ?, "
                + " Name = ?, "
                + " Relation = ?, "
                + " Alive = ?, "
                + " `Lives with patient` = ?, "
                + " MajorDisorder = ?, "
                + " SpecificTypeDisorder = ?, "
                + " DisorderHRF = ?, "
                + " deleted = ? "
                + "WHERE FamilyID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, familyHist.getPatientID());
            ps.setString(2, familyHist.getName());
            ps.setString(3, familyHist.getRelation());
            ps.setByte(4, familyHist.getAlive());
            ps.setByte(5, familyHist.getLivesWithPatient());
            ps.setString(6, familyHist.getMajorDisorder());
            ps.setString(7, familyHist.getSpecificTypeDisorder());
            ps.setByte(8, familyHist.getDisorderHRF());
            ps.setByte(9, (byte) 1);
            ps.setInt(10, familyHist.getFamilyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(GeneralMedicalHistory generalMedicalHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE  SET "
                + " MaritalStatus = ?, "
                + " Education = ?, "
                + " GrowthAndDevelopment = ?, "
                + " Pregnancies = ?, "
                + " BehavioralHistory = ?, "
                + " Tobacco = ?, "
                + " TobaccoQuantity = ?, "
                + " Tobaccoduraton = ?, "
                + " Alcohol = ?, "
                + " AlcoholQuantity = ?, "
                + " Alcoholduration = ?, "
                + " Drug = ?, "
                + " DrugType = ?, "
                + " Drugduration = ?, "
                + " Dietary = ?, "
                + " Travel = ?, "
                + " BloodType = ?, "
                + " Rh = ?, "
                + " MedicalHistoryNotes = ?, "
                + " HxObtainedBy = ?, "
                + " UnableToObtainHxReason = ?, "
                + " LMPStatus = ?, "
                + " EDC = ?, "
                + " LMPEstMethod = ?, "
                + " MensesFreq = ?, "
                + " HospitalOfDelivery = ?, "
                + " EGA = ?, "
                + " PatientID = ?, "
                + " NumberOfChildren = ?, "
                + " NumberOfPregnancies = ?, "
                + " MenarcheAgeOfOnset = ?, "
                + " TobaccoHRF = ?, "
                + " AlcoholHRF = ?, "
                + " DrugHRF = ?, "
                + " DietHRF = ?, "
                + " TravelHRF = ?, "
                + " HxConfirmedByHCP = ?, "
                + " deleted = ?, "
                + " LMP = ?, "
                + " Pregnant = ?, "
                + " LMPDateApprox = ?, "
                + " MenstrualAmtNormalYes = ?, "
                + " MenstrualAmtNormalNo = ?, "
                + " MensesMonthlyYes = ?, "
                + " MensesMonthlyNo = ?, "
                + " OnBCPAtConceptionYes = ?, "
                + " OnBCPAtConceptionNo = ?, "
                + " LMPDate = ?, "
                + " PregnancyDueDate = ?, "
                + " MensesPriorDate = ? "
                + "WHERE GeneralMedicalHistoryID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, generalMedicalHist.getMaritalStatus());
            ps.setString(2, generalMedicalHist.getEducation());
            ps.setString(3, generalMedicalHist.getGrowthAndDevelopment());
            ps.setString(4, generalMedicalHist.getPregnancies());
            ps.setString(5, generalMedicalHist.getBehavioralHistory());
            ps.setString(6, generalMedicalHist.getTobacco());
            ps.setString(7, generalMedicalHist.getTobaccoQuantity());
            ps.setString(8, generalMedicalHist.getTobaccoduraton());
            ps.setString(9, generalMedicalHist.getAlcohol());
            ps.setString(10, generalMedicalHist.getAlcoholQuantity());
            ps.setString(11, generalMedicalHist.getAlcoholduration());
            ps.setString(12, generalMedicalHist.getDrug());
            ps.setString(13, generalMedicalHist.getDrugType());
            ps.setString(14, generalMedicalHist.getDrugduration());
            ps.setString(15, generalMedicalHist.getDietary());
            ps.setString(16, generalMedicalHist.getTravel());
            ps.setString(17, generalMedicalHist.getBloodType());
            ps.setString(18, generalMedicalHist.getRh());
            ps.setString(19, generalMedicalHist.getMedicalHistoryNotes());
            ps.setString(20, generalMedicalHist.getHxObtainedBy());
            ps.setString(21, generalMedicalHist.getUnableToObtainHxReason());
            ps.setString(22, generalMedicalHist.getLMPStatus());
            ps.setDate(23, generalMedicalHist.getEDC());
            ps.setString(24, generalMedicalHist.getLMPEstMethod());
            ps.setString(25, generalMedicalHist.getMensesFreq());
            ps.setString(26, generalMedicalHist.getHospitalOfDelivery());
            ps.setString(27, generalMedicalHist.getEGA());
            ps.setInt(28, generalMedicalHist.getPatientID());
            ps.setInt(29, generalMedicalHist.getNumberOfChildren());
            ps.setInt(30, generalMedicalHist.getNumberOfPregnancies());
            ps.setInt(31, generalMedicalHist.getMenarcheAgeOfOnset());
            ps.setByte(32, generalMedicalHist.getTobaccoHRF());
            ps.setByte(33, generalMedicalHist.getAlcoholHRF());
            ps.setByte(34, generalMedicalHist.getDrugHRF());
            ps.setByte(35, generalMedicalHist.getDietHRF());
            ps.setByte(36, generalMedicalHist.getTravelHRF());
            ps.setByte(37, generalMedicalHist.getHxConfirmedByHCP());
            ps.setByte(38, (byte) 1);
            ps.setByte(39, generalMedicalHist.getLMP());
            ps.setByte(40, generalMedicalHist.getPregnant());
            ps.setByte(41, generalMedicalHist.getLMPDateApprox());
            ps.setByte(42, generalMedicalHist.getMenstrualAmtNormalYes());
            ps.setByte(43, generalMedicalHist.getMenstrualAmtNormalNo());
            ps.setByte(44, generalMedicalHist.getMensesMonthlyYes());
            ps.setByte(45, generalMedicalHist.getMensesMonthlyNo());
            ps.setByte(46, generalMedicalHist.getOnBCPAtConceptionYes());
            ps.setByte(47, generalMedicalHist.getOnBCPAtConceptionNo());
            ps.setDate(48, generalMedicalHist.getLMPDate());
            ps.setDate(49, generalMedicalHist.getPregnancyDueDate());
            ps.setDate(50, generalMedicalHist.getMensesPriorDate());
            ps.setInt(51, generalMedicalHist.getGeneralMedicalHistoryID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(OccupationalHistory occupationalHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE occupationalhistorytable SET "
                + " Description = ?, "
                + " Causeofdisability = ?, "
                + " PatientID = ?, "
                + " Current = ?, "
                + " Disability = ?, "
                + " OccupationalHRF = ?, "
                + " deleted = ?, "
                + " StartDate = ?, "
                + " EndDate = ?, "
                + " LastWorkDate = ? "
                + "WHERE OccupationalID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, occupationalHist.getDescription());
            ps.setString(2, occupationalHist.getCauseofdisability());
            ps.setInt(3, occupationalHist.getPatientID());
            ps.setByte(4, occupationalHist.getCurrent());
            ps.setByte(5, occupationalHist.getDisability());
            ps.setByte(6, occupationalHist.getOccupationalHRF());
            ps.setByte(7, (byte) 1);
            ps.setDate(8, occupationalHist.getStartDate());
            ps.setDate(9, occupationalHist.getEndDate());
            ps.setDate(10, occupationalHist.getLastWorkDate());
            ps.setInt(11, occupationalHist.getOccupationalID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(IllnessHistory illnessHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE illnesshistorytable SET "
                + " IllnessDate = ?, "
                + " Illness = ?, "
                + " Resolution = ?, "
                + " IllnessID = ?, "
                + " PatientID = ?, "
                + " IllnessHRF = ?, "
                + " deleted = ? "
                + "WHERE IllnessID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setDate(1, illnessHist.getIllnessDate());
            ps.setString(2, illnessHist.getIllness());
            ps.setString(3, illnessHist.getResolution());
            ps.setInt(4, illnessHist.getIllnessID());
            ps.setInt(5, illnessHist.getPatientID());
            ps.setByte(6, illnessHist.getIllnessHRF());
            ps.setByte(7, (byte) 1);
            ps.setInt(8, illnessHist.getIllnessID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(ImmunizationsHistory immuneHist) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE immunizationshistorytable SET "
                + " Vaccine = ?, "
                + " Delivery = ?, "
                + " Comments = ?, "
                + " PatientID = ?, "
                + " HCPId = ?, "
                + " deleted = ?, "
                + " ImmunizationDate = ?, "
                + " ExperationDate = ? "
                + "WHERE ImmunizationsID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, immuneHist.getVaccine());
            ps.setString(2, immuneHist.getDelivery());
            ps.setString(3, immuneHist.getComments());
            ps.setInt(4, immuneHist.getPatientID());
            ps.setInt(5, immuneHist.getHCPId());
            ps.setByte(6, (byte) 1);
            ps.setDate(7, immuneHist.getImmunizationDate());
            ps.setDate(8, immuneHist.getExperationDate());
            ps.setInt(9, immuneHist.getImmunizationsID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(PastPregnancies pastPreg) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE pastpregnanciestable SET "
                + " PregnancyDate = ?, "
                + " LengthOfLabor = ?, "
                + " Sex = ?, "
                + " TypeOfDelivery = ?, "
                + " PlaceOfDelivery = ?, "
                + " Comments = ?, "
                + " Corionicity = ?, "
                + " EGAEstMethod = ?, "
                + " PatientID = ?, "
                + " NumberOfFetuses = ?, "
                + " EGA = ?, "
                + " BirthWeightLbs = ?, "
                + " BirthWeightOunces = ?, "
                + " PreTermLabor = ?, "
                + " deleted = ?, "
                + " Choncordant = ?, "
                + " TwinToTwinTransSyndrome = ?, "
                + " OnBCPAtConceptionYes = ?, "
                + " OnBCPAtConceptionNo = ?, "
                + " Current = ?, "
                + " LMP = ?, "
                + " EDD = ?, "
                + " DateStamp = ?, "
                + " EGACalculationDate = ? "
                + "WHERE PastPregnanciesID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setDate(1, pastPreg.getPregnancyDate());
            ps.setString(2, pastPreg.getLengthOfLabor());
            ps.setString(3, pastPreg.getSex());
            ps.setString(4, pastPreg.getTypeOfDelivery());
            ps.setString(5, pastPreg.getPlaceOfDelivery());
            ps.setString(6, pastPreg.getComments());
            ps.setString(7, pastPreg.getCorionicity());
            ps.setString(8, pastPreg.getEGAEstMethod());
            ps.setInt(9, pastPreg.getPatientID());
            ps.setInt(10, pastPreg.getNumberOfFetuses());
            ps.setDouble(11, pastPreg.getEGA());
            ps.setDouble(12, pastPreg.getBirthWeightLbs());
            ps.setDouble(13, pastPreg.getBirthWeightOunces());
            ps.setByte(14, pastPreg.getPreTermLabor());
            ps.setByte(15, (byte) 1);
            ps.setByte(16, pastPreg.getChoncordant());
            ps.setByte(17, pastPreg.getTwinToTwinTransSyndrome());
            ps.setByte(18, pastPreg.getOnBCPAtConceptionYes());
            ps.setByte(19, pastPreg.getOnBCPAtConceptionNo());
            ps.setByte(20, pastPreg.getCurrent());
            ps.setDate(21, pastPreg.getLMP());
            ps.setDate(22, pastPreg.getEDD());
            ps.setDate(23, pastPreg.getDateStamp());
            ps.setDate(24, pastPreg.getEGACalculationDate());
            ps.setInt(25, pastPreg.getPastPregnanciesID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(Patient patient) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE patienttable SET "
                + " OldID = ?, "
                + " PtLastName = ?, "
                + " PtPreviousLastName = ?, "
                + " PtFirstName = ?, "
                + " HomeAddress1 = ?, "
                + " HomeAddress2 = ?, "
                + " HomeCity = ?, "
                + " `HomeState/Province/Region` = ?, "
                + " HomeZip = ?, "
                + " Country = ?, "
                + " Citizenship = ?, "
                + " PtHomePhone = ?, "
                + " EmergencyPhoneNumber = ?, "
                + " PtHomeFax = ?, "
                + " Pager = ?, "
                + " EmailAddress = ?, "
                + " `PtSS#` = ?, "
                + " Gender = ?, "
                + " EthnicAssociation = ?, "
                + " Religion = ?, "
                + " MaritalStatus = ?, "
                + " EmploymentStatus = ?, "
                + " `HospitalMR#` = ?, "
                + " Comments = ?, "
                + " BusinessPhone = ?, "
                + " BusinessFax = ?, "
                + " Updates = ?, "
                + " GroupName = ?, "
                + " SubscriberRelationship = ?, "
                + " UPID = ?, "
                + " PtMiddleInitial = ?, "
                + " NextOfKinRelationshipToPatient = ?, "
                + " Suffix = ?, "
                + " Referral = ?, "
                + " CurrentPrimaryHCPId = ?, "
                + " Specialist1 = ?, "
                + " Specialist2 = ?, "
                + " Specialist3 = ?, "
                + " Specialist4 = ?, "
                + " OriginalStaffHCP = ?, "
                + " CurrentStaffHCP = ?, "
                + " BillingAcctNumber = ?, "
                + " EmployerID = ?, "
                + " NextOfKinID = ?, "
                + " Active = ?, "
                + " deleted = ?, "
                + " NoticeOfPracticePrivacy = ?, "
                + " DOB = ?, "
                + " DateofExpire = ?, "
                + " DateEntered = ?, "
                + " NPPDate = ? "
                + "WHERE PatientID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, patient.getOldID());
            ps.setString(2, patient.getPtLastName());
            ps.setString(3, patient.getPtPreviousLastName());
            ps.setString(4, patient.getPtFirstName());
            ps.setString(5, patient.getHomeAddress1());
            ps.setString(6, patient.getHomeAddress2());
            ps.setString(7, patient.getHomeCity());
            ps.setString(8, patient.getHomeStateProvinceRegion());
            ps.setString(9, patient.getHomeZip());
            ps.setString(10, patient.getCountry());
            ps.setString(11, patient.getCitizenship());
            ps.setString(12, patient.getPtHomePhone());
            ps.setString(13, patient.getEmergencyPhoneNumber());
            ps.setString(14, patient.getPtHomeFax());
            ps.setString(15, patient.getPager());
            ps.setString(16, patient.getEmailAddress());
            ps.setString(17, patient.getPtSS());
            ps.setString(18, patient.getGender());
            ps.setString(19, patient.getEthnicAssociation());
            ps.setString(20, patient.getReligion());
            ps.setString(21, patient.getMaritalStatus());
            ps.setString(22, patient.getEmploymentStatus());
            ps.setString(23, patient.getHospitalMR());
            ps.setString(24, patient.getComments());
            ps.setString(25, patient.getBusinessPhone());
            ps.setString(26, patient.getBusinessFax());
            ps.setString(27, patient.getUpdates());
            ps.setString(28, patient.getGroupName());
            ps.setString(29, patient.getSubscriberRelationship());
            ps.setString(30, patient.getUPID());
            ps.setString(31, patient.getPtMiddleInitial());
            ps.setString(32, patient.getNextOfKinRelationshipToPatient());
            ps.setString(33, patient.getSuffix());
            ps.setInt(34, patient.getReferral());
            ps.setInt(35, patient.getCurrentPrimaryHCPId());
            ps.setInt(36, patient.getSpecialist1());
            ps.setInt(37, patient.getSpecialist2());
            ps.setInt(38, patient.getSpecialist3());
            ps.setInt(39, patient.getSpecialist4());
            ps.setInt(40, patient.getOriginalStaffHCP());
            ps.setInt(41, patient.getCurrentStaffHCP());
            ps.setInt(42, patient.getBillingAcctNumber());
            ps.setInt(43, patient.getEmployerID());
            ps.setInt(44, patient.getNextOfKinID());
            ps.setByte(45, patient.getActive());
            ps.setByte(46, (byte) 1);
            ps.setByte(47, patient.getNoticeOfPracticePrivacy());
            ps.setDate(48, patient.getDOB());
            ps.setDate(49, patient.getDateofExpire());
            ps.setDate(50, patient.getDateEntered());
            ps.setDate(51, patient.getNPPDate());
            ps.setInt(52, patient.getPatientID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(Person person) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE persontable SET "
                + " OldID = ?, "
                + " PersonFirstName = ?, "
                + " PersonLastName = ?, "
                + " PersonMiddleName = ?, "
                + " PersonInitials = ?, "
                + " Title = ?, "
                + " Address1 = ?, "
                + " Address2 = ?, "
                + " GroupName = ?, "
                + " City = ?, "
                + " `State/Province/Region` = ?, "
                + " ZipCode = ?, "
                + " Country = ?, "
                + " Citizenship = ?, "
                + " SpecialtyDescription = ?, "
                + " OtherSpecialty = ?, "
                + " OfficePhone = ?, "
                + " OfficeFAX = ?, "
                + " HomePhone = ?, "
                + " CarPhone = ?, "
                + " FaxNumber = ?, "
                + " Pager = ?, "
                + " EmailAddress = ?, "
                + " InternetPassword = ?, "
                + " Type = ?, "
                + " Position = ?, "
                + " SocialSecurity = ?, "
                + " StateLicenseNumber = ?, "
                + " Medicaid = ?, "
                + " MedicareUPIN = ?, "
                + " MedicarePIN = ?, "
                + " HospitalPIN = ?, "
                + " DEARegNumber = ?, "
                + " MalpracticePol# = ?, "
                + " SignatureImage = ?, "
                + " Username = ?, "
                + " NameSuffix = ?, "
                + " CreditCardIDInfo = ?, "
                + " RelationshipToPatient = ?, "
                + " NationalProviderID = ?, "
                + " EmployerIDNumber = ?, "
                + " Gender = ?, "
                + " StateControlledSubstanceNumber = ?, "
                + " Comments = ?, "
                + " Suffix = ?, "
                + " ProviderOrganizationID = ?, "
                + " SpecialtyID = ?, "
                + " StaffID = ?, "
                + " PrimaryEmployerID = ?, "
                + " SecondaryEmployerID = ?, "
                + " OrganizationID = ?, "
                + " Active = ?, "
                + " deleted = ?, "
                + " HospiceEmployee = ?, "
                + " ClaimSignatureAuth = ?, "
                + " LicenseExpiration = ?, "
                + " DEAExpiration = ?, "
                + " ControlledSubstanceExpiration = ?, "
                + " DOB = ? "
                + "WHERE PersonId = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, person.getOldID());
            ps.setString(2, person.getPersonFirstName());
            ps.setString(3, person.getPersonLastName());
            ps.setString(4, person.getPersonMiddleName());
            ps.setString(5, person.getPersonInitials());
            ps.setString(6, person.getTitle());
            ps.setString(7, person.getAddress1());
            ps.setString(8, person.getAddress2());
            ps.setString(9, person.getGroupName());
            ps.setString(10, person.getCity());
            ps.setString(11, person.getStateProvinceRegion());
            ps.setString(12, person.getZipCode());
            ps.setString(13, person.getCountry());
            ps.setString(14, person.getCitizenship());
            ps.setString(15, person.getSpecialtyDescription());
            ps.setString(16, person.getOtherSpecialty());
            ps.setString(17, person.getOfficePhone());
            ps.setString(18, person.getOfficeFAX());
            ps.setString(19, person.getHomePhone());
            ps.setString(20, person.getCarPhone());
            ps.setString(21, person.getFaxNumber());
            ps.setString(22, person.getPager());
            ps.setString(23, person.getEmailAddress());
            ps.setString(24, person.getInternetPassword());
            ps.setString(25, person.getType());
            ps.setString(26, person.getPosition());
            ps.setString(27, person.getSocialSecurity());
            ps.setString(28, person.getStateLicenseNumber());
            ps.setString(29, person.getMedicaid());
            ps.setString(30, person.getMedicareUPIN());
            ps.setString(31, person.getMedicarePIN());
            ps.setString(32, person.getHospitalPIN());
            ps.setString(33, person.getDEARegNumber());
            ps.setString(34, person.getMalpracticePol());
            ps.setString(35, person.getSignatureImage());
            ps.setString(36, person.getUsername());
            ps.setString(37, person.getNameSuffix());
            ps.setString(38, person.getCreditCardIDInfo());
            ps.setString(39, person.getRelationshipToPatient());
            ps.setString(40, person.getNationalProviderID());
            ps.setString(41, person.getEmployerIDNumber());
            ps.setString(42, person.getGender());
            ps.setString(43, person.getStateControlledSubstanceNumber());
            ps.setString(44, person.getComments());
            ps.setString(45, person.getSuffix());
            ps.setInt(46, person.getProviderOrganizationID());
            ps.setInt(47, person.getSpecialtyID());
            ps.setInt(48, person.getStaffID());
            ps.setInt(49, person.getPrimaryEmployerID());
            ps.setInt(50, person.getSecondaryEmployerID());
            ps.setInt(51, person.getOrganizationID());
            ps.setByte(52, person.getActive());
            ps.setByte(53, (byte) 1);
            ps.setByte(54, person.getHospiceEmployee());
            ps.setByte(55, person.getClaimSignatureAuth());
            ps.setDate(56, person.getLicenseExpiration());
            ps.setDate(57, person.getDEAExpiration());
            ps.setDate(58, person.getControlledSubstanceExpiration());
            ps.setDate(59, person.getDOB());
            ps.setInt(60, person.getPersonId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(Prescriptions prescrip) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE patientprescriptiontable SET "
                + " Medication = ?, "
                + " PrescriptionQuantity = ?, "
                + " PrescriptionQuantityUnits = ?, "
                + " RefillPeriod = ?, "
                + " Instructions = ?, "
                + " PrescriptionMedsAmt = ?, "
                + " PrescriptionMedsUnit = ?, "
                + " CurrentMedicationID = ?, "
                + " PatientID = ?, "
                + " Refills = ?, "
                + " PrescriptionHCP = ?, "
                + " PharmacyID = ?, "
                + " Generic = ?, "
                + " deleted = ?, "
                + " PrescriptionDate = ? "
                + "WHERE PrescriptionID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, prescrip.getMedication());
            ps.setString(2, prescrip.getPrescriptionQuantity());
            ps.setString(3, prescrip.getPrescriptionQuantityUnits());
            ps.setString(4, prescrip.getRefillPeriod());
            ps.setString(5, prescrip.getInstructions());
            ps.setString(6, prescrip.getPrescriptionMedsAmt());
            ps.setString(7, prescrip.getPrescriptionMedsUnit());
            ps.setInt(8, prescrip.getCurrentMedicationID());
            ps.setInt(9, prescrip.getPatientID());
            ps.setInt(10, prescrip.getRefills());
            ps.setInt(11, prescrip.getPrescriptionHCP());
            ps.setInt(12, prescrip.getPharmacyID());
            ps.setByte(13, prescrip.getGeneric());
            ps.setByte(14, (byte) 1);
            ps.setDate(15, prescrip.getPrescriptionDate());
            ps.setInt(16, prescrip.getPrescriptionID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(Therapy therapies) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE patienttherapiestable SET "
                + " TherapyDescription = ?, "
                + " StartDate = ?, "
                + " EndDate = ?, "
                + " Outcome = ?, "
                + " CertificationType = ?, "
                + " Duration = ?, "
                + " OrderDate = ?, "
                + " O2FlowRate = ?, "
                + " PatientID = ?, "
                + " EncounterID = ?, "
                + " deleted = ? "
                + "WHERE TherapyID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, therapies.getTherapyDescription());
            ps.setDate(2, therapies.getStartDate());
            ps.setDate(3, therapies.getEndDate());
            ps.setString(4, therapies.getOutcome());
            ps.setString(5, therapies.getCertificationType());
            ps.setString(6, therapies.getDuration());
            ps.setDate(7, therapies.getOrderDate());
            ps.setString(8, therapies.getO2FlowRate());
            ps.setInt(9, therapies.getPatientID());
            ps.setInt(10, therapies.getEncounterID());
            ps.setByte(11, (byte) 1);
            ps.setInt(12, therapies.getTherapyID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRecord(VitalSigns vitals) {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = "UPDATE vitalsigns SET "
                + " Presentation = ?, "
                + " PretermLaborSigns = ?, "
                + " Comments = ?, "
                + " CompleteGeneralSpecialistClinicID = ?, "
                + " FetalMovement = ?, "
                + " WeeksGestation = ?, "
                + " FundalHeight = ?, "
                + " FHR = ?, "
                + " CervixDilationLength = ?, "
                + " deleted = ?, "
                + " PatientID = ? "
                + "WHERE VitalSignID = ?";
        try {
            connection = JDBCMySQLConnection.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, vitals.getPresentation());
            ps.setString(2, vitals.getPretermLaborSigns());
            ps.setString(3, vitals.getComments());
            ps.setInt(4, vitals.getCompleteGeneralSpecialistClinicID());
            ps.setInt(5, vitals.getFetalMovement());
            ps.setDouble(6, vitals.getWeeksGestation());
            ps.setDouble(7, vitals.getFundalHeight());
            ps.setDouble(8, vitals.getFHR());
            ps.setDouble(9, vitals.getCervixDilationLength());
            ps.setByte(10, (byte) 1);
            ps.setInt(11, vitals.getPatientID());
            ps.setInt(12, vitals.getVitalSignID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
// </editor-fold>
}
