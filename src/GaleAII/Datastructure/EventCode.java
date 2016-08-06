/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Datastructure;

/**
 *
 * @author Brian Miller
 */
public class EventCode {
    private int primary;
    private int secondary;

    public EventCode(String eventCode) {
        String[] codes = eventCode.split(";");
        primary = Integer.parseInt(codes[0]);
        secondary = Integer.parseInt(codes[1]);
    }

    public int getPrimary() {
        return primary;
    }

    public int getSecondary() {
        return secondary;
    }
    
    
    
}
