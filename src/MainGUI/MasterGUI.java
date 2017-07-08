package MainGUI;

import MainGUI.DAO.JDBCMySQLConnection;
import MainGUI.Forms.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * developed by someone else, modified by Fan Hu and Zhiwei Chu.
 *
 * @author Someone, Fan Hu, Zhiwei Chu
 */
public class MasterGUI extends javax.swing.JFrame {

    public static String patient_ID;

    public MasterGUI() {
        initComponents();
        jLabel3.setVisible(false);
        jLabel2.setVisible(false);
        jLabel5.setVisible(false);
        Last_Name_TextField.setVisible(false);
        DOB_TextField.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jButton_Patient = new javax.swing.JButton();
        jButton_Person = new javax.swing.JButton();
        jButton_Vitals = new javax.swing.JButton();
        jButton_Allergy = new javax.swing.JButton();
        jButton_Family = new javax.swing.JButton();
        jButton_GenMed = new javax.swing.JButton();
        jButton_Ill = new javax.swing.JButton();
        jButton_Imm = new javax.swing.JButton();
        jButton_Occ = new javax.swing.JButton();
        jButton_Preg = new javax.swing.JButton();
        jButton_Thera = new javax.swing.JButton();
        jButton_Pers = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Patient_ID_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Last_Name_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jButtonNewPatient = new javax.swing.JButton();
        jButtonNewPerson = new javax.swing.JButton();
        DOB_TextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setTitle("Medical Record Editor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1090, 762));

        jDesktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1343, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 884, Short.MAX_VALUE)
        );

