import java.util.Arrays;

public class CustomStack {
    private int[] data;
    private static final int Defalut_size = 10;
    private int ptr = -1;

    CustomStack(){
        this(Defalut_size);
    }
    CustomStack(int size){
        this.data = new int[size];
    }

    public void push(int item){
        if(ptr >= data.length - 1){
            System.out.println("Stack is full.");
            return;
        }
        ptr++;
        data[ptr] = item;
    }

    public void pop() throws Exception{
        if(ptr == -1){
            throw new Exception();
        }
        data[ptr] = 0;
        ptr--;
    }

    public int peek() throws Exception{
        if(ptr == -1){
            throw new Exception();
        }
        return data[ptr];
    }    

    public void display(){
        int[] values = new int[ptr+1];
        for(int i=0; i<=ptr ;i++){
            values[i] = data[i];
        }
        System.out.println(Arrays.toString(values));
    }
}