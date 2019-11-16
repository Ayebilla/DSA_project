package  graph;

import java.util.HashMap;
import java.util.Map;

public class currencyNode {
    private  double weight;
    private  String currencyName;

    Map <String, Double> neighbors;

    public currencyNode(String currencyName, double weight){
        this.currencyName=currencyName;
        this.weight = weight;
        neighbors =  new HashMap<String, Double>();
    }
    public  String getCurrencyName(){
        return this.currencyName;
    }
    public  double getWeight(){
        return this.weight;
    }
    public void setWeight(int newWeight){
        this.weight = newWeight;
    }
    public  void  setCurrencyName(String newName){
        this.currencyName =newName;
    }
    public void addNeighbor(String name, double weight){
        this.neighbors.putIfAbsent(name, weight);
    }

    public Map<String, Double> getNeighbors(){
        return this.neighbors;
    }

}
