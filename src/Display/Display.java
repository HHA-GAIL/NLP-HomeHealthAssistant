/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.util.regex.*;

/**
 *
 * @author Brian
 */
public interface Display {
    
    /**
     *
     * @param regex
     * @param toVerify
     * @param errorMessage
     * @return
     * @throws Exception
     */
    static public boolean validate(String regex, String toVerify, String errorMessage) throws Exception{
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(toVerify);
            if (matcher.find()) {
                return true;
            } else {
                Exception badData = new Exception(errorMessage);
                throw badData;
            }
        } catch (Exception e) {
            throw e;
        }
    };
}
