package Sorting;
import java.util.Arrays;

public class cyclicsorting {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(cyclicSort(nums)));
    }

    static int[] cyclicSort(int[] nums){
        int i=0;
        while (i<nums.length) {
            if(nums[nums[i]-1]!=nums[i]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
            else{
                i++;
            }
        }
        return nums;
    }
}