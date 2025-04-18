// In this i will find the Shortest Path from source node to all the nodes;

package src.Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

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

public class ShortestPathInDAGacyclic {
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
        sc.close();
        System.out.println(adj);
        System.out.println(Arrays.toString(ShortestPath(adj)));
    }

    private static int[] ShortestPath(ArrayList<ArrayList<Pair>> adj){
        Stack<Integer> stack = topoSort(adj);
        int[] dist = new int[adj.size()];

        for(int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE - 1;

        dist[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for(Pair p : adj.get(node)){
                int n = p.node;
                int wt = p.weight;
                if(dist[node] + wt < dist[n]){
                    dist[n] = dist[node] + wt;
                }
            }
        }

        return dist;
    }

    private static Stack<Integer> topoSort(ArrayList<ArrayList<Pair>> adj){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                dfs(adj,visited,stack,i);
            }
        }
        return stack;
    }

    private static void dfs(ArrayList<ArrayList<Pair>> adj,boolean[] visited,Stack<Integer> stack,int node){
        visited[node] = true;
        for(Pair p : adj.get(node)){
            if(!visited[p.node]){
                dfs(adj, visited, stack, p.node);
            }
        }
        stack.push(node);
    }
}
