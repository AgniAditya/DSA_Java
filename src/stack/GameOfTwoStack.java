public class GameOfTwoStack {
    public static void main(String[] args) {
        int[] a = {4, 3, 2};
        int[] b = {1, 2, 3, 10};
        int maxSum = 22;

        if (a.length == 0 || b.length == 0) {
            System.out.println(Math.max(a.length, b.length));
            return;
        }

        System.out.println(maxCount(a, b, 0, 0, 0, 0,maxSum));
    }

    static int maxCount(int[] stack1, int[] stack2, int sum, int count, int i, int j, int maxSum) {
        if (sum > maxSum || i >= stack1.length || j >= stack2.length) {
            return count;
        }
        int FromStack1 = maxCount(stack1, stack2, sum + stack1[i], count + 1, i + 1, j, maxSum);
        int FromStack2 = maxCount(stack1, stack2, sum + stack2[j], count + 1, i, j + 1, maxSum);
        return Math.max(FromStack1, FromStack2);
    }
}
