# Binary Search Tree Implementation

This repository contains a Java implementation of a Binary Search Tree (BST). The code is developed as a solution for Homework 1 of CMPE 326: Concepts of Programming Languages course at TED University.

## Overview
The implementation consists of several Java classes:
- `BinarySearchTree`: Represents the binary search tree data structure.
- `Node`: Represents a single node in the binary search tree.

## `BinarySearchTree` Class
This class represents a binary search tree and includes methods to construct, manipulate, and traverse the tree.

### Constructor
- `public BinarySearchTree()`: Initializes an empty binary search tree.

### Methods
1. `constructTree(int[] values)`: Constructs the binary search tree from an array of integers.
2. `insertNode(Node node, int val)`: Inserts a new value into the binary search tree.
3. `inorderTraversal()`: Performs an inorder traversal of the binary search tree.
4. `printParent(int val)`: Finds and prints the parent of a given value in the binary search tree.
5. `findParent(Node node, int val, Node parentNode)`: Recursive method to find the parent of a given value.
6. `deleteValue(Node root, int key)`: Deletes a value from the binary search tree while maintaining its properties.
7. `findMinValue(Node root)`: Helper method to find the minimum value in a subtree.

## `Node` Class
This class represents a single node in the binary search tree.

### Constructor
- `public Node(int val)`: Initializes a node with the given value.

### Attributes
- `int value`: Stores the value of the node.
- `Node leftChild`: Reference to the left child node.
- `Node rightChild`: Reference to the right child node.

## Usage
To use the binary search tree implementation, follow these steps:
1. Create an instance of `BinarySearchTree`.
2. Call the appropriate methods to construct, manipulate, or traverse the tree.

```java

import java.util.Scanner;

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
public class hw1 {
    Node rootNode;

    // Constructor to initialize an empty binary search tree
    public hw1() {
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

    public static void main(String[] args) {
        hw1 bst = new hw1(); // Create a new instance of MyBinarySearchTree
        Scanner scanner = new Scanner(System.in); // Create a scanner object to read input
        
        // Get Input
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim(); // Read the next line of input and remove leading and trailing whitespaces
            
            if (inputLine.isEmpty()) {
                break; // Break the loop if input line is empty
            }

            // CONSTRUCT: Construct the binary search tree with provided values
            if (inputLine.startsWith("CONSTRUCT")) {
                String[] numbers = inputLine.substring(inputLine.indexOf('[') + 1, inputLine.indexOf(']')).split(",");
                int[] values = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    values[i] = Integer.parseInt(numbers[i].trim());
                }
                bst.constructTree(values);
                
                
             // INSERT: Insert a new value into the binary search tree
            } else if (inputLine.startsWith("INSERT")) {
                int value = Integer.parseInt(inputLine.split(" ")[1]);
                bst.insertNode(bst.rootNode, value);
                Node parent = bst.findParent(bst.rootNode, value, null);
                String parentMessage = (parent == null) ? "It is a root node." : "The parent of " + value + " is " + parent.value;
                System.out.println(parentMessage);
                
                
              // LIST: Perform inorder traversal and print the elements of the binary search tree
            } else if (inputLine.equals("LIST")) {
                bst.inorderTraversal();
                
                
              // PARENT: Find and print the parent of a given value in the binary search tree
            } else if (inputLine.startsWith("PARENT")) {
                int value = Integer.parseInt(inputLine.split(" ")[1]);
                Node parent = bst.findParent(bst.rootNode, value, null);
                String parentMessage = (parent == null) ? "It is a root node" : "The parent of " + value + " is " + parent.value;
                System.out.println(parentMessage);
                
                
              // DELETE: Delete a value from the binary search tree
            } else if (inputLine.startsWith("DELETE")) {
                int value = Integer.parseInt(inputLine.split(" ")[1]);
                Node oldRoot = bst.rootNode;
                bst.rootNode = bst.deleteValue(bst.rootNode, value);
                if (oldRoot != bst.rootNode) {
                    System.out.println("Root changed. The new root is " + (bst.rootNode != null ? bst.rootNode.value : "null"));
                }
            }
        }

        scanner.close(); // Close the scanner
    }
}
```
