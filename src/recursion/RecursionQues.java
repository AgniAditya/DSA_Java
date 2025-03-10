package Recursion;
public class RecursionQues {
    public static void main(String[] args) {
        int a=sumOfDigit(12233, 0);
        System.out.println(a);
        print(10);
    }

    static int sumOfDigit(int num,int sum){
        if(num<1){
            return sum;
        }
        return sumOfDigit(num/10, sum+num%10);
    }

    static void print(int N){
        if(N==1){
            System.out.print(1);
            return;
        }
        System.out.print(N);
        print(N-1);
    }
}