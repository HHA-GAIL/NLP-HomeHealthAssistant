using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NLPDotNetLib.DAO
{
    public class SleepDAO:BaseDAO
    {
        private static SleepDAO SleepDao = null;

        public static SleepDAO Sleep_DAO
        {
            get
            {
                if (SleepDao == null)
                    SleepDao = new SleepDAO();
                return SleepDao;
            }
        }

        /// <summary>
        /// to get a Sleep_Devs by PatientID
        /// </summary>
        /// <param name="PatientID"></param>
        /// <returns>List of data</returns>
        public List<edu.dhu.DTRules.entities.Sleep_Dev> GetSleepByPatientID(String PatientID)
        {
            MySqlConnection conn = new MySqlConnection(connString);
            List<edu.dhu.DTRules.entities.Sleep_Dev> result = new List<edu.dhu.DTRules.entities.Sleep_Dev>();
            String sql = "Select * from Sleep_Dev where PatientID_FK = " + PatientID + " order by DateTime desc limit 0, 200;";
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
                    edu.dhu.DTRules.entities.Sleep_Dev tmp = new edu.dhu.DTRules.entities.Sleep_Dev();
                    tmp.setSleepID(new java.lang.Integer((int)dr["SleepID"]));
                    tmp.setSleepResults((string)dr["SleepResults"]);
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
