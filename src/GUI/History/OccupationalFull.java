/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.History;

import collections.History;
import Interface.History.Occupation;
import java.util.*;
import javax.swing.DefaultListModel;
import java.sql.Date;

/**
 *
 * @author Brian
 */
public class OccupationalFull extends javax.swing.JInternalFrame implements HistoryForm{

    History history;
    DefaultListModel occupationalListModel;
    ArrayList<Occupation> occupations;

    /**
     * Creates new form OccupationalFull
     *
     * @param history
     */
    public OccupationalFull(History history) {
        initComponents();
        this.history = history;
        occupationalListModel = new DefaultListModel();
        occupationList.setModel(occupationalListModel);
        occupations = history.getOccupationalHistory();
        occupations.stream().forEach((occupation) -> {
            occupationalListModel.addElement(occupation.getDescription());
        });
        makeAllItemsVisable();
        occupationList.setSelectedIndex(0);
        populateFields(occupationList.getSelectedIndex());
    }

    private void clearFields() {
        occupationalIDTextField.setText("");
        startDateFormattedField.setText("");
        endDateFormattedField.setText("");
        endDateFormattedField.setEnabled(true); //since this could be disabled from a previous occupation
        descriptionTextField.setText("");
        currentCheckBox.setSelected(false);
        disabilityCheckBox.setSelected(false);
        //the fields relating to disability are disabled unless the box is selected
        causeOfDisabilityTextField.setText("");
        causeOfDisabilityTextField.setEnabled(false);
        lastDayWorkedFormattedField.setText("");
        lastDayWorkedFormattedField.setEnabled(false);
        deletedCheckBox.setSelected(false);

    }

    private void makeAllItemsVisable() {
        int size = occupationalListModel.size() - 1;
        if (size == 0) {
            size = 1;
        }
        for (int i = 0; i < size; i++) {
            occupationList.ensureIndexIsVisible(i);
        }
    }

    private void populateFields(int locationInArray) {
        Occupation currentOccupation = occupations.get(locationInArray);
        occupationalIDTextField.setText(Integer.toString(currentOccupation.getOccupationalID()));
        startDateFormattedField.setText(currentOccupation.getStartDate().toString());
        if (currentOccupation.getEndDate() != null) {
            endDateFormattedField.setText(currentOccupation.getEndDate().toString());
        }
        currentCheckBox.setSelected((currentOccupation.getCurrent() != 0));
        descriptionTextField.setText(currentOccupation.getDescription());
        disabilityCheckBox.setSelected((currentOccupation.getDisability() != 0));
        causeOfDisabilityTextField.setText(currentOccupation.getCauseOfDisability());
        deletedCheckBox.setSelected(currentOccupation.getDeleted() != 0);
        if (currentOccupation.getLastWorkDate() != null) {
            lastDayWorkedFormattedField.setText(currentOccupation.getLastWorkDate().toString());
        }
        checkDisabled();
        checkCurrent();
    }

    private byte toByte(boolean bool) {
        return (byte) (bool ? 1 : 0);
    }

    private Occupation populateOccupation() throws Exception {
        Occupation newOccupation = new Occupation();
        try {
            if (!occupationalIDTextField.getText().equals("")) {
                newOccupation.setOccupationalID(Integer.parseInt(occupationalIDTextField.getText()));
            }
            newOccupation.setStartDate(Date.valueOf(startDateFormattedField.getText()));
            if (!endDateFormattedField.getText().equals("")) {
              newOccupation.setEndDate(Date.valueOf(endDateFormattedField.getText()));  
            }
            
            newOccupation.setCurrent(toByte(currentCheckBox.isSelected()));
            newOccupation.setDescription(descriptionTextField.getText());
            newOccupation.setDisability(toByte(disabilityCheckBox.isSelected()));
            newOccupation.setCauseOfDisability(causeOfDisabilityTextField.getText());
            newOccupation.setDeleted(toByte(deletedCheckBox.isSelected()));
            if (!lastDayWorkedFormattedField.getText().equals("")) {
             newOccupation.setLastWorkDate(Date.valueOf(lastDayWorkedFormattedField.getText()));   
            }            
            return newOccupation;
        } catch (Exception e) {
            throw e;
        }

    }

    private void clearInformUser() {
        informUser.setText("");
    }

    private void addOccupation() {
        try {
            Occupation newOccupation = populateOccupation();
            history.addOccupationHistory(newOccupation);
            occupationalListModel.addElement(newOccupation.getDescription());
            makeAllItemsVisable();
            occupations = history.getOccupationalHistory();
            populateFields(occupationalListModel.size() - 1);
            addButton.setEnabled(true);
            selectButton.setEnabled(true);
            updateButton.setText("Update");
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
            occupationList.setEnabled(true);
            informUser.setText("Occupation added successfully");
        } catch (Exception e) {
            informUser.setText(e.getMessage());
        }
    }

