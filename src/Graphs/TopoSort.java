package src.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class TopoSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num_nodes = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int i = 0;
        while (num_nodes-- > 0) {
            System.out.print("Enter the number of neighbours of: " + i + " -> ");
            int neighbours = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (neighbours-- > 0) {
                System.out.print("Enter the neighbour of: " + i + " -> ");
                int x = sc.nextInt();
                list.add(x);
            }
            adj.add(list);
            i++;
        }
        sc.close();
        System.out.println(adj);
        System.out.println(topologicalSort(adj));
    }
    private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                res.addAll(0,dfs(adj,visited,i));
            }
        }
        return res;
    }

    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int node){
        visited[node] = true;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node);
        for(Integer i : adj.get(node)){
            if(!visited[i]){
                list.addAll(dfs(adj,visited,i));
            }
        }
        return list;
    }
}