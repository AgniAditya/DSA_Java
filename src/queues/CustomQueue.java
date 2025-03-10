import java.util.Arrays;

public class CustomQueue {
    private int[] data;
    private static final int Defalut_size = 10;
    private int end = 0;

    CustomQueue(){
        this(Defalut_size);
    }

    CustomQueue(int size){
        this.data = new int[size];
    }

    public void insert(int item) {
        if(end > data.length){
            System.out.println("Queue is full.");
            return;
        }
        data[end++] = item;
    }

    public void remove() throws Exception{
        if(end == 0){
            throw new Exception();
        }
        for(int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
    }

    public void display(){
        int[] values = new int[end];
        for(int i=0; i<end ;i++){
            values[i] = data[i];
        }
        System.out.println(Arrays.toString(values));
    }
}