import java.util.Arrays;

public class CircularQueue {
    private int[] data;
    private static final int Defalut_size = 10;
    private int end = -1;
    private int front = -1;
    private int size = 0;

    CircularQueue(){
        this(Defalut_size);
    }

    CircularQueue(int size){
        this.data = new int[size];
    }

    public void insert(int item) {
        if(isEmpty()){
            front = 0;
            end = 0;
        }else{
            if(end == front){
                front++;
                front = front % data.length;
            }
        }
        data[end] = item;
        end++;
        end = end % data.length;
        if(size < data.length){
            size++;
        }
    }    

    public void remove() throws Exception{
        if(isEmpty()){
            throw new Exception();
        }
        front++;
        front = front % data.length;
        size--;
    }

   public void display(){
        if (isEmpty()) {
            System.out.println("Circular Queue is Empty.");
            return;
        }
        int[] values = new int[size];
        int i = front;
        int indx = front;
        if(front >= size){
            indx = size - 1;
        }
        do{
            indx = indx % size;
            values[indx] = data[i];
            indx++;
            i++;
            i = i % data.length;
        }while(i != end);
        System.out.println(Arrays.toString(values));
    }

    private boolean isEmpty(){
        return size == 0;
    }
}