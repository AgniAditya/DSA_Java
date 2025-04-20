// ✅ Dijkstra is applicable on:

// Graph Type	Can Use Dijkstra?	Conditions
// UG (Undirected Graph)	✅ Yes	All edge weights must be non-negative
// UAG (Undirected Acyclic)	✅ Yes	Same as above — non-negative weights
// DG (Directed Graph)	✅ Yes	Must have non-negative edge weights
// DAG (Directed Acyclic)	✅ Yes	Again, no negative edge weights

// 🔴 Important:
// Dijkstra doesn't care about cycles or direction — it only breaks when negative weights exist.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair{
    int node;
    int weight;
    Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "[" + node + ", " + weight + "]";
    }
}

public class DijkstraAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num_nodes = sc.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int i = 0;
        while (num_nodes-- > 0) {
            System.out.print("Enter the number of neighbours of: " + i + " -> ");
            int neighbours = sc.nextInt();
            ArrayList<Pair> list = new ArrayList<>();
            while (neighbours-- > 0) {
                System.out.print("Enter the neighbour of: " + i + " -> ");
                int node = sc.nextInt();
                System.out.print("Enter the weight of the neighbour edge of -> ");
                int weight = sc.nextInt();
                list.add(new Pair(node, weight));
            }
            adj.add(list);
            i++;
        }
        System.out.print("Source Node: ");
        int src = sc.nextInt();
        sc.close();
        System.out.println(adj);
        System.out.println(Arrays.toString(ShortestPath(adj,src)));
    }

    private static int[] ShortestPath(ArrayList<ArrayList<Pair>> adj,int src){
        int[] dist = new int[adj.size()];

        for(int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE - 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.offer(new Pair(src, 0));

        dist[src] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            for(Pair n : adj.get(node)){
                int v = n.node;
                int wt = n.weight;
                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        
        for(int i = 0; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE - 1) dist[i] = -1;
        }

        return dist;
    }
}