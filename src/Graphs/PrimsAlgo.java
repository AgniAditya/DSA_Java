import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgo {
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
        System.out.print("Given Graph -> ");
        System.out.println(adj);

        System.out.println(Prims_min_sum(adj));
    }

    private static int Prims_min_sum(ArrayList<ArrayList<Pair>> adj){
        int n = adj.size();

        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> minPQ = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        minPQ.offer(new Pair (0,0));
        int sum = 0;

        while (!minPQ.isEmpty()) {
            Pair p = minPQ.poll();
            int node = p.node;
            int wt = p.weight;

            if(visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for(Pair pair : adj.get(node)){
                int adjnode = pair.node;
                int edgewt = pair.weight;
                if(!visited[adjnode]){
                    minPQ.offer(new Pair(adjnode, edgewt));
                }
            }
        }
        return sum;
    }
}