using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NLPDotNetLib.DAO;
using edu.dhu.DTRules.entities;
using edu.dhu.DTRules;
using com.dtrules.samples.sampleproject2;
using NLPDotNetLib.Entity;
using System.IO;

namespace NLPDotNetLib.NLP
{
    public class NLPBusiness
    {
        private static NLPBusiness business = null;
        private static String BMI_String = "BMI";
        private static String Sleep_String = "Sleep";
        private static String Steps_String = "Steps";
        private static String Floors_String = "Floors";
        private static String Weight_String = "Weight";
        private static String HR_String = "HR";
        private static String BasePath = Environment.CurrentDirectory;
        private edu.dhu.DTRules.entities.Patient patient = null;

        public static NLPBusiness Business {
            get {
                if (business == null)
                    business = new NLPBusiness();
                return business;
            }
        }

        public Patient Patient { get { return patient; } set { patient = value; } }

        /// <summary>
        /// used to get the rule names via trigger attributes
        /// </summary>
        /// <param name="BMI"></param>
        /// <param name="HR"></param>
        /// <param name="Sleep"></param>
        /// <param name="Steps"></param>
        /// <param name="Floors"></param>
        /// <param name="Weight"></param>
        /// <returns>a list of rule name</returns>
        public List<String> GetTriggeredRuleName(String BMI, String HR,
            String Sleep, String Steps, String Floors, String Weight)
        {
            List<String> result = new List<string>();
            List<String> has = new List<string>();
            if (BMI != null)
                has.Add(BMI_String);
            if (HR != null)
                has.Add(HR_String);
            if (Sleep != null)
                has.Add(Sleep_String);
            if (Steps != null)
                has.Add(Steps_String);
            if (Floors != null)
                has.Add(Floors_String);
            if (Weight != null)
                has.Add(Weight_String);
            DTRulesDAO DTDAO = DTRulesDAO.DTDAO;
            Dictionary<String, String> dict = DTDAO.GetAllTriggers();
            foreach(String key in dict.Keys)
            {
                String triggers = dict[key];
                Boolean none = false;
                foreach(String attri in has)
                {
                    if(!triggers.Contains(attri))
                    {
                        none = true;
                        break;
                    }
                }
                if (none)
                    break;
                else
                    result.Add(key);
            }
            return result;
        }

        /// <summary>
        /// to run the data with rule name and the past data of patient whose id is PatientID
        /// need all data to be inputed or will be wrong
        /// </summary>
        /// <param name="RuleName"></param>
        /// <returns>the result String</returns>
        public String RunWithNewData(String RuleName)
        {

            StringBuilder sb = new StringBuilder();
            //System.Diagnostics.Debug.WriteLine(BasePath);
            DTRulesPatientDev dtpd = new DTRulesPatientDev();
            //download the DTRules from database
            DTRulesEntity dTRules = DTRulesDAO.DTDAO.GetDTRulesByRuleName(RuleName);
            FileStream fs = new FileStream(BasePath + @"\DTRules\xml\TheDecisionTable_dt.xml", FileMode.OpenOrCreate, FileAccess.Write);
            StreamWriter sw = new StreamWriter(fs);
            sw.Write(dTRules.DTXMLContent);
            sw.Close();
            fs.Close();
            java.util.List results = dtpd.doExamine(Patient, BasePath + @"\DTRules", "DTRules.xml", "TheDecisionTable", dTRules.EntryTable);
            for(int i = 0; i < results.size(); i++)
            {
                edu.dhu.DTRules.entities.Result result = (edu.dhu.DTRules.entities.Result)results.get(i);
                sb.Append(result.getResultCode()).Append("--->").Append(result.getResultMessage()).Append("\n");
            }
            return sb.ToString();
        }

