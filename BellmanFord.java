package graph;
import java.util.ArrayList;
import java.util.List;

public class BellmanFord{
    //private List<vertex> vertexList;
    //private  List<Edge> edgeList;
    private  List<vertex> cyclicList;
    graphClass g;


    public  BellmanFord(graphClass g){
        this.g = g;
        g.connectCurrencies();
        this.cyclicList = new ArrayList<>();
    }


    //we assume a fully connected graph where every node in the vertex list is connected.
    public void  bellmanFord(vertex sourceVertex) {
        if(g.vertexList.size() > 0 || sourceVertex!=null) {//make sure vertexlist is not empty before you can set a distance a minimum distance.
            sourceVertex.setMinDistance(0);
        }
        else {
            System.out.println("graph is empty");
        }



//relaxing every edge
        for (int i = 0; i < g.vertexList.size() - 1; i++) {
            for (Edge edge : g.edgeList) {
               // System.out.println(g.vertexList.get(i));
                if (edge.getStartVertex().getMinDistance() == Integer.MAX_VALUE) {
                    continue;
                }
                double newDistance = edge.getStartVertex().getMinDistance() + edge.getWeight();
                if (newDistance < edge.getEndVertex().getMinDistance()) {
                    edge.getEndVertex().setMinDistance(newDistance);
                    edge.getEndVertex().setPreviousVertex(edge.getStartVertex());
                }
            }

        }



//go through all the edges in the edgelist and check if the product of
        for (Edge edg : g.edgeList) {
            if (edg.getStartVertex().getMinDistance() != Integer.MAX_VALUE){// after relaxation, we expect to have the best path cost attached to each edge.
                //check if arbitrage is possible, add nodes involved to the negative cycle list and print them afterwards
                if (edg.getEndVertex().getMinDistance() > edg.getStartVertex().getMinDistance()) {
                    vertex vex = edg.getStartVertex();
                    while (!vex.equals(edg.getEndVertex())) {
                        if(!vex.getPrinted()) {
                            vex.setPrinted(true);
                            this.cyclicList.add(vex);
                            vex = vex.getPreviousVertex();
                        }
                        else{
                            break;
                        }
                    }
                    this.cyclicList.add(edg.getEndVertex());
                    printCycle();//prints the cycle to indicate whether arbitrage has occured or not
                   return;
                }
                else {
                    break;
                }
            }
        }
    }


    //This checks the arbitrage situation after the relaxation stage
        public void printCycle () {
            if (this.cyclicList.size()>0) {
                System.out.println("Arbitrage detected");
                for (vertex ver : this.cyclicList) {
                    System.out.print(ver + " ---> ");
                }
                System.out.print(cyclicList.get(0));
            }
            else {
                System.out.println("No arbitrage detected");
            }
        }

    }
