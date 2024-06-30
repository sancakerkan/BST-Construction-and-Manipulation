# BST-Construction-and-Manipulation
This project is a Binary Search Tree (BST) implementation in Java. The BST supports various operations such as construction, insertion, listing (inorder traversal), finding parent nodes, and deletion.
## Features
- **CONSTRUCT [values]**: Constructs a BST from a given list of integers.
- **INSERT value**: Inserts a new integer into the BST in the correct position.
- **LIST**: Performs an inorder traversal of the BST and prints the keys in ascending order.
- **PARENT value**: Finds and prints the parent of a given value in the BST.
- **DELETE value**: Deletes a specified value from the BST while maintaining the BST properties.
## Implementation
The implementation is done in Java without using any library functions for BST-related operations. The program uses dynamic data structures and recursion for various operations on the tree.
## Input/Output Specifications
The program accepts input commands from the standard input.
Commands include:
CONSTRUCT [value1, value2, value3, ..., valueN]
INSERT value
LIST
PARENT value
DELETE value
Outputs are printed to the standard output.
## How to Run
Compile the code using a Java compiler (e.g., javac).
Run the executable or the Java class file.
Enter commands as specified in the input/output specifications.
## Example Output
```java
CONSTRUCT [31, 65, 3, 10, 5, 100, 3, 12]
INSERT 55
The parent of 55 is 65
LIST
3 3 5 10 12 31 55 65 100
PARENT 12
The parent of 12 is 10
PARENT 31
It is a root node
INSERT 1
The parent of 1 is 3
LIST
1 3 3 5 10 12 31 55 65 100
INSERT 500
The parent of 500 is 100
LIST
1 3 3 5 10 12 31 55 65 100 500
PARENT 5
The parent of 5 is 10
DELETE 5
LIST
3 3 10 12 31 65 100
DELETE 65
LIST
3 3 10 12 31 100
PARENT 100
The parent of 100 is 31
DELETE 31
Root changed. The new root is 100
DELETE 100
Root changed. The new root is 3
LIST
3 3 10 12
```
## Contribution
Contributions are welcome! Feel free to fork the repository and submit pull requests.
## License
This project is licensed under the MIT License. See the LICENSE file for more details.
