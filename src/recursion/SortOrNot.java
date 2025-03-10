package Recursion;
public class SortOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,9,8};
        System.out.println(arrayissort(arr));
    }

    static int i = 0;
    static boolean arrayissort(int[] nums){
        if(i == nums.length-1){
            return true;
        }
        if(nums[i] < nums[i+1]){
            i++;
            return arrayissort(nums);
        }
        else{
            return false;
        }
    }
}
