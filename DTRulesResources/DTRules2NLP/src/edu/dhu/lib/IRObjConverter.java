/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dhu.lib;

import com.dtrules.entity.IREntity;
import com.dtrules.infrastructure.RulesException;
import com.dtrules.interpreter.IRObject;
import edu.dhu.DTRules.entities.BMI_Dev;
import edu.dhu.DTRules.entities.Floors_Dev;
import edu.dhu.DTRules.entities.HR_Dev;
import edu.dhu.DTRules.entities.Patient;
import edu.dhu.DTRules.entities.Sleep_Dev;
import edu.dhu.DTRules.entities.Steps_Dev;
import edu.dhu.DTRules.entities.Weight_Dev;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author HASEE
 */
public class IRObjConverter {
    
    public static Patient ConvertIRObjToPatient(IRObject x) throws RulesException {
        Patient patient = new Patient();
        IREntity entity = x.rEntityValue();
        patient.setAge(entity.get("age").intValue());
        patient.setGender(entity.get("gender").stringValue());
        patient.setFullName(entity.get("fullName").stringValue());
        patient.setPatientID(entity.get("patientID").intValue());
        patient.setBMI_Devs(ConvertBMI(entity.get("bMI_Devs")));
        patient.setFloors_Devs(ConvertFloors(entity.get("floors_Devs")));
        patient.setHR_Devs(ConvertHR(entity.get("hR_Devs")));
        patient.setSleep_Devs(ConvertSleep(entity.get("sleep_Devs")));
        patient.setSteps_Devs(ConvertSteps(entity.get("steps_Devs")));
        patient.setWeight_Devs(ConvertWeight(entity.get("weight_Devs")));
        return  patient;
    }

    public static List<BMI_Dev> ConvertBMI(IRObject bmi) throws RulesException {
        List<IRObject> bmiList = bmi.arrayValue();
        List<BMI_Dev> results = new LinkedList<>();
        for(IRObject tmpIRObject : bmiList){
            IREntity bmitmp = tmpIRObject.rEntityValue();
            BMI_Dev tmp = new BMI_Dev();
            tmp.setBMI(bmitmp.get("bMI").doubleValue());
            tmp.setBMIID(bmitmp.get("bMIID").intValue());
            tmp.setDevID_FK(bmitmp.get("devID_FK").intValue());
            tmp.setPatientID_FK(bmitmp.get("patientID_FK").intValue());
            Date dt = new Date(bmitmp.get("dateTime").longValue());
            tmp.setDateTime(dt);
            results.add(tmp);
        }
        return results;
    }

    public static List<Floors_Dev> ConvertFloors(IRObject floors) throws RulesException {
        List<IRObject> floorsList = floors.arrayValue();
        List<Floors_Dev> results = new LinkedList<>();
        for(IRObject tmpIRObject : floorsList){
            IREntity floorstmp = tmpIRObject.rEntityValue();
            Floors_Dev tmp = new Floors_Dev();
            tmp.setFloors(floorstmp.get("floors").intValue());
            tmp.setFloorsID(floorstmp.get("floorsID").intValue());
            tmp.setDevID_FK(floorstmp.get("devID_FK").intValue());
            tmp.setPatientID_FK(floorstmp.get("patientID_FK").intValue());
            Date dt = new Date(floorstmp.get("dateTime").longValue());
            tmp.setDateTime(dt);
            results.add(tmp);
        }
        return results;
    }

    public static List<HR_Dev> ConvertHR(IRObject hr) throws RulesException {
        List<IRObject> hrList = hr.arrayValue();
        List<HR_Dev> results = new LinkedList<>();
        for(IRObject tmpIRObject : hrList){
            IREntity hrtmp = tmpIRObject.rEntityValue();
            HR_Dev tmp = new HR_Dev();
            tmp.setHR(hrtmp.get("hR").intValue());
            tmp.setHRID(hrtmp.get("hRID").intValue());
            tmp.setDevID_FK(hrtmp.get("devID_FK").intValue());
            tmp.setPatientID_FK(hrtmp.get("patientID_FK").intValue());
            Date dt = new Date(hrtmp.get("dateTime").longValue());
            tmp.setDateTime(dt);
            results.add(tmp);
        }
        return results;
    }

    public static List<Sleep_Dev> ConvertSleep(IRObject sleep) throws RulesException {
        List<IRObject> sleepList = sleep.arrayValue();
        List<Sleep_Dev> results = new LinkedList<>();
        for(IRObject tmpIRObject : sleepList){
            IREntity sleeptmp = tmpIRObject.rEntityValue();
            Sleep_Dev tmp = new Sleep_Dev();
            tmp.setSleepResults(sleeptmp.get("sleepResults").stringValue());
            tmp.setSleepID(sleeptmp.get("sleepID").intValue());
            tmp.setDevID_FK(sleeptmp.get("devID_FK").intValue());
            tmp.setPatientID_FK(sleeptmp.get("patientID_FK").intValue());
            Date dt = new Date(sleeptmp.get("dateTime").longValue());
            tmp.setDateTime(dt);
            results.add(tmp);
        }
        return results;
    }

    public static List<Steps_Dev> ConvertSteps(IRObject steps) throws RulesException {
        List<IRObject> stepsList = steps.arrayValue();
        List<Steps_Dev> results = new LinkedList<>();
        for(IRObject tmpIRObject : stepsList){
            IREntity stepstmp = tmpIRObject.rEntityValue();
            Steps_Dev tmp = new Steps_Dev();
            tmp.setSteps(stepstmp.get("steps").doubleValue());
            tmp.setStepsID(stepstmp.get("stepsID").intValue());
            tmp.setDevID_FK(stepstmp.get("devID_FK").intValue());
            tmp.setPatientID_FK(stepstmp.get("patientID_FK").intValue());
            Date dt = new Date(stepstmp.get("dateTime").longValue());
            tmp.setDateTime(dt);
            results.add(tmp);
        }
        return results;
    }

    public static List<Weight_Dev> ConvertWeight(IRObject weight) throws RulesException {
        List<IRObject> weightList = weight.arrayValue();
        List<Weight_Dev> results = new LinkedList<>();
        for(IRObject tmpIRObject : weightList){
            IREntity weighttmp = tmpIRObject.rEntityValue();
            Weight_Dev tmp = new Weight_Dev();
            tmp.setWeight(weighttmp.get("weight").doubleValue());
            tmp.setWeightID(weighttmp.get("weightID").intValue());
            tmp.setDevID_FK(weighttmp.get("devID_FK").intValue());
            tmp.setPatientID_FK(weighttmp.get("patientID_FK").intValue());
            Date dt = new Date(weighttmp.get("dateTime").longValue());
            tmp.setDateTime(dt);
            results.add(tmp);
        }
        return results;
    }
    
}
