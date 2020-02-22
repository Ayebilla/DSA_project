package graph;
/*
This class modesl the vertices of a graph. Every vertex(node) has neighbors and a minimum distance associated with it.
It also has reference to the previous vertex that points to it.
 */
import java.util.ArrayList;
import java.util.List;


public class vertex {
    private String currencyName;
    private  boolean visited;
    private boolean printed = false;
    private  double  minDistance = Integer.MAX_VALUE; // an inbuild large constant value in Java
    private vertex previousVertex;
    private List<Edge> neigbours;


// constructor
    public vertex(String currencyName){
        this.currencyName = currencyName;
        this.neigbours = new ArrayList<>();
    }



    // getters and setters
    public double getMinDistance(){

        return  this.minDistance;
    }


    public vertex getPreviousVertex (){

        return  this.previousVertex;
    }


    public void setPreviousVertex(vertex previousVertex){
        this.previousVertex = previousVertex;
    }



    public void setMinDistance(double minDistance){
        this.minDistance = minDistance;
    }



    public void  addEdge(Edge edge){
        this.neigbours.add(edge);
    }


    public List<Edge> getNeigbours(){
        return  neigbours;
    }


    public  boolean hasBeenVisited(){
        return  visited;
    }


    public void setVisited(boolean visited){

        this.visited = visited;
    }


    public boolean getPrinted(){
        return printed;
    }


    public  void setPrinted(boolean printed){

        this.printed = printed;
    }


    public String getCurrencyName(){
        return this.currencyName;
    }


    // toString method
    @Override
    public String toString(){

        return  " " + this.currencyName;
    }
}
