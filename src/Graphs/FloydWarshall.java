import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num_nodes = sc.nextInt();
        int V = num_nodes;

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();
        
        int[][] adj = new int[edges][edges];

        int i = 0;
        while (num_nodes-- > 0) {
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

        System.out.print("Source Node: ");
        int source = sc.nextInt();

        System.out.print("Destination Node: ");
        int destination = sc.nextInt();
        sc.close();

        for(int[] row : adj){
            System.out.println(Arrays.toString(row));
        }

        int minCost = allShortestPath(V,adj,source,destination);
        System.out.println("From " + source + " to " + destination + " minimum cost is -> " + minCost);
    }

    private static int allShortestPath(int n,int[][] matrix,int src,int dest){
        int[][] adj = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                adj[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            int u = matrix[i][0];
            int v = matrix[i][1];
            int wt = matrix[i][2];
            adj[u][v] = wt;
            adj[v][u] = wt;
        }

        for(int i = 0; i < n; i++) adj[i][i] = 0;

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE) continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        return adj[src][dest];
    }
}