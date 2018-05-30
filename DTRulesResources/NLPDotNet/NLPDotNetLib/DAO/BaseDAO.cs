using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NLPDotNetLib.DAO
{
    public class BaseDAO
    {
        protected String connString = "server=ec2-54-200-12-7.us-west-2.compute.amazonaws.com;user=research;database=gale;port=3306;password=Gail01";

        protected java.util.Date GetJavaDate(DateTime dt)
        {
            DateTime startTime = System.TimeZone.CurrentTimeZone.ToLocalTime(new System.DateTime(1970, 1, 1));
            long timeStamp = (long)(dt - startTime).TotalMilliseconds;
            //System.Diagnostics.Debug.WriteLine(new java.util.Date().getTime() +"--"+timeStamp);
            java.util.Date date = new java.util.Date(timeStamp);
            return date;
        }
    }
}
