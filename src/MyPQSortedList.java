public class MyPQSortedList implements MyPQ<Integer,String> {
    public class Node{
        public Entry data;
        public Node next;
        public Node prev;
        public void displayNodeData(){
            System.out.println("k= "+data.getK()+"value= "+data.getV()+"-->");
        }
    }

    public MyPQSortedList(){

    }
    private Node head;
    private Node tail;
    int size;
    public void insert(Integer k, String v) {
        //TODO: I have written the unsorted insert algorithm, it needs to be modified
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
        sortList();
    }
    public void sortList(){
        // Reference: https://www.javatpoint.com/java-program-to-sort-the-elements-of-the-doubly-linked-list
        Node current = null, index = null;
        Entry temp;
        if(head == null)
            return;
        else{
            for(current=head;current.next!=null;current=current.next){
                for(index = current.next;index!=null;index=index.next){
                    if(current.data.getK()>index.data.getK()){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
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

    @Override
    public Entry min() {
        if(isEmpty())
            return null;
        return head.data;
    }

    @Override
    public Entry removeMin() {
        if(isEmpty())
            return null;
        head = head.next;
        head.prev = null;
        size--;
        return this.min();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }
}
