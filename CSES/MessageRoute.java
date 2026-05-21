import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class MessageRoute {
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
            ArrayList<Integer> l1 = adj.get(v);
            ArrayList<Integer> l2 = adj.get(u);
            l1.add(u);
            l2.add(v);
        }

        boolean[] visited = new boolean[n+1];
        int[] parent = new int[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        Arrays.fill(parent,-1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for(int i : adj.get(curr)){
                if(!visited[i]){
                    queue.add(i);
                    parent[i] = curr;
                    visited[i] = true;
                }
            }
        }

        if(!visited[n]){
            System.out.println("IMPOSSIBLE");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int p = n;
        path.add(n);
        while (parent[p] != -1) {
            path.add(parent[p]);
            p = parent[p];
        }

        System.out.println(path.size());
        for(int i = path.size() - 1; i >= 0; i--){
            System.out.print(path.get(i) + " ");
        }
    }
}
