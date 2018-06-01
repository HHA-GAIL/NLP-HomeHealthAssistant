using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NLPDotNetLib.Entity
{
    public class DTRulesEntity
    {
        private int dTID;
        private string ruleName;
        private string triggerAttributes;
        private string entryTable;
        private string dTXMLContent;

        public int DTID { 
            get{return dTID;}
            set{dTID = value; }
        }
        public string RuleName { get { return ruleName;} set{ruleName = value; }}
        public string TriggerAttributes { get { return triggerAttributes;} set { triggerAttributes = value; }}
        public string EntryTable { get { return entryTable;} set { entryTable = value; }}
        public string DTXMLContent { get { return dTXMLContent; } set { dTXMLContent = value; } }
    }
}
