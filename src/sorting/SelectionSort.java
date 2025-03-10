package Sorting;
import java.util.Arrays;;

public class SelectionSort {

    static int[] selectionSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int last=nums.length-i-1;
            int maxIndex=getMaxIndex(nums,0,last);
            int temp=nums[last];
            nums[last]=nums[maxIndex];
            nums[maxIndex]=temp;
        }
        return nums;
    }

    static int getMaxIndex(int[] arr,int start,int end){
        int max=start;
        for(int i=0;i<=end;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums={4,3,2,1};
        int[] arr={3,4,5,2,1,9,45};
        System.out.println(Arrays.toString(selectionSort(nums)));
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}