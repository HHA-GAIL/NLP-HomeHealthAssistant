/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp;


/**
 *
 * @author Brian
 */
public interface Temp {
    public abstract void fillvalueStrings();
    public abstract void fillColumnStrings(); 
    public void populateData() throws Exception;
    public boolean addData() throws Exception;
    public boolean updateData() throws Exception;
    public boolean deleteData() throws Exception;
    public void populateFromResultSet() throws Exception;
}
