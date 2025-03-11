package backtracking;
import java.util.Arrays;

public class BacktrackingMaze {
    public static void main(String[] args) {
        boolean[][] arr = {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        int[][] path = new int[arr.length][arr[0].length];
        // allpaths("", arr, 0, 0);
        allpathsprint("", arr, 0, 0,path,1);
    }
    static void allpaths(String p,boolean[][] Maze,int r, int c){
        if(r == Maze.length - 1 && c == Maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!Maze[r][c]){
            return;
        }
        //While going marking the visited place as FALSE;
        Maze[r][c] = false;

        if(r < Maze.length - 1){
            allpaths(p+'D',Maze,r+1, c);
        }
        if(c < Maze[0].length - 1){
            allpaths(p+'R',Maze,r, c+1);
        }
        if(r > 0){
            allpaths(p+'U',Maze,r-1, c);
        }
        if(c > 0){
            allpaths(p+'L',Maze,r, c-1);
        }

        //Now while returning marks all the visited place as TRUE.
        Maze[r][c] = true;
    }

    static void allpathsprint(String p,boolean[][] Maze,int r, int c,int[][] path,int step){
        if(r == Maze.length - 1 && c == Maze[0].length - 1){
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println("");
            return;
        }
        if(!Maze[r][c]){
            return;
        }
        //While going marking the visited place as FALSE;
        Maze[r][c] = false;
        path[r][c] = step;

        if(r < Maze.length - 1){
            allpathsprint(p+'D',Maze,r+1, c,path,step+1);
        }
        if(c < Maze[0].length - 1){
            allpathsprint(p+'R',Maze,r, c+1,path,step+1);
        }
        if(r > 0){
            allpathsprint(p+'U',Maze,r-1, c,path,step+1);
        }
        if(c > 0){
            allpathsprint(p+'L',Maze,r, c-1,path,step+1);
        }

        //Now while returning marks all the visited place as TRUE.
        Maze[r][c] = true;
        path[r][c] = 0;
    }
}