import java.util.*;

public class minheap {

    // Cost Matrix (Adjacency Matrix)
    static int[][] costMatrix = {
        {0,  15, 25, 35},
        {15, 0,  30, 28},
        {25, 30, 0,  20},
        {35, 28, 20, 0}
    };

    // Location names
    static String[] locations = {"UPTM", "City B", "City C", "City D"};
    
    // Min-Heap
    static class MinHeap {
        private PriorityQueue<Integer> heap;
        public MinHeap() { heap = new PriorityQueue<>(); }
        public void insert(int val) { heap.add(val); }
        public int extractMin() { return heap.poll(); }
    }
    
    
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(3);
        heap.insert(15);
        System.out.println("Min-Heap Extract Min: " + heap.extractMin());
        
    }
}
