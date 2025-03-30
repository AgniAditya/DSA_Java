import java.util.Arrays;

public class RangeQuery {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,4,8,9,3,10,11};
        
        int sqrt = (int)Math.sqrt(arr.length);

        int[] blocks = new int[sqrt+1];
        int block_id = -1;

        for(int i = 0; i < arr.length; i++){
            if(i % sqrt == 0){
                block_id++;
            }
            blocks[block_id] += arr[i];
        }
        System.out.println(Arrays.toString(blocks));
        int l = 1;
        int r = 6;
        System.out.println(query(arr, blocks, l, r, sqrt));
        update(arr, blocks, 1, 0, sqrt);
        System.out.println(Arrays.toString(blocks));
        System.out.println(query(arr, blocks, l, r, sqrt));
    }

    private static int query(int[] arr,int[] blocks,int l,int r,int sqrt){
        int ans = 0;

        //Left part
        while(l % sqrt != 0 && l < r){
            ans += arr[l];
            l++;
        }

        //Middle part
        while(l + sqrt <= r){
            ans += blocks[l/sqrt];
            l += sqrt;
        }

        //Right part
        while(l <= r){
            ans += arr[l];
            l++;
        }

        return ans;
    }

    public static void update(int[] arr,int[] blocks,int index,int val,int sqrt){
        blocks[index/sqrt] += (val - arr[index]);
        arr[index] = val;
    }
}
