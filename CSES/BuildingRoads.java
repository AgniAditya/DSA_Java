import java.io.*;
import java.util.*;

public class BuildingRoads {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    public static void main(String[] args) throws IOException{
        FastReader sc = new FastReader();

        int n = sc.nextInt();
        int m = sc.nextInt();

        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            int v = sc.nextInt();
            int u = sc.nextInt();
            ArrayList<Integer> l1 = adj.get(v);
            ArrayList<Integer> l2 = adj.get(u);
            l1.add(u);
            l2.add(v);
        }
        
        ArrayList<int[]> roads = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        int prev = -1;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                bfs(i,visited,adj);
                if(prev != -1){
                    roads.add(new int[] {prev,i});
                }
                prev = i;
            }
        }

        System.out.println(roads.size());
        for(int[] road : roads){
            System.out.println(road[0] + " " + road[1]);
        }
    }

    private static void bfs(int i, boolean[] visited ,ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visited[i] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for(int n : adj.get(curr)){
                if(!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}