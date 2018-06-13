package com.dtrules.samples.sampleproject2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import edu.dhu.DTRules.DTRulesCompiler;
import edu.dhu.DTRules.DTRulesPatientDev;
import edu.dhu.DTRules.entities.BMI_Dev;
import edu.dhu.DTRules.entities.ExaminResult;
import edu.dhu.DTRules.entities.Patient;

public class DemoTesting {

	public static void main(String args[]){
		try {
			
			String [] mapping = {"main"};
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PrintStream cacheout = new PrintStream(baos);
//            PrintStream original = System.out;
//            System.setOut(cacheout);
                        String basePath = System.getProperty("user.dir") + "/DTRulesTest/";
                        DTRulesCompiler.getInstance().setWorkingPath(basePath);
                        ExaminResult er = DTRulesCompiler.getInstance().Compile(mapping);
//			System.setOut(original);
//			System.out.println("--->"+baos.toString()+"<---");
			if(er.getStatus().equals(ExaminResult.FAIL)){
                            System.out.println(er.getMessage());
                        }else{
                            edu.dhu.DTRules.entities.Patient patient = DataGenerater.GenerateDTRulesPatient();
                            DTRulesPatientDev dtpd = DTRulesPatientDev.getInstance();
                            dtpd.setWorkingPath(basePath);
                            dtpd.doExamine(patient, er.getMessage(), dtpd.EntryTable);
                        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
