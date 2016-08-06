/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Core;

import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Brian Miller
 */
public class Speak {

    public enum methodOfCommunication {
        Text, English
    }

    methodOfCommunication communicationMethod;

    public Speak(methodOfCommunication communicationMethod) {
        this.communicationMethod = communicationMethod;
    }

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
