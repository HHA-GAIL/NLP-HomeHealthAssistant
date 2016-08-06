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
public abstract class Occupation implements History {

    // Internal Varriables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[11];
    private final String[] columnStrings = new String[11];
    private final String tableName = "occupationalhistorytable";

    //Definition Varriables
    private int occupationalID;
    private int patientID;
    private Date startDate;
    private Date endDate;
    private String description;
    private byte current;
    private byte disability;
    private String causeOfDisability;
    private byte occupationalHRF;
    private byte deleted;
    private Date lastWorkDate;
    //Constructors

    public Occupation() {
        this.readData = new Read(tableName);
        fillColumnStrings();
    }

    //methods
    @Override
    public void fillvalueStrings() {
        valueStrings[0] = Integer.toString(occupationalID);
        valueStrings[1] = Integer.toString(patientID);
        valueStrings[2] = startDate.toString();
        if (endDate == null) {
            valueStrings[3] = null;
        } else {
            valueStrings[3] = endDate.toString();
        }        
        valueStrings[4] = description;
        valueStrings[5] = Byte.toString(current);
        valueStrings[6] = Byte.toString(disability);
        valueStrings[7] = causeOfDisability;
        valueStrings[8] = Byte.toString(occupationalHRF);
        valueStrings[9] = Byte.toString(deleted);
        if (lastWorkDate == null) {
            valueStrings[10] = null;
        } else {
            valueStrings[10] = lastWorkDate.toString();
        }
    }

    @Override
    public void fillColumnStrings() {
        columnStrings[0] = "OccupationalID";
        columnStrings[1] = "PatientID";
        columnStrings[2] = "StartDate";
        columnStrings[3] = "EndDate";
        columnStrings[4] = "Description";
        columnStrings[5] = "Current";
        columnStrings[6] = "Disability";
        columnStrings[7] = "Causeofdisability";
        columnStrings[8] = "OccupationalHRF";
        columnStrings[9] = "deleted";
        columnStrings[10] = "LastWorkDate";
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

    public void populateData(Interface.PatientMeta.GeneralInformation currentPatient) {
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

    public boolean addData(Occupation occupation) throws Exception {
        try {
            changeOccupation(occupation);
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

    public boolean updateData(Occupation occupation) throws Exception {
        try {
            changeOccupation(occupation);
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
        occupationalID = currentResultSet.getInt("OccupationalID");
        patientID = currentResultSet.getInt("PatientID");
        startDate = currentResultSet.getDate("StartDate");
        endDate = currentResultSet.getDate("EndDate");
        description = currentResultSet.getString("Description");
        current = currentResultSet.getByte("Current");
        disability = currentResultSet.getByte("Disability");
        causeOfDisability = currentResultSet.getString("Causeofdisability");
        occupationalHRF = currentResultSet.getByte("OccupationalHRF");
        deleted = currentResultSet.getByte("deleted");
        lastWorkDate = currentResultSet.getDate("LastWorkDate");
    }

    @Override
    public void populateFromResultSet(int position) throws Exception {
        currentResultSet.absolute(position);
        populateFromResultSet();
    }

    @Override
    public void populateFromResultSet(ResultSet resultSet) throws Exception {
        resultSet.moveToCurrentRow();
        occupationalID = resultSet.getInt("OccupationalID");
        patientID = resultSet.getInt("PatientID");
        startDate = resultSet.getDate("StartDate");
        endDate = resultSet.getDate("EndDate");
        description = resultSet.getString("Description");
        current = resultSet.getByte("Current");
        disability = resultSet.getByte("Disability");
        causeOfDisability = resultSet.getString("Causeofdisability");
        occupationalHRF = resultSet.getByte("OccupationalHRF");
        deleted = resultSet.getByte("deleted");
        lastWorkDate = resultSet.getDate("LastWorkDate");
    }

    private void changeOccupation(Occupation occupation) throws Exception {
        occupationalID = occupation.getOccupationalID();
        patientID = occupation.getPatientID();
        startDate = occupation.getStartDate();
        endDate = occupation.getEndDate();
        description = occupation.getDescription();
        current = occupation.getCurrent();
        disability = occupation.getDisability();
        causeOfDisability = occupation.getCauseOfDisability();
        occupationalHRF = occupation.getOccupationalHRF();
        deleted = occupation.getDeleted();
        lastWorkDate =occupation.getLastWorkDate();
        currentResultSet.absolute(findRow());
    }
    
    private int findRow() throws SQLException {
        int result = 0;
        int counter = 0;
        currentResultSet.absolute(0);
        while (currentResultSet.next()) {
            counter++;
            if (this.occupationalID == currentResultSet.getInt(columnStrings[0])) {
                result = counter;
            }
        }
        return result;
    }
    
    public ArrayList<Interface.History.Occupation> createArrayList() throws Exception{
        ArrayList<Interface.History.Occupation> occupationHistory = new ArrayList<>(readData.getNumberOfRows());
        try {
            int counter = 0;
            while (this.currentResultSet.next()) {                
                Interface.History.Occupation newOccupation = new Interface.History.Occupation();
                newOccupation.populateFromResultSet(currentResultSet);
                occupationHistory.add(newOccupation);
                counter++;
            }
        } catch (Exception e) {
            throw e;
        }
        return  occupationHistory;
    }
    
    public int getNextID() throws Exception{
        try {
            return readData.getNextID(columnStrings[0]);
        } catch (Exception e) {
            throw e;
        }
    }

    //Get Methods
    public int getOccupationalID() {
        return occupationalID;
    }

    public int getPatientID() {
        return patientID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public byte getCurrent() {
        return current;
    }

    public byte getDisability() {
        return disability;
    }

    public String getCauseOfDisability() {
        return causeOfDisability;
    }

    public byte getOccupationalHRF() {
        return occupationalHRF;
    }

    public Date getLastWorkDate() {
        return lastWorkDate;
    }

    public byte getDeleted() {
        return deleted;
    }

    //Set Methods
    public void setOccupationalID(int occupationalID) {
        this.occupationalID = occupationalID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrent(byte current) {
        this.current = current;
    }

    public void setDisability(byte disability) {
        this.disability = disability;
    }

    public void setCauseOfDisability(String causeOfDisability) {
        this.causeOfDisability = causeOfDisability;
    }

    public void setOccupationalHRF(byte occupationalHRF) {
        this.occupationalHRF = occupationalHRF;
    }

    public void setLastWorkDate(Date lastWorkDate) {
        this.lastWorkDate = lastWorkDate;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

}
