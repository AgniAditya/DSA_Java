package BinarySearch;
import java.util.Arrays;

public class BinarySearch {

    public static int binarysearch(int[] nums,int target){
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        // int mid=(left+right)/2;
        //Better way to find mid;
        int mid=left+(right-left)/2;
        while (nums[mid]!=target) {
            if(nums[mid]<target){
                left=mid+1;
                mid=left+(right-left)/2;
            }
            else{
                right=mid-1;
                mid=left+(right-left)/2;
            }
        }
        System.out.print("Index of "+nums[mid]+" -> ");
        return mid;
    }

    public static void main(String[] args) {
        int[] nums={3,4,5,6,7,8,9,10,2,3,23,31,21};
        int target=21;
        System.out.println(binarysearch(nums, target));
    }
}