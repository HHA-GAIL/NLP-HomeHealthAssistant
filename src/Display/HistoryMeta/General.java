/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display.HistoryMeta;

import java.sql.Date;

/**
 *
 * @author Brian
 */
public abstract class General extends Temp.HistoryMeta.General implements History{

    /**
     *
     * @param ega
     */
    @Override
    public void setEga(double ega) {
        super.setEga(ega);
    }

    /**
     *
     * @param hospitalofdelivery
     */
    @Override
    public void setHospitalofdelivery(String hospitalofdelivery) {
        super.setHospitalofdelivery(hospitalofdelivery);
    }

    /**
     *
     * @param onbcpatconceptionno
     */
    @Override
    public void setOnbcpatconceptionno(byte onbcpatconceptionno) {
        super.setOnbcpatconceptionno(onbcpatconceptionno);
    }

    /**
     *
     * @param onbcpatconceptionyes
     */
    @Override
    public void setOnbcpatconceptionyes(byte onbcpatconceptionyes) {
        super.setOnbcpatconceptionyes(onbcpatconceptionyes);
    }

    /**
     *
     * @param menarcheageofonset
     */
    @Override
    public void setMenarcheageofonset(int menarcheageofonset) {
        super.setMenarcheageofonset(menarcheageofonset);
    }

    /**
     *
     * @param mensesfreq
     */
    @Override
    public void setMensesfreq(int mensesfreq) {
        super.setMensesfreq(mensesfreq);
    }

    /**
     *
     * @param mensespriordate
     */
    @Override
    public void setMensespriordate(Date mensespriordate) {
        super.setMensespriordate(mensespriordate);
    }

    /**
     *
     * @param mensesmonthlyno
     */
    @Override
    public void setMensesmonthlyno(byte mensesmonthlyno) {
        super.setMensesmonthlyno(mensesmonthlyno);
    }

    /**
     *
     * @param mensesmonthlyyes
     */
    @Override
    public void setMensesmonthlyyes(byte mensesmonthlyyes) {
        super.setMensesmonthlyyes(mensesmonthlyyes);
    }

    /**
     *
     * @param menstrualamtnormalno
     */
    @Override
    public void setMenstrualamtnormalno(byte menstrualamtnormalno) {
        super.setMenstrualamtnormalno(menstrualamtnormalno);
    }

    /**
     *
     * @param menstrualamtnormalyes
     */
    @Override
    public void setMenstrualamtnormalyes(byte menstrualamtnormalyes) {
        super.setMenstrualamtnormalyes(menstrualamtnormalyes);
    }

    /**
     *
     * @param lmpdateapprox
     */
    @Override
    public void setLmpdateapprox(byte lmpdateapprox) {
        super.setLmpdateapprox(lmpdateapprox);
    }

    /**
     *
     * @param lmpestmethod
     */
    @Override
    public void setLmpestmethod(String lmpestmethod) {
        super.setLmpestmethod(lmpestmethod);
    }

    /**
     *
     * @param numberofpregnancies
     */
    @Override
    public void setNumberofpregnancies(int numberofpregnancies) {
        super.setNumberofpregnancies(numberofpregnancies);
    }

    /**
     *
     * @param numberofchildren
     */
    @Override
    public void setNumberofchildren(int numberofchildren) {
        super.setNumberofchildren(numberofchildren);
    }

    /**
     *
     * @param edc
     */
    @Override
    public void setEdc(Date edc) {
        super.setEdc(edc);
    }

    /**
     *
     * @param pregnancyduedate
     */
    @Override
    public void setPregnancyduedate(Date pregnancyduedate) {
        super.setPregnancyduedate(pregnancyduedate);
    }

    /**
     *
     * @param pregnant
     */
    @Override
    public void setPregnant(byte pregnant) {
        super.setPregnant(pregnant);
    }

    /**
     *
     * @param lmp
     */
    @Override
    public void setLmp(byte lmp) {
        super.setLmp(lmp);
    }

    /**
     *
     * @param lmpstatus
     */
    @Override
    public void setLmpstatus(String lmpstatus) {
        super.setLmpstatus(lmpstatus);
    }

    /**
     *
     * @param lmpdate
     */
    @Override
    public void setLmpdate(Date lmpdate) {
        super.setLmpdate(lmpdate);
    }

    /**
     *
     * @param deleted
     */
    @Override
    public void setDeleted(byte deleted) {
        super.setDeleted(deleted);
    }

    /**
     *
     * @param unabletoobtainhxreason
     */
    @Override
    public void setUnabletoobtainhxreason(String unabletoobtainhxreason) {
        super.setUnabletoobtainhxreason(unabletoobtainhxreason);
    }

