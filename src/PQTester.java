import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PQTester {

    public static int N = 100000;

    public static void main(String[] args) throws FileNotFoundException {
        String pathName = "";
        if (N >= 1 && N < 10000) {
            pathName = "elements_test_file1.txt";
        } else if (N >= 10000 && N < 100000) {
            pathName = "elements_test_file2.txt";
        } else if (N >= 100000 && N <= 1000000) {
            pathName = "elements_test_file3.txt";
        } else {
            System.out.println("N is out of range => Exit");
            System.exit(0);
        }
        Scanner scanner = new Scanner(new File(pathName));
        testSortedArray(scanner);
        testUnsortedArray(scanner);
        testUnSortedList(scanner);
        testSortedList(scanner);
    }

    public static void testSortedList(Scanner scanner) {
        MyPQSortedList myPQSortedList = new MyPQSortedList();
        double count = 0;
        double startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            myPQSortedList.insert(generateRandomInteger(), scanner.nextLine());
            count++;
        }
        double stopTime = System.nanoTime();
        double totalTime = (stopTime - startTime) / 1000000.0;
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

    public static void testUnSortedList(Scanner scanner) {
        MyPQUnsortedList myPQUnsortedList = new MyPQUnsortedList();
        int count = 0;
        double startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            myPQUnsortedList.insert(generateRandomInteger(), scanner.nextLine());
            count++;
        }
        double stopTime = System.nanoTime();
        double totalTime = (stopTime - startTime) / 1000000.0;
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
    }

    public static void testUnsortedArray(Scanner scanner) {
        MYPQUnsortedArray mypqUnsortedArray = new MYPQUnsortedArray();
        int count = 0;
        double startTime = System.nanoTime();
        while (scanner.hasNextLine() && count < N) {
            mypqUnsortedArray.insert(generateRandomInteger(), scanner.nextLine());
            count++;
        }
        double stopTime = System.nanoTime();
        double totalTime = (stopTime - startTime) / 1000000.0;
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
    }

    public static void testSortedArray(Scanner scanner) {
        int realSize = 0;
        MyPQSortedArray myPQSortedArray = new MyPQSortedArray();
        // Read file
        double startTime = System.nanoTime();
        while (scanner.hasNextLine() && realSize < N) {
            myPQSortedArray.insert(generateRandomInteger(), scanner.nextLine());
            realSize++;
        }
        double stopTime = System.nanoTime();
        double totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of insert function of sorted array is " + totalTime);
        startTime = System.nanoTime();
        realSize = N;
        while (realSize > 1) {
            myPQSortedArray.removeMin();
            realSize--;
        }
        stopTime = System.nanoTime();
        totalTime = (stopTime - startTime) / 1000000.0;
        System.out.println("Running time of remove function of sortedArray: " + totalTime);
    }

    /**
     * Generate a random integer from range 1 to N
     */
    public static Integer generateRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, N + 1);
    }
}
