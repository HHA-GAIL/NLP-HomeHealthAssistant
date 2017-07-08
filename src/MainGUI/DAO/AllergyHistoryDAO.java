package MainGUI.DAO;

import MainGUI.Classes.AllergyHistory;

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
 * @author Zhiwei Chu
 * @date 06/24/17
 */
public class AllergyHistoryDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<AllergyHistory> allergyHistories) {
        boolean success = false;
        String sql = "insert into allergyhistorytable values (?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (AllergyHistory allergyHistory : allergyHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, allergyHistory.getAllergyID());
                pstmt.setInt(2, allergyHistory.getPatientID());
                pstmt.setString(3, allergyHistory.getAllergen());
                pstmt.setString(4, allergyHistory.getAllergyStartDate());
                pstmt.setString(5, allergyHistory.getAllergyEndDate());
                pstmt.setString(6, allergyHistory.getAllergyDescription());
                pstmt.setByte(7, allergyHistory.getAllergyHRF());
                pstmt.setByte(8, allergyHistory.getDeleted());
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

    public boolean update(List<AllergyHistory> allergyHistories) {
        boolean success = false;
        String sql = "update allergyhistorytable set AllergyID=?,PatientID=?,Allergen=?,AllergyStartDate=?,AllergyEndDate=?,AllergyDescription=?,AllergyHRF=?,deleted=? where AllergyID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (AllergyHistory allergyHistory : allergyHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, allergyHistory.getAllergyID());
                pstmt.setInt(2, allergyHistory.getPatientID());
                pstmt.setString(3, allergyHistory.getAllergen());
                pstmt.setString(4, allergyHistory.getAllergyStartDate());
                pstmt.setString(5, allergyHistory.getAllergyEndDate());
                pstmt.setString(6, allergyHistory.getAllergyDescription());
                pstmt.setByte(7, allergyHistory.getAllergyHRF());
                pstmt.setByte(8, allergyHistory.getDeleted());
                pstmt.setInt(9, allergyHistory.getAllergyID());
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
            pstmt = conn.prepareStatement("SELECT * FROM allergyhistorytable where deleted=0 and PatientID=? order by AllergyStartDate DESC;");
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
                    } else if (column < 2 || column == 6) {
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
        int allergyID = -1;
        try {
            conn = JDBCMySQLConnection.getConnection();
            pstmt = conn.prepareStatement("select max(AllergyID) from allergyhistorytable");
            rst = pstmt.executeQuery();
            rst.next();
            allergyID = rst.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return allergyID;
    }
}
