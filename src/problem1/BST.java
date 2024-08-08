package problem1;

import java.util.ArrayList;
import java.util.List;

public class BST {

    Node root;

    public BST() {
        root = null;
    }

    // Insert a new node
    void insert(String name, int grade) {
        root = insertRec(root, name, grade);
    }

    Node insertRec(Node root, String name, int grade) {
        if (root == null) {
            root = new Node(name, grade);
            return root;
        }

        if (name.compareTo(root.name) < 0)
            root.left = insertRec(root.left, name, grade);
        else if (name.compareTo(root.name) > 0)
            root.right = insertRec(root.right, name, grade);

        return root;
    }

    // Function to balance the tree
    void balance() {
        List<Node> list = new ArrayList<>();
        inorder(root, list);

        root = buildBalancedTree(list, 0, list.size() - 1);
    }

    // Inorder traversal for conversion to list
    void inorder(Node root, List<Node> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }
    }

    // Build balanced tree from list
    Node buildBalancedTree(List<Node> list, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node node = list.get(mid);

        node.left = buildBalancedTree(list, start, mid - 1);
        node.right = buildBalancedTree(list, mid + 1, end);

        return node;
    }

    class Node {
        String name;
        int grade;
        Node left, right;

        public Node(String name, int grade) {
            this.name = name;
            this.grade = grade;
            left = right = null;
        }
    }

}
