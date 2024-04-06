package BST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        
        //Get Input
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();
            if (inputLine.isEmpty()) {
                break;
            }

            //CONSTRUCT
            if (inputLine.startsWith("CONSTRUCT")) {
                String[] numbers = inputLine.substring(inputLine.indexOf('[') + 1, inputLine.indexOf(']')).split(",");
                int[] values = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    values[i] = Integer.parseInt(numbers[i].trim());
                }
                bst.construct(values);
                
                
             //INSERT   
            } else if (inputLine.startsWith("INSERT")) {
                int value = Integer.parseInt(inputLine.split(" ")[1]);
                bst.insertRecursive(bst.root, value);
                TreeNode parent = bst.findParent(bst.root, value, null);
                String parentMessage = (parent == null) ? "It is a root node." : "The parent of " + value + " is " + parent.value;
                System.out.println(parentMessage);
                
                
              //LIST  
            } else if (inputLine.equals("LIST")) {
                bst.inorderTraversal();
                
                
              //PARENT  
            } else if (inputLine.startsWith("PARENT")) {
                int value = Integer.parseInt(inputLine.split(" ")[1]);
                TreeNode parent = bst.findParent(bst.root, value, null);
                String parentMessage = (parent == null) ? "It is a root node" : "The parent of " + value + " is " + parent.value;
                System.out.println(parentMessage);
                
                
              //DELETE
            } else if (inputLine.startsWith("DELETE")) {
                int value = Integer.parseInt(inputLine.split(" ")[1]);
                TreeNode oldRoot = bst.root;
                bst.root = bst.deleteRecursive(bst.root, value);
                if (oldRoot != bst.root) {
                    System.out.println("Root changed. The new root is " + (bst.root != null ? bst.root.value : "null"));
                }
            }
        }

        scanner.close();
    }
}