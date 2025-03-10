package BinarySearch;
public class infiniteArrary {
    public static void main(String[] args) {
        int[] nums={1,2,3,45,55,77,87,99,101,134,223,442,541,600};
        int target=99;
        System.out.println(ans(nums, target));
    }

    public static int ans(int[] nums,int target){
        int start=0;
        int end=1;

        while(target>nums[end]){
            int temp=end+1;
            //Changing the end position
            end=end+(end-start+1)*2;
            start=temp;
        }

        return binarySearch(nums, target, start, end);
    }
    public static int binarySearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }
            else if(target<nums[mid]){
                end=mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
