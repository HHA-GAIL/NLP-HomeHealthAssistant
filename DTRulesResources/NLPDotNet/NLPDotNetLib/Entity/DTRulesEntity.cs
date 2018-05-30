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

        public int DTID { get => dTID; set => dTID = value; }
        public string RuleName { get => ruleName; set => ruleName = value; }
        public string TriggerAttributes { get => triggerAttributes; set => triggerAttributes = value; }
        public string EntryTable { get => entryTable; set => entryTable = value; }
        public string DTXMLContent { get => dTXMLContent; set => dTXMLContent = value; }
    }
}
