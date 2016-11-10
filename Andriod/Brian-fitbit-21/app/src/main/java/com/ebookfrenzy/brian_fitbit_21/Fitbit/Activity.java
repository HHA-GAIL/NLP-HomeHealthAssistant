package com.ebookfrenzy.brian_fitbit_21.Fitbit;

import com.ebookfrenzy.brian_fitbit_21.Database.Add;
import com.ebookfrenzy.brian_fitbit_21.Database.Read;

import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by brian on 11/9/2016.
 */

public class Activity {
    private Read read;
    private Add add;

    private int id;
    private Date date;
    private int Steps;

    public Activity(int id, Date date, int steps) {
        this.id = id;
        this.date = date;
        Steps = steps;
        read = new Read("fitBitActivity");
        try{
            ResultSet fitbitActivity = read.selectAll();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        //add = new Add(valueStrings(),);

    }

    private String[] valueStrings(){
        String[] values = new String[3];
        values[0] = String.valueOf(id);
        values[1] = date.toString();
        values[2] = String.valueOf(Steps);
        return values;
    }




}
