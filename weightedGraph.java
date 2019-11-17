package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class weightedGraph {
     Map<currencyNode, List<currencyNode>> adjacentVertices =  new HashMap<currencyNode, List<currencyNode>>();

    Map<String , currencyNode> currencies =  new HashMap<String, currencyNode>();

    public  void addCurrency(String name, double weight){
        currencyNode cur = new currencyNode(name, weight);
        currencies.putIfAbsent(name, cur);
    }

    public void addEdge(String curr1, double w1, String s2, double w2){
        if(currencies.get(curr1) == null){
            currencyNode currency1 = new currencyNode(curr1, w1);
            currencies.putIfAbsent(curr1, currency1);
        }

        if( currencies.get(s2) == null){
            currencyNode currency2 = new currencyNode(s2, w2);
            currencies.putIfAbsent(s2, currency2);
        }

        currencies.get(curr1).addNeighbor(s2, w2);
        currencies.get(s2).addNeighbor(curr1, w1);

    }
     
public int getnumOfcurrencies(){return adjacentVertices.size();}

public static  void main(String [] args){
        weightedGraph w = new weightedGraph();
        w.addCurrency("Ghs", 3);
        w.addCurrency("dollar", 4);
        w.addCurrency("naira", 5);
        w.addCurrency("shilli", 6);

        w.addEdge("Ghs", 3, "naira", 4);
        w.addEdge("Ghs", 3, "kobo", 10);
        w.addEdge("cent", 20, "shilli", 6);
        w.addEdge("kwacha",1, "boom",3);
}
}



