import java.util.*;

public class MinHeap{
    // Min-Heap
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    {
        // TO BE IMPLEMENTED: Heap Algorithm logic
        // Write your code here
        insert(10);
        insert(3);
        insert(15);
        System.out.println("Min-Heap Extract Min: " + extractMin());
    } // end of a static method

    public void insert(int value) {
        heap.add(value);
    }

    public int extractMin() {
        return heap.poll();
    }

    // Driver method
    public static void main(String[] args) {
        // Min-Heap Test
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(3);
        heap.insert(15);
        System.out.println("Min-Heap Extract Min: " + heap.extractMin());
    }
}
