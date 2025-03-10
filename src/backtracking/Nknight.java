package BacktrackingRec;
public class Nknight {
    public static void main(String[] args) {
        int size = 2;
        boolean[][] board = new boolean[size][size];
        knight(board, 0, 0, 4);
    }
    
    static void knight(boolean[][] board,int r,int c,int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }

        if(r == board.length-1 && c == board.length){
            return;
        }

        if(c == board.length){
            knight(board,r+1,0,knights);
            return;
        }

        if(safe(board,r,c)){
            board[r][c] = true;
            knight(board, r, c+1, knights - 1);
            board[r][c] = false;
        }
        knight(board, r, c+1, knights);
    }

    private static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("K ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private static boolean safe(boolean[][] board,int row,int col){
        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }

        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }

        return true;
    }

    private static boolean isValid(boolean[][] board,int row,int col){
        if(row >= 0 && row < board.length && col >=0 && col < board[0].length){
            return true;
        }
        return false;
    }
}
