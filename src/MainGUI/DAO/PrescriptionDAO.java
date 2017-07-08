/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGUI.DAO;

import MainGUI.Classes.Prescriptions;
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
public class PrescriptionDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<Prescriptions> prescriptions) {
        boolean success = false;
        String sql = "insert into patientprescriptiontable values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (Prescriptions prescription : prescriptions) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, prescription.getPrescriptionID());
                pstmt.setInt(3, prescription.getPatientID());
                pstmt.setInt(2, prescription.getCurrentMedicationID());
                pstmt.setString(4, prescription.getMedication());
                pstmt.setString(5, prescription.getPrescriptionQuantity());
                pstmt.setString(6, prescription.getPrescriptionQuantityUnits());
                pstmt.setInt(7, prescription.getRefills());
                pstmt.setString(8, prescription.getRefillPeriod());
                pstmt.setByte(9, prescription.getGeneric());
                pstmt.setInt(10, prescription.getPrescriptionHCP());
                pstmt.setDate(11, prescription.getPrescriptionDate());
                pstmt.setInt(12, prescription.getPharmacyID());
                pstmt.setString(13, prescription.getInstructions());
                pstmt.setString(14, prescription.getPrescriptionMedsAmt());
                pstmt.setString(15, prescription.getPrescriptionMedsUnit());
                pstmt.setByte(16, prescription.getDeleted());
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

    public boolean update(List<Prescriptions> prescriptions) {
        boolean success = false;
        String sql = "update patientprescriptiontable set "
                + "PrescriptionID=?,"
                + "CurrentMedicationID=?,"
                + "PatientID=?,"
                + "Medication=?,"
                + "PrescriptionQuantity=?,"
                + "PrescriptionQuantityUnits=?,"
                + "Refills=?,"
                + "RefillPeriod=?,"
                + "Generic=?,"
                + "PrescriptionHCP=?,"
                + "PrescriptionDate=?,"
                + "PharmacyID=?,"
                + "Instructions=?,"
                + "PrescriptionMedsAmt=?,"
                + "PrescriptionMedsUnit=?,"
                + "deleted=? "
                + "where PrescriptionID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (Prescriptions prescription : prescriptions) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, prescription.getPrescriptionID());
                pstmt.setInt(3, prescription.getPatientID());
                pstmt.setInt(2, prescription.getCurrentMedicationID());
                pstmt.setString(4, prescription.getMedication());
                pstmt.setString(5, prescription.getPrescriptionQuantity());
                pstmt.setString(6, prescription.getPrescriptionQuantityUnits());
                pstmt.setInt(7, prescription.getRefills());
                pstmt.setString(8, prescription.getRefillPeriod());
                pstmt.setByte(9, prescription.getGeneric());
                pstmt.setInt(10, prescription.getPrescriptionHCP());
                pstmt.setDate(11, prescription.getPrescriptionDate());
                pstmt.setInt(12, prescription.getPharmacyID());
                pstmt.setString(13, prescription.getInstructions());
                pstmt.setString(14, prescription.getPrescriptionMedsAmt());
                pstmt.setString(15, prescription.getPrescriptionMedsUnit());
                pstmt.setByte(16, prescription.getDeleted());
                pstmt.setInt(17, prescription.getPrescriptionID());
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
            pstmt = conn.prepareStatement("SELECT * FROM patientprescriptiontable where deleted=0 and PatientID=? order by PrescriptionDate DESC;");
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
            pstmt = conn.prepareStatement("select max(PrescriptionID) from patientprescriptiontable");
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
