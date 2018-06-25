/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleDTRules.Tools;

import edu.dhu.DTRules.entities.ExaminResult;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author HASEE
 */
public class DTRulesXML {
    
    public static final String BASEPATH = System.getProperty("user.dir")+"/DTRules/";
    public static final String XMLDIR = "xml";
    public static final String WORKINGDIR = "workingDir";
    public static final String EDDFOLDER = "DevEDD";
    public static final String XMLENTITY = "Dev_edd.xml";
    public static final String XMLMAP = "Dev_map.xml";
    public static final String DTName = "TheDecisionTable";
    public static final String XMLDT = DTName + "_dt.xml";
    public static final String DTFolder = "DecisionTables/DevDT";
    
    private StringBuilder sb = new StringBuilder();
    
    private static DTRulesXML instance = null;
    
    public static DTRulesXML getInstance(){
        if(instance == null)
            instance = new DTRulesXML();
        return instance;
    }
    
    public String getRuleSetString(String RuleSetName, String XMLDir, String WorkingDir, 
            String DTFolder, String EDDFolder, 
            String XMLEntity, String XMLDT, String XMLMap){
        sb.delete(0, sb.length());
        sb.append("<RuleSet name=\"").append(RuleSetName).append("\" source=\"file\"  >\r\n");
        sb.append("<RuleSetFilePath>/").append(XMLDir).append("</RuleSetFilePath>\r\n");
        sb.append("<WorkingDirectory>/").append(WorkingDir).append("</WorkingDirectory>\r\n");
        sb.append("<DTExcelFolder>/").append(DTFolder).append("/</DTExcelFolder>\r\n");
        sb.append("<EDDExcelFolder>/").append(EDDFolder).append("/</EDDExcelFolder>\r\n");
        sb.append("<Entities        name=\"").append(XMLEntity).append("\" />\r\n");
        sb.append("<Decisiontables  name=\"").append(XMLDT).append("\"  />\r\n");
        sb.append("<Map             name=\"").append(XMLMap).append("\" />\r\n");
        sb.append("</RuleSet>");
        return sb.toString();
    }
    
    /*
    the method used the same edd file, for now...
    */
    public String getRuleSetString(){
//        return getRuleSetString(DTName, XMLDIR, WORKINGDIR, 
//                "DecisionTables/"+DTName, EDDFOLDER,
//                XMLENTITY, DTName+"_dt.xml", XMLMAP);
        return getRuleSetString(this.DTName, XMLDIR, WORKINGDIR, 
                DTFolder, EDDFOLDER,
                XMLENTITY, XMLDT, XMLMAP);
    }
    
    /**
     to check if there exists the same DTRules or if there exists the DTRules.xml
     @return returns -1 means no DTRules.xml; 
     @return returns 0 means no same RuleSet; 
     @return returns means there exists same RuleSet.
    **/
    public int checkDTRules(String DTName) throws FileNotFoundException, IOException {
        //1.check for xml file
        File dtrules = new File(BASEPATH + "DTRules.xml");
        if(!dtrules.exists())
            return -1;
        int result = 0;
        FileInputStream fis = new FileInputStream(dtrules);
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        String tmp = new String(content,"utf-8");
        tmp = tmp.replaceAll("\\s", "");
        if(tmp.contains("<RuleSetname=\""+DTName+"\"source=\"file\">")){
            result = 1;
        }
        return result;
    }
    
    /**
     * to create a new DTRules.xml with the DTRulesString
     * @param ResultString--DTRulesString
     * @throws IOException 
     */
    public String createDTRules(String ResultString) throws IOException{
        sb.delete(0, sb.length());
        sb.append("<DTRules>\r\n<compileralias name=\"EL\">com.dtrules.compiler.el.EL</compileralias>\r\n<compiler>EL</compiler>\r\n");
        sb.append(ResultString);
        sb.append("</DTRules>\r\n");
        File dtrules = new File(BASEPATH + "DTRules.xml");
        dtrules.deleteOnExit();
        dtrules.createNewFile();
        FileOutputStream fos = new FileOutputStream(dtrules);
        fos.write(sb.toString().getBytes("utf-8"));
        fos.close();
        return sb.toString();
    }

