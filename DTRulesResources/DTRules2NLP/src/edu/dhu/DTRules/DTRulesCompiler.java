package edu.dhu.DTRules;

import com.dtrules.compiler.excel.util.Excel2XML;


public class DTRulesCompiler {

	//Allowed to be modified by outsiders
	public static final String BasePath = System.getProperty("user.dir")+"/DTRules/";
	public static final String LayoutRelativePath = "./";
	public static final String ConfigFileName = "DTRules.xml";
	
	/**
	 * used to compile the relative files of the decison table
	 * @param basePath - the base dir of all. Default:./DTRules/
	 * @param configFileName - the config file name. Default:DTRules.xml
	 * @param rulesName - the RuleSet's name. need to be inputed
	 * @param layoutRelativePath - the dir of reposity, used to check. Default:./
	 * @param mapping - could be null, used to make sure the initial attributes. need to be inputed
	 * @return true if success; false if fail
	 */
	public static boolean Compile(String basePath,String configFileName,String rulesName,
			String layoutRelativePath, String[] mapping) throws Exception{
		try {
            System.out.println(basePath);
            if(mapping == null)
            {
                Excel2XML e2x = new Excel2XML(basePath, configFileName,rulesName);
        		e2x.compileRuleSet(basePath,configFileName,rulesName,layoutRelativePath,null,5);
            }
            else
            {
            	Excel2XML e2x = new Excel2XML(basePath, configFileName,rulesName);
        		e2x.compileRuleSet(basePath,configFileName,rulesName,layoutRelativePath,mapping,5);
            }
            return true;
        } catch ( Exception ex ) {
            System.out.println("Failed to convert the Excel files");
            ex.printStackTrace();
            throw ex;
        }
	}
	
}
