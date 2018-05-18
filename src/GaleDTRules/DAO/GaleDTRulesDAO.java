/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleDTRules.DAO;

import MainGUI.DAO.JDBCMySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NazonaX
 */
public class GaleDTRulesDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean insertDTRules(String RuleSetName, String Attributes, String EntryTable, String RuleSetString, String DTXMLContent) {
        boolean result = false;
        try {
            conn = JDBCMySQLConnection.getConnection(JDBCMySQLConnection.TYPE.GALE);
            pstmt = conn.prepareStatement("insert into DTRules(RuleName, Attributes, RuleSetContent, EntryTable, DTXMLContent) values(?,?,?,?,?)");
            pstmt.setString(1, RuleSetName);
            pstmt.setString(2, Attributes);
            pstmt.setString(3, RuleSetString);
            pstmt.setString(4, EntryTable);
            pstmt.setString(5, DTXMLContent);
            int count = pstmt.executeUpdate();
            if(count > 0)
                result = true;
//            System.out.println("Check...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return result;
    }
    
}
