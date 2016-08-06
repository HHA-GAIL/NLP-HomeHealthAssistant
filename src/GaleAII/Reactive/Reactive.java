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
        Sentence userResponse = new Sentence(gale.askQuestion(currentNode.getQuestion()));
        switch (listeningType){
            case "BOOLEAN":
                if (userResponse.getFullSentence().equals("Yes")) {
                    nodeAnswer = "YES";
                    decesionAnswer = "YES";
                }else{
                    nodeAnswer = "NO";
                    decesionAnswer = "NO";
                }
                break;
            default:
                nodeAnswer = userResponse.mentions(listeningType).get(0);
                found = (nodeAnswer != null);
                if (found) {
                    decesionAnswer = "FOUND";
                }else{
                    runCurrentNode();
                }
        }
        runEvent(currentNode.getEvent());
    }
    
    public abstract void runEvent(int eventID);
    
    public abstract void runDecision(int eventID);
}
