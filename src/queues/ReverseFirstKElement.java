import java.util.LinkedList;
import java.util.Queue;

public class ReverseFirstKElement {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = 3;
        Queue<Integer> q1 = new LinkedList<>();
        while (k > 0) {
            q1.add(q.remove());
            k--;
        }
        reverse(q1);
        while (!q.isEmpty()) {
            q1.add(q.remove());
        }
        System.out.println(q1);
    }
    public static void reverse(Queue<Integer> queue){
        if(queue.isEmpty()){
            return;
        }
        int num = queue.peek();
        queue.remove();
        reverse(queue);
        queue.add(num);
    }
}
