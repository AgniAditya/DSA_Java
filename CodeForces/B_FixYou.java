import java.util.Scanner;

public class B_FixYou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] maze = new char[n][m];
            for(int i = 0; i < n; i++){
                String s = sc.next();
                for(int j = 0; j < m; j++){
                    maze[i][j] = s.charAt(j);
                }
            }
            System.out.println(fixYou(n,m,maze));
        }
    }
    
    private static int fixYou(int n, int m, char[][] maze){
        int min = 0;
        char[][] copy = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copy[i][j] = maze[i][j];
            }
        }
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                chnageDirection(i,j,copy,visited);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copy[i][j] != maze[i][j]) min++;
            }
        }
        return min;
    }
    
    private static void chnageDirection(int i,int j,char[][] maze,boolean[][] visited){
        if(visited[i][j] || maze[i][j] == 'C') return;
        visited[i][j] = true;
        char ch = maze[i][j];
        if(ch == 'R'){
            if(j + 1 < maze[0].length){
                chnageDirection(i, j + 1, maze, visited);
                return;
            }
            maze[i][j] = 'D';
            chnageDirection(i + 1, j, maze, visited);
            return;
        }
        if(i + 1 < maze.length) {
            chnageDirection(i + 1, j, maze, visited);
            return;
        }
        maze[i][j] = 'R';
        chnageDirection(i, j + 1, maze, visited);
    }
}
