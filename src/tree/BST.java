public class BST {
    private class Node{
        int data;
        int height;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }

        public int getValue(){
            return data;
        }
    }

    private Node root;

    public BST(){
        root = null;
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
        
        curr.height = Math.max(height(curr.left),height(curr.right) + 1);
        
        return curr;
    }
    
    public boolean balanced(){
        return balanced(root);
    }
    
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    
    public boolean isEmpty(){
        return root == null;
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
    
    public boolean search(int val){
        if(isEmpty()){
            return false;
        }
        return search(root,val);
    }
    
    private boolean search(Node curr, int val){
        if(curr == null){
            return false;
        }
        if(curr.data > val){
            return search(curr.left,val);
        }
        else if(curr.data < val){
            return search(curr.right,val);
        }
        return true;
    }
}