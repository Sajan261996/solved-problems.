import java.util.Scanner;
import java.util.Arrays;

public class bst {
    int value;
    Node leftchild, rightchild;

    Node(int item) {
        value = item;
        leftchild = rightchild = null;
    }
}

class BinaryTree {
    Node root;
    static int preIndex = 0;
    static int index = 0;

    Node constructTree(int in[], int pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd) 
            return null;

        Node tNode = new Node(pre[preIndex++]);

        if (inStrt == inEnd)
            return tNode;

        int inIndex = search(in, inStrt, inEnd, tNode.value);

        tNode.leftchild = constructTree(in, pre, inStrt, inIndex - 1);
        tNode.rightchild = constructTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    int search(int arr[], int strt, int end, int value) {
        for (int i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1; // should not reach here if input is correct
    }

    // Create a sum binary tree
    int sumBinaryTree(Node node) {
        if (node == null)
            return 0;

        // Store the original value
        int originalValue = node.value;

        // Recursively get the sum of left and right children
        int leftSum = sumBinaryTree(node.leftchild);
        int rightSum = sumBinaryTree(node.rightchild);

        // Update the current node's value to the sum of its own value and the sums of its children
        node.value = originalValue + leftSum + rightSum;

        // Return the new value of this node to be used by its parent
        return node.value;
    }

    void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.leftchild);
        printPostorder(node.rightchild);
        System.out.print(node.value + " ");
    }

    void inOrder(Node node, int array[]) {
        if (node == null)
            return;
        inOrder(node.leftchild, array);
        array[index++] = node.value;
        inOrder(node.rightchild, array);
    }

    Node ArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2; // Find the middle element

        Node node = new Node(arr[mid]); // Create a new node with the middle element

        // Recursively construct the left and right subtrees
        node.leftchild = ArrayToBST(arr, start, mid - 1);
        node.rightchild = ArrayToBST(arr, mid + 1, end);

        return node;
    }
}

class Source {
    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int in[] = new int[len];
        int pre[] = new int[len];
        
        for (int i = 0; i < len; i++) {
            in[i] = scanner.nextInt();
        }
        for (int i = 0; i < len; i++) {
            pre[i] = scanner.nextInt();
        }

        BinaryTree tree = new BinaryTree();
        Node root = tree.constructTree(in, pre, 0, len - 1);
        
        // Transform the original tree into a sum binary tree
        tree.sumBinaryTree(root);
        
        int inSumTree[] = new int[len];
        tree.index = 0; // Reset index for inorder collection
        tree.inOrder(root, inSumTree);
        
        Arrays.sort(inSumTree); // Sort the inorder sum array
        
        // Create a balanced BST from the sorted array
        Node bstRoot = tree.ArrayToBST(inSumTree, 0, len - 1);
        
        // Print the postorder traversal of the new BST
        tree.printPostorder(bstRoot);
    }

    
}
