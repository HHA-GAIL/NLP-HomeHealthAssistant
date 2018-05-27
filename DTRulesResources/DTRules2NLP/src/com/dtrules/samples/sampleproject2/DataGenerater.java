package com.dtrules.samples.sampleproject2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.dtrules.samples.sampleproject2.entity.Patient;
import com.dtrules.samples.sampleproject2.entity.SleepDev;
import com.dtrules.samples.sampleproject2.entity.StepsDev;
import com.dtrules.samples.sampleproject2.entity.TestEntity;

import edu.dhu.DTRules.entities.Floors_Dev;
import edu.dhu.DTRules.entities.HR_Dev;
import edu.dhu.DTRules.entities.Sleep_Dev;
import edu.dhu.DTRules.entities.Steps_Dev;
import edu.dhu.DTRules.entities.Weight_Dev;

public class DataGenerater {

	public static int ArrayNumber = 20;
	
	public static Patient GetPatients(){
		Patient patient = new Patient();
		Random random = new Random(new Date().getTime());
		int ids = 0;
		boolean male = random.nextBoolean();
		if(male){
			patient.setGender(Patient.MALE);
		}else{
			patient.setGender(Patient.FEMALE);
		}
		patient.setPatient_ID("" + random.nextInt(99999));
		List<Integer> randomArray = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray.add(i);
		}
		List<Integer> randomArray2 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray2.add(i);
		}
		for(int i = 0; i < ArrayNumber; i++){
			//add a random sleepdev
			SleepDev sleepDev = new SleepDev();
			sleepDev.setSleepID(ids + "");
			sleepDev.setSleepDate(getDateUL(randomArray, random, true));
			sleepDev.setSleepMeasurement(420 + random.nextInt(120));
			patient.getSleepDevs().add(sleepDev);
			//add a random steps dev
			StepsDev stepsDev = new StepsDev();
			stepsDev.setStepsID(ids++ + "");
			stepsDev.setStepsDate(getDateUL(randomArray2, random, true));
			stepsDev.setStepsMeasurement(random.nextInt(10000));
			patient.getStepsDevs().add(stepsDev);
		}
		TestEntity te = new TestEntity();
		te.setTestID(ids++);
		te.setTestName("A test of sub entity...");
		patient.setMyTestEntity(te);
		patient.setPatientName("NazonaX");
		return patient;
	}
	
	private static Date getDateUL(Random random, int number1, int number2) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(calendar.DATE, random.nextInt(number1) - number2);
		return calendar.getTime();
	}
	
	private static Date getDateUL(List<Integer> array, Random random, boolean delete) {
                System.out.println(array.size());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int selected = random.nextInt(array.size());
		calendar.add(calendar.DATE, array.get(selected));
		if(delete)
			array.remove(selected);
		return calendar.getTime();
	}
	
	public static edu.dhu.DTRules.entities.Patient GenerateDTRulesPatient(){
		edu.dhu.DTRules.entities.Patient patient = new edu.dhu.DTRules.entities.Patient();
		Random random = new Random(new Date().getTime());
		int ids = 0;
		boolean male = random.nextBoolean();
		male = true;
		if(male){
			patient.setGender(edu.dhu.DTRules.entities.Patient.MALE);
		}else{
			patient.setGender(edu.dhu.DTRules.entities.Patient.FEMALE);
		}
		patient.setPatientID(1);
		patient.setAge(24);
		patient.setMemberSince(new Date());
		patient.setFullName("NazonaX");
		List<Integer> randomArray = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray.add(i);
		}
		List<Integer> randomArray2 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray2.add(i);
		}
		List<Integer> randomArray3 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray3.add(i);
		}
		List<Integer> randomArray4 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray4.add(i);
		}
		List<Integer> randomArray5 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray5.add(i);
		}
		List<Integer> randomArray6 = new ArrayList<Integer>();
		for(int i = 0; i < ArrayNumber; i++){
			randomArray6.add(i);
		}
		for(int i = 0; i < ArrayNumber; i++){
			//add a random sleepdev
			edu.dhu.DTRules.entities.Sleep_Dev sleepDev = new edu.dhu.DTRules.entities.Sleep_Dev();
			sleepDev.setSleepID(i);
			sleepDev.setDevID_FK(-1);
			sleepDev.setPatientID_FK(1);
			sleepDev.setSleepResults("better..."+i);
			sleepDev.setDateTime(getDateUL(randomArray, random, true));
			sleepDev.setSleepMeasurement(random.nextInt(400) + 500d);
			patient.getSleep_Devs().add(sleepDev);
			//add a random steps dev
			edu.dhu.DTRules.entities.Steps_Dev stepsDev = new edu.dhu.DTRules.entities.Steps_Dev();
			stepsDev.setStepsID(i);
			stepsDev.setDevID_FK(-1);
			stepsDev.setPatientID_FK(1);
			stepsDev.setSteps(random.nextInt(10000) + 0.0);
			stepsDev.setDateTime(getDateUL(randomArray2, random, true));
			patient.getSteps_Devs().add(stepsDev);
			//add a random BMI_Dev
			edu.dhu.DTRules.entities.BMI_Dev bmi = new edu.dhu.DTRules.entities.BMI_Dev();
			bmi.setBMI(random.nextInt(25)+15.2);
			bmi.setBMIID(i);
			bmi.setDevID_FK(-1);
			bmi.setPatientID_FK(1);
			bmi.setDateTime(getDateUL(randomArray3, random, true));
			patient.getBMI_Devs().add(bmi);
			//add a random Floors_Dev
			edu.dhu.DTRules.entities.Floors_Dev floor = new Floors_Dev();
			floor.setDevID_FK(-1);
			floor.setPatientID_FK(1);
			floor.setFloorsID(i);
			floor.setDateTime(getDateUL(randomArray4, random, true));
			floor.setFloors(random.nextInt(10));
			patient.getFloors_Devs().add(floor);
			//add a random HR_Dev
			edu.dhu.DTRules.entities.HR_Dev hr = new HR_Dev();
			hr.setDevID_FK(-1);;
			hr.setPatientID_FK(1);
			hr.setHR(random.nextInt());
			hr.setHRID(i);
			hr.setDateTime(getDateUL(randomArray5, random, true));
			patient.getHR_Devs().add(hr);
			//add a random Weight_Dev
			edu.dhu.DTRules.entities.Weight_Dev we = new Weight_Dev();
			we.setDateTime(getDateUL(randomArray6, random, true));
			we.setDevID_FK(-1);
			we.setPatientID_FK(1);
			we.setWeight(random.nextDouble() + random.nextInt(50) + 30);
			we.setWeightID(i);
			patient.getWeight_Devs().add(we);
		}
		return patient;
	}
	
}
