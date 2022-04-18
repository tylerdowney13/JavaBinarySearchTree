public class BinarySearchTree {
    // Initial node class
    class Node {
        int key;
        Node left, right;

        // Node Constructor
        public Node(int data) {
            key = data;
            left = null;
            right = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    // Initialize root node
    Node root;

    // Binary Search Tree constructor
    BinarySearchTree() {
        root = null;
    }

    // minValue method
    int minValue(Node root) {
        int minval = root.key;

        // Find minvalue
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }

        return minval;
    }

    // insert method
    void insert(int key) {
        root = insert_recursive(root, key);
    }

    // insert recursive method
    Node insert_recursive(Node root, int key) {
        // check if tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Traverse tree
        if (key < root.key) {
            root.left = insert_recursive(root.left, key);
        } else if (key > root.key) {
            root.right = insert_recursive(root.right, key);
        }

        // return root
        return root;
    }

    // delete method
    void delete(int key) {
        root = delete_recursive(root, key);
    }

    // delete_recursive method
    Node delete_recursive(Node root, int key) {
        // check if tree is empty
        if (root == null) {
            return root;
        }

        // traverse tree
        if (key < root.key) {
            root.left = delete_recursive(root.left, key);
        } else if (key > root.key) {
            root.right = delete_recursive(root.right, key);
        } else {
            // check if node contains only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // check if root has more than one child
            root.key = minValue(root.right);

            // delete the inorder successor
            root.right = delete_recursive(root.right, root.key);
        }

        return root;
    }

    // inorder sort method
    void inorder() {
        inorder_recursive(root);
    }

    // inorder_recursive method
    void inorder_recursive(Node root) {
        if (root != null) {
            inorder_recursive(root.left);
            System.out.print(root.key + " ");
            inorder_recursive(root.right);
        }
    }

    // search method
    boolean search(int key) {
        root = search_recursive(root, key);

        if (root != null) {
            return true;
        } else {
            return false;
        }
    }

    // search_recursive method
    Node search_recursive(Node root, int key) {
        // check if root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        } else if (root.key > key) {
            return search_recursive(root.left, key);
        }

        return search_recursive(root.right, key);
    }

    // Setters and Getters

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
