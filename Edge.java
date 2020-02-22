package graph;
/*
This class simulates edge connecting nodes. Every edge takes three parameters; the node it is from, the weight of the edge and node it is going to.
The nodes of the graph are the vertex class.
 */

public class Edge {
    private double weight;
    private  vertex startVertex;
    private  vertex endVertex;



    public  Edge(vertex  startVertex, vertex endVertex, double weight){
        this.endVertex = endVertex;
        this.startVertex = startVertex;
        this.weight = weight;
    }



    public  double getWeight(){
        return  weight;
    }



    public void  setWeight(double weight){
        this.weight = weight;
    }



    public vertex getStartVertex(){

        return  this.startVertex;
    }



    public vertex getEndVertex(){
        return this.endVertex;
    }



    public void setStartVertex(vertex startVertex){

        this.startVertex = startVertex;
    }


    public void setEndVertex(vertex endVertex){

        this.endVertex = endVertex;
    }

}
