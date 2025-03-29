import java.util.ArrayList;

public class CustomHeap<T extends Comparable<T>> {
    
    private ArrayList<T> list;

    public CustomHeap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int sec){
        T temp = list.get(first);
        list.set(first, list.get(sec));
        list.set(sec, temp);
    }

    private int parent(int indx){
        return (indx-1)/2;
    }

    private int left(int indx){
        return indx*2 + 1;
    }

    private int right(int indx){
        return indx*2 + 2;
    }

    public void insert(T val){
        list.add(val);
        uphead(list.size() - 1);
    }

    private void uphead(int indx){
        if(indx == 0){
            return;
        }
        int p = parent(indx);
        if(list.get(indx).compareTo(list.get(p)) < 0){
            swap(indx, p);
        }
        uphead(p);
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Empty Heap!");
        }
        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int indx){
        int min = indx;
        int left = left(indx);
        int rgt = right(indx);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        if(rgt < list.size() && list.get(min).compareTo(list.get(rgt)) > 0){
            min = rgt;
        }

        if(min != indx){
            swap(min, indx);
            downheap(min);
        }
    }

    public ArrayList<T> heapsort() throws Exception{
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}