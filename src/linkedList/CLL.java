public class CLL {
    
    private class node {
        node next;
        int data;

        public node(int data){
            this.data = data;
        }
        
        public node (int data, node next){
            this.data = data;
            this.next = next;
        }
    }

    private node head;
    private node tail;
    private int size;

    public CLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addAtFirst(int val){
        node newnode = new node(val);
        if(head == null){
            newnode.next = head;
            head = newnode;
            tail = head;
        }else{
            newnode.next = head;
            head = newnode;
        }
        tail.next = head;
        size++;
    }

    public void addAtLast(int val){
        node newnode = new node(val);
        if(tail == null){
            addAtFirst(val);
            return;
        }
        tail.next = newnode;
        newnode.next = head;
        tail = newnode;
        size++;
    }

    public void add(int val){
        addAtLast(val);
    }

    public void add(int index,int val){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            addAtFirst(val);
            return;
        }
        node newnode = new node(val);
        node temp = head;
        int cnt = 1;
        while(cnt < index){
            temp = temp.next;
            cnt++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        size++;
    }

    public void remove(){
        if(size == 0){
            System.out.println("Empty List");
            return;
        }
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail.next = null;
        tail = temp;
        tail.next = head;
        size--;
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }
        if(index == 0){
            head = head.next;
            tail.next = head;
            size--;
            return;
        }
        node temp = head;
        int cnt = 1;
        while(cnt < index){
            temp = temp.next;
            cnt++;
        }
        node next = temp.next;
        temp.next = next.next;
        next.next = null;
        size--;
    }

    public void removeall(){
        head = null;
        tail = null;
        size = 0;
    }

    public void display(){
        if(size == 0){
            System.out.println("Null");
            return;
        }
        node temp = head;
        System.out.print("HEAD -> ");
        while(temp != tail){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data + " -> " + "HEAD");
    }

    public int size(){
        return size;
    }
}
