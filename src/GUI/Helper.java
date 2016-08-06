/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Frame;
import javax.swing.*;

/**
 *
 * @author Brian
 */
public class Helper {
    //for methods to create dialog boxes ect...

    /**
     * Create a normal message box with an OK button.
     *
     * @param message the message you want to display
     */
    protected static void createDialogMessage(String message) {
        JOptionPane.showMessageDialog(createDesiredFrame(), message);
    }

    /**
     * Create a warning message box with an OK button
     *
     * @param message the message you want to display
     */
    protected static void createDialogWarning(String message) {
        JOptionPane.showMessageDialog(createDesiredFrame(), message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * create an error message box with an OK button
     *
     * @param message the message you want to display
     */
    protected static void createDialogError(String message) {
        JOptionPane.showMessageDialog(createDesiredFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Creates a frame with desired attributes for dialog boxes
     *
     * @return frame with attributes in use with message dialog.
     */
    private static Frame createDesiredFrame() {
        Frame controledFrame = new Frame();
        controledFrame.setAlwaysOnTop(true);
        return controledFrame;
    }
    
    protected static final void addInternalFrame(JDesktopPane desktopPane, JInternalFrame internalFrame){
        desktopPane.add(internalFrame);
        internalFrame.show();
    }
    protected static final String askQuestionToTheUser(String question){
        return JOptionPane.showInputDialog(createDesiredFrame(), question);
    }
}
