package MainGUI.DAO;

import MainGUI.Classes.ImmunizationsHistory;

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
 * Done!
 *
 * @author Fan Hu, Zhiwei Chu
 */
public class ImmunizationHistoryDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<ImmunizationsHistory> immunizationHistories) {
        boolean success = false;
        String sql = "insert into immunizationshistorytable values (?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (ImmunizationsHistory immunizationHistory : immunizationHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, immunizationHistory.getImmunizationsID());
                pstmt.setInt(2, immunizationHistory.getPatientID());
                pstmt.setString(3, immunizationHistory.getVaccine());
                pstmt.setDate(4, immunizationHistory.getImmunizationDate());
                pstmt.setDate(5, immunizationHistory.getExperationDate());
                pstmt.setString(6, immunizationHistory.getDelivery());
                pstmt.setString(7, immunizationHistory.getComments());
                pstmt.setInt(8, immunizationHistory.getHCPId());
                pstmt.setByte(9, immunizationHistory.getDeleted());
                pstmt.executeUpdate();
            }
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return success;
    }

    public boolean update(List<ImmunizationsHistory> immunizationHistories) {
        boolean success = false;
        String sql = "update immunizationshistorytable set ImmunizationsID=?,PatientID=?,Vaccine=?,ImmunizationDate=?,ExperationDate=?,Delivery=?,Comments=?,HCPId=?,deleted=? where ImmunizationsID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (ImmunizationsHistory immunizationHistory : immunizationHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, immunizationHistory.getImmunizationsID());
                pstmt.setInt(2, immunizationHistory.getPatientID());
                pstmt.setString(3, immunizationHistory.getVaccine());
                pstmt.setDate(4, immunizationHistory.getImmunizationDate());
                pstmt.setDate(5, immunizationHistory.getExperationDate());
                pstmt.setString(6, immunizationHistory.getDelivery());
                pstmt.setString(7, immunizationHistory.getComments());
                pstmt.setInt(8, immunizationHistory.getHCPId());
                pstmt.setByte(9, immunizationHistory.getDeleted());
                pstmt.setInt(10, immunizationHistory.getImmunizationsID());
                pstmt.executeUpdate();
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
            int tempPatientID = Integer.valueOf(patient_ID);
            conn = JDBCMySQLConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM immunizationshistorytable where deleted=0 and PatientID=? order by ImmunizationDate DESC;");
//            pstmt = conn.prepareStatement("SELECT * FROM immunizationshistorytable where deleted=0 order by ImmunizationsID;");
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
                    if (getRowCount() <= 1) {
                        return Object.class;
                    } else if (column < 2) {
                        return getValueAt(0, column).getClass();
                    } else {
                        return Object.class;
                    }
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
        int illnessID = -1;
        try {
            conn = JDBCMySQLConnection.getConnection();
            pstmt = conn.prepareStatement("select max(ImmunizationsID) from immunizationshistorytable");
            rst = pstmt.executeQuery();
            rst.next();
            illnessID = rst.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return illnessID;
    }
}
