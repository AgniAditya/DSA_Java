import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AlienDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of character: ");
        int characters = sc.nextInt();
        while (characters < 1 || characters > 26) {
            System.out.println("Characters not in valid range");
            System.out.println("Range is 1 to 26");
        }

        System.out.print("Enter the number of words: ");
        int wordslen = sc.nextInt();
        ArrayList<String> words = new ArrayList<>();

        while (wordslen-- > 0) {
            System.out.print("Enter the word: ");
            String word = sc.next();
            words.add(word);
        }
        System.out.print("The Alien order of the words: ");
        System.out.println(findOrder(words,characters));
    }

    private static String findOrder(ArrayList<String> words,int k){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < k; i++){
            adj.add(new ArrayList<>());
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < words.size() - 1; i++){
            String s1 = words.get(i);
            String s2 = words.get(i+1);
            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        ArrayList<Integer> topo = kahns_algo(adj);

        for(int i = 0; i < topo.size(); i++){
            str.append((char)(topo.get(i)+'a'));
        }

        return str.toString();
    }

    private static ArrayList<Integer> kahns_algo(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> kahnsSort = new ArrayList<>();
        int[] indegree = new int[adj.size()];

        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                indegree[adj.get(i).get(j)] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }
            kahnsSort.add(node);
        }

        return kahnsSort;
    }
}
