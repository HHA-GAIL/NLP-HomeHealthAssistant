package edu.dhu.DTRules;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.dtrules.entity.IREntity;
import com.dtrules.interpreter.IRObject;
import com.dtrules.interpreter.RArray;
import com.dtrules.interpreter.RName;
import com.dtrules.mapping.DataMap;
import com.dtrules.mapping.Mapping;
import com.dtrules.session.DTState;
import com.dtrules.session.IRSession;
import com.dtrules.session.RuleSet;
import com.dtrules.session.RulesDirectory;

import edu.dhu.DTRules.entities.BMI_Dev;
import edu.dhu.DTRules.entities.ExaminResult;
import edu.dhu.DTRules.entities.Floors_Dev;
import edu.dhu.DTRules.entities.HR_Dev;
import edu.dhu.DTRules.entities.Patient;
import edu.dhu.DTRules.entities.Result;
import edu.dhu.DTRules.entities.Sleep_Dev;
import edu.dhu.DTRules.entities.Steps_Dev;
import edu.dhu.DTRules.entities.Weight_Dev;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DTRulesPatientDev {

	public static final String RuleName_PatientDemo = "DemoPatientTest";
	public static final String BasePath = System.getProperty("user.dir")+"/DTRules/";
	public static final String ConfigFileFileName = "DTRules.xml";
	public static final String EntryTable = "Test_Patient";
        public static final String RuleName = "TheDecisionTable";
	public static DTRulesPatientDev dtr;
	
	private boolean trace = false;
        private String WorkingPath = System.getProperty("java.library.path").split(";;")[0];
	
	public static DTRulesPatientDev getInstance(){
                System.out.println("---GG--->"+System.getProperty("java.library.path"));
		if(dtr == null){
			dtr = new DTRulesPatientDev();
			return dtr;
		}else
			return dtr;
	}
	
	public boolean isTrace() {
		return trace;
	}

	public void setTrace(boolean trace) {
		this.trace = trace;
	}

	/**
	 * to do the decision table and return the reusult list
	 * @param patient - the Dev data, should be Patient
	 * @param basePath - the base path of DTRules. Default:./DTRules/
	 * @param configFileName - the config file name. Default:DTRules.xml
	 * @param ruleName - the RuleSet's name
	 * @param entryTable - the entry table of the decision table
	 * @return the list of Result
	 */
	private List<Result> doExamine(Patient patient,String basePath, String configFileName, String ruleName, String entryTable)
			throws Exception{
		List<Result> results = new ArrayList<Result>();
                System.out.println("DE111");
		try{
			RulesDirectory rd = new RulesDirectory(basePath, configFileName);
			RName rsName   = RName.getRName(ruleName);
			RuleSet rs = rd.getRuleSet(rsName);
			rs.newSession();
		System.out.println("DE222");
			IRSession session = rs.newSession();
			Mapping mapping = session.getMapping();
	        DataMap datamap = session.getDataMap(mapping,null);
	        System.out.println("DE333");
	        File file = new File(basePath + ruleName + "TEST/output");
	        if(!file.exists())
	        	file.mkdirs();
	        OutputStream out = new FileOutputStream(basePath + ruleName + "TEST/output/" + patient.getFullName() + "_trace.xml");
	       	session.getState().setOutput(out, System.out);
	       	session.getState().setState(DTState.TRACE | DTState.DEBUG);
	       	session.getState().traceStart();
	        System.out.println("DE444");
	        datamap.opentag(patient, "patient");
	        datamap.readDO(patient, "patient");
	        System.out.println("DE555");
	        	datamap.opentag("sleep_Devs");
	        	for(Sleep_Dev slp : patient.getSleep_Devs()){
	        		datamap.opentag(slp, "sleep_Dev");
	        		datamap.readDO(slp, "sleep_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        System.out.println("DE666");
	        	datamap.opentag("steps_Devs");
	        	for(Steps_Dev slp : patient.getSteps_Devs()){
	        		datamap.opentag(slp, "steps_Dev");
	        		datamap.readDO(slp, "steps_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        System.out.println("DE777");
	        	datamap.opentag("bMI_Devs");
	        	for(BMI_Dev slp : patient.getBMI_Devs()){
	        		datamap.opentag(slp, "bMI_Dev");
	        		datamap.readDO(slp, "bMI_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        System.out.println("DE888");
	        	datamap.opentag("hR_Devs");
	        	for(HR_Dev slp : patient.getHR_Devs()){
	        		datamap.opentag(slp, "hR_Dev");
	        		datamap.readDO(slp, "hR_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        System.out.println("DE999");
	        	datamap.opentag("floors_Devs");
	        	for(Floors_Dev slp : patient.getFloors_Devs()){
	        		datamap.opentag(slp, "floors_Dev");
	        		datamap.readDO(slp, "floors_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        System.out.println("DE101010");
	        	datamap.opentag("weight_Devs");
	        	for(Weight_Dev slp : patient.getWeight_Devs()){
	        		datamap.opentag(slp, "weight_Dev");
	        		datamap.readDO(slp, "weight_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        System.out.println("DE111111");
	        	datamap.opentag("results");
	        	for(Result slp : patient.getResults()){
	        		datamap.opentag(slp, "result");
	        		datamap.readDO(slp, "result");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        System.out.println("DE121212");

	        datamap.closetag();
	        
	        mapping.loadData(session, datamap);
                session.execute(entryTable);
	        session.getState().traceEnd();
	        System.out.println("DE131313");
	        RArray resultsArray = session.getState().find("results").rArrayValue();
	        for(IRObject r: resultsArray){
	        	IREntity result = r.rEntityValue();
	        	int code = result.get("resultCode").intValue();
	        	String message = result.get("resultMessage").stringValue();
	        	System.out.println("result:"+code+"--->"+message);
	        	Result tmp = new Result();
	        	tmp.setResultCode(code);
	        	tmp.setResultMessage(message);
	        	results.add(tmp);
	        }
                System.out.println("DE141414");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		}
		return results;
	}
	/***
         * to save the XMLContent to the certain xml file and do the examine.
         * @param patient
         * @param XMLContent
         * @param entryTable
         * @return
         * @throws Exception 
         */
        public ExaminResult doExamine(Patient patient, String XMLContent, String entryTable)
			throws Exception{
            //write the XMLContent into the certain xml file
//            throw new Exception("Some thing wrong in the do Examine");
            ExaminResult er = new ExaminResult();
            String check = checkForDirsAndNecessaryFiles(null);
            if(check.contains("<--!MISSINGFILES!-->"))
            {
                er.setStatus(ExaminResult.FAIL);
                er.setMessage(check);
                return er;
            }
            writeRuleContentXmlFile(XMLContent);
            List<Result> results = doExamine(patient, WorkingPath + "/DTRules/", ConfigFileFileName, RuleName, entryTable);
            er.setStatus(ExaminResult.SUCC);
            er.setMessage("");
            er.setResults(results);
            return er;
        }
        
        /***
         * to run the DTRules with the files exist now
         * @param patient
         * @param entryTable
         * @return
         * @throws Exception 
         */
        public ExaminResult doExamine(Patient patient, String entryTable)
			throws Exception{
            ExaminResult er = new ExaminResult();
            String check = checkForDirsAndNecessaryFiles(BasePath);
            if(check.contains("<--!MISSINGFILES!-->"))
            {
                er.setStatus(ExaminResult.FAIL);
                er.setMessage(check);
                return er;
            }
            List<Result> results = doExamine(patient, BasePath, ConfigFileFileName, RuleName, entryTable);
            er.setStatus(ExaminResult.SUCC);
            er.setMessage("");
            er.setResults(results);
            return er;
        }
        
        public void writeRuleContentXmlFile(String RuleSetString) throws FileNotFoundException, IOException {
            //write a temp file for the new RuleSetString
            File dtrules = new File(WorkingPath + "/DTRules/xml/TheDecisionTable_dt.xml");
            dtrules.createNewFile();
            FileOutputStream fos = new FileOutputStream(dtrules);
            fos.write(RuleSetString.getBytes("utf-8"));
            fos.close();
        }
        
        /***
         * used to check for the necessary files 
         * @return 
         */
        public String checkForDirsAndNecessaryFiles(String basepathString){
            StringBuilder sb = new StringBuilder();
            boolean can = true;
            File file = null;
            String tmpWorkingPath = null;   
            if(basepathString == null)
                tmpWorkingPath = WorkingPath + "/DTRules/";
            else
                tmpWorkingPath = basepathString;
            file = new File(tmpWorkingPath);
            file.mkdirs();
            file = new File(tmpWorkingPath + "workingDir");
            file.mkdirs();
            file = new File(tmpWorkingPath + ConfigFileFileName);
            if(!file.exists())
            {
                sb.append("Missing " + tmpWorkingPath + "DTRules.xml\n");
                can = false;
            }
            file = new File(tmpWorkingPath + "xml/Dev_edd.xml");
            if(!file.exists())
            {
                sb.append("Missing " + tmpWorkingPath + "xml/Dev_edd.xml\n");
                can = false;
            }
            file = new File(tmpWorkingPath + "xml/Dev_map.xml");
            if(!file.exists())
            {
                sb.append("Missing " + tmpWorkingPath + "xml/Dev_map.xml\n");
                can = false;
            }
            if(!can)
                sb.append("<--!MISSINGFILES!-->");
            else
                sb.append("<--!OK!-->");
            return sb.toString();
        }

    /**
     * @return the WorkingPath
     */
    public String getWorkingPath() {
        return WorkingPath;
    }

    /**
     * @param WorkingPath the WorkingPath to set
     */
    public void setWorkingPath(String WorkingPath) {
        this.WorkingPath = WorkingPath;
    }
    
    private String getCurrentPath()  
    {
        String path = DTRulesPatientDev.class.getProtectionDomain().getCodeSource().getLocation().getFile();  
        try  
        {  
            path = java.net.URLDecoder.decode(path, "UTF-8");
        }  
        catch (java.io.UnsupportedEncodingException e)  
        {  
            return null;  
        }  
        return new File(path).getParent();  
    }  
}
