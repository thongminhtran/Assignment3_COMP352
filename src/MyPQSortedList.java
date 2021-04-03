public class MyPQSortedList implements MyPQ<Integer, String> {
    public class Node {
        public Entry entry;
        public Node next;
        public Node prev;
        public Node(Entry entry) {
            this.entry = entry;
        }
    }
    private Node head, tail = null;
    private int size = 0;


    @Override
    public void insert(Integer k, String v) {
        Entry entry = new Entry(k, v);
        // 1, 2, 3, 5 ==> insert 4, find 3's position = 2 ==> insert with position = 2+1 ==> 1,2,3,4,5
        int positionShouldInsert = findPositionOfEntryLessThanNewValue(k);
        try{
            insertNodeAtPosition(new Node(entry), positionShouldInsert == -1 ? 0 : positionShouldInsert);
        }catch(Exception e) {
            System.out.println("Exception when insert " + e.getMessage());
        }
    }
    @Override
    public Entry min() {
        if (isEmpty())
            return null;
        return head.entry;
    }
    @Override
    public Entry removeMin() {
        if (isEmpty())
            return null;
        head = head.next;
        head.prev = null;
        size--;
        return this.min();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    /**
     *
     * @param node: Node that we want to insert
     * @param position: position of the list I want to insert, example 0 means the first, current length + 1 is the final position
     * @throws Exception when the position is not valid < 0
     */
    private void insertNodeAtPosition(Node node, int position) throws Exception {
        // 1-2-3 ==> position = 0; node = 5 ==> 5-1-2-3
        // 1-2-3 ==> position = 1; node = 5 ==> 1-5-2-3
        // 1-2-3 ==> position = 2; node = 5 ==> 1-2-5-3
        // 1-2-3 ==> position = 3; node = 5 ==> 1-2-3-5
        boolean isPositionValid = position >= 0;
        if (!isPositionValid) throw new Exception("Position must be more than or equals with 0.");
        Node current = head;
        if(position == 0){
            if(isEmpty()){
                tail = node;
            }else{
                head.prev = node;
            }
            node.next = head;
            head = node;
            size++;
        } else if(position == size){
            if(isEmpty()){
                head = node;
            }else{
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            size++;
        }else{
            for(int j = 0; j < position && current.next != null; j++){
                current = current.next;
            }
            node.next = current;
            current.prev.next = node;
            node.prev = current.prev;
            current.prev = node;
            size++;
        }
    }

    /**
     * 1,2,3,5 == insert 6, find 3 and output = 2;
     * @param newValueK: The value I want to insert to this list
     * @return the position that this value should be inserted inside the list
     */
    private int findPositionOfEntryLessThanNewValue(Integer newValueK) {

        if (isEmpty()) return -1;
        Node currentNode = head;
        int checkingPosition = 0;
        while(currentNode != null) {
            if (currentNode.entry.getK() < newValueK) {
                currentNode = currentNode.next;
                checkingPosition++;
            } else {
                return checkingPosition;
            }
        }
        return checkingPosition;
    }
}
