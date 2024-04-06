package defaultpackage;

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Method to construct the BST 
    public void construct(int[] values) {
        for (int value : values) {
            root = insertRecursive(root, value);
        }
    }

    // Method to insert a new value into the BST
    public TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value <= node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;

    }

    // Method to perform inorder traversal
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    public void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.value + " ");
            inorderRecursive(node.right);
        }
    }

    // Method to find and print the parent of a given value
    public void printParent(int value) {
        TreeNode parent = findParent(root, value, null);
        if (parent == null) {
            System.out.println(value + " is the root node or does not exist in the tree.");
        } else {
            System.out.println("The parent of " + value + " is " + parent.value);
        }
    }

    TreeNode findParent(TreeNode node, int value, TreeNode parent) {
        if (node == null) return null;
        if (node.value == value) return parent;
        parent = findParent(node.left, value, node);
        if (parent != null) return parent;
        return findParent(node.right, value, node);
    }

    // Method to delete a value 
    TreeNode deleteRecursive(TreeNode root, int key) {
        if (root == null) return root;

        
        if (key < root.value) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.value) {
            root.right = deleteRecursive(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);

            root.right = deleteRecursive(root.right, root.value);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }
    
}