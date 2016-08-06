/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.History;

import Interface.History.Family;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Brian
 */
public class familyFull extends javax.swing.JInternalFrame implements HistoryForm{

    collections.History history;
    DefaultListModel familyMembersListModel;
    ArrayList<Family> familyMembers;

    /**
     * Creates new form familyFull2
     *
     * @param history
     */
    public familyFull(collections.History history) {
        initComponents();
        this.history = history;
        familyMembersListModel = new DefaultListModel();
        familyMembersListBox.setModel(familyMembersListModel);
        familyMembers = history.getFamilyHistory();
        familyMembers.stream().forEach((familyMember) -> {
            familyMembersListModel.addElement(familyMember.getName() + "   " + familyMember.getRelative());
        });
        makeAllItemsVisible();
        familyMembersListBox.setSelectedIndex(0);
        populateFields(familyMembersListBox.getSelectedIndex());
    }

    private void clearFields() {
        familyIDTextField.setText("");
        relativeTextField.setText("");
        aliveCheckBox.setSelected(false);
        livesWithCheckBox.setSelected(false);
        majorDisorderTextField.setText("");
        specificDisorderTextField.setText("");
        deletedCheckBox.setSelected(false);
    }
    /**
     * 
     * @param locationInArray 
     */
    public final void populateFields(int locationInArray) {
        Family currentFamily = familyMembers.get(locationInArray);
        familyIDTextField.setText(String.valueOf(currentFamily.getFamilyID()));
        nameTextField.setText(currentFamily.getName());
        relativeTextField.setText(currentFamily.getRelative());
        aliveCheckBox.setSelected((currentFamily.getAlive() != 0));
        livesWithCheckBox.setSelected((currentFamily.getLivesWithPatient() != 0));
        majorDisorderTextField.setText(currentFamily.getMajorDisorder());
        specificDisorderTextField.setText(currentFamily.getSpecificTypeDisorder());
        deletedCheckBox.setSelected(currentFamily.getDeleted() != 0);
    }

    private Family populateFamily() {
        Family currentFamily = new Family();
        try {
            if (!familyIDTextField.getText().equals("")) {
                currentFamily.setFamilyID(Integer.valueOf(familyIDTextField.getText()));
            }
            currentFamily.setName(nameTextField.getText());
            currentFamily.setRelative(relativeTextField.getText());
            currentFamily.setAlive(toByte(aliveCheckBox.isSelected()));
            currentFamily.setLivesWithPatient(toByte(livesWithCheckBox.isSelected()));
            currentFamily.setMajorDisorder(majorDisorderTextField.getText());
            currentFamily.setSpecificTypeDisorder(specificDisorderTextField.getText());
            currentFamily.setDeleted(toByte(deletedCheckBox.isSelected()));
        } catch (Exception e) {
            informUser.setText(e.getMessage());
        }
        return currentFamily;
    }

    public void addFamilyHistory() {
        Family newFamily = populateFamily();
        try {
            history.addFamilyHistory(newFamily);
            familyMembersListModel.addElement(newFamily.getName() + "    " + newFamily.getRelative());
            makeAllItemsVisible();
            familyMembersListBox.setSelectedIndex(familyMembersListModel.size() - 1);
            familyMembers = history.getFamilyHistory();
            familyMembersListBox.setEnabled(true);
            addButton.setEnabled(true);
            familyMembersListBox.setEnabled(true);
            selectButton.setEnabled(true);
            updateButton.setText("Update");
            updateButton.setEnabled(false);
            informUser.setText("Family memeber added");
        } catch (Exception e) {
            informUser.setText(title);
        }
    }

    private void updateFamilyHistory() {
        int selection = familyMembersListBox.getSelectedIndex();
        if (selection == -1) {
            informUser.setText("Select a family member to update");
        } else {
            Family updatedFamily = populateFamily();
            try {
                history.updateFamilyHistory(updatedFamily);
                familyMembersListModel.remove(selection);
                familyMembersListModel.add(selection, updatedFamily.getName() + "    " + updatedFamily.getRelative());
                familyMembersListBox.setSelectedIndex(selection);
                makeAllItemsVisible();
                familyMembers = history.getFamilyHistory();
                familyMembersListBox.setEnabled(true);
                addButton.setEnabled(true);
                familyMembersListBox.setEnabled(true);
                selectButton.setEnabled(true);
                updateButton.setText("Update");
                updateButton.setEnabled(false);
                informUser.setText("Family memeber updated");
            } catch (Exception e) {
                informUser.setText(e.getMessage());
            }
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
        int size = familyMembersListModel.size() - 1;
        for (int i = 0; i < size; i++) {
            familyMembersListBox.ensureIndexIsVisible(i);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        familyMembersListBox = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        informUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        relativeTextField = new javax.swing.JTextField();
        aliveCheckBox = new javax.swing.JCheckBox();
        livesWithCheckBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        majorDisorderTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        specificDisorderTextField = new javax.swing.JTextField();
        deletedCheckBox = new javax.swing.JCheckBox();
        familyIDTextField = new javax.swing.JTextField();
        selectButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jScrollPane1.setViewportView(familyMembersListBox);

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

        jLabel2.setText("Family ID");

        jLabel3.setText("Relation");

        aliveCheckBox.setText("Alive");

        livesWithCheckBox.setText("Lives With");

        jLabel4.setText("Major Disorder");

        jLabel5.setText("Specific Disorder");

        deletedCheckBox.setText("Deleted");
        deletedCheckBox.setEnabled(false);

        familyIDTextField.setEditable(false);

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(addButton)
                                .addGap(160, 160, 160)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(511, 511, 511))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(familyIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(specificDisorderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(185, 185, 185))
                                        .addComponent(relativeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(26, 26, 26)
                                        .addComponent(majorDisorderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aliveCheckBox)
                                    .addComponent(livesWithCheckBox))
                                .addGap(107, 107, 107)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(deletedCheckBox)
                                .addGap(42, 42, 42))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(informUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(deletedCheckBox)
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(familyIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(livesWithCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(aliveCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(relativeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(majorDisorderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(specificDisorderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(updateButton)
                            .addComponent(selectButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(informUser, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        prepareForAdding();
    }//GEN-LAST:event_addButtonActionPerformed
    
    public void prepareForAdding(){
        clearInformUser();
        addButton.setEnabled(false);
        familyMembersListBox.setEnabled(false);
        selectButton.setEnabled(false);
        updateButton.setEnabled(true);
        updateButton.setText("Confirm");
        clearFields();
    }
    
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        clearInformUser();
        if (updateButton.getText().equals("Confirm")) {
            addFamilyHistory();
        } else {
            updateFamilyHistory();
        }
        

    }//GEN-LAST:event_updateButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        populateFields(familyMembersListBox.getSelectedIndex());
        familyMembersListBox.setEnabled(false);
        selectButton.setEnabled(false);
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
    }//GEN-LAST:event_selectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addButton;
    public javax.swing.JCheckBox aliveCheckBox;
    public javax.swing.JCheckBox deletedCheckBox;
    public javax.swing.JTextField familyIDTextField;
    private javax.swing.JList<String> familyMembersListBox;
    public javax.swing.JLabel informUser;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JCheckBox livesWithCheckBox;
    public javax.swing.JTextField majorDisorderTextField;
    public javax.swing.JTextField nameTextField;
    public javax.swing.JTextField relativeTextField;
    public javax.swing.JButton selectButton;
    public javax.swing.JTextField specificDisorderTextField;
    public javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
