/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramData;

import Database.*;
import Temp.PatientMeta.Patient;
import java.sql.ResultSet;

/**
 *
 * @author Brian
 */
public class Fequency implements Patient {

    //internal Variables
    private final Read readData;
    private Remove removeData;
    private Add addData;
    private Update updateData;
    private ResultSet currentResultSet;
    private final String[] valueStrings = new String[4];
    private final String[] columnStrings = new String[4];
    private final String tableName = "fequencytable";

    private int fequencyID;
    private int timesPerDay;
    private String description;

    public Fequency() {
        this.readData = new Read(tableName);
        fillColumnStrings();
    }

    @Override
    public void fillvalueStrings() {
        valueStrings[0] = String.valueOf(this.fequencyID);
        valueStrings[1] = String.valueOf(this.timesPerDay);
        valueStrings[2] = String.valueOf(this.description);
    }

    @Override
    public final void fillColumnStrings() {
        columnStrings[0] = "fequencyID";
        columnStrings[1] = "TimesPerDay";
        columnStrings[2] = "Description";
    }

    @Override
    public void populateData() throws Exception {
        this.fequencyID = currentResultSet.getInt("fequencyID");
        this.timesPerDay = currentResultSet.getInt("TimesPerDay");
        this.description = currentResultSet.getString("Description");
    }

    @Override
    public boolean addData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void populateFromResultSet() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
