/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Proactive;

import GaleAII.Datastructure.Cluster;

/**
 *
 * @author Brian Miller
 */
public abstract class Proactive implements Runnable{
    Cluster cluster;

    public Proactive(Cluster cluster) {
        this.cluster = cluster;
    }    
}
