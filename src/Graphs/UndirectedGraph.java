package src.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UndirectedGraph<T> {
    private Map<T,ArrayList<T>> adjacencyList;
    
    public UndirectedGraph(){
        this.adjacencyList = new HashMap<>();
    }

    public void add(T node){
        this.adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void connectWith(T node,T neighourNode) throws Exception{
        if(this.adjacencyList.containsKey(node)){
            this.adjacencyList.get(node).add(neighourNode);
            return;
        }
        throw new Exception("Vertex " + node + " not in the Graph");
    }

    public void connectWith(T node,T[] neighourNode) throws Exception{
        if(this.adjacencyList.containsKey(node)){
            for(int i = 0; i < neighourNode.length; i++){
                this.adjacencyList.get(node).add(neighourNode[i]);
            }
            return;
        }
        throw new Exception("Vertex " + node + " not in the Graph");
    }

    public void connectWith(T node,ArrayList<T> neighourNode) throws Exception{
        if(this.adjacencyList.containsKey(node)){
            this.adjacencyList.get(node).addAll(neighourNode);
            return;
        }
        throw new Exception("Vertex " + node + " not in the Graph");
    }

    public void display(){
        for(Map.Entry<T,ArrayList<T>> entry : adjacencyList.entrySet()){
            System.out.println("Vertex : " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}