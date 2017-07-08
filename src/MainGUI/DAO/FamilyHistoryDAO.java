package MainGUI.DAO;

import MainGUI.Classes.FamilyHistory;

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
public class FamilyHistoryDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rst;

    public boolean add(List<FamilyHistory> familyHistories) {
        boolean success = false;
        String sql = "insert into familyhistorytable values (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (FamilyHistory familyHistory : familyHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, familyHistory.getFamilyID());
                pstmt.setInt(2, familyHistory.getPatientID());
                pstmt.setString(3, familyHistory.getName());
                pstmt.setString(4, familyHistory.getRelation());
                pstmt.setByte(5, familyHistory.getAlive());
                pstmt.setByte(6, familyHistory.getLivesWithPatient());
                pstmt.setString(7, familyHistory.getMajorDisorder());
                pstmt.setString(8, familyHistory.getSpecificTypeDisorder());
                pstmt.setByte(9, familyHistory.getDisorderHRF());
                pstmt.setByte(10, familyHistory.getDeleted());
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

    public boolean update(List<FamilyHistory> familyHistories) {
        boolean success = false;
        String sql = "update familyhistorytable set familyID=?,PatientID=?,Name=?,Relation=?,Alive=?,`Lives with patient`=?,MajorDisorder=?,SpecificTypeDisorder=?,DisorderHRF=?,deleted=? where FamilyID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            for (FamilyHistory familyHistory : familyHistories) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, familyHistory.getFamilyID());
                pstmt.setInt(2, familyHistory.getPatientID());
                pstmt.setString(3, familyHistory.getName());
                pstmt.setString(4, familyHistory.getRelation());
                pstmt.setByte(5, familyHistory.getAlive());
                pstmt.setByte(6, familyHistory.getLivesWithPatient());
                pstmt.setString(7, familyHistory.getMajorDisorder());
                pstmt.setString(8, familyHistory.getSpecificTypeDisorder());
                pstmt.setByte(9, familyHistory.getDisorderHRF());
                pstmt.setByte(10, familyHistory.getDeleted());
                pstmt.setInt(11, familyHistory.getFamilyID());
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
            pstmt = conn.prepareStatement("SELECT * FROM familyhistorytable where deleted=0 and PatientID=? order by FamilyID;");
//            pstmt = conn.prepareStatement("SELECT * FROM familyhistorytable where deleted=0 order by FamilyID;");
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
                    } else if (column < 2 || column == 4 || column == 5 || column == 8) {
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
            /* auto increase illness id */
            pstmt = conn.prepareStatement("select max(FamilyID) from familyhistorytable");
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
