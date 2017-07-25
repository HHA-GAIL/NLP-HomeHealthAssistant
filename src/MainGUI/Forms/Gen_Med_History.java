package MainGUI.Forms;

import MainGUI.Classes.GeneralMedicalHistory;
import MainGUI.DAO.GeneralMedicalHistoryDAO;
import java.awt.Color;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * revise
 * 
 * @author Fan Hu
 */
public final class Gen_Med_History extends javax.swing.JInternalFrame {

    MainGUI.Classes.GeneralMedicalHistory OriginalRecord, NewRecord;
    Boolean inEditMode = true;
    GeneralMedicalHistoryDAO dao;

    public Gen_Med_History() {
        dao = new GeneralMedicalHistoryDAO();
        initComponents();
        editModeToggler();
    }

    public Gen_Med_History(int ID) {
        dao = new GeneralMedicalHistoryDAO();
        initComponents();
        editModeToggler();
        this.OriginalRecord = MainGUI.Classes.TestMain.getGeneralMedicalHistory(ID);
        populateTabGeneralMedicalHistory(OriginalRecord);
    }

    public void populateTabGeneralMedicalHistory(MainGUI.Classes.GeneralMedicalHistory generalMedicalHist) {
        Marital_status.setText(generalMedicalHist.getMaritalStatus());
        EDU.setText(generalMedicalHist.getEducation());
        GaD.setText(generalMedicalHist.getGrowthAndDevelopment());
        Preg.setText(generalMedicalHist.getPregnancies());
        Beh_Hist.setText(generalMedicalHist.getBehavioralHistory());
        Tobacco.setText(generalMedicalHist.getTobacco());
        TQuant.setText(generalMedicalHist.getTobaccoQuantity());
        TDur.setText(generalMedicalHist.getTobaccoduraton());
        Alcohol.setText(generalMedicalHist.getAlcohol());
        AQuant.setText(generalMedicalHist.getAlcoholQuantity());
        ADur.setText(generalMedicalHist.getAlcoholduration());
        Drug.setText(generalMedicalHist.getDrug());
        DType.setText(generalMedicalHist.getDrugType());
        DDur.setText(generalMedicalHist.getDrugduration());
        Dietary.setText(generalMedicalHist.getDietary());
        Travel.setText(generalMedicalHist.getTravel());
        BloodType.setText(generalMedicalHist.getBloodType());
        RH.setText(generalMedicalHist.getRh());
        Med_Hist_Notes.setText(generalMedicalHist.getMedicalHistoryNotes());
        HxOB.setText(generalMedicalHist.getHxObtainedBy());
        UTOHxReason.setText(generalMedicalHist.getUnableToObtainHxReason());
        LMPStatus.setText(generalMedicalHist.getLMPStatus());
        EDC.setText(generalMedicalHist.getEDC().toString());
        LMPEst.setText(generalMedicalHist.getLMPEstMethod());
        MensesFreq.setText(generalMedicalHist.getMensesFreq());
        HoD.setText(generalMedicalHist.getHospitalOfDelivery());
        EGA.setText(generalMedicalHist.getEGA());
        Gen_Med_Hist_ID.setText(Integer.toString(generalMedicalHist.getGeneralMedicalHistoryID()));
        Patient_ID.setText(Integer.toString(generalMedicalHist.getPatientID()));
        NoC.setText(Integer.toString(generalMedicalHist.getNumberOfChildren()));
        NoP.setText(Integer.toString(generalMedicalHist.getNumberOfPregnancies()));
        MAoO.setText(Integer.toString(generalMedicalHist.getMenarcheAgeOfOnset()));
        T_HRF.setText(Byte.toString(generalMedicalHist.getTobaccoHRF()));
        A_HRF.setText(Byte.toString(generalMedicalHist.getAlcoholHRF()));
        D_HRF.setText(Byte.toString(generalMedicalHist.getDrugHRF()));
        Diet_HRF.setText(Byte.toString(generalMedicalHist.getDietHRF()));
        T_HRF.setText(Byte.toString(generalMedicalHist.getTravelHRF()));
        HxC_HCP.setText(Byte.toString(generalMedicalHist.getHxConfirmedByHCP()));

        LMP.setText(Byte.toString(generalMedicalHist.getLMP()));
        gmh_Preg.setText(Byte.toString(generalMedicalHist.getPregnant()));

        LMP_Date_Approx.setText(Byte.toString(generalMedicalHist.getLMPDateApprox()));
        MAN_No.setText(Byte.toString(generalMedicalHist.getMenstrualAmtNormalNo()));
        MM_Yes.setText(Byte.toString(generalMedicalHist.getMensesMonthlyYes()));
        MM_No.setText(Byte.toString(generalMedicalHist.getMensesMonthlyNo()));
        BCP_Yes.setText(Byte.toString(generalMedicalHist.getOnBCPAtConceptionYes()));
        BCP_No.setText(Byte.toString(generalMedicalHist.getOnBCPAtConceptionNo()));
        LMP_Date.setText(generalMedicalHist.getLMPDate().toString());
        PDD.setText(generalMedicalHist.getPregnancyDueDate().toString());
        MPD.setText(generalMedicalHist.getMensesPriorDate().toString());
    }

