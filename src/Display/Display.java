/*
This is the interface class for all display classes which are used in building
a health history database. The display classes allow for validation of incoming
data according to the regex provided by upstream code.

Note--

Currently not fully implimented 
 */
package Display;

import java.util.regex.*;

/**
 *
 * @author Brian
 */
public interface Display {
    
    /**
     * General method to provide validation
     * @param regex Regular expression used in validation.
     * @param toVerify the string to be validated
     * @param errorMessage custom error message to be displayed
     * @return True if validation successful
     * @throws Exception returns on invalid validation, returns custom error message
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
