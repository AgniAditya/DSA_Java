import java.util.Arrays;

public class SumOfTriangleREC {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,7};
        triangles(A);
    }

    static void triangles(int[] nums){
        if(nums.length == 1){
            System.out.println(Arrays.toString(nums));
            return;
        }

        int[] ans = new int[nums.length-1];
        for(int i=0 ; i < nums.length - 1;i++){
            ans[i] = nums[i] + nums[i+1];
        }
        triangles(ans);
        System.out.println(Arrays.toString(nums));
        return;
    }
}