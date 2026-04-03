import java.util.*;

public class Main {
    // Simple Splay Tree (basic version)
    static class SplayTree {
        private Set<Integer> data = new HashSet<>();
        
        public void insert(int value) {
            data.add(value);
        }
        
        public boolean search(int value) {
            return data.contains(value);
        }
    }
    
    public static void main(String[] args) {
        // HEAP (Min Heap)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        heap.add(10);
        heap.add(3);
        heap.add(15);
        
        System.out.println("Min-Heap Extract Min: " + heap.poll());
        
        // SPLAY TREE
        SplayTree tree = new SplayTree();
        
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        
        System.out.println("Splay Tree Search (10 found): " + tree.search(10));
    }
}
