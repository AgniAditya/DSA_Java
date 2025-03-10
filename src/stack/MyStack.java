import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int size = 0;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.add(x);
        size++;
    }
    
    public int pop() {
        while(queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        int num = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        size--;
        return num;
    }
    
    public int top() {
        while(queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        int num = queue1.remove();
        queue2.add(num);
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return num;
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */