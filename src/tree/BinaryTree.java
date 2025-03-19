import java.util.Scanner;
public class BinaryTree{

    private class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public Node root;

    public BinaryTree(){
        root = null;
    }

    public void populated(Scanner scanner){
        System.out.print("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populated(scanner,root);
    }

    private void populated(Scanner scanner,Node node){
        System.out.print("Do you want to insert to left of "+ node.data + ": ");
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.print("Enter the left node value :" );
            int val = scanner.nextInt();
            node.left = new Node(val);
            populated(scanner,node.left);
        }
        System.out.print("Do you want to insert to right of "+ node.data + ": ");
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.print("Enter the right node value : ");
            int val = scanner.nextInt();
            node.right = new Node(val);
            populated(scanner,node.right);
        }
    }

    public void display(){
        show(this.root);
    }

    private void show(Node root){
        if(root == null){
            System.out.println("Empty tree");
            return;
        }
        System.out.print(root.data + " ");
        if(root.left != null){
            show(root.left);
        }
        if(root.right != null){
            show(root.right);
        }
    }
}