public class DLL {
    Node head;
    Node tail;


    public void insert(int val){
        Node node= new Node(val);
        if(head==null){
            head=tail=node;
            node.prev=null;
            node.next=null;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
            tail.next=null;
        }
    }

    public void insert(int index,int val){
        Node node= new Node(val);
        Node temp=head;
        if(head==null){
            insert(val);
            index=0;
            return;
        }
        if(index==0){
            insertFirst(val);
            return;
        }
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next.prev=node;
        temp.next=node;
        node.prev=temp;
    }
    
    public void insertafter(int beforeval,int val){
        Node node = new Node(val);
        Node temp = head;
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        while (temp!=null){
            if(temp.val==beforeval){
                break;
            }
            temp=temp.next;
        }
        if(temp!=null){
            node.next=temp.next;
            temp.next.prev=node;
            temp.next=node;
            node.prev=temp;
            return;
        }
        System.out.println(beforeval+" it does not exist in the List");
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        if(head==null){
            insert(val);
            return;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
            head.prev=null;
        }
    }
    
    public void insertLast(int val){
        Node node = new Node(val);
        if(tail==null){
            insert(val);
            return;
        }
        tail.next=node;
        node.prev=tail;
        tail=node;
        tail.next=null;
    }
    
    public void display(){
        Node temp=head;
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
    
    public void displayreverse(){
        Node last=tail;
        if(tail==null){
            System.out.println("Empty List");
            return;
        }
        while (last!=null) {
            System.out.print(last.val+" -> ");
            last=last.prev;
        }
        System.out.println("START");
    }

    private class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val=val;
        }

        public Node(int val,Node next,Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }

    public static void main(String args[]){
        DLL dll=new DLL();
        dll.insert(12);
        dll.insert(23);
        dll.insert(40);
        dll.insert(0);
        dll.insert(10);
        dll.insert(9);
        dll.insertFirst(100);
        dll.insertLast(200);
        dll.display();
        dll.insert(3,89);
        dll.display();
        dll.insertafter(40, 45);
        dll.display();
    }
}