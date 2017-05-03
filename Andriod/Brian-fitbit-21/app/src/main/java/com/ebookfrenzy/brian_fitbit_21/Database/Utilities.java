/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebookfrenzy.brian_fitbit_21.Database;

import com.ebookfrenzy.brian_fitbit_21.ProgramData.DatabaseInfo;

import java.sql.*;

/**
 *
 * @author Brian
 */
public abstract class Utilities implements DatabaseInfo {
    /**
     * The connection for the child database classes.
     */
    public Connection connection;

    /**
     * creates a database connection for child classes. This method allows you
     * to pass a custom URL, Username and Password for the connection. It is
     * recommended to use a user with full permissions to the target scheme
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation parameters.
     *
     * @param URL The url of the database including the custom parameters you
     * want to pass
     * @param PASSWORD password for the database user
     * @param USERNAME
     * @throws SQLException
     */
    public void createConnection(String URL, String PASSWORD, String USERNAME) throws SQLException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException ex) {
                throw ex;
            }
        }

    }

    /**
     * creates a database connection for child classes. This method will use the
     * default URL, Username and password found in the database info interface.
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @throws SQLException
     */
    public void createConnection() throws Exception {
        if (this.connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                throw e;
            }
        }

    }

    /**
     * Determines if a connection is null. which will most likely determine if
     * the connection is live to the database as it is the first thing that is
     * done when creating any of the database classes and errors are thrown when
     * it fails.
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @return
     */
    public boolean connectionIsLive() {
        return !(this.connection == null);
    }

}
