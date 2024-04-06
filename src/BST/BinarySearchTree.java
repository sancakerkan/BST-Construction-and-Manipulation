package BST;

// Definition of a single node in a binary search tree
class Node {
    int value;
    Node leftChild, rightChild;

    // Constructor to initialize a node with a given value
    public Node(int val) {
        value = val;
        leftChild = rightChild = null;
    }
}

// Class representing a binary search tree
public class BinarySearchTree {
    Node rootNode;

    // Constructor to initialize an empty binary search tree
    public BinarySearchTree() {
        rootNode = null;
    }

    // Method to build the binary search tree from an array of integers
    public void constructTree(int[] values) {
        for (int val : values) {
            rootNode = insertNode(rootNode, val);
        }
    }

    // Method to insert a new value into the binary search tree
    public Node insertNode(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if (val <= node.value) {
            node.leftChild = insertNode(node.leftChild, val);
        } else if (val > node.value) {
            node.rightChild = insertNode(node.rightChild, val);
        }
        return node;
    }

    // Method to perform an inorder traversal of the binary search tree
    public void inorderTraversal() {
        inorderTraverse(rootNode);
        System.out.println();
    }

    // Recursive helper method for inorder traversal
    public void inorderTraverse(Node node) {
        if (node != null) {
            inorderTraverse(node.leftChild);
            System.out.print(node.value + " ");
            inorderTraverse(node.rightChild);
        }
    }

    // Method to find and print the parent of a given value in the binary search tree
    public void printParent(int val) {
        Node parent = findParent(rootNode, val, null);
        if (parent == null) {
            System.out.println(val + " is the root node or does not exist in the tree.");
        } else {
            System.out.println("The parent of " + val + " is " + parent.value);
        }
    }

    // Recursive method to find the parent of a given value in the binary search tree
    Node findParent(Node node, int val, Node parentNode) {
        if (node == null) return null;
        if (node.value == val) return parentNode;
        parentNode = findParent(node.leftChild, val, node);
        if (parentNode != null) return parentNode;
        return findParent(node.rightChild, val, node);
    }

    // Method to delete a value from the binary search tree
    Node deleteValue(Node root, int key) {
        if (root == null) return root;

        if (key < root.value) {
            root.leftChild = deleteValue(root.leftChild, key);
        } else if (key > root.value) {
            root.rightChild = deleteValue(root.rightChild, key);
        } else {
            if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }

            root.value = findMinValue(root.rightChild);

            root.rightChild = deleteValue(root.rightChild, root.value);
        }

        return root;
    }

    // Helper method to find the minimum value in a subtree
    private int findMinValue(Node root) {
        int minVal = root.value;
        while (root.leftChild != null) {
            minVal = root.leftChild.value;
            root = root.leftChild;
        }
        return minVal;
    }
}
