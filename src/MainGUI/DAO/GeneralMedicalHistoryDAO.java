package MainGUI.DAO;

import MainGUI.Classes.GeneralMedicalHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fan Hu
 */
public class GeneralMedicalHistoryDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rst;

    public boolean add(GeneralMedicalHistory generalMedicalHist) {
        boolean success = false;
        String sql = "INSERT INTO generalmedicalhistorytable (MaritalStatus, "
                + "Education, GrowthAndDevelopment, Pregnancies, BehavioralHistory,"
                + " Tobacco, TobaccoQuantity, Tobaccoduraton, Alcohol, "
                + "AlcoholQuantity, Alcoholduration, Drug, DrugType, "
                + "Drugduration, Dietary, Travel, BloodType, Rh,"
                + " MedicalHistoryNotes, HxObtainedBy, UnableToObtainHxReason,"
                + " LMPStatus, EDC, LMPEstMethod, MensesFreq, HospitalOfDelivery, "
                + "EGA, PatientID, NumberOfChildren, NumberOfPregnancies, "
                + "MenarcheAgeOfOnset, TobaccoHRF, AlcoholHRF, DrugHRF, DietHRF,"
                + " TravelHRF, HxConfirmedByHCP, deleted, LMP, Pregnant,"
                + " LMPDateApprox, MenstrualAmtNormalYes, MenstrualAmtNormalNo,"
                + " MensesMonthlyYes, MensesMonthlyNo, OnBCPAtConceptionYes, "
                + "OnBCPAtConceptionNo, LMPDate, PregnancyDueDate, "
                + "MensesPriorDate, GeneralMedicalHistoryID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = JDBCMySQLConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, generalMedicalHist.getMaritalStatus());
            ps.setString(2, generalMedicalHist.getEducation());
            ps.setString(3, generalMedicalHist.getGrowthAndDevelopment());
            ps.setString(4, generalMedicalHist.getPregnancies());
            ps.setString(5, generalMedicalHist.getBehavioralHistory());
            ps.setString(6, generalMedicalHist.getTobacco());
            ps.setString(7, generalMedicalHist.getTobaccoQuantity());
            ps.setString(8, generalMedicalHist.getTobaccoduraton());
            ps.setString(9, generalMedicalHist.getAlcohol());
            ps.setString(10, generalMedicalHist.getAlcoholQuantity());
            ps.setString(11, generalMedicalHist.getAlcoholduration());
            ps.setString(12, generalMedicalHist.getDrug());
            ps.setString(13, generalMedicalHist.getDrugType());
            ps.setString(14, generalMedicalHist.getDrugduration());
            ps.setString(15, generalMedicalHist.getDietary());
            ps.setString(16, generalMedicalHist.getTravel());
            ps.setString(17, generalMedicalHist.getBloodType());
            ps.setString(18, generalMedicalHist.getRh());
            ps.setString(19, generalMedicalHist.getMedicalHistoryNotes());
            ps.setString(20, generalMedicalHist.getHxObtainedBy());
            ps.setString(21, generalMedicalHist.getUnableToObtainHxReason());
            ps.setString(22, generalMedicalHist.getLMPStatus());
            ps.setDate(23, generalMedicalHist.getEDC());
            ps.setString(24, generalMedicalHist.getLMPEstMethod());
            ps.setString(25, generalMedicalHist.getMensesFreq());
            ps.setString(26, generalMedicalHist.getHospitalOfDelivery());
            ps.setString(27, generalMedicalHist.getEGA());
            ps.setInt(28, generalMedicalHist.getPatientID());
            ps.setInt(29, generalMedicalHist.getNumberOfChildren());
            ps.setInt(30, generalMedicalHist.getNumberOfPregnancies());
            ps.setInt(31, generalMedicalHist.getMenarcheAgeOfOnset());
            ps.setByte(32, generalMedicalHist.getTobaccoHRF());
            ps.setByte(33, generalMedicalHist.getAlcoholHRF());
            ps.setByte(34, generalMedicalHist.getDrugHRF());
            ps.setByte(35, generalMedicalHist.getDietHRF());
            ps.setByte(36, generalMedicalHist.getTravelHRF());
            ps.setByte(37, generalMedicalHist.getHxConfirmedByHCP());
            ps.setByte(38, generalMedicalHist.getDeleted());
            ps.setByte(39, generalMedicalHist.getLMP());
            ps.setByte(40, generalMedicalHist.getPregnant());
            ps.setByte(41, generalMedicalHist.getLMPDateApprox());
            ps.setByte(42, generalMedicalHist.getMenstrualAmtNormalYes());
            ps.setByte(43, generalMedicalHist.getMenstrualAmtNormalNo());
            ps.setByte(44, generalMedicalHist.getMensesMonthlyYes());
            ps.setByte(45, generalMedicalHist.getMensesMonthlyNo());
            ps.setByte(46, generalMedicalHist.getOnBCPAtConceptionYes());
            ps.setByte(47, generalMedicalHist.getOnBCPAtConceptionNo());
            ps.setDate(48, generalMedicalHist.getLMPDate());
            ps.setDate(49, generalMedicalHist.getPregnancyDueDate());
            ps.setDate(50, generalMedicalHist.getMensesPriorDate());
            ps.setInt(51, generalMedicalHist.getGeneralMedicalHistoryID());
            System.out.println("===============\n" + ps);
            ps.execute();

            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, ps, conn);
        }
        return success;
    }

    public boolean update(GeneralMedicalHistory generalMedicalHist) {
        boolean success = false;
        String sql = "UPDATE generalmedicalhistorytable SET "
                + " MaritalStatus = ?, "
                + " Education = ?, "
                + " GrowthAndDevelopment = ?, "
                + " Pregnancies = ?, "
                + " BehavioralHistory = ?, "
                + " Tobacco = ?, "
                + " TobaccoQuantity = ?, "
                + " Tobaccoduraton = ?, "
                + " Alcohol = ?, "
                + " AlcoholQuantity = ?, "
                + " Alcoholduration = ?, "
                + " Drug = ?, "
                + " DrugType = ?, "
                + " Drugduration = ?, "
                + " Dietary = ?, "
                + " Travel = ?, "
                + " BloodType = ?, "
                + " Rh = ?, "
                + " MedicalHistoryNotes = ?, "
                + " HxObtainedBy = ?, "
                + " UnableToObtainHxReason = ?, "
                + " LMPStatus = ?, "
                + " EDC = ?, "
                + " LMPEstMethod = ?, "
                + " MensesFreq = ?, "
                + " HospitalOfDelivery = ?, "
                + " EGA = ?, "
                + " PatientID = ?, "
                + " NumberOfChildren = ?, "
                + " NumberOfPregnancies = ?, "
                + " MenarcheAgeOfOnset = ?, "
                + " TobaccoHRF = ?, "
                + " AlcoholHRF = ?, "
                + " DrugHRF = ?, "
                + " DietHRF = ?, "
                + " TravelHRF = ?, "
                + " HxConfirmedByHCP = ?, "
                + " deleted = ?, "
                + " LMP = ?, "
                + " Pregnant = ?, "
                + " LMPDateApprox = ?, "
                + " MenstrualAmtNormalYes = ?, "
                + " MenstrualAmtNormalNo = ?, "
                + " MensesMonthlyYes = ?, "
                + " MensesMonthlyNo = ?, "
                + " OnBCPAtConceptionYes = ?, "
                + " OnBCPAtConceptionNo = ?, "
                + " LMPDate = ?, "
                + " PregnancyDueDate = ?, "
                + " MensesPriorDate = ? "
                + "WHERE GeneralMedicalHistoryID = ?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, generalMedicalHist.getMaritalStatus());
            ps.setString(2, generalMedicalHist.getEducation());
            ps.setString(3, generalMedicalHist.getGrowthAndDevelopment());
            ps.setString(4, generalMedicalHist.getPregnancies());
            ps.setString(5, generalMedicalHist.getBehavioralHistory());
            ps.setString(6, generalMedicalHist.getTobacco());
            ps.setString(7, generalMedicalHist.getTobaccoQuantity());
            ps.setString(8, generalMedicalHist.getTobaccoduraton());
            ps.setString(9, generalMedicalHist.getAlcohol());
            ps.setString(10, generalMedicalHist.getAlcoholQuantity());
            ps.setString(11, generalMedicalHist.getAlcoholduration());
            ps.setString(12, generalMedicalHist.getDrug());
            ps.setString(13, generalMedicalHist.getDrugType());
            ps.setString(14, generalMedicalHist.getDrugduration());
            ps.setString(15, generalMedicalHist.getDietary());
            ps.setString(16, generalMedicalHist.getTravel());
            ps.setString(17, generalMedicalHist.getBloodType());
            ps.setString(18, generalMedicalHist.getRh());
            ps.setString(19, generalMedicalHist.getMedicalHistoryNotes());
            ps.setString(20, generalMedicalHist.getHxObtainedBy());
            ps.setString(21, generalMedicalHist.getUnableToObtainHxReason());
            ps.setString(22, generalMedicalHist.getLMPStatus());
            ps.setDate(23, generalMedicalHist.getEDC());
            ps.setString(24, generalMedicalHist.getLMPEstMethod());
            ps.setString(25, generalMedicalHist.getMensesFreq());
            ps.setString(26, generalMedicalHist.getHospitalOfDelivery());
            ps.setString(27, generalMedicalHist.getEGA());
            ps.setInt(28, generalMedicalHist.getPatientID());
            ps.setInt(29, generalMedicalHist.getNumberOfChildren());
            ps.setInt(30, generalMedicalHist.getNumberOfPregnancies());
            ps.setInt(31, generalMedicalHist.getMenarcheAgeOfOnset());
            ps.setByte(32, generalMedicalHist.getTobaccoHRF());
            ps.setByte(33, generalMedicalHist.getAlcoholHRF());
            ps.setByte(34, generalMedicalHist.getDrugHRF());
            ps.setByte(35, generalMedicalHist.getDietHRF());
            ps.setByte(36, generalMedicalHist.getTravelHRF());
            ps.setByte(37, generalMedicalHist.getHxConfirmedByHCP());
            ps.setByte(38, generalMedicalHist.getDeleted());
            ps.setByte(39, generalMedicalHist.getLMP());
            ps.setByte(40, generalMedicalHist.getPregnant());
            ps.setByte(41, generalMedicalHist.getLMPDateApprox());
            ps.setByte(42, generalMedicalHist.getMenstrualAmtNormalYes());
            ps.setByte(43, generalMedicalHist.getMenstrualAmtNormalNo());
            ps.setByte(44, generalMedicalHist.getMensesMonthlyYes());
            ps.setByte(45, generalMedicalHist.getMensesMonthlyNo());
            ps.setByte(46, generalMedicalHist.getOnBCPAtConceptionYes());
            ps.setByte(47, generalMedicalHist.getOnBCPAtConceptionNo());
            ps.setDate(48, generalMedicalHist.getLMPDate());
            ps.setDate(49, generalMedicalHist.getPregnancyDueDate());
            ps.setDate(50, generalMedicalHist.getMensesPriorDate());
            ps.setInt(51, generalMedicalHist.getGeneralMedicalHistoryID());
            System.out.println("===============\n" + ps);
            ps.execute();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, ps, conn);
        }
        return success;
    }

    public boolean delete(GeneralMedicalHistory generalMedicalHist) {
        boolean success = false;
        String sql = "UPDATE generalmedicalhistorytable SET deleted=1 where GeneralMedicalHistoryID=?";
        try {
            conn = JDBCMySQLConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, generalMedicalHist.getGeneralMedicalHistoryID());
            ps.execute();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMySQLConnection.closeAll(rst, ps, conn);
        }

        return success;
    }

}
