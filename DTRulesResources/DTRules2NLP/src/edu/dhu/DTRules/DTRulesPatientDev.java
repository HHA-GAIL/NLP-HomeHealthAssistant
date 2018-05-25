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
import edu.dhu.DTRules.entities.Floors_Dev;
import edu.dhu.DTRules.entities.HR_Dev;
import edu.dhu.DTRules.entities.Patient;
import edu.dhu.DTRules.entities.Result;
import edu.dhu.DTRules.entities.Sleep_Dev;
import edu.dhu.DTRules.entities.Steps_Dev;
import edu.dhu.DTRules.entities.Weight_Dev;


public class DTRulesPatientDev {

	public static final String RuleName_PatientDemo = "DemoPatientTest";
	public static final String BasePath = System.getProperty("user.dir")+"/DTRules/";
	public static final String ConfigFileFileName = "DTRules.xml";
	public static final String EntryTable = "Test_Patient";
	public static DTRulesPatientDev dtr;
	
	private boolean trace = false;
	
	public static DTRulesPatientDev getInstance(){
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
	public List<Result> doExamine(Patient patient,String basePath, String configFileName, String ruleName, String entryTable)
			throws Exception{
		List<Result> results = new ArrayList<Result>();
		try{
			RulesDirectory rd = new RulesDirectory(basePath, configFileName);
			RName rsName   = RName.getRName(ruleName);
			RuleSet rs = rd.getRuleSet(rsName);
			rs.newSession();
			
			IRSession session = rs.newSession();
			Mapping mapping = session.getMapping();
	        DataMap datamap = session.getDataMap(mapping,null);
	        
	        File file = new File(basePath + ruleName + "TEST/output");
	        if(!file.exists())
	        	file.mkdirs();
	        OutputStream out = new FileOutputStream(basePath + ruleName + "TEST/output/" + patient.getFullName() + "_trace.xml");
	       	session.getState().setOutput(out, System.out);
	       	session.getState().setState(DTState.TRACE | DTState.DEBUG);
	       	session.getState().traceStart();
	        
	        datamap.opentag(patient, "patient");
	        datamap.readDO(patient, "patient");
	        
	        	datamap.opentag("sleep_Devs");
	        	for(Sleep_Dev slp : patient.getSleep_Devs()){
	        		datamap.opentag(slp, "sleep_Dev");
	        		datamap.readDO(slp, "sleep_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	
	        	datamap.opentag("steps_Devs");
	        	for(Steps_Dev slp : patient.getSteps_Devs()){
	        		datamap.opentag(slp, "steps_Dev");
	        		datamap.readDO(slp, "steps_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	
	        	datamap.opentag("bMI_Devs");
	        	for(BMI_Dev slp : patient.getBMI_Devs()){
	        		datamap.opentag(slp, "bMI_Dev");
	        		datamap.readDO(slp, "bMI_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	
	        	datamap.opentag("hR_Devs");
	        	for(HR_Dev slp : patient.getHR_Devs()){
	        		datamap.opentag(slp, "hR_Dev");
	        		datamap.readDO(slp, "hR_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	
	        	datamap.opentag("floors_Devs");
	        	for(Floors_Dev slp : patient.getFloors_Devs()){
	        		datamap.opentag(slp, "floors_Dev");
	        		datamap.readDO(slp, "floors_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	
	        	datamap.opentag("weight_Devs");
	        	for(Weight_Dev slp : patient.getWeight_Devs()){
	        		datamap.opentag(slp, "weight_Dev");
	        		datamap.readDO(slp, "weight_Dev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	
	        	datamap.opentag("results");
	        	for(Result slp : patient.getResults()){
	        		datamap.opentag(slp, "result");
	        		datamap.readDO(slp, "result");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	

	        datamap.closetag();
	        
	        mapping.loadData(session, datamap);
            session.execute(entryTable);
	        session.getState().traceEnd();
	        
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
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		}
		return results;
	}
	
}
