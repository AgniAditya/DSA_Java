package src.Graphs;
import java.util.*;
public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int tc = sc.nextInt();

        while (tc-- > 0) {
            System.out.print("Enter number of vertices (V): ");
            int V = sc.nextInt();
            System.out.print("Enter number of edges (E): ");
            int E = sc.nextInt();
            int[][] edges = new int[E][2];

            System.out.println("Enter the edges (pair of vertices): ");
            for (int i = 0; i < E; i++) {
                System.out.print("Edge " + (i + 1) + ": ");
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);

            System.out.println(ans ? "Cycle exists: true" : "Cycle exists: false");
        }

        sc.close();
    }
}
// } Driver Code Ends
class Solution {
    private class Pair{
        int vertex;
        int parent;
        
        Pair(int vertex,int parent){
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
    // Code here
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);

            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V+1];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,-1));
        visited[0] = true;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                Pair pair = queue.poll();
                int vertex = pair.vertex;
                int parent = pair.parent;
                
                for(Integer n : adj.get(vertex)){
                    if(n != parent && !visited[n]){
                        queue.offer(new Pair(n,vertex));
                        visited[n] = true;
                    }
                    else if(n != parent && visited[n]){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
}