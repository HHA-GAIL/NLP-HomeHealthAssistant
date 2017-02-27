/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Reactive;

import GaleAII.Datastructure.Cluster;
import GaleAII.Gale;
import collections.History;

/**
 *
 * @author Brian Miller
 */
public class Core extends Reactive {

    History patientHistory;

    private static int ROOT_CORE_NODE = 1;

    public Core(Cluster cluster, Gale gale, History patientHistory) {
        super(cluster, gale);
        this.patientHistory = patientHistory;
        this.cluster.moveToNode(this.cluster.getNodeByID(ROOT_CORE_NODE));
        currentNode = cluster.getCurrentNode();
    }

    @Override
    public void runEvent(int eventID) {
        currentDecision = cluster.getDecisionFromAnswer(decesionAnswer);
        /**
         * should add a judgment to avoid the NULL pointer
         */
//        if(currentDecision!=null){
             runDecision(currentDecision.getEventCode());
//        }else{
//            System.out.println("No Result");
//        }
       
    }

    @Override
    public void runDecision(int eventID) {
        switch (eventID) {
            case 0:
                break;
            case 1:
                dEvent1();
        }
    }

    private void dEvent1() {
        FamilyInterview familyInterview
                = new FamilyInterview(gale.getClusterByName("Family Interview"),
                        gale, patientHistory);
        Thread familyInterviewThread = new Thread(familyInterview);
        familyInterviewThread.start();
    }

    @Override
    public void run() {
        runCurrentNode();
    }
}
