using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using edu.dhu.DTRules;
using com.dtrules.samples.sampleproject2;
using System.IO;
using com.dtrules.session;

namespace NLPDotNetLib
{
    public class test
    {
        public static void Compile()
        {
            //No idea about why should have a system.out.println to ensure the code could run
            edu.dhu.DTRules.entities.Patient patient = DataGenerater.GenerateDTRulesPatient();
            string[] mapping = { "main" };
            string path = Environment.CurrentDirectory;
            //System.Diagnostics.Debug.WriteLine(path);
            //DTRulesCompiler.Compile(path + @"\DTRules", "DTRules.xml", "TheDecisionTable", path + @"\DTRules", mapping);
            DTRulesPatientDev dtpd = new DTRulesPatientDev();
            dtpd.doExamine(patient, path + @"\DTRules", "DTRules.xml","TheDecisionTable","Test_Patient");
        }
    }
}
