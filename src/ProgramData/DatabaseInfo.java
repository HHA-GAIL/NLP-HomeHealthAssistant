/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramData;

/**
 * this is a test
 * @author Brian
 */
public interface DatabaseInfo {


    //    public final String HOST_NAME = "ec2-54-200-12-7.us-west-2.compute.amazonaws.com";

//    public final String HOST_NAME = "ec2-54-200-12-7.us-west-2.compute.amazonaws.com";


//    public final String HOST_NAME = "ec2-54-200-12-7.us-west-2.compute.amazonaws.com";

//    public final String URL = "jdbc:mysql://"+HOST_NAME+"/dbo?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useSSL=false";
//    public final String USER = "research";
//    public final String PASSWORD = "Gail01";
//    public final String HOST_NAME = "ec2-54-200-12-7.us-west-2.compute.amazonaws.com";
    public final String URL = "jdbc:mysql://localhost:3306/dbo?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useSSL=false";
    public final String USER = "root";
    public final String PASSWORD = "123";
    
}
