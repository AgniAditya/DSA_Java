package Recursion;
public class PatternsRec {
    public static void main(String[] args) {
        System.out.println("Triangle 2");
        pattern1(5, 1,0);
        System.out.println("Triangle 2");
        pattern2(5, 0);
    }
    static void pattern1(int rows,int row,int col){
        if(row > rows){
            return;
        }
        if(col == row){
            System.out.println("");
            pattern1(rows, row+1 ,0);
        }
        if(col < row){
            System.out.print("*");
            pattern1(rows, row ,col+1);
        }
    }
    static void pattern2(int rows,int col){
        if(rows == 0){
            return;
        }
        if(col == rows){
            System.out.println("");
            pattern2(rows-1,0);
        }
        if(col < rows){
            System.out.print("*");
            pattern2(rows,col+1);
        }
    }
}