    public void appendDTRules(String RuleSetString) throws FileNotFoundException, IOException {
        sb.delete(0, sb.length());
        sb.append(readDTRules());
        sb.insert(sb.lastIndexOf("</RuleSet>") + 10, "\r\n"+RuleSetString);
        System.out.println(sb.toString());
        writeDTRules(sb.toString());
    }

    /**
     * used to replace the same name RuleSet
     * The RuleSet name is the name of xls file
     * @param RuleSetString
     * @param RuleName
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
    public void replaceDTRules(String RuleSetString, String RuleName) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        //use xml parser
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(BASEPATH + "DTRules.xml");
        NodeList ruleSets = document.getElementsByTagName("RuleSet");
        for (int i = 0; i < ruleSets.getLength(); i++) {
            Element ruleSet = (Element)ruleSets.item(i);
            //to get name and decide whether it is multi named
            System.out.println(ruleSet.getAttribute("name"));
            if(RuleName.equals(ruleSet.getAttribute("name"))){
                Document targetDocument = builder.parse(BASEPATH + "_TMP_.xml");
                Element targetRuleSet = (Element)targetDocument.getElementsByTagName("RuleSet").item(0);
                NodeList targetNodes = targetRuleSet.getChildNodes();
                //replace the ruleset
                ruleSet.setAttribute("name", RuleName);
                NodeList nodes = ruleSet.getChildNodes();
                ruleSet.getElementsByTagName("RuleSetFilePath").item(0).setTextContent(targetRuleSet.getElementsByTagName("RuleSetFilePath").item(0).getTextContent());
                ruleSet.getElementsByTagName("WorkingDirectory").item(0).setTextContent(targetRuleSet.getElementsByTagName("WorkingDirectory").item(0).getTextContent());
                ruleSet.getElementsByTagName("DTExcelFolder").item(0).setTextContent(targetRuleSet.getElementsByTagName("DTExcelFolder").item(0).getTextContent());
                ruleSet.getElementsByTagName("EDDExcelFolder").item(0).setTextContent(targetRuleSet.getElementsByTagName("EDDExcelFolder").item(0).getTextContent());
                
                Element ele = (Element)ruleSet.getElementsByTagName("Entities").item(0);
                Element targetEle = (Element)targetRuleSet.getElementsByTagName("Entities").item(0);
                ele.setAttribute("name", targetEle.getAttribute("name"));
                
                ele = (Element)ruleSet.getElementsByTagName("Decisiontables").item(0);
                targetEle = (Element)targetRuleSet.getElementsByTagName("Decisiontables").item(0);
                ele.setAttribute("name", targetEle.getAttribute("name"));
                
                ele = (Element)ruleSet.getElementsByTagName("Map").item(0);
                targetEle = (Element)targetRuleSet.getElementsByTagName("Map").item(0);
                ele.setAttribute("name", targetEle.getAttribute("name"));
//                for(int j = 0; j < nodes.getLength(); j++){
//                    Node node = nodes.item(j);
//                    if("RuleSetFilePath".equals(node.getNodeName())){
//                        setTextContent("RuleSetFilePath", node, targetNodes);
//                    }
//                    if("WorkingDirectory".equals(node.getNodeName())){
//                        setTextContent("WorkingDirectory", node, targetNodes);
//                    }
//                    if("DTExcelFolder".equals(node.getNodeName())){
//                        setTextContent("DTExcelFolder", node, targetNodes);
//                    }
//                    if("EDDExcelFolder".equals(node.getNodeName())){
//                        setTextContent("EDDExcelFolder", node, targetNodes);
//                    }
//                    if("Entities".equals(node.getNodeName())){
//                        Element ele = (Element)ruleSet.getElementsByTagName("Entities").item(0);
//                        Element targetEle = (Element)targetRuleSet.getElementsByTagName("Entities").item(0);
//                        ele.setAttribute("name", targetEle.getAttribute("name"));
//                    }
//                    if("Decisiontables".equals(node.getNodeName())){
//                        Element ele = (Element)ruleSet.getElementsByTagName("Decisiontables").item(0);
//                        Element targetEle = (Element)targetRuleSet.getElementsByTagName("Decisiontables").item(0);
//                        ele.setAttribute("name", targetEle.getAttribute("name"));
//                    }
//                    if("Map".equals(node.getNodeName())){
//                        Element ele = (Element)ruleSet.getElementsByTagName("Map").item(0);
//                        Element targetEle = (Element)targetRuleSet.getElementsByTagName("Map").item(0);
//                        ele.setAttribute("name", targetEle.getAttribute("name"));
//                    }
//                }
                TransformerFactory transFactory = TransformerFactory.newInstance();  
                Transformer transformer = transFactory.newTransformer();  
                transformer.setOutputProperty(OutputKeys.INDENT, "Yes");  
                transformer.transform(new DOMSource(document), new StreamResult(BASEPATH + "DTRules.xml"));
                break;
            }
        }
    }

    private String readDTRules() throws FileNotFoundException, IOException {
        return readXMLFile(BASEPATH + "DTRules.xml");
    }

    private void writeDTRules(String DTRulesString) throws FileNotFoundException, IOException {
        File dtrules = new File(BASEPATH + "DTRules.xml");
        FileOutputStream fos = new FileOutputStream(dtrules);
        fos.write(DTRulesString.getBytes("utf-8"));
        fos.close();
    }

    /**
     * used to set the targetNode's TextCpntent to the node's TextContent
     * @param NodeName
     * @param node
     * @param targetNodes 
     */
    private void setTextContent(String NodeName, Node node, NodeList targetNodes) {
        for(int x = 0; x < targetNodes.getLength(); x++){
            if(NodeName.equals(targetNodes.item(x).getNodeName()))
                node.setTextContent(targetNodes.item(x).getTextContent());
        }
    }

