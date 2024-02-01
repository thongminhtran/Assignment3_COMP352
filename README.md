# Priority Queue Implementation and Performance Analysis

## Project Overview
This project involves the implementation and testing of a priority queue (PQ) interface, `MyPQ<K,V>`, in four different ways: array-based and linked list-based, each in sorted and unsorted variants. The aim is to analyze the performance of these implementations in terms of insertion and removal operations.

## Programming Requirements

### Implementations
1. **Array-Based Implementations**
   - **MyPQUnsortedArray<K,V>**: Utilizes an unsorted array to manage PQ elements, doubling capacity when full and halving it when underutilized.
   - **MyPQSortedArray<K,V>**: Manages elements in a sorted array, ensuring efficient min operations and capacity adjustments similar to the unsorted version.
   
2. **Linked List-Based Implementations**
   - **MyPQUnsortedList<K,V>**: Employs a doubly linked list to store elements in an unsorted manner, with insertion at the end and linear search for min operations.
   - **MyPQSortedList<K,V>**: Stores elements in a sorted doubly linked list, optimizing min operations while maintaining insertion efficiency.

### Constraints
- Do not use Java Collections or the Java Collection Framework.
- Implementations should support the basic functionalities required by the `MyPQ<K,V>` interface without needing to replicate the full extent of Java’s ArrayList or LinkedList classes.

### Testing Program: PQTester
- **Objective**: Test the performance of each PQ implementation.
- **Procedure**:
  1. For each N in `{10, 100, 1000, 10000, 100000, 1000000}`, prepare an input file based on the size range and corresponding test file.
  2. Measure the time taken to insert N `<Integer, String>` elements into each PQ variant.
  3. Measure the time taken to remove all elements from each PQ.
  4. Record and save the timing results in a table format to `pqtestrun.txt`.

### Performance Measurement
- Record the time for insert and remove operations for each implementation at different scales (N).
- If operations for larger N values exceed practical time limits (e.g., more than 50 seconds), adjust the N range accordingly.

### Error Handling and Boundary Cases
- Ensure robustness against boundary cases such as operations on an empty queue.

## Deliverables
1. Source code for all PQ implementations and the testing program (`PQTester`).
2. The `pqtestrun.txt` file containing the performance analysis table.
3. A comprehensive test plan that includes boundary case handling.
