package backtracking;
import java.util.ArrayList;

public class MazeProblem {
    public static void main(String[] args) {
        boolean[][] arr = {
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        System.out.println(paths(3, 4));
        System.out.println(Diagonalpathslist("",3, 4));
        System.out.println(pathsobstacle(arr,0,0));
    }

    static int paths(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = paths(r-1, c);
        int right = paths(r, c-1);
        return left+right;
    }
    static ArrayList<String> pathslist(String p,int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r > 1){
            ans.addAll(pathslist(p+'D',r-1, c));
        }
        if(c > 1){
            ans.addAll(pathslist(p+'R',r, c-1));
        }
        return ans;
    }
    static ArrayList<String> Diagonalpathslist(String p,int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(c > 1 && r > 1){
            ans.addAll(Diagonalpathslist(p+'D',r-1, c-1));
        }
        if(r > 1){
            ans.addAll(Diagonalpathslist(p+'V',r-1, c));
        }
        if(c > 1){
            ans.addAll(Diagonalpathslist(p+'R',r, c-1));
        }
        return ans;
    }
    static int pathsobstacle(boolean[][] Maze,int r, int c){
        if(r == Maze.length - 1 && c == Maze[0].length - 1){
            return 1;
        }
        if(!Maze[r][c]){
            return 0;
        }
        int count = 0;
        if(r < Maze.length - 1){
            count +=  pathsobstacle(Maze,r+1, c);
        }
        if(c < Maze[0].length - 1){
            count += pathsobstacle(Maze,r, c+1);
        }
        return count;
    }
}