    public GeneralMedicalHistory formToGeneralMedicalHistory() {
        GeneralMedicalHistory generalMedicalHist = new GeneralMedicalHistory();
        generalMedicalHist.setMaritalStatus(Marital_status.getText());
        generalMedicalHist.setEducation(EDU.getText());
        generalMedicalHist.setGrowthAndDevelopment(GaD.getText());
        generalMedicalHist.setPregnancies(Preg.getText());
        generalMedicalHist.setBehavioralHistory(Beh_Hist.getText());
        generalMedicalHist.setTobacco(Tobacco.getText());
        generalMedicalHist.setTobaccoQuantity(TQuant.getText());
        generalMedicalHist.setTobaccoduraton(TDur.getText());
        generalMedicalHist.setAlcohol(Alcohol.getText());
        generalMedicalHist.setAlcoholQuantity(AQuant.getText());
        generalMedicalHist.setAlcoholduration(ADur.getText());
        generalMedicalHist.setDrug(Drug.getText());
        generalMedicalHist.setDrugType(DType.getText());
        generalMedicalHist.setDrugduration(DDur.getText());
        generalMedicalHist.setDietary(Dietary.getText());
        generalMedicalHist.setTravel(Travel.getText());
        generalMedicalHist.setBloodType(BloodType.getText());
        generalMedicalHist.setRh(RH.getText());
        generalMedicalHist.setMedicalHistoryNotes(Med_Hist_Notes.getText());
        generalMedicalHist.setHxObtainedBy(HxOB.getText());
        generalMedicalHist.setUnableToObtainHxReason(UTOHxReason.getText());
        generalMedicalHist.setLMPStatus(LMPStatus.getText());

        generalMedicalHist.setLMPEstMethod(LMPEst.getText());
        generalMedicalHist.setMensesFreq(MensesFreq.getText());
        generalMedicalHist.setHospitalOfDelivery(HoD.getText());
        generalMedicalHist.setEGA(EGA.getText());
        generalMedicalHist.setGeneralMedicalHistoryID(Integer.parseInt(Gen_Med_Hist_ID.getText()));
        generalMedicalHist.setPatientID(Integer.parseInt(Patient_ID.getText()));
        generalMedicalHist.setNumberOfChildren(Integer.parseInt(NoC.getText()));
        generalMedicalHist.setNumberOfPregnancies(Integer.parseInt(NoP.getText()));
        generalMedicalHist.setMenarcheAgeOfOnset(Integer.parseInt(MAoO.getText()));
        generalMedicalHist.setTobaccoHRF(Byte.parseByte(T_HRF.getText()));
        generalMedicalHist.setAlcoholHRF(Byte.parseByte(A_HRF.getText()));
        generalMedicalHist.setDrugHRF(Byte.parseByte(D_HRF.getText()));
        generalMedicalHist.setDietHRF(Byte.parseByte(Diet_HRF.getText()));
        generalMedicalHist.setTravelHRF(Byte.parseByte(T_HRF.getText()));
        generalMedicalHist.setHxConfirmedByHCP(Byte.parseByte(HxC_HCP.getText()));
        generalMedicalHist.setDeleted(new Byte("0"));
        generalMedicalHist.setLMP(Byte.parseByte(LMP.getText()));
        generalMedicalHist.setPregnant(Byte.parseByte(gmh_Preg.getText()));

        generalMedicalHist.setLMPDateApprox(Byte.parseByte(LMP_Date_Approx.getText()));
        generalMedicalHist.setMenstrualAmtNormalNo(Byte.parseByte(MAN_No.getText()));
        generalMedicalHist.setMensesMonthlyYes(Byte.parseByte(MM_Yes.getText()));
        generalMedicalHist.setMensesMonthlyNo(Byte.parseByte(MM_No.getText()));
        generalMedicalHist.setOnBCPAtConceptionYes(Byte.parseByte(BCP_Yes.getText()));
        generalMedicalHist.setOnBCPAtConceptionNo(Byte.parseByte(BCP_No.getText()));

        try {
            java.util.Date date;
            java.sql.Date sqlStartDate;
            if (!LMP_Date.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(LMP_Date.getText());
                sqlStartDate = new Date(date.getTime());
                generalMedicalHist.setLMPDate(sqlStartDate);
            }
            if (!PDD.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(PDD.getText());
                sqlStartDate = new Date(date.getTime());
                generalMedicalHist.setPregnancyDueDate(sqlStartDate);
            }
            if (!MPD.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(MPD.getText());
                sqlStartDate = new Date(date.getTime());
                generalMedicalHist.setMensesPriorDate(sqlStartDate);
            }

            if (!EDC.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(MPD.getText());
                sqlStartDate = new Date(date.getTime());
                generalMedicalHist.setEDC(sqlStartDate);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return generalMedicalHist;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Update = new javax.swing.JButton();
        jButton_Revert = new javax.swing.JButton();
        jButton_Insert = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Med_Hist_Notes = new javax.swing.JTextField();
        HxOB = new javax.swing.JTextField();
        HxC_HCP = new javax.swing.JTextField();
        UTOHxReason = new javax.swing.JTextField();
        MAN_Yes = new javax.swing.JTextField();
        MAN_No = new javax.swing.JTextField();
        MM_Yes = new javax.swing.JTextField();
        MM_No = new javax.swing.JTextField();
        MPD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Gen_Med_Hist_ID = new javax.swing.JTextField();
        Patient_ID = new javax.swing.JTextField();
        Marital_status = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        EDU = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        GaD = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Preg = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        Beh_Hist = new javax.swing.JTextField();
        Tobacco = new javax.swing.JTextField();
        T_HRF = new javax.swing.JTextField();
        TQuant = new javax.swing.JTextField();
        Diet_HRF = new javax.swing.JTextField();
        Travel = new javax.swing.JTextField();
        Travel_HRF = new javax.swing.JTextField();
        BloodType = new javax.swing.JTextField();
        RH = new javax.swing.JTextField();
        EDC = new javax.swing.JTextField();
        NoP = new javax.swing.JTextField();
        LMPEst = new javax.swing.JTextField();
        MensesFreq = new javax.swing.JTextField();
        MAoO = new javax.swing.JTextField();
        BCP_Yes = new javax.swing.JTextField();
        BCP_No = new javax.swing.JTextField();
        HoD = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        TDur = new javax.swing.JTextField();
        Alcohol = new javax.swing.JTextField();
        A_HRF = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        AQuant = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        ADur = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Drug = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        D_HRF = new javax.swing.JTextField();
        DType = new javax.swing.JTextField();
        DDur = new javax.swing.JTextField();
        Dietary = new javax.swing.JTextField();
        LMP_Date = new javax.swing.JTextField();
        LMPStatus = new javax.swing.JTextField();
        LMP = new javax.swing.JTextField();
        gmh_Preg = new javax.swing.JTextField();
        PDD = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        EGA = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        LMP_Date_Approx = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        NoC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("General Medical History");
        setPreferredSize(new java.awt.Dimension(1020, 820));

        jButton_Update.setText("Update");
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_Revert.setText("Revert");
        jButton_Revert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RevertActionPerformed(evt);
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

        Med_Hist_Notes.setMinimumSize(new java.awt.Dimension(140, 29));
        Med_Hist_Notes.setPreferredSize(new java.awt.Dimension(140, 29));

        HxOB.setMinimumSize(new java.awt.Dimension(140, 29));
        HxOB.setPreferredSize(new java.awt.Dimension(140, 29));

        HxC_HCP.setMinimumSize(new java.awt.Dimension(140, 29));
        HxC_HCP.setPreferredSize(new java.awt.Dimension(140, 29));

        UTOHxReason.setMinimumSize(new java.awt.Dimension(140, 29));
        UTOHxReason.setPreferredSize(new java.awt.Dimension(140, 29));

        MAN_Yes.setMinimumSize(new java.awt.Dimension(140, 29));
        MAN_Yes.setPreferredSize(new java.awt.Dimension(140, 29));

        MAN_No.setMinimumSize(new java.awt.Dimension(140, 29));
        MAN_No.setPreferredSize(new java.awt.Dimension(140, 29));

        MM_Yes.setMinimumSize(new java.awt.Dimension(140, 29));
        MM_Yes.setPreferredSize(new java.awt.Dimension(140, 29));

        MM_No.setMinimumSize(new java.awt.Dimension(140, 29));
        MM_No.setPreferredSize(new java.awt.Dimension(140, 29));

        MPD.setMinimumSize(new java.awt.Dimension(140, 29));
        MPD.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel1.setText("General Medical History ID");

        jLabel2.setText("Patient ID");

        jLabel3.setText("Martial Status");

        jLabel4.setText("Education");

        jLabel5.setText("Growth and Development");

        jLabel6.setText("Pregnancies");

        jLabel7.setText("Behavioral History");

        jLabel8.setText("Tobacco");

        jLabel9.setText("Tobacco HRF");

        jLabel10.setText("Tobacco Quantity");

        Gen_Med_Hist_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Gen_Med_Hist_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Patient_ID.setMinimumSize(new java.awt.Dimension(140, 29));
        Patient_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Marital_status.setMinimumSize(new java.awt.Dimension(140, 29));
        Marital_status.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel11.setText("Diet HRf");

        EDU.setMinimumSize(new java.awt.Dimension(140, 29));
        EDU.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel12.setText("Travel");

        GaD.setMinimumSize(new java.awt.Dimension(140, 29));
        GaD.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel13.setText("Travel HRF");

        jLabel14.setText("Blood Type");

        jLabel15.setText("Rh");

        jLabel16.setText("Medical History Notes");

        jLabel17.setText("Hx Obtained By");

        jLabel18.setText("Hx Confirmed By HCP");

        jLabel19.setText("Unable to Obtain Hx Reason");

        jLabel21.setText("Menstrual Amount Normal Yes");

        jLabel22.setText("Menstrual Amount Normal No");

        jLabel23.setText("Menses Monthly Yes");

        jLabel24.setText("Menses Monthly No");

        Preg.setMinimumSize(new java.awt.Dimension(140, 29));
        Preg.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel25.setText("Menses Prior Date");

        Beh_Hist.setMinimumSize(new java.awt.Dimension(140, 29));
        Beh_Hist.setPreferredSize(new java.awt.Dimension(140, 29));

        Tobacco.setMinimumSize(new java.awt.Dimension(140, 29));
        Tobacco.setPreferredSize(new java.awt.Dimension(140, 29));

        T_HRF.setMinimumSize(new java.awt.Dimension(140, 29));
        T_HRF.setPreferredSize(new java.awt.Dimension(140, 29));

        TQuant.setMinimumSize(new java.awt.Dimension(140, 29));
        TQuant.setPreferredSize(new java.awt.Dimension(140, 29));

        Diet_HRF.setMinimumSize(new java.awt.Dimension(140, 29));
        Diet_HRF.setPreferredSize(new java.awt.Dimension(140, 29));

        Travel.setMinimumSize(new java.awt.Dimension(140, 29));
        Travel.setPreferredSize(new java.awt.Dimension(140, 29));

        Travel_HRF.setMinimumSize(new java.awt.Dimension(140, 29));
        Travel_HRF.setPreferredSize(new java.awt.Dimension(140, 29));

        BloodType.setMinimumSize(new java.awt.Dimension(140, 29));
        BloodType.setPreferredSize(new java.awt.Dimension(140, 29));

        RH.setMinimumSize(new java.awt.Dimension(140, 29));
        RH.setPreferredSize(new java.awt.Dimension(140, 29));

        EDC.setMinimumSize(new java.awt.Dimension(140, 29));
        EDC.setPreferredSize(new java.awt.Dimension(140, 29));

        NoP.setMinimumSize(new java.awt.Dimension(140, 29));
        NoP.setPreferredSize(new java.awt.Dimension(140, 29));

        LMPEst.setMinimumSize(new java.awt.Dimension(140, 29));
        LMPEst.setPreferredSize(new java.awt.Dimension(140, 29));

        MensesFreq.setMinimumSize(new java.awt.Dimension(140, 29));
        MensesFreq.setPreferredSize(new java.awt.Dimension(140, 29));

        MAoO.setMinimumSize(new java.awt.Dimension(140, 29));
        MAoO.setPreferredSize(new java.awt.Dimension(140, 29));

        BCP_Yes.setMinimumSize(new java.awt.Dimension(140, 29));
        BCP_Yes.setPreferredSize(new java.awt.Dimension(140, 29));

        BCP_No.setMinimumSize(new java.awt.Dimension(140, 29));
        BCP_No.setPreferredSize(new java.awt.Dimension(140, 29));

        HoD.setMinimumSize(new java.awt.Dimension(140, 29));
        HoD.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel26.setText("Tobacco Duration");

        jLabel27.setText("Alcohol");

        jLabel28.setText("Alcohol HRF");

        jLabel29.setText("Alcohol Quantity");

        jLabel30.setText("Alcholo Duration");

        jLabel31.setText("Drug");

        jLabel32.setText("Drug HRF");

        jLabel33.setText("Drug Type");

        jLabel34.setText("Drug Duration");

        jLabel35.setText("Dietary");

        TDur.setMinimumSize(new java.awt.Dimension(140, 29));
        TDur.setPreferredSize(new java.awt.Dimension(140, 29));

        Alcohol.setMinimumSize(new java.awt.Dimension(140, 29));
        Alcohol.setPreferredSize(new java.awt.Dimension(140, 29));

        A_HRF.setMinimumSize(new java.awt.Dimension(140, 29));
        A_HRF.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel36.setText("LMP Date");

        AQuant.setMinimumSize(new java.awt.Dimension(140, 29));
        AQuant.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel37.setText("LMP Status");

        ADur.setMinimumSize(new java.awt.Dimension(140, 29));
        ADur.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel38.setText("LMP");

        jLabel39.setText("Pregnant");

        jLabel40.setText("Pregnancy Due Date");

        jLabel42.setText("Number of Children");

        jLabel43.setText("Number of Pregnancies");

        jLabel44.setText("LMP Est Method");

        jLabel46.setText("Menses Freq");

        jLabel47.setText("Menarche Age of Onset");

        jLabel48.setText("On BCP at Conception Yes");

        jLabel49.setText("On BCP at Conception No");

        Drug.setMinimumSize(new java.awt.Dimension(140, 29));
        Drug.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel50.setText("Hospital of Delivery");

        D_HRF.setMinimumSize(new java.awt.Dimension(140, 29));
        D_HRF.setPreferredSize(new java.awt.Dimension(140, 29));

        DType.setMinimumSize(new java.awt.Dimension(140, 29));
        DType.setPreferredSize(new java.awt.Dimension(140, 29));

        DDur.setMinimumSize(new java.awt.Dimension(140, 29));
        DDur.setPreferredSize(new java.awt.Dimension(140, 29));
        DDur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DDurActionPerformed(evt);
            }
        });

