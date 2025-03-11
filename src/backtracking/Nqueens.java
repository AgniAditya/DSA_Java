package backtracking;
public class Nqueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[9][9];
        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board,int r){
        if(r == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for(int c = 0; c < board[0].length ;c++){
            if(safe(board,r,c)){
                board[r][c] = true;
                count += queens(board, r+1);
                board[r][c] = false;
            }
        }
        return count;
    }

    private static boolean safe(boolean[][] board,int row,int col){
        for(int i = row-1;i >= 0;i--){
            if(board[i][col]){
                return false;
            }
        }

        int maxleft = Math.min(row,col);
        for(int i = 1; i <= maxleft ; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        int maxright = Math.min(row,board.length - col - 1);
        for(int i = 1; i <= maxright ; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
