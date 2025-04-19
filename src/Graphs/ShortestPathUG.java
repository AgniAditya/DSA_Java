// Shortest Path in UG (Undirected Graph)

package src.Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathUG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num_nodes = sc.nextInt();
        int size = num_nodes;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int i = 0;
        while (num_nodes-- > 0) {
            System.out.print("Enter the number of neighbours of: " + i + " -> ");
            int neighbours = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (neighbours-- > 0) {
                System.out.print("Enter the neighbour of: " + i + " -> ");
                int node = sc.nextInt();
                list.add(node);
            }
            adj.add(list);
            i++;
        }
        System.out.print("Enter the src number: ");
        int src = sc.nextInt();
        while (src < 0 && src >= size) {
            System.out.print("Source node not in range");
            src = sc.nextInt();
        }
        sc.close();
        System.out.println(adj);
        System.out.println(Arrays.toString(ShortestPath(adj,src)));
    }

    private static int[] ShortestPath(ArrayList<ArrayList<Integer>> adj,int src){
        int[] dist = new int[adj.size()];
        
        for(int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE - 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int i : adj.get(node)){
                if(dist[node] + 1 < dist[i]){
                    dist[i] = dist[node] + 1;
                    queue.offer(i);
                }
            }
        }

        for(int i = 0; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE - 1){
                dist[i] = -1;
            }
        }

        return dist;
    }
}
