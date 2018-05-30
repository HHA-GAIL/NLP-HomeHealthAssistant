using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data;
using MySql.Data.MySqlClient;
using NLPDotNetLib.Entity;

namespace NLPDotNetLib.DAO
{
    public class DTRulesDAO:BaseDAO
    {
        private static DTRulesDAO dtDAO = null;

        public static DTRulesDAO DTDAO
        {
            get
            {
                if (dtDAO == null)
                    dtDAO = new DTRulesDAO();
                return dtDAO;
            }
        }

        public void TestConnect()
        {
            MySqlConnection conn = new MySqlConnection(connString);
            try
            {
                conn.Open();
                conn.Close();
            }
            catch(Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
            }
        }


        public Dictionary<String, String> GetAllTriggers()
        {
            MySqlConnection conn = new MySqlConnection(connString);
            Dictionary<String, String> dict = new Dictionary<string, string>();
            String sql = "Select RuleName, TriggerAttributes from DTRules;";
            try
            {
                conn.Open();
                MySqlCommand command = conn.CreateCommand();
                command.CommandText = sql;
                MySqlDataAdapter adapter = new MySqlDataAdapter(command);
                DataSet dataSet = new DataSet();
                adapter.Fill(dataSet);
                DataTable dt = dataSet.Tables[0];
                foreach(DataRow dr in dt.Rows)
                {
                    dict.Add((String)dr["RuleName"], (String)dr["TriggerAttributes"]);
                }
                conn.Close();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
            }
            return dict;
        }

        /// <summary>
        /// used to Get DTRules by input RuleName
        /// </summary>
        /// <param name="ruleName"></param>
        /// <returns>a DTRules entity or null</returns>
        public DTRulesEntity GetDTRulesByRuleName(string ruleName)
        {
            DTRulesEntity dTRules = null;
            MySqlConnection conn = new MySqlConnection(connString);
            String sql = "Select * from DTRules where RuleName = '" + ruleName + "';";
            try
            {
                conn.Open();
                MySqlCommand command = conn.CreateCommand();
                command.CommandText = sql;
                MySqlDataAdapter adapter = new MySqlDataAdapter(command);
                DataSet dataSet = new DataSet();
                adapter.Fill(dataSet);
                DataTable dt = dataSet.Tables[0];
                if(dt.Rows.Count != 0)
                {
                    dTRules = new DTRulesEntity();
                    dTRules.DTID = (int)dt.Rows[0]["DTID"];
                    dTRules.DTXMLContent = (string)dt.Rows[0]["DTXMLContent"];
                    dTRules.EntryTable = (string)dt.Rows[0]["EntryTable"];
                    dTRules.RuleName = (string)dt.Rows[0]["RuleName"];
                    dTRules.TriggerAttributes = (string)dt.Rows[0]["TriggerAttributes"];
                }
                conn.Close();
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e.Message);
            }
            return dTRules;
        }
    }
}
