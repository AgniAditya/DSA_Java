package Sorting;
import java.util.Arrays;

public class InsertionSort {
    static int[] insertionSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(nums[j]>nums[j-1]){
                    break;
                }
                else if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums={3,4,0,1};
        System.out.println((Arrays.toString(insertionSort(nums))));
    }
}