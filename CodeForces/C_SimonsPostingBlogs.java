import java.io.*;
import java.util.*;

public class C_SimonsPostingBlogs {
    
    static List<Integer> reduceBlog(List<Integer> a) {
        Set<Integer> used = new HashSet<>();
        List<Integer> b = new ArrayList<>();

        for (int i = a.size() - 1; i >= 0; i--) {
            int val = a.get(i);
            if (!used.contains(val)) {
                used.add(val);
                b.add(val);
            }
        }
        return b;
    }

    static List<Integer> filtered(List<Integer> b, Set<Integer> seen) {
        List<Integer> res = new ArrayList<>();
        for (int x : b) {
            if (!seen.contains(x)) {
                res.add(x);
            }
        }
        return res;
    }

    static boolean lexicographicallySmaller(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder output = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();

            List<List<Integer>> blogs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int l = fs.nextInt();
                List<Integer> blog = new ArrayList<>();
                for (int j = 0; j < l; j++) {
                    blog.add(fs.nextInt());
                }
                blogs.add(blog);
            }

            List<List<Integer>> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                b.add(reduceBlog(blogs.get(i)));
            }

            List<Integer> answer = new ArrayList<>();
            Set<Integer> seen = new HashSet<>();
            boolean[] alive = new boolean[n];
            Arrays.fill(alive, true);

            for (int step = 0; step < n; step++) {
                int best = -1;
                List<Integer> bestSeq = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if (!alive[i]) continue;

                    List<Integer> cur = filtered(b.get(i), seen);

                    if (best == -1 || lexicographicallySmaller(cur, bestSeq)) {
                        best = i;
                        bestSeq = cur;
                    }
                }

                alive[best] = false;

                for (int x : bestSeq) {
                    answer.add(x);
                }
                for (int x : b.get(best)) {
                    seen.add(x);
                }
            }

            for (int i = 0; i < answer.size(); i++) {
                if (i > 0) output.append(" ");
                output.append(answer.get(i));
            }
            output.append("\n");
        }

        System.out.print(output);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
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
}
