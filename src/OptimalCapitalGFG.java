import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class OptimalCapitalGFG {
    public static void main(String[] args) {
        int[][] roads = {{0,1},{1,2},{1,3}};
        System.out.println(optimalCity(3, 4, roads));
    }

    public static int optimalCity(int m, int n,int[][] roads){
        if(n == 1) return 0;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int city = 0;
        int sum = Integer.MAX_VALUE - 1;

        for(int i = 0; i < n; i++){
            int path_sum = bfs(i,adj,n);
            if(path_sum < sum){
                city = i;
                sum = path_sum;
            }
        }

        return city;
    }

    private static int bfs(int start, List<List<Integer>> adj, int n){
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        int sum = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];
            sum += dist;

            for(int neighbor : adj.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return sum;
    }
}
