// package Sorting;
import java.util.Arrays;


// Time Complexity Big-O(nlogn).
// Space Complexity Big-O(1).

public class QuickSort {
    static void quicksort(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int i=start;
        int j=end;
        int pivot = i+(j-i)/2;
        while (i<=j) {
            while (nums[i]<nums[pivot]) {
                i++;
            }
            while (nums[j]>nums[pivot]) {
                j--;
            }
            if(i<=j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
        }
        quicksort(nums, i, end);
        quicksort(nums, start, j);
    }

    static int binarySearch(int[] nums,int start,int end,int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] < target){
            return binarySearch(nums, mid + 1, end, target);
        }
        return binarySearch(nums, start, mid - 1, target);
    }
    public static void main(String[] args) {
        int[] nums={30,50,15,25,80,20,90,45};
        System.out.print("Non-Sorted Array - > ");
        System.out.println(Arrays.toString(nums));
        quicksort(nums,0,nums.length-1);
        System.out.print("Sorted Array - > ");
        System.out.println(Arrays.toString(nums));
        int index = binarySearch(nums, 0, nums.length-1, 15);
        if(index == -1){
            System.out.println("Target not found");
        }else{
            System.out.println("Target is at -> " + index + " index of Array");
        }
    }
}