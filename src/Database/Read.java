package Database;

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
public class Read extends Utilities {

    //Variable declaration
    String currentTable;
    int numberOfRows;
    //Constructors

    /**
     * A constructor for the read class that allows you to pass the intended
     * table name for easier use. I am avoiding creating the connection in this
     * method because I want to force the downstream code to explictly create
     * and close the connection
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @param currentTable Table or view you wish to select records from
     */
    public Read(String currentTable) {
        this.currentTable = currentTable;
    }

    /**
     * Default constructor for the Read class. I am avoiding creating the
     * connection in this method because I want to force the downstream code to
     * explictly create and close the connection
     *
     * Edit Date: 05/21/2016 Brian Miller
     */
    public Read() {

    }

    /**
     * This method will return an updatable result set filled with all the data
     * from a selected table. This method is only intended to be used by the
     * temp class package.
     *
     * Edit Date: 05/20/2016 Brian Miller
     *
     * @param tableName The name of the table to select records from.
     * @return Updatable result set with data from the table.
     * @throws Exception on database errors.
     */
    public ResultSet selectAll(String tableName) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + tableName + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_UPDATABLE);
        return resultSet;
    }

    /**
     * This method will return an updatable result set filled with all the data
     * from a selected table. This method is only intended to be used by the
     * temp class package.
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @return Updatable result set with data from the table.
     * @throws Exception on database errors.
     */
    public ResultSet selectAll() throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + currentTable + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_UPDATABLE);
        return resultSet;
    }

    /**
     * This method will return an updatable result set filled with the data from
     * the selected table, filtered by a where condition. This method is only
     * intended to be used by the temp class package.
     *
     * Edit Date: 05/20/2016 Brian Miller
     *
     * @param tableName The name of the table to select records from
     * @param whereCollumn The column in which the condition is tested
     * @param whereCondition The condition to test for, this method only allows
     * for = condition.
     * @return Updatable result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectWhere(String tableName, String whereCollumn, String whereCondition) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + tableName
                + " Where " + whereCollumn + "=" + whereCondition + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_UPDATABLE);
        return resultSet;
    }

    /**
     * This method will return an updatable result set filled with the data from
     * the selected table, filtered by a where condition. This method is only
     * intended to be used by the temp class package.
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @param whereCollumn The column in which the condition is tested
     * @param whereCondition The condition to test for, this method only allows
     * for = condition.
     * @return Updatable result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectWhere(String whereCollumn, String whereCondition) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + currentTable
                + " Where " + whereCollumn + "=" + whereCondition + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_UPDATABLE);
        return resultSet;
    }

    /**
     * This method will return a subset of data grouped by the selected column,
     * the result set is not updatable. This method is only intended to be used
     * by the display class package.
     *
     * Edit Date: 05/20/2016 Brian Miller
     *
     * @param tableName The name of the table to select records from.
     * @param groupByCollumn The column for the group by condition to exist.
     * @return A non-updatable result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectAllGroupBy(String tableName, String groupByCollumn) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + tableName
                + " Group By " + groupByCollumn + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * This method will return a subset of data grouped by the selected column,
     * the result set is not updatable. This method is only intended to be used
     * by the display class package.
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @param groupByCollumn The column for the group by condition to exist.
     * @return A non-updatable result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectAllGroupBy(String groupByCollumn) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + currentTable
                + " Group By " + groupByCollumn + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * This method will return a subset of data sorted by the selected column,
     * the result set is not updatable. This method is only intended to be used
     * by the display class package.
     *
     * Edit Date: 05/20/2016 Brian Miller
     *
     * @param tableName The name of the table to select records from.
     * @param sortedByColumn The column for the group by condition to exist.
     * @return A non-updatable result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectAllSortedBy(String tableName, String sortedByColumn) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + tableName
                + " Sorted By " + sortedByColumn + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * This method will return a subset of data sorted by the selected column,
     * the result set is not updatable. This method is only intended to be used
     * by the display class package.
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @param sortedByColumn The column for the group by condition to exist.
     * @return A non-updatable result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectAllSortedBy(String sortedByColumn) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + currentTable
                + " Sorted By " + sortedByColumn + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * Finds the next incremental value of the Primary Key field.
     *
     * @param idCollumn primary key column
     * @return the next ID
     * @throws Exception
     */
    public int getNextID(String idCollumn) throws Exception {
        ResultSet resultSet;
        int nextID = 0;
        String queryString = "Select max(" + idCollumn + ") from " + currentTable + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        while (resultSet.next()) {
            nextID = resultSet.getInt(1);
        }
        return nextID + 1;
    }

    /**
     * This method will return an non-updatable result set filled with all the
     * data from a selected view. This method is only intended to be used by the
     * display class package.
     *
     * Edit Date: 05/20/2016 Brian Miller
     *
     * @param viewName The name of the view to select records from.
     * @return static result set with data from the view.
     * @throws Exception on database errors.
     */
    public ResultSet selectView(String viewName) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + viewName + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * This method will return an non-updatable result set filled with all the
     * data from a selected view. This method is only intended to be used by the
     * display class package.
     *
     * Edit Date: 05/21/2016 Brian Miller
     *
     * @return static result set with data from the view.
     * @throws Exception on database errors.
     */
    public ResultSet selectView() throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + currentTable + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * This method will return an static result set filled with the data from
     * the selected view, filtered by a where condition. This method is only
     * intended to be used by the display class package.
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @param viewName The name of the view to select records from
     * @param whereCollumn The column in which the condition is tested
     * @param whereCondition The condition to test for, this method only allows
     * for = condition.
     * @return Static result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectViewWhere(String viewName, String whereCollumn, String whereCondition) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + viewName
                + " Where " + whereCollumn + "=" + whereCondition + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * This method will return an static result set filled with the data from
     * the selected view, filtered by a where condition. This method is only
     * intended to be used by the display class package.
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @param whereCollumn The column in which the condition is tested
     * @param whereCondition The condition to test for, this method only allows
     * for = condition.
     * @return Static result set with the selected data.
     * @throws Exception on database errors.
     */
    public ResultSet selectViewWhere(String whereCollumn, String whereCondition) throws Exception {
        ResultSet resultSet;
        String queryString = "Select * from " + currentTable
                + " Where " + whereCollumn + "=" + whereCondition + ";";
        resultSet = executQuery(queryString, ResultSet.CONCUR_READ_ONLY);
        return resultSet;
    }

    /**
     * For Testing Purposes This method will run a custom query. It use is not
     * recommended and will be deleted before final release.
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @param queryString The query you wish to perform must be valid MySQL
     * syntax.
     * @param readPermissions Desired read permissions from the
     * java.sql.ResultSet interface
     * @return Result with desired data and read permissions
     * @throws Exception on database errors.
     */
    public ResultSet customReadStatement(String queryString, int readPermissions) throws Exception {
        ResultSet resultSet = executQuery(queryString, readPermissions);
        return resultSet;
    }

    /**
     * A private method for executing queries and returning the result set.
     * Allows for calling methods to set the query and the read permissions
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @param queryString The desired query to perform.
     * @param readPermissions The permissions for the result set.
     * @return A scroll insensitive result set following the read permissions
     * that are passed.
     * @throws Exception
     */
    private ResultSet executQuery(String queryString, int readPermissions) throws Exception {
        ResultSet resultSet;
        try {
            //test for a live connection, if fails stop further execution.
            if (connectionIsLive() == false) {
                Exception connectionDead = new Exception("There is no active connection to the Database");
                throw connectionDead;
            } else {
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, readPermissions);
                resultSet = statement.executeQuery(queryString);
                //find number of returns
                calculateNumberOfRows(resultSet);
                System.err.println(this.numberOfRows);
                return resultSet;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Counts the number of rows in the returned result set for further use.
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @param resultSet result set you want to count
     * @throws SQLException this should never occur, as the result set is
     * already valid.
     */
    private void calculateNumberOfRows(ResultSet resultSet) throws SQLException {
        try {
            resultSet.last();
            numberOfRows = resultSet.getRow();
        } catch (Exception e) {
        }
        resultSet.beforeFirst();  //return the result set to the first position.
    }

    /**
     * This variable is calculated during each select statement execution.
     * Useful for random methods and determining available size.
     * ------------------------------------------------------------------------
     * Edit Date: 06/14/2016 Brian Miller - Initial creation
     *
     * @return
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

}
