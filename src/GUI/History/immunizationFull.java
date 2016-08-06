/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.History;

import collections.History;
import Interface.History.Immunizations;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.time.*;
import java.sql.Date;

/**
 *
 * @author Brian
 */
public class immunizationFull extends javax.swing.JInternalFrame implements HistoryForm{

    History history;
    DefaultListModel immunizationListModel;
    ArrayList<Immunizations> immunizations;

    /**
     * Creates new form immunizationFull
     *
     * @param history
     */
    public immunizationFull(History history) {
        this.history = history;
        initComponents();
        immunizationListModel = new DefaultListModel();
        immunizationList.setModel(immunizationListModel);
        immunizations = history.getImmunizationHistory();
        immunizations.stream().forEach((immunization) -> {
            immunizationListModel.addElement(immunization.getVaccine() + "   " + immunization.getExperationDate().toString());
        });
        makeAllItemsVisable();
        immunizationList.setSelectedIndex(0);
        populateFields(immunizationList.getSelectedIndex());
    }

    private void calculateDaysTillExperation() {
        
        try {
            ZoneId zoneId = ZoneId.of("America/Montreal");            
            Date experationDate = Date.valueOf(experatoinDateFormattedField.getText());
            LocalDate today = LocalDate.now(zoneId);
            LocalDate localExperationDate = experationDate.toLocalDate();
            Period difference = Period.between(localExperationDate, today);
            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(today, localExperationDate);
            daysUntilExperationTextField.setText(Long.toString(daysBetween));
        } catch (Exception e) {
        }

    }

    private void populateFields(int locationInArray) {
        Immunizations currentImmunization = immunizations.get(locationInArray);
        hcpidTextField.setText(Integer.toString(currentImmunization.getHCPId()));
        experatoinDateFormattedField.setText(currentImmunization.getExperationDate().toString());
        immunizationDateFormatedField.setText(currentImmunization.getImmunizationDate().toString());
        calculateDaysTillExperation();
        vaccineTextField.setText(currentImmunization.getVaccine());
        deliveryTextField.setText(currentImmunization.getDelivery());
        commentsTextArea.setText(currentImmunization.getComments());
        immunizationIDTextBox.setText(Integer.toString(currentImmunization.getImmunizationsID()));
    }

    private void clearFields() {
        hcpidTextField.setText("");
        experatoinDateFormattedField.setText("");
        immunizationDateFormatedField.setText((""));
        daysUntilExperationTextField.setText("");
        vaccineTextField.setText("");
        deliveryTextField.setText("");
        commentsTextArea.setText("");
        immunizationIDTextBox.setText("");
    }

    private Immunizations populateImmunization() {
        Immunizations newImmunization = new Immunizations();
        if (!immunizationIDTextBox.getText().equals("")) {
            newImmunization.setImmunizationsID(Integer.parseInt(immunizationIDTextBox.getText()));
        }
        newImmunization.setComments(commentsTextArea.getText());
        newImmunization.setDeleted(toByte(deleteButton.isSelected()));
        newImmunization.setDelivery(deliveryTextField.getText());
        newImmunization.setExperationDate(java.sql.Date.valueOf(experatoinDateFormattedField.getText()));
        newImmunization.setHCPId(Integer.parseInt(hcpidTextField.getText()));
        newImmunization.setImmunizationDate(java.sql.Date.valueOf(immunizationDateFormatedField.getText()));
        newImmunization.setVaccine(vaccineTextField.getText());
        return newImmunization;
    }

    private byte toByte(boolean bool) {
        return (byte) (bool ? 1 : 0);
    }

    private void makeAllItemsVisable() {
        int size = immunizationListModel.size() - 1;
        if (size == 0){
            size = 1;
        }
        for (int i = 0; i < size; i++) {
            immunizationList.ensureIndexIsVisible(i);
        }
    }

    private void updateImmunizationHistory() {
        int selection = immunizationList.getSelectedIndex();

        if (selection == -1) {
            informUser.setText("Select a Immunization record to update");
        } else {
            Immunizations updatedImmunization = populateImmunization();
            try {
                history.updateImmunizationHistory(updatedImmunization);
                immunizationListModel.remove(selection);
                immunizationListModel.add(selection, updatedImmunization.getVaccine() + "    " + updatedImmunization.getImmunizationDate().toString());
                immunizationList.setSelectedIndex(selection);
                makeAllItemsVisable();
                immunizations = history.getImmunizationHistory();
                populateFields(selection);
                immunizationList.setEnabled(true);
                addButton.setEnabled(true);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                selectButton.setEnabled(true);
                informUser.setText("Immunization Record Updated Successfully");
            } catch (Exception e) {
                informUser.setText(e.getMessage());
            }
        }
    }

