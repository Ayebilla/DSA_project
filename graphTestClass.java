package graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class graphTestClass {
    public static void main(String [] args){
        graphClass g = new graphClass();
        g.connectCurrencies();
        BellmanFord bellman = new BellmanFord(g);
        bellman.bellmanFord(g.edgeList.get(1).getStartVertex());


    }
}
