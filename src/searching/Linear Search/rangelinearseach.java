public class rangelinearseach {
    public static boolean linearsearch(int[] nums,int start,int target){
        for(int i=start;i<nums.length;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        int[] nums={10,23,32,5,3,52,8,0};
        int target=10;
        int start=3;
        System.out.println(linearsearch(nums,start ,target));
        System.out.println(linearsearch(nums,start ,5));
    } 
}