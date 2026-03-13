import java.util.Arrays;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Vertexs : ");
        int numOfVertex = sc.nextInt();
        int[][] adj = new int[numOfVertex][numOfVertex];
        while (numOfVertex-- > 0) {
            System.out.print("Enter vertex number : ");
            int vertex = sc.nextInt();
            if(vertex >= numOfVertex){
                System.out.println(vertex + " is greater or equal to " + numOfVertex);
                continue;
            }
            System.out.print("Enter number of nieghbours of " + vertex + " : ");
            int numOfniegh = sc.nextInt();
            while (numOfniegh-- > 0) {
                System.out.print("Enter nieghbour of " + vertex + " : ");
                int nieghbour = sc.nextInt();
                adj[vertex][nieghbour] = 1;
                adj[nieghbour][vertex] = 1;
            }
        }

        for(int[] row : adj){
            System.out.println(Arrays.toString(row));
        }
    }
}
