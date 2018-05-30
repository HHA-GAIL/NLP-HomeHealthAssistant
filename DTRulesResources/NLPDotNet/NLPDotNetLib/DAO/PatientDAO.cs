using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NLPDotNetLib.DAO
{
    public class PatientDAO:BaseDAO
    {
        private static PatientDAO PatientDao = null;

        public static PatientDAO Patient_DAO
        {
            get
            {
                if (PatientDao == null)
                    PatientDao = new PatientDAO();
                return PatientDao;
            }
        }

        /// <summary>
        /// used to get a Patient by PatientID
        /// </summary>
        /// <param name="PatientID"></param>
        /// <returns></returns>
        public edu.dhu.DTRules.entities.Patient GetPatientByID(String PatientID)
        {
            edu.dhu.DTRules.entities.Patient patient = new edu.dhu.DTRules.entities.Patient();
            MySqlConnection conn = new MySqlConnection(connString);
            String sql = "Select * from Patients where PatientID = " + PatientID + ";";
            try
            {
                conn.Open();
                MySqlCommand command = conn.CreateCommand();
                command.CommandText = sql;
                MySqlDataAdapter adapter = new MySqlDataAdapter(command);
                DataSet dataSet = new DataSet();
                adapter.Fill(dataSet);
                DataTable dt = dataSet.Tables[0];
                if (dt.Rows.Count == 0)
                    patient = null;
                else
                {
                    DataRow dr = dt.Rows[0];
                    patient.setAge(new java.lang.Integer((int)dr["Age"]));
                    patient.setId((int)dr["PatientID"]);
                    patient.setFullName((string)dr["FullName"]);
                    patient.setGender((string)dr["Gender"]);
                    //patient.setMemberSince(new java.util.Date());
                }
                conn.Close();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
            }
            return patient;
        }

    }
}
