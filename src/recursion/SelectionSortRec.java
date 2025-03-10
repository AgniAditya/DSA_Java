package Recursion;
import java.util.Arrays;

public class SelectionSortRec {
    public static void main(String[] args) {
        int[] arr = {8,1,3,4,3,3,8};
        selectionsort(arr, 0, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionsort(int[] nums,int i,int j,int min){
        if(i>nums.length-1){
            return;
        }
        if(j<nums.length){
            if(nums[j] < nums[min]){
                min = j;
            }
            selectionsort(nums, i, j+1, min);
        }
        else{
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
            selectionsort(nums, i+1, i+1, i+1);
        }
    }
}