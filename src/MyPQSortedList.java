public class MyPQSortedList implements MyPQ<Integer, String> {
    public class Node {
        public Entry entry;
        public Node next;
        public Node prev;

        public Node(Entry entry) {
            this.entry = entry;
        }

        public void displayNodeData() {
            System.out.println("k= " + entry.getK() + "value= " + entry.getV() + "-->");
        }
    }

    private Node head, tail = null;

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
        //2. check if the position is > 0
        boolean isPositionValid = position >= 0;
        if (!isPositionValid) throw new Exception("Position must be more than or equals with 0.");
        if (position == 0) {
            // insert at the beginning of the list
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node temporaryNode = new Node(node.entry);
            temporaryNode = head;
            for (int i = 0; i <= position; i++) {
                if (temporaryNode != null) {
                    temporaryNode = temporaryNode.next;
                }
            }
            if (temporaryNode != null) {
                node.next = temporaryNode.next;
                node.prev = temporaryNode;
                temporaryNode.next = node;
                if (node.next != null)
                    node.next.prev = node;
            }
        }
        //if list is empty, head and tail points to this node
        if (head == null) {
            head = tail = node;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
    }
    private int findPositionOfEntryLessThanNewValue(Integer newValueK)
    {
        // 1,2,3,5 == insert 6, find 3 and output = 2;
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
    @Override
    public void insert(Integer k, String v) {
        int size = size();
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
        return this.min();
    }

    @Override
    public int size() {
        int size = 0;
        Node currentNode = head;
        while(currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
