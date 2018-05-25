package com.dtrules.samples.sampleproject2;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import com.dtrules.entity.IREntity;
import com.dtrules.interpreter.RName;
import com.dtrules.mapping.DataMap;
import com.dtrules.mapping.Mapping;
import com.dtrules.samples.sampleproject2.entity.Patient;
import com.dtrules.samples.sampleproject2.entity.SleepDev;
import com.dtrules.samples.sampleproject2.entity.StepsDev;
import com.dtrules.session.DTState;
import com.dtrules.session.IRSession;
import com.dtrules.session.RuleSet;
import com.dtrules.session.RulesDirectory;

public class MappingDataTestList {

	public boolean printData = true;
	
	public void run(){
		Patient testData = DataGenerater.GetPatients();
		if(printData)
			printTestData(testData);
		try{
			RulesDirectory rd = new RulesDirectory(System.getProperty("user.dir") + "/", "DTRules.xml");
			RName rsName   = RName.getRName("listtest");
			RuleSet rs = rd.getRuleSet(rsName);
			rs.newSession();
			
			IRSession session = rs.newSession();
			Mapping mapping = session.getMapping();
	        DataMap datamap = session.getDataMap(mapping,null);
	        
	        OutputStream out = new FileOutputStream(System.getProperty("user.dir") + "/listtest/output/" + testData.getPatientName() + "_trace.xml");
	       	session.getState().setOutput(out, System.out);
	       	session.getState().setState(DTState.TRACE | DTState.DEBUG);
	       	session.getState().traceStart();
	        
	        datamap.opentag(testData,"patient");
	        datamap.readDO(testData, "patient");
	        	datamap.opentag(testData.getMyTestEntity(),"myTestEntity");
	        	datamap.readDO(testData.getMyTestEntity(), "myTestEntity");
	        	datamap.closetag();
	        	datamap.opentag("sleepDevs");
	        	for(SleepDev slp : testData.getSleepDevs()){
	        		datamap.opentag(slp, "sleepDev");
	        		datamap.readDO(slp, "sleepDev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        	datamap.opentag("stepsDevs");
	        	for(StepsDev stp : testData.getStepsDevs()){
	        		datamap.opentag(stp, "stepsDev");
	        		datamap.readDO(stp, "stepsDev");
	        		datamap.closetag();
	        	}
	        	datamap.closetag();
	        datamap.closetag();
	        
	        mapping.loadData(session, datamap);
            session.execute("Test_Patient_List");
	        session.getState().traceEnd();
	        
	        IREntity result = session.getState().find("patientResult").rEntityValue();
	        int code = result.get("resultCode").intValue();
	        String message = result.get("resultMessage").stringValue();
	        
			System.out.println("Over.....\n"+code+"--"+message);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	public void printTestData(Patient testData){
		System.out.println(testData.getPatient_ID() + "--" + testData.getGender() + "--" + testData.getPatientName());
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("-------------------------------------------------------");
		for(int i = 0; i < DataGenerater.ArrayNumber; i++){
			System.out.println(format.format(testData.getSleepDevs().get(i).getSleepDate()) + "--" + testData.getSleepDevs().get(i).getSleepMeasurement());
		}
		System.out.println("-------------------------------------------------------");
		for(int i = 0; i < DataGenerater.ArrayNumber; i++){
			System.out.println(format.format(testData.getStepsDevs().get(i).getStepsDate()) + "--" + testData.getStepsDevs().get(i).getStepsMeasurement());
		}
		System.out.println("-------------------------------------------------------");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MappingDataTestList mdtl = new MappingDataTestList();
		mdtl.printData = false;
		mdtl.run();
	}
	
	
}
