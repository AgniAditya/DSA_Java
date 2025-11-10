import java.util.*;

public class B_Sort_The_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        int index = 0;

        while (index < n) {
            int num = sc.nextInt();
            nums[index] = num;
            index++;
        }

        int i = 0;
        while(i < n - 1 && nums[i] <= nums[i+1]){
            i++;
        }

        int j = i + 1;
        while(j < n && nums[j] <= nums[j-1]){
            j++;
        }
        
        int l = i;
        int r = j - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        
        boolean sorted = true;
        for(int k = 1; k < n; k++){
            if(nums[k-1] > nums[k]) {
                sorted = false;
                break;
            }
        }

        if(sorted){
            System.out.println("yes");
            System.out.println((i + 1) + " " + j);
        }
        else{
            System.out.println("no");
        }
    }
}