    /**
     *
     * @param hxconfirmedbyhcp
     */
    @Override
    public void setHxconfirmedbyhcp(byte hxconfirmedbyhcp) {
        super.setHxconfirmedbyhcp(hxconfirmedbyhcp);
    }

    /**
     *
     * @param hxobtainedby
     */
    @Override
    public void setHxobtainedby(String hxobtainedby) {
        super.setHxobtainedby(hxobtainedby);
    }

    /**
     *
     * @param medicalhistorynotes
     */
    @Override
    public void setMedicalhistorynotes(String medicalhistorynotes) {
        super.setMedicalhistorynotes(medicalhistorynotes);
    }

    /**
     *
     * @param rh
     */
    @Override
    public void setRh(String rh) {
        super.setRh(rh);
    }

    /**
     *
     * @param bloodtype
     */
    @Override
    public void setBloodtype(String bloodtype) {
        super.setBloodtype(bloodtype);
    }

    /**
     *
     * @param travelhrf
     */
    @Override
    public void setTravelhrf(byte travelhrf) {
        super.setTravelhrf(travelhrf);
    }

    /**
     *
     * @param travel
     */
    @Override
    public void setTravel(String travel) {
        super.setTravel(travel);
    }

    /**
     *
     * @param diethrf
     */
    @Override
    public void setDiethrf(byte diethrf) {
        super.setDiethrf(diethrf);
    }

    /**
     *
     * @param dietary
     */
    @Override
    public void setDietary(String dietary) {
        super.setDietary(dietary);
    }

    /**
     *
     * @param drugduration
     */
    @Override
    public void setDrugduration(String drugduration) {
        super.setDrugduration(drugduration);
    }

    /**
     *
     * @param drugtype
     */
    @Override
    public void setDrugtype(String drugtype) {
        super.setDrugtype(drugtype);
    }

    /**
     *
     * @param drughrf
     */
    @Override
    public void setDrughrf(byte drughrf) {
        super.setDrughrf(drughrf);
    }

    /**
     *
     * @param drug
     */
    @Override
    public void setDrug(String drug) {
        super.setDrug(drug);
    }

    /**
     *
     * @param alcoholduration
     */
    @Override
    public void setAlcoholduration(String alcoholduration) {
        super.setAlcoholduration(alcoholduration);
    }

    /**
     *
     * @param alcoholquantity
     */
    @Override
    public void setAlcoholquantity(String alcoholquantity) {
        super.setAlcoholquantity(alcoholquantity);
    }

    /**
     *
     * @param alcoholhrf
     */
    @Override
    public void setAlcoholhrf(byte alcoholhrf) {
        super.setAlcoholhrf(alcoholhrf);
    }

    /**
     *
     * @param alcohol
     */
    @Override
    public void setAlcohol(String alcohol) {
        super.setAlcohol(alcohol);
    }

    /**
     *
     * @param tobaccoduraton
     */
    @Override
    public void setTobaccoduraton(String tobaccoduraton) {
        super.setTobaccoduraton(tobaccoduraton);
    }

    /**
     *
     * @param tobaccoquantity
     */
    @Override
    public void setTobaccoquantity(String tobaccoquantity) {
        super.setTobaccoquantity(tobaccoquantity);
    }

    /**
     *
     * @param tobaccohrf
     */
    @Override
    public void setTobaccohrf(byte tobaccohrf) {
        super.setTobaccohrf(tobaccohrf);
    }

    /**
     *
     * @param tobacco
     */
    @Override
    public void setTobacco(String tobacco) {
        super.setTobacco(tobacco);
    }

    /**
     *
     * @param behavioralhistory
     */
    @Override
    public void setBehavioralhistory(String behavioralhistory) {
        super.setBehavioralhistory(behavioralhistory);
    }

    /**
     *
     * @param pregnancies
     */
    @Override
    public void setPregnancies(String pregnancies) {
        super.setPregnancies(pregnancies);
    }

    /**
     *
     * @param growthanddevelopment
     */
    @Override
    public void setGrowthanddevelopment(String growthanddevelopment) {
        super.setGrowthanddevelopment(growthanddevelopment);
    }

    /**
     *
     * @param education
     */
    @Override
    public void setEducation(String education) {
        super.setEducation(education);
    }

    /**
     *
     * @param maritalstatus
     */
    @Override
    public void setMaritalstatus(String maritalstatus) {
        super.setMaritalstatus(maritalstatus);
    }

    /**
     *
     * @param patientid
     */
    @Override
    public void setPatientid(int patientid) {
        super.setPatientid(patientid);
    }

    /**
     *
     * @param generalmedicalhistoryid
     */
    @Override
    public void setGeneralmedicalhistoryid(int generalmedicalhistoryid) {
        super.setGeneralmedicalhistoryid(generalmedicalhistoryid);
    }
    
}