        /// <summary>
        /// used to reset data of patient with the data input
        /// the data will be recorded in  NLPBusiness entity
        /// </summary>
        /// <param name="PatientID"></param>
        /// <param name="BMI"></param>
        /// <param name="HR"></param>
        /// <param name="Sleep"></param>
        /// <param name="Steps"></param>
        /// <param name="Floors"></param>
        /// <param name="Weight"></param>
        public bool GetPatientDate(String PatientID, String BMI, String HR,
            String Sleep, String Steps, String Floors, String Weight)
        {
            this.Patient = PatientDAO.Patient_DAO.GetPatientByID(PatientID);
            if(this.Patient == null)
            {
                return false;
            }
            bool succ = false;
            try
            {
                //add the new data
                if (BMI != null)
                {
                    BMI_Dev tmp = new BMI_Dev();
                    tmp.setBMI(new java.lang.Double(Double.Parse(BMI)));
                    tmp.setDateTime(new java.util.Date());
                    tmp.setPatientID_FK(new java.lang.Integer(Int32.Parse(PatientID)));
                    tmp.setDevID_FK(new java.lang.Integer(-1));
                    tmp.setBMIID(new java.lang.Integer(-1));
                    this.Patient.getBMI_Devs().add(tmp);
                }
                if (HR != null)
                {
                    HR_Dev tmp = new HR_Dev();
                    tmp.setHR(new java.lang.Integer(Int32.Parse(HR)));
                    tmp.setPatientID_FK(new java.lang.Integer(Int32.Parse(PatientID)));
                    tmp.setDateTime(new java.util.Date());
                    tmp.setDevID_FK(new java.lang.Integer(-1));
                    tmp.setHRID(new java.lang.Integer(-1));
                    this.Patient.getHR_Devs().add(tmp);
                }
                if (Sleep != null)
                {
                    Sleep_Dev tmp = new Sleep_Dev();
                    tmp.setPatientID_FK(new java.lang.Integer(Int32.Parse(PatientID)));
                    tmp.setDateTime(new java.util.Date());
                    tmp.setSleepResults(Sleep);
                    tmp.setDevID_FK(new java.lang.Integer(-1));
                    tmp.setSleepID(new java.lang.Integer(-1));
                    this.Patient.getSleep_Devs().add(tmp);
                }
                if (Steps != null)
                {
                    Steps_Dev tmp = new Steps_Dev();
                    tmp.setPatientID_FK(new java.lang.Integer(Int32.Parse(PatientID)));
                    tmp.setDateTime(new java.util.Date());
                    tmp.setSteps(new java.lang.Double(Double.Parse(Steps)));
                    tmp.setDevID_FK(new java.lang.Integer(-1));
                    tmp.setStepsID(new java.lang.Integer(-1));
                    this.Patient.getSteps_Devs().add(tmp);
                }
                if (Floors != null)
                {
                    Floors_Dev tmp = new Floors_Dev();
                    tmp.setPatientID_FK(new java.lang.Integer(Int32.Parse(PatientID)));
                    tmp.setDateTime(new java.util.Date());
                    tmp.setFloors(new java.lang.Integer(Int32.Parse(Floors)));
                    tmp.setDevID_FK(new java.lang.Integer(-1));
                    tmp.setFloorsID(new java.lang.Integer(-1));
                    this.Patient.getFloors_Devs().add(tmp);
                }
                if (Weight != null)
                {
                    Weight_Dev tmp = new Weight_Dev();
                    tmp.setPatientID_FK(new java.lang.Integer(Int32.Parse(PatientID)));
                    tmp.setDateTime(new java.util.Date());
                    tmp.setWeight(new java.lang.Double(Double.Parse(Weight)));
                    tmp.setDevID_FK(new java.lang.Integer(-1));
                    tmp.setWeightID(new java.lang.Integer(-1));
                    this.Patient.getWeight_Devs().add(tmp);
                }
                // search for other datas in the database
                List<BMI_Dev> bmilist = BMIDAO.BMI_DAO.GetBMIByPatientID(PatientID);
                foreach (BMI_Dev bmi in bmilist)
                {
                    this.Patient.getBMI_Devs().add(bmi);
                }
                System.Diagnostics.Debug.WriteLine("BMI done...");
                List<Sleep_Dev> sleeplist = SleepDAO.Sleep_DAO.GetSleepByPatientID(PatientID);
                foreach (Sleep_Dev slp in sleeplist)
                {
                    this.Patient.getSleep_Devs().add(slp);
                }
                System.Diagnostics.Debug.WriteLine("Sleep done...");
                List<Steps_Dev> stepslist = StepsDAO.Steps_DAO.GetStepsByPatientID(PatientID);
                foreach (Steps_Dev stps in stepslist)
                {
                    this.Patient.getSteps_Devs().add(stps);
                }
                System.Diagnostics.Debug.WriteLine("Steps done...");
                List<HR_Dev> HRlist = HRDAO.HR_DAO.GetHRByPatientID(PatientID);
                foreach (HR_Dev stps in HRlist)
                {
                    this.Patient.getHR_Devs().add(stps);
                }
                System.Diagnostics.Debug.WriteLine("HR done...");
                List<Floors_Dev> Floorslist = FloorsDAO.Floors_DAO.GetFloorsByPatientID(PatientID);
                foreach (Floors_Dev stps in Floorslist)
                {
                    this.Patient.getFloors_Devs().add(stps);
                }
                System.Diagnostics.Debug.WriteLine("Floors done...");
                List<Weight_Dev> Weightlist = WeightDAO.Weight_DAO.GetWeightByPatientID(PatientID);
                foreach (Weight_Dev stps in Weightlist)
                {
                    this.Patient.getWeight_Devs().add(stps);
                }
                System.Diagnostics.Debug.WriteLine("Weight done...");
                succ = true;
            }
            catch(Exception e)
            {
                succ = false;
                throw e;
            }
            return succ;
        }

        public string GetPatientInfo()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("\nPatient ID: ").Append(patient.getPatientID())
                .Append("\nPatient Name: ").Append(patient.getFullName())
                .Append("\nGender: ").Append(patient.getGender())
                .Append("\nAge: ").Append(patient.getAge())
                .Append("\nCount of BMI_Dev: ").Append(patient.getBMI_Devs().size())
                .Append("\nCount of HR_Dev: ").Append(patient.getHR_Devs().size())
                .Append("\nCount of Floors_Dev: ").Append(patient.getFloors_Devs().size())
                .Append("\nCount of Weight_Dev: ").Append(patient.getWeight_Devs().size())
                .Append("\nCount of Sleep_Dev: ").Append(patient.getSleep_Devs().size())
                .Append("\nCount of Steps_Dev: ").Append(patient.getSteps_Devs().size());
            return sb.ToString();
        }
    }
}