    private void addImmunizationHistory() {

        Immunizations updatedImmunization = populateImmunization();
        try {
            history.addImmunizationHistory(updatedImmunization);
            immunizationListModel.addElement(updatedImmunization.getVaccine() + "    " + updatedImmunization.getImmunizationDate().toString());
            makeAllItemsVisable();
            immunizations = history.getImmunizationHistory();
            populateFields(immunizationListModel.size() - 1);
            immunizationList.setEnabled(true);
            addButton.setEnabled(true);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
            selectButton.setEnabled(true);
            updateButton.setText("Update");
            informUser.setText("Immunization Record Added Successfully");
        } catch (Exception e) {
            informUser.setText(e.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        immunizationIDTextBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        immunizationList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        selectButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        vaccineTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        immunizationDateFormatedField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        experatoinDateFormattedField = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        deliveryTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        hcpidTextField = new javax.swing.JTextField();
        deletedCheckBox = new javax.swing.JCheckBox();
        informUser = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        daysUntilExperationTextField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Immunizations ID");

        immunizationIDTextBox.setEnabled(false);

        jScrollPane1.setViewportView(immunizationList);

        jLabel2.setText("Immunizations");

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.setEnabled(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setEnabled(false);

        jLabel3.setText("Vaccine");

        jLabel4.setText("Immunization Date");

        immunizationDateFormatedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel5.setText("yyyy-MM-dd");

        jLabel6.setText("Expiration Date");

        experatoinDateFormattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel7.setText("yyyy-MM-dd");

        jLabel8.setText("Delivery");

        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        jScrollPane2.setViewportView(commentsTextArea);

        jLabel9.setText("Comments");

        jLabel10.setText("HCPId");

        deletedCheckBox.setText("Deleted");
        deletedCheckBox.setEnabled(false);

        jLabel12.setText("Days Until Experation");

        daysUntilExperationTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(informUser, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deletedCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addGap(47, 47, 47)
                                .addComponent(updateButton)
                                .addGap(91, 91, 91)
                                .addComponent(deleteButton)
                                .addGap(62, 62, 62)
                                .addComponent(selectButton)
                                .addGap(107, 107, 107))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(experatoinDateFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(immunizationDateFormatedField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(daysUntilExperationTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(hcpidTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(deliveryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(35, 35, 35)
                                            .addComponent(vaccineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(immunizationIDTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(immunizationIDTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(vaccineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hcpidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliveryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel12)
                                .addComponent(daysUntilExperationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(selectButton)
                                            .addComponent(addButton)
                                            .addComponent(updateButton)
                                            .addComponent(deleteButton))
                                        .addGap(16, 16, 16)
                                        .addComponent(informUser, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(deletedCheckBox, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(experatoinDateFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(immunizationDateFormatedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel5))))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            if (updateButton.getText().equals("Update")) {
                updateImmunizationHistory();
            } else {
                addImmunizationHistory();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        clearFields();
        updateButton.setText("Confirm");
        addButton.setEnabled(false);
        selectButton.setEnabled(false);
        deleteButton.setEnabled(false);
        updateButton.setEnabled(true);
        immunizationList.setEnabled(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        addButton.setEnabled(false);
        selectButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
        immunizationList.setEnabled(false);
        populateFields(immunizationList.getSelectedIndex());

    }//GEN-LAST:event_selectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addButton;
    public javax.swing.JTextArea commentsTextArea;
    public javax.swing.JTextField daysUntilExperationTextField;
    public javax.swing.JButton deleteButton;
    public javax.swing.JCheckBox deletedCheckBox;
    public javax.swing.JTextField deliveryTextField;
    public javax.swing.JFormattedTextField experatoinDateFormattedField;
    public javax.swing.JTextField hcpidTextField;
    public javax.swing.JFormattedTextField immunizationDateFormatedField;
    public javax.swing.JTextField immunizationIDTextBox;
    private javax.swing.JList<String> immunizationList;
    public javax.swing.JLabel informUser;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton selectButton;
    public javax.swing.JButton updateButton;
    public javax.swing.JTextField vaccineTextField;
    // End of variables declaration//GEN-END:variables
}
