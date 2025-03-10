package Recursion;
public class BsRecursion {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        System.out.println(search(arr, 4, 0, arr.length-1));
        System.out.println(search(arr, -4, 0, arr.length-1));
   }

    static int search(int[] nums,int target,int start,int end){
        if(start>end){
            return -1;
        }

        int mid=start+(end-start)/2;

        if(target==nums[mid]){
            return mid;
        }
        else if(target<nums[mid]){
            return search(nums, target, start, mid-1);
        }
        else{
            return search(nums, target, mid+1, end);
        }
    }
}