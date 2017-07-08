package MainGUI.Forms;

import java.awt.Color;
import java.sql.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * revise
 * @author Zhiwei Chu, Fan Hu
 */
public final class Patient extends javax.swing.JInternalFrame {

    MainGUI.Classes.Patient OriginalRecord, NewRecord;
    Boolean inEditMode = true;

    public Patient() {
        initComponents();
        editModeToggler();
    }

    public Patient(int ID) {
        initComponents();
        editModeToggler();
        this.OriginalRecord = MainGUI.Classes.TestMain.getPatient(ID);
        populateTabPatient(OriginalRecord);
    }

    Format Formatter = new SimpleDateFormat("yyyy-mm-dd");

    public void populateTabPatient(MainGUI.Classes.Patient patient) {
        Old_ID.setText(patient.getOldID());
        Last_Name.setText(patient.getPtLastName());
        Prev_Last_Name.setText(patient.getPtPreviousLastName());
        First_Name.setText(patient.getPtFirstName());
        Address_1.setText(patient.getHomeAddress1());
        Address_2.setText(patient.getHomeAddress2());
        City.setText(patient.getHomeCity());
        State.setText(patient.getHomeStateProvinceRegion());
        Zipcode.setText(patient.getHomeZip());
        Country.setText(patient.getCountry());
        Citizenship.setText(patient.getCitizenship());
        Home_Phone.setText(patient.getPtHomePhone());
        Emrg_Phone.setText(patient.getEmergencyPhoneNumber());
        Fax.setText(patient.getPtHomeFax());
        Pager.setText(patient.getPager());
        Email.setText(patient.getEmailAddress());
        PTSS.setText(patient.getPtSS());
        Gender.setText(patient.getGender());
        Ethnic.setText(patient.getEthnicAssociation());
        Religion.setText(patient.getReligion());
        Marital.setText(patient.getMaritalStatus());
        Empl_Status.setText(patient.getEmploymentStatus());
        HMR.setText(patient.getHospitalMR());
        Comments.setText(patient.getComments());
        Bus_Phone.setText(patient.getBusinessPhone());
        Bus_Fax.setText(patient.getBusinessFax());
        Updates.setText(patient.getUpdates());
        GRP_Name.setText(patient.getGroupName());
        Relation_SubScriber.setText(patient.getSubscriberRelationship());
        UP_ID.setText(patient.getUPID());
        Middle_Init.setText(patient.getPtMiddleInitial());
        NoK_Relation.setText(patient.getNextOfKinRelationshipToPatient());
        Suffix.setText(patient.getSuffix());
        Patient_ID.setText(Integer.toString(patient.getPatientID()));
        Referral.setText(Integer.toString(patient.getReferral()));
        CPHCP_ID.setText(Integer.toString(patient.getCurrentPrimaryHCPId()));
        Spec1.setText(Integer.toString(patient.getSpecialist1()));
        Spec2.setText(Integer.toString(patient.getSpecialist2()));
        Spec3.setText(Integer.toString(patient.getSpecialist3()));
        Spec4.setText(Integer.toString(patient.getSpecialist4()));
        Orig_HCP.setText(Integer.toString(patient.getOriginalStaffHCP()));
        CS_HCP.setText(Integer.toString(patient.getCurrentStaffHCP()));
        Billing_Address.setText(Integer.toString(patient.getBillingAcctNumber()));
        Emp_ID.setText(Integer.toString(patient.getEmployerID()));
        NoK_ID.setText(Integer.toString(patient.getNextOfKinID()));
        Active.setText(Byte.toString(patient.getActive()));
        NPP.setText(Byte.toString(patient.getNoticeOfPracticePrivacy()));
        DOB.setText((patient.getDOB().toString()));
        DOE.setText((patient.getDateofExpire().toString()));
        Date_Ent.setText((patient.getDateEntered().toString()));
        Date_NPP.setText((patient.getNPPDate().toString()));
    }

