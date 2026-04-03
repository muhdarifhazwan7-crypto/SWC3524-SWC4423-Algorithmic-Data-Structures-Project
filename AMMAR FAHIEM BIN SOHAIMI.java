import java.util.*;


public class IndividualTask {
    // Min-Heap Implementation
    static class MinHeap {
        private PriorityQueue<Integer> heap = new PriorityQueue<>();
        public void insert(int val) { heap.add(val); }
        public int extractMin() { return heap.poll(); }
    }


    // Splay Tree Implementation
    static class SplayTree {
        class Node {
            int key;
            Node left, right;
            Node(int key) { this.key = key; }
        }
        private Node root;


        private Node rightRotate(Node x) {
            Node y = x.left; x.left = y.right; y.right = x; return y;
        }


        private Node leftRotate(Node x) {
            Node y = x.right; x.right = y.left; y.left = x; return y;
        }


        private Node splay(Node root, int key) {
            if (root == null || root.key == key) return root;
            if (key < root.key) {
                if (root.left == null) return root;
                if (key < root.left.key) {
                    root.left.left = splay(root.left.left, key);
                    root = rightRotate(root);
                } else if (key > root.left.key) {
                    root.left.right = splay(root.left.right, key);
                    if (root.left.right != null) root.left = leftRotate(root.left);
                }
                return (root.left == null) ? root : rightRotate(root);
            } else {
                if (root.right == null) return root;
                if (key > root.right.key) {
                    root.right.right = splay(root.right.right, key);
                    root = leftRotate(root);
                } else if (key < root.right.key) {
                    root.right.left = splay(root.right.left, key);
                    if (root.right.left != null) root.right = rightRotate(root.right);
                }
                return (root.right == null) ? root : leftRotate(root);
            }
        }


        public void insert(int key) {
            if (root == null) { root = new Node(key); return; }
            root = splay(root, key);
            if (root.key == key) return;
            Node n = new Node(key);
            if (key < root.key) { n.right = root; n.left = root.left; root.left = null; }
            else { n.left = root; n.right = root.right; root.right = null; }
            root = n;
        }


        public boolean search(int key) {
            root = splay(root, key);
            return root != null && root.key == key;
        }
    }


    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(10); heap.insert(3); heap.insert(15);
        System.out.println("Min-Heap Extract Min: " + heap.extractMin());


        SplayTree tree = new SplayTree();
        tree.insert(20); tree.insert(10); tree.insert(30);
        System.out.println("Splay Tree Search (10 found): " + tree.search(10));
    }
}
