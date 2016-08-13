/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Reactive;

import GaleAII.Datastructure.Cluster;
import GaleAII.Datastructure.Node;
import Interface.History.Family;
import collections.History;

/**
 *
 * @author Brian Miller
 */
public class FamilyInterview extends Interview {

    Family newFamily;

    private static int FAMILY_CLUSTER_ROOT_NODEID = 2;

    public FamilyInterview(Cluster cluster, GaleAII.Gale gale, History patientHistory) {
        super(cluster, gale, patientHistory);
        this.cluster.moveToNode(this.cluster.getNodeByID(FAMILY_CLUSTER_ROOT_NODEID));
        currentNode = cluster.getCurrentNode();
        newFamily = new Family();

    }

    private Byte convertNodeAnswer() {
        byte liveWith;

        switch (nodeAnswer) {
            case "YES":
                liveWith = 1;
            default:
                liveWith = 0;
        }
        return liveWith;
    }

    @Override
    public void runEvent(int eventID) {
        currentDecision = cluster.getDecisionFromAnswer(decesionAnswer);
        switch (eventID) {
            case 9:
                break;
            default:

        }
        runDecision(currentDecision.getEventCode());
    }

    @Override
    public void run() {
        runCurrentNode();
    }

    @Override
    public void runDecision(int eventID) {
        switch (eventID) {
            case 2:
                dEvent2();
                break;
            case 3:
                dEvent3();
                break;
            case 4:
                dEvent4();
                break;
            case 5:
                dEvent5();
                break;
            case 6:
                dEvent6();
                break;
            case 7:
                dEvent7();
                break;
            case 8:
                dEvent8();
                break;
            case 9:
                dEvent9();
                break;
            case 10:
                dEvent10();
                break;
            case 11:
                dEvent11();
                break;
            case 12:
                dEvent12();
                break;
            case 13:
                dEvent13();
                break;
            default:
                break;

        }
        if (currentDecision.getDetermineNode() != null) {
            cluster.moveToNode(currentDecision.getDetermineNode());
            this.currentNode = cluster.getCurrentNode();
            runCurrentNode();
        }

    }

    private void dEvent2() {
        newFamily.setName(nodeAnswer);
    }

    private void dEvent3() {
        newFamily.setRelative(nodeAnswer);
    }

    private void dEvent4() {

    }

    private void dEvent5() {

    }

    private void dEvent6() {
        StringBuilder majorDisorders;
        if (newFamily.getMajorDisorder() != null) {
            majorDisorders = new StringBuilder(newFamily.getMajorDisorder());
            majorDisorders.append(",");
        } else {
            majorDisorders = new StringBuilder();
        }
        majorDisorders.append(nodeAnswer);
        newFamily.setMajorDisorder(majorDisorders.toString());
    }

    private void dEvent7() {

    }

    private void dEvent8() {

    }

    private void dEvent9() {
        StringBuilder minorDisorders;
        if (newFamily.getMajorDisorder() != null) {
            minorDisorders = new StringBuilder(newFamily.getSpecificTypeDisorder());
            minorDisorders.append(",");
        } else {
            minorDisorders = new StringBuilder();
        }
        minorDisorders.append(nodeAnswer);
        newFamily.setSpecificTypeDisorder(minorDisorders.toString());
    }

    private void dEvent10() {
        newFamily.setLivesWithPatient(convertNodeAnswer());
    }

    private void dEvent11() {
        newFamily.setAlive(convertNodeAnswer());
    }

    private void dEvent12() {
        writeFamily();
    }

    private void dEvent13() {
        writeFamily();
    }

    private void writeFamily() {
        try {
            patientHistory.addFamilyHistory(newFamily);
        } catch (Exception e) {
        }

    }

}
