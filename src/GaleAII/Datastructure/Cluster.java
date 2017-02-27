/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Datastructure;

import Database.Read;
import GaleAII.Language.Sentence;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class Cluster {

    //Identification
    private int clusterID;
    private String name;
    private ArrayList<Node> nodes = new ArrayList<>();
    Node currentNode;
    
    public Cluster() {
    }

    public Cluster(ResultSet rs) {
        try {
            constructFromResultSet(rs);
            buildCluster();
        } catch (Exception e) {
        }
    }

    private void constructFromResultSet(ResultSet rs) {
        try {
            this.clusterID = rs.getInt("clusterID");
            this.name = rs.getString("Name");
        } catch (Exception e) {
        }
    }

    /**
     * With the given cluster, find nodes.
     */
    private void buildCluster() {
        try {
            Read read = new Read("gale.node");
            read.createConnection();
            ResultSet rs = read.selectWhere("clusterID", String.valueOf(this.clusterID));
            while (rs.next()) {
                nodes.add(new Node(rs));
            }
            read.connection.close();
            read = new Read("gale.decisionsfornodes");
            read.createConnection();
            for (int i = 0; i < nodes.size(); i++) {
                rs
                        = read.selectViewWhere("nodeID",
                                String.valueOf(nodes.get(i).getNodeID()));
                while (rs.next()) {
                    nodes.get(i).addDecisionToNode(new Decision(rs, nodes));
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Searches through the cluster's nodes for the node by the passed id.
     *
     * @param nodeID
     * @return Null or the Node.
     */
    public Node getNodeByID(int nodeID) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getNodeID() == nodeID) {
                return nodes.get(i);
            }
        }
        return null;
    }
    
    public Decision getDecisionFromAnswer(String Answer){
        Decision correctDecision = null;
        for (Decision decision : currentNode.getDecisions()) {
            /**
             * Author： Fan Hu
             * Date: 2/12/2017
             * Function: Ignore all the spelling mistakes about upper and lower character
             */
            if (Answer.toUpperCase().equals(decision.getAnswer().toUpperCase())) {
                correctDecision = decision;
            }
        }
        return correctDecision;
}

    
    
    
    public void moveToNode(Node node){
        currentNode = node;
    }

    public int getClusterID() {
        return clusterID;
    }

    public void setClusterID(int clusterID) {
        this.clusterID = clusterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getCurrentNode() {
        return currentNode;
    }
    
    

}
