import java.util.*;

public class SortingNSearching {

    // Cost Matrix (Adjacency Matrix)
    static int[][] costMatrix = {
        {0,  15, 25, 35},
        {15, 0,  30, 28},
        {25, 30, 0,  20},
        {35, 28, 20, 0}
    };

    // Location names
    static String[] locations = {"UPTM", "City B", "City C", "City D"};

// Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // Sorting and Searching
        int[] arr = {8, 3, 5, 1, 9, 2};
        insertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Binary Search (5 found at index): " + binarySearch(arr, 5));
        
    }
}
