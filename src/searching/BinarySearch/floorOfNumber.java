package BinarySearch;
public class floorOfNumber {
    public static int FloorOfNumber(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        if(target>nums[nums.length-1] || target<nums[0]){
            System.out.print("Number "+target+" does not exist ");
            return -1;
        }
        while(left<=right){
            if(nums[mid]==target){
                System.out.print("Number is Found in list-> ");
                return nums[mid];
            }else if(nums[mid]<target){
                left=mid+1;
                mid=left+(right-left)/2;
            }
            else{
                right=mid-1;
                mid=left+(right-left)/2;
            }
        }
        System.out.println("Number: "+target+" is not in list");
        System.out.print("Answer is-> ");
        return nums[right];
    }
    public static void main(String[] args) {
        int[] nums={2,3,4,5,7,9,12,14,16,18};
        int target=16;
        System.out.println(FloorOfNumber(nums, target));
        System.out.println(FloorOfNumber(nums, 8));
        System.out.println(FloorOfNumber(nums, 100));
        System.out.println(FloorOfNumber(nums, 0));
    }
}
