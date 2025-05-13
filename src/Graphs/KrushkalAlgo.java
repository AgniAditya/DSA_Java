import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;


public class KrushkalAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num_nodes = sc.nextInt();
        int V = num_nodes;

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();
        
        int[][] adj = new int[edges][edges];

        int i = 0;
        while (edges-- > 0) {
            System.out.print("Enter the source node: -> ");
            int src = sc.nextInt();

            System.out.print("Enter the destination node: -> ");
            int dest = sc.nextInt();

            System.out.print("Enter the edge weight: -> ");
            int wt = sc.nextInt();

            int[] list = {src,dest,wt};
            adj[i] = list;
            i++;
        }
        sc.close();

        for(int[] row : adj){
            System.out.println(Arrays.toString(row));
        }

        System.out.println(minSum(V,adj));
    }

    private static int minSum(int V,int[][] edges){
        Arrays.sort(edges,Comparator.comparingInt(e -> e[2]));

        DisjointSet ds = new DisjointSet(V);
        int cost = 0;
        int count = 0;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(ds.find(u) != ds.find(v)){
                ds.union(u, v);
                cost += wt;
                if(++count == V - 1) break;
            }
        }

        return cost;
    }
}


class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int num){
        if(parent[num] != num){
            parent[num] = find(parent[num]);
        }

        return parent[num];
    }

    public void union(int num1,int num2){
        int p1 = find(num1);
        int p2 = find(num2);
        if(p1 != p2){
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }
            else if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }
            else{
                parent[p2] = p1;
                rank[p1]++;
            }
        }
    }
}