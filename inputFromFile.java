package graph;
import java.io.*;
import java.util.*;


public class inputFromFile {
    private Scanner a;
    ArrayList<String> Vertices = new ArrayList<>();

    ArrayList<String> Vertices_origin = new ArrayList<>();
    ArrayList<String> Vertices_dest = new ArrayList<>();
    ArrayList<Double> rates = new ArrayList<>();

    public void openFile(){
        try{
            // store the datatotest.txt file anywhere and provide a full path to it as bellow
            a = new Scanner(new File("C:/DSA_final_project/src/graph/Noarbitrage.txt"));
        }

        catch(Exception e){
            System.out.println("The file does not exit");
        }
    }

    public ArrayList<String> readFile(){
        while(a.hasNext()){
            Vertices.add(a.next());
        }
        return Vertices;
    }

    public void distributeFromFile(ArrayList<String> Vertices){
        //loop through the arr and keep each elt in it actual position
        for(int i=0; i<Vertices.size(); i+=3){
            this.Vertices_origin.add(Vertices.get(i));
            //conversion string to Double
            double dbl = Double.parseDouble(Vertices.get(i+1));
            this.rates.add(dbl);
            this.Vertices_dest.add(Vertices.get(i+2));
        }
    }


    public double currencyFinder(String og, String dest){
        for(int i = 0; i<this.Vertices_origin.size(); i++){
            if(Vertices_origin.get(i).equals(og)){
                //We found the position
                if(Vertices_dest.get(i).equals(dest)){
                    //Founs our destination
                    return rates.get(i);
                }
            }
        }
        return -1.0;
    }

    public void closeFile(){
        a.close();
    }
}
