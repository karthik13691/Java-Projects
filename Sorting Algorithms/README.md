# Sorting Algorithms

This project implements and tests various sorting algorithms in Java. It includes implementations of:

- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort

## Algorithm Implementations

All sorting algorithms are implemented in the `Sorting` class:

### Bubble Sort
- **Time Complexity**: O(n²) in worst and average cases, O(n) in best case (optimized version)
- **Space Complexity**: O(1)
- **Description**: Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
- **Best Use Case**: Small arrays or nearly sorted arrays

### Selection Sort
- **Time Complexity**: O(n²) in all cases
- **Space Complexity**: O(1)
- **Description**: Repeatedly finds the minimum element from the unsorted part and puts it at the beginning.
- **Best Use Case**: Small arrays where memory usage is a concern

### Insertion Sort
- **Time Complexity**: O(n²) in worst and average cases, O(n) in best case
- **Space Complexity**: O(1)
- **Description**: Builds the sorted array one item at a time by comparing each with the items before it.
- **Best Use Case**: Small arrays or nearly sorted arrays

### Merge Sort
- **Time Complexity**: O(n log n) in all cases
- **Space Complexity**: O(n)
- **Description**: Divides the array into two halves, sorts them separately, and then merges them.
- **Best Use Case**: Large arrays where stable sorting is required

### Quick Sort
- **Time Complexity**: O(n log n) in average and best cases, O(n²) in worst case
- **Space Complexity**: O(log n) due to recursion
- **Description**: Picks an element as pivot and partitions the array around the pivot.
- **Best Use Case**: Large arrays where average-case performance is important

## Testing

The project includes comprehensive tests for all sorting algorithms:

1. **Correctness Tests**: Verify that each algorithm correctly sorts arrays
2. **Performance Tests**: Measure and compare the execution time of each algorithm on:
   - Small arrays (100 elements)
   - Medium arrays (1,000 elements)
   - Large arrays (10,000 elements)
   - Very large arrays (100,000 elements) - only for O(n log n) algorithms
   - Already sorted arrays (best-case scenario)
   - Reverse-sorted arrays (worst-case scenario for some algorithms)

## How to Run

### Running the Main Program

```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.sample.Sorting"
```

### Running the Tests

```bash
mvn test
```

## Performance Comparison

The performance of sorting algorithms varies based on:

1. **Input Size**: As the size of the array increases, the difference between O(n²) and O(n log n) algorithms becomes more significant.
2. **Initial Order**: Some algorithms perform better on partially sorted arrays.
3. **Stability**: Some applications require maintaining the relative order of equal elements.

### Expected Results

- For small arrays (< 100 elements): All algorithms perform similarly
- For medium arrays (100-1,000 elements): Insertion sort may outperform merge sort for nearly sorted data
- For large arrays (> 1,000 elements): Merge sort and quick sort significantly outperform the O(n²) algorithms
- For very large arrays (> 10,000 elements): The O(n²) algorithms become impractical

## Additional Ways to Test Sorting Algorithms

1. **Memory Usage**: Use a profiler to measure memory consumption during sorting
2. **Cache Performance**: Test with arrays that fit in CPU cache vs. larger arrays
3. **Stability Testing**: Check if the relative order of equal elements is preserved
4. **Specialized Input**: Test with:
   - Arrays with many duplicate elements
   - Arrays with few unique values
   - Arrays with specific patterns (e.g., saw-tooth pattern)
5. **Parallel Implementations**: Compare single-threaded vs. multi-threaded versions
6. **Hybrid Algorithms**: Implement and test hybrid approaches (e.g., Timsort)
7. **External Sorting**: Test algorithms for data that doesn't fit in memory

## Visualization

For educational purposes, consider adding visualization of the sorting process using:
- Console-based animation
- GUI-based visualization
- Step-by-step execution with state display
