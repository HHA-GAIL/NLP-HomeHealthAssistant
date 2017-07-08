package com.ebookfrenzy.brian_fitbit_21.Database;

import java.sql.*;

/**
 * This class is part of the subset of the classes that will do all the database
 * interfacing. While there is no security in the methods themselves it is
 * intended a higher layer will manage that.
 *
 * Edit Date: 05/20/2016 Brian Miller
 *
 * @author Brian
 */
public class Update extends Utilities {

    //variable declaration
    String[] valueStrings;
    String[] columnStrings;

    //constructors
    /**
     * Constructor for the Update class. Forcing downstream code to pass the
     * required string arrays.
     *
     * @param valueStrings values of the data to be passed, in the order of
     * columns
     * @param columnStrings order of columns you wish to update
     */
    public Update(String[] valueStrings, String[] columnStrings) {
        this.valueStrings = valueStrings;
        this.columnStrings = columnStrings;
    }

    //Methods
    /**
     * This method will update the passed result set with the data passed in the
     * constructor. It will check is a result set is read only, which not only
     * catching bad sets, but null ones as well. 
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @param updateableResultSet An Updatable result set
     * @return True or false depending on if the update was successful.
     * @throws Exception If the result is not updatable.
     */
    public boolean perform(ResultSet updateableResultSet) throws Exception {
        try {
            //check concurrency
            if (updateableResultSet.getConcurrency() == ResultSet.CONCUR_READ_ONLY) {
                SQLException badResultSet
                        = new SQLException("The result set passed is not updateable");
                throw badResultSet;
            }
            //actual update
            updateableResultSet.moveToCurrentRow();
            for (int i = 0; i < columnStrings.length; i++) {
                updateableResultSet.updateObject(columnStrings[i], valueStrings[i]);
            }
            updateableResultSet.updateRow();
            return true;
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
            
        }
    }
}
