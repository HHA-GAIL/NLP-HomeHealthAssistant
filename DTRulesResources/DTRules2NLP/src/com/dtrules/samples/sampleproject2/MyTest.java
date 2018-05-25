package com.dtrules.samples.sampleproject2;

import java.io.PrintStream;

import com.dtrules.entity.IREntity;
import com.dtrules.entity.REntity;
import com.dtrules.infrastructure.RulesException;
import com.dtrules.interpreter.IRObject;
import com.dtrules.interpreter.RArray;
import com.dtrules.interpreter.RString;
import com.dtrules.session.IRSession;
import com.dtrules.testsupport.ATestHarness;
import com.dtrules.testsupport.ITestHarness;
import com.dtrules.xmlparser.XMLPrinter;

public class MyTest extends ATestHarness {

	public boolean  Trace()                   { return true;                            }
    public boolean  Console()                 { return true;                            }
    public String   getPath()                 { return CompileSampleProject2.path;      }
    public String   getRulesDirectoryPath()   { return getPath()+"xml/";                }
    public String   getRuleSetName()          { return "myprojecttest";                }
    public String   getDecisionTableName()    { return "Test_Patient";           }
    public String   getRulesDirectoryFile()   { return "DTRules.xml";                   }
    public String   getTestDirectory()		  { return getPath()+"mytest/";             }
	
    public static void main(String[] args) {
    	MyTest mt = new MyTest();
        ITestHarness t = mt;
        mt.prtRelativeMsg();
        t.runTests();
    }
    
    private void prtRelativeMsg(){
    	System.out.println(getPath());
    	System.out.println(getRulesDirectoryPath());
    }
    
    public void printReport(int runNumber, IRSession session, PrintStream _out) throws RulesException {
//        RString result = session.getState().find("patient.result.resultMessage").rStringValue();
        IREntity presult = session.getState().find("patient.patientResult").rEntityValue();
        int code = presult.get("resultCode").intValue();
        String message = presult.get("resultMessage").stringValue();
        System.out.println(code+"---->"+message);
//        System.out.println(result.toString());
    }
	
}