    public MainGUI.Classes.Patient formToPatient() {
        MainGUI.Classes.Patient patient = new MainGUI.Classes.Patient();
        patient.setOldID(Old_ID.getText());
        patient.setPtLastName(Last_Name.getText());
        patient.setPtPreviousLastName(Prev_Last_Name.getText());
        patient.setPtFirstName(First_Name.getText());
        patient.setHomeAddress1(Address_1.getText());
        patient.setHomeAddress2(Address_2.getText());
        patient.setHomeCity(City.getText());
        patient.setHomeStateProvinceRegion(State.getText());
        patient.setHomeZip(Zipcode.getText());
        patient.setCountry(Country.getText());
        patient.setCitizenship(Citizenship.getText());
        patient.setPtHomePhone(Home_Phone.getText());
        patient.setEmergencyPhoneNumber(Emrg_Phone.getText());
        patient.setPtHomeFax(Fax.getText());
        patient.setPager(Pager.getText());
        patient.setEmailAddress(Email.getText());
        patient.setPtSS(PTSS.getText());
        patient.setGender(Gender.getText());
        patient.setEthnicAssociation(Ethnic.getText());
        patient.setReligion(Religion.getText());
        patient.setMaritalStatus(Marital.getText());
        patient.setEmploymentStatus(Empl_Status.getText());
        patient.setHospitalMR(HMR.getText());
        patient.setComments(Comments.getText());
        patient.setBusinessPhone(Bus_Phone.getText());
        patient.setBusinessFax(Bus_Fax.getText());
        patient.setUpdates(Updates.getText());
        patient.setGroupName(GRP_Name.getText());
        patient.setSubscriberRelationship(Relation_SubScriber.getText());
        patient.setUPID(UP_ID.getText());
        patient.setPtMiddleInitial(Middle_Init.getText());
        patient.setNextOfKinRelationshipToPatient(NoK_Relation.getText());
        patient.setSuffix(Suffix.getText());
        patient.setPatientID(Integer.parseInt(Patient_ID.getText()));
        patient.setReferral(Integer.parseInt(Referral.getText()));
        patient.setCurrentPrimaryHCPId(Integer.parseInt(CPHCP_ID.getText()));
        patient.setSpecialist1(Integer.parseInt(Spec1.getText()));
        patient.setSpecialist2(Integer.parseInt(Spec2.getText()));
        patient.setSpecialist3(Integer.parseInt(Spec3.getText()));
        patient.setSpecialist4(Integer.parseInt(Spec4.getText()));
        patient.setOriginalStaffHCP(Integer.parseInt(Orig_HCP.getText()));
        patient.setCurrentStaffHCP(Integer.parseInt(CS_HCP.getText()));
        patient.setBillingAcctNumber(Integer.parseInt(Billing_Address.getText()));
        patient.setEmployerID(Integer.parseInt(Emp_ID.getText()));
        patient.setNextOfKinID(Integer.parseInt(NoK_ID.getText()));
        patient.setActive(Byte.parseByte(Active.getText()));
        patient.setNoticeOfPracticePrivacy(Byte.parseByte(NPP.getText()));

        java.util.Date date;
        java.sql.Date sqlDate;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(DOB.getText());
            sqlDate = new Date(date.getTime());
            patient.setDOB(sqlDate);

            date = new SimpleDateFormat("yyyy-MM-dd").parse(Date_Ent.getText());
            sqlDate = new Date(date.getTime());
            patient.setDateEntered(sqlDate);

            date = new SimpleDateFormat("yyyy-MM-dd").parse(DOE.getText());
            sqlDate = new Date(date.getTime());
            patient.setDateofExpire(sqlDate);

            date = new SimpleDateFormat("yyyy-MM-dd").parse(Date_NPP.getText());
            sqlDate = new Date(date.getTime());
            patient.setNPPDate(sqlDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return patient;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jButton_Revert2 = new javax.swing.JButton();
        jButton_Insert1 = new javax.swing.JButton();
        jButton_Delete1 = new javax.swing.JButton();
        jButton_Update2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Spec3 = new javax.swing.JTextField();
        Spec2 = new javax.swing.JTextField();
        Spec1 = new javax.swing.JTextField();
        CPHCP_ID = new javax.swing.JTextField();
        Referral = new javax.swing.JTextField();
        DOE = new javax.swing.JTextField();
        HMR = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Empl_Status = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Marital = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Religion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Ethnic = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        GRP_Name = new javax.swing.JTextField();
        Updates = new javax.swing.JTextField();
        Billing_Address = new javax.swing.JTextField();
        Bus_Fax = new javax.swing.JTextField();
        Bus_Phone = new javax.swing.JTextField();
        Date_Ent = new javax.swing.JTextField();
        Comments = new javax.swing.JTextField();
        Active = new javax.swing.JTextField();
        Orig_HCP = new javax.swing.JTextField();
        Spec4 = new javax.swing.JTextField();
        NoK_ID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Suffix = new javax.swing.JTextField();
        Date_NPP = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        NPP = new javax.swing.JTextField();
        NoK_Relation = new javax.swing.JTextField();
        Middle_Init = new javax.swing.JTextField();
        UP_ID = new javax.swing.JTextField();
        Emp_ID = new javax.swing.JTextField();
        Relation_SubScriber = new javax.swing.JTextField();
        Address_2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Old_ID = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        State = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Address_1 = new javax.swing.JTextField();
        First_Name = new javax.swing.JTextField();
        Prev_Last_Name = new javax.swing.JTextField();
        Last_Name = new javax.swing.JTextField();
        Patient_ID = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        Gender = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        PTSS = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Pager = new javax.swing.JTextField();
        Fax = new javax.swing.JTextField();
        Emrg_Phone = new javax.swing.JTextField();
        Home_Phone = new javax.swing.JTextField();
        Citizenship = new javax.swing.JTextField();
        Country = new javax.swing.JTextField();
        Zipcode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CS_HCP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jLabel9.setText("jLabel9");

        jLabel39.setText("jLabel39");

        jLabel47.setText("jLabel47");

        jTextField22.setText("jTextField22");

        setClosable(true);
        setIconifiable(true);
        setTitle("Patient Table");
        setPreferredSize(new java.awt.Dimension(1000, 750));

        jButton_Revert2.setText("Revert");
        jButton_Revert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Revert2ActionPerformed(evt);
            }
        });

        jButton_Insert1.setText("Insert");
        jButton_Insert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Insert1ActionPerformed(evt);
            }
        });

        jButton_Delete1.setText("Delete");
        jButton_Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Delete1ActionPerformed(evt);
            }
        });

        jButton_Update2.setText("Update");
        jButton_Update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Update2ActionPerformed(evt);
            }
        });

        Spec3.setMinimumSize(new java.awt.Dimension(140, 29));
        Spec3.setPreferredSize(new java.awt.Dimension(140, 29));

        Spec2.setMinimumSize(new java.awt.Dimension(140, 29));
        Spec2.setPreferredSize(new java.awt.Dimension(140, 29));

        Spec1.setMinimumSize(new java.awt.Dimension(140, 29));
        Spec1.setPreferredSize(new java.awt.Dimension(140, 29));

        CPHCP_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        CPHCP_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Referral.setMinimumSize(new java.awt.Dimension(140, 29));
        Referral.setPreferredSize(new java.awt.Dimension(140, 29));

        DOE.setMinimumSize(new java.awt.Dimension(140, 29));
        DOE.setPreferredSize(new java.awt.Dimension(140, 29));

        HMR.setMinimumSize(new java.awt.Dimension(140, 29));
        HMR.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel3.setText("Last Name");

        jLabel5.setText("Pervious Last Name");

        jLabel6.setText("First Name");

        jLabel7.setText("Address 1");

        jLabel8.setText("Address 2");

        Empl_Status.setMinimumSize(new java.awt.Dimension(140, 29));
        Empl_Status.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel10.setText("City");

        Marital.setMinimumSize(new java.awt.Dimension(140, 29));
        Marital.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel11.setText("State");

        Religion.setMinimumSize(new java.awt.Dimension(140, 29));
        Religion.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel12.setText("Zipcode");

        Ethnic.setMinimumSize(new java.awt.Dimension(140, 29));
        Ethnic.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel13.setText("Country");

        jLabel14.setText("Citizenship");

        GRP_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        GRP_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        Updates.setMinimumSize(new java.awt.Dimension(140, 29));
        Updates.setPreferredSize(new java.awt.Dimension(140, 29));

        Billing_Address.setMinimumSize(new java.awt.Dimension(140, 29));
        Billing_Address.setPreferredSize(new java.awt.Dimension(140, 29));

        Bus_Fax.setMinimumSize(new java.awt.Dimension(140, 29));
        Bus_Fax.setPreferredSize(new java.awt.Dimension(140, 29));

        Bus_Phone.setMinimumSize(new java.awt.Dimension(140, 29));
        Bus_Phone.setPreferredSize(new java.awt.Dimension(140, 29));

        Date_Ent.setMinimumSize(new java.awt.Dimension(140, 29));
        Date_Ent.setPreferredSize(new java.awt.Dimension(140, 29));

        Comments.setMinimumSize(new java.awt.Dimension(140, 29));
        Comments.setPreferredSize(new java.awt.Dimension(140, 29));

        Active.setMinimumSize(new java.awt.Dimension(140, 29));
        Active.setPreferredSize(new java.awt.Dimension(140, 29));

        Orig_HCP.setMinimumSize(new java.awt.Dimension(140, 29));
        Orig_HCP.setPreferredSize(new java.awt.Dimension(140, 29));

        Spec4.setMinimumSize(new java.awt.Dimension(140, 29));
        Spec4.setPreferredSize(new java.awt.Dimension(140, 29));

        NoK_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        NoK_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel15.setText("Home Phone");

        Suffix.setMinimumSize(new java.awt.Dimension(140, 29));
        Suffix.setPreferredSize(new java.awt.Dimension(140, 29));

        Date_NPP.setMinimumSize(new java.awt.Dimension(140, 29));
        Date_NPP.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel56.setText("Suffix");

        jLabel55.setText("NPP Date");

        NPP.setMinimumSize(new java.awt.Dimension(140, 29));
        NPP.setPreferredSize(new java.awt.Dimension(140, 29));

        NoK_Relation.setMinimumSize(new java.awt.Dimension(140, 29));
        NoK_Relation.setPreferredSize(new java.awt.Dimension(140, 29));

        Middle_Init.setMinimumSize(new java.awt.Dimension(140, 29));
        Middle_Init.setPreferredSize(new java.awt.Dimension(140, 29));

        UP_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        UP_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Emp_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Emp_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Relation_SubScriber.setMinimumSize(new java.awt.Dimension(140, 29));
        Relation_SubScriber.setPreferredSize(new java.awt.Dimension(140, 29));

        Address_2.setMinimumSize(new java.awt.Dimension(140, 29));
        Address_2.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel26.setText("Employment Status");

        jLabel25.setText("Marital Status");

        jLabel23.setText("Ethnic Ass");

        jLabel22.setText("Gender");

        jLabel21.setText("DOB");

        jLabel20.setText("PTSS#");

        jLabel19.setText("Email");

        jLabel18.setText("Pager");

        jLabel17.setText("Fax");

        jLabel16.setText("Emgerancy Phone");

        Old_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Old_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel24.setText("Religion");

        jLabel37.setText("Active");

        jLabel36.setText("Current Staff HCP");

        jLabel35.setText("Original Staff HCP");

        jLabel34.setText("Specialist 4");

        jLabel33.setText("Specialist 3");

        jLabel32.setText("Specialist 2");

        jLabel31.setText("Specialist 1");

        jLabel30.setText("Current Primary HCP ID");

        jLabel29.setText("Referral");

        jLabel28.setText("Date of Expire");

        jLabel27.setText("Hospital MR#");

        jLabel50.setText("Next of Kin ID");

        jLabel49.setText("Emploer ID");

        jLabel48.setText("Subscriber Relationship");

        jLabel46.setText("Group Name");

        jLabel45.setText("Updates");

        jLabel43.setText("Billing Address");

        jLabel42.setText("Business Fax");

        jLabel41.setText("Business Phone");

        jLabel40.setText("Date Entered");

        jLabel38.setText("Comments");

        State.setMinimumSize(new java.awt.Dimension(140, 29));
        State.setPreferredSize(new java.awt.Dimension(140, 29));

        City.setMinimumSize(new java.awt.Dimension(140, 29));
        City.setPreferredSize(new java.awt.Dimension(140, 29));

        First_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        First_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        Prev_Last_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        Prev_Last_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        Last_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        Last_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        Patient_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Patient_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel54.setText("Notice of Practice Privacy");

        jLabel53.setText("Next of Kin Relationship to Patient");

        jLabel52.setText("Middle Initial");

        jLabel51.setText("UP ID");

        Gender.setMinimumSize(new java.awt.Dimension(140, 29));
        Gender.setPreferredSize(new java.awt.Dimension(140, 29));

        DOB.setMinimumSize(new java.awt.Dimension(140, 29));
        DOB.setPreferredSize(new java.awt.Dimension(140, 29));

        PTSS.setMinimumSize(new java.awt.Dimension(140, 29));
        PTSS.setPreferredSize(new java.awt.Dimension(140, 29));

        Email.setMinimumSize(new java.awt.Dimension(140, 29));
        Email.setPreferredSize(new java.awt.Dimension(140, 29));

        Pager.setMinimumSize(new java.awt.Dimension(140, 29));
        Pager.setPreferredSize(new java.awt.Dimension(140, 29));

        Fax.setMinimumSize(new java.awt.Dimension(140, 29));
        Fax.setPreferredSize(new java.awt.Dimension(140, 29));

        Emrg_Phone.setMinimumSize(new java.awt.Dimension(140, 29));
        Emrg_Phone.setPreferredSize(new java.awt.Dimension(140, 29));

        Home_Phone.setMinimumSize(new java.awt.Dimension(140, 29));
        Home_Phone.setPreferredSize(new java.awt.Dimension(140, 29));

        Citizenship.setMinimumSize(new java.awt.Dimension(140, 29));
        Citizenship.setPreferredSize(new java.awt.Dimension(140, 29));

        Country.setMinimumSize(new java.awt.Dimension(140, 29));
        Country.setPreferredSize(new java.awt.Dimension(140, 29));

        Zipcode.setMinimumSize(new java.awt.Dimension(140, 29));
        Zipcode.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel1.setText("Patient ID");

        jLabel2.setText("Old ID");

        CS_HCP.setMinimumSize(new java.awt.Dimension(140, 29));
        CS_HCP.setPreferredSize(new java.awt.Dimension(140, 29));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(10, 10, 10))
                        .addComponent(jLabel12)
                        .addComponent(jLabel14)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)
                        .addComponent(jLabel19)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Address_1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Old_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(First_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Prev_Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Emrg_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Citizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Address_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PTSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS_HCP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Spec3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Spec2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Spec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPHCP_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Referral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DOE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Empl_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Marital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ethnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Orig_HCP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Spec4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(jLabel45)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42)
                    .addComponent(jLabel48)
                    .addComponent(jLabel46)
                    .addComponent(jLabel50)
                    .addComponent(jLabel49)
                    .addComponent(jLabel52)
                    .addComponent(jLabel51)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Active, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Comments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Date_Ent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bus_Phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bus_Fax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Billing_Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Updates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GRP_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Relation_SubScriber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Emp_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoK_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UP_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Middle_Init, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoK_Relation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NPP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Date_NPP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Suffix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Address_1, Address_2, Citizenship, City, Country, Email, Emrg_Phone, Fax, First_Name, Home_Phone, Last_Name, Old_ID, Pager, Patient_ID, Prev_Last_Name, State, Zipcode});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CPHCP_ID, CS_HCP, DOB, DOE, Empl_Status, Ethnic, Gender, HMR, Marital, Orig_HCP, PTSS, Referral, Religion, Spec1, Spec2, Spec3, Spec4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Old_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Prev_Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(First_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Address_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Address_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Zipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Citizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Home_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Emrg_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(PTSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(Ethnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(Marital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel37)
                                .addComponent(Active, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(Comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(Date_Ent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(Bus_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42)
                                    .addComponent(Bus_Fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43)
                                    .addComponent(Billing_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel45)
                                    .addComponent(Updates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel46)
                                    .addComponent(GRP_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48)
                                    .addComponent(Relation_SubScriber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel49)
                                    .addComponent(Emp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel50)
                                    .addComponent(NoK_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel51)
                                    .addComponent(UP_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel52)
                                    .addComponent(Middle_Init, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel53)
                                    .addComponent(NoK_Relation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel54)
                                    .addComponent(NPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel55)
                                    .addComponent(Date_NPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Suffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(Empl_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(HMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(DOE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(Referral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(CPHCP_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(Spec1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(Spec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(Spec3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(Spec4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(Orig_HCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(CS_HCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56))))))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jButton1.setText("Toggle Edit Mode");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Update2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Revert2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Insert1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Delete1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Update2)
                    .addComponent(jButton_Delete1)
                    .addComponent(jButton_Insert1)
                    .addComponent(jButton_Revert2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void editModeToggler() {
        if (inEditMode) {
            inEditMode = false;
            jButton_Delete1.setVisible(false);
            jButton_Insert1.setVisible(false);
            jButton_Revert2.setVisible(false);
            jButton_Update2.setVisible(false);
            Active.setEditable(inEditMode);
            Address_1.setEditable(inEditMode);
            Address_2.setEditable(inEditMode);
            Billing_Address.setEditable(inEditMode);
            Bus_Fax.setEditable(inEditMode);
            Bus_Phone.setEditable(inEditMode);
            CPHCP_ID.setEditable(inEditMode);
            CS_HCP.setEditable(inEditMode);
            Citizenship.setEditable(inEditMode);
            City.setEditable(inEditMode);
            Comments.setEditable(inEditMode);
            Country.setEditable(inEditMode);
            DOB.setEditable(inEditMode);
            DOE.setEditable(inEditMode);
            Date_Ent.setEditable(inEditMode);
            Date_NPP.setEditable(inEditMode);
            Email.setEditable(inEditMode);
            Emp_ID.setEditable(inEditMode);
            Empl_Status.setEditable(inEditMode);
            Emrg_Phone.setEditable(inEditMode);
            Ethnic.setEditable(inEditMode);
            Fax.setEditable(inEditMode);
            First_Name.setEditable(inEditMode);
            GRP_Name.setEditable(inEditMode);
            Gender.setEditable(inEditMode);
            HMR.setEditable(inEditMode);
            Home_Phone.setEditable(inEditMode);
            Last_Name.setEditable(inEditMode);
            Marital.setEditable(inEditMode);
            Middle_Init.setEditable(inEditMode);
            NPP.setEditable(inEditMode);
            NoK_ID.setEditable(inEditMode);
            NoK_Relation.setEditable(inEditMode);
            Old_ID.setEditable(inEditMode);
            Orig_HCP.setEditable(inEditMode);
            PTSS.setEditable(inEditMode);
            Pager.setEditable(inEditMode);
            Patient_ID.setEditable(inEditMode);
            Prev_Last_Name.setEditable(inEditMode);
            Referral.setEditable(inEditMode);
            Relation_SubScriber.setEditable(inEditMode);
            Religion.setEditable(inEditMode);
            Spec1.setEditable(inEditMode);
            Spec2.setEditable(inEditMode);
            Spec3.setEditable(inEditMode);
            Spec4.setEditable(inEditMode);
            State.setEditable(inEditMode);
            Suffix.setEditable(inEditMode);
            UP_ID.setEditable(inEditMode);
            Updates.setEditable(inEditMode);
            Zipcode.setEditable(inEditMode);
            Active.setBackground(Color.LIGHT_GRAY);
            Address_1.setBackground(Color.LIGHT_GRAY);
            Address_2.setBackground(Color.LIGHT_GRAY);
            Billing_Address.setBackground(Color.LIGHT_GRAY);
            Bus_Fax.setBackground(Color.LIGHT_GRAY);
            Bus_Phone.setBackground(Color.LIGHT_GRAY);
            CPHCP_ID.setBackground(Color.LIGHT_GRAY);
            CS_HCP.setBackground(Color.LIGHT_GRAY);
            Citizenship.setBackground(Color.LIGHT_GRAY);
            City.setBackground(Color.LIGHT_GRAY);
            Comments.setBackground(Color.LIGHT_GRAY);
            Country.setBackground(Color.LIGHT_GRAY);
            DOB.setBackground(Color.LIGHT_GRAY);
            DOE.setBackground(Color.LIGHT_GRAY);
            Date_Ent.setBackground(Color.LIGHT_GRAY);
            Date_NPP.setBackground(Color.LIGHT_GRAY);
            Email.setBackground(Color.LIGHT_GRAY);
            Emp_ID.setBackground(Color.LIGHT_GRAY);
            Empl_Status.setBackground(Color.LIGHT_GRAY);
            Emrg_Phone.setBackground(Color.LIGHT_GRAY);
            Ethnic.setBackground(Color.LIGHT_GRAY);
            Fax.setBackground(Color.LIGHT_GRAY);
            First_Name.setBackground(Color.LIGHT_GRAY);
            GRP_Name.setBackground(Color.LIGHT_GRAY);
            Gender.setBackground(Color.LIGHT_GRAY);
            HMR.setBackground(Color.LIGHT_GRAY);
            Home_Phone.setBackground(Color.LIGHT_GRAY);
            Last_Name.setBackground(Color.LIGHT_GRAY);
            Marital.setBackground(Color.LIGHT_GRAY);
            Middle_Init.setBackground(Color.LIGHT_GRAY);
            NPP.setBackground(Color.LIGHT_GRAY);
            NoK_ID.setBackground(Color.LIGHT_GRAY);
            NoK_Relation.setBackground(Color.LIGHT_GRAY);
            Old_ID.setBackground(Color.LIGHT_GRAY);
            Orig_HCP.setBackground(Color.LIGHT_GRAY);
            PTSS.setBackground(Color.LIGHT_GRAY);
            Pager.setBackground(Color.LIGHT_GRAY);
            Patient_ID.setBackground(Color.LIGHT_GRAY);
            Prev_Last_Name.setBackground(Color.LIGHT_GRAY);
            Referral.setBackground(Color.LIGHT_GRAY);
            Relation_SubScriber.setBackground(Color.LIGHT_GRAY);
            Religion.setBackground(Color.LIGHT_GRAY);
            Spec1.setBackground(Color.LIGHT_GRAY);
            Spec2.setBackground(Color.LIGHT_GRAY);
            Spec3.setBackground(Color.LIGHT_GRAY);
            Spec4.setBackground(Color.LIGHT_GRAY);
            State.setBackground(Color.LIGHT_GRAY);
            Suffix.setBackground(Color.LIGHT_GRAY);
            UP_ID.setBackground(Color.LIGHT_GRAY);
            Updates.setBackground(Color.LIGHT_GRAY);
            Zipcode.setBackground(Color.LIGHT_GRAY);

        } else {
            inEditMode = true;
            jButton_Delete1.setVisible(true);
            jButton_Insert1.setVisible(true);
            jButton_Revert2.setVisible(true);
            jButton_Update2.setVisible(true);
            Active.setEditable(inEditMode);
            Address_1.setEditable(inEditMode);
            Address_2.setEditable(inEditMode);
            Billing_Address.setEditable(inEditMode);
            Bus_Fax.setEditable(inEditMode);
            Bus_Phone.setEditable(inEditMode);
            CPHCP_ID.setEditable(inEditMode);
            CS_HCP.setEditable(inEditMode);
            Citizenship.setEditable(inEditMode);
            City.setEditable(inEditMode);
            Comments.setEditable(inEditMode);
            Country.setEditable(inEditMode);
            DOB.setEditable(inEditMode);
            DOE.setEditable(inEditMode);
            Date_Ent.setEditable(inEditMode);
            Date_NPP.setEditable(inEditMode);
            Email.setEditable(inEditMode);
            Emp_ID.setEditable(inEditMode);
            Empl_Status.setEditable(inEditMode);
            Emrg_Phone.setEditable(inEditMode);
            Ethnic.setEditable(inEditMode);
            Fax.setEditable(inEditMode);
            First_Name.setEditable(inEditMode);
            GRP_Name.setEditable(inEditMode);
            Gender.setEditable(inEditMode);
            HMR.setEditable(inEditMode);
            Home_Phone.setEditable(inEditMode);
            Last_Name.setEditable(inEditMode);
            Marital.setEditable(inEditMode);
            Middle_Init.setEditable(inEditMode);
            NPP.setEditable(inEditMode);
            NoK_ID.setEditable(inEditMode);
            NoK_Relation.setEditable(inEditMode);
            Old_ID.setEditable(inEditMode);
            Orig_HCP.setEditable(inEditMode);
            PTSS.setEditable(inEditMode);
            Pager.setEditable(inEditMode);
            Patient_ID.setEditable(inEditMode);
            Prev_Last_Name.setEditable(inEditMode);
            Referral.setEditable(inEditMode);
            Relation_SubScriber.setEditable(inEditMode);
            Religion.setEditable(inEditMode);
            Spec1.setEditable(inEditMode);
            Spec2.setEditable(inEditMode);
            Spec3.setEditable(inEditMode);
            Spec4.setEditable(inEditMode);
            State.setEditable(inEditMode);
            Suffix.setEditable(inEditMode);
            UP_ID.setEditable(inEditMode);
            Updates.setEditable(inEditMode);
            Zipcode.setEditable(inEditMode);
            Active.setBackground(Color.WHITE);
            Address_1.setBackground(Color.WHITE);
            Address_2.setBackground(Color.WHITE);
            Billing_Address.setBackground(Color.WHITE);
            Bus_Fax.setBackground(Color.WHITE);
            Bus_Phone.setBackground(Color.WHITE);
            CPHCP_ID.setBackground(Color.WHITE);
            CS_HCP.setBackground(Color.WHITE);
            Citizenship.setBackground(Color.WHITE);
            City.setBackground(Color.WHITE);
            Comments.setBackground(Color.WHITE);
            Country.setBackground(Color.WHITE);
            DOB.setBackground(Color.WHITE);
            DOE.setBackground(Color.WHITE);
            Date_Ent.setBackground(Color.WHITE);
            Date_NPP.setBackground(Color.WHITE);
            Email.setBackground(Color.WHITE);
            Emp_ID.setBackground(Color.WHITE);
            Empl_Status.setBackground(Color.WHITE);
            Emrg_Phone.setBackground(Color.WHITE);
            Ethnic.setBackground(Color.WHITE);
            Fax.setBackground(Color.WHITE);
            First_Name.setBackground(Color.WHITE);
            GRP_Name.setBackground(Color.WHITE);
            Gender.setBackground(Color.WHITE);
            HMR.setBackground(Color.WHITE);
            Home_Phone.setBackground(Color.WHITE);
            Last_Name.setBackground(Color.WHITE);
            Marital.setBackground(Color.WHITE);
            Middle_Init.setBackground(Color.WHITE);
            NPP.setBackground(Color.WHITE);
            NoK_ID.setBackground(Color.WHITE);
            NoK_Relation.setBackground(Color.WHITE);
            Old_ID.setBackground(Color.WHITE);
            Orig_HCP.setBackground(Color.WHITE);
            PTSS.setBackground(Color.WHITE);
            Pager.setBackground(Color.WHITE);
            Patient_ID.setBackground(Color.WHITE);
            Prev_Last_Name.setBackground(Color.WHITE);
            Referral.setBackground(Color.WHITE);
            Relation_SubScriber.setBackground(Color.WHITE);
            Religion.setBackground(Color.WHITE);
            Spec1.setBackground(Color.WHITE);
            Spec2.setBackground(Color.WHITE);
            Spec3.setBackground(Color.WHITE);
            Spec4.setBackground(Color.WHITE);
            State.setBackground(Color.WHITE);
            Suffix.setBackground(Color.WHITE);
            UP_ID.setBackground(Color.WHITE);
            Updates.setBackground(Color.WHITE);
            Zipcode.setBackground(Color.WHITE);
        }
    }
// <editor-fold defaultstate="collapsed" desc="Button Actions">    
    private void jButton_Update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Update2ActionPerformed
        this.NewRecord = formToPatient();
        MainGUI.Classes.TestMain.updateRecord(NewRecord);
        JOptionPane.showMessageDialog(null, "Update Completed");
    }//GEN-LAST:event_jButton_Update2ActionPerformed

    private void jButton_Revert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Revert2ActionPerformed
        populateTabPatient(OriginalRecord);
        MainGUI.Classes.TestMain.updateRecord(OriginalRecord);
        JOptionPane.showMessageDialog(null, "File Reverted to Original");
    }//GEN-LAST:event_jButton_Revert2ActionPerformed

    private void jButton_Insert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Insert1ActionPerformed
        this.NewRecord = formToPatient();
        MainGUI.Classes.TestMain.insertRecord(NewRecord);
        JOptionPane.showMessageDialog(null, "Insert Completed");
    }//GEN-LAST:event_jButton_Insert1ActionPerformed

    private void jButton_Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Delete1ActionPerformed
        this.NewRecord = formToPatient();
        MainGUI.Classes.TestMain.deleteRecord(NewRecord);
        JOptionPane.showMessageDialog(null, "Delete Completed");
    }//GEN-LAST:event_jButton_Delete1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editModeToggler();
    }//GEN-LAST:event_jButton1ActionPerformed
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Variables Declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Active;
    private javax.swing.JTextField Address_1;
    private javax.swing.JTextField Address_2;
    private javax.swing.JTextField Billing_Address;
    private javax.swing.JTextField Bus_Fax;
    private javax.swing.JTextField Bus_Phone;
    private javax.swing.JTextField CPHCP_ID;
    private javax.swing.JTextField CS_HCP;
    private javax.swing.JTextField Citizenship;
    private javax.swing.JTextField City;
    private javax.swing.JTextField Comments;
    private javax.swing.JTextField Country;
    private javax.swing.JTextField DOB;
    private javax.swing.JTextField DOE;
    private javax.swing.JTextField Date_Ent;
    private javax.swing.JTextField Date_NPP;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Emp_ID;
    private javax.swing.JTextField Empl_Status;
    private javax.swing.JTextField Emrg_Phone;
    private javax.swing.JTextField Ethnic;
    private javax.swing.JTextField Fax;
    private javax.swing.JTextField First_Name;
    private javax.swing.JTextField GRP_Name;
    private javax.swing.JTextField Gender;
    private javax.swing.JTextField HMR;
    private javax.swing.JTextField Home_Phone;
    private javax.swing.JTextField Last_Name;
    private javax.swing.JTextField Marital;
    private javax.swing.JTextField Middle_Init;
    private javax.swing.JTextField NPP;
    private javax.swing.JTextField NoK_ID;
    private javax.swing.JTextField NoK_Relation;
    private javax.swing.JTextField Old_ID;
    private javax.swing.JTextField Orig_HCP;
    private javax.swing.JTextField PTSS;
    private javax.swing.JTextField Pager;
    private javax.swing.JTextField Patient_ID;
    private javax.swing.JTextField Prev_Last_Name;
    private javax.swing.JTextField Referral;
    private javax.swing.JTextField Relation_SubScriber;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField Spec1;
    private javax.swing.JTextField Spec2;
    private javax.swing.JTextField Spec3;
    private javax.swing.JTextField Spec4;
    private javax.swing.JTextField State;
    private javax.swing.JTextField Suffix;
    private javax.swing.JTextField UP_ID;
    private javax.swing.JTextField Updates;
    private javax.swing.JTextField Zipcode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Delete1;
    private javax.swing.JButton jButton_Insert1;
    private javax.swing.JButton jButton_Revert2;
    private javax.swing.JButton jButton_Update2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField22;
    // End of variables declaration//GEN-END:variables
// </editor-fold>

}
