package MainGUI.Forms;

import java.awt.Color;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * revise
 *
 * @author Fan Hu, Zhiwei Chu
 */
public final class Past_Pregnancies extends javax.swing.JInternalFrame {

    MainGUI.Classes.PastPregnancies OriginalRecord, NewRecord;
    Boolean inEditMode = true;

    public Past_Pregnancies() {
        initComponents();
        editModeToggler();
    }

    public Past_Pregnancies(int ID) {
        initComponents();
        editModeToggler();
        this.OriginalRecord = MainGUI.Classes.TestMain.getPastPregnancies(ID);
        populateTabPastPregnancies(OriginalRecord);
    }

    Format Formatter = new SimpleDateFormat("yyyy-mm-dd");

    public void populateTabPastPregnancies(MainGUI.Classes.PastPregnancies pastPreg) {
        Preg_Date.setText(pastPreg.getPregnancyDate().toString());
        LoL.setText(pastPreg.getLengthOfLabor());
        Sex.setText(pastPreg.getSex());
        ToD.setText(pastPreg.getTypeOfDelivery());
        PoD.setText(pastPreg.getPlaceOfDelivery());
        Comments.setText(pastPreg.getComments());
        Corionicity.setText(pastPreg.getCorionicity());
        EGA_Est.setText(pastPreg.getEGAEstMethod());
        PP_ID.setText(Integer.toString(pastPreg.getPastPregnanciesID()));
        Patient_ID.setText(Integer.toString(pastPreg.getPatientID()));
        NoF.setText(Integer.toString(pastPreg.getNumberOfFetuses()));
        EGA.setText(Double.toString(pastPreg.getEGA()));
        BWLbs.setText(Double.toString(pastPreg.getBirthWeightLbs()));
        BWOunces.setText(Double.toString(pastPreg.getBirthWeightOunces()));
        PTL.setText(Byte.toString(pastPreg.getPreTermLabor()));

        Choncordant.setText(Byte.toString(pastPreg.getChoncordant()));
        TtTtS.setText(Byte.toString(pastPreg.getTwinToTwinTransSyndrome()));
        BCP_Yes.setText(Byte.toString(pastPreg.getOnBCPAtConceptionYes()));
        BCP_No.setText(Byte.toString(pastPreg.getOnBCPAtConceptionNo()));
        Current.setText(Byte.toString(pastPreg.getCurrent()));
        LMP.setText(Formatter.format(pastPreg.getLMP()));
        EDD.setText(Formatter.format(pastPreg.getEDD()));
        Date_Stamp.setText((pastPreg.getDateStamp().toString()));
        EGA_Cal.setText(Formatter.format(pastPreg.getEGACalculationDate()));
    }

