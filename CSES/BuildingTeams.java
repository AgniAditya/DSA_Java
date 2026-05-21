import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BuildingTeams {
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
    public static void main(String[] args) throws IOException {
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
            adj.get(v).add(u);
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n+1];
        int[] team = new int[n+1];

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                if(bfs(i,visited,team,adj)){
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 1; i <= n; i++){
            ans.append(team[i]).append(" ");
        }

        System.out.println(ans);
    }

    private static boolean bfs(int i, boolean[] visited, int[] team, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visited[i] = true;
        team[i] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for(int n : adj.get(curr)){
                if(!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                    team[n] = team[curr] == 1 ? 2 : 1;
                }
                else if(team[n] == team[curr]){
                    return true;
                }
            }
        }

        return false;
    }
}