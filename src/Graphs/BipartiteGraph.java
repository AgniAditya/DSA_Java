package src.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraph {
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
        if(isBipartitiGraph(adj)) System.out.println("Graph is Bipartite");
        else System.out.println("Graph is not Bipartite");
    }

    private static boolean isBipartitiGraph(ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[adj.size()];
        for(int i = 0; i < color.length; i++){
            if(color[i] == 0){
                if(!bfs(adj,color,i)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj,int[] color,int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        color[num] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(Integer n : adj.get(node)){
                if (color[node] == color[n]) return false;
                else if (color[n] == 0){
                    if(node == 1) color[n] = 2;
                    else color[n] = 1;
                    queue.offer(n);
                }
            }
        }
        return true;
    }
}