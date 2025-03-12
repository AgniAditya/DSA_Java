// package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(40);
        tree.insert(50);
        tree.insert(20);
        tree.insert(5);
        tree.insert(7);
        tree.insert(15);
        tree.display();
        System.out.println(BFS(tree.root));
    }
    
    static List<List<Integer>> BFS(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < level; i++){
                Node node = queue.poll();
                list.add(node.data);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
        public int getValue(){
            return data;
        }
    }
    public static class Tree {
        Node root;
        Tree(){
            this.root = null;
        }
        public void insert(int val){
            Node newnode = new Node(val);
            if(root ==  null){
                root = newnode;
                return;
            }
            root = add(root,val);
        }
        private Node add(Node curr,int val){
            if(curr == null){
                Node newnode = new Node(val);
                return newnode;
            }
            if(curr.data < val){
                curr.right = add(curr.right, val);
            }
            else if(curr.data > val){
                curr.left = add(curr.left, val);
            }
            
            return curr;
        }
        public void display(){
            display(root,"Root Node: ");
        }
        
        private void display(Node node , String details){
            if(node == null){
                return;
            }
            System.out.println(details + node.getValue());
            display(node.left , "Left Child of " + node.getValue() + " : ");
            display(node.right , "Right Child of " + node.getValue() + " : ");
        }
    }
}