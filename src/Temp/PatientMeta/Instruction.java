/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp.PatientMeta;

import Database.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class Instruction implements Patient {

    //internal Variables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[7];
    private final String[] columnStrings = new String[7];
    private final String tableName = "occupationalhistorytable";
    //Definition Variables
    
    private int instructionsID;
    private int patientID;
    private int encounterID;
    private String instruction;
    private java.sql.Date dateGiven;
    private java.sql.Date completionDate;
    private int frequencyID;
    private byte deleted;

    //constructors
    public Instruction() {
        this.readData = null;
        fillColumnStrings();
    }

    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(this.instructionsID);
        valueStrings[1] = String.valueOf(this.patientID);
        valueStrings[2] = String.valueOf(this.encounterID);
        valueStrings[3] = String.valueOf(this.instruction);
        valueStrings[4] = String.valueOf(this.dateGiven);
        valueStrings[5] = String.valueOf(this.completionDate);
        valueStrings[6] = String.valueOf(this.frequencyID);
        valueStrings[7] = String.valueOf(this.deleted);
    }

    @Override
    public final void fillColumnStrings() {
        columnStrings[0] = "InstructionsID";
        columnStrings[1] = "PatientID";
        columnStrings[2] = "EncounterID";
        columnStrings[3] = "Instruction";
        columnStrings[4] = "DateGiven";
        columnStrings[5] = "CompletionDate";
        columnStrings[6] = "FrequencyID";
        columnStrings[7] = "deleted";
    }

    @Override
    public void populateData() throws Exception {
        try {
            readData.createConnection();
            currentResultSet = readData.selectAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public void populateDate(GeneralInformation currentPatient) {
        try {
            readData.createConnection();
            currentResultSet = readData.selectWhere(columnStrings[1], Integer.toString(currentPatient.getPatientID()));
        } catch (Exception e) {
        }
    }

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

    public boolean addData(Instruction newInstruction) throws Exception {
        try {
            changeInstruction(newInstruction);
            return addData();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean updateData() throws Exception {
        try {
            fillvalueStrings();
            updateData = new Update(valueStrings, columnStrings);
            return updateData.perform(currentResultSet);
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean updateData(Instruction instruction) throws Exception {
        try {
            changeInstruction(instruction);
            return updateData();
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
        currentResultSet.moveToCurrentRow();
        this.instructionsID = currentResultSet.getInt("InstructionsID");
        this.patientID = currentResultSet.getInt("PatientID");
        this.encounterID = currentResultSet.getInt("EncounterID");
        this.instruction = currentResultSet.getString("Instruction");
        this.dateGiven = currentResultSet.getDate("DateGiven");
        this.completionDate = currentResultSet.getDate("CompletionDate");
        this.frequencyID = currentResultSet.getInt("FrequencyID");
        this.deleted = currentResultSet.getByte("deleted");
    }
    public void populateFromResultSet(int position) throws Exception {
        currentResultSet.absolute(position);
        this.instructionsID = currentResultSet.getInt("InstructionsID");
        this.patientID = currentResultSet.getInt("PatientID");
        this.encounterID = currentResultSet.getInt("EncounterID");
        this.instruction = currentResultSet.getString("Instruction");
        this.dateGiven = currentResultSet.getDate("DateGiven");
        this.completionDate = currentResultSet.getDate("CompletionDate");
        this.frequencyID = currentResultSet.getInt("FrequencyID");
        this.deleted = currentResultSet.getByte("deleted");
    }
    public void populateFromResultSet(ResultSet resultSet) throws Exception {
        resultSet.moveToCurrentRow();
        this.instructionsID = resultSet.getInt("InstructionsID");
        this.patientID = resultSet.getInt("PatientID");
        this.encounterID = resultSet.getInt("EncounterID");
        this.instruction = resultSet.getString("Instruction");
        this.dateGiven = resultSet.getDate("DateGiven");
        this.completionDate = resultSet.getDate("CompletionDate");
        this.frequencyID = resultSet.getInt("FrequencyID");
        this.deleted = resultSet.getByte("deleted");
    }
    public ArrayList<Interface.PatientMeta.Instruction> createArrayList() throws Exception{
        ArrayList<Interface.PatientMeta.Instruction> instructionHistory = new ArrayList<>(readData.getNumberOfRows());
        try {
            int counter = 0;
            while (this.currentResultSet.next()) {                
                Interface.PatientMeta.Instruction newInstruction = new Interface.PatientMeta.Instruction();
                newInstruction.populateFromResultSet(currentResultSet);
                instructionHistory.add(newInstruction);
                counter++;
            }
            return  instructionHistory;
        } catch (Exception e) {
            throw e;
        }        
    }
    public int getNextID() throws Exception{
        try {
            return readData.getNextID(columnStrings[0]);
        } catch (Exception e) {
            throw e;
        }
    }

    private void changeInstruction(Instruction newInstruction) throws Exception {
        instructionsID = newInstruction.getInstructionsID();
        patientID = newInstruction.getPatientID();
        encounterID = newInstruction.getEncounterID();
        instruction = newInstruction.getInstruction();
        dateGiven = newInstruction.getDateGiven();
        completionDate = newInstruction.getCompletionDate();
        frequencyID = newInstruction.getFrequencyID();
        deleted = newInstruction.getDeleted();
        currentResultSet.absolute(findRow());
    }
    private int findRow() throws SQLException {
        int result = 0;
        int counter = 0;
        currentResultSet.absolute(0);
        while (currentResultSet.next()) {
            counter++;
            if (this.instructionsID == currentResultSet.getInt(columnStrings[0])) {
                result = counter;
            }
        }
        return result;
    }
    
    //getters

    public int getInstructionsID() {
        return instructionsID;
    }

    public int getPatientID() {
        return patientID;
    }

    public int getEncounterID() {
        return encounterID;
    }

    public String getInstruction() {
        return instruction;
    }

    public Date getDateGiven() {
        return dateGiven;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public int getFrequencyID() {
        return frequencyID;
    }

    public byte getDeleted() {
        return deleted;
    }
    
    //Setters

    public void setInstructionsID(int instructionsID) throws Exception {
        this.instructionsID = instructionsID;
    }

    public void setPatientID(int patientID) throws Exception {
        this.patientID = patientID;
    }

    public void setEncounterID(int encounterID) throws Exception {
        this.encounterID = encounterID;
    }

    public void setInstruction(String instruction) throws Exception {
        this.instruction = instruction;
    }

    public void setDateGiven(Date dateGiven) throws Exception {
        this.dateGiven = dateGiven;
    }

    public void setCompletionDate(Date completionDate) throws Exception {
        this.completionDate = completionDate;
    }

    public void setFrequencyID(int frequencyID) throws Exception {
        this.frequencyID = frequencyID;
    }

    public void setDeleted(byte deleted) throws Exception{
        this.deleted = deleted;
    }
    
    
}
