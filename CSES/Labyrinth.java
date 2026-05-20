import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Labyrinth{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            char[][] map = new char[n][m];

            for(int i = 0; i < n; i++){
                char[] s = sc.next().toCharArray();
                for(int j = 0; j < m; j++){
                    map[i][j] = s[j];
                }
            }

            shorestPath(map);
        }
    }

    private static void shorestPath(char[][] map){
        int n = map.length;
        int m = map[0].length;

        int[] start = {0,0};
        int[] end = {n-1,m-1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'A'){
                    start[0] = i;
                    start[1] = j;
                }
                else if(map[i][j] == 'B'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        char[][] parent = new char[n][m];
        queue.add(new int[] {start[0],start[1]});
        visited[start[0]][start[1]] = true;
        parent[start[0]][start[1]] = '0';

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if(
                curr[0] - 1 >= 0 && 
                map[curr[0] - 1][curr[1]] != '#' &&
                !visited[curr[0] - 1][curr[1]]
            ){
                queue.add(new int[] {curr[0] - 1,curr[1]});
                parent[curr[0] - 1][curr[1]] = 'U';
                visited[curr[0] - 1][curr[1]] = true;
            }
            if(
                curr[0] + 1 < map.length && 
                map[curr[0] + 1][curr[1]] != '#' &&
                !visited[curr[0] + 1][curr[1]]
            ){
                queue.add(new int[] {curr[0] + 1,curr[1]});
                parent[curr[0] + 1][curr[1]] = 'D';
                visited[curr[0] + 1][curr[1]] = true;
            }
            if(
                curr[1] + 1 < map[0].length && 
                map[curr[0]][curr[1] + 1] != '#' &&
                !visited[curr[0]][curr[1] + 1]
            ){
                queue.add(new int[] {curr[0],curr[1] + 1});
                parent[curr[0]][curr[1] + 1] = 'R';
                visited[curr[0]][curr[1] + 1] = true;
            }
            if(
                curr[1] - 1 >= 0 && 
                map[curr[0]][curr[1] - 1] != '#' && 
                !visited[curr[0]][curr[1] - 1]
            ){
                queue.add(new int[] {curr[0],curr[1] - 1});
                parent[curr[0]][curr[1] - 1] = 'L';
                visited[curr[0]][curr[1] - 1] = true;
            }
        }

        if (!visited[end[0]][end[1]]) {
            System.out.println("NO");
            return;
        }

        StringBuilder path = new StringBuilder();
        int x = end[0];
        int y = end[1];

        while (parent[x][y] != '0') {
            char p = parent[x][y];
            path.append(p);
            if(p == 'U') x++;
            else if(p == 'D') x--;
            else if(p == 'R') y--;
            else if(p == 'L') y++;
        }

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.reverse());
    }
}