/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII;

import GUI.healthCareAIFullMDIParent;
import GaleAII.Core.*;
import GaleAII.Datastructure.*;
import GaleAII.Proactive.CheckVitals;

/**
 *
 * @author Brian Miller
 */
public class Gale {

    Listen listen;
    Speak speak;
    NeuralMap neuralMap;
    healthCareAIFullMDIParent primaryForm;

    public Gale() throws Exception {
        try {
            speak = new Speak(Speak.methodOfCommunication.Text);
            listen = new Listen(speak);
            neuralMap = new NeuralMap();
            //startProactiveThreads();
        } catch (Exception e) {
            throw e;
        }
    }

    private void startProactiveThreads() {
        try {
            //Check vitals proactive activity
            CheckVitals checkVitals = new CheckVitals(neuralMap.getClusterByName("Vital ProActive"));
            Thread checkVitalsThread;
            checkVitalsThread = new Thread(checkVitals);
        } catch (Exception e) {
        }
    }
    
    public Cluster getClusterByName(String name){
        Cluster cluster = null;
        try {
          cluster = neuralMap.getClusterByName(name);  
        } catch (Exception e) {
        }
        return cluster;
    }
    
    public void speak(String stringToSpeak){
        speak.askQuestionToUser(stringToSpeak);
    }
    
    public String askQuestion(String stringToAsk){
        return speak.askQuestionToUser(stringToAsk);
    }

    public Listen getListen() {
        return listen;
    }

    public Speak getSpeak() {
        return speak;
    }
    
    
}
