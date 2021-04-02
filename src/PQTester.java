import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PQTester {

    public static int N = 9999;

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
//        myPQSortedArray.insert(2,"Thong");
//        myPQSortedArray.insert(5, "An");

//        myPQUnsortedList.insert(12,"erjrfef");
//        myPQUnsortedList.insert(15,"evetrwq");
//        myPQUnsortedList.insert(9,"klerjhb");
//        myPQUnsortedList.insert(4,"kwenkjwen");
        String pathName = "";
        if(N>=1 && N<10000){
            pathName = "elements_test_file1.txt";
        }
        else if(N>=10000&&N<100000){
            pathName = "elements_test_file2.txt";
        }
        else if(N>=100000 &&N<=1000000){
            pathName = "elements_test_file3.txt";
        }
        else{
            System.out.println("N is out of range => Exit");
            System.exit(0);
        }
        Scanner scanner = new Scanner(new File(pathName));
        int count = 0;
        MyPQSortedArray myPQSortedArray = new MyPQSortedArray();

        //Measure running time of Sorted Array
        double startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            myPQSortedArray.insert(generateRandomInteger(), scanner.nextLine());
            count++;
        }
        double stopTime = System.nanoTime();
        double totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of insert function of sorted array is " + totalTime);
        startTime = System.nanoTime();
        count = N;
        while (count > 1) {
            myPQSortedArray.removeMin();
            count--;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of remove function of sortedArray: " + totalTime);

        //Measure running time of unsorted array
        MYPQUnsortedArray mypqUnsortedArray = new MYPQUnsortedArray();
        count = 0;
        startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            mypqUnsortedArray.insert(generateRandomInteger(), scanner.nextLine());
            count++;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of insert function of unsorted array is " + totalTime);
        startTime = System.nanoTime();
        count = N;
        while (count > 1) {
            mypqUnsortedArray.removeMin();
            count--;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of remove function of unsorted array: " + totalTime);

        //Measure running time of UnsortedList
        MyPQUnsortedList myPQUnsortedList = new MyPQUnsortedList();
        count = 0;
        startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            myPQUnsortedList.insert(generateRandomInteger(), scanner.nextLine());
            count++;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of insert function of unsorted list is " + totalTime);
        startTime = System.nanoTime();
        count = N;
        while (count > 1) {
            myPQUnsortedList.removeMin();
            count--;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of remove function of unsorted list: " + totalTime);

        //Measure running time of sorted list
        MyPQSortedList myPQSortedList = new MyPQSortedList();
        count = 0;
        startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            myPQSortedList.insert(generateRandomInteger(), scanner.nextLine());
            count++;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of insert function of sorted list is " + totalTime);
        startTime = System.nanoTime();
        count = N;
        while (count > 1) {
            myPQSortedList.removeMin();
            count--;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of remove function of sorted list: " + totalTime);
    }

    /**
     * Generate a random integer from range 1 to N
     */
    public static Integer generateRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, N + 1);
    }
}
