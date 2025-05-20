import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TarjansAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num_nodes = sc.nextInt();
        int V = num_nodes;

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int i = 0;
        while (edges-- > 0) {
            System.out.print("Enter the source node: -> ");
            int src = sc.nextInt();

            System.out.print("Enter the destination node: -> ");
            int dest = sc.nextInt();

            adj.get(i).add(src);
            adj.get(i).add(dest);
            i++;
        }
        sc.close();

        for(List<Integer> row : adj){
            System.out.println(row);
        }

        System.out.println(criticalConnections(V, adj));
    }

    public static List<List<Integer>> criticalConnections(int n,List<List<Integer>> connections){
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> connection : connections){
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];
        dfs(0,-1,adj,visited,time,low,edges);
        return edges;
    }

    private static int timer = 1;
    private static void dfs(int node,int parent,List<List<Integer>> adj,boolean[] visited,int[] time,int[] low,List<List<Integer>> edges){
        visited[node] = true;
        time[node] = low[node] = timer;
        timer++;

        for(Integer i : adj.get(node)){
            if(i == parent) continue;
            if(!visited[i]){
                dfs(i, node, adj, visited, time, low, edges);
                low[node] = Math.min(low[node], low[i]);

                if(low[i] > time[node]){
                    edges.add(Arrays.asList(node,i));
                }
            }
            else{
                low[node] = Math.min(low[node], low[i]);
            }
        }
    }
}
