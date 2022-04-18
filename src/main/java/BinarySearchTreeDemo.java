import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        // Create new instance of BinarySearchTree
        BinarySearchTree bst = new BinarySearchTree();

        // Insert values into bst
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);

        // sort values and print values in order
        bst.inorder();

        System.out.println();

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bst);
            System.out.println();
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("Deleting 10...");
        bst.delete(10);

        // do a search to check if 10 exists in the binary search tree
        System.out.println();

        // print tree again
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bst);
            System.out.println();
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // do a search to check if 10 exists in the binary search tree

        System.out.println();

        System.out.println("Does the key 10 exist in the tree? : " + bst.search(10));
    }
}
