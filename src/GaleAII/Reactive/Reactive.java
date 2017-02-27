/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Reactive;

import GaleAII.Datastructure.Cluster;
import GaleAII.Datastructure.Decision;
import GaleAII.Datastructure.Node;
import GaleAII.Language.Sentence;

/**
 *
 * @author Brian Miller
 */
public abstract class Reactive implements Runnable{
    
    protected Cluster cluster;
    protected GaleAII.Gale gale;
    protected Node currentNode;
    protected String nodeAnswer;
    protected String decesionAnswer;
    protected Decision currentDecision;
    boolean found;
    
    
    public Reactive(Cluster cluster, GaleAII.Gale gale) {
        this.cluster = cluster;
        this.gale = gale;
    }
    
    public void runCurrentNode(){
       String listeningType = currentNode.getListeningFor();
       Sentence userResponse = gale.getListen().convertStringToSentence(
                (gale.askQuestion(currentNode.getQuestion())));
       /**
         * Author: Fan Hu
         * add toUpperCase to ignore the spelling mistake
         */
        switch (listeningType) {
            case "BINARY":
                if (userResponse.getFullSentence().toUpperCase().equals("YES")) {
                    nodeAnswer = "YES";
                    decesionAnswer = "YES";
                } else {
                    nodeAnswer = "NO";
                    decesionAnswer = "NO";
                }
                break;
            case "BOOLEAN":
                if (userResponse.getFullSentence().toUpperCase().equals("YES")) {
                    nodeAnswer = "YES";
                    decesionAnswer = "FOUND";
                } else {
                    nodeAnswer = "NO";
                    decesionAnswer = "FOUND";
                }
                break;
            case "ANSWER":
                nodeAnswer="";
                nodeAnswer = userResponse.getFullSentence();
                decesionAnswer = userResponse.getFullSentence();
                break;
            default:
                try {
                    nodeAnswer = userResponse.mentions(listeningType).get(0);
                } catch (Exception e) {
                }
                found = (nodeAnswer != null);
                if (found) {
                    decesionAnswer = "FOUND";
                } else {
                    runCurrentNode();
                }
                break;
        }
        runEvent(currentNode.getEvent());
    }
    
    public abstract void runEvent(int eventID);
    
    public abstract void runDecision(int eventID);
}
