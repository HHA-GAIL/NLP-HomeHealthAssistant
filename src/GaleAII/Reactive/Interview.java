/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Reactive;

import GUI.History.HistoryForm;
import GUI.healthCareAIFullMDIParent;
import GaleAII.Datastructure.Cluster;
import GaleAII.Datastructure.Node;
import GaleAII.Language.Sentence;
import collections.History;

/**
 *
 * @author Brian Miller
 */
public abstract class Interview extends Reactive{
    collections.History patientHistory;
    
    public Interview(Cluster cluster, GaleAII.Gale gale, History patentHistory) {
        super(cluster, gale);
        this.patientHistory = patentHistory;
    }
    
    
    
    
    
    
    
}
