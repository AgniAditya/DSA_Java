import java.util.Arrays;

public class SegmentTree {
    
    private class Node {
        int data;
        int startindex;
        int endindex;
        Node left;
        Node right;
        public Node(int startindex,int endindex){
            this.endindex = endindex;
            this.startindex = startindex;
        }

        public int getValue(){
            return data;
        }

        public int[] getRange(){
            if(startindex == endindex){
                return new int[] {startindex};
            }
            return new int[] {startindex,endindex};
        }
    }

    Node root;
    int[] nums;

    public SegmentTree(){
        this.root = null;
    }

    public SegmentTree(int[] arr){
        this.nums = arr;
        this.root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr,int startindex,int endindex){
        if(startindex == endindex){
            Node newNode = new Node(startindex,endindex);
            newNode.data = arr[startindex];
            return newNode;
        }
        Node newNode = new Node(startindex,endindex);
        int mid = (startindex + endindex)/2;
        newNode.left = constructTree(arr, startindex, mid);
        newNode.right = constructTree(arr, mid+1, endindex);
        newNode.data = newNode.left.data + newNode.right.data;
        return newNode;
    }

    public void display(){
        display(root,"Root Node: ");
    }
    
    private void display(Node node , String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue() + " of Range " +Arrays.toString(node.getRange()));
        display(node.left , "Left Child of " + node.getValue() + " : ");
        display(node.right , "Right Child of " + node.getValue() + " : ");
    }

    public int query(int startindex,int endindex) throws Exception{
        if(startindex < 0 && endindex >= nums.length){
            throw new ArithmeticException("Not Valid Range");
        }
        return query(root,startindex, endindex);
    }

    private int query(Node root, int startindex,int endindex){
        if(root.startindex >= startindex && root.endindex <= endindex){
            return root.data;
        }
        else if(root.startindex > endindex || root.endindex < startindex){
            return 0;
        }
        else {
            return this.query(root.left,startindex, endindex) + this.query(root.right,startindex, endindex);
        }
    }

    public void update(int index, int val){
        this.root.data = update(root,index, val);
    }

    private int update(Node root, int index,int val){
        if(index >= root.startindex && index <= root.endindex){
            if(root.startindex == root.endindex){
                root.data = val;
                return root.data;
            }
            else{
                int left = update(root.left,index, val);
                int right = update(root.right,index, val);
                root.data = left + right;
                return root.data;
            }
        }
        return root.data;
    }

    public int rootValue(){
        return root.data;
    }
}