    public MainGUI.Classes.PastPregnancies formToPastPregnancies() {
        MainGUI.Classes.PastPregnancies pastPreg = new MainGUI.Classes.PastPregnancies();

        pastPreg.setLengthOfLabor(LoL.getText());
        pastPreg.setSex(Sex.getText());
        pastPreg.setTypeOfDelivery(ToD.getText());
        pastPreg.setPlaceOfDelivery(PoD.getText());
        pastPreg.setComments(Comments.getText());
        pastPreg.setCorionicity(Corionicity.getText());
        pastPreg.setEGAEstMethod(EGA_Est.getText());
        pastPreg.setPastPregnanciesID(Integer.parseInt(PP_ID.getText()));
        pastPreg.setPatientID(Integer.parseInt(Patient_ID.getText()));
        pastPreg.setNumberOfFetuses(Integer.parseInt(NoF.getText()));
        pastPreg.setEGA(Double.parseDouble(EGA.getText()));
        pastPreg.setBirthWeightLbs(Double.parseDouble(BWLbs.getText()));
        pastPreg.setBirthWeightOunces(Double.parseDouble(BWOunces.getText()));
        pastPreg.setPreTermLabor(Byte.parseByte(PTL.getText()));

        pastPreg.setChoncordant(Byte.parseByte(Choncordant.getText()));
        pastPreg.setTwinToTwinTransSyndrome(Byte.parseByte(TtTtS.getText()));
        pastPreg.setOnBCPAtConceptionYes(Byte.parseByte(BCP_Yes.getText()));
        pastPreg.setOnBCPAtConceptionNo(Byte.parseByte(BCP_No.getText()));
        pastPreg.setCurrent(Byte.parseByte(Current.getText()));
        try {
            java.util.Date date;
            java.sql.Date sqlStartDate;
            if (!LMP.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(LMP.getText());
                sqlStartDate = new Date(date.getTime());
                pastPreg.setLMP(sqlStartDate);
            }
            if (!EDD.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(EDD.getText());
                sqlStartDate = new Date(date.getTime());
                pastPreg.setEDD(sqlStartDate);
            }
            if (!Date_Stamp.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(Date_Stamp.getText());
                sqlStartDate = new Date(date.getTime());
                pastPreg.setDateStamp(sqlStartDate);
            }

            if (!EGA_Cal.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(EGA_Cal.getText());
                sqlStartDate = new Date(date.getTime());
                pastPreg.setEGACalculationDate(sqlStartDate);
            }
            if (!Preg_Date.getText().equals("")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(Preg_Date.getText());
                sqlStartDate = new Date(date.getTime());
                pastPreg.setPregnancyDate(sqlStartDate);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return pastPreg;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Update = new javax.swing.JButton();
        jButton_Revert = new javax.swing.JButton();
        PP_ID = new javax.swing.JTextField();
        Patient_ID = new javax.swing.JTextField();
        Preg_Date = new javax.swing.JTextField();
        EGA = new javax.swing.JTextField();
        LoL = new javax.swing.JTextField();
        BWLbs = new javax.swing.JTextField();
        BWOunces = new javax.swing.JTextField();
        Sex = new javax.swing.JTextField();
        ToD = new javax.swing.JTextField();
        PoD = new javax.swing.JTextField();
        PTL = new javax.swing.JTextField();
        Comments = new javax.swing.JTextField();
        NoF = new javax.swing.JTextField();
        Corionicity = new javax.swing.JTextField();
        Choncordant = new javax.swing.JTextField();
        TtTtS = new javax.swing.JTextField();
        LMP = new javax.swing.JTextField();
        EDD = new javax.swing.JTextField();
        EGA_Est = new javax.swing.JTextField();
        BCP_Yes = new javax.swing.JTextField();
        BCP_No = new javax.swing.JTextField();
        Current = new javax.swing.JTextField();
        Date_Stamp = new javax.swing.JTextField();
        EGA_Cal = new javax.swing.JTextField();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton_Insert = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Past Pregnanices");

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

        PP_ID.setMinimumSize(new java.awt.Dimension(100, 29));
        PP_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Patient_ID.setMinimumSize(new java.awt.Dimension(100, 29));
        Patient_ID.setPreferredSize(new java.awt.Dimension(140, 29));

        Preg_Date.setMinimumSize(new java.awt.Dimension(100, 29));
        Preg_Date.setPreferredSize(new java.awt.Dimension(140, 29));

        EGA.setMinimumSize(new java.awt.Dimension(100, 29));
        EGA.setPreferredSize(new java.awt.Dimension(140, 29));

        LoL.setMinimumSize(new java.awt.Dimension(100, 29));
        LoL.setPreferredSize(new java.awt.Dimension(140, 29));

        BWLbs.setMinimumSize(new java.awt.Dimension(100, 29));
        BWLbs.setPreferredSize(new java.awt.Dimension(140, 29));

        BWOunces.setMinimumSize(new java.awt.Dimension(100, 29));
        BWOunces.setPreferredSize(new java.awt.Dimension(140, 29));

        Sex.setMinimumSize(new java.awt.Dimension(100, 29));
        Sex.setPreferredSize(new java.awt.Dimension(140, 29));

        ToD.setMinimumSize(new java.awt.Dimension(100, 29));
        ToD.setPreferredSize(new java.awt.Dimension(140, 29));

        PoD.setMinimumSize(new java.awt.Dimension(100, 29));
        PoD.setPreferredSize(new java.awt.Dimension(140, 29));

        PTL.setPreferredSize(new java.awt.Dimension(140, 29));

        Comments.setPreferredSize(new java.awt.Dimension(140, 29));

        NoF.setPreferredSize(new java.awt.Dimension(140, 29));

        Corionicity.setPreferredSize(new java.awt.Dimension(140, 29));

        Choncordant.setPreferredSize(new java.awt.Dimension(140, 29));

        TtTtS.setPreferredSize(new java.awt.Dimension(140, 29));

        LMP.setPreferredSize(new java.awt.Dimension(140, 29));

        EDD.setPreferredSize(new java.awt.Dimension(140, 29));

        EGA_Est.setPreferredSize(new java.awt.Dimension(140, 29));

        BCP_Yes.setPreferredSize(new java.awt.Dimension(140, 29));

        BCP_No.setPreferredSize(new java.awt.Dimension(140, 29));

        Current.setPreferredSize(new java.awt.Dimension(140, 29));

        Date_Stamp.setPreferredSize(new java.awt.Dimension(140, 29));

        EGA_Cal.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel1.setText("Past Pregnancies ID");

        jLabel2.setText("Patient ID");

        jLabel3.setText("Pregnancy Date");

        jLabel4.setText("EGA");

        jLabel5.setText("Length of Labor");

        jLabel6.setText("Birth Weight Lbs ");

        jLabel7.setText("Birth Weight Ounces");

        jLabel8.setText("Sex");

        jLabel9.setText("Type of Delivery");

        jLabel10.setText("Place of Delivery");

        jLabel11.setText("Pre Term Labor");

        jLabel12.setText("Comments");

        jLabel14.setText("Number of Fetuses");

        jLabel15.setText("Corionicty");

        jLabel16.setText("Choncordant");

        jLabel17.setText("Twin to Twin Trans Syndrome");

        jLabel18.setText("LMP");

        jLabel19.setText("EDD");

        jLabel20.setText("EGA Est Method");

        jLabel21.setText("On BCP at Conception Yes");

        jLabel22.setText("On BCP at Conception No");

        jLabel23.setText("Current");

        jLabel24.setText("Date Stamp");

        jLabel25.setText("EGA Calculation Date");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Revert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Update))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ToD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BWOunces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BWLbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PP_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Preg_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel20)
                            .addComponent(jLabel11)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EGA_Est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TtTtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(192, 192, 192))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Corionicity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Choncordant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BCP_Yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BCP_No, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Current, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Date_Stamp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EGA_Cal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BCP_Yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BCP_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Current, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Date_Stamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EGA_Cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PP_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Patient_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Preg_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BWLbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BWOunces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ToD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Update)
                            .addComponent(jButton_Revert)
                            .addComponent(jButton_Insert)
                            .addComponent(jButton_Delete)
                            .addComponent(jButton1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Corionicity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Choncordant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TtTtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EGA_Est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(145, 145, 145))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editModeToggler();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        this.NewRecord = formToPastPregnancies();
        NewRecord.setDeleted(new Byte("1"));
        MainGUI.Classes.TestMain.deleteRecord(NewRecord);
        JOptionPane.showMessageDialog(null, "Delete Completed");
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed
        this.NewRecord = formToPastPregnancies();
        NewRecord.setDeleted(new Byte("0"));
        MainGUI.Classes.TestMain.insertRecord(NewRecord);
        JOptionPane.showMessageDialog(null, "Insert Completed");
    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jButton_RevertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RevertActionPerformed
        populateTabPastPregnancies(OriginalRecord);
        MainGUI.Classes.TestMain.updateRecord(OriginalRecord);
        JOptionPane.showMessageDialog(null, "File Reverted to Original");
    }//GEN-LAST:event_jButton_RevertActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        this.NewRecord = formToPastPregnancies();
        NewRecord.setDeleted(new Byte("0"));
        MainGUI.Classes.TestMain.updateRecord(NewRecord);
        JOptionPane.showMessageDialog(null, "Update Completed");
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void editModeToggler() {
        if (inEditMode) {
            inEditMode = false;
            jButton_Delete.setVisible(false);
            jButton_Insert.setVisible(false);
            jButton_Revert.setVisible(false);
            jButton_Update.setVisible(false);
            BCP_No.setEditable(inEditMode);
            BCP_Yes.setEditable(inEditMode);
            BWLbs.setEditable(inEditMode);
            BWOunces.setEditable(inEditMode);
            Choncordant.setEditable(inEditMode);
            Comments.setEditable(inEditMode);
            Corionicity.setEditable(inEditMode);
            Current.setEditable(inEditMode);
            Date_Stamp.setEditable(inEditMode);

            EDD.setEditable(inEditMode);
            EGA.setEditable(inEditMode);
            EGA_Cal.setEditable(inEditMode);
            EGA_Est.setEditable(inEditMode);
            LMP.setEditable(inEditMode);
            LoL.setEditable(inEditMode);
            NoF.setEditable(inEditMode);
            PP_ID.setEditable(inEditMode);
            PTL.setEditable(inEditMode);
            Patient_ID.setEditable(inEditMode);
            PoD.setEditable(inEditMode);
            Preg_Date.setEditable(inEditMode);
            Sex.setEditable(inEditMode);
            ToD.setEditable(inEditMode);
            TtTtS.setEditable(inEditMode);
            BCP_No.setBackground(Color.LIGHT_GRAY);
            BCP_Yes.setBackground(Color.LIGHT_GRAY);
            BWLbs.setBackground(Color.LIGHT_GRAY);
            BWOunces.setBackground(Color.LIGHT_GRAY);
            Choncordant.setBackground(Color.LIGHT_GRAY);
            Comments.setBackground(Color.LIGHT_GRAY);
            Corionicity.setBackground(Color.LIGHT_GRAY);
            Current.setBackground(Color.LIGHT_GRAY);
            Date_Stamp.setBackground(Color.LIGHT_GRAY);

            EDD.setBackground(Color.LIGHT_GRAY);
            EGA.setBackground(Color.LIGHT_GRAY);
            EGA_Cal.setBackground(Color.LIGHT_GRAY);
            EGA_Est.setBackground(Color.LIGHT_GRAY);
            LMP.setBackground(Color.LIGHT_GRAY);
            LoL.setBackground(Color.LIGHT_GRAY);
            NoF.setBackground(Color.LIGHT_GRAY);
            PP_ID.setBackground(Color.LIGHT_GRAY);
            PTL.setBackground(Color.LIGHT_GRAY);
            Patient_ID.setBackground(Color.LIGHT_GRAY);
            PoD.setBackground(Color.LIGHT_GRAY);
            Preg_Date.setBackground(Color.LIGHT_GRAY);
            Sex.setBackground(Color.LIGHT_GRAY);
            ToD.setBackground(Color.LIGHT_GRAY);
            TtTtS.setBackground(Color.LIGHT_GRAY);
        } else {
            inEditMode = true;
            jButton_Delete.setVisible(true);
            jButton_Insert.setVisible(true);
            jButton_Revert.setVisible(true);
            jButton_Update.setVisible(true);
            BCP_No.setEditable(inEditMode);
            BCP_Yes.setEditable(inEditMode);
            BWLbs.setEditable(inEditMode);
            BWOunces.setEditable(inEditMode);
            Choncordant.setEditable(inEditMode);
            Comments.setEditable(inEditMode);
            Corionicity.setEditable(inEditMode);
            Current.setEditable(inEditMode);
            Date_Stamp.setEditable(inEditMode);

            EDD.setEditable(inEditMode);
            EGA.setEditable(inEditMode);
            EGA_Cal.setEditable(inEditMode);
            EGA_Est.setEditable(inEditMode);
            LMP.setEditable(inEditMode);
            LoL.setEditable(inEditMode);
            NoF.setEditable(inEditMode);
            PP_ID.setEditable(inEditMode);
            PTL.setEditable(inEditMode);
            Patient_ID.setEditable(inEditMode);
            PoD.setEditable(inEditMode);
            Preg_Date.setEditable(inEditMode);
            Sex.setEditable(inEditMode);
            ToD.setEditable(inEditMode);
            TtTtS.setEditable(inEditMode);
            BCP_No.setBackground(Color.WHITE);
            BCP_Yes.setBackground(Color.WHITE);
            BWLbs.setBackground(Color.WHITE);
            BWOunces.setBackground(Color.WHITE);
            Choncordant.setBackground(Color.WHITE);
            Comments.setBackground(Color.WHITE);
            Corionicity.setBackground(Color.WHITE);
            Current.setBackground(Color.WHITE);
            Date_Stamp.setBackground(Color.WHITE);

            EDD.setBackground(Color.WHITE);
            EGA.setBackground(Color.WHITE);
            EGA_Cal.setBackground(Color.WHITE);
            EGA_Est.setBackground(Color.WHITE);
            LMP.setBackground(Color.WHITE);
            LoL.setBackground(Color.WHITE);
            NoF.setBackground(Color.WHITE);
            PP_ID.setBackground(Color.WHITE);
            PTL.setBackground(Color.WHITE);
            Patient_ID.setBackground(Color.WHITE);
            PoD.setBackground(Color.WHITE);
            Preg_Date.setBackground(Color.WHITE);
            Sex.setBackground(Color.WHITE);
            ToD.setBackground(Color.WHITE);
            TtTtS.setBackground(Color.WHITE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BCP_No;
    private javax.swing.JTextField BCP_Yes;
    private javax.swing.JTextField BWLbs;
    private javax.swing.JTextField BWOunces;
    private javax.swing.JTextField Choncordant;
    private javax.swing.JTextField Comments;
    private javax.swing.JTextField Corionicity;
    private javax.swing.JTextField Current;
    private javax.swing.JTextField Date_Stamp;
    private javax.swing.JTextField EDD;
    private javax.swing.JTextField EGA;
    private javax.swing.JTextField EGA_Cal;
    private javax.swing.JTextField EGA_Est;
    private javax.swing.JTextField LMP;
    private javax.swing.JTextField LoL;
    private javax.swing.JTextField NoF;
    private javax.swing.JTextField PP_ID;
    private javax.swing.JTextField PTL;
    private javax.swing.JTextField Patient_ID;
    private javax.swing.JTextField PoD;
    private javax.swing.JTextField Preg_Date;
    private javax.swing.JTextField Sex;
    private javax.swing.JTextField ToD;
    private javax.swing.JTextField TtTtS;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_Revert;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
