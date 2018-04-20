package MainGUI.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMySQLConnection {

    //static reference to itself
    public static final String URL = "jdbc:mysql://ec2-54-200-12-7.us-west-2.compute.amazonaws.com:3306/dbo?useSSL=true";
    public static final String URL_GALE = "jdbc:mysql://ec2-54-200-12-7.us-west-2.compute.amazonaws.com:3306/gale?useSSL=true";
    public static final String USER = "research";
    public static final String PASSWORD = "Gail01";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    
    public static enum TYPE{Normal, GALE};
    
    private static Connection createGaleConnection() {
         Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL_GALE, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

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
    
    public static Connection getConnection(TYPE enumer){
        if(enumer == TYPE.Normal){
            return createConnection();
        }else if(enumer == TYPE.GALE){
            return createGaleConnection();
        }
        return null;
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