        Dietary.setMinimumSize(new java.awt.Dimension(140, 29));
        Dietary.setPreferredSize(new java.awt.Dimension(140, 29));

        LMP_Date.setMinimumSize(new java.awt.Dimension(140, 29));
        LMP_Date.setPreferredSize(new java.awt.Dimension(140, 29));

        LMPStatus.setMinimumSize(new java.awt.Dimension(140, 29));
        LMPStatus.setPreferredSize(new java.awt.Dimension(140, 29));

        LMP.setMinimumSize(new java.awt.Dimension(140, 29));
        LMP.setPreferredSize(new java.awt.Dimension(140, 29));

        gmh_Preg.setMinimumSize(new java.awt.Dimension(140, 29));
        gmh_Preg.setPreferredSize(new java.awt.Dimension(140, 29));

        PDD.setMinimumSize(new java.awt.Dimension(140, 29));
        PDD.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel51.setText("EGA");

        EGA.setMinimumSize(new java.awt.Dimension(140, 29));
        EGA.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel52.setText("EDC");

        LMP_Date_Approx.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel53.setText("LMP Date Approx");

        NoC.setMinimumSize(new java.awt.Dimension(140, 29));
        NoC.setPreferredSize(new java.awt.Dimension(140, 29));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(99, 99, 99))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(47, 47, 47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gen_Med_Hist_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Marital_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EDU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Preg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Beh_Hist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tobacco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LMP_Date_Approx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(D_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Drug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ADur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Alcohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TDur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DDur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel52)
                            .addComponent(jLabel40)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Travel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Diet_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Travel_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Med_Hist_Notes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HxOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HxC_HCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UTOHxReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LMP_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LMPStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gmh_Preg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LMPEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Dietary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel50)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49)
                    .addComponent(jLabel23)
                    .addComponent(jLabel48)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(MAN_Yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAN_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MM_Yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MM_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MPD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MensesFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAoO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCP_Yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCP_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Gen_Med_Hist_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Marital_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EDU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Preg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Beh_Hist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Tobacco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(T_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LMP_Date_Approx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TDur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Alcohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(A_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ADur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Drug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(D_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Dietary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Diet_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Travel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Travel_HRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Med_Hist_Notes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(HxOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(HxC_HCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(UTOHxReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LMP_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MAN_Yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MAN_No, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MM_Yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MM_No, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MPD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MensesFreq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MAoO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel47))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BCP_Yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel48))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BCP_No, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel49))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EGA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel50))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(HoD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel51))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LMPStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gmh_Preg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LMPEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(DDur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Delete)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Insert)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Revert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Update))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Update)
                    .addComponent(jButton_Revert)
                    .addComponent(jButton_Insert)
                    .addComponent(jButton_Delete)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editModeToggler();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
