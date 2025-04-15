package src.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KahnsAlgo {
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
        System.out.println(kahns_algo(adj));
    }

    private static ArrayList<Integer> kahns_algo(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> kahnsSort = new ArrayList<>();
        int[] indegree = new int[adj.size()];

        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                indegree[adj.get(i).get(j)] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }
            kahnsSort.add(node);
        }

        return kahnsSort;
    }
}
