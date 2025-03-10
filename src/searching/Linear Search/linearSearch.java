/**
 * linearSearch
 */
public class linearSearch {

    public static boolean linearsearch(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        int[] nums={10,23,32,5,3,52,8,0};
        int target=10;
        System.out.println(linearsearch(nums, target));
    }   
}