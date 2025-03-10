package Recursion;

public class Recursion {
    public static void main(String[] args) {
        // Fibonacci(0, 1, 5);
        // System.out.println(Fibonacci(1));
    }

    static void message(int a){
        System.out.println("Hello World!");
        if(a>1){
            message(a-1);
        }
    }

    static void Fibonacci(int a,int b,int n){
        if(a==0){
            System.out.print(a+" "+b+" ");
        }else{
            System.out.print(b+" ");
        }
        if(n<3){
            return;
        }
        Fibonacci(b, b+a, n-1);
    }

    static int Fibonacci(int n){
        if(n==0){  
            return n;
        }
        if(n==1){
            return 1;
        }

        //This is called Tail Recursion.
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
} 