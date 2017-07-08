/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGUI.DAO;

import MainGUI.Classes.Therapy;
import static MainGUI.MasterGUI.patient_ID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fan Hu
 */
public class TherapyDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<Therapy> therapies) {
        boolean success = false;
        String sql = "insert into patienttherapiestable values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (Therapy therapy : therapies) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, therapy.getTherapyID());
                pstmt.setInt(2, therapy.getPatientID());
                pstmt.setInt(3, therapy.getEncounterID());
                pstmt.setString(4, therapy.getTherapyDescription());
                pstmt.setDate(5, therapy.getStartDate());
                pstmt.setDate(6, therapy.getEndDate());
                pstmt.setString(7, therapy.getOutcome());
                pstmt.setString(8, therapy.getCertificationType());
                pstmt.setString(9, therapy.getDuration());
                pstmt.setDate(10, therapy.getOrderDate());
                pstmt.setString(11, therapy.getO2FlowRate());
                pstmt.setByte(12, therapy.getDeleted());
                pstmt.execute();
            }
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return success;
    }

    public boolean update(List<Therapy> therapies) {
        boolean success = false;
        String sql = "update patienttherapiestable set TherapyID=?,PatientID=?,EncounterID=?,TherapyDescription=?,StartDate=?,EndDate=?,Outcome=?,CertificationType=?,Duration=?,OrderDate=?,O2FlowRate=?,deleted=? where TherapyID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (Therapy therapy : therapies) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, therapy.getTherapyID());
                pstmt.setInt(2, therapy.getPatientID());
                pstmt.setInt(3, therapy.getEncounterID());
                pstmt.setString(4, therapy.getTherapyDescription());
                pstmt.setDate(5, therapy.getStartDate());
                pstmt.setDate(6, therapy.getEndDate());
                pstmt.setString(7, therapy.getOutcome());
                pstmt.setString(8, therapy.getCertificationType());
                pstmt.setString(9, therapy.getDuration());
                pstmt.setDate(10, therapy.getOrderDate());
                pstmt.setString(11, therapy.getO2FlowRate());
                pstmt.setByte(12, therapy.getDeleted());
                pstmt.setInt(13, therapy.getTherapyID());
                pstmt.execute();
            }
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return success;
    }

    public DefaultTableModel getTableModel() {
        try {
            int tempPatientID = Integer.parseInt(patient_ID);
            conn = JDBCMySQLConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM patienttherapiestable where deleted=0 and PatientID=? order by StartDate DESC;");
            pstmt.setInt(1, tempPatientID);
            rst = pstmt.executeQuery();
            ResultSetMetaData metaData = rst.getMetaData();
            int count = metaData.getColumnCount(); //number of column
            Vector<String> columnNames = new Vector<>();

            for (int i = 1; i <= count - 1; i++) {
                columnNames.add(metaData.getColumnLabel(i));
            }

            Vector<Vector<Object>> data = new Vector<>();
            while (rst.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= count - 1; columnIndex++) {
                    vector.add(rst.getObject(columnIndex));
                }
                data.add(vector);
            }
            return new DefaultTableModel(data, columnNames) {
                /* set the first row, which is id row, not editable */
                @Override
                public boolean isCellEditable(int row, int column) {
                    return !(0 <= row && row < getRowCount() && column == 0 || column == 1);
                }

                @Override
                public Class<?> getColumnClass(int column) {
                    return Object.class;
                }
            };
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return null;
    }

    public int getCurrentId() {
        int therapyID = -1;
        try {
            conn = JDBCMySQLConnection.getConnection();
            pstmt = conn.prepareStatement("select max(TherapyID) from patienttherapiestable");
            rst = pstmt.executeQuery();
            rst.next();
            therapyID = rst.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return therapyID;
    }
}
