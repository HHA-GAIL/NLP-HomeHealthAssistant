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
 *
 * @author Brian
 */
public class NeuralMap {

    ArrayList<Cluster> clusters = new ArrayList<>();

    public NeuralMap() {
        buildNeuralMap();
    }

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
