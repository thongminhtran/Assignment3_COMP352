public class PQTester {

    public static void main(String[] args) {
	// write your code here
        Entry entry1 = new Entry(2,"thong");
        Entry entry2 = new Entry(4,"thinh");
//        MyPQSortedArray myPQSortedArray = new MyPQSortedArray();
//        myPQSortedArray.insert(2,"Thong");
//        myPQSortedArray.insert(5, "An");
        LinkedList linkedList = new LinkedList();
        linkedList.insertLast(entry1);
        linkedList.insertLast(entry1);
        linkedList.insertLast(entry1);
        linkedList.insertLast(entry1);
        linkedList.insertLast(entry1);
        linkedList.insertLast(entry2);
        linkedList.deleteFirst();
        linkedList.printLinkedListForward();
//        myPQSortedArray.printArray();
    }
}
