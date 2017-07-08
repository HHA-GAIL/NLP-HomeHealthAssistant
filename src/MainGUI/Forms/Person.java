package MainGUI.Forms;

import java.awt.Color;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * revise and change UI
 * 
 * @author Zhiwei Chu, Fan Hu
 */
public final class Person extends javax.swing.JInternalFrame {

    MainGUI.Classes.Person OriginalRecord, NewRecord;
    Boolean inEditMode = true;

    public Person() {
        initComponents();
        editModeToggler();
    }

    public Person(int ID) {
        initComponents();
        editModeToggler();
        this.OriginalRecord = MainGUI.Classes.TestMain.getPerson(ID);
        populateTabPerson(OriginalRecord);
    }

    Format Formatter = new SimpleDateFormat("yyyy-mm-dd");

    public void populateTabPerson(MainGUI.Classes.Person person) {
        Old_ID.setText(person.getOldID());
        First_Name.setText(person.getPersonFirstName());
        Last_Name.setText(person.getPersonLastName());
        Middle_Name.setText(person.getPersonMiddleName());
        Initals.setText(person.getPersonInitials());
        Title.setText(person.getTitle());
        Address_1.setText(person.getAddress1());
        Address_2.setText(person.getAddress2());
        Group_Name.setText(person.getGroupName());
        City.setText(person.getCity());
        S_P_R.setText(person.getStateProvinceRegion());
        Zip_Code.setText(person.getZipCode());
        Country.setText(person.getCountry());
        Citizenship.setText(person.getCitizenship());
        Specialty_Disc.setText(person.getSpecialtyDescription());
        Other_Specialty.setText(person.getOtherSpecialty());
        Office_Phone.setText(person.getOfficePhone());
        Office_Fax.setText(person.getOfficeFAX());
        Home_Phone.setText(person.getHomePhone());
        Car_Phone.setText(person.getCarPhone());
        Fax_Num.setText(person.getFaxNumber());
        Pager.setText(person.getPager());
        Email.setText(person.getEmailAddress());
        Int_Password.setText(person.getInternetPassword());
        Type.setText(person.getType());
        Position.setText(person.getPosition());
        SSN.setText(person.getSocialSecurity());
        State_License.setText(person.getStateLicenseNumber());
        Medicaid_ID.setText(person.getMedicaid());
        Medicare_UPin.setText(person.getMedicareUPIN());
        Medicare_Pin.setText(person.getMedicarePIN());
        Hospital_Pin.setText(person.getHospitalPIN());
        DEA_Reg_Num.setText(person.getDEARegNumber());
        MalPrac_POL.setText(person.getMalpracticePol());
        Sig_Image.setText(person.getSignatureImage());
        UserName.setText(person.getUsername());
        Name_Suffix.setText(person.getNameSuffix());
        CC_ID_Info.setText(person.getCreditCardIDInfo());
        Rel_to_Patient.setText(person.getRelationshipToPatient());
        Nat_Pro_ID.setText(person.getNationalProviderID());
        Emp_ID_Num.setText(person.getEmployerIDNumber());
        Gender.setText(person.getGender());
        State_CSN.setText(person.getStateControlledSubstanceNumber());
        Comments.setText(person.getComments());
        Suffix.setText(person.getSuffix());
        Person_ID.setText(Integer.toString(person.getPersonId()));
        Pro_Org_ID.setText(Integer.toString(person.getProviderOrganizationID()));
        Spec_ID.setText(Integer.toString(person.getSpecialtyID()));
        Staff_ID.setText(Integer.toString(person.getStaffID()));
        Prim_Emp_ID.setText(Integer.toString(person.getPrimaryEmployerID()));
        Sec_Emp_ID.setText(Integer.toString(person.getSecondaryEmployerID()));
        Org_ID.setText(Integer.toString(person.getOrganizationID()));
        Active.setText(Byte.toString(person.getActive()));

        Hospice_Emp.setText(Byte.toString(person.getHospiceEmployee()));
        Claim_Sig_Auth.setText(Byte.toString(person.getClaimSignatureAuth()));
        License_Exp.setText(person.getLicenseExpiration().toString());
        DEA_Exp.setText(person.getDEAExpiration().toString());
        Cont_Sub_Exp.setText(person.getControlledSubstanceExpiration().toString());
        DOB.setText(person.getDOB().toString());
    }

