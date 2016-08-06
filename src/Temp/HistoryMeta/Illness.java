/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp.HistoryMeta;

import Database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public abstract class Illness implements History {

    //Internal Variables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[7];
    private final String[] columnStrings = new String[7];
    private final String tableName = "illnesshistorytable";

    //Definition Variables
    private int illnessID;
    private int patientID;
    private String illnessDate;
    private String illness;
    private String resolution;
    private byte illnessHRF;
    private byte deleted;

    public Illness() {
        this.readData = new Read(tableName);
        fillColumnStrings();
    }

    @Override
    public void populateFromResultSet(int position) throws Exception {
        currentResultSet.absolute(position);
        this.illnessID = currentResultSet.getInt("IllnessID");
        this.patientID = currentResultSet.getInt("PatientID");
        this.illnessDate = currentResultSet.getString("IllnessDate");
        this.illness = currentResultSet.getString("Illness");
        this.resolution = currentResultSet.getString("Resolution");
        this.illnessHRF = currentResultSet.getByte("IllnessHRF");
        this.deleted = currentResultSet.getByte("deleted");
    }

    @Override
    public void populateFromResultSet(ResultSet resultSet) throws Exception {
        resultSet.moveToCurrentRow();
        this.illnessID = resultSet.getInt("IllnessID");
        this.patientID = resultSet.getInt("PatientID");
        this.illnessDate = resultSet.getString("IllnessDate");
        this.illness = resultSet.getString("Illness");
        this.resolution = resultSet.getString("Resolution");
        this.illnessHRF = resultSet.getByte("IllnessHRF");
        this.deleted = resultSet.getByte("deleted");
    }

    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(this.illnessID);
        valueStrings[1] = String.valueOf(this.patientID);
        valueStrings[2] = String.valueOf(this.illnessDate);
        valueStrings[3] = String.valueOf(this.illness);
        valueStrings[4] = String.valueOf(this.resolution);
        valueStrings[5] = String.valueOf(this.illnessHRF);
        valueStrings[6] = String.valueOf(this.deleted);
    }

    @Override
    public final void fillColumnStrings() {
        columnStrings[0] = "IllnessID";
        columnStrings[1] = "PatientID";
        columnStrings[2] = "IllnessDate";
        columnStrings[3] = "Illness";
        columnStrings[4] = "Resolution";
        columnStrings[5] = "IllnessHRF";
        columnStrings[6] = "deleted";
    }

    @Override
    public void populateData() throws Exception {
        readData.createConnection();
        currentResultSet = readData.selectAll();
    }
    public void populateData(Temp.PatientMeta.GeneralInformation patientInfo) throws Exception{
        readData.createConnection();
        currentResultSet = readData.selectWhere(columnStrings[1], Integer.toString(patientInfo.getPatientID()));
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
    public boolean addData(Illness newIllness) throws Exception {
        try {
            changeIllness(newIllness);
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
    public boolean updateData(Illness updatedIllness) throws Exception {
        try {
            changeIllness(updatedIllness);
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
        this.illnessID = currentResultSet.getInt("IllnessID");
        this.patientID = currentResultSet.getInt("PatientID");
        this.illnessDate = currentResultSet.getString("IllnessDate");
        this.illness = currentResultSet.getString("Illness");
        this.resolution = currentResultSet.getString("Resolution");
        this.illnessHRF = currentResultSet.getByte("IllnessHRF");
        this.deleted = currentResultSet.getByte("deleted");
    }

    private void changeIllness(Illness changedIllness) throws Exception {
        this.illnessID = changedIllness.getIllnessid();
        this.patientID = changedIllness.getPatientid();
        this.illnessDate = changedIllness.getIllnessdate();
        this.illness = changedIllness.getIllness();
        this.resolution = changedIllness.getResolution();
        this.illnessHRF = changedIllness.getIllnesshrf();
        this.deleted = changedIllness.getDeleted();
        currentResultSet.absolute(findRow());
    }
    
    public ArrayList<Interface.History.Illness> createArrayList() throws Exception{
        ArrayList<Interface.History.Illness> illnessHistory = new ArrayList<>(readData.getNumberOfRows());
        try {
            int counter = 0;
            while (this.currentResultSet.next()) {                
                Interface.History.Illness newIllness = new Interface.History.Illness();
                newIllness.populateFromResultSet(currentResultSet);
                illnessHistory.add(newIllness);
                counter++;
            }
            return  illnessHistory;
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
    
    private int findRow() throws SQLException {
        int result = 0;
        int counter = 0;
        currentResultSet.absolute(0);
        while (currentResultSet.next()) {
            counter++;
            if (this.illnessID == currentResultSet.getInt(columnStrings[0])) {
                result = counter;
            }
        }
        return result;
    }

    //getters
    public int getIllnessid() {
        return illnessID;
    }

    public int getPatientid() {
        return patientID;
    }

    public String getIllnessdate() {
        return illnessDate;
    }

    public String getIllness() {
        return illness;
    }

    public String getResolution() {
        return resolution;
    }

    public byte getIllnesshrf() {
        return illnessHRF;
    }

    public byte getDeleted() {
        return deleted;
    }
    //setters

    public void setIllnessid(int illnessid) {
        this.illnessID = illnessid;
    }

    public void setPatientid(int patientid) {
        this.patientID = patientid;
    }

    public void setIllnessdate(String illnessdate) {
        this.illnessDate = illnessdate;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setIllnesshrf(byte illnesshrf) {
        this.illnessHRF = illnesshrf;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

}
