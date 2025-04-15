package src.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleDirectedGraph{
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
        System.out.println(detectCycle(adj));
    }
    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        boolean[] path = new boolean[adj.size()];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                if(dfs(adj,visited,path,i)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] path,int node){
        path[node] = true;
        visited[node] = true;
        for(Integer n : adj.get(node)){
            if(path[n]) {
                return true;
            }
            if(!visited[n]){
                if(dfs(adj, visited, path, n)) return true;
            }
        }
        path[node] = false;
        return false;
    }
}