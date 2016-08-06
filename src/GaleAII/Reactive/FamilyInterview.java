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

    @Override
    public void runEvent(int eventID) {
        currentDecision = cluster.getDecisionFromAnswer(decesionAnswer);
        switch (eventID) {
            default:

        }
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
            case 3:
                dEvent3();
            case 4:
                dEvent4();
            case 5:
                dEvent5();
            case 6:
                dEvent6();
            case 7:
                dEvent7();
            case 8:
                dEvent8();
            case 9:
                dEvent9();
            case 10:
                dEvent10();
            case 11:
                dEvent11();
            case 12:
                dEvent12();
            case 13:
                dEvent13();
            default:

        }
        cluster.moveToNode(currentDecision.getDetermineNode());
        runCurrentNode();
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
        }else{
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
        }else{
            minorDisorders = new StringBuilder();
        }
        minorDisorders.append(nodeAnswer);
        newFamily.setSpecificTypeDisorder(minorDisorders.toString());
    }

    private void dEvent10() {

    }

    private void dEvent11() {

    }

    private void dEvent12() {

    }

    private void dEvent13() {

    }

}
