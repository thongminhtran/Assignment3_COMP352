import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PQTester {

    public static int N = 10;

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
//        myPQSortedArray.insert(2,"Thong");
//        myPQSortedArray.insert(5, "An");

//        myPQUnsortedList.insert(12,"erjrfef");
//        myPQUnsortedList.insert(15,"evetrwq");
//        myPQUnsortedList.insert(9,"klerjhb");
//        myPQUnsortedList.insert(4,"kwenkjwen");

        Scanner scanner = new Scanner(new File("elements_test_file1.txt"));
        int count = 0;
        MyPQSortedArray myPQSortedArray = new MyPQSortedArray();
        double startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            String line = scanner.nextLine();
            myPQSortedArray.insert(generateRandomInteger(),line);
            count++;
        }
        double stopTime = System.nanoTime();
        double totalTime = (stopTime-startTime)/1000000.0;
        System.out.println("Running time of insert function of sorted array is "+totalTime);
        MYPQUnsortedArray mypqUnsortedArray = new MYPQUnsortedArray();
        count = 0;
        startTime = System.nanoTime();
        while (scanner.hasNextLine()&&count<N){
            String line = scanner.nextLine();
            mypqUnsortedArray.insert(generateRandomInteger(),line);
            count++;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime-startTime)/1000000.0;
        System.out.println("Running time of insert function of unsorted array is "+totalTime);
        startTime = System.nanoTime();
        count = N;
        while (count>1){
            mypqUnsortedArray.removeMin();
            count--;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime-startTime)/1000000.0;
        System.out.println("Running time of remove function of unsortedArray: "+totalTime);
        startTime = System.nanoTime();
        count = N;
        while (count>1){
            myPQSortedArray.removeMin();
            count--;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime-startTime)/1000000.0;
        System.out.println("Running time of remove function of sortedArray: "+totalTime);

        Entry entry = new Entry(12,"erfner");
        Entry entry1 = new Entry(53,"rjnkr");
        Entry entry2 = new Entry(3, "rgref");
        Entry entry3 = new Entry(5,"kjrenkjn");
//        LinkedList linkedList = new LinkedList();
//        linkedList.insertLast(entry1);
//        linkedList.insertLast(entry1);
//        linkedList.insertLast(entry3);
//        linkedList.printLinkedListForward();

        // Test / Debug
        MyPQUnsortedList myPQUnsortedList = new MyPQUnsortedList();
        myPQUnsortedList.insert(12,"vercer");
        myPQUnsortedList.printLinkedListForward();

//        MyPQSortedArray myPQSortedArray = new MyPQSortedArray();
//        myPQSortedArray.insert(4,"thong");
//        myPQSortedArray.insert(9,"rghiw");
//        myPQSortedArray.insert(7,"asf");
//        myPQSortedArray.insert(1,"sdfvrt");
//        myPQSortedArray.printArray();
    }

    /**
     * Generate a random integer from range 1 to N
     */
    public static Integer generateRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, N + 1);
    }
}