//        this.NewRecord = formToGeneralMedicalHistory();
        GeneralMedicalHistory g = new GeneralMedicalHistory();
        g.setGeneralMedicalHistoryID(Integer.parseInt(Gen_Med_Hist_ID.getText()));
        if (dao.delete(g)) {
            JOptionPane.showMessageDialog(null, "Delete Completed");
        } else {
            JOptionPane.showMessageDialog(null, "Delete failed");
        }
//        MainGUI.Classes.TestMain.deleteRecord(NewRecord);
//        JOptionPane.showMessageDialog(null,"Delete Completed");
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed
        NewRecord = formToGeneralMedicalHistory();
        if (dao.add(NewRecord)) {
            JOptionPane.showMessageDialog(null, "Insert Completed");
        } else {
            JOptionPane.showMessageDialog(null, "Insert Failed");
        }
//        MainGUI.Classes.TestMain.insertRecord(NewRecord);
//        JOptionPane.showMessageDialog(null,"Insert Completed");
    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jButton_RevertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RevertActionPerformed
        populateTabGeneralMedicalHistory(OriginalRecord);
        if (dao.update(OriginalRecord)) {
            JOptionPane.showMessageDialog(null, "Revert Completed");
        } else {
            JOptionPane.showMessageDialog(null, "Revert Failed");
        }
