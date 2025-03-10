package Recursion;
import java.util.ArrayList;

public class LinearSearchRec {
    public static void main(String[] args) {
        int[] arr = {3,5,3,4,5};
        System.out.println(Searchelementoccs(arr,5,0));
    }

    static int search(int[] nums,int target,int index){
        if(index > nums.length-1){
            return -1;
        }
        if(nums[index] == target) return index;
        return search(nums, target, index+1);
    }

    static ArrayList<Integer> res = new ArrayList<Integer>();
    static ArrayList<Integer> searchMulOcc(int[] nums,int target,int index){
        if(index > nums.length-1 && res.size() != 0){
            return res;
        }
        if(index > nums.length-1 && res.size() == 0){
            res.add(-1);
            return res;
        }
        if(nums[index] == target){
            res.add(index);
        }
        return searchMulOcc(nums, target, index+1);
    }

    static ArrayList<Integer> Searchelementoccs(int[] nums ,int target ,int index){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(index == nums.length){
            return res;
        }
        if(nums[index] == target){
            res.add(index);
        }
        ArrayList<Integer> ans = Searchelementoccs(nums ,target ,index+1);
        res.addAll(ans);
        return res;
    }
}
