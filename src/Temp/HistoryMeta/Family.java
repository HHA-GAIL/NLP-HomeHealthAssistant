/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp.HistoryMeta;

import Database.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public abstract class Family implements History {

    //Internal variables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[10];
    private final String[] columnStrings = new String[10];
    private final String tableName = "familyhistorytable";

    //Definition Variables
    private int familyID;
    private int patientID;
    private String name;
    private String relative;
    private byte alive;
    private byte livesWithPatient;
    private String majorDisorder;
    private String specificTypeDisorder;
    private byte disorderHRF;
    private byte deleted;

    //Constructors
    /**
     * Creates a new family history object creating the read object.
     */
    public Family() {
        fillColumnStrings();
        this.readData = new Read(tableName);
    }

    /**
     * Constructs the value strings needed for add and update operations
     *
     * Edit Date: 05/24/2016
     */
    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(familyID);
        valueStrings[1] = String.valueOf(patientID);
        valueStrings[2] = name;
        valueStrings[3] = relative;
        valueStrings[4] = String.valueOf(alive);
        valueStrings[5] = String.valueOf(livesWithPatient);
        valueStrings[6] = majorDisorder;
        valueStrings[7] = specificTypeDisorder;
        valueStrings[8] = String.valueOf(disorderHRF);
        valueStrings[9] = String.valueOf(deleted);
    }

    /**
     * Constructs the column Strings needed for add and update operations
     *
     * Edit Date: 05/24/2016
     */
    @Override
    public final void fillColumnStrings() {
        columnStrings[0] = "FamilyID";
        columnStrings[1] = "PatientID";
        columnStrings[2] = "Name";
        columnStrings[3] = "Relation";
        columnStrings[4] = "Alive";
        columnStrings[5] = "Lives with patient";
        columnStrings[6] = "MajorDisorder";
        columnStrings[7] = "SpecificTypeDisorder";
        columnStrings[8] = "DisorderHRF";
        columnStrings[9] = "deleted";

    }

    /**
     * Populates all records of family history, not designed to be used outside
     * of testing purposes
     *
     * Edit Date: 05/24/2016 Brian Miller
     *
     * @throws Exception on database errors.
     */
    @Override
    public void populateData() throws Exception {
        try {
            readData.createConnection();
            currentResultSet = readData.selectAll();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Populates all records of family history for the passed patient.
     *
     * Edit Date: 05/24/2016 Brian Miller
     *
     * @param currentPatient
     * @throws Exception
     */
    public void populateData(Temp.PatientMeta.GeneralInformation currentPatient) throws Exception {
        try {
            readData.createConnection();
            currentResultSet = readData.selectWhere(columnStrings[1], String.valueOf(currentPatient.getPatientID()));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Adds the current family history object to the database.
     *
     * Edit Date: 05/24/2016 Brian Miller
     *
     * @return the result of the add operation, true or false.
     * @throws Exception on database errors
     */
    @Override
    public boolean addData() throws Exception {
        try {
            fillvalueStrings();
            addData = new Add(valueStrings, columnStrings);
            return addData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean addData(Family family) throws Exception {
        try {
            changeCurrentFamily(family);
            fillvalueStrings();
            addData = new Add(valueStrings, columnStrings);
            return addData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Updates the current family history object in the database.
     *
     * Edit Date: 05/24/2016 Brian Miller
     *
     * @return the result of the update operation, true or false.
     * @throws Exception on database errors
     */
    @Override
    public boolean updateData() throws Exception {
        try {
            fillvalueStrings();
            this.updateData = new Update(valueStrings, columnStrings);
            return updateData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean updateData(Family family) throws Exception {
        try {
            changeCurrentFamily(family);
            fillvalueStrings();
            updateData = new Update(valueStrings, columnStrings);
            return updateData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void populateFromResultSet() throws Exception {
        try {
            currentResultSet.moveToCurrentRow();
            familyID = currentResultSet.getInt("FamilyID");
            patientID = currentResultSet.getInt("PatientID");
            name = currentResultSet.getString("Name");
            relative = currentResultSet.getString("Relation");
            alive = currentResultSet.getByte("Alive");
            livesWithPatient = currentResultSet.getByte("Lives with patient");
            majorDisorder = currentResultSet.getString("MajorDisorder");
            specificTypeDisorder = currentResultSet.getString("SpecificTypeDisorder");
            disorderHRF = currentResultSet.getByte("DisorderHRF");
            deleted = currentResultSet.getByte("deleted");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void populateFromResultSet(ResultSet resultSet) throws Exception {
        try {
            resultSet.moveToCurrentRow();
            familyID = resultSet.getInt("FamilyID");
            patientID = resultSet.getInt("PatientID");
            name = resultSet.getString("Name");
            relative = resultSet.getString("Relation");
            alive = resultSet.getByte("Alive");
            livesWithPatient = resultSet.getByte("Lives with patient");
            majorDisorder = resultSet.getString("MajorDisorder");
            specificTypeDisorder = resultSet.getString("SpecificTypeDisorder");
            disorderHRF = resultSet.getByte("DisorderHRF");
            deleted = resultSet.getByte("deleted");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void populateFromResultSet(int position) throws Exception {
        try {
            currentResultSet.absolute(position);
            familyID = currentResultSet.getInt("FamilyID");
            patientID = currentResultSet.getInt("PatientID");
            name = currentResultSet.getString("Name");
            relative = currentResultSet.getString("Relation");
            alive = currentResultSet.getByte("Alive");
            livesWithPatient = currentResultSet.getByte("Lives with patient");
            majorDisorder = currentResultSet.getString("MajorDisorder");
            specificTypeDisorder = currentResultSet.getString("SpecificTypeDisorder");
            disorderHRF = currentResultSet.getByte("DisorderHRF");
            deleted = currentResultSet.getByte("deleted");
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Interface.History.Family> createArrayList() throws Exception {
        ArrayList<Interface.History.Family> familyArrayList = new ArrayList<>(readData.getNumberOfRows());
        try {

            int counter = 0;
            while (this.currentResultSet.next()) {
                Interface.History.Family newFamily = new Interface.History.Family();
                newFamily.populateFromResultSet(currentResultSet);
                familyArrayList.add(newFamily);
                counter++;
            }
        } catch (Exception e) {
        }

        return familyArrayList;
    }

    /**
     * Fetches and returns the next family ID.
     *
     * @return next primary key entry.
     * @throws Exception
     */
    public int getNextID() throws Exception {
        try {
            return readData.getNextID(columnStrings[0]);
        } catch (Exception e) {
            throw e;
        }
    }

    private void changeCurrentFamily(Family family) throws Exception {
        familyID = family.getFamilyID();
        patientID = family.getPatientID();
        relative = family.getRelative();
        name = family.getName();
        alive = family.getAlive();
        livesWithPatient = family.getLivesWithPatient();
        majorDisorder = family.getMajorDisorder();
        specificTypeDisorder = family.getSpecificTypeDisorder();
        disorderHRF = family.getDisorderHRF();
        deleted = family.getDeleted();
        int row = findRow();
        switch (row) {
            case 0:
                currentResultSet.beforeFirst();
                break;
            default:
                currentResultSet.absolute(row);
                break;
        }

    }

    private int findRow() throws SQLException {
        int result = 0;
        int counter = 0;
        currentResultSet.beforeFirst();
        while (currentResultSet.next()) {
            counter++;
            if (this.familyID == currentResultSet.getInt("familyID")) {
                result = counter;
            }
        }
        return result;
    }

    //Get methods
    public String[] getValueStrings() {
        return valueStrings;
    }

    public String[] getColumnStrings() {
        return columnStrings;
    }

    public int getFamilyID() {
        return familyID;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getRelative() {
        return relative;
    }

    public byte getAlive() {
        return alive;
    }

    public byte getLivesWithPatient() {
        return livesWithPatient;
    }

    public String getMajorDisorder() {
        return majorDisorder;
    }

    public String getSpecificTypeDisorder() {
        return specificTypeDisorder;
    }

    public byte getDisorderHRF() {
        return disorderHRF;
    }

    public byte getDeleted() {
        return deleted;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

    public void setAlive(byte alive) {
        this.alive = alive;
    }

    public void setLivesWithPatient(byte livesWithPatient) {
        this.livesWithPatient = livesWithPatient;
    }

    public void setMajorDisorder(String majorDisorder) {
        this.majorDisorder = majorDisorder;
    }

    public void setSpecificTypeDisorder(String specificTypeDisorder) {
        this.specificTypeDisorder = specificTypeDisorder;
    }

    public void setDisorderHRF(byte disorderHRF) {
        this.disorderHRF = disorderHRF;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public void setName(String name) {
        this.name = name;
    }

}
