package MainGUI.DAO;

import MainGUI.Classes.IllnessHistory;

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
 * Done! The original copy of DAO methods
 *
 * @author Zhiwei Chu
 * @date 06/24/17
 */
public class IllnessHistoryDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<IllnessHistory> illnesshistories) {
        boolean success = false;
        String sql = "insert into illnesshistorytable values (?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (IllnessHistory illnesshistory : illnesshistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, illnesshistory.getIllnessID());
                pstmt.setInt(2, illnesshistory.getPatientID());
                pstmt.setDate(3, illnesshistory.getIllnessDate());
                pstmt.setString(4, illnesshistory.getIllness());
                pstmt.setString(5, illnesshistory.getResolution());
                pstmt.setByte(6, illnesshistory.getIllnessHRF());
                pstmt.setByte(7, illnesshistory.getDeleted());
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

//    public boolean delete(IllnessHistory illnesshistory) {
//        boolean success = false;
//        String sql = "delete from illnesshistorytable where illnessid=?";
//        try {
//            conn = JDBCMySQLConnection.getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, illnesshistory.getIllnessID());
//            pstmt.executeUpdate();
//            success = true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
//        }
//        return success;
//    }
    public boolean update(List<IllnessHistory> illnesshistories) {
        boolean success = false;
        String sql = "update illnesshistorytable set illnessid=?,patientid=?,illnessdate=?,illness=?,resolution=?,illnesshrf=?,deleted=? where illnessid=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (IllnessHistory illnesshistory : illnesshistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, illnesshistory.getIllnessID());
                pstmt.setInt(2, illnesshistory.getPatientID());
                pstmt.setDate(3, illnesshistory.getIllnessDate());
                pstmt.setString(4, illnesshistory.getIllness());
                pstmt.setString(5, illnesshistory.getResolution());
                pstmt.setByte(6, illnesshistory.getIllnessHRF());
                pstmt.setByte(7, illnesshistory.getDeleted());
                pstmt.setInt(8, illnesshistory.getIllnessID());
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

//    public List<IllnessHistory> getAllIllnessHistory() {
//        List<IllnessHistory> illnesshistories = new ArrayList<>();
//        String sql = "SELECT * FROM illnesshistorytable;";
//        try {
//            conn = JDBCMySQLConnection.getConnection();
//            pstmt = conn.prepareStatement(sql);
//            rst = pstmt.executeQuery();
//            while (rst.next()) {
//                IllnessHistory illnesshistory = new IllnessHistory();
//                illnesshistory.setIllnessID(rst.getInt(1));
//                illnesshistory.setPatientID(rst.getInt(2));
//                illnesshistory.setIllnessDate(rst.getDate(3));
//                illnesshistory.setIllness(rst.getString(4));
//                illnesshistory.setResolution(rst.getString(5));
//                illnesshistory.setIllnessHRF(rst.getByte(6));
//                illnesshistory.setDeleted(rst.getByte(7));
//                illnesshistories.add(illnesshistory);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBCMySQLConnection.closeAll(rst, pstmt, conn);
//        }
//        return illnesshistories;
//    }
    public DefaultTableModel getTableModel() {
        try {
            int tempPatientID = Integer.parseInt(patient_ID);
            conn = JDBCMySQLConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM illnesshistorytable where deleted=0 and PatientID = ? order by IllnessId;");
//            pstmt = conn.prepareStatement("SELECT * FROM illnesshistorytable where deleted=0 order by IllnessId;");
            pstmt.setInt(1, tempPatientID);
            rst = pstmt.executeQuery();
            ResultSetMetaData metaData = rst.getMetaData();
            int count = metaData.getColumnCount(); //number of column
            Vector<String> columnNames = new Vector<>();

            /* using i = 1 and count - 1 can avoid showing "deleted" attribute */
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
                    } else if (column < 2 || column == 5) {
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
            /* auto increase illness id */
            pstmt = conn.prepareStatement("select max(IllnessID) from illnesshistorytable");
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
