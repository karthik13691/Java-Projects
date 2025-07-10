package org.sample;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for sorting algorithms.
 * Tests both correctness and performance of various sorting algorithms.
 */
public class SortingTest {

    private int[] smallArray;
    private int[] mediumArray;
    private int[] largeArray;
    private int[] veryLargeArray;
    private final Random random = new Random(42); // Fixed seed for reproducibility

    @BeforeEach
    public void setUp() {
        // Generate arrays of different sizes
        smallArray = generateRandomArray(100);
        mediumArray = generateRandomArray(1000);
        largeArray = generateRandomArray(10000);
        veryLargeArray = generateRandomArray(100000);
    }

    /**
     * Generates an array of random integers with a fixed seed for reproducibility.
     *
     * @param size The size of the array to generate
     * @return An array of random integers
     */
    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    /**
     * Verifies that an array is sorted in ascending order.
     *
     * @param array The array to check
     * @return true if the array is sorted, false otherwise
     */
    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tests the correctness of all sorting algorithms.
     */
    @Test
    @DisplayName("Test correctness of all sorting algorithms")
    public void testSortingCorrectness() {
        int[] testArray = {9, 5, 1, 8, 3, 10, 7, 6, 2, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Test Bubble Sort
        int[] bubbleSortArray = Arrays.copyOf(testArray, testArray.length);
        Sorting.bubbleSort(bubbleSortArray);
        assertArrayEquals(expected, bubbleSortArray, "Bubble Sort failed");

        // Test Selection Sort
        int[] selectionSortArray = Arrays.copyOf(testArray, testArray.length);
        Sorting.selectionSort(selectionSortArray);
        assertArrayEquals(expected, selectionSortArray, "Selection Sort failed");

        // Test Insertion Sort
        int[] insertionSortArray = Arrays.copyOf(testArray, testArray.length);
        Sorting.insertionSort(insertionSortArray);
        assertArrayEquals(expected, insertionSortArray, "Insertion Sort failed");

        // Test Merge Sort
        int[] mergeSortArray = Arrays.copyOf(testArray, testArray.length);
        Sorting.mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        assertArrayEquals(expected, mergeSortArray, "Merge Sort failed");

        // Test Quick Sort
        int[] quickSortArray = Arrays.copyOf(testArray, testArray.length);
        Sorting.quickSort(quickSortArray, 0, quickSortArray.length - 1);
        assertArrayEquals(expected, quickSortArray, "Quick Sort failed");
    }

    /**
     * Tests the performance of all sorting algorithms on small arrays.
     */
    @Test
    @DisplayName("Performance test on small arrays (100 elements)")
    public void testSmallArrayPerformance() {
        performPerformanceTest(smallArray, "Small Array (100 elements)");
    }

    /**
     * Tests the performance of all sorting algorithms on medium arrays.
     */
    @Test
    @DisplayName("Performance test on medium arrays (1,000 elements)")
    public void testMediumArrayPerformance() {
        performPerformanceTest(mediumArray, "Medium Array (1,000 elements)");
    }

    /**
     * Tests the performance of all sorting algorithms on large arrays.
     */
    @Test
    @DisplayName("Performance test on large arrays (10,000 elements)")
    public void testLargeArrayPerformance() {
        performPerformanceTest(largeArray, "Large Array (10,000 elements)");
    }

    /**
     * Tests the performance of O(n log n) algorithms on very large arrays.
     * Skips O(n²) algorithms which would take too long.
     */
    @Test
    @DisplayName("Performance test on very large arrays (100,000 elements)")
    public void testVeryLargeArrayPerformance() {
        System.out.println("Very Large Array (100,000 elements):");

        // Skip O(n²) algorithms for very large arrays
        System.out.println("Bubble Sort: Skipped (would take too long)");
        System.out.println("Selection Sort: Skipped (would take too long)");
        System.out.println("Insertion Sort: Skipped (would take too long)");

        // Test Merge Sort
        int[] array = Arrays.copyOf(veryLargeArray, veryLargeArray.length);
        long startTime = System.currentTimeMillis();
        Sorting.mergeSort(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.printf("Merge Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Merge Sort failed to sort the array");

        // Test Quick Sort
        array = Arrays.copyOf(veryLargeArray, veryLargeArray.length);
        startTime = System.currentTimeMillis();
        Sorting.quickSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.printf("Quick Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Quick Sort failed to sort the array");

        System.out.println();
    }

    /**
     * Tests the performance of all sorting algorithms on a given array.
     *
     * @param originalArray The array to sort
     * @param description Description of the test case
     */
    private void performPerformanceTest(int[] originalArray, String description) {
        System.out.println(description + ":");

        // Test Bubble Sort
        int[] array = Arrays.copyOf(originalArray, originalArray.length);
        long startTime = System.currentTimeMillis();
        Sorting.bubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.printf("Bubble Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Bubble Sort failed to sort the array");

        // Test Selection Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        Sorting.selectionSort(array);
        endTime = System.currentTimeMillis();
        System.out.printf("Selection Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Selection Sort failed to sort the array");

        // Test Insertion Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        Sorting.insertionSort(array);
        endTime = System.currentTimeMillis();
        System.out.printf("Insertion Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Insertion Sort failed to sort the array");

        // Test Merge Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        Sorting.mergeSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.printf("Merge Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Merge Sort failed to sort the array");

        // Test Quick Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        Sorting.quickSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.printf("Quick Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Quick Sort failed to sort the array");

        System.out.println();
    }

    /**
     * Tests the performance of sorting algorithms on already sorted arrays.
     * This is a best-case scenario for some algorithms.
     */
    @Test
    @DisplayName("Performance test on already sorted arrays")
    public void testSortedArrayPerformance() {
        int[] sortedArray = new int[10000];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }

        System.out.println("Already Sorted Array (10,000 elements):");

        // Test Bubble Sort (with optimization)
        int[] array = Arrays.copyOf(sortedArray, sortedArray.length);
        long startTime = System.currentTimeMillis();
        Sorting.bubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.printf("Bubble Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Bubble Sort failed to sort the array");

        // Test Selection Sort
        array = Arrays.copyOf(sortedArray, sortedArray.length);
        startTime = System.currentTimeMillis();
        Sorting.selectionSort(array);
        endTime = System.currentTimeMillis();
        System.out.printf("Selection Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Selection Sort failed to sort the array");

        // Test Insertion Sort
        array = Arrays.copyOf(sortedArray, sortedArray.length);
        startTime = System.currentTimeMillis();
        Sorting.insertionSort(array);
        endTime = System.currentTimeMillis();
        System.out.printf("Insertion Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Insertion Sort failed to sort the array");

        // Test Merge Sort
        array = Arrays.copyOf(sortedArray, sortedArray.length);
        startTime = System.currentTimeMillis();
        Sorting.mergeSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.printf("Merge Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Merge Sort failed to sort the array");

        // Test Quick Sort
        array = Arrays.copyOf(sortedArray, sortedArray.length);
        startTime = System.currentTimeMillis();
        Sorting.quickSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.printf("Quick Sort Time: %d ms%n", (endTime - startTime));
        assertTrue(isSorted(array), "Quick Sort failed to sort the array");

        System.out.println();
    }

    /**
     * Tests the performance of sorting algorithms on reverse-sorted arrays.
     * This is a worst-case scenario for some algorithms.
     */
    @Test
    @DisplayName("Performance test on reverse-sorted arrays")
    public void testReverseSortedArrayPerformance() {
        int[] reverseSortedArray = new int[10000];
        for (int i = 0; i < reverseSortedArray.length; i++) {
            reverseSortedArray[i] = reverseSortedArray.length - i;
        }

        System.out.println("Reverse Sorted Array (10,000 elements):");

        // Test each algorithm
        performPerformanceTest(reverseSortedArray, "Reverse Sorted Array (10,000 elements)");
    }
}
