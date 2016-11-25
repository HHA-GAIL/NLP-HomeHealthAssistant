/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Core;

import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 * At the moment Gail speaks using J-Option panes. These methods are helper methods
 * allowing the creation of J-Option panes along with what wants to be said.
 * There is a method for allowing multiple types of communication, when creating the speak
 * class you pass an enumeration option to the class. As mentioned before the only
 * viable option currently is the Text option.
 * @author Brian Miller
 */
public class Speak {
    /**
     * A Enumeration allowing for multiple different types of speech, for later
     * use simply add the method you want to use and add each option for the switch
     * methods below.
     */
    public enum methodOfCommunication {
        Text, English
    }

    methodOfCommunication communicationMethod;
    /**
     * The constructor for the speak class, has you choose which method of communication
     * to use
     * @param communicationMethod 
     */
    public Speak(methodOfCommunication communicationMethod) {
        this.communicationMethod = communicationMethod;
    }
    /**
     * Asks a question to the user. Depending on the method of communication you
     * chose to use originally when creating the class.
     * @param questoinToAsk
     * @return 
     */
    public String askQuestionToUser(String questoinToAsk) {
        String responseString = null;
        switch (communicationMethod) {
            case Text:
                responseString = askQuestionToUserTextMethod(questoinToAsk);
                break;
        }
        return responseString;
    }
    /**
     * Returns the user input from a posed question. Returns a normal string.
     * @param questionToAsk question you want to ask the user via text method
     * @return string of user response. 
     */
    private String askQuestionToUserTextMethod(String questionToAsk) {
        String response = JOptionPane.showInputDialog(createDesiredFrame(), questionToAsk);
        
        return response;
    }

    /**
     * This creates a frame to be used by JOptionPane. The frame will always be
     * on top.
     *
     * @return frame with the property set always on top to be true
     */
    private Frame createDesiredFrame() {
        Frame controledFrame = new Frame();
        controledFrame.setAlwaysOnTop(true);
        return controledFrame;
    }
}
