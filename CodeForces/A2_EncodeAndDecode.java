import java.util.Scanner;

public class A2_EncodeAndDecode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String run = sc.next();
        if(run.equals("first")){
            int n = sc.nextInt();
            long[] nums = new long[n];
            for(int i = 0; i < n; i++) nums[i] = sc.nextLong();

            StringBuilder s = new StringBuilder();
            s.append(encode(n));

            for(int i = 0; i < n; i++){
                s.append(encode(nums[i]));
            }

            System.out.println(s);
        }
        else{
            String s = sc.next();
            int pos = 0;

            int n = (int)decode(s,pos);
            System.out.println(n);
            pos += W;

            for(int i = 0; i < n; i++){
                long num = decode(s, pos);
                System.out.print(num + " ");
                pos += W;
            }
        }
    }

    final static int W = 7;

    private static String encode(long x){
        char[] a = new char[W];
        for(int i = W - 1; i >= 0; i--){
            int r = (int)(x % 26);
            a[i] = (char)('a' + r);
            x /= 26;
        }
        return new String(a);
    }

    private static long decode(String s,int pos){
        long val = 0;
        for(int i = 0; i < W; i++){
            val = val * 26 + (s.charAt(pos + i) - 'a');
        }
        return val;
    }
}