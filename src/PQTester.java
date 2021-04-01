public class PQTester {

    public static void main(String[] args) {
	// write your code here
        Entry entry1 = new Entry(2,"thong");
        Entry entry2 = new Entry(4,"thinh");
        MyPQSortedArray myPQSortedArray = new MyPQSortedArray();
        myPQSortedArray.insert(2,"Thong");
        myPQSortedArray.insert(5,

                "An");
        myPQSortedArray.printArray();
    }
}
