import java.util.Arrays;

public class customAL {

    private int[] data;
    private static int defaultsize = 10;
    private int size = 0;
    
    
    customAL(){
        this.data = new int[defaultsize];
    }

    customAL(int size){
        this.data = new int[size];
    }

    public void add(int num){
        if(isfull()){
            resize();
        }
        data[size] = num;
        size++;
    }

    public void remove(){
        size--;
    }
    
    public int size(){
        return size;
    }

    public void display(){
        int[] temp = new int[size];
        for(int i=0;i<size;i++){
            temp[i] = data[i];
        }
        System.out.println(Arrays.toString(temp));
    }

    private boolean isfull(){
        return size == data.length;
    }

    private void resize(){
        int[] temp = new int[data.length *2];
        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }
}