//        MainGUI.Classes.TestMain.updateRecord(OriginalRecord);
//        JOptionPane.showMessageDialog(null,"File Reverted to Original");
    }//GEN-LAST:event_jButton_RevertActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
//        this.NewRecord = formToGeneralMedicalHistory();
        NewRecord = formToGeneralMedicalHistory();
        if (dao.update(NewRecord)) {
            JOptionPane.showMessageDialog(null, "Update Completed");
        } else {
            JOptionPane.showMessageDialog(null, "Update Failed");
        }
//        MainGUI.Classes.TestMain.updateRecord(NewRecord);
//        JOptionPane.showMessageDialog(null,"Update Completed");
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void DDurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DDurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DDurActionPerformed

    private void editModeToggler() {
        if (inEditMode) {
            inEditMode = false;
            jButton_Delete.setVisible(false);
            jButton_Insert.setVisible(false);
            jButton_Revert.setVisible(false);
            jButton_Update.setVisible(false);
            ADur.setEditable(inEditMode);
            AQuant.setEditable(inEditMode);
            A_HRF.setEditable(inEditMode);
            Alcohol.setEditable(inEditMode);
            BCP_No.setEditable(inEditMode);
            BCP_Yes.setEditable(inEditMode);
            Beh_Hist.setEditable(inEditMode);
            BloodType.setEditable(inEditMode);
            DDur.setEditable(inEditMode);
            DType.setEditable(inEditMode);
            D_HRF.setEditable(inEditMode);

            Diet_HRF.setEditable(inEditMode);
            Dietary.setEditable(inEditMode);
            Drug.setEditable(inEditMode);
            EDC.setEditable(inEditMode);
            EDU.setEditable(inEditMode);
            EGA.setEditable(inEditMode);
            GaD.setEditable(inEditMode);
            Gen_Med_Hist_ID.setEditable(inEditMode);
            HoD.setEditable(inEditMode);
            HxC_HCP.setEditable(inEditMode);
            HxOB.setEditable(inEditMode);
            LMP.setEditable(inEditMode);
            LMPEst.setEditable(inEditMode);
            LMPStatus.setEditable(inEditMode);

            LMP_Date_Approx.setEditable(inEditMode);
            LMP_Date.setEditable(inEditMode);
            MAN_No.setEditable(inEditMode);
            MAN_Yes.setEditable(inEditMode);
            MAoO.setEditable(inEditMode);
            MM_No.setEditable(inEditMode);
            MM_Yes.setEditable(inEditMode);
            MPD.setEditable(inEditMode);
            Marital_status.setEditable(inEditMode);
            Med_Hist_Notes.setEditable(inEditMode);
            MensesFreq.setEditable(inEditMode);
            NoC.setEditable(inEditMode);
            NoP.setEditable(inEditMode);
            PDD.setEditable(inEditMode);
            Patient_ID.setEditable(inEditMode);
            Preg.setEditable(inEditMode);
            RH.setEditable(inEditMode);
            TDur.setEditable(inEditMode);
            TQuant.setEditable(inEditMode);
            T_HRF.setEditable(inEditMode);
            Tobacco.setEditable(inEditMode);
            Travel.setEditable(inEditMode);
            Travel_HRF.setEditable(inEditMode);
            UTOHxReason.setEditable(inEditMode);
            gmh_Preg.setEditable(inEditMode);
            ADur.setBackground(Color.LIGHT_GRAY);
            AQuant.setBackground(Color.LIGHT_GRAY);
            A_HRF.setBackground(Color.LIGHT_GRAY);
            Alcohol.setBackground(Color.LIGHT_GRAY);
            BCP_No.setBackground(Color.LIGHT_GRAY);
            BCP_Yes.setBackground(Color.LIGHT_GRAY);
            Beh_Hist.setBackground(Color.LIGHT_GRAY);
            BloodType.setBackground(Color.LIGHT_GRAY);
            DDur.setBackground(Color.LIGHT_GRAY);
            DType.setBackground(Color.LIGHT_GRAY);
            D_HRF.setBackground(Color.LIGHT_GRAY);

            Diet_HRF.setBackground(Color.LIGHT_GRAY);
            Dietary.setBackground(Color.LIGHT_GRAY);
            Drug.setBackground(Color.LIGHT_GRAY);
            EDC.setBackground(Color.LIGHT_GRAY);
            EDU.setBackground(Color.LIGHT_GRAY);
            EGA.setBackground(Color.LIGHT_GRAY);
            GaD.setBackground(Color.LIGHT_GRAY);
            Gen_Med_Hist_ID.setBackground(Color.LIGHT_GRAY);
            HoD.setBackground(Color.LIGHT_GRAY);
            HxC_HCP.setBackground(Color.LIGHT_GRAY);
            HxOB.setBackground(Color.LIGHT_GRAY);
            LMP.setBackground(Color.LIGHT_GRAY);
            LMPEst.setBackground(Color.LIGHT_GRAY);
            LMPStatus.setBackground(Color.LIGHT_GRAY);

            LMP_Date_Approx.setBackground(Color.LIGHT_GRAY);
            LMP_Date.setBackground(Color.LIGHT_GRAY);
            MAN_No.setBackground(Color.LIGHT_GRAY);
            MAN_Yes.setBackground(Color.LIGHT_GRAY);
            MAoO.setBackground(Color.LIGHT_GRAY);
            MM_No.setBackground(Color.LIGHT_GRAY);
            MM_Yes.setBackground(Color.LIGHT_GRAY);
            MPD.setBackground(Color.LIGHT_GRAY);
            Marital_status.setBackground(Color.LIGHT_GRAY);
            Med_Hist_Notes.setBackground(Color.LIGHT_GRAY);
            MensesFreq.setBackground(Color.LIGHT_GRAY);
            NoC.setBackground(Color.LIGHT_GRAY);
            NoP.setBackground(Color.LIGHT_GRAY);
            PDD.setBackground(Color.LIGHT_GRAY);
            Patient_ID.setBackground(Color.LIGHT_GRAY);
            Preg.setBackground(Color.LIGHT_GRAY);
            RH.setBackground(Color.LIGHT_GRAY);
            TDur.setBackground(Color.LIGHT_GRAY);
            TQuant.setBackground(Color.LIGHT_GRAY);
            T_HRF.setBackground(Color.LIGHT_GRAY);
            Tobacco.setBackground(Color.LIGHT_GRAY);
            Travel.setBackground(Color.LIGHT_GRAY);
            Travel_HRF.setBackground(Color.LIGHT_GRAY);
            UTOHxReason.setBackground(Color.LIGHT_GRAY);
            gmh_Preg.setBackground(Color.LIGHT_GRAY);
        } else {
            inEditMode = true;
            jButton_Delete.setVisible(true);
            jButton_Insert.setVisible(true);
            jButton_Revert.setVisible(true);
            jButton_Update.setVisible(true);
            ADur.setEditable(inEditMode);
            AQuant.setEditable(inEditMode);
            A_HRF.setEditable(inEditMode);
            Alcohol.setEditable(inEditMode);
            BCP_No.setEditable(inEditMode);
            BCP_Yes.setEditable(inEditMode);
            Beh_Hist.setEditable(inEditMode);
            BloodType.setEditable(inEditMode);
            DDur.setEditable(inEditMode);
            DType.setEditable(inEditMode);
            D_HRF.setEditable(inEditMode);

            Diet_HRF.setEditable(inEditMode);
            Dietary.setEditable(inEditMode);
            Drug.setEditable(inEditMode);
            EDC.setEditable(inEditMode);
            EDU.setEditable(inEditMode);
            EGA.setEditable(inEditMode);
            GaD.setEditable(inEditMode);
            Gen_Med_Hist_ID.setEditable(inEditMode);
            HoD.setEditable(inEditMode);
            HxC_HCP.setEditable(inEditMode);
            HxOB.setEditable(inEditMode);
            LMP.setEditable(inEditMode);
            LMPEst.setEditable(inEditMode);
            LMPStatus.setEditable(inEditMode);

            LMP_Date_Approx.setEditable(inEditMode);
            LMP_Date.setEditable(inEditMode);
            MAN_No.setEditable(inEditMode);
            MAN_Yes.setEditable(inEditMode);
            MAoO.setEditable(inEditMode);
            MM_No.setEditable(inEditMode);
            MM_Yes.setEditable(inEditMode);
            MPD.setEditable(inEditMode);
            Marital_status.setEditable(inEditMode);
            Med_Hist_Notes.setEditable(inEditMode);
            MensesFreq.setEditable(inEditMode);
            NoC.setEditable(inEditMode);
            NoP.setEditable(inEditMode);
            PDD.setEditable(inEditMode);
            Patient_ID.setEditable(inEditMode);
            Preg.setEditable(inEditMode);
            RH.setEditable(inEditMode);
            TDur.setEditable(inEditMode);
            TQuant.setEditable(inEditMode);
            T_HRF.setEditable(inEditMode);
            Tobacco.setEditable(inEditMode);
            Travel.setEditable(inEditMode);
            Travel_HRF.setEditable(inEditMode);
            UTOHxReason.setEditable(inEditMode);
            gmh_Preg.setEditable(inEditMode);
            ADur.setBackground(Color.WHITE);
            AQuant.setBackground(Color.WHITE);
            A_HRF.setBackground(Color.WHITE);
            Alcohol.setBackground(Color.WHITE);
            BCP_No.setBackground(Color.WHITE);
            BCP_Yes.setBackground(Color.WHITE);
            Beh_Hist.setBackground(Color.WHITE);
            BloodType.setBackground(Color.WHITE);
            DDur.setBackground(Color.WHITE);
            DType.setBackground(Color.WHITE);
            D_HRF.setBackground(Color.WHITE);

            Diet_HRF.setBackground(Color.WHITE);
            Dietary.setBackground(Color.WHITE);
            Drug.setBackground(Color.WHITE);
            EDC.setBackground(Color.WHITE);
            EDU.setBackground(Color.WHITE);
            EGA.setBackground(Color.WHITE);
            GaD.setBackground(Color.WHITE);
            Gen_Med_Hist_ID.setBackground(Color.WHITE);
            HoD.setBackground(Color.WHITE);
            HxC_HCP.setBackground(Color.WHITE);
            HxOB.setBackground(Color.WHITE);
            LMP.setBackground(Color.WHITE);
            LMPEst.setBackground(Color.WHITE);
            LMPStatus.setBackground(Color.WHITE);

            LMP_Date_Approx.setBackground(Color.WHITE);
            LMP_Date.setBackground(Color.WHITE);
            MAN_No.setBackground(Color.WHITE);
            MAN_Yes.setBackground(Color.WHITE);
            MAoO.setBackground(Color.WHITE);
            MM_No.setBackground(Color.WHITE);
            MM_Yes.setBackground(Color.WHITE);
            MPD.setBackground(Color.WHITE);
            Marital_status.setBackground(Color.WHITE);
            Med_Hist_Notes.setBackground(Color.WHITE);
            MensesFreq.setBackground(Color.WHITE);
            NoC.setBackground(Color.WHITE);
            NoP.setBackground(Color.WHITE);
            PDD.setBackground(Color.WHITE);
            Patient_ID.setBackground(Color.WHITE);
            Preg.setBackground(Color.WHITE);
            RH.setBackground(Color.WHITE);
            TDur.setBackground(Color.WHITE);
            TQuant.setBackground(Color.WHITE);
            T_HRF.setBackground(Color.WHITE);
            Tobacco.setBackground(Color.WHITE);
            Travel.setBackground(Color.WHITE);
            Travel_HRF.setBackground(Color.WHITE);
            UTOHxReason.setBackground(Color.WHITE);
            gmh_Preg.setBackground(Color.WHITE);
        }
    }

