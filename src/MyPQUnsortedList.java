public class MyPQUnsortedList implements MyPQ<Integer,String> {
    public class Node{
        public Entry data;
        public Node next;
        public Node prev;
        public void displayNodeData(){
            System.out.println("k= "+data.getK()+"value= "+data.getV()+"-->");
        }
    }
    public MyPQUnsortedList(){

    }
    private Node head;
    private Node tail;
    int size;
    public boolean isEmpty(){
        return head==null;
    }
    public void insert(Integer k,String v){
        Entry entry = new Entry(k,v);
        Node newNode = new Node();
        newNode.data = entry;
        newNode.next = null;
        newNode.prev = tail;
        if(tail!=null){
            tail.next=newNode;
        }
        tail=newNode;
        if(head==null)
            head=newNode;
        size++;
    }
    public void printLinkedListForward(){
        System.out.println("Printing Doubly LinkedList (head-->tail) ");
        Node current = head;
        while (current!=null){
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }
    public Entry min(){
        if(isEmpty())
            return null;
        Node current = head;
        int min = current.data.getK();
        while(current!=null){
            if(min > current.data.getK()){
                min = current.data.getK();
            }
            current = current.next;
        }
        current = head;
        while(current!=null){
            if(min == current.data.getK()){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    // Delete from Doubly linked list: https://stackoverflow.com/questions/49700276/deleting-from-doubly-linked-list-java
    public Entry removeMin(){
        if(isEmpty())
            return null;
        Node current = head;
        while (current!=null&&current.data!=this.min()){
            current = current.next;
        }
        deleteNode(current);
        return this.min();
    }
    public void deleteNode(Node node){
        if(node!=null){
            if(node.prev!=null)
                node.prev.next = node.next;
            else
                head = node.next;
            if(node.next!=null)
                node.next.prev = node.prev;
            else
                tail = node.prev;
        }
    }
    public int size(){
        return this.size;
    }
}
