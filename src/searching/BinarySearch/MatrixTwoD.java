package BinarySearch;
import java.util.*;

public class MatrixTwoD {
    public static void main(String[] args) {
        int[][] nums={
            {1,2,3,4},
            {2,5,7,9},
            {3,6,9,12},
            {4,8,16,20}
        };
        System.out.println(Arrays.toString(Search(nums, 16)));
        System.out.println(Arrays.toString(Search(nums, 100)));
        
    }

    static int[] Search(int[][] matrix, int target){
        int row=0;
        int col=matrix.length-1;

        while (row<matrix.length && col>=0) {
            if(matrix[row][col]==target){
                return new int[]{row,col};
            }
            else if(matrix[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return new int[]{-1,-1};
    } 
}
