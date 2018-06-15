package com.dtrules.samples.sampleproject2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import edu.dhu.DTRules.DTRulesCompiler;
import edu.dhu.DTRules.DTRulesPatientDev;
import edu.dhu.DTRules.entities.BMI_Dev;
import edu.dhu.DTRules.entities.ExaminResult;
import edu.dhu.DTRules.entities.Patient;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class DemoTesting {

	public static void main(String args[]){
		try {
			
			String [] mapping = {"main"};
                        
                        String basePath = System.getProperty("user.dir") + "/DTRulesTest/";
                        DTRulesCompiler.getInstance().setWorkingPath(basePath);
//                        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
//                        PrintStream cacheout = new PrintStream(baos);
//                        PrintStream original = System.out;
//                        System.setOut(cacheout);
//                        PipedInputStream pipedIS = new PipedInputStream();
//                        PipedOutputStream pipedOS = new PipedOutputStream();
//                        pipedOS.connect(pipedIS); 
//                        PrintStream ps = new PrintStream(pipedOS); 
//                        System.setOut(ps); 
//                        System.setErr(ps);
                        ExaminResult er = DTRulesCompiler.getInstance().Compile(mapping);
//                        System.setOut(original);
//                        System.out.println("\n===================\n"+baos.toString("utf-8")+"\n===================\n");
//                        byte[] readed = new byte[pipedIS.available()];
//                        pipedIS.read(readed, 0, pipedIS.available());
//                        System.out.println("\n===================\n"+new String(readed)+"\n===================\n");
			if(er.getStatus().equals(ExaminResult.FAIL)){
                            System.out.println(er.getMessage());
                        }else{
                            edu.dhu.DTRules.entities.Patient patient = DataGenerater.GenerateDTRulesPatient();
                            DTRulesPatientDev dtpd = DTRulesPatientDev.getInstance();
                            dtpd.setWorkingPath(basePath);
                            dtpd.doExamine(patient, er.getMessage(), "Test_Heart_Rate");
//                            dtpd.doExamine(patient, er.getMessage(), dtpd.EntryTable);
                        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
