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
import javax.swing.*;
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
       /**
         * @author: Fan Hu
         * @function: add toUpperCase to avoid the mistake when recognizing the family relationship
         * @date: 03/27/2017
         */
       String question=currentNode.getQuestion();
       String answer=gale.askQuestion(question);
       Sentence userResponse = gale.getListen().convertStringToSentence(
               answer.substring(0,1).toUpperCase()+answer.substring(1));
       /**
         * @author: Fan Hu
         * @function: add toUpperCase to ignore the spelling mistake, and 
         *             add throw exception function to give some specific suggestions
         * @date: 03/27/2017
         */
       switch (listeningType) {
            case "BINARY":
                try{
                    if (userResponse.getFullSentence().toUpperCase().equals("YES")) {
                        nodeAnswer = "YES";
                        decesionAnswer = "YES";
                    } else if(userResponse.getFullSentence().toUpperCase().equals("NO")){
                        nodeAnswer = "NO";
                        decesionAnswer = "NO";
                    }else
                        throw new WrongAnswerException("The answer is wrong");

                }catch (WrongAnswerException wae) {
                    JOptionPane.showMessageDialog(null, "Please input \"Yes\" or \"No\"", "Input Error", JOptionPane.ERROR_MESSAGE);
                    runCurrentNode();
                    }
                break;

            case "BOOLEAN":
                try{
           switch (userResponse.getFullSentence().toUpperCase()) {
               case "YES":
                   nodeAnswer = "YES";
                   decesionAnswer = "FOUND";
                   break;
               case "NO":
                   nodeAnswer = "NO";
                   decesionAnswer = "FOUND";
                   break;
               default:
                   throw new WrongAnswerException("The answer is wrong");
           }
                }catch (WrongAnswerException wae){
                    JOptionPane.showMessageDialog(null, "Please input \"Yes\" or \"No\"", "Input Error", JOptionPane.ERROR_MESSAGE);
                    runCurrentNode();
                }

                break;
            case "ANSWER":
                nodeAnswer = userResponse.getFullSentence();
                decesionAnswer = userResponse.getFullSentence();
                break;
            default:
                try {
                    nodeAnswer = userResponse.mentions(listeningType).get(0);
                    found = (nodeAnswer != null);
                    if (found) {
                        decesionAnswer = "FOUND";
                    } else {
                        runCurrentNode();
                    }

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Catch the IndexOutOfBoundsException in Reactive");
                    switch (question){

                        case "What is your family members name?":
                            JOptionPane.showMessageDialog(null, "The first character should be capital", "Input Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        case "What is your relation to them?":
                            JOptionPane.showMessageDialog(null, "Only support \nMother\n" +
                                    "Father\n" +
                                    "Sister\n" +
                                    "Brother\n" +
                                    "Grandmother\n" +
                                    "Maternal Grandmother\n" +
                                    "Paternal Grandmother\n" +
                                    "Maternal Grandfather\n" +
                                    "Paternal Grandfather\n" +
                                    "Grandfather\n" +
                                    "Cousin\n" +
                                    "Uncle\n" +
                                    "Aunt", "Input Error", JOptionPane.ERROR_MESSAGE);
                            break;

                        case "What Major disorders do they have?":
                            JOptionPane.showMessageDialog(null, "The disorder you input cannot be recognised, please try another one", "Input Error", JOptionPane.ERROR_MESSAGE);
                            break;

                        case "What specific disorders do they have?":
                            JOptionPane.showMessageDialog(null, "The disorder you input cannot be recognised, please try another one", "Input Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    runCurrentNode();
                }

                break;
        }
        runEvent(currentNode.getEvent());
    }
    
    public abstract void runEvent(int eventID);
    
    public abstract void runDecision(int eventID);
    class WrongAnswerException extends Exception{
        private String message;

        WrongAnswerException(String message){
            super(message);
        }
    }
}
