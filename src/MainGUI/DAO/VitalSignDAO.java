/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGUI.DAO;

import MainGUI.Classes.VitalSign;
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
public class VitalSignDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<VitalSign> vitalSigns) {
        boolean success = false;
        String sql = "insert into vitalsigns values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (VitalSign vitalSign : vitalSigns) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, vitalSign.getEncounterID());
                pstmt.setInt(2, vitalSign.getPatientID());
                pstmt.setString(3, vitalSign.getPETime());
                pstmt.setDouble(4, vitalSign.getHt());
                pstmt.setString(5, vitalSign.getHt_Unit_of_Measurement());
                pstmt.setDouble(6, vitalSign.getWt());
                pstmt.setString(7, vitalSign.getWt_Unit_of_Measurement());
                pstmt.setInt(8, vitalSign.getHR());
                pstmt.setInt(9, vitalSign.getRR());
                pstmt.setDouble(10, vitalSign.getHeadCircumference());
                pstmt.setString(11, vitalSign.getHead_Unit_of_Measurement());
                pstmt.setDouble(12, vitalSign.getBodyMassIndex());
                pstmt.setInt(13, vitalSign.getBPSYS1());
                pstmt.setInt(14, vitalSign.getBPDIAS1());
                pstmt.setString(15, vitalSign.getBP1Position());
                pstmt.setString(16, vitalSign.getBP1Location());
                pstmt.setInt(17, vitalSign.getBPSYS2());
                pstmt.setInt(18, vitalSign.getBPDIAS2());
                pstmt.setString(19, vitalSign.getBP2Position());
                pstmt.setString(20, vitalSign.getBP2Location());
                pstmt.setInt(21, vitalSign.getBPSYS3());
                pstmt.setInt(22, vitalSign.getBPDIAS3());
                pstmt.setString(23, vitalSign.getBP3Position());
                pstmt.setString(24, vitalSign.getBP3Location());
                pstmt.setDouble(25, vitalSign.getTemperature());
                pstmt.setString(26, vitalSign.getTemperature_unit());
                pstmt.setByte(27, vitalSign.getDeleted());
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

    public boolean update(List<VitalSign> vitalSigns) {
        boolean success = false;
        String sql = "update vitalsigns set EncounterID=?,PatientID=?,PETime=?,Ht=?,`Ht Unit of Measurement`=?,"
                + "Wt=?,`Wt Unit of Measurement`=?,HR=?,RR=?,HeadCircumference=?,`Head Unit of Measurement`=?,BodyMassIndex=?,BPSYS1=?,BPDIAS1=?,"
                + " BP1Position=?,BP1Location=?,BPSYS2=?,BPDIAS2=?,BP2Position=?,BP2Location=?,BPSYS3=?,BPDIAS3=?,BP3Position=?,BP3Location=?,"
                + "Temperature=?,`Temperature unit`=?,deleted=? where EncounterID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (VitalSign vitalSign : vitalSigns) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, vitalSign.getEncounterID());
                pstmt.setInt(2, vitalSign.getPatientID());
                pstmt.setString(3, vitalSign.getPETime());
                pstmt.setDouble(4, vitalSign.getHt());
                pstmt.setString(5, vitalSign.getHt_Unit_of_Measurement());
                pstmt.setDouble(6, vitalSign.getWt());
                pstmt.setString(7, vitalSign.getWt_Unit_of_Measurement());
                pstmt.setInt(8, vitalSign.getHR());
                pstmt.setInt(9, vitalSign.getRR());
                pstmt.setDouble(10, vitalSign.getHeadCircumference());
                pstmt.setString(11, vitalSign.getHead_Unit_of_Measurement());
                pstmt.setDouble(12, vitalSign.getBodyMassIndex());
                pstmt.setInt(13, vitalSign.getBPSYS1());
                pstmt.setInt(14, vitalSign.getBPDIAS1());
                pstmt.setString(15, vitalSign.getBP1Position());
                pstmt.setString(16, vitalSign.getBP1Location());
                pstmt.setInt(17, vitalSign.getBPSYS2());
                pstmt.setInt(18, vitalSign.getBPDIAS2());
                pstmt.setString(19, vitalSign.getBP2Position());
                pstmt.setString(20, vitalSign.getBP2Location());
                System.out.println("---" + vitalSign.getBP2Location());
                pstmt.setInt(21, vitalSign.getBPSYS3());
                pstmt.setInt(22, vitalSign.getBPDIAS3());
                pstmt.setString(23, vitalSign.getBP3Position());
                pstmt.setString(24, vitalSign.getBP3Location());
                pstmt.setDouble(25, vitalSign.getTemperature());
                pstmt.setString(26, vitalSign.getTemperature_unit());
                pstmt.setByte(27, vitalSign.getDeleted());
                pstmt.setInt(28, vitalSign.getEncounterID());
                System.out.println("---" + pstmt.toString());
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

    /**
     * get the column names of illness history table
     *
     * @return column names
     */
    public DefaultTableModel getTableModel() {
        try {
            int tempPatientID = Integer.valueOf(patient_ID);
            conn = JDBCMySQLConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM vitalsigns where deleted=0 and PatientID=? order by PatientID;");
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
        int EncounterID = -1;
        try {
            conn = JDBCMySQLConnection.getConnection();
            /* auto increase illness id */
            pstmt = conn.prepareStatement("select max(EncounterID) from vitalsigns");
            rst = pstmt.executeQuery();
            rst.next();
            EncounterID = rst.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return EncounterID;
    }
}
