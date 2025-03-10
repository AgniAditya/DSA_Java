package Recursion;
import java.util.Arrays;

public class BubbleSortRec {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        BubbleSort(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void BubbleSort(int[] nums,int i, int j){
        if(i>nums.length-1){
            return;
        }
        if(j<nums.length-1-i){
            if(nums[j] > nums[j+1]){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
            BubbleSort(nums, i, j+1);
        }
        else{
            BubbleSort(nums, i+1, 0);
        }
    }
}