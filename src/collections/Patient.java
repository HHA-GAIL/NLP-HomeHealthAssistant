/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;
import Interface.PatientMeta.*;
/**
 *
 * @author Brian
 */
public class Patient {
    
    private final GeneralInformation generalInformationHolder = new GeneralInformation();
    private GeneralInformation generalInformation = new GeneralInformation();

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }
    
    public boolean firstProgramUse() throws Exception{
        try {
            return generalInformationHolder.fristUse();
        } catch (Exception e) {
            throw e;
        }        
    }

    public Patient() throws Exception{
        initiateGeneralInformation();
    }
    
    private void initiateGeneralInformation() throws Exception{
        generalInformationHolder.populateData();
        generalInformation = generalInformationHolder.populateFromResultSet(1);
    }
   
}
