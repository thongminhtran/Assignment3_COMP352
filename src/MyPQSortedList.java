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
    }

    @Override
    public Entry min() {
        //TODO
        return null;
    }

    @Override
    public Entry removeMin() {
        //TODO
        return null;
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
