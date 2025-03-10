package BinarySearch;
public class rotationCount {
    public static void main(String args[]){
        int[] nums={30,40,50,6};
        System.out.println(90);
        int ans=searchMax(nums);
        System.out.println(ans);
    }

    public static int searchMax(int[] nums){
        int start=0;
        int end=nums.length-1;

        if(nums[start]<nums[end] || nums.length==1){
            return 0;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid+1;
            }
            if(nums[mid]<nums[start]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}
