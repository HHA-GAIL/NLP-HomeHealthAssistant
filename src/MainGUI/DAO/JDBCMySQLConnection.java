package MainGUI.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMySQLConnection {

    //static reference to itself
    public static final String URL = "jdbc:mysql://localhost:3306/cnit350_database?useSSL=true";
//    public static final String URL = "jdbc:mysql://localhost:3306/table_form?useSSL=true";
    public static final String USER = "root";
    public static final String PASSWORD = "960617";
//    public static final String PASSWORD = "123";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private static Connection createConnection() {
        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return createConnection();
    }

    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
