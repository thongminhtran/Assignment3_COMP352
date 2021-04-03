public class MyPQUnsortedList implements MyPQ<Integer, String> {
    public class Node {
        public Entry entry;
        public Node next;
        public Node prev;

        public Node(Entry entry) {
            this.entry = entry;
        }
    }

    private Node head, tail;
    int size;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insert(Integer k, String v) {
        Entry entry = new Entry(k, v);
        Node newNode = new Node(entry);
        newNode.next = null;
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null)
            head = newNode;
        size++;
    }

    @Override
    public Entry min() {
        if (isEmpty())
            return null;
        Node current = head;
        Entry currentMinEntry = current.entry;
        while (current != null) {
            if (currentMinEntry.getK() > current.entry.getK()) {
                currentMinEntry = current.entry;
            }
            current = current.next;
        }
        return currentMinEntry;
    }

    // Delete from Doubly linked list: https://stackoverflow.com/questions/49700276/deleting-from-doubly-linked-list-java
    @Override
    public Entry removeMin() {
        if (isEmpty())
            return null;
        Node current = head;
        Entry minEntry = min();
        while (current != null && current.entry != this.min()) {
            current = current.next;
        }
        deleteNode(current);
        return minEntry;
    }

    private void deleteNode(Node node) {
        if (node != null) {
            if (node.prev != null)
                node.prev.next = node.next;
            else {
                head = node.next;
            }
            if (node.next != null)
                node.next.prev = node.prev;
            else
                tail = node.prev;
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