        jButton_Patient.setText("Patient Table");
        jButton_Patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PatientActionPerformed(evt);
            }
        });

        jButton_Person.setText("Person Table");
        jButton_Person.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PersonActionPerformed(evt);
            }
        });

        jButton_Vitals.setText("Vital Signs");
        jButton_Vitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VitalsActionPerformed(evt);
            }
        });

        jButton_Allergy.setText("Allergy History");
        jButton_Allergy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AllergyActionPerformed(evt);
            }
        });

        jButton_Family.setText("Family History");
        jButton_Family.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FamilyActionPerformed(evt);
            }
        });

        jButton_GenMed.setText("General Medical History");
        jButton_GenMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GenMedActionPerformed(evt);
            }
        });

        jButton_Ill.setText("Illness History");
        jButton_Ill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IllActionPerformed(evt);
            }
        });

        jButton_Imm.setText("Immunization History");
        jButton_Imm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImmActionPerformed(evt);
            }
        });

        jButton_Occ.setText("Occupational History");
        jButton_Occ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OccActionPerformed(evt);
            }
        });

        jButton_Preg.setText("Past Pregnancies");
        jButton_Preg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PregActionPerformed(evt);
            }
        });

        jButton_Thera.setText("Therapies");
        jButton_Thera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TheraActionPerformed(evt);
            }
        });

        jButton_Pers.setText("Perscriptions");
        jButton_Pers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PersActionPerformed(evt);
            }
        });

        jLabel1.setText("Patient ID");

        Patient_ID_TextField.setBackground(new java.awt.Color(220, 220, 220));
        Patient_ID_TextField.setMinimumSize(new java.awt.Dimension(140, 29));
        Patient_ID_TextField.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel2.setText("Last Name");

        Last_Name_TextField.setEditable(false);
        Last_Name_TextField.setBackground(new java.awt.Color(220, 220, 220));
        Last_Name_TextField.setMinimumSize(new java.awt.Dimension(140, 29));
        Last_Name_TextField.setPreferredSize(new java.awt.Dimension(140, 29));

        jLabel5.setText("Birthday");

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonNewPatient.setText("Create New Patient");
        jButtonNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPatientActionPerformed(evt);
            }
        });

        jButtonNewPerson.setText("Create New Person");
        jButtonNewPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPersonActionPerformed(evt);
            }
        });

        DOB_TextField.setEditable(false);
        DOB_TextField.setBackground(new java.awt.Color(220, 220, 220));
        DOB_TextField.setMinimumSize(new java.awt.Dimension(140, 29));
        DOB_TextField.setPreferredSize(new java.awt.Dimension(140, 29));

        jMenu2.setText("Reports");

        jMenuItem1.setText("Report");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addGap(227, 227, 227))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton_GenMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Family, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Allergy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Vitals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Person, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Ill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Imm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Occ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Preg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Thera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Pers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonNewPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Patient_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Last_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DOB_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 514, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Patient_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSearch)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Last_Name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(DOB_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Patient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Person)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Vitals)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Allergy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Family)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_GenMed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Ill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Imm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Occ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Preg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Thera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Pers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNewPerson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonNewPatient)
                        .addGap(413, 437, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPane)
                        .addContainerGap())))
        );

        setSize(new java.awt.Dimension(1600, 1000));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PatientActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            try {
                Patient P = new Patient(Integer.parseInt(Patient_ID_TextField.getText()));
                jDesktopPane.add(P);
                P.show();
            } catch (NullPointerException e) {
                Patient P = new Patient();
                jDesktopPane.add(P);
                P.show();
            }
        } else {
            Patient P = new Patient();
            jDesktopPane.add(P);
            P.show();
        }
    }//GEN-LAST:event_jButton_PatientActionPerformed

    private void jButton_PersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PersonActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            try {
                Person Pe = new Person(Integer.parseInt(Patient_ID_TextField.getText()));
                jDesktopPane.add(Pe);
                Pe.show();
            } catch (NullPointerException e) {
                Person Pe = new Person();
                jDesktopPane.add(Pe);
                Pe.show();
            }
        } else {
            Person Pe = new Person();
            jDesktopPane.add(Pe);
            Pe.show();
        }
    }//GEN-LAST:event_jButton_PersonActionPerformed

    private void jButton_VitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VitalsActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Vital_Sign_table VS = new Vital_Sign_table();
            jDesktopPane.add(VS);
            VS.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_VitalsActionPerformed

    private void jButton_AllergyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AllergyActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Allergy_History_table AH = new Allergy_History_table();
            jDesktopPane.add(AH);
            AH.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_AllergyActionPerformed

    private void jButton_FamilyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FamilyActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Family_History_table FH = new Family_History_table();
            jDesktopPane.add(FH);
            FH.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_FamilyActionPerformed

    private void jButton_GenMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GenMedActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            try {
                Gen_Med_History GMH = new Gen_Med_History(Integer.parseInt(Patient_ID_TextField.getText()));
                jDesktopPane.add(GMH);
                GMH.show();
            } catch (NullPointerException e) {
                Gen_Med_History GMH = new Gen_Med_History();
                jDesktopPane.add(GMH);
                GMH.show();
            }
        } else {
            Gen_Med_History GMH = new Gen_Med_History();
            jDesktopPane.add(GMH);
            GMH.show();
        }
    }//GEN-LAST:event_jButton_GenMedActionPerformed

    private void jButton_IllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IllActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Illness_History_table IlH = new Illness_History_table();
            jDesktopPane.add(IlH);
            IlH.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_IllActionPerformed

    private void jButton_ImmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImmActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Immunization_History_table ih = new Immunization_History_table();
            jDesktopPane.add(ih);
            ih.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_ImmActionPerformed

    private void jButton_OccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OccActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Occupational_History_table OH = new Occupational_History_table();
            jDesktopPane.add(OH);
            OH.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_OccActionPerformed

    private void jButton_PregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PregActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            try {
                Past_Pregnancies PP = new Past_Pregnancies(Integer.parseInt(Patient_ID_TextField.getText()));
                jDesktopPane.add(PP);
                PP.show();
            } catch (NullPointerException e) {
                e.printStackTrace();
                Past_Pregnancies PP = new Past_Pregnancies();
                jDesktopPane.add(PP);
                PP.show();
            }
        } else {
            Past_Pregnancies PP = new Past_Pregnancies();
            jDesktopPane.add(PP);
            PP.show();
        }
    }//GEN-LAST:event_jButton_PregActionPerformed

    private void jButton_TheraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TheraActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Therapy_table T = new Therapy_table();
            jDesktopPane.add(T);
            T.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_TheraActionPerformed

    private void jButton_PersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PersActionPerformed
        if (!Patient_ID_TextField.getText().equals("")) {
            Prescription_table Ps = new Prescription_table();
            jDesktopPane.add(Ps);
            Ps.show();
        } else {
            JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Please input a patient ID.</span></html>",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_PersActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        //person_ID will only be used for person table
        patient_ID = Patient_ID_TextField.getText();
        jLabel2.setVisible(true);
        Last_Name_TextField.setVisible(true);
        DOB_TextField.setVisible(true);
        jLabel5.setVisible(true);
        Connection conn = JDBCMySQLConnection.getConnection();
        PreparedStatement pstmt;
        ResultSet rst;
        try {
            pstmt = conn.prepareStatement("SELECT PtLastName,DOB FROM patienttable where deleted=0 and PatientID=?;");
            pstmt.setInt(1, Integer.valueOf(patient_ID));
            rst = pstmt.executeQuery();
            while (rst.next()) {
                Last_Name_TextField.setText(rst.getString("PtLastName"));
                DOB_TextField.setText(rst.getString("DOB"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DOB_TextField.setVisible(true);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonNewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPatientActionPerformed
        Patient P = new Patient();
        jDesktopPane.add(P);
        P.show();
    }//GEN-LAST:event_jButtonNewPatientActionPerformed

    private void jButtonNewPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPersonActionPerformed
        Person Pe = new Person();
        jDesktopPane.add(Pe);
        Pe.show();
    }//GEN-LAST:event_jButtonNewPersonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField DOB_TextField;
    public static javax.swing.JTextField Last_Name_TextField;
    public static javax.swing.JTextField Patient_ID_TextField;
    private javax.swing.JButton jButtonNewPatient;
    private javax.swing.JButton jButtonNewPerson;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButton_Allergy;
    private javax.swing.JButton jButton_Family;
    private javax.swing.JButton jButton_GenMed;
    private javax.swing.JButton jButton_Ill;
    private javax.swing.JButton jButton_Imm;
    private javax.swing.JButton jButton_Occ;
    private javax.swing.JButton jButton_Patient;
    private javax.swing.JButton jButton_Pers;
    private javax.swing.JButton jButton_Person;
    private javax.swing.JButton jButton_Preg;
    private javax.swing.JButton jButton_Thera;
    private javax.swing.JButton jButton_Vitals;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
