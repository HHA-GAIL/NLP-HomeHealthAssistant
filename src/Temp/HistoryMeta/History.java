/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temp.HistoryMeta;

import java.sql.ResultSet;

/**
 *
 * @author Brian
 */
public interface History extends Temp.Temp{
    public void populateFromResultSet(int position) throws Exception;    
    public void populateFromResultSet(ResultSet resultSet) throws Exception;
}
