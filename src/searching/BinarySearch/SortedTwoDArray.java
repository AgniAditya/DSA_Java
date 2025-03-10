package BinarySearch;
import java.util.Arrays;

public class SortedTwoDArray {
    public static void main(String[] args) {
        int[][] nums={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(Arrays.toString(Search(nums, 19)));
    }
    
    public static int[] BinarySearch(int[][] nums,int row, int cStart,int cend,int target){
        while (cStart<=cend) {

            int mid=cStart+(cend-cStart)/2;

            if(nums[row][mid]<target){
                cStart=mid+1;
            }
            else if(nums[row][mid]>target){
                cend=mid-1;
            }
            else{
                return new int[] {row,mid};
            }
        }
        return new int[] {-1,-1};
    }

    static int[] Search(int[][] matrix,int target){
        int row=matrix.length;
        int col=matrix[0].length;

        if(row==1){
            return BinarySearch(matrix, 0, 0, col-1, target);
        }

        int rstart=0;
        int rend=row-1;
        int cmid=col/2;

        while(rstart<(rend-1)){

            int mid=rstart+(rend-rstart)/2;

            if(matrix[mid][cmid]==target){
                return new int[] {mid,cmid};
            }else if(matrix[mid][cmid]<target){
                rstart=mid;
            }else{
                rend=mid;
            }
        }

        if(matrix[rstart][cmid]==target){
            return new int[] {rstart,cmid};
        }
        if(matrix[rstart+1][cmid]==target){
            return new int[] {rstart+1,cmid};
        }

        if(target <= matrix[rstart][cmid-1]){
            return BinarySearch(matrix, rstart, 0, cmid-1, target);
        }

        if(target >= matrix[rstart][cmid+1] && target<=matrix[rstart][col-1]){
            return BinarySearch(matrix, rstart, cmid+1, col-1, target);
        }

        if(target <= matrix[rstart+1][cmid-1]){
            return BinarySearch(matrix, rstart+1, 0, cmid-1, target);
        }
        else{
            return BinarySearch(matrix, rstart+1, cmid+1, col-1, target);
        }
    }
} 