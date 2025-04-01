package src.Graphs;

public class Main {
    public static void main(String[] args) throws Exception {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.add(4);
        graph.add(5);
        graph.connectWith(1, new Integer[] {2,3});
        graph.connectWith(2, new Integer[] {1, 4});
        graph.connectWith(3, new Integer[] {4, 1, 5});
        graph.connectWith(4, new Integer[] {2, 3, 5});
        graph.connectWith(5, new Integer[] {3, 4});
        graph.add(10);
        graph.display();
    }
}