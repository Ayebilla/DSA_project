package graph;
import java.util.ArrayList;
import java.util.List;
public class graphClass {



    List<vertex> vertexList = new ArrayList<>();
    List<vertex> dest_vertexlist = new ArrayList<>();
    List<Edge> edgeList = new ArrayList<>();
    private int numberOfCurrencies;

    //default class constructor
    public graphClass(){

    }


    //this method connect the currencies
        public void connectCurrencies() {
                inputFromFile input = new inputFromFile();
                input.openFile();
                input.distributeFromFile(input.readFile());
                for(int i = 0; i < input.Vertices_origin.size()-1; i++){
                    vertexList.add(new vertex(input.Vertices_origin.get(i)));
                    dest_vertexlist.add(new vertex(input.Vertices_dest.get(i)));
                    edgeList.add(new Edge(vertexList.get(i), dest_vertexlist.get(i), -1*Math.log(input.rates.get(i))));
                    edgeList.add(new Edge(dest_vertexlist.get(i), vertexList.get(i), 1/(-1*Math.log(input.rates.get(i)))));
                }
        }
        //get the number of currencies in the currencies list
    public int getNumberOfCurrencies(){
        return vertexList.size();
    }


    public vertex getItem(int index){
        if(vertexList.size() <= 0 || index > vertexList.size() ){
            //throw new IndexOutOfBoundsException("illegal index");
            System.out.println("illegal index");
        }
        return vertexList.get(index);
    }



    public void displayAll(){
        //prints all the veritices in a graph

    }



    public void delete(String currencyName){
        //deletes a currency with the given name from the vertices list
    }



    public void displayNeighbors(){
        /* prints out the neighbors of each currency node. prints in the form;
         currencyName:
                neighbor1
                neighbor2
                neighbor3
                etc
         */

    }


    // this method checks the list of vertices to see if a particular currency exist in the list. It returns true if a currency exist and false otherwise
    public boolean exist(String currencyName){
        boolean found = false;
        for(vertex ver : vertexList)
        if( ver.getCurrencyName().equals(currencyName)){
            found = true;
        }
      return found;
    }
    }

