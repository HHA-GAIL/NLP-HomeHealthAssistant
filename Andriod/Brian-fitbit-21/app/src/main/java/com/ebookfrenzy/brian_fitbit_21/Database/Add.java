package com.ebookfrenzy.brian_fitbit_21.Database;

import java.sql.*;

/**
 * This class is part of the subset of the classes that will do all the database
 * interfacing. While there is no security in the methods themselves it is
 * intended a higher layer will manage that.
 *
 * Edit Date: 05/21/2016 Brian Miller
 *
 * @author Brian
 */
public class Add extends Utilities {
    //variable declaration

    String[] valueStrings;
    String[] columnStrings;

    //constructors
    /**
     * Constructor for the Add class. Forcing downstream code to pass the
     * required string arrays.
     *
     * @param valueStrings values of the data to be passed, in the order of
     * columns
     * @param columnStrings order of columns you wish to add
     */
    public Add(String[] valueStrings, String[] columnStrings) {
        this.valueStrings = valueStrings;
        this.columnStrings = columnStrings;
    }

    /**
     * This method will insert the classes record into the passed result set. It
     * will check is a result set is read only, which not only catching bad
     * sets, but null ones as well. 
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @param updateableResultSet An Updatable result set
     * @return True or false depending on if the insert was successful.
     * @throws Exception If the result is not updatable or the connection is not
     * live.
     */
    public boolean perform(ResultSet updateableResultSet) throws Exception {
        try {
            //check concurrency
            if (updateableResultSet.getConcurrency() == ResultSet.CONCUR_READ_ONLY) {
                SQLException badResultSet
                        = new SQLException("The result set passed is not updateable");
                throw badResultSet;
            }
            //actual insert
            updateableResultSet.moveToInsertRow();
            for (int i = 0; i < columnStrings.length; i++) {
                updateableResultSet.updateObject(columnStrings[i], valueStrings[i]);
            }
            updateableResultSet.insertRow();
            return true;
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception e) {
            return false;
        }
    }

}
