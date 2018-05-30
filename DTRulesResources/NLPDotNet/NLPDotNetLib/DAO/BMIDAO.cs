using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using java.util;
using MySql.Data;
using MySql.Data.MySqlClient;

namespace NLPDotNetLib.DAO
{
    public class BMIDAO:BaseDAO
    {
        private static BMIDAO bmiDao = null;

        public static BMIDAO BMI_DAO
        {
            get
            {
                if (bmiDao == null)
                    bmiDao = new BMIDAO();
                return bmiDao;
            }
        }

        /// <summary>
        /// to get a BMI_Devs by PatientID
        /// </summary>
        /// <param name="PatientID"></param>
        /// <returns>List of data</returns>
        public List<edu.dhu.DTRules.entities.BMI_Dev> GetBMIByPatientID(String PatientID)
        {
            MySqlConnection conn = new MySqlConnection(connString);
            List<edu.dhu.DTRules.entities.BMI_Dev> result = new List<edu.dhu.DTRules.entities.BMI_Dev>();
            String sql = "Select * from BMI_Dev where PatientID_FK = "+PatientID+ " order by DateTime desc limit 0, 200;";
            try
            {
                conn.Open();
                MySqlCommand command = conn.CreateCommand();
                command.CommandText = sql;
                MySqlDataAdapter adapter = new MySqlDataAdapter(command);
                DataSet dataSet = new DataSet();
                adapter.Fill(dataSet);
                DataTable dt = dataSet.Tables[0];
                foreach (DataRow dr in dt.Rows)
                {
                    edu.dhu.DTRules.entities.BMI_Dev tmp = new edu.dhu.DTRules.entities.BMI_Dev();
                    tmp.setBMIID(new java.lang.Integer((int)dr["BMIID"]));
                    tmp.setBMI(new java.lang.Double((double)dr["BMI"]));
                    tmp.setPatientID_FK(new java.lang.Integer((int)dr["PatientID_FK"]));
                    tmp.setDevID_FK(new java.lang.Integer((int)dr["DevID_FK"]));
                    tmp.setDateTime(GetJavaDate((DateTime)dr["DateTime"]));
                    tmp.setPatientID_FK(new java.lang.Integer(Int32.Parse(PatientID)));
                    result.Add(tmp);
                }
                conn.Close();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
            }
            return result;
        }

    }
}
