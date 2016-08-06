/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.History;

import Interface.History.Illness;
import collections.History;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Brian
 */
public class illnessFull extends javax.swing.JInternalFrame implements HistoryForm{

    History history;
    ArrayList<Illness> illnessHistory;
    DefaultListModel illnessListModel;

    /**
     * Creates new form illnessFull
     *
     * @param history
     */
    public illnessFull(History history) {
        initComponents();
        this.history = history;
        illnessListModel = new DefaultListModel();
        illnessList.setModel(illnessListModel);
        illnessHistory = history.getIllnessHistory();
        illnessHistory.stream().forEach((illness) -> {
            illnessListModel.addElement(illness.getIllness() + "   " + illness.getIllnessdate());
        });
        makeAllItemsVisible();
        if (illnessListModel.size() == 0) {
            selectButton.setEnabled(false);
            illnessList.setEnabled(false);
            updateButton.setEnabled(false);
            addButton.setEnabled(true);
            deleteButton.setEnabled(false);
        } else {
            illnessList.setSelectedIndex(0);
            populateFields(illnessList.getSelectedIndex());
        }

    }

    private void clearFields() {
        illnessIDTextField.setText("");
        illnessDateFormatedField.setText("");
        illnessTextField.setText("");
        resolutionTextField.setText("");
        illnessHRFCheckBox.setSelected(false);
        deletedCheckBox.setSelected(false);
    }

    private void populateFields(int locationInArray) {
        Illness illnessToPopulate = illnessHistory.get(locationInArray);
        illnessIDTextField.setText(String.valueOf(illnessToPopulate.getIllnessid()));
        illnessDateFormatedField.setText(illnessToPopulate.getIllnessdate());
        illnessTextField.setText(illnessToPopulate.getIllness());
        resolutionTextField.setText(illnessToPopulate.getResolution());
        illnessHRFCheckBox.setSelected(illnessToPopulate.getIllnesshrf() != 0);
        deletedCheckBox.setSelected(illnessToPopulate.getDeleted() != 0);
    }

    private Illness populateIllness() throws Exception {
        Illness populatedIllness = new Illness();
        try {
            if (!illnessIDTextField.getText().equals("")) {
                populatedIllness.setIllnessid(Integer.parseInt(illnessIDTextField.getText()));
            }
            populatedIllness.setIllnessdate(illnessDateFormatedField.getText());
            populatedIllness.setIllness(illnessTextField.getText());
            populatedIllness.setResolution(resolutionTextField.getText());
            populatedIllness.setIllnesshrf(toByte(illnessHRFCheckBox.isSelected()));
            populatedIllness.setDeleted(toByte(deletedCheckBox.isSelected()));
        } catch (Exception e) {
            informUser.setText(e.getMessage());
            throw e;
        }
        return populatedIllness;
    }

    private void addIllness() {
        try {
            Illness newIllness = populateIllness();
            history.addIllnessHistory(newIllness);
            illnessListModel.addElement(newIllness.getIllness() + "    "
                    + newIllness.getIllnessdate());
            makeAllItemsVisible();
            illnessList.setSelectedIndex(illnessListModel.getSize() - 1);
            illnessHistory = history.getIllnessHistory();
            illnessList.setEnabled(true);
            addButton.setEnabled(true);
            illnessList.setEnabled(true);
            selectButton.setEnabled(true);
            updateButton.setText("Update");
            updateButton.setEnabled(false);
            informUser.setText("Illness added");
        } catch (Exception e) {
            informUser.setText(e.getMessage());
        }
    }

    private void updateIllness() {
        int selection = illnessList.getSelectedIndex();
        try {
            if (selection == -1) {
                throw new Exception("No item selected");
            }
            Illness updatedIllness = populateIllness();
            history.updateIllnessHistory(updatedIllness);
            illnessListModel.remove(selection);
            illnessListModel.add(selection, updatedIllness.getIllness() + "    "
                    + updatedIllness.getIllnessdate());
            makeAllItemsVisible();
            illnessHistory = history.getIllnessHistory();
            illnessList.setEnabled(true);
            addButton.setEnabled(true);
            illnessList.setEnabled(true);
            selectButton.setEnabled(true);
            updateButton.setText("Update");
            updateButton.setEnabled(false);
            informUser.setText("Illness updated");
        } catch (Exception e) {
            informUser.setText(e.getMessage());
        }
    }

    private void clearInformUser() {
        informUser.setText("");
    }

    /**
     * Runs through the list box to ensure all items from the list model are
     * visible and selectable in the parent list box.
     */
    public final void makeAllItemsVisible() {
        int size = illnessListModel.size() - 1;
        for (int i = 0; i < size; i++) {
            illnessList.ensureIndexIsVisible(i);
        }
    }

    private byte toByte(boolean bool) {
        return (byte) (bool ? 1 : 0);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deletedCheckBox = new javax.swing.JCheckBox();
        illnessIDTextField = new javax.swing.JTextField();
        illnessTextField = new javax.swing.JTextField();
        illnessDateFormatedField = new javax.swing.JFormattedTextField();
        resolutionTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        illnessList = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        informUser = new javax.swing.JLabel();
        illnessHRFCheckBox = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Illness History");

        jLabel1.setText("Illness ID");

        jLabel2.setText("Ilness Date");

        jLabel3.setText("yyyy-MM-dd");

        jLabel4.setText("Illness");

        jLabel5.setText("Resolution");

        deletedCheckBox.setText("Deleted");

        illnessIDTextField.setEnabled(false);

        illnessDateFormatedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        illnessList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(illnessList);

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

        illnessHRFCheckBox.setText("Illness HRF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deletedCheckBox)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(illnessIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(93, 93, 93)
                                .addComponent(updateButton)
                                .addGap(87, 87, 87)
                                .addComponent(deleteButton)
                                .addGap(108, 108, 108))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(illnessTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(186, 186, 186))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(illnessDateFormatedField)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addGap(110, 110, 110)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(29, 29, 29)
                                        .addComponent(resolutionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(illnessHRFCheckBox))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(selectButton)
                                .addGap(91, 91, 91))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(informUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(illnessIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(illnessDateFormatedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resolutionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(illnessTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(illnessHRFCheckBox)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGap(80, 80, 80)
                        .addComponent(deletedCheckBox))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(selectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informUser, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
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
        illnessList.setEnabled(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (updateButton.getText().equals("Confirm")) {
            addIllness();
        } else {
            updateIllness();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
        selectButton.setEnabled(false);
        clearInformUser();
        illnessList.setEnabled(false);
        populateFields(illnessList.getSelectedIndex());
    }//GEN-LAST:event_selectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addButton;
    public javax.swing.JButton deleteButton;
    public javax.swing.JCheckBox deletedCheckBox;
    public javax.swing.JFormattedTextField illnessDateFormatedField;
    public javax.swing.JCheckBox illnessHRFCheckBox;
    public javax.swing.JTextField illnessIDTextField;
    private javax.swing.JList<String> illnessList;
    public javax.swing.JTextField illnessTextField;
    public javax.swing.JLabel informUser;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField resolutionTextField;
    public javax.swing.JButton selectButton;
    public javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
