package Sorting;
import java.util.Arrays;

public class bubblesort {
    public static void main(String[] args) {
        int[] nums ={5,4,3,2,1,0};
        int[] arr={};
        System.out.println(Arrays.toString(bubbleSort(nums)));
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    static int[] bubbleSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            boolean swapped=false;
            for(int j=1;j<nums.length-i;j++){
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return nums;
    }
}
