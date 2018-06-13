package edu.dhu.DTRules;

import com.dtrules.compiler.excel.util.Excel2XML;
import edu.dhu.DTRules.entities.ExaminResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DTRulesCompiler {

	//Allowed to be modified by outsiders
	public static final String BasePath = System.getProperty("user.dir")+"/DTRules/";
	public static final String LayoutRelativePath = "./";
	public static final String ConfigFileName = "DTRules.xml";
        public static final String RuleName = "TheDecisionTable";
        
        private String workingPath = System.getProperty("user.dir")+"/DTRules/";
	private static DTRulesCompiler compiler = null;
        
        public static DTRulesCompiler getInstance(){
            if(compiler == null)
                compiler = new DTRulesCompiler();
            return compiler;
        }
        
	/**
	 * used to compile the relative files of the decison table
	 * @param basePath - the base dir of all. Default:./DTRules/
	 * @param configFileName - the config file name. Default:DTRules.xml
	 * @param rulesName - the RuleSet's name. need to be inputed
	 * @param layoutRelativePath - the dir of reposity, used to check. Default:./
	 * @param mapping - could be null, used to make sure the initial attributes. need to be inputed
	 * @return true if success; false if fail
	 */
	public ExaminResult Compile(String[] mapping) throws Exception{
		try {
                    String check = checkForNecessaryDirsOrFiles();
                    System.out.println("Compiling..."+workingPath);
                    if(check.contains("<--!MISSINGFILES!-->")){
                        ExaminResult er = new ExaminResult();
                        er.setStatus(ExaminResult.FAIL);
                        er.setMessage(check);
                        return er;
                    }
                    if(mapping == null)
                    {
                        Excel2XML e2x = new Excel2XML(workingPath, ConfigFileName, RuleName);
                                e2x.compileRuleSet(workingPath,ConfigFileName,RuleName,workingPath,null,5);
                    }
                    else
                    {
                        Excel2XML e2x = new Excel2XML(workingPath, ConfigFileName, RuleName);
                                e2x.compileRuleSet(workingPath,ConfigFileName,RuleName,workingPath,mapping,5);
                    }
                    ExaminResult er = new ExaminResult();
                    er.setStatus(ExaminResult.SUCC);
                    er.setMessage(readXMLFile(workingPath + "xml/TheDecisionTable_dt.xml"));
                    return er;
                } catch ( Exception ex ) {
                    System.out.println("Failed to convert the Excel files");
                    ex.printStackTrace();
                    throw ex;
                }
	}

    /**
     * @return the workingPath
     */
    public String getWorkingPath() {
        return workingPath;
    }

    /**
     * @param workingPath the workingPath to set
     */
    public void setWorkingPath(String workingPath) {
        this.workingPath = workingPath;
    }

    private String checkForNecessaryDirsOrFiles() {
        StringBuilder sb = new StringBuilder();
        boolean can = true;
        File file = null;
        String tmpWorkingPath = workingPath;   
        file = new File(tmpWorkingPath);
        file.mkdirs();
        file = new File(tmpWorkingPath + "DecisionTables/DevDT");
        file.mkdirs();
        file = new File(tmpWorkingPath + ConfigFileName);
        if(!file.exists())
        {
            sb.append("Missing " + tmpWorkingPath + "DTRules.xml\n");
            can = false;
        }
        file = new File(tmpWorkingPath + "DevEDD/Dev_edd.xls");
        if(!file.exists())
        {
            sb.append("Missing " + tmpWorkingPath + "DevEDD/Dev_edd.xls\n");
            can = false;
        }
        file = new File(tmpWorkingPath + "xml/Dev_map.xml");
        if(!file.exists())
        {
            sb.append("Missing " + tmpWorkingPath + "xml/Dev_map.xml\n");
            can = false;
        }
        if(!can)
            sb.append("<--!MISSINGFILES!-->");
        else
            sb.append("<--!OK!-->");
        return sb.toString();
    }
    
    private String readXMLFile(String FileName) throws FileNotFoundException, IOException{
        File dtrules = new File(FileName);
        FileInputStream fis = new FileInputStream(dtrules);
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        return new String(content,"utf-8");
    }
	
}
