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
public abstract class Imunization implements History {

    //Internal Varriables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[9];
    private final String[] columnStrings = new String[9];
    private final String tableName = "immunizationshistorytable";

    //Definition Varriables
    private int immunizationsID;
    private int patientID;
    private String vaccine;
    private java.sql.Date immunizationDate;
    private java.sql.Date experationDate;
    private String delivery;
    private String comments;
    private int HCPId;
    private byte deleted;
    //Constructors
    public Imunization() {
        fillColumnStrings();
        readData = new Read(tableName);
    }

    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(immunizationsID);
        valueStrings[1] = String.valueOf(patientID);
        valueStrings[2] = vaccine;
        valueStrings[3] = immunizationDate.toString();
        valueStrings[4] = experationDate.toString();
        valueStrings[5] = delivery;
        valueStrings[6] = comments;
        valueStrings[7] = Integer.toString(HCPId);
        valueStrings[8] = Byte.toString(deleted);
    }

    @Override
    public final void fillColumnStrings() {
        columnStrings[0] = "ImmunizationsID";
        columnStrings[1] = "PatientID";
        columnStrings[2] = "Vaccine";
        columnStrings[3] = "ImmunizationDate";
        columnStrings[4] = "ExperationDate";
        columnStrings[5] = "Delivery";
        columnStrings[6] = "Comments";
        columnStrings[7] = "HCPId";
        columnStrings[8] = "deleted";
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
    public boolean addData(Imunization immunization) throws Exception{
        try {
            changeImmunization(immunization);
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
    
    public boolean updateData(Imunization immunization) throws Exception {
        try {
            changeImmunization(immunization);            
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
        currentResultSet.moveToCurrentRow();
        immunizationsID = currentResultSet.getInt("ImmunizationsID");
        patientID = currentResultSet.getInt("PatientID");
        vaccine = currentResultSet.getString("Vaccine");
        immunizationDate = currentResultSet.getDate("ImmunizationDate");
        experationDate = currentResultSet.getDate("ExperationDate");
        delivery = currentResultSet.getString("Delivery");
        comments = currentResultSet.getString("Comments");
        HCPId = currentResultSet.getInt("HCPId");
        deleted = currentResultSet.getByte("deleted");                
    }
    
    @Override
    public void populateFromResultSet(int position) throws Exception {
        currentResultSet.absolute(position);
        immunizationsID = currentResultSet.getInt("ImmunizationsID");
        patientID = currentResultSet.getInt("PatientID");
        vaccine = currentResultSet.getString("Vaccine");
        immunizationDate = currentResultSet.getDate("ImmunizationDate");
        experationDate = currentResultSet.getDate("ExperationDate");
        delivery = currentResultSet.getString("Delivery");
        comments = currentResultSet.getString("Comments");
        HCPId = currentResultSet.getInt("HCPId");
        deleted = currentResultSet.getByte("deleted");                
    }
    
    @Override
    public void populateFromResultSet(ResultSet resultSet) throws Exception {
        resultSet.moveToCurrentRow();
        immunizationsID = resultSet.getInt("ImmunizationsID");
        patientID = resultSet.getInt("PatientID");
        vaccine = resultSet.getString("Vaccine");
        immunizationDate = resultSet.getDate("ImmunizationDate");
        experationDate = resultSet.getDate("ExperationDate");
        delivery = resultSet.getString("Delivery");
        comments = resultSet.getString("Comments");
        HCPId = resultSet.getInt("HCPId");
        deleted = resultSet.getByte("deleted");                
    }
    
    public ArrayList<Interface.History.Immunizations> createArrayList() throws Exception{
        ArrayList<Interface.History.Immunizations> ImmunizationHistory = new ArrayList<>(readData.getNumberOfRows());
        try {
            int counter = 0;
            while (this.currentResultSet.next()) {                
                Interface.History.Immunizations newImmunization = new Interface.History.Immunizations();
                newImmunization.populateFromResultSet(currentResultSet);
                ImmunizationHistory.add(newImmunization);
                counter++;
            }
        } catch (Exception e) {
        }
        return  ImmunizationHistory;
    }
    
    public int getNextID() throws Exception{
        try {
            return readData.getNextID(columnStrings[0]);
        } catch (Exception e) {
            throw e;
        }
    }
        
    private void changeImmunization(Imunization imunization) throws Exception {        
        immunizationsID = imunization.getImmunizationsID();
        patientID = imunization.getPatientID();
        vaccine = imunization.getVaccine();
        immunizationDate = imunization.getImmunizationDate();
        experationDate = imunization.getExperationDate();
        delivery = imunization.getDelivery();
        comments = imunization.getComments();
        HCPId = imunization.getHCPId();
        deleted = imunization.getDeleted();
        int row = findRow();
        currentResultSet.absolute(findRow());
    }
    
    private int findRow() throws SQLException {
        int result = 0;
        int counter = 0;
        currentResultSet.absolute(0);
        while (currentResultSet.next()) {
            counter++;
            if (this.immunizationsID == currentResultSet.getInt(columnStrings[0])) {
                result = counter;
            }
        }
        return result;
    }
    
    //Get Methods
    public int getImmunizationsID() {
        return immunizationsID;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getVaccine() {
        return vaccine;
    }

    public Date getImmunizationDate() {
        return immunizationDate;
    }

    public Date getExperationDate() {
        return experationDate;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getComments() {
        return comments;
    }

    public int getHCPId() {
        return HCPId;
    }

    public byte getDeleted() {
        return deleted;
    }
    //Set methods

    public void setImmunizationsID(int immunizationsID) {
        this.immunizationsID = immunizationsID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public void setImmunizationDate(Date immunizationDate) {
        this.immunizationDate = immunizationDate;
    }

    public void setExperationDate(Date experationDate) {
        this.experationDate = experationDate;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setHCPId(int HCPId) {
        this.HCPId = HCPId;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    
            

}
