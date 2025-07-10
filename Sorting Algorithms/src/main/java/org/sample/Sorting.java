package org.sample;

import java.util.Arrays;

/**
 * This class implements various sorting algorithms and provides methods to test their performance.
 */
public class Sorting {
    /**
     * Main method to test and compare different sorting algorithms.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Generate test arrays of different sizes
        int[] smallArray = arrayGenerator(100);
        int[] mediumArray = arrayGenerator(1000);
        int[] largeArray = arrayGenerator(10000);

        // Small test array for verification
        int[] testArray = {4, 5, 1, 0, 3};
        System.out.println("Original array: " + Arrays.toString(testArray));

        System.out.println("\n--- Functional Testing ---\n");
        // Test each sorting algorithm on the small test array
        int[] bubbleSortArray = Arrays.copyOf(testArray, testArray.length);
        bubbleSort(bubbleSortArray);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSortArray));

        int[] selectionSortArray = Arrays.copyOf(testArray, testArray.length);
        selectionSort(selectionSortArray);
        System.out.println("Selection Sort: " + Arrays.toString(selectionSortArray));

        int[] insertionSortArray = Arrays.copyOf(testArray, testArray.length);
        insertionSort(insertionSortArray);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSortArray));

        int[] mergeSortArray = Arrays.copyOf(testArray, testArray.length);
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeSortArray));

        int[] quickSortArray = Arrays.copyOf(testArray, testArray.length);
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickSortArray));

        System.out.println("\n--- Performance Testing ---\n");

        // Test performance on small array
        testSortingPerformance("Small Array (100 elements)", smallArray);

        // Test performance on medium array
        testSortingPerformance("Medium Array (1,000 elements)", mediumArray);

        // Test performance on large array
        testSortingPerformance("Large Array (10,000 elements)", largeArray);
    }

    /**
     * Tests the performance of all sorting algorithms on the given array.
     *
     * @param description Description of the test case
     * @param originalArray Array to be sorted
     */
    private static void testSortingPerformance(String description, int[] originalArray) {
        System.out.println(description + ":");

        // Test Bubble Sort
        int[] array = Arrays.copyOf(originalArray, originalArray.length);
        long startTime = System.currentTimeMillis();
        bubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.printf("Bubble Sort Time: %d ms%n", (endTime - startTime));

        // Test Selection Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        selectionSort(array);
        endTime = System.currentTimeMillis();
        System.out.printf("Selection Sort Time: %d ms%n", (endTime - startTime));

        // Test Insertion Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        insertionSort(array);
        endTime = System.currentTimeMillis();
        System.out.printf("Insertion Sort Time: %d ms%n", (endTime - startTime));

        // Test Merge Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.printf("Merge Sort Time: %d ms%n", (endTime - startTime));

        // Test Quick Sort
        array = Arrays.copyOf(originalArray, originalArray.length);
        startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        endTime = System.currentTimeMillis();
        System.out.printf("Quick Sort Time: %d ms%n", (endTime - startTime));

        System.out.println();
    }

    /**
     * Partitions the array for quicksort by selecting the last element as pivot.
     * Elements smaller than the pivot are moved to the left, and larger elements to the right.
     *
     * @param array The array to be partitioned
     * @param low Starting index of the partition
     * @param high Ending index of the partition
     * @return The position of the pivot after partitioning
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * Implements the quicksort algorithm to sort an array.
     * This is a divide and conquer algorithm that picks an element as pivot
     * and partitions the array around the pivot.
     *
     * @param array The array to be sorted
     * @param low Starting index of the array segment to be sorted
     * @param high Ending index of the array segment to be sorted
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition Index
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * Implements the merge sort algorithm to sort an array.
     * This is a divide and conquer algorithm that divides the array into two halves,
     * sorts them separately, and then merges them.
     *
     * @param arr The array to be sorted
     * @param left Starting index of the array segment to be sorted
     * @param right Ending index of the array segment to be sorted
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point to divide the array into two halves
            int middle = left + (right - left) / 2; // Safer way to find middle to avoid integer overflow

            // Recursively divide the array
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     *
     * @param arr The array containing the subarrays to be merged
     * @param left Starting index of the first subarray
     * @param middle Ending index of the first subarray
     * @param right Ending index of the second subarray
     */
    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Merge the temporary arrays back into arr[left..right]
        int i = 0; // Initial index of first subarray
        int j = 0; // Initial index of second subarray
        int k = left; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }


    /**
     * Generates an array of random integers.
     *
     * @param size The size of the array to generate
     * @return An array of random integers between 0 and 9999
     */
    public static int[] arrayGenerator(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 10000);
        }
        return numbers;
    }
    /**
     * Implements the bubble sort algorithm to sort an array.
     * Repeatedly steps through the list, compares adjacent elements,
     * and swaps them if they are in the wrong order.
     *
     * @param arr The array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swapping occurred in this pass, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Implements the insertion sort algorithm to sort an array.
     * Builds the sorted array one item at a time by comparing each
     * with the items before it and inserting it into its correct position.
     *
     * @param arr The array to be sorted
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than current
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    /**
     * Implements the selection sort algorithm to sort an array.
     * Repeatedly finds the minimum element from the unsorted part
     * and puts it at the beginning of the unsorted part.
     *
     * @param arr The array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
