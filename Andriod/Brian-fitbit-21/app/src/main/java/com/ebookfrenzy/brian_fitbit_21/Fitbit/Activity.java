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

    private String date;
    private int Steps;

    public Activity(String date, int steps) {
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
        String[] values = new String[2];
        values[0] = date.toString();
        values[1] = String.valueOf(Steps);
        return values;
    }

    private String[] columnStrings(){
        String[] columns = new String[2];
        columns[0] = "Date";
        columns[1] = "Steps";
        return columns;
    }

    public void Add() throws Exception{
        add = new Add(valueStrings(),columnStrings());
        read = new Read("fitBitActivity");
        read.createConnection();
        add.perform(read.selectAll());
    }




}
