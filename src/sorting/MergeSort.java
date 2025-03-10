package Sorting;
// Time Complexity Big-O(nlogn).
// Space Complexity Big-O(n).

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,0};
        System.out.println(Arrays.toString(mergesort(arr)));
    }
    
    // So by this logic we are sorting the real array instead we are returing the new array.
    static int[] mergesort(int[] nums){
        if(nums.length == 1){
            return nums;
        }

        int mid = nums.length/2;
        
        int[] left = mergesort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(nums, mid, nums.length));
        
        return megre(left,right);
    }
    
    static int[] megre(int[] first,int[] second){
        int[] mergearray = new int [first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]){
                mergearray[k] = first[i];
                i++;
            }
            else{
                mergearray[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            mergearray[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mergearray[k] = second[j];
            j++;
            k++;
        }
        return mergearray;
    }
    
    
    // So to Sort the real array Use this Logic.
    static void mergesortInplace(int[] nums,int start , int end){
        if(nums.length == 1){
            return;
        }

        int mid = start + (end - start)/2;

        mergesortInplace(nums, start, mid);
        mergesortInplace(nums, mid,end);

        megreInplace(nums,start,mid,end);
    }

    static void megreInplace(int[] nums,int start ,int mid , int end){
        int[] mergearray = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        while (i < mid && j < end) {
            if (nums[i] < nums[j]){
                mergearray[k] = nums[i];
                i++;
            }
            else{
                mergearray[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            mergearray[k] = nums[i];
            i++;
            k++;
        }
        while (j < end) {
            mergearray[k] = nums[j];
            j++;
            k++;
        }
        for(int l=0;l<mergearray.length;l++){
            nums[l] = mergearray[l];
        }
    }
}