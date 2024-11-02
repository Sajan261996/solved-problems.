import java.util.*;

public class Nodedoesnotsubline {
    class Node {
        int data;
        Node left, right;
    
        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    
    class BinaryTree {
        Node root;
    
        BinaryTree() {
            root = null;
        }
    
        void insert(int key) {
            root = insertRec(root, key);
        }
    
        // A recursive function to insert a new key in BST
        Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }
    
            if (key < root.data)
                root.left = insertRec(root.left, key);
            else if (key > root.data)
                root.right = insertRec(root.right, key);
    
            return root;
        }
    
        // Function to print nodes that don't have a sibling
        void printSingles(Node node) {
            // Base case: if the node is null, return
            if (node == null) {
                return;
            }
    
            // Check left child
            if (node.left != null && node.right == null) {
                System.out.print(node.left.data + " "); // Print left child if it has no sibling
            }
            // Check right child
            if (node.right != null && node.left == null) {
                System.out.print(node.right.data + " "); // Print right child if it has no sibling
            }
    
            // Recur for left and right children
            printSingles(node.left);
            printSingles(node.right);
        }
    }
    
    // WARNING: Do not edit code below this; failing which your solution may not pass the test case(s)
    public class Source {
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
    
            Scanner sc = new Scanner(System.in);
            int size;
            size = sc.nextInt();
    
            if (size <= 0) {
                System.out.println("Size should be a positive integer");
            } else {
                int[] elementsArr = new int[size];
                for (int i = 0; i < size; i++) {
                    elementsArr[i] = sc.nextInt();
                    tree.insert(elementsArr[i]);
                }
                tree.printSingles(tree.root);
            }
        }
    }
    
}
