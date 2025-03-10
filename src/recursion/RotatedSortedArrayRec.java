package Recursion;
public class RotatedSortedArrayRec {
    public static void main(String[] args) {
        int[] arr = {5,6,0,1,2,3};
        System.out.println(Search(arr,10,0,arr.length-1));
    }
    //With Recursion:
    static int Search(int[] nums,int target,int s,int e){
        if(s > e){
            return -1;
        }
        int m = s + (e - s)/2;
        if(nums[m] == target){
            return m;
        }
        if(nums[s] <= nums[m]){
            if(target >= nums[s] && target <= nums[m]){
                return Search(nums, target, s, m-1);
            }
            else{
                return Search(nums, target, m+1, e);
            }
        }
        else{
            if(target >= nums[s] || target < nums[m]){
                return Search(nums, target, s, m-1);
            }
            else if(target > nums[m] && target < nums[s]){
                return Search(nums, target, m+1, e);
            }
        }
        return -1;
    }

    //Wihtout Recursion:
    // static int Search(int[] nums,int target){
    //     int s = 0;
    //     int e = nums.length-1;
    //     while(s <= e){
    //         int m = s + (e - s)/2;
    //         if(nums[m] == target){
    //             return m;
    //         }
    //         if(nums[s] <= nums[m]){
    //             if(target >= nums[s] && target <= nums[m]){
    //                 e = m - 1;
    //             }
    //             else{
    //                 s = m + 1;
    //             }
    //         }
    //         else{
    //             if(target >= nums[s] || target < nums[m]){
    //                 e = m - 1;
    //             }
    //             else if(target > nums[m] && target < nums[s]){
    //                 s = m + 1;
    //             }
    //         }
    //     }
    //     return -1;
    // }
}