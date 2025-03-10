import java.util.Arrays;

public class customgenericAL<type> {

    private Object[] data;
    private static int defaultsize = 10;
    private int size = 0;
    
    customgenericAL(){
        this.data = new Object[defaultsize];
    }

    public void add(type num){
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
        Object[] temp = new Object[size];
        for(int i=0;i<size;i++){
            temp[i] = data[i];
        }
        System.out.println(Arrays.toString(temp));
    }

    private boolean isfull(){
        return size == data.length;
    }

    private void resize(){
        Object[] temp = new Object[data.length *2];
        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
    }
}
