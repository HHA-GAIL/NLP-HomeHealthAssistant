using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NLPDotNetLib.DAO
{
    public class WeightDAO : BaseDAO
    {
        private static WeightDAO WeightDao = null;

        public static WeightDAO Weight_DAO
        {
            get
            {
                if (WeightDao == null)
                    WeightDao = new WeightDAO();
                return WeightDao;
            }
        }

        /// <summary>
        /// to get a Weight_Devs by PatientID
        /// </summary>
        /// <param name="PatientID"></param>
        /// <returns>List of data</returns>
        public List<edu.dhu.DTRules.entities.Weight_Dev> GetWeightByPatientID(String PatientID)
        {
            MySqlConnection conn = new MySqlConnection(connString);
            List<edu.dhu.DTRules.entities.Weight_Dev> result = new List<edu.dhu.DTRules.entities.Weight_Dev>();
            String sql = "Select * from Weight_Dev where PatientID_FK = " + PatientID + " order by DateTime desc limit 0, 200;";
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
                    edu.dhu.DTRules.entities.Weight_Dev tmp = new edu.dhu.DTRules.entities.Weight_Dev();
                    tmp.setWeightID(new java.lang.Integer((int)dr["WeightID"]));
                    tmp.setWeight(new java.lang.Double((double)dr["Weight"]));
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
