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
        // TODO:
        return null;
    }
    public Entry removeMin(){
        //TODO
        return null;
    }
    public int size(){
        return this.size;
    }
}
