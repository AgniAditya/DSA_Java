package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class countSort {
    public static void main(String[] args) {
        int[] nums = {3,4,1,3,2,5,2,8};
        System.out.println(Arrays.toString(countsort(nums)));
        System.out.println(Arrays.toString(countsortHash(nums)));
    }

    static int[] countsort(int[] nums){
        if(nums.length == 0){
            return nums;
        }
        int max = nums[0];
        for(int num : nums){
            max = Math.max(num, max);
        }
        int[] newarr = new int[max+1];
        for(int i = 0; i < nums.length; i++){
            int ele = nums[i];
            newarr[ele] += 1;
        }
        int j = 0;
        for(int i = 0; i < newarr.length; i++){
            int count = newarr[i];
            while(count > 0){
                nums[j] = i;
                j++;
                count--;
            }
        }
        return nums;
    }

    static int[] countsortHash(int[] nums){
        if(nums.length == 0){
            return nums;
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int j = 0;
        for(int i = min; i <= max; i++){
            int count = freq.getOrDefault(i,0);
            while(count > 0){
                nums[j] = i;
                j++;
                count--;
            }
        }
        return nums;
    }
}
