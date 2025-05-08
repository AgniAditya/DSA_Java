import java.util.ArrayList;
import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num_nodes = sc.nextInt();
        int V = num_nodes;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int i = 0;
        while (num_nodes-- > 0) {
            System.out.print("Enter the number of source node: -> ");
            int source = sc.nextInt();

            System.out.print("Enter the destination node: -> ");
            int dest = sc.nextInt();

            System.out.print("Enter the edge weight: -> ");
            int wt = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            list.add(source);
            list.add(dest);
            list.add(wt);

            adj.add(list);
            i++;
        }
        System.out.print("Source Node: ");
        int src = sc.nextInt();
        sc.close();

        System.out.print("Given Graph -> ");
        System.out.println(adj);

        boolean[] negCycle = {false};

        int[] dist_arr = shortest_path(V,adj,src,negCycle);
        System.out.println("Shortest distances from node " + src + ":");
        for (int k = 0; k < dist_arr.length; k++) {
            System.out.println("Node " + k + ": " + dist_arr[k]);
        }

        if(negCycle[0]) System.out.println("Graph has negative cycle");
        else System.out.println("No negative cycle");
    }

    private static int[] shortest_path(int V, ArrayList<ArrayList<Integer>> adj, int src, boolean[] negCycle){
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) dist[i] = (int)(1e8);
        dist[src] = 0;

        for(int i = 0; i < V-1; i++){
            for(ArrayList<Integer> arr : adj){
                int u = arr.get(0);
                int v = arr.get(1);
                int wt = arr.get(2);
                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(ArrayList<Integer> arr : adj){
            int u = arr.get(0);
            int v = arr.get(1);
            int wt = arr.get(2);
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                negCycle[0] = true;
            }
        }

        return dist;
    }
}
