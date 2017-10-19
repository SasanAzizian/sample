/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;

import java.util.*;

/**
 *
 * @author sazizian
 */
public abstract class Graph {
    
    private int numVertices;
    private int numEdges;

    public Graph() {
        numVertices=0;
        numEdges=0;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }
   
    
    public void addVErtex(){
        implementAddVertex();
        numVertices++;
    }
    public abstract void implementAddVertex();
    public abstract List<Integer> getNeighbors(int v);
    
}
