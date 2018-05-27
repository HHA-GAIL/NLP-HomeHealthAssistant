package com.dtrules.samples.sampleproject2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import edu.dhu.DTRules.DTRulesCompiler;
import edu.dhu.DTRules.DTRulesPatientDev;
import edu.dhu.DTRules.entities.BMI_Dev;
import edu.dhu.DTRules.entities.Patient;

public class DemoTesting {

	public static void main(String args[]){
		try {
			
			String [] mapping = {"main"};
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PrintStream cacheout = new PrintStream(baos);
//            PrintStream original = System.out;
//            System.setOut(cacheout);
			DTRulesCompiler.Compile(DTRulesCompiler.BasePath, DTRulesCompiler.ConfigFileName,
					"TheDecisionTable", DTRulesCompiler.BasePath, mapping);
//			System.setOut(original);
//			System.out.println("--->"+baos.toString()+"<---");
			
			edu.dhu.DTRules.entities.Patient patient = DataGenerater.GenerateDTRulesPatient();
			DTRulesPatientDev dtpd = new DTRulesPatientDev();
			dtpd.doExamine(patient, dtpd.BasePath,
					dtpd.ConfigFileFileName,
					"TheDecisionTable",
					dtpd.EntryTable);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
