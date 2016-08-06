/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.*;
import Interface.History.*;

/**
 *
 * @author Brian
 */
public class History {
//Global History Variables    

    private final Interface.PatientMeta.GeneralInformation historyOfPatient;
//Family history variables
    private ArrayList<Family> familyHistory;
    private final Family familyHolder = new Family();

    public ArrayList<Family> getFamilyHistory() {
        return familyHistory;
    }
    //immunization history variables

    private ArrayList<Immunizations> immunizationHistory;
    private final Immunizations immunizationHolder = new Immunizations();

    public ArrayList<Immunizations> getImmunizationHistory() {
        return immunizationHistory;
    }

    //Occupational History
    private ArrayList<Occupation> occupationalHistory;
    private final Occupation occupationHolder = new Occupation();

    public ArrayList<Occupation> getOccupationalHistory() {
        return occupationalHistory;
    }
    //General History
    private final General generalHistoryHolder = new General();
    private General generalHistory;

    public General getGeneralHistory() {
        return generalHistory;
    }
    //Illness
    private ArrayList<Illness> illnessHistory;
    private final Illness illnessHolder = new Illness();

    public ArrayList<Illness> getIllnessHistory() {
        return illnessHistory;
    }
    
    

//Constructors
    public History(Interface.PatientMeta.GeneralInformation patient) throws Exception {
        this.historyOfPatient = patient;
        initiateHistory();
    }

    public final void initiateHistory() throws Exception {
        initiateFamilyHistory();
        initiateImmunizationHistory();
        initiateOccupationHistory();
        initiateGeneralHistory();
        initiateIllnessHistory();
    }

    //family history
    /**
     * Using the family holder variable initiates an array of family history to
     * be used by later code
     *
     * @throws Exception
     */
    public void initiateFamilyHistory() throws Exception {
        try {
            familyHolder.populateData(historyOfPatient);
            familyHistory = null;
            familyHistory = familyHolder.createArrayList();
        } catch (Exception e) {
            System.err.println("Error thrown in initateFamilyHistory");
            throw e;
        }
    }

    public void updateFamilyHistory(Family familyFromGUI) throws Exception {
        familyFromGUI.setPatientID(historyOfPatient.getPatientID());
        familyHolder.updateData(familyFromGUI);
        initiateFamilyHistory();
    }

    public void addFamilyHistory(Family familyFromGUI) throws Exception {
        familyFromGUI.setPatientID(historyOfPatient.getPatientID());
        int nextValue = familyHolder.getNextID();
        familyFromGUI.setFamilyID(nextValue);
        familyHolder.addData(familyFromGUI);
        initiateFamilyHistory();
    }

    //immunization history
    public void initiateImmunizationHistory() throws Exception {
        try {
            immunizationHolder.populateData(historyOfPatient);
            immunizationHistory = null;
            immunizationHistory = immunizationHolder.createArrayList();
        } catch (Exception e) {
            System.err.println("Error thrown in initateImmunizationHistor");
            throw e;
        }
    }

    public void updateImmunizationHistory(Immunizations imunizationFromGUI) throws Exception {
        imunizationFromGUI.setPatientID(historyOfPatient.getPatientID());
        immunizationHolder.updateData(imunizationFromGUI);
        initiateImmunizationHistory();
    }

    public void addImmunizationHistory(Immunizations immunizationsFromGUI) throws Exception {
        immunizationsFromGUI.setPatientID(historyOfPatient.getPatientID());
        int nextValue = immunizationHolder.getNextID();
        immunizationsFromGUI.setImmunizationsID(nextValue);
        immunizationHolder.addData(immunizationsFromGUI);
        initiateImmunizationHistory();
    }

    //Occupation
    
     public void initiateOccupationHistory() throws Exception {
        try {
            occupationHolder.populateData(historyOfPatient);
            occupationalHistory = null;
            occupationalHistory = occupationHolder.createArrayList();
        } catch (Exception e) {
            System.err.println("Error thrown in initateOccupationHistor");
            throw e;
        }
    }

    public void updateOccupationHistory(Occupation occupationFromGui) throws Exception {
        occupationFromGui.setPatientID(historyOfPatient.getPatientID());
        occupationHolder.updateData(occupationFromGui);
        initiateOccupationHistory();
    }

    public void addOccupationHistory(Occupation occupationFromGUI) throws Exception {
        occupationFromGUI.setPatientID(historyOfPatient.getPatientID());
        int nextValue = occupationHolder.getNextID();
        occupationFromGUI.setOccupationalID(nextValue);
        occupationHolder.addData(occupationFromGUI);
        initiateOccupationHistory();
    }
    
    //General
    
    public void initiateGeneralHistory() throws Exception {
        try {
            generalHistoryHolder.populateData(historyOfPatient);
            generalHistory = null;
            generalHistory = generalHistoryHolder.createGeneralHistory();
        } catch (Exception e) {
            System.err.println("Error thrown in initateGeneralHistory");
            throw e;
        }
    }

    public void updateGeneralHistory(General generalFromGUI) throws Exception {
        generalFromGUI.setPatientid(historyOfPatient.getPatientID());
        generalHistoryHolder.updateData(generalFromGUI);
        initiateOccupationHistory();
    }

    public void addGenearlHistory(General generalFromGUI) throws Exception {
        generalFromGUI.setPatientid(historyOfPatient.getPatientID());
        int nextValue = generalHistoryHolder.getNextID();
        generalFromGUI.setGeneralmedicalhistoryid(nextValue);
        generalHistoryHolder.addData(generalFromGUI);
        initiateOccupationHistory();
    }
    
    //Illness
    public void initiateIllnessHistory() throws Exception {
        try {
            illnessHolder.populateData(historyOfPatient);
            illnessHistory = null;
            illnessHistory = illnessHolder.createArrayList();
        } catch (Exception e) {
            System.err.println("Error thrown in initateIllnessHistor");
            throw e;
        }
    }

    public void updateIllnessHistory(Illness illnessFromGui) throws Exception {
        illnessFromGui.setPatientid(historyOfPatient.getPatientID());
        illnessHolder.updateData(illnessFromGui);
        initiateIllnessHistory();
    }

    public void addIllnessHistory(Illness illnessFromGUI) throws Exception {
        illnessFromGUI.setPatientid(historyOfPatient.getPatientID());
        int nextValue = illnessHolder.getNextID();
        illnessFromGUI.setIllnessid(nextValue);
        illnessHolder.addData(illnessFromGUI);
        initiateIllnessHistory();
    }
}