    private void updateOccupation() {
        int selection = occupationList.getSelectedIndex();
        try {
            if (selection == -1) {
                throw new Exception("Select an Occupation");
            }
            try {
                Occupation updatedOccupation = populateOccupation();
                history.updateOccupationHistory(updatedOccupation);
                occupationalListModel.remove(selection);
                occupationalListModel.add(selection, updatedOccupation.getDescription());
                occupationList.setSelectedIndex(selection);
                makeAllItemsVisable();
                occupations = history.getOccupationalHistory();
                populateFields(selection);
                occupationList.setEnabled(true);
                selectButton.setEnabled(true);
                addButton.setEnabled(true);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                informUser.setText("Occupation updated successfully");
            } catch (Exception e) {
                informUser.setText(e.getMessage());
            }

        } catch (Exception e) {
            informUser.setText(e.getMessage());
        }
    }

    private void checkDisabled() {
        if (disabilityCheckBox.isSelected()) {
            causeOfDisabilityTextField.setEnabled(true);
            lastDayWorkedFormattedField.setEnabled(true);
        } else {
            causeOfDisabilityTextField.setEnabled(false);
            lastDayWorkedFormattedField.setEnabled(false);
            causeOfDisabilityTextField.setText("");
            lastDayWorkedFormattedField.setText("");
        }
    }

    private void checkCurrent() {
        if (currentCheckBox.isSelected()) {
            endDateFormattedField.setText("");
            endDateFormattedField.setEnabled(false);
        } else {
            endDateFormattedField.setEnabled(true);
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

        informUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        occupationalIDTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        currentCheckBox = new javax.swing.JCheckBox();
        startDateFormattedField = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        endDateFormattedField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        disabilityCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        occupationList = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        causeOfDisabilityTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lastDayWorkedFormattedField = new javax.swing.JFormattedTextField();
        deletedCheckBox = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Occupational ID");

        occupationalIDTextField.setEnabled(false);

        jLabel2.setText("Start Date");

        jLabel3.setText("End Date");

        currentCheckBox.setText("Current");
        currentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentCheckBoxActionPerformed(evt);
            }
        });

        startDateFormattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel4.setText("yyyy-MM-dd");

        jLabel5.setText("yyyy-MM-dd");

        endDateFormattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel6.setText("Description");

        disabilityCheckBox.setText("Disability");
        disabilityCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disabilityCheckBoxActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(occupationList);

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

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Cause of Disability");

        causeOfDisabilityTextField.setEnabled(false);

        jLabel8.setText("Last Day Worked");

        jLabel9.setText("yyyy-MM-dd");

        lastDayWorkedFormattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        lastDayWorkedFormattedField.setEnabled(false);

        deletedCheckBox.setText("Deleted");
        deletedCheckBox.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(currentCheckBox)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(occupationalIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(startDateFormattedField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                            .addComponent(endDateFormattedField))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)))
                                    .addComponent(descriptionTextField))
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disabilityCheckBox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(causeOfDisabilityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                            .addComponent(lastDayWorkedFormattedField))
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel9))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(addButton)
                                .addGap(93, 93, 93)
                                .addComponent(updateButton)
                                .addGap(87, 87, 87)
                                .addComponent(deleteButton)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectButton)
                            .addComponent(deletedCheckBox))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(occupationalIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(106, 106, 106)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startDateFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(disabilityCheckBox)
                                    .addComponent(currentCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(causeOfDisabilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(endDateFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lastDayWorkedFormattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel9)))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deletedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(selectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(informUser, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        clearFields();
        updateButton.setText("Confirm");
        addButton.setEnabled(false);
        selectButton.setEnabled(false);
        deleteButton.setEnabled(false);
        updateButton.setEnabled(true);
        occupationList.setEnabled(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
        selectButton.setEnabled(false);
        clearInformUser();
        occupationList.setEnabled(false);
        populateFields(occupationList.getSelectedIndex());
    }//GEN-LAST:event_selectButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (updateButton.getText().equals("Confirm")) {
            addOccupation();
        } else {
            updateOccupation();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void currentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentCheckBoxActionPerformed
        checkCurrent();
    }//GEN-LAST:event_currentCheckBoxActionPerformed

    private void disabilityCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disabilityCheckBoxActionPerformed
        checkDisabled();
    }//GEN-LAST:event_disabilityCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addButton;
    public javax.swing.JTextField causeOfDisabilityTextField;
    public javax.swing.JCheckBox currentCheckBox;
    public javax.swing.JButton deleteButton;
    public javax.swing.JCheckBox deletedCheckBox;
    public javax.swing.JTextField descriptionTextField;
    public javax.swing.JCheckBox disabilityCheckBox;
    public javax.swing.JFormattedTextField endDateFormattedField;
    public javax.swing.JLabel informUser;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JFormattedTextField lastDayWorkedFormattedField;
    private javax.swing.JList<String> occupationList;
    public javax.swing.JTextField occupationalIDTextField;
    public javax.swing.JButton selectButton;
    public javax.swing.JFormattedTextField startDateFormattedField;
    public javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
