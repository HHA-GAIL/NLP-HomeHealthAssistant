/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GaleAII.Datastructure;

import Database.Read;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This is the Neural Map data structure, the point of this structure is to
 * act the way the human brain behaves. In this simplified version there are 
 * clusters of related thoughts, with each thought living in a single node. 
 * This class acts as the brain for Gail, and not to be tampered with without
 * carefully examining other code as each change has profound effects on behavior.
 * @author Brian
 */
public class NeuralMap {

    ArrayList<Cluster> clusters = new ArrayList<>();
    /**
     * default constructor for the data structure class, forces the build of a neural 
     * map, this process is not yet thread safe.
     */
    public NeuralMap() {
        buildNeuralMap();
    }
    /**
     * Reads the database and pulls each cluster result into the cluster
     * constructor.
     * 
     * @see 
     */
    private void buildNeuralMap() {
        try {
            Read read = new Read("Gale.Cluster");
            read.createConnection();
            ResultSet rs = read.selectAll();
            while (rs.next()) {
                clusters.add(new Cluster(rs));
            }
        } catch (Exception e) {
        }
    }

    public Cluster getClusterByName(String name) throws Exception{
        try {
            for (int i = 0; i < clusters.size(); i++) {
                if (clusters.get(i).getName().equals(name)) {
                    return clusters.get(i);
                }
            }
            throw new Exception("Cluster does not exist");
        } catch (Exception e) {
            throw e;
        }
    }
}
