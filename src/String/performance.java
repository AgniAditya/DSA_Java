package String;
import java.util.Arrays;

public class performance {
    public static void main(String[] args) {
        // String series="";
        // for(int i=0;i<26;i++){
        //     char ch=(char)('a'+ i);
        //     series=series + ch + " " ;
        // }
        // System.out.println(series);

        // String s="is2 sentence4 This1 a3";
        // String[] arr=s.split(" ");
        // System.out.println(Arrays.toString(arr));
        
        int[] nums={-1,0,1,2,4,6,54};
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}