// <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADur;
    private javax.swing.JTextField AQuant;
    private javax.swing.JTextField A_HRF;
    private javax.swing.JTextField Alcohol;
    private javax.swing.JTextField BCP_No;
    private javax.swing.JTextField BCP_Yes;
    private javax.swing.JTextField Beh_Hist;
    private javax.swing.JTextField BloodType;
    private javax.swing.JTextField DDur;
    private javax.swing.JTextField DType;
    private javax.swing.JTextField D_HRF;
    private javax.swing.JTextField Diet_HRF;
    private javax.swing.JTextField Dietary;
    private javax.swing.JTextField Drug;
    private javax.swing.JTextField EDC;
    private javax.swing.JTextField EDU;
    private javax.swing.JTextField EGA;
    private javax.swing.JTextField GaD;
    private javax.swing.JTextField Gen_Med_Hist_ID;
    private javax.swing.JTextField HoD;
    private javax.swing.JTextField HxC_HCP;
    private javax.swing.JTextField HxOB;
    private javax.swing.JTextField LMP;
    private javax.swing.JTextField LMPEst;
    private javax.swing.JTextField LMPStatus;
    private javax.swing.JTextField LMP_Date;
    private javax.swing.JTextField LMP_Date_Approx;
    private javax.swing.JTextField MAN_No;
    private javax.swing.JTextField MAN_Yes;
    private javax.swing.JTextField MAoO;
    private javax.swing.JTextField MM_No;
    private javax.swing.JTextField MM_Yes;
    private javax.swing.JTextField MPD;
    private javax.swing.JTextField Marital_status;
    private javax.swing.JTextField Med_Hist_Notes;
    private javax.swing.JTextField MensesFreq;
    private javax.swing.JTextField NoC;
    private javax.swing.JTextField NoP;
    private javax.swing.JTextField PDD;
    private javax.swing.JTextField Patient_ID;
    private javax.swing.JTextField Preg;
    private javax.swing.JTextField RH;
    private javax.swing.JTextField TDur;
    private javax.swing.JTextField TQuant;
    private javax.swing.JTextField T_HRF;
    private javax.swing.JTextField Tobacco;
    private javax.swing.JTextField Travel;
    private javax.swing.JTextField Travel_HRF;
    private javax.swing.JTextField UTOHxReason;
    private javax.swing.JTextField gmh_Preg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_Revert;
    private javax.swing.JButton jButton_Update;
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
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
// </editor-fold>

}
