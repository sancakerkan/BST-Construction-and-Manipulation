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


