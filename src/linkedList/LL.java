public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL(){
        this.size=0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public void insert(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node =new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public void insert(int index,int val){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        Node node =new Node(val,temp.next);
        temp.next=node;

        size++;
    }

    public void insertrec(int val){
        if(size == 0){
            Node newnode = new Node(val);
            head = newnode;
            return;
        }
        insertatrec(size,val);
    }

    public void insertatrec(int indx , int val){
        Node temp = head;
        insertatrec(indx, val, temp);
    }

    private void insertatrec(int index , int val,Node temp){
        if(index < 0 || index > size){
            System.out.println("Index not in range");
            return;
        }
        if(index == 0){
            Node newnode = new Node(val);
            newnode.next = head;
            head = newnode;
            size++;
            return;
        }
        if(index == 1){
            Node newnode = new Node(val);
            newnode.next = temp.next;
            temp.next = newnode;
            size++;
            return;
        }
        insertatrec(index-1, val,temp.next);
    }


    public int deleteFirst(){
        int val = head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        int val=tail.value;
        tail=temp;
        tail.next=null;
        return val;
    }

    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        int val=temp.next.value;
        temp.next=temp.next.next;
        return val;
    }

    public Node find(int val){
        Node node=head;
        while(node!=null){
            if(node.value==val){
                return node;
            }else{
                node=node.next;
            }
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println("");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
}
