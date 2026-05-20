package CSES;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountingRoom {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] map = new char[n][m];
            for(int i = 0; i < n; i++){
                String s = sc.next();
                char[] ch = s.toCharArray();
                for(int j = 0; j < m; j++){
                    map[i][j] = ch[j];
                }
            }

            System.out.println(countRooms(map));
        }
    }

    private static int countRooms(char[][] map){
        int n = map.length;
        int m = map[0].length;
        int rooms = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '.' & !visited[i][j]){
                    bfs(i,j,directions,visited,map);
                    rooms++;
                }
            }
        }

        return rooms;
    }

    private static void bfs(int i,int j,int[][] directions,boolean[][] visited,char[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] direction : directions){
                int newRow = curr[0] + direction[0];
                int newCol = curr[1] + direction[1];
                if(newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length && !visited[newRow][newCol] && map[newRow][newCol] == '.'){
                    queue.add(new int[] {newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}