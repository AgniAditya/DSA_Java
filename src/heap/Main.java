import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        int[] arr = {10,3,5,9,20};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void HeapSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            upward(i,arr);
        }
        for(int i = 0; i < arr.length; i++){
            swap(0, arr.length - i - 1, arr);
            downward(0,arr.length - i - 1,arr);
        }
    }
    
    private static void upward(int index,int[] arr){
        if(index == 0){
            return;
        }
        int parent = parent(index);
        if(arr[parent] < arr[index]){
            swap(index, parent, arr);
            upward(parent, arr);
        }
    }
    
    private static void downward(int index,int range,int[] arr){
        int left = left(index);
        int right = right(index);
        int largest = index;

        if (left < range && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < range && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest, arr);
            downward(largest, range, arr);
        }
    }

    private static void swap(int f, int s,int[] arr){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
    
    static int parent(int indx){
        return (indx-1)/2;
    }
    
    private static int left(int indx){
        return indx*2 + 1;
    }
    
    private static int right(int indx){
        return indx*2 + 2;
    }
}
