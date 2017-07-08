package MainGUI.DAO;

import MainGUI.Classes.OccupationalHistory;

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
 * @date 06/24/17
 */
public class OccupationalHistoryDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<OccupationalHistory> occupationalHistories) {
        boolean success = false;
        String sql = "insert into occupationalhistorytable values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (OccupationalHistory occupationalHistory : occupationalHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, occupationalHistory.getOccupationalID());
                pstmt.setInt(2, occupationalHistory.getPatientID());
                pstmt.setDate(3, occupationalHistory.getStartDate());
                pstmt.setDate(4, occupationalHistory.getEndDate());
                pstmt.setString(5, occupationalHistory.getDescription());
                pstmt.setByte(6, occupationalHistory.getCurrent());
                pstmt.setByte(7, occupationalHistory.getDisability());
                pstmt.setString(8, occupationalHistory.getCauseofdisability());
                pstmt.setByte(9, occupationalHistory.getOccupationalHRF());
                pstmt.setDate(10, occupationalHistory.getLastWorkDate());
                pstmt.setByte(11, occupationalHistory.getDeleted());
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

    public boolean update(List<OccupationalHistory> occupationalHistories) {
        boolean success = false;
        String sql = "update occupationalhistorytable set OccupationalID=?,PatientID=?,StartDate=?,EndDate=?,Description=?,"
                + "Current=?,Disability=?,Causeofdisability=?,OccupationalHRF=?,LastWorkDate=?,deleted=? where OccupationalID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (OccupationalHistory occupationalHistory : occupationalHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, occupationalHistory.getOccupationalID());
                pstmt.setInt(2, occupationalHistory.getPatientID());
                pstmt.setDate(3, occupationalHistory.getStartDate());
                pstmt.setDate(4, occupationalHistory.getEndDate());
                pstmt.setString(5, occupationalHistory.getDescription());
                pstmt.setByte(6, occupationalHistory.getCurrent());
                pstmt.setByte(7, occupationalHistory.getDisability());
                pstmt.setString(8, occupationalHistory.getCauseofdisability());
                pstmt.setByte(9, occupationalHistory.getOccupationalHRF());
                pstmt.setDate(10, occupationalHistory.getLastWorkDate());
                pstmt.setByte(11, occupationalHistory.getDeleted());
                pstmt.setInt(12, occupationalHistory.getOccupationalID());
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
            pstmt = conn.prepareStatement("SELECT * FROM occupationalhistorytable where deleted=0 and PatientID=? order by StartDate;");
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
                    } else if (column < 2 || column == 5 || column == 6 || column == 8) {
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
        int OccupationalID = -1;
        try {
            conn = JDBCMySQLConnection.getConnection();
            /* auto increase illness id */
            pstmt = conn.prepareStatement("select max(OccupationalID) from occupationalhistorytable");
            rst = pstmt.executeQuery();
            rst.next();
            OccupationalID = rst.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
        }
        return OccupationalID;
    }
}
