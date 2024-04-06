package BST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(); // Create a new instance of MyBinarySearchTree
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
