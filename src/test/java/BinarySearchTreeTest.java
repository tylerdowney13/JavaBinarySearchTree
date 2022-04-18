import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    // Initialize instance of BinarySearchTree
    BinarySearchTree bst = new BinarySearchTree();

    // Insert values into binary search tree
    @BeforeEach
    void setup() {
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
    }

    @Test
    void testRootNodeExists() {
        Assertions.assertEquals(true, bst.search(10));
    }

    @Test
    void testRootNodeDoesNotExist() {
        Assertions.assertEquals(false, bst.search(100));
    }

    @Test
    void testRootNodeRight() {
        Assertions.assertEquals(90, bst.root.getRight().key);
    }

    @Test
    void testRootNodeLeft() {
        Assertions.assertEquals(10, bst.root.getLeft().key);
    }
}