    /**
     * Copy the xls file in to the certain dir, use the same pattern of the RuleSetString generate method.
     * as we can see in the getRuleSetString method.
     * @param dtFile
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void copyFileToCertainDir(File dtFile) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(dtFile);
        File dest = new File(BASEPATH + DTFolder);
        dest.mkdirs();
        dest = new File(BASEPATH + DTFolder + "/" + dtFile.getName());
        FileOutputStream fos = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int btRead = 0;
        while((btRead = fis.read(buffer))>0){
            fos.write(buffer, 0, btRead);
        }
        fos.close();
        fis.close();
    }

    /**
     * compile the RuleSet using the RulesName, the RulesName should be in the DTRules.xml first
     * @param RulesName 
     */
    public ExaminResult Compile(File dtfile) throws Exception {
//        com.dtrules.samples.sampleproject2.DemoTesting.main(null);//no problem
//        edu.dhu.DTRules.DTRulesCompiler.Compile(BASEPATH, "DTRules.xml", RulesName, BASEPATH, new String[] {"main"});
        try {
            //delete the files in the certain dir
            File dir = new File(BASEPATH + DTFolder);
            File[] files = dir.listFiles();
            for(File fir : files){
                fir.delete();
            }
            copyFileToCertainDir(dtfile);
            File compilemsgfile = new File(BASEPATH+WORKINGDIR+"/compileMessage.txt");
            FileOutputStream fos = new FileOutputStream(compilemsgfile);
            PrintStream original = System.out;
            System.setOut(new PrintStream(fos));
            ExaminResult er = edu.dhu.DTRules.DTRulesCompiler.getInstance().Compile(new String[] {"main"});
            fos.flush();
            System.setOut(original);
            return er;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * to get the decision tables' name via RuleSet Name, the RuleSet Name shoud be in DTRules.xml first
     * @param ruleName
     * @return the List of decision tables' name
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public List<String> getDecisionTables(String ruleName) throws ParserConfigurationException, SAXException, IOException {
        List<String> result = new LinkedList<>();
        //first to find the dt xml file
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dtDocument = builder.parse(BASEPATH + "_TMP_.xml");
        Element dtElement = (Element)dtDocument.getElementsByTagName("RuleSet").item(0);
        String xmlDir = null;String DTName = null;
        xmlDir = dtElement.getElementsByTagName("RuleSetFilePath").item(0).getTextContent();
        Element ele = (Element)dtElement.getElementsByTagName("Decisiontables").item(0);
        DTName = ele.getAttribute("name");
        
        //to get the document of dt xml
        dtDocument = builder.parse(BASEPATH + xmlDir + "/" + DTName);
        NodeList dtTables = dtDocument.getElementsByTagName("decision_table");
        for(int i = 0; i < dtTables.getLength(); i++){
            dtElement = (Element)dtTables.item(i);
            result.add(dtElement.getElementsByTagName("table_name").item(0).getTextContent());
        }
        return result;
    }

    public void writeTempXmlFile(String RuleSetString) throws FileNotFoundException, IOException {
        //write a temp file for the new RuleSetString
        File dtrules = new File(BASEPATH + "_TMP_.xml");
        dtrules.createNewFile();
        FileOutputStream fos = new FileOutputStream(dtrules);
        fos.write(RuleSetString.getBytes("utf-8"));
        fos.close();
    }

    public void deleteTempXmlFile(){
        File dtrules = new File(BASEPATH + "_TMP_.xml");
        dtrules.delete();
    }

    public String readMapXML(String RuleSetName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dtDocument = builder.parse(BASEPATH + "_TMP_.xml");
        Element dtElement = (Element)dtDocument.getElementsByTagName("RuleSet").item(0);
        String xmlDir = dtElement.getElementsByTagName("RuleSetFilePath").item(0).getTextContent();
        Element ele = (Element)dtElement.getElementsByTagName("Map").item(0);
        String MapName = ele.getAttribute("name");
        return readXMLFile(BASEPATH + xmlDir + "/" + MapName);
    }

    public String readEDDXML(String RuleSetName) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dtDocument = builder.parse(BASEPATH + "_TMP_.xml");
        Element dtElement = (Element)dtDocument.getElementsByTagName("RuleSet").item(0);
        String xmlDir = dtElement.getElementsByTagName("RuleSetFilePath").item(0).getTextContent();
        Element ele = (Element)dtElement.getElementsByTagName("Entities").item(0);
        String EDDName = ele.getAttribute("name");
        return readXMLFile(BASEPATH + xmlDir + "/" + EDDName);
    }

    public String readDTXML() throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dtDocument = builder.parse(BASEPATH + "_TMP_.xml");
        Element dtElement = (Element)dtDocument.getElementsByTagName("RuleSet").item(0);
        String xmlDir = dtElement.getElementsByTagName("RuleSetFilePath").item(0).getTextContent();
        Element ele = (Element)dtElement.getElementsByTagName("Decisiontables").item(0);
        String DTName = ele.getAttribute("name");
        return readXMLFile(BASEPATH + xmlDir + "/" + DTName);
    }
    
    private String readXMLFile(String FileName) throws FileNotFoundException, IOException{
        File dtrules = new File(FileName);
        FileInputStream fis = new FileInputStream(dtrules);
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        return new String(content,"utf-8");
    }

    public String getCompileMessage() throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();
        File txt = new File(BASEPATH+WORKINGDIR+"/compileMessage.txt");
        FileInputStream fis = new FileInputStream(txt);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String strtmp = null;
        while((strtmp = br.readLine())!=null){
            if(strtmp.contains("Starting: "))
                sb.append(strtmp.trim()).append("\n");
            else
                sb.append(strtmp).append("\n");
        }
        br.close();
        isr.close();
        fis.close();
        return sb.toString();
    }

    public void deleteCompileMessageFile() {
        File txt = new File(BASEPATH+WORKINGDIR+"/compileMessage.txt");
        txt.deleteOnExit();
    }
    
}