    public MainGUI.Classes.Person formToPerson() {
        MainGUI.Classes.Person person = new MainGUI.Classes.Person();
        person.setOldID(Old_ID.getText());
        person.setPersonFirstName(First_Name.getText());
        person.setPersonLastName(Last_Name.getText());
        person.setPersonMiddleName(Middle_Name.getText());
        person.setPersonInitials(Initals.getText());
        person.setTitle(Title.getText());
        person.setAddress1(Address_1.getText());
        person.setAddress2(Address_2.getText());
        person.setGroupName(Group_Name.getText());
        person.setCity(City.getText());
        person.setStateProvinceRegion(S_P_R.getText());
        person.setZipCode(Zip_Code.getText());
        person.setCountry(Country.getText());
        person.setCitizenship(Citizenship.getText());
        person.setSpecialtyDescription(Specialty_Disc.getText());
        person.setOtherSpecialty(Other_Specialty.getText());
        person.setOfficePhone(Office_Phone.getText());
        person.setOfficeFAX(Office_Fax.getText());
        person.setHomePhone(Home_Phone.getText());
        person.setCarPhone(Car_Phone.getText());
        person.setFaxNumber(Fax_Num.getText());
        person.setPager(Pager.getText());
        person.setEmailAddress(Email.getText());
        person.setInternetPassword(Int_Password.getText());
        person.setType(Type.getText());
        person.setPosition(Position.getText());
        person.setSocialSecurity(SSN.getText());
        person.setStateLicenseNumber(State_License.getText());
        person.setMedicaid(Medicaid_ID.getText());
        person.setMedicareUPIN(Medicare_UPin.getText());
        person.setMedicarePIN(Medicare_Pin.getText());
        person.setHospitalPIN(Hospital_Pin.getText());
        person.setDEARegNumber(DEA_Reg_Num.getText());
        person.setMalpracticePol(MalPrac_POL.getText());
        person.setSignatureImage(Sig_Image.getText());
        person.setUsername(UserName.getText());
        person.setNameSuffix(Name_Suffix.getText());
        person.setCreditCardIDInfo(CC_ID_Info.getText());
        person.setRelationshipToPatient(Rel_to_Patient.getText());
        person.setNationalProviderID(Nat_Pro_ID.getText());
        person.setEmployerIDNumber(Emp_ID_Num.getText());
        person.setGender(Gender.getText());
        person.setStateControlledSubstanceNumber(State_CSN.getText());
        person.setComments(Comments.getText());
        person.setSuffix(Suffix.getText());
        person.setPersonId(Integer.parseInt(Person_ID.getText()));
        person.setProviderOrganizationID(Integer.parseInt(Pro_Org_ID.getText()));
        person.setSpecialtyID(Integer.parseInt(Spec_ID.getText()));
        person.setStaffID(Integer.parseInt(Staff_ID.getText()));
        person.setPrimaryEmployerID(Integer.parseInt(Prim_Emp_ID.getText()));
        person.setSecondaryEmployerID(Integer.parseInt(Sec_Emp_ID.getText()));
        person.setOrganizationID(Integer.parseInt(Org_ID.getText()));
        person.setActive(Byte.parseByte(Active.getText()));

        person.setHospiceEmployee(Byte.parseByte(Hospice_Emp.getText()));
        person.setClaimSignatureAuth(Byte.parseByte(Claim_Sig_Auth.getText()));
        try {
            java.util.Date date;
            java.sql.Date sqlStartDate;
            if (!License_Exp.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(License_Exp.getText());
                sqlStartDate = new Date(date.getTime());
                person.setLicenseExpiration(sqlStartDate);
            }
            if (!DEA_Exp.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(DEA_Exp.getText());
                sqlStartDate = new Date(date.getTime());
                person.setDEAExpiration(sqlStartDate);
            }
            if (!Cont_Sub_Exp.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(Cont_Sub_Exp.getText());
                sqlStartDate = new Date(date.getTime());
                person.setControlledSubstanceExpiration(sqlStartDate);
            }

            if (!DOB.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(DOB.getText());
                sqlStartDate = new Date(date.getTime());
                person.setDOB(sqlStartDate);
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        Active = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        Old_ID = new javax.swing.JTextField();
        Person_ID = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Zip_Code = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        S_P_R = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Group_Name = new javax.swing.JTextField();
        Address_2 = new javax.swing.JTextField();
        Address_1 = new javax.swing.JTextField();
        Title = new javax.swing.JTextField();
        Initals = new javax.swing.JTextField();
        Middle_Name = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        Last_Name = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        First_Name = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Pager = new javax.swing.JTextField();
        Fax_Num = new javax.swing.JTextField();
        Car_Phone = new javax.swing.JTextField();
        Home_Phone = new javax.swing.JTextField();
        Office_Fax = new javax.swing.JTextField();
        Office_Phone = new javax.swing.JTextField();
        Other_Specialty = new javax.swing.JTextField();
        Specialty_Disc = new javax.swing.JTextField();
        Citizenship = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        Country = new javax.swing.JTextField();
        DEA_Reg_Num = new javax.swing.JTextField();
        Hospital_Pin = new javax.swing.JTextField();
        Medicare_Pin = new javax.swing.JTextField();
        Medicare_UPin = new javax.swing.JTextField();
        Medicaid_ID = new javax.swing.JTextField();
        License_Exp = new javax.swing.JTextField();
        State_License = new javax.swing.JTextField();
        SSN = new javax.swing.JTextField();
        Position = new javax.swing.JTextField();
        Type = new javax.swing.JTextField();
        Int_Password = new javax.swing.JTextField();
        Prim_Emp_ID = new javax.swing.JTextField();
        Name_Suffix = new javax.swing.JTextField();
        UserName = new javax.swing.JTextField();
        Sig_Image = new javax.swing.JTextField();
        Staff_ID = new javax.swing.JTextField();
        Spec_ID = new javax.swing.JTextField();
        Pro_Org_ID = new javax.swing.JTextField();
        MalPrac_POL = new javax.swing.JTextField();
        Cont_Sub_Exp = new javax.swing.JTextField();
        DEA_Exp = new javax.swing.JTextField();
        Comments = new javax.swing.JTextField();
        Org_ID = new javax.swing.JTextField();
        State_CSN = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        Hospice_Emp = new javax.swing.JTextField();
        Emp_ID_Num = new javax.swing.JTextField();
        Nat_Pro_ID = new javax.swing.JTextField();
        Rel_to_Patient = new javax.swing.JTextField();
        CC_ID_Info = new javax.swing.JTextField();
        Sec_Emp_ID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Suffix = new javax.swing.JTextField();
        Claim_Sig_Auth = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton_Revert1 = new javax.swing.JButton();
        jButton_Insert = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton_Update1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Person Table");
        setToolTipText("");
        setAutoscrolls(true);

        jLabel30.setText("State License Number");

        Active.setToolTipText("");
        Active.setMinimumSize(new java.awt.Dimension(140, 29));
        Active.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel29.setText("Social Security");

        jLabel28.setText("Position");

        jLabel27.setText("Type");

        jLabel26.setText("Internet Password");

        jLabel25.setText("Email");

        jLabel24.setText("Pager");

        jLabel23.setText("Fax Number");

        jLabel60.setText("Suffix");

        jLabel59.setText("Claim Signature Auth.");

        jLabel58.setText("Comments");

        jLabel57.setText("Organization ID");

        jLabel56.setText("State C.S.N.");

        jLabel22.setText("Car Phone");

        jLabel55.setText("Date Of Birth");

        jLabel21.setText("Home Phone");

        jLabel54.setText("Gender");

        jLabel20.setText("Office Fax");

        jLabel53.setText("Hospice Employee");

        Old_ID.setToolTipText("");
        Old_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Old_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Person_ID.setToolTipText("");
        Person_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Person_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel33.setText("Medicare UPin");

        Zip_Code.setToolTipText("");
        Zip_Code.setMinimumSize(new java.awt.Dimension(140, 29));
        Zip_Code.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel40.setText("Provider Organization ID");

        S_P_R.setToolTipText("");
        S_P_R.setMinimumSize(new java.awt.Dimension(140, 29));
        S_P_R.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel39.setText("Malpractice Pol #");

        jLabel38.setText("Controlled Substance Exp");

        jLabel37.setText("DEA Experation");

        jLabel36.setText("DEA Registration Number");

        jLabel35.setText("Hospital Pin");

        jLabel34.setText("Medicare Pin");

        Group_Name.setToolTipText("");
        Group_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        Group_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        Address_2.setToolTipText("");
        Address_2.setMinimumSize(new java.awt.Dimension(140, 29));
        Address_2.setPreferredSize(new java.awt.Dimension(140, 29));

        Address_1.setToolTipText("");
        Address_1.setMinimumSize(new java.awt.Dimension(140, 29));
        Address_1.setPreferredSize(new java.awt.Dimension(140, 29));

        Title.setToolTipText("");
        Title.setMinimumSize(new java.awt.Dimension(140, 29));
        Title.setPreferredSize(new java.awt.Dimension(140, 29));

        Initals.setToolTipText("");
        Initals.setMinimumSize(new java.awt.Dimension(140, 29));
        Initals.setPreferredSize(new java.awt.Dimension(140, 29));

        Middle_Name.setToolTipText("");
        Middle_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        Middle_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel32.setText("Medicaid ID");

        Last_Name.setToolTipText("");
        Last_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        Last_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel31.setText("License Experation");

        First_Name.setToolTipText("");
        First_Name.setMinimumSize(new java.awt.Dimension(140, 29));
        First_Name.setPreferredSize(new java.awt.Dimension(140, 29));

        City.setToolTipText("");
        City.setMinimumSize(new java.awt.Dimension(140, 29));
        City.setPreferredSize(new java.awt.Dimension(140, 29));

        Email.setToolTipText("");
        Email.setMinimumSize(new java.awt.Dimension(140, 29));
        Email.setPreferredSize(new java.awt.Dimension(140, 29));

        Pager.setToolTipText("");
        Pager.setMinimumSize(new java.awt.Dimension(140, 29));
        Pager.setPreferredSize(new java.awt.Dimension(140, 29));

        Fax_Num.setToolTipText("");
        Fax_Num.setMinimumSize(new java.awt.Dimension(140, 29));
        Fax_Num.setPreferredSize(new java.awt.Dimension(140, 29));

        Car_Phone.setToolTipText("");
        Car_Phone.setMinimumSize(new java.awt.Dimension(140, 29));
        Car_Phone.setPreferredSize(new java.awt.Dimension(140, 29));

        Home_Phone.setToolTipText("");
        Home_Phone.setMinimumSize(new java.awt.Dimension(140, 29));
        Home_Phone.setPreferredSize(new java.awt.Dimension(140, 29));

        Office_Fax.setToolTipText("");
        Office_Fax.setMinimumSize(new java.awt.Dimension(140, 29));
        Office_Fax.setPreferredSize(new java.awt.Dimension(140, 29));

        Office_Phone.setToolTipText("");
        Office_Phone.setMinimumSize(new java.awt.Dimension(140, 29));
        Office_Phone.setPreferredSize(new java.awt.Dimension(140, 29));

        Other_Specialty.setToolTipText("");
        Other_Specialty.setMinimumSize(new java.awt.Dimension(140, 29));
        Other_Specialty.setPreferredSize(new java.awt.Dimension(140, 29));

        Specialty_Disc.setToolTipText("");
        Specialty_Disc.setMinimumSize(new java.awt.Dimension(140, 29));
        Specialty_Disc.setPreferredSize(new java.awt.Dimension(140, 29));

        Citizenship.setToolTipText("");
        Citizenship.setMinimumSize(new java.awt.Dimension(140, 29));
        Citizenship.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel42.setText("Specialty ID");

        Country.setToolTipText("");
        Country.setMinimumSize(new java.awt.Dimension(140, 29));
        Country.setPreferredSize(new java.awt.Dimension(140, 29));

        DEA_Reg_Num.setToolTipText("");
        DEA_Reg_Num.setMinimumSize(new java.awt.Dimension(140, 29));
        DEA_Reg_Num.setPreferredSize(new java.awt.Dimension(140, 29));

        Hospital_Pin.setToolTipText("");
        Hospital_Pin.setMinimumSize(new java.awt.Dimension(140, 29));
        Hospital_Pin.setPreferredSize(new java.awt.Dimension(140, 29));

        Medicare_Pin.setToolTipText("");
        Medicare_Pin.setMinimumSize(new java.awt.Dimension(140, 29));
        Medicare_Pin.setPreferredSize(new java.awt.Dimension(140, 29));

        Medicare_UPin.setToolTipText("");
        Medicare_UPin.setMinimumSize(new java.awt.Dimension(140, 29));
        Medicare_UPin.setPreferredSize(new java.awt.Dimension(140, 29));

        Medicaid_ID.setToolTipText("");
        Medicaid_ID.setMinimumSize(new java.awt.Dimension(100, 26));
        Medicaid_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        License_Exp.setToolTipText("");
        License_Exp.setMinimumSize(new java.awt.Dimension(100, 26));
        License_Exp.setPreferredSize(new java.awt.Dimension(140, 29));

        State_License.setToolTipText("");
        State_License.setMinimumSize(new java.awt.Dimension(100, 26));
        State_License.setPreferredSize(new java.awt.Dimension(140, 29));

        SSN.setToolTipText("");
        SSN.setMinimumSize(new java.awt.Dimension(100, 26));
        SSN.setPreferredSize(new java.awt.Dimension(140, 29));

        Position.setToolTipText("");
        Position.setMinimumSize(new java.awt.Dimension(100, 26));
        Position.setPreferredSize(new java.awt.Dimension(140, 29));

        Type.setToolTipText("");
        Type.setMinimumSize(new java.awt.Dimension(100, 26));
        Type.setPreferredSize(new java.awt.Dimension(140, 29));

        Int_Password.setToolTipText("");
        Int_Password.setMinimumSize(new java.awt.Dimension(100, 26));
        Int_Password.setPreferredSize(new java.awt.Dimension(140, 29));

        Prim_Emp_ID.setToolTipText("");
        Prim_Emp_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Prim_Emp_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Name_Suffix.setToolTipText("");
        Name_Suffix.setMinimumSize(new java.awt.Dimension(140, 29));
        Name_Suffix.setPreferredSize(new java.awt.Dimension(140, 29));

        UserName.setToolTipText("");
        UserName.setMinimumSize(new java.awt.Dimension(140, 29));
        UserName.setPreferredSize(new java.awt.Dimension(140, 29));

        Sig_Image.setToolTipText("");
        Sig_Image.setMinimumSize(new java.awt.Dimension(140, 29));
        Sig_Image.setPreferredSize(new java.awt.Dimension(140, 29));

        Staff_ID.setToolTipText("");
        Staff_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Staff_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Spec_ID.setToolTipText("");
        Spec_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Spec_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Pro_Org_ID.setToolTipText("");
        Pro_Org_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Pro_Org_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        MalPrac_POL.setToolTipText("");
        MalPrac_POL.setMinimumSize(new java.awt.Dimension(140, 29));
        MalPrac_POL.setPreferredSize(new java.awt.Dimension(140, 29));

        Cont_Sub_Exp.setToolTipText("");
        Cont_Sub_Exp.setMinimumSize(new java.awt.Dimension(140, 29));
        Cont_Sub_Exp.setPreferredSize(new java.awt.Dimension(140, 29));

        DEA_Exp.setToolTipText("");
        DEA_Exp.setMinimumSize(new java.awt.Dimension(140, 29));
        DEA_Exp.setPreferredSize(new java.awt.Dimension(140, 29));

        Comments.setToolTipText("");
        Comments.setMinimumSize(new java.awt.Dimension(100, 26));
        Comments.setPreferredSize(new java.awt.Dimension(140, 29));

        Org_ID.setToolTipText("");
        Org_ID.setMinimumSize(new java.awt.Dimension(100, 26));
        Org_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        State_CSN.setToolTipText("");
        State_CSN.setMinimumSize(new java.awt.Dimension(140, 29));
        State_CSN.setPreferredSize(new java.awt.Dimension(140, 29));

        DOB.setToolTipText("");
        DOB.setMinimumSize(new java.awt.Dimension(140, 29));
        DOB.setPreferredSize(new java.awt.Dimension(140, 29));

        Gender.setToolTipText("");
        Gender.setMinimumSize(new java.awt.Dimension(140, 29));
        Gender.setPreferredSize(new java.awt.Dimension(140, 29));

        Hospice_Emp.setToolTipText("");
        Hospice_Emp.setMinimumSize(new java.awt.Dimension(140, 29));
        Hospice_Emp.setPreferredSize(new java.awt.Dimension(140, 29));

        Emp_ID_Num.setToolTipText("");
        Emp_ID_Num.setMinimumSize(new java.awt.Dimension(140, 29));
        Emp_ID_Num.setPreferredSize(new java.awt.Dimension(140, 29));

        Nat_Pro_ID.setToolTipText("");
        Nat_Pro_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Nat_Pro_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Rel_to_Patient.setToolTipText("");
        Rel_to_Patient.setMinimumSize(new java.awt.Dimension(140, 29));
        Rel_to_Patient.setPreferredSize(new java.awt.Dimension(140, 29));

        CC_ID_Info.setToolTipText("");
        CC_ID_Info.setMinimumSize(new java.awt.Dimension(140, 29));
        CC_ID_Info.setPreferredSize(new java.awt.Dimension(140, 29));

        Sec_Emp_ID.setToolTipText("");
        Sec_Emp_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Sec_Emp_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel8.setText("Title");

        jLabel7.setText("Initals");

        jLabel6.setText("Middle Name");

        jLabel5.setText("Last Name");

        jLabel4.setText("First Name");

        jLabel3.setText("Active");

        jLabel2.setText("Old ID");

        jLabel1.setText("Person ID");

        Suffix.setToolTipText("");
        Suffix.setMinimumSize(new java.awt.Dimension(100, 26));
        Suffix.setPreferredSize(new java.awt.Dimension(140, 29));

        Claim_Sig_Auth.setToolTipText("");
        Claim_Sig_Auth.setMinimumSize(new java.awt.Dimension(100, 26));
        Claim_Sig_Auth.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel19.setText("Office Phone");

        jLabel18.setText("Other Specialty");

        jLabel17.setText("Specialty Discription");

        jLabel16.setText("Citizenship");

        jLabel15.setText("Country");

        jLabel14.setText("Zip Code");

        jLabel13.setText("State / Province / Region");

        jLabel49.setText("Credit Card ID Info");

        jLabel48.setText("Secondary Emplyer ID");

        jLabel47.setText("Primary Employer ID");

        jLabel46.setText("Name Suffix");

        jLabel12.setText("City");

        jLabel45.setText("Username");

        jLabel11.setText("Group Name");

        jLabel44.setText("Signature Image");

        jLabel10.setText("Address 2");

        jLabel43.setText("Staff ID");

        jLabel9.setText("Address 1");

        jLabel52.setText("Employer ID Number");

        jLabel51.setText("National Provider ID");

        jLabel50.setText("Relationship to Patient");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Specialty_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Other_Specialty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Office_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Office_Fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Citizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Zip_Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S_P_R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Group_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Address_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Address_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Initals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Middle_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(First_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Active, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Old_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Person_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(DEA_Reg_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hospital_Pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medicare_Pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medicare_UPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medicaid_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(License_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(State_License, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Int_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pro_Org_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MalPrac_POL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cont_Sub_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DEA_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fax_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Car_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel54)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel56)
                    .addComponent(jLabel47)
                    .addComponent(jLabel50)
                    .addComponent(jLabel53)
                    .addComponent(jLabel49)
                    .addComponent(jLabel55)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Suffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Claim_Sig_Auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Prim_Emp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name_Suffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sig_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Staff_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Spec_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Org_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(State_CSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hospice_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Emp_ID_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nat_Pro_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rel_to_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CC_ID_Info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sec_Emp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Spec_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Staff_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sig_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Name_Suffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Prim_Emp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sec_Emp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CC_ID_Info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rel_to_Patient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nat_Pro_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Emp_ID_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Hospice_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(State_CSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Org_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Claim_Sig_Auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Suffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Person_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Old_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Active, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(First_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Last_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Middle_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Initals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Address_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Address_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Group_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(S_P_R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Zip_Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Citizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Specialty_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Other_Specialty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Office_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Office_Fax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Medicare_UPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Medicare_Pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Hospital_Pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DEA_Reg_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DEA_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cont_Sub_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MalPrac_POL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Pro_Org_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Home_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Car_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fax_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Int_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(State_License, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(License_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Medicaid_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        jButton_Revert1.setText("Revert");
        jButton_Revert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Revert1ActionPerformed(evt);
            }
        });

        jButton_Insert.setText("Insert");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformed(evt);
            }
        });

        jButton_Delete.setText("Delete");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jButton_Update1.setText("Update");
        jButton_Update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Update1ActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Update1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Revert1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Delete)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Insert)
                    .addComponent(jButton_Revert1)
                    .addComponent(jButton_Update1)
                    .addComponent(jButton_Delete)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editModeToggler();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_Update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Update1ActionPerformed
        this.NewRecord = formToPerson();
        NewRecord.setDeleted(new Byte("0"));
        if (MainGUI.Classes.TestMain.updateRecord(NewRecord)) {
            JOptionPane.showMessageDialog(null, "Update Completed");
        } else {
            JOptionPane.showMessageDialog(null, "Update Failed");
        }
    }//GEN-LAST:event_jButton_Update1ActionPerformed

    private void jButton_Revert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Revert1ActionPerformed
        populateTabPerson(OriginalRecord);
        OriginalRecord.setDeleted(new Byte("0"));
        if (MainGUI.Classes.TestMain.updateRecord(OriginalRecord)) {
            JOptionPane.showMessageDialog(null, "Revert Completed");
        } else {
            JOptionPane.showMessageDialog(null, "Revert Failed");
        }

    }//GEN-LAST:event_jButton_Revert1ActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed
        this.NewRecord = formToPerson();
        NewRecord.setDeleted(new Byte("0"));
        if (MainGUI.Classes.TestMain.insertRecord(NewRecord)) {
            JOptionPane.showMessageDialog(null, "Insert Completed");
        } else {
            JOptionPane.showMessageDialog(null, "Insert Failed");
        }

    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        this.NewRecord = formToPerson();
        NewRecord.setDeleted(new Byte("1"));
        MainGUI.Classes.TestMain.deleteRecord(NewRecord);
        JOptionPane.showMessageDialog(null, "Delete Completed");
    }//GEN-LAST:event_jButton_DeleteActionPerformed
    private void editModeToggler() {
        if (inEditMode) {
            inEditMode = false;
            jButton_Delete.setVisible(false);
            jButton_Insert.setVisible(false);
            jButton_Revert1.setVisible(false);
            jButton_Update1.setVisible(false);
            Active.setEditable(inEditMode);
            Address_1.setEditable(inEditMode);
            Address_2.setEditable(inEditMode);
            CC_ID_Info.setEditable(inEditMode);
            Car_Phone.setEditable(inEditMode);
            Citizenship.setEditable(inEditMode);
            City.setEditable(inEditMode);
            Claim_Sig_Auth.setEditable(inEditMode);
            Comments.setEditable(inEditMode);
            Cont_Sub_Exp.setEditable(inEditMode);
            Country.setEditable(inEditMode);
            DEA_Exp.setEditable(inEditMode);
            DEA_Reg_Num.setEditable(inEditMode);
            DOB.setEditable(inEditMode);

            Email.setEditable(inEditMode);
            Emp_ID_Num.setEditable(inEditMode);
            Fax_Num.setEditable(inEditMode);
            First_Name.setEditable(inEditMode);
            Gender.setEditable(inEditMode);
            Group_Name.setEditable(inEditMode);
            Home_Phone.setEditable(inEditMode);
            Hospice_Emp.setEditable(inEditMode);
            Hospital_Pin.setEditable(inEditMode);
            Initals.setEditable(inEditMode);
            Int_Password.setEditable(inEditMode);
            Last_Name.setEditable(inEditMode);
            License_Exp.setEditable(inEditMode);
            MalPrac_POL.setEditable(inEditMode);
            Medicaid_ID.setEditable(inEditMode);
            Medicare_Pin.setEditable(inEditMode);
            Medicare_UPin.setEditable(inEditMode);
            Middle_Name.setEditable(inEditMode);
            Name_Suffix.setEditable(inEditMode);
            Nat_Pro_ID.setEditable(inEditMode);
            Office_Fax.setEditable(inEditMode);
            Office_Phone.setEditable(inEditMode);
            Old_ID.setEditable(inEditMode);
            Org_ID.setEditable(inEditMode);
            Other_Specialty.setEditable(inEditMode);
            Pager.setEditable(inEditMode);
            Person_ID.setEditable(inEditMode);
            Position.setEditable(inEditMode);
            Prim_Emp_ID.setEditable(inEditMode);
            Pro_Org_ID.setEditable(inEditMode);
            Rel_to_Patient.setEditable(inEditMode);
            SSN.setEditable(inEditMode);
            S_P_R.setEditable(inEditMode);
            Sec_Emp_ID.setEditable(inEditMode);
            Sig_Image.setEditable(inEditMode);
            Spec_ID.setEditable(inEditMode);
            Specialty_Disc.setEditable(inEditMode);
            Staff_ID.setEditable(inEditMode);
            State_CSN.setEditable(inEditMode);
            State_License.setEditable(inEditMode);
            Suffix.setEditable(inEditMode);
            Title.setEditable(inEditMode);
            Type.setEditable(inEditMode);
            UserName.setEditable(inEditMode);
            Zip_Code.setEditable(inEditMode);
            Active.setBackground(Color.LIGHT_GRAY);
            Address_1.setBackground(Color.LIGHT_GRAY);
            Address_2.setBackground(Color.LIGHT_GRAY);
            CC_ID_Info.setBackground(Color.LIGHT_GRAY);
            Car_Phone.setBackground(Color.LIGHT_GRAY);
            Citizenship.setBackground(Color.LIGHT_GRAY);
            City.setBackground(Color.LIGHT_GRAY);
            Claim_Sig_Auth.setBackground(Color.LIGHT_GRAY);
            Comments.setBackground(Color.LIGHT_GRAY);
            Cont_Sub_Exp.setBackground(Color.LIGHT_GRAY);
            Country.setBackground(Color.LIGHT_GRAY);
            DEA_Exp.setBackground(Color.LIGHT_GRAY);
            DEA_Reg_Num.setBackground(Color.LIGHT_GRAY);
            DOB.setBackground(Color.LIGHT_GRAY);

            Email.setBackground(Color.LIGHT_GRAY);
            Emp_ID_Num.setBackground(Color.LIGHT_GRAY);
            Fax_Num.setBackground(Color.LIGHT_GRAY);
            First_Name.setBackground(Color.LIGHT_GRAY);
            Gender.setBackground(Color.LIGHT_GRAY);
            Group_Name.setBackground(Color.LIGHT_GRAY);
            Home_Phone.setBackground(Color.LIGHT_GRAY);
            Hospice_Emp.setBackground(Color.LIGHT_GRAY);
            Hospital_Pin.setBackground(Color.LIGHT_GRAY);
            Initals.setBackground(Color.LIGHT_GRAY);
            Int_Password.setBackground(Color.LIGHT_GRAY);
            Last_Name.setBackground(Color.LIGHT_GRAY);
            License_Exp.setBackground(Color.LIGHT_GRAY);
            MalPrac_POL.setBackground(Color.LIGHT_GRAY);
            Medicaid_ID.setBackground(Color.LIGHT_GRAY);
            Medicare_Pin.setBackground(Color.LIGHT_GRAY);
            Medicare_UPin.setBackground(Color.LIGHT_GRAY);
            Middle_Name.setBackground(Color.LIGHT_GRAY);
            Name_Suffix.setBackground(Color.LIGHT_GRAY);
            Nat_Pro_ID.setBackground(Color.LIGHT_GRAY);
            Office_Fax.setBackground(Color.LIGHT_GRAY);
            Office_Phone.setBackground(Color.LIGHT_GRAY);
            Old_ID.setBackground(Color.LIGHT_GRAY);
            Org_ID.setBackground(Color.LIGHT_GRAY);
            Other_Specialty.setBackground(Color.LIGHT_GRAY);
            Pager.setBackground(Color.LIGHT_GRAY);
            Person_ID.setBackground(Color.LIGHT_GRAY);
            Position.setBackground(Color.LIGHT_GRAY);
            Prim_Emp_ID.setBackground(Color.LIGHT_GRAY);
            Pro_Org_ID.setBackground(Color.LIGHT_GRAY);
            Rel_to_Patient.setBackground(Color.LIGHT_GRAY);
            SSN.setBackground(Color.LIGHT_GRAY);
            S_P_R.setBackground(Color.LIGHT_GRAY);
            Sec_Emp_ID.setBackground(Color.LIGHT_GRAY);
            Sig_Image.setBackground(Color.LIGHT_GRAY);
            Spec_ID.setBackground(Color.LIGHT_GRAY);
            Specialty_Disc.setBackground(Color.LIGHT_GRAY);
            Staff_ID.setBackground(Color.LIGHT_GRAY);
            State_CSN.setBackground(Color.LIGHT_GRAY);
            State_License.setBackground(Color.LIGHT_GRAY);
            Suffix.setBackground(Color.LIGHT_GRAY);
            Title.setBackground(Color.LIGHT_GRAY);
            Type.setBackground(Color.LIGHT_GRAY);
            UserName.setBackground(Color.LIGHT_GRAY);
            Zip_Code.setBackground(Color.LIGHT_GRAY);
        } else {
            inEditMode = true;
            jButton_Delete.setVisible(true);
            jButton_Insert.setVisible(true);
            jButton_Revert1.setVisible(true);
            jButton_Update1.setVisible(true);
            Active.setEditable(inEditMode);
            Address_1.setEditable(inEditMode);
            Address_2.setEditable(inEditMode);
            CC_ID_Info.setEditable(inEditMode);
            Car_Phone.setEditable(inEditMode);
            Citizenship.setEditable(inEditMode);
            City.setEditable(inEditMode);
            Claim_Sig_Auth.setEditable(inEditMode);
            Comments.setEditable(inEditMode);
            Cont_Sub_Exp.setEditable(inEditMode);
            Country.setEditable(inEditMode);
            DEA_Exp.setEditable(inEditMode);
            DEA_Reg_Num.setEditable(inEditMode);
            DOB.setEditable(inEditMode);

            Email.setEditable(inEditMode);
            Emp_ID_Num.setEditable(inEditMode);
            Fax_Num.setEditable(inEditMode);
            First_Name.setEditable(inEditMode);
            Gender.setEditable(inEditMode);
            Group_Name.setEditable(inEditMode);
            Home_Phone.setEditable(inEditMode);
            Hospice_Emp.setEditable(inEditMode);
            Hospital_Pin.setEditable(inEditMode);
            Initals.setEditable(inEditMode);
            Int_Password.setEditable(inEditMode);
            Last_Name.setEditable(inEditMode);
            License_Exp.setEditable(inEditMode);
            MalPrac_POL.setEditable(inEditMode);
            Medicaid_ID.setEditable(inEditMode);
            Medicare_Pin.setEditable(inEditMode);
            Medicare_UPin.setEditable(inEditMode);
            Middle_Name.setEditable(inEditMode);
            Name_Suffix.setEditable(inEditMode);
            Nat_Pro_ID.setEditable(inEditMode);
            Office_Fax.setEditable(inEditMode);
            Office_Phone.setEditable(inEditMode);
            Old_ID.setEditable(inEditMode);
            Org_ID.setEditable(inEditMode);
            Other_Specialty.setEditable(inEditMode);
            Pager.setEditable(inEditMode);
            Person_ID.setEditable(inEditMode);
            Position.setEditable(inEditMode);
            Prim_Emp_ID.setEditable(inEditMode);
            Pro_Org_ID.setEditable(inEditMode);
            Rel_to_Patient.setEditable(inEditMode);
            SSN.setEditable(inEditMode);
            S_P_R.setEditable(inEditMode);
            Sec_Emp_ID.setEditable(inEditMode);
            Sig_Image.setEditable(inEditMode);
            Spec_ID.setEditable(inEditMode);
            Specialty_Disc.setEditable(inEditMode);
            Staff_ID.setEditable(inEditMode);
            State_CSN.setEditable(inEditMode);
            State_License.setEditable(inEditMode);
            Suffix.setEditable(inEditMode);
            Title.setEditable(inEditMode);
            Type.setEditable(inEditMode);
            UserName.setEditable(inEditMode);
            Zip_Code.setEditable(inEditMode);
            Active.setBackground(Color.WHITE);
            Address_1.setBackground(Color.WHITE);
            Address_2.setBackground(Color.WHITE);
            CC_ID_Info.setBackground(Color.WHITE);
            Car_Phone.setBackground(Color.WHITE);
            Citizenship.setBackground(Color.WHITE);
            City.setBackground(Color.WHITE);
            Claim_Sig_Auth.setBackground(Color.WHITE);
            Comments.setBackground(Color.WHITE);
            Cont_Sub_Exp.setBackground(Color.WHITE);
            Country.setBackground(Color.WHITE);
            DEA_Exp.setBackground(Color.WHITE);
            DEA_Reg_Num.setBackground(Color.WHITE);
            DOB.setBackground(Color.WHITE);

            Email.setBackground(Color.WHITE);
            Emp_ID_Num.setBackground(Color.WHITE);
            Fax_Num.setBackground(Color.WHITE);
            First_Name.setBackground(Color.WHITE);
            Gender.setBackground(Color.WHITE);
            Group_Name.setBackground(Color.WHITE);
            Home_Phone.setBackground(Color.WHITE);
            Hospice_Emp.setBackground(Color.WHITE);
            Hospital_Pin.setBackground(Color.WHITE);
            Initals.setBackground(Color.WHITE);
            Int_Password.setBackground(Color.WHITE);
            Last_Name.setBackground(Color.WHITE);
            License_Exp.setBackground(Color.WHITE);
            MalPrac_POL.setBackground(Color.WHITE);
            Medicaid_ID.setBackground(Color.WHITE);
            Medicare_Pin.setBackground(Color.WHITE);
            Medicare_UPin.setBackground(Color.WHITE);
            Middle_Name.setBackground(Color.WHITE);
            Name_Suffix.setBackground(Color.WHITE);
            Nat_Pro_ID.setBackground(Color.WHITE);
            Office_Fax.setBackground(Color.WHITE);
            Office_Phone.setBackground(Color.WHITE);
            Old_ID.setBackground(Color.WHITE);
            Org_ID.setBackground(Color.WHITE);
            Other_Specialty.setBackground(Color.WHITE);
            Pager.setBackground(Color.WHITE);
            Person_ID.setBackground(Color.WHITE);
            Position.setBackground(Color.WHITE);
            Prim_Emp_ID.setBackground(Color.WHITE);
            Pro_Org_ID.setBackground(Color.WHITE);
            Rel_to_Patient.setBackground(Color.WHITE);
            SSN.setBackground(Color.WHITE);
            S_P_R.setBackground(Color.WHITE);
            Sec_Emp_ID.setBackground(Color.WHITE);
            Sig_Image.setBackground(Color.WHITE);
            Spec_ID.setBackground(Color.WHITE);
            Specialty_Disc.setBackground(Color.WHITE);
            Staff_ID.setBackground(Color.WHITE);
            State_CSN.setBackground(Color.WHITE);
            State_License.setBackground(Color.WHITE);
            Suffix.setBackground(Color.WHITE);
            Title.setBackground(Color.WHITE);
            Type.setBackground(Color.WHITE);
            UserName.setBackground(Color.WHITE);
            Zip_Code.setBackground(Color.WHITE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Active;
    private javax.swing.JTextField Address_1;
    private javax.swing.JTextField Address_2;
    private javax.swing.JTextField CC_ID_Info;
    private javax.swing.JTextField Car_Phone;
    private javax.swing.JTextField Citizenship;
    private javax.swing.JTextField City;
    private javax.swing.JTextField Claim_Sig_Auth;
    private javax.swing.JTextField Comments;
    private javax.swing.JTextField Cont_Sub_Exp;
    private javax.swing.JTextField Country;
    private javax.swing.JTextField DEA_Exp;
    private javax.swing.JTextField DEA_Reg_Num;
    private javax.swing.JTextField DOB;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Emp_ID_Num;
    private javax.swing.JTextField Fax_Num;
    private javax.swing.JTextField First_Name;
    private javax.swing.JTextField Gender;
    private javax.swing.JTextField Group_Name;
    private javax.swing.JTextField Home_Phone;
    private javax.swing.JTextField Hospice_Emp;
    private javax.swing.JTextField Hospital_Pin;
    private javax.swing.JTextField Initals;
    private javax.swing.JTextField Int_Password;
    private javax.swing.JTextField Last_Name;
    private javax.swing.JTextField License_Exp;
    private javax.swing.JTextField MalPrac_POL;
    private javax.swing.JTextField Medicaid_ID;
    private javax.swing.JTextField Medicare_Pin;
    private javax.swing.JTextField Medicare_UPin;
    private javax.swing.JTextField Middle_Name;
    private javax.swing.JTextField Name_Suffix;
    private javax.swing.JTextField Nat_Pro_ID;
    private javax.swing.JTextField Office_Fax;
    private javax.swing.JTextField Office_Phone;
    private javax.swing.JTextField Old_ID;
    private javax.swing.JTextField Org_ID;
    private javax.swing.JTextField Other_Specialty;
    private javax.swing.JTextField Pager;
    private javax.swing.JTextField Person_ID;
    private javax.swing.JTextField Position;
    private javax.swing.JTextField Prim_Emp_ID;
    private javax.swing.JTextField Pro_Org_ID;
    private javax.swing.JTextField Rel_to_Patient;
    private javax.swing.JTextField SSN;
    private javax.swing.JTextField S_P_R;
    private javax.swing.JTextField Sec_Emp_ID;
    private javax.swing.JTextField Sig_Image;
    private javax.swing.JTextField Spec_ID;
    private javax.swing.JTextField Specialty_Disc;
    private javax.swing.JTextField Staff_ID;
    private javax.swing.JTextField State_CSN;
    private javax.swing.JTextField State_License;
    private javax.swing.JTextField Suffix;
    private javax.swing.JTextField Title;
    private javax.swing.JTextField Type;
    private javax.swing.JTextField UserName;
    private javax.swing.JTextField Zip_Code;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_Revert1;
    private javax.swing.JButton jButton_Update1;
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
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
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
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
