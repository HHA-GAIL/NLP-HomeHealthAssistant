/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Datastructure;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class Node {
    
    //Identification
    
    private int nodeID;
    private int clusterID;
    private String question;
    private ArrayList<Decision> decisions = new ArrayList<>();
    private String listeningFor;
    private int event;

    public Node(ResultSet rs) {
        buildNodeFromResultSet(rs);
    }
    
    private void buildNodeFromResultSet(ResultSet rs){
        try {
            this.nodeID = rs.getInt("nodeID");
            this.clusterID = rs.getInt("clusterID");
            this.question = rs.getString("Question");
            this.listeningFor = rs.getString("listeningFor");
            this.event = rs.getInt("Event");
        } catch (Exception e) {
        }
    }

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getClusterID() {
        return clusterID;
    }

    public void setClusterID(int clusterID) {
        this.clusterID = clusterID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    public void addDecisionToNode(Decision decision){
        decisions.add(decision);
    }

    public String getListeningFor() {
        return listeningFor;
    }

    public void setListeningFor(String listeningFor) {
        this.listeningFor = listeningFor;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public ArrayList<Decision> getDecisions() {
        return decisions;
    }
    
    
    
}
