package sorting;

// Time Complexity -> O(digit*(n+base))
// Space Complexity -> O(n)

import java.util.Arrays;
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = {24,5,669,10,77,1000};
        radixsort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void radixsort(int[] nums){
        int max = Arrays.stream(nums).max().getAsInt();
        
        //Do dount sort for every digit place.

        for(int exp = 1; max/exp > 0; exp *= 10){
            countSort(nums,exp);
        }
    }

    static void countSort(int[] nums,int exp){
        int n = nums.length;
        int[] output = new int[n];
        int[] count = new int[10];

        System.out.println("Original array before : " + Arrays.toString(nums));

        for(int i = 0; i < n; i++){
            count[(nums[i]/exp) % 10]++;
        }

        System.out.println("Count Array for " + exp + " : " + Arrays.toString(count));

        for(int i = 1; i < 10; i++){
            count[i] = count[i] + count[i-1];
        }

        System.out.println("Updated count Array for " + exp + " : " + Arrays.toString(count));

        for(int i = n-1; i >= 0; i--){
            output[count[(nums[i]/exp) % 10]-1] = nums[i];
            count[(nums[i]/exp) % 10]--;
        }

        System.arraycopy(output, 0, nums, 0, n);

        System.out.println("Original array after : " + Arrays.toString(nums));

    }
}
