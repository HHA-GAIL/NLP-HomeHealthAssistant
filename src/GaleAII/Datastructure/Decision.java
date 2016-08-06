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
 * @author Brian Miller
 */
public class Decision {

    int decisionID;
    private String answer;
    private int eventCode;
    private Node determineNode;

    public Decision(ResultSet rs, ArrayList<Node> clustersNodes) {
        buildDecisionFromResultSet(rs);
        try {
            int determineNodeID = rs.getInt("DetermineNode");
            for (int i = 0; i < clustersNodes.size(); i++) {
                if (clustersNodes.get(i).getNodeID() == determineNodeID) {
                    this.determineNode = clustersNodes.get(i);
                }
            }
        } catch (Exception e) {
        }

    }

    private void buildDecisionFromResultSet(ResultSet rs) {
        try {
            decisionID = rs.getInt("DecisionID");
            answer = rs.getString("Answer");
            eventCode = rs.getInt("DecisionEvent");
        } catch (Exception e) {
        }
    }

    public String getAnswer() {
        return answer;
    }

    public int getEventCode() {
        return eventCode;
    }

    public Node getDetermineNode() {
        return determineNode;
    }
    
    

}
