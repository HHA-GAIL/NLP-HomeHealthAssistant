using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NLPDotNetLib.DAO
{
    public class FloorsDAO : BaseDAO
    {
        private static FloorsDAO FloorsDao = null;

        public static FloorsDAO Floors_DAO
        {
            get
            {
                if (FloorsDao == null)
                    FloorsDao = new FloorsDAO();
                return FloorsDao;
            }
        }

        /// <summary>
        /// to get a Floors_Devs by PatientID
        /// </summary>
        /// <param name="PatientID"></param>
        /// <returns>List of data</returns>
        public List<edu.dhu.DTRules.entities.Floors_Dev> GetFloorsByPatientID(String PatientID)
        {
            MySqlConnection conn = new MySqlConnection(connString);
            List<edu.dhu.DTRules.entities.Floors_Dev> result = new List<edu.dhu.DTRules.entities.Floors_Dev>();
            String sql = "Select * from Floors_Dev where PatientID_FK = " + PatientID + " order by DateTime desc limit 0, 200;";
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
                    edu.dhu.DTRules.entities.Floors_Dev tmp = new edu.dhu.DTRules.entities.Floors_Dev();
                    tmp.setFloorsID(new java.lang.Integer((int)dr["FloorsID"]));
                    tmp.setFloors(new java.lang.Integer((int)dr["Floors"]));
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
