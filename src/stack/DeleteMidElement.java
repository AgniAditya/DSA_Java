import java.util.Stack;

public class DeleteMidElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        Stack<Integer> temp = new Stack<>();
        int len = stack.size()/2;
        while (len > 0) {
            temp.push(stack.pop());
            len--;
        }
        stack.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println(stack);
